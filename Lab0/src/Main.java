package com.company;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static String[] stroki = new String[13];

    public static void main(String[] args) throws IOException {
        reader();
        out_Information();
        for (int i = 0; i < stroki.length; i++) {
            out_Date(i + 1, stroki[i], check_Palindrome(stroki[i]), count_Of_Symbols(stroki[i]), getBytes(stroki[i]), bit_Of_Harly(stroki[i]), bit_Of_Shennon(stroki[i]));
        }
    }

    public static void reader() throws IOException {
        File file = new File("for_Reading.txt");
        FileReader fr = fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        System.out.println("Размер данных в файле: " + file.length() + " байт" + "\n" + "Решение вариант а) данные в string");
        String line;
        int i = 0;
        while ((line = br.readLine()) != null) {
            stroki[i] = line;
            i++;
        }
        br.close();
    }

    public static String check_Palindrome(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++)
            if (str.charAt(i) != str.charAt(n - i - 1)) return "-";
        return "+";
    }

    public static int count_Of_Symbols(String str) {
        int a = str.length();
        return a;
    }

    public static int getBytes(String str) throws UnsupportedEncodingException {
        byte[] bytes = str.getBytes("UTF-8");
        return bytes.length;
    }

    public static double number_Of_Unique_Chars(String str) {
        ArrayList list = new ArrayList(str.length());
        for (int i = 0; i < str.length(); i++) {
            char symbol = str.charAt(i);
            if (!list.contains(symbol)) list.add(symbol);
        }
        return list.size();
    }

    public static ArrayList<Character> Unique_Chars(String str) {
        ArrayList<Character> list = new ArrayList();
        for (int i = 0; i < str.length(); i++) {
            char symbol = str.charAt(i);
            if (!list.contains(symbol)) list.add(symbol);
        }
        return list;
    }

    public static double bit_Of_Harly(String str) {
        return str.length() * (Math.log(number_Of_Unique_Chars(str)) / Math.log(2.0));
    }

    public static double bit_Of_Shennon(String str) {
        ArrayList<Character> list = Unique_Chars(str);
        double for_Return = 0;
        int counter;
        for (char ch : list) {
            counter = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ch) counter++;
            }
            double ti = (double) counter / str.length();
            for_Return -= (double) ti * Math.log((double) ti) / Math.log(2.0);
        }
        return for_Return;
    }

    public static void out_Information() {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("  № | слово                                                   |           |            Количество информации ");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("    |                                                         |           | кол-во    | байт, размер |     бит,     |    бит,");
        System.out.println("    |                                                         | палиндром | символов  | в программе  |  по Хартли   | по Шеннону ");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void out_Date(int k, String stroki, String check_Palindrome, int count_Of_Symbols, double getBytes, double bit_Of_Harly, double bit_Of_Shennon) {

        System.out.printf("%-4.4s|%-57.57s|%-11.11s|%-11.11s|%14.2s|%14.2f|%12.9f|", k, stroki, check_Palindrome, count_Of_Symbols, getBytes, bit_Of_Harly, bit_Of_Shennon);
        System.out.println();

    }
}

