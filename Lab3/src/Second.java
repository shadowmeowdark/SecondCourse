import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Second {
    public static ArrayList<Sportsman> sportsmanArrayList = new ArrayList<>();

    public static void main(String[] args) {
        readXMLAndWriteInformation();
        three_First();
        three_Second();
        three_Third();
        fourPoint();
        //без пятого пункта
    }

    public static void readXMLAndWriteInformation() {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse("Information_About_Sport");

            Node root = document.getDocumentElement();
            NodeList contacts = root.getChildNodes();

            for (int i = 0; i < contacts.getLength(); i++) {
                Node node = contacts.item(i);
                if (node.getNodeType() != Node.TEXT_NODE) {
                    Sportsman sportsman = new Sportsman();
                    if (node.hasAttributes()) {
                        sportsman.setName(node.getAttributes().getNamedItem("name").getTextContent());
                        sportsman.setSex(node.getAttributes().getNamedItem("s").getTextContent());
                        sportsman.setBirthday(node.getAttributes().getNamedItem("birthday").getTextContent());
                    }
                    NodeList nodechilds = node.getChildNodes();
                    for (int j = 0; j < nodechilds.getLength(); j++) {
                        Node competiton = nodechilds.item(j);
                        if (competiton.getNodeType() != Node.TEXT_NODE) {
                            if (competiton.hasAttributes()) {
                                sportsman.setPlace(competiton.getAttributes().getNamedItem("place").getTextContent());
                                sportsman.setYear(Integer.parseInt(competiton.getAttributes().getNamedItem("year").getTextContent()));
                            }
                            if (competiton.getNodeType() == Node.ELEMENT_NODE) {
                                Element element = (Element) competiton;
                                sportsman.setResult(Integer.parseInt(element.getElementsByTagName("result").item(0).getTextContent()));
                                sportsman.setAward(element.getElementsByTagName("award").item(0).getTextContent());
                            }
                        }
                        sportsmanArrayList.add(sportsman);
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public static void three_First() {
        System.out.println("Имена и даты рождения всех мужчин"); //пункт 3а
        for (Sportsman sportsman1 : sportsmanArrayList) {
            if (sportsman1.getSex().equals("м")) {
                System.out.println("name: " + sportsman1.getName() + ", birthday: " + sportsman1.getBirthday());
            }
        }
    }

    public static void three_Second() {
        System.out.println("\n" + "Имена, даты рождения и количество медалей у женщин старше 1985 г.р.");
        for (Sportsman sportsman2 : sportsmanArrayList) { //пункт 3б
            if (sportsman2.getSex().equals("ж") && (Integer.parseInt(sportsman2.getBirthday().substring(0, 4)) > 1985)) {
                System.out.println("name: " + sportsman2.getName() + ", birthday: " + sportsman2.getBirthday() + ", медали: " + sportsman2.getAward());
            }
        }
    }

    public static void three_Third() {
        System.out.println("\n" + "Имена и результаты спортсменов, участвовавших в 2002 в соревнованиях в Москве");
        for (Sportsman sportsman3 : sportsmanArrayList) { //пункт 3в
            if (sportsman3.getPlace().equals("москва") && sportsman3.getYear() == 2002) {
                System.out.println("name: " + sportsman3.getName() + ", result: " + sportsman3.getResult());
            }
        }
    }

    public static void fourPoint() {
        Scanner scanner = new Scanner(System.in);
        Sportsman newSportsman = new Sportsman();
        System.out.println("Введите информацию о спортсмене");
        System.out.print("Имя: ");
        newSportsman.setName(scanner.next());
        System.out.print("День рождения: ");
        newSportsman.setBirthday(scanner.next());
        System.out.print("Пол (м/ж): ");
        newSportsman.setSex(scanner.next());
        System.out.println("Введите количество соревнований спортсмена: ");
        int counter = scanner.nextInt();
        for (int i = 0; i < counter; i++) {
            System.out.println("Введите информацию о соревнованиях " + (i + 1));
            System.out.print("Место соревнований: ");
            newSportsman.setPlace(scanner.next());
            System.out.print("Год: ");
            newSportsman.setYear(scanner.nextInt());
            System.out.print("Медаль: ");
            String award = scanner.next();
            if (award.equals("золото")) newSportsman.setResult(200);
            else if (award.equals("серебро")) newSportsman.setResult(180);
            else if (award.equals("бронза")) newSportsman.setResult(160);
        }
        sportsmanArrayList.add(newSportsman);
    }
}
