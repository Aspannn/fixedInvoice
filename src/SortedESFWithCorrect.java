import pojo.cdata.Consignee;
import pojo.cdata.Invoice;
import pojo.cdata.Product;
import pojo.root.InvoiceInfo;
import pojo.root.InvoiceInfoContainer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SortedESFWithCorrect {

    public void sortSapESF(String folderName) {
        File[] files = new File(folderName).listFiles();
        for (File xmlFile : files) {
            Invoice invoice = ReadAndWriteXml.convertXmlToObj("sap\\" + xmlFile.getName());
            String newName = String.valueOf(invoice.getNum());
            renameCorrect(xmlFile, newName, "sapSorted\\");
        }
    }

    public void differenceBetweenSapAndPortal(String portalFolderName) {
        FileWriter writer = fileWriter();

        File[] folders = new File(portalFolderName).listFiles();
        for (File folder : folders) {
            File[] xmlFile = folder.listFiles();
            for (File file : xmlFile) {
                InvoiceInfoContainer invoiceInfoContainer = ReadAndWriteXml.getCdata("portal\\tes\\" + file.getName());
                List<InvoiceInfo> invoiceInfo = invoiceInfoContainer.getInvoiceSet().getInvoiceInfo();
                for (InvoiceInfo info : invoiceInfo) {
                    Invoice portalInvoice = ReadAndWriteXml.convertStringToObj(info.getInvoiceBody());
                    String regNum = info.getRegistrationNumber();
                    String sapXmlFileName = portalInvoice.getNum() + ".xml";

                    File[] sapSortedFiles = new File("sapSorted").listFiles();
                    List<String> sapSortedFileName = new ArrayList<>();
                    for (File file1 : sapSortedFiles) {
                        sapSortedFileName.add(file1.getName());
                    }

                    if (sapSortedFileName.contains(sapXmlFileName)) {

                        Invoice sapInvoice = ReadAndWriteXml.convertXmlToObj("sapSorted\\" + sapXmlFileName);

                        if (!sapInvoice.equals(portalInvoice)) {
                            List<Product> sapProducts = sapInvoice.getProductSet().getProducts().getProduct();
                            List<Product> portalProducts = portalInvoice.getProductSet().getProducts().getProduct();

                            long num = sapInvoice.getNum();
                            String date = sapInvoice.getDate();
                            String deliveryDocNum = sapInvoice.getDeliveryDocNum();

                            sapProducts.removeAll(portalProducts);
//
                            for (Product sapProduct : sapProducts) {
                                String catalogTruId = sapProduct.getCatalogTruId();
                                String description = sapProduct.getDescription();
                                String priceWithTax = sapProduct.getPriceWithTax();
                                String priceWithoutTax = sapProduct.getPriceWithoutTax();
                                String productDeclaration = sapProduct.getProductDeclaration();
                                String productNumberInDeclaration = sapProduct.getProductNumberInDeclaration();
                                String quantity = sapProduct.getQuantity();
                                String tnvedName = sapProduct.getTnvedName();
                                String truOriginCode = sapProduct.getTruOriginCode();
                                String turnoverSize = sapProduct.getTurnoverSize();
                                String unitCode = sapProduct.getUnitCode();
                                String unitNomenclature = sapProduct.getUnitNomenclature();
                                String unitPrice = sapProduct.getUnitPrice();

                                System.out.println(description + "\t" + quantity);
                                try {

                                    writer.write(num + "\t" + regNum + "\t" + "'" + deliveryDocNum + "\t" + date + "\t" + catalogTruId + "\t" + description + "\t" + priceWithTax + "\t"
                                            + priceWithoutTax + "\t" + productDeclaration + "\t" + productNumberInDeclaration + "\t" + quantity + "\t" + tnvedName + "\t" +
                                            truOriginCode + "\t" + turnoverSize + "\t" + unitCode + "\t" + unitNomenclature + "\t" + unitPrice);
                                    writer.append("\n");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }

            }
        }

        try {
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private List<String> getFileNames(String folder) {
        List<String> filenames = new ArrayList<>();
        File[] xmlFiles = new File(folder).listFiles();
        for (File xmlFile : xmlFiles) {
            filenames.add(xmlFile.getName());
        }
        return filenames;
    }

    private void renameCorrect(File file, String newName, String path) {
        file.renameTo(new File(path + newName + ".xml"));
    }

    private FileWriter fileWriter() {
        FileWriter writer = null;
        try {
            writer = new FileWriter("Olzhas.csv", false);
        } catch (IOException ex) {
        }
        return writer;
    }


    public void getCon(String portalFolderName) {
        FileWriter writer = fileWriter();

        File[] folders = new File(portalFolderName).listFiles();
        for (File folder : folders) {
            File[] xmlFile = folder.listFiles();
            for (File file : xmlFile) {
                InvoiceInfoContainer invoiceInfoContainer = ReadAndWriteXml.getCdata(portalFolderName + "\\" + folder.getName() + "\\" + file.getName());
                List<InvoiceInfo> invoiceInfo = invoiceInfoContainer.getInvoiceSet().getInvoiceInfo();
                for (InvoiceInfo info : invoiceInfo) {
                    Invoice portalInvoice = ReadAndWriteXml.convertStringToObj(info.getInvoiceBody());
                    Consignee consignee = portalInvoice.getConsignee();
                    if (consignee != null) {
                        try {
                            writer.write(consignee.getAddress() + "\t" + consignee.getCountryCode() + "\t" + consignee.getName() + "\t" + consignee.getTin());
                            writer.append("\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }

        }
        try {
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

