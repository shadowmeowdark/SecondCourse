package com.company;

import java.util.Arrays;
import java.util.Random;

public class Lab_Number_One {
    public static double znach = 0;
    public static CommonFunction[] function = new CommonFunction[4];
    public static CommonFunction[] uravneniya = new CommonFunction[4];

    interface CommonFunction {
        double OurFunction(double x);
    }

    public static void main(String[] args) {
        function[0] = (double x) -> 2 * Math.sin(x) + 1;
        function[1] = (double x) -> Math.pow(x / Math.PI - 1, 2);
        function[2] = (double x) -> -1 * Math.pow(x / Math.PI, 2) - 2 * x + 5 * Math.PI;
        function[3] = (double x) -> Math.pow(Math.cos(x), 2) * 0.5 + 1;
        testing_OurFunction(-2 * Math.PI, 2 * Math.PI, Math.PI / 6, function); //первый пункт
        counter_Negative(-2 * Math.PI, 2 * Math.PI, Math.PI / 6, function); //второй пункт а
        find_Min_Max(function); //второй пункт б

        uravneniya[0] = (double x) -> x * Math.sin(x) - 0.5;
        uravneniya[1] = (double x) -> Math.log(x * x - 3 * x + 2);
        uravneniya[2] = (double x) -> Math.log(x * x - 3 * x + 2);
        uravneniya[3] = (double x) -> 0.5 * Math.tan(2 * (x + Math.PI / 4) / 3) - 1;

        out_half_Devide(); //четвертый пункт
        System.out.println("Пятый пункт, вычисление интегралов");
        for (int i = 0; i < 4; i++) {
            System.out.println(calculation_Of_Integrals(-Math.PI, Math.PI, 25, uravneniya[i])); //пятый пункт
        }

    }

    public static void testing_OurFunction(double start, double end, double step, CommonFunction[] function) {
        System.out.println("Первый пункт задания, тестировка функций");
        for (int i = 0; i < 4; i++) {
            for (double x = start; x < end; x += step) {
                znach = function[i].OurFunction(x);
                System.out.println("Значение функции " + i + " в точке " + x + " равно " + znach);
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    public static void counter_Negative(double start, double end, double step, CommonFunction[] function) {
        System.out.println("Второй пункт задания, поиск отрицательных значений, пункт а)");
        int counter_Function = 0;
        int counter_Common = 0;
        for (int i = 0; i < 4; i++) {
            counter_Function = 0;
            for (double x = start; x < end; x += step) {
                if (function[i].OurFunction(x) < 0) {
                    counter_Function++;
                    counter_Common++;
                }
            }
            System.out.println("Для функции под номером " + i + " количесто отрицательных значений равно " + counter_Function);
        }
        System.out.println("Для всех функций количество отрицательных значений равно " + counter_Common);
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    public static void find_Min_Max(CommonFunction[] function) {
        System.out.println("Второй пункт задания, поиск максимума и минимума пункт б)");
        double minimum = 0;
        double maximum = 0;
        Random random = new Random();
        int n = random.nextInt(100); //для удобства n ограничение не больше 100
        double[] points = new double[n];
        for (int i = 0; i < points.length; i++) {
            points[i] = -10 + random.nextInt(20) + random.nextDouble();
        }
        for (int k = 0; k < 4; k++) {
            minimum = 10000;
            maximum = -10000;
            for (int i = 0; i < points.length; i++) {
                if (function[k].OurFunction(points[i]) < minimum) minimum = function[k].OurFunction(points[i]);
                if (function[k].OurFunction(points[i]) > maximum) maximum = function[k].OurFunction(points[i]);
            }
            System.out.println("Для функции под номером " + k + " минимальное значение равно " + minimum);
            System.out.println("Для функции под номером " + k + " максимальное значение равно " + maximum);
        }
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    public static double half_Devide(double a, double b, CommonFunction function) {
        double x;
        double eps = 0.0001;
        double middle = 0;
        while ((b - a) > eps) {
            middle = (b + a) / 2;
            if (function.OurFunction(middle) == 0) {
                x = middle;
                System.out.println(x);
                return x;
            } else if (function.OurFunction(middle) * function.OurFunction(a) < 0) {
                b = middle;
            } else {
                a = middle;
            }
        }
        return middle;
    }

    public static double calculation_Of_Integrals(double up, double down, int n, CommonFunction function) {
        double a = 0;
        double step = (up - down) / n;
        for (double i = down; i < up; i += step) {
            a += function.OurFunction(i) * step;
        }
        return a;
    }


    public static void out_half_Devide() {
        System.out.println("Четвертвый пункт задания, поиск корней уравнения");
        System.out.println(half_Devide(0, Math.PI, uravneniya[0]));
        System.out.println(half_Devide(0, 0.9, uravneniya[1]));
        System.out.println(half_Devide(2.1, 5, uravneniya[2]));
        System.out.println(half_Devide(Math.PI, 2 * Math.PI, uravneniya[3]));
        System.out.println("----------------------------------------------------------------------------------------------");
    }


}

