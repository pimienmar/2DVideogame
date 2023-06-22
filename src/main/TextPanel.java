package main;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;

public class TextPanel extends JFrame {

    private JTextArea textArea;

    // Konstruktor/////////////////////////////////////////
    public TextPanel(int screenHeight) {  // Konstruktor definiert wie man eine Klasse aufbaut
        this.getContentPane().setPreferredSize(new Dimension(250, screenHeight));  //größe
        // getContentPane().setBackground(Color.black); // Mit getContentPane() gelangt man an die Komponente, die den graphischen Inhalt eine Bedienoberfläche darstellt.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Programm schließen bei X
        setResizable(false); // Programmfenstergröße nicht änderbar
        setTitle("2D Game result"); // Fenstername bzw. Spielname
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setMinimumSize(new Dimension(200, screenHeight-80));
        textArea.setEditable(false);  // Nicht Editierbar für den User (reinschreiben/löschen etc)
        DefaultCaret caret = (DefaultCaret) textArea.getCaret();  // Scrollbalken, getCaret = |Tippen (wo man im text ist)
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);  // Scrollbalken wird immer zum caret geupdatet, dadurch scroll er mit

        JScrollPane scrollPane = new JScrollPane(textArea);  //text wird in den scrollpane eingefügt
        scrollPane.setViewportView(textArea); // balken genauso groß wie textarea

        this.add(scrollPane); // fügt scrollpane dem fenster hinzu ( Objekt TextPanel hat JScrollPane, JScrollPane hat textArea

        pack(); // Fenster übernimmt angegebene Größe von GamePanel
        setVisible(true);

        appendTextNewLine("==============================");
        appendTextNewLine(" Sammle 10 Gold um");
        appendTextNewLine(" das Level zu beenden.");
        appendTextNewLine(" ");
        // appendTextNewLine("Du besitzt " + Spielfigur.s1.getGesammeltePunkte() + " Punkte.");
        appendTextNewLine(" ");
        appendTextNewLine(" Gold: " + "0");
        appendTextNewLine(" Schlüssel: " + "0");
        appendTextNewLine("==============================");


    }

    public void appendTextNewLine(String text) {  // Methode die Text in das Textfenster schriebt
        this.textArea.append("\n" + text); // append = füge text zu textarea attribut hinzu, n = neue zeile
    }


}
