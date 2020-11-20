package com.lab5;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
    try {
        //создадим объекты
        Employee[] es = new Employee[3];
        es[0] = Employee.fromConsole();
        es[1] = Employee.fromConsole();
        es[2] = new Employee("Никита", 99999.0, true);

        System.out.println("Средняя зарплата: " + Employee.avgSalary(es));
        System.out.println("Имеют детей: " + Employee.countWithKids(es));
        Employee.allToFile(es, "employees.txt"); //сохранить всё в файл
        System.out.println("Содержимое файла: \n");
        outputOfFile("employees.txt"); //вывести файл
    } catch (IOException e) {
        System.out.println("Не получилось прочитать из файла/консоли!");
        System.exit(-1);
    }

    }

    public static void outputOfFile(String fname) throws IOException {
        File file = new File(fname); //откроем файл
        FileReader reader = new FileReader(file); //для чтения из файла
        char[] buffer = new char[1];
        int number;
        do {
            number = reader.read(buffer);  //прочитать 1 символ
            System.out.print(buffer[0]);
        } while (number == 1); //пока есть что читать
        reader.close();
    }
}
