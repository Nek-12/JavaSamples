package com.lab6;

import java.io.*;

/*
ОК Дан исходный символьный файл, в котором находится текст, состоящий не менее чем из 30 слов.
ОК Написать программу, которая выполняла бы следующие действия над этим текстом.
ОК Читала его из файла.
ОК По необходимости, редактировала его в файле.
ОК Делала над ним действия, указанные ниже в вашем варианте заданий.
ОК Результат выполнения действий записывала в байтовый файл.
При этом все указанные возможности необходимо реализовать через меню:
ОК а) Чтение текста из файла (исходного).
ОК б) Редактирование текста исходного файла (
   ОК добавление текста в начало файла,
   ОК добавление текста в конец файла,
   ОК добавление текста в произвольную позицию в файле).
в) ОК Выполнение действий над текстом.
г) ОК Запись текста в файл.
ОК Указанные действия необходимо реализовать в виде соответствующих методов класса.
ОК Запрещается помещать весь код в метод public static void main(String args[]).
ОК Запрещается использовать класс Scanner.
 */


public class Main {

    public static void menu() throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        Engine e;
        while (true) {
            System.out.println("Введите имя файла, который открыть или пустую строку, чтобы открыть стандартный: ");
            try {
                String s = br.readLine();
                //если пустая, открыть text.txt, иначе новый
                e = new Engine(s.isEmpty()? "text.txt" : s);
                break;
            } catch (IOException ignored) {
                System.out.println("Не удалось открыть этот файл... ");
            }
        }
        while (true) {
            System.out.println("\n1. Показать текст в файле\n" +
                    "2. Добавить текст в начало файла\n" +
                    "3. Добавить текст в конец\n" +
                    "4. Добавить текст на позицию в файле\n" +
                    "5. Показать, сколько раз встречается слово в файле\n" +
                    "6. Сохранить текст\n" +
                    "7. Выйти\n");
            switch (br.readLine()) {
                case "1":
                    //вывести текст
                    System.out.println(e.getText());
                    break;
                case "2":
                    System.out.println("Что добавить в начало файла?.. Введите строку: ");
                    //нулевая позиция - в начале
                    e.insertAt(br.readLine(), 0);
                    System.out.println("Отредактировано успешно");
                    break;
                case "3":
                    System.out.println("Что добавить в конец? Введите строку...");
                    e.insertAt(br.readLine(), e.lastPos());
                    System.out.println("Отредактировано успешно");
                    break;
                case "4":
                    int pos;
                    while (true) {
                        System.out.println("Последняя позиция в тексте: " + e.lastPos()
                                + "\n Введите позицию, куда вставить текст: ");
                        try {
                            //попытаемся преобразовать в число
                            pos = Integer.parseInt(br.readLine());
                            break;
                        } catch (NumberFormatException ignored)
                        { } //спросить заново
                    }
                    System.out.println("Введите строку...");
                    e.insertAt(br.readLine(), pos);
                    break;
                case "5":
                    System.out.println("Введите строку для подсчёта количества: ");
                    String s = br.readLine().strip(); //уберем лишние пробелы
                    System.out.println("Строка " + s + " встречается " + e.count(s) + " раз.");
                    break;
                case "6":
                    System.out.println("Введите имя нового файла: ");
                    e.save(br.readLine());
                case "7":
                    while (true) {
                        System.out.println("Сохранить файл?");
                        switch (br.readLine()) {
                            case "да":
                                e.save();
                                return;
                            case "нет":
                                return;
                            default:
                                break;
                        }
                    }
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        try {
            //посчитаем, сколько раз встречаются слова в статье на Википедии о Java
            menu();
        } catch (IOException e) {
            System.err.println("Не удалось выполнить действие с файлом");
        }
    }
}
