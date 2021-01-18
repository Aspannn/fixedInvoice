import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import pojo.cdata.Invoice;
import pojo.root.InvoiceInfoContainer;

import javax.xml.bind.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;

public class ReadAndWriteXml {

    public static Invoice convertXmlToObj(String path) {
        Invoice invoice = null;
        try {
            JAXBContext context = JAXBContext.newInstance(Invoice.class);
            Unmarshaller mar = context.createUnmarshaller();
            final SAXParserFactory sax = SAXParserFactory.newInstance();
            sax.setNamespaceAware(false);
            final XMLReader reader = sax.newSAXParser().getXMLReader();
            final Source source = new SAXSource(reader, new InputSource(new FileReader(path)));
            JAXBElement<Invoice> element = mar.unmarshal(source, Invoice.class);
            invoice = element.getValue();
        } catch (JAXBException | SAXException | ParserConfigurationException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return invoice;
    }


    public static Invoice convertStringToObj(String path) {
        Invoice invoice = null;
        try {
            JAXBContext context = JAXBContext.newInstance(Invoice.class);
            Unmarshaller mar = context.createUnmarshaller();
            final SAXParserFactory sax = SAXParserFactory.newInstance();
            sax.setNamespaceAware(false);
            final XMLReader reader = sax.newSAXParser().getXMLReader();
            final Source source = new SAXSource(reader, new InputSource(new StringReader(path)));
            JAXBElement<Invoice> element = mar.unmarshal(source, Invoice.class);
            invoice = element.getValue();
        } catch (JAXBException | SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        return invoice;
    }

    public static void writeXMlToFile(Invoice invoice, String path, String fileName) {
        try {
            JAXBContext context = JAXBContext.newInstance(Invoice.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(invoice, new File(path + fileName));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static InvoiceInfoContainer getCdata(String path) {
        InvoiceInfoContainer invoice = null;
        try {
            JAXBContext context = JAXBContext.newInstance(InvoiceInfoContainer.class);
            Unmarshaller mar = context.createUnmarshaller();
            final SAXParserFactory sax = SAXParserFactory.newInstance();
            sax.setNamespaceAware(false);
            final XMLReader reader = sax.newSAXParser().getXMLReader();
            final Source source = new SAXSource(reader, new InputSource(new FileReader(path)));
            JAXBElement<InvoiceInfoContainer> element = mar.unmarshal(source, InvoiceInfoContainer.class);
            invoice = element.getValue();
        } catch (JAXBException | SAXException | ParserConfigurationException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return invoice;
    }
}
