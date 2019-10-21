package com.company;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Lab2 {

    public static ArrayList<String> list = new ArrayList<>();
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        point1();
        People plp = new People(); //point2
        point3();
        //point4();
        point5();
        //point6();
    }


    public static void point1() {
        System.out.println("////////////////Первый пункт////////////////");
        System.out.print("Введите число: ");
        int num = scn.nextInt();
        stacksAndDeques(num);
        System.out.println("---------------------------------------------------------------------------------------------");
    }

    public static void point3() {
        System.out.println("////////////////Третий пункт////////////////");
        System.out.print("Введите математическое выражение: ");
        String math = scn.next();
        System.out.println(checkBalanced(math));
        System.out.println("---------------------------------------------------------------------------------------------");
    }

    public static void point4() {
    }

    public static void point5() {
        System.out.println("////////////////Пятый пункт////////////////");
        try {
            reader();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        sorts();
        System.out.println("---------------------------------------------------------------------------------------------");
    }

    public static void point6() {
    }

    public static void stacksAndDeques(int chislo) {
        Stack<Integer> stack = new Stack<Integer>();
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();

        while (chislo != 0) {
            stack.push(chislo % 10);
            deque.add(chislo % 10);
            list.add(chislo % 10);
            chislo /= 10;
        }
        System.out.println("Стек в правильном порядке: ");
        while (!stack.isEmpty()) System.out.println(stack.pop());
        System.out.println("Очередь в обратном порядке: ");
        while (!deque.isEmpty()) System.out.println(deque.pop());

        for (int i = list.size() - 1; i >= 0; i--) {
            stack.push(list.get(i));
            deque.addLast(list.get(i));
        }

        System.out.println("Стек в обратном порядке: ");
        while (!stack.isEmpty()) System.out.println(stack.pop());
        System.out.println("Очередь в прямом порядке: ");
        while (!deque.isEmpty()) System.out.println(deque.pop());

    } //point1

    public static String checkBalanced(String str){

            Stack<Character> stack = new Stack<Character>();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == '{' || ch == '(' || ch == '[')
                {
                    stack.push(ch);
                }
                if (ch == '}' || ch == ')' || ch == ']')
                {
                    if (stack.isEmpty())
                        return "Все скобки расствлены правильно";
                    char last = stack.peek();
                    if (ch == '}' && last == '{' || ch == ')' && last == '(' || ch == ']' && last == '[')
                        stack.pop();
                    else
                        return "Некорректное расставление скобок";
                }
            }
        if(stack.isEmpty()) return "Все скобки расствлены правильно";
        else return "Некорректное расставление скобок";
    }

    public static void reader() throws FileNotFoundException, IOException {
        File file = new File("for_5.txt");
        FileReader fr = fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        int i = 0;
        while ((line = br.readLine()) != null) {
            list.add(line);
            i++;
        }
        br.close();
    } //point5

    public static void sorts() { //метод для пятого пункта
        System.out.println("Сортировка по длине строки пукнт а)");
        Collections.sort(list, new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) return 1;
                else if (o1.length() < o2.length()) return -1;
                else return 0;
            }
        });
        System.out.println(list);

        System.out.println("Сортировка в лексиграфическом порядке пункт б)");
        Collections.sort(list);
        System.out.println(list);

        System.out.println("Сортировка по количеству заглавных латинских букв в строке");
        Collections.sort(list, new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                int upperCaseCounter1 = 0;
                int upperCaseCounter2 = 0;

                for (int i = 0; i < o1.length(); i++) {
                    if (Character.isUpperCase(o1.charAt(i))) upperCaseCounter1++;
                }
                for (int i = 0; i < o2.length(); i++) {
                    if (Character.isUpperCase(o2.charAt(i))) upperCaseCounter2++;
                }

                if (upperCaseCounter1 < upperCaseCounter2) return 1;
                else if (upperCaseCounter1 > upperCaseCounter2) return -1;
                else return 0;
            }
        });
        System.out.println(list);
    } //point5

}

class People { // point2

    public static ArrayList <String> sortPeople40 = new ArrayList<>();

    public People() {
        System.out.println("////////////////Второй пункт////////////////");
        try {
            reader();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        for (int i = 0; i < sortPeople40.size(); i++) {
            System.out.println(sortPeople40.get(i));
        }
        System.out.println("---------------------------------------------------------------------------------------------");
    }

    public static void setInformation(String inf) {
        String [] array = inf.split(" ");
        Stack<String> stack = new Stack<>();
        ArrayDeque <String> deque = new ArrayDeque<>();
        for (int i = array.length - 1; i >= 0; i--) {
            stack.push(array[i]);
            deque.addFirst(array[i]);
        }
        String[] str = stack.get(1).split("/");
        Integer[] dates = new Integer[3];
        for (int i = 0; i < dates.length; i++) {
            dates[i] = Integer.parseInt(str[i]);
        }
        LocalDate birthdate = LocalDate.of(dates[2], dates[1], dates[0]);
        LocalDate now = LocalDate.now();
        long years = ChronoUnit.YEARS.between(birthdate, now);
        if (years < 40) while(!stack.isEmpty()) System.out.println (stack.pop());
        else while(!stack.isEmpty()) sortPeople40.add(stack.pop());

    }

    public static void reader() throws FileNotFoundException, IOException {
        File file = new File("for_2.txt");
        FileReader fr = fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        int i = 0;
        while ((line = br.readLine()) != null) {
            setInformation(line);
            i++;
        }
        br.close();
    }
}

