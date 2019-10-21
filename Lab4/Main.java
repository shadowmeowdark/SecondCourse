import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите строку: ");
        Scanner scn = new Scanner(System.in);
        String text = scn.next();
        first_A(text); //1a
        first_B(text); //1б
        first_B1(text); //1в
        first_G(text); //1г
        first_D(text); //1д
        first_E(text); //1е
        first_J(text); //1ж
        first_Z(text); //1з
        first_I(); //1и
        third(text); //3
        foutrh(text); //4
        //5 задание аналогично к 1е
        sixth(text); //6
        seventh(text); //7
        eighth(text); //8
        nineth((text)); //9
        tenth(text); //10
        //11 задание нет условий
        twelfth(text); //12
        thirteenth(text); //13
    }

    public static void first_A(String str) {
        boolean answer = Pattern.matches("abcd1{7}02019", str);
        System.out.println("1a) Совпадает ли данная строка с \"abcd111111102019\"? " + answer);
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public static void first_B(String str) {
        Pattern pattern = Pattern.compile("\\d*\\d"); // \\d   –  цифровой символ
        Matcher matcher = pattern.matcher(str);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (matcher.find()) {
            arrayList.add(Integer.parseInt(str.substring(matcher.start(), matcher.end())));
        }
        System.out.print("1b) ");
        if (arrayList.isEmpty()) System.out.println("В строке нет десятеричных чисел");
        else {
            int max = 0;
            int sum = 0;
            int poryadok = 0;
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i) >= max) {
                    max = arrayList.get(i);
                    poryadok = i;
                }
                sum += arrayList.get(i);
            }
            System.out.println(arrayList);
            System.out.println("Сумма чисел: " + sum + ", максимальное число: " + max + ", его порядковый номер: " + (poryadok + 1));
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public static void first_B1(String str) {
        Pattern pattern = Pattern.compile("(([0-9]*[.,])?[0-9])+");
        Matcher matcher = pattern.matcher(str);
        ArrayList<String> arrayList = new ArrayList<>();
        while (matcher.find()) {
            arrayList.add(str.substring(matcher.start(), matcher.end()));
        }
        System.out.println("1в: " + arrayList);
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public static void first_G(String str) {
        Pattern pattern = Pattern.compile("\\w{10,}");// \\w буквенный или цифровой символ или знак подчёркивания
        // {m,}  - Не менее m
        Matcher matcher = pattern.matcher(str);
        String strForReplaceAll = str;
        String strForReplaceFirst = str;
        while (matcher.find()) {
            int k = matcher.start();
            strForReplaceAll = matcher.replaceAll("*"); //Заменить все такие слова на одну *.
            strForReplaceFirst = matcher.replaceAll(Character.toString(str.charAt(k))); //Заменить каждое такое слово на одну его же первую букву
        }
        System.out.println("1г: " + strForReplaceAll);
        System.out.println(strForReplaceFirst);
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public static void first_D(String str) {
        System.out.print("1д: ");
        boolean answer = Pattern.matches("[0-9A-Fa-f]{8}-([0-9A-Fa-f]{4}-){3}[0-9A-Fa-f]{12}", str);
        System.out.println("Является ли данная строка GUID. Где GUID это строчка, состоящая из 8, 4, 4, 4, 12\n" +
                "шестнадцатеричных цифр разделенных тире: " + answer);
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public static void first_E(String str) {
        System.out.print("1е: ");
        boolean answer = Pattern.matches("#[0-9A-Fa-f]{6}", str);
        System.out.println("Является ли данная строчка шестнадцатиричным идентификатором цвета в HTML " + answer);
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public static void first_J(String str) {
        Pattern pattern = Pattern.compile("[0-9A-Za-z]+");
        Matcher matcher = pattern.matcher(str);
        ArrayList<String> arrayList = new ArrayList<>();
        while (matcher.find()) {
            arrayList.add(str.substring(matcher.start(), matcher.end()));
        }
        arrayList.remove(arrayList.size() - 1);
        System.out.print("1ж) Вывод имён всех катологов в папке по указанному пути: ");
        System.out.println(arrayList);
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public static void first_Z(String str) {
        Pattern pattern = Pattern.compile("ик");
        Matcher matcher = pattern.matcher(str);
        System.out.print("1з) Удаление суффикса -ик, " + str + "->");
        str = matcher.replaceAll("");
        System.out.println(str);
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public static void first_I(){
        String str = "104.5 USD , 103.8 EU , 45.23 RUR , 413.3 RD , 18.85 RUR , 13.44 EU , 64.48 USD";
        Pattern pattern1 = Pattern.compile("(([0-9]*[.])?[0-9])+\\s(USD)");
        Pattern pattern2 = Pattern.compile("([0-9]*[.])?[0-9]+\\s(RUR)");
        Pattern pattern3 = Pattern.compile("([0-9]*[.])?[0-9]+\\s(EU)");
        Matcher matcher = pattern1.matcher(str);
        ArrayList<String> usd = new ArrayList<>();
        ArrayList<String> rur = new ArrayList<>();
        ArrayList<String> eu = new ArrayList<>();
        while (matcher.find()) {
            usd.add(str.substring(matcher.start(), matcher.end()-4));
        }
        matcher = pattern2.matcher(str);
        while (matcher.find()) {
            rur.add(str.substring(matcher.start(), matcher.end()-4));
        }
        matcher = pattern3.matcher(str);
        while (matcher.find()) {
            eu.add(str.substring(matcher.start(), matcher.end()-3));
        }
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите название валюты: " );
        String name = scn.next();
        System.out.println("Введите курс данной валюты:");
        double usdm , rurm , eum;
        System.out.print("1 USD = ");
        usdm = Double.parseDouble(scn.next());
        System.out.print("1 RUR = ");
        rurm = Double.parseDouble(scn.next());
        System.out.print("1 EU = ");
        eum = Double.parseDouble(scn.next());
        String answer = "";
        for (int i = 0; i < usd.size(); i++) {
            answer += usd.get(i) + " USD = " + Double.parseDouble(usd.get(i))*usdm + " " + name + ", ";
        }
        answer += "\n";
        for (int i = 0; i < rur.size(); i++) {
            answer += rur.get(i) + " RUR = " + Double.parseDouble(rur.get(i))*rurm + " " + name + ", ";
        }
        answer += "\n";
        for (int i = 0; i < eu.size(); i++) {
            answer += eu.get(i) + " EU = " + Double.parseDouble(eu.get(i))*eum + " " + name + ", ";
        }
        System.out.println(answer);
    }

    public static void third(String str) {
        //шести наборов буквенно-цифровых значений, разделённых двоеточием
        boolean answer = Pattern.matches("([0-9A-Fa-f]{2}[:\\-\\.]){5}[0-9A-Fa-f]{2}", str);
        System.out.println("3) Является ли заданная строка правильным MAC-адресом? " + answer);
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public static void foutrh(String str) {
        boolean answer = Pattern.matches("(https?://)?([a-zA-Z0-9])(([a-zA-Z0-9-])+\\.)+([a-z]{2,6})(:\\d+)?((/[a-zA-Z0-9]+)?)+/?(#[a-zA-Z0-9]+)?", str);
        System.out.println("4) Является ли заданная строчка валидным URL адресом? " + answer);
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public static void sixth(String str) {
        boolean answer = Pattern.matches("([0-2][0-9]|3[0-1])/(0[0-9]|1[0-2])/(1[6-9][0-9]{2}|[2-9][0-9]{3})", str);
        //БЕЗ 29 ФЕВРАЛЯ
        System.out.println("6) Является ли данная строчка датой в формате dd/mm/yyyy. Начиная с 1600 года до 9999 года? " + answer);
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public static void seventh(String str) {
        boolean answer = Pattern.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}", str);
        System.out.println("7) Является ли данная строчка валидным Email адресом согласно RFC под номером 2822? " + answer);
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public static void eighth(String str) {
        boolean answer = Pattern.matches("^(?:1?[0-9]{1,2}|2[0-4][0-9]|25[0-5])(?:\\.(?:1?[0-9]{1,2}|2[0-4][0-9]|25[0-5])){3}(?::(?:[0-9]{1,4}|[1-5][0-9]{4}|6[0-4][0-9]{3}|65[0-4][0-9]{2}|655[0-2][0-9]|6553[0-5]))?$", str);
        System.out.println("8) Является ли заданная строка IP-адресом? " + answer);
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public static void nineth(String str) {
        boolean answer = Pattern.matches("(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z]).{8,}", str);
        System.out.println("9) Является ли пароль надежным? " + answer);
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public static void tenth(String str) {
        boolean answer = Pattern.matches("[1-9]\\d{5}", str);
        System.out.println("10) Является ли заданная строка шестизначным числом, записанным в десятичной " +
                "системе счисления без нулей в старших разрядах? " + answer);
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public static void twelfth(String str) {
        //не совсем понятна формулировка задания, поэтому я сделал проверку есть ли цифры за которыми стоит +
        Pattern pattern = Pattern.compile("\\d(\\+)");
        Matcher matcher = pattern.matcher(str);
        ArrayList<String> arrayList = new ArrayList<>();
        while (matcher.find()) {
            arrayList.add(matcher.group());
        }
        System.out.println("12) Есть ли в тексте цифры, за которыми стоит +? " + !arrayList.isEmpty());
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public static void thirteenth(String str) {
        Pattern pattern = Pattern.compile("\\(");
        Pattern pattern1 = Pattern.compile("\\)");
        Matcher matcher = pattern.matcher(str);
        ArrayList<String> arrayList = new ArrayList<>();
        while (matcher.find()) {
            arrayList.add(matcher.group());
        }
        ArrayList<String>arrayList1 = new ArrayList<>();
        matcher = pattern1.matcher(str);
        while(matcher.find()){
            arrayList1.add(matcher.group());
        }
        boolean answer = arrayList.size() == arrayList1.size();
        System.out.println("13) Правильно ли написано выражение со скобками? " + answer);
        System.out.println("--------------------------------------------------------------------------------------");
    }

}
