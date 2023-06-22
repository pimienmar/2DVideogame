package main;            //Program execution begins by initializing the main package

// z.B. import Tools.Toolbox;   Tools = package  Toolbox.java = class
                        //import package.name.*;   // Import the whole package
                        //import package.name.Class;   // Import a single class

import java.awt.*;

public class Main {

    private final static int tileSize = 32; // 32x32
    private final static int maxScreenCol = 16; //COLUMN Spalte     // Verhältnis 16x12
    private final static int maxScreenRow = 12; //ROW Zeile     // Verhältnis 16x12
    private final static int screenWidth = tileSize * maxScreenCol; // 768 pixel
    private final static int screenHeight = tileSize * maxScreenRow; // 576 pixel
    // definiert beide fenster

    public static void main(String[] args) {

        //GamePanel (Fenster) Objekte ///////////////////////////////////////////////
        TextPanel textPanel = new TextPanel(screenHeight);  // Textpanel wird erzeugt, und in der Variable textPanel abgespeichert
        GamePanel gamePanel = new GamePanel(screenWidth, screenHeight, tileSize, textPanel);    // GamePanel g1 = new GamePanel();
                                                                        // textPanel als Parameter

        Point gameLocation = gamePanel.getLocation(); // x y koordinate auf dem bildschirm, nicht programm //GP Zeile 105
        Point textLocation = new Point(gameLocation.x + gamePanel.getWidth() - 13, gameLocation.y); //position textfenster
                            // definiere textpanel (obere linke ecke spielfenster + breite)
        // position gamepanel im gamepanel
        textPanel.setLocation(textLocation); // Fensterposition des textpanel
    }
}
