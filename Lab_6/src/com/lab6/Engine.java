package com.lab6;

import java.io.*;

//для управления файлами
public class Engine {
    String fname;
    String text;

    //открывает файл и сохраняет его содержимое
    Engine(String fname) throws IOException {
        this.fname = fname;
        this.text = getFileContents();
    }

    public String getText() {
        return text;
    }

    //открыть файл и вернуть содержимое
    public String getFileContents() throws IOException {
        var f = new FileInputStream(fname);
        var s = new String(f.readAllBytes()).strip();
        f.close();
        return s;
    }

    //посчитать сколько раз встречается what в файле
    public int count(String what) {
        return (what.isEmpty() || text.isEmpty() ? //если не пусты строки
                0 : (text.length() - text.replace(what, "").length()) / what.length());
    } //длина строки - длина строки без искомого слова, деленная на длину искомого слова

    public int lastPos() {
        return text.length();
    }

    //вставляет подстроку в файл
    public void insertAt(String what, int pos) throws StringIndexOutOfBoundsException {
        this.text = new StringBuffer(text).insert(pos,what).toString();
    }

    //сохраняет буфер в файл
    public void save(String filename) throws IOException {
        var f = new FileWriter(filename);
        f.write(text);
        f.close();
    }

    public void save() throws IOException {
        save(fname);
    }
}
