package com.lab5;
/*
Вариант10.
ОК Состав класса Employee (служащий) фамилия, зарплата, наличие детей.
ОК Подсчитать среднюю зарплату и количество служащих с детьми.
ОК Предусмотреть ввод информации с клавиатуры с помощью потоков ввода,
ОК вывод информации в файл,
ОК статический метод чтения из файла и вывода прочитанной информации на экран.
ОК Запрещается использовать класс Scanner.
 */

import java.io.*;

public class Employee {
    String surname;
    double salary;
    boolean hasKids;

    public Employee(String surname, double salary, boolean hasKids) {
        this.surname = surname;
        this.salary = salary;
        this.hasKids = hasKids;
    }

    public Employee() { salary = 0; hasKids = false; }

    public static double avgSalary(Employee[] employees) {
        double sum = 0;
        double cnt = 0;
        for (var e : employees) { //для каждого сотрудника в массиве
            if (e != null) { //проверка на пустое значение
                sum += e.getSalary(); //добавим зарплату и число
                ++cnt;
            }
        }
        return sum / cnt; //среднее
    }

    public static int countWithKids(Employee[] employees) {
        int cnt = 0;
        for (var e : employees) { //для каждого
            if (e != null && e.isHasKids()) //если есть дети
                ++cnt; //добавим
        }
        return cnt;
    }

    public static Employee fromConsole() throws IOException {
        //создать новый буферизованный Reader используя консольный поток ввода
        BufferedReader cli = new BufferedReader(new InputStreamReader(System.in));
        Employee e = new Employee(); //буферный объект
        System.out.println("Введите фамилию");
        e.setSurname(cli.readLine());
        while (true) { //пока не будет правильно
            System.out.println("Введите зарплату");
            try { //пытаемся получить зарплату с проверкой
                e.setSalary(Double.parseDouble(cli.readLine()));
                break;
            } catch (NumberFormatException ignored) { } //ничего не делаем если ошибка
        }
        outer: //для выхода из цикла
        while (true) { //пока не верно
            System.out.println("Есть ли дети? ( да/нет )"); //спросим про детей
            switch (cli.readLine()) {
                case "да":
                    e.setHasKids(true);
                    break outer;
                case "нет":
                    e.setHasKids(false);
                    break outer;
                default: //ничего не делать при ошибке
            }
        }
        return e; //вернем новый объект
    }

    public static void allToFile(Employee[] es, String fname) throws IOException {
        FileWriter fw = new FileWriter(fname); //откроем файл
        for (var e : es) {
            fw.write(e.toString() + '\n'); //запишем строку
        }
        fw.flush(); //очистка
        fw.close(); //закроем
    }

    @Override
    public String toString() { //для вывода
        return surname + ';' + salary + ';' + hasKids;
    }


    /////////////геттеры и сеттеры//////////

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isHasKids() {
        return hasKids;
    }

    public void setHasKids(boolean hasKids) {
        this.hasKids = hasKids;
    }
}
