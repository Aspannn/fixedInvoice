import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
//        SortedESFWithCorrect sortedESFWithCorrect = new SortedESFWithCorrect();
//        sortedESFWithCorrect.sortSapESF("sap");
//
//        sortedESFWithCorrect.differenceBetweenSapAndPortal("portal");

        FixedInvoice fixedInvoice = new FixedInvoice();
//        try {
//            fixedInvoice.updateErrorP();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

        fixedInvoice.fixError();

    }
}
