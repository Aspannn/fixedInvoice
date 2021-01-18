import pojo.ErrorP;
import pojo.cdata.Invoice;
import pojo.cdata.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FixedInvoice {

    public void fixError() {
        Connection connectToProk = connect("jdbc:sqlite:sqlLight\\prok.sqlite");
        Connection connectToMeasure = connect("jdbc:sqlite:sqlLight\\MeasureUnitReport.sqlite");

        Connection connectToErrorP = connect("jdbc:sqlite:sqlLight\\ErrorP.sqlite");
        String sql = "SELECT DISTINCT num FROM errorpp";
        List<String> numList = new ArrayList<>();

        try {
            Statement statement = connectToErrorP.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String num = resultSet.getString("num");
                numList.add(num);
            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }

        for (String s : numList) {
            String getErrPName = "SELECT Column5,Column4, mat, par FROM errorpp WHERE num =" + s;
            List<ErrorP> errorPList = new ArrayList<>();
            try {
                Statement statement = connectToErrorP.createStatement();
                ResultSet resultSet = statement.executeQuery(getErrPName);

                while (resultSet.next()) {
                    String description = resultSet.getString("Column5");
                    String catalogTruId = resultSet.getString("Column4");
                    String mat = resultSet.getString("mat");
                    String par = resultSet.getString("par");

                    errorPList.add(new ErrorP(description, catalogTruId, mat, par));
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            Invoice invoice = ReadAndWriteXml.convertXmlToObj("sapSorted\\" + s + ".xml");
            for (Product product : invoice.getProductSet().getProducts().getProduct()) {
                String xmlDescription = product.getDescription().toLowerCase(Locale.ROOT).trim();
                String xmlCatalogTruId = product.getCatalogTruId().toLowerCase(Locale.ROOT).trim();
                for (ErrorP errorP : errorPList) {
                    if (xmlDescription.equals(errorP.getDescription().toLowerCase(Locale.ROOT).trim()) && xmlCatalogTruId.equals(errorP.getCatalogTruId().toLowerCase(Locale.ROOT).trim())) {
                        updateProduct(connectToProk, connectToMeasure, product, errorP.getMat(), errorP.getPar());
                    }
                }
            }

            ReadAndWriteXml.writeXMlToFile(invoice, "Fixed\\", invoice.getNum() + ".xml");

        }


        try {
            connectToErrorP.close();
            connectToMeasure.close();
            connectToProk.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private Connection connect(String url) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    private void updateProduct(Connection prok, Connection measure, Product product, String mat, String par) {
        String measureNum = "SELECT unitname FROM MeasureUnitReport_MeasureUnitReport WHERE code = " + Integer.parseInt(product.getUnitNomenclature());
        String unitName = null;
        try {
            Statement oldMeasure = measure.createStatement();
            ResultSet measureResult = oldMeasure.executeQuery(measureNum);

            if (measureResult.next()) {
                unitName = measureResult.getString(1);
            }
            int quantity = Integer.parseInt(product.getQuantity());


            String prokSelection = "SELECT * FROM prok WHERE mat = '" + mat + "' AND par = '" + par + "' AND quantity > " + quantity + " AND measure = '" + unitName + "'";

            Statement curProk = prok.createStatement();
            ResultSet prokResult = curProk.executeQuery(prokSelection);

            Statement updateProkS = prok.createStatement();

            if (prokResult.next()) {
                System.out.println(mat + "\t" + par + "\t" + unitName);

                String codgsvs = prokResult.getString("codgsvs");
                String id = prokResult.getString("id");
                String virtualId = prokResult.getString("virtualId");
                String fno = prokResult.getString("fno");

                String truOriginCode = "5";
                if (fno != null && !fno.isEmpty()) {
                    char[] fnoChars = fno.toCharArray();
                    if (fnoChars.length > 12 && (fnoChars[12] == 'N' || fnoChars[13] == '1' || fnoChars[13] == '0')) {
                        truOriginCode = "1";
                    } else if (fnoChars[0] == 'K') {
                        truOriginCode = "3";
                    }
                }


                String newCatalogID = mat;
                if (codgsvs != null && !codgsvs.isEmpty()) {
                    newCatalogID = codgsvs + "<" + id + ">" + "(" + virtualId + ")";
                }

                System.out.println(newCatalogID);
                System.out.println(truOriginCode);

                if (updateProkDb(updateProkS, id, virtualId, quantity) > 0) {
//                    int
                }

                product.setCatalogTruId(newCatalogID);
                product.setTruOriginCode(truOriginCode);



            } else {
                System.out.println("404   " + mat + "\t" + par + "\t" + product.getDescription() + "\t" + product.getQuantity());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private int updateProkDb(Statement prokStatement, String ID, String virtualID, Integer pQuantity) {
        String updateProkQuantity = "UPDATE prok SET quantity = quantity - " + pQuantity + " WHERE id = " + ID + " AND virtualId =  " + virtualID;
        int i = 0;
        try {
            i = prokStatement.executeUpdate(updateProkQuantity);
            System.out.println("updated = " + i);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    public void updateErrorP() throws SQLException {
        Connection connectTomb51 = connect("jdbc:sqlite:sqlLight\\mb51.db");

        int temp = 0;
        Connection connectToErrorP = connect("jdbc:sqlite:sqlLight\\ErrorP.sqlite");
        String getAllError = "SELECT * FROM errorpp ";
        Statement errorPS = connectToErrorP.createStatement();
        Statement updateS = connectToErrorP.createStatement();

        ResultSet errorPR = errorPS.executeQuery(getAllError);
        while (errorPR.next()) {
            String lingWithout = errorPR.getString("link");
            String link = "00" + lingWithout;
            String description = errorPR.getString("Column5");
            int qty = errorPR.getInt("Column10");

            String getMatAndPar = "SELECT mat_id, part FROM mb51 WHERE link = '" + link + "' AND mat_text = '" + description + "' AND qty = " + qty;
            Statement mb51S = connectTomb51.createStatement();
            ResultSet mb51RS = mb51S.executeQuery(getMatAndPar);
            if (mb51RS.next()) {
                String mat = mb51RS.getString("mat_id");
                String part = mb51RS.getString("part");

                String updateErrorP = "UPDATE errorpp SET mat = " + mat + ", par = " + part + " WHERE link = " + lingWithout + " AND Column5 = '" + description + "' AND Column10 = " + qty;
                int i = updateS.executeUpdate(updateErrorP);
                System.out.println(i);

                System.out.println(++temp + "\t" + link + "\t" + mat + "\t" + part);

            }


        }

        connectToErrorP.close();
        connectTomb51.close();

    }
}
