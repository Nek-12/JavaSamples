package com.HttpPageViewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

public class App {
    JFrame frame;
    Font font;
    String text;

    App() {
        frame = new JFrame("HTMLViewer");
        font = new Font("Arial",Font.BOLD,24);
        frame.setSize(1280,720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
        var label = new JLabel("Enter the page URL Below");
        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        label.setFont(font);


        //text box for the url
        var box = new JTextField();
        box.setAlignmentX(JTextField.CENTER_ALIGNMENT);
        box.setFont(font);
        box.setMinimumSize(new Dimension(1000,40));
        //box.setMaximumSize(new Dimension(1000,40));

        //text to display
        var textArea = new JTextArea();
        textArea.setFont(new Font(null,Font.PLAIN,16));

        //button
        var btn = new JButton("Display");
        btn.setMaximumSize(new Dimension(120,40));
        btn.setFont(font);

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    textArea.setText(Engine.getTextFrom(new URL(box.getText())));
                } catch (MalformedURLException malformedURLException) {
                    textArea.setText("Invalid URL!");
                }
            }
        });

        var group = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,box,btn);
        group.setMaximumSize(new Dimension(1280,40));
        group.setMinimumSize(new Dimension(1280,40));

        frame.add(label);
        frame.add(group);
        frame.add(textArea);

        frame.setVisible(true);
    }


}
