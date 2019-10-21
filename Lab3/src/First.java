import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class First {
    public static void main(String[] args) {
        readXML();
    }

    public static void readXML() {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse("Literature");

            Node root = document.getDocumentElement();
            NodeList contacts = root.getChildNodes();

            for (int i = 0; i < contacts.getLength(); i++) {
                Node node = contacts.item(i);
                if (node.hasAttributes()) {
                    System.out.println("Имя автора произведения: " + node.getAttributes().getNamedItem("name").getTextContent());
                }
                NodeList nchilds = node.getChildNodes();
                for (int j = 0; j < nchilds.getLength(); j++) {
                    Node book = nchilds.item(j);
                    if (book.hasAttributes())
                        System.out.println("Название книги: " + book.getAttributes().getNamedItem("name").getTextContent());
                    if (book.getNodeType() == Node.ELEMENT_NODE) {
                        Element pages = (Element) book;
                        System.out.println("Количество страниц в книге: " + pages.getElementsByTagName("pages").item(0).getTextContent());
                    }
                }
                System.out.println("===========>>>>");
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
