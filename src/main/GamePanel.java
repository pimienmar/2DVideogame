package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JFrame {  // GamePanel = Game Screen (kein JPanel Subclass mehr)

    // Attribute ///////////////////////////////////

    private Truhe[] truhen;
    private final Truhe t1;
    private final Truhe t2;
    private final Truhe t3;
    private final Truhe t4;
    private TextPanel textPanel;

    private final Schluessel schluessel1;

    private final Gold g1;
    private final Gold g2;

    private final Tile tileOutfit;
    private final Tile exitTile;


    //oldNotizfürDoku JLabel s1; // label deklaration
    //oldNotizfürDoku JLabel truhe1;
    //oldNotizfürDoku JLabel truhe2;
    //JLabel tile1;

    //Konstruktor ///////////////////////////////////
    public GamePanel(int screenWidth, int screenHeight, int tileSize, TextPanel textPanel){  // KONSTRUKTOR erkennen: IMMER! public+Klassenname
        this.textPanel = textPanel;
        //setPreferredSize(new Dimension());  war größe des kompletten fensters inklusive buttons und name
        this.getContentPane().setPreferredSize(new Dimension(screenWidth, screenHeight)); //Größe vom Inhalt vom Fenster
        // getContentPane().setBackground(Color.black); // Mit getContentPane() gelangt man an die Komponente, die den graphischen Inhalt eine Bedienoberfläche darstellt.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Programm schließen bei X
        setResizable(false); // Programmfenstergröße nicht änderbar
        setTitle("2D Game"); // Fenstername bzw. Spielname

        setLayout(null);   // "manually moving components within the frame"


        ///////////// Tiles Einzeln ///////////////////////////////

        Tile tile1 = new Tile(tileSize*4, tileSize*2, tileSize);
        this.add(tile1);

        ///////////// TileArrays /////////////////////////////////

        Tile [] tilesArrayTop = new Tile [16];
        for (int i = 0; i < 16; i++) {

            tilesArrayTop[i] = new Tile(tileSize*i, 0,tileSize);
            this.add(tilesArrayTop[i]);
        }

        Tile [] tilesArrayBot = new Tile [16];
        for (int i = 0; i < 16; i++) {

            tilesArrayBot[i] = new Tile(tileSize*i, tileSize*(12-1),tileSize);  // position y geht 16x nach rechts
            this.add(tilesArrayBot[i]);
        }

        Tile [] tilesArrayLeft = new Tile [10]; // Bei 12 gibt es die ecken doppelt!!!
        for (int i = 0; i < 10; i++) {

            tilesArrayLeft[i] = new Tile(0, tileSize*i,tileSize);
            this.add(tilesArrayLeft[i]);
        }

        Tile [] tilesArrayRight = new Tile [10];
        for (int i = 0; i < 10; i++) {

            tilesArrayRight[i] = new Tile(tileSize*(16-1), tileSize*i,tileSize);
            this.add(tilesArrayRight[i]);
        }


        schluessel1 = new Schluessel(tileSize*4, tileSize, tileSize);
        this.add(schluessel1);

        g1 = new Gold(tileSize * 5, tileSize * 6, tileSize, 1);
        this.add(g1);

        g2 = new Gold(tileSize*10, tileSize*10, tileSize, 1);
        this.add(g2);

        tileOutfit = new Tile(tileSize,tileSize,tileSize);  // Skinhändler
        this.add(tileOutfit);
        tileOutfit.setIcon(new ImageIcon("Images/Spielfiguren/spielFigurSkin2.jpg"));

        exitTile = new Tile(tileSize*4, tileSize*3,tileSize);
        this.add(exitTile);
        exitTile.setIcon(new ImageIcon("Images/Tiles/treppe.jpg"));

        /////////////////////////////////////////////////

        // setIcon(new ImageIcon("C:\\Users\\PimienMar\\Desktop\\Schule\\SRH 2322 FIA\\DO IT Projekt\\IntelliJ\\Images\\Tiles\\Tile1Scale2.jpg"));


        /*tile1 = new JLabel();
        tile1.setIcon(new ImageIcon("C:\\Users\\PimienMar\\Desktop\\Schule\\SRH 2322 FIA\\DO IT Projekt\\IntelliJ\\Images\\Tiles\\Tile1Scale2.jpg"));
        // setBounds:   x y = Startpunkt, w l = Größe
        tile1.setBackground(Color.MAGENTA);
        tile1.setOpaque(true);*/
        //  for i = 1    und  for i = 16
        //      for i 1-12   set tile1
        // 2d array besser
        //this.add(tile1);

        // Spielfigur ////////////////////////////////////////////////////
        //oldNotizfürDoku spielFigur = new JLabel(); -> Spielfigur s1 = new Spielfigur();

        Spielfigur s1 = new Spielfigur(this, textPanel, 0, tileSize,tileSize*2, tileSize*8, 0);
        //oldNotizfürDoku spielFigur = new JLabel();
        // this referenziert auf die Klasse
        this.addKeyListener(s1); // if ( s1 x/y = t1 x/y removeKeyListener(s1);
        this.add(s1);
        //getTextPanel().appendTextNewLine("s1 position x, y: " + s1.getPositionX() + ", " + s1.getPositionY());
        //getTextPanel().appendTextNewLine("--------------------------");

        // setCanMove(true); TODO keylistener als eigene methode/klasse
        // spielFigur.kannSichBewegen(true); TODO

        // Test: Spieler 2 ///////////////////////////////////////////////// TODO

        /*Spielfigur s2 = new Spielfigur(0,getTileSize()*4, getTileSize()*10);
        addKeyListener(s2);
        this.add(s2);*/
        // s2.addKeyListener(); Warum nicht so? TODO


        // Schatztruhen //////////////////////////////////////////////////////////////////
        // in setBounds x y = Startpunkt, w l = Größe



        t1 = new Truhe(1, tileSize*5, tileSize*8,tileSize);
        this.add(t1);  //truhe gamefenster zugeordnet

        t2 = new Truhe(2, tileSize*12, tileSize*7, tileSize);
        this.add(t2);

        t3 = new Truhe(1,tileSize*10,tileSize*6, tileSize); // kein main.tilesize weil im konstruktor
        this.add(t3);

        t4 = new Truhe(4, tileSize*14, tileSize,tileSize);
        this.add(t4);

        truhen = new Truhe[]{t1, t2, t3, t4};

        // Hintergrund Test (Tiles) //////////////////////
        /*for (int i = 0; i < getOriginalTileSize(); i++ ) {
            //OriginalTileSize().setIcon("C:\Users\PimienMar\Desktop\Schule\SRH 2322 FIA\DO IT Projekt\IntelliJ\Images\Tiles\tile1");
        }*/

        s1.repaint();

        t1.repaint();
        t2.repaint();
        t3.repaint();
        tile1.repaint();
        schluessel1.repaint();
        g1.repaint();
        g2.repaint();
        tileOutfit.repaint();
        exitTile.repaint();

        /*while (true){
            s1.repaint();
        }*/

        pack(); // Fenster übernimmt angegebene Größe von GamePanel
        setLocationRelativeTo(null); // Bildschirmmitte //war nicht mittig da zu früh im Code!
        setVisible(true); // "So we can see this window"
    }


    public Truhe[] getTruhen() { // gibt das array zurück (alle truhen, nicht die werte)
        return truhen;
    }

    /*public boolean spielEnde() {  // SPIELENDE wenn der inhalt aller truhen 0 ist
        int offenerWert = 0;  //speichert die addition
        Truhe[] truhen = getTruhen();
        for (int i = 0; i < truhen.length; i++){
            offenerWert = offenerWert + truhen[i].getWert();
        }
        if (offenerWert > 0) {
            return false;
        }
        return true;
    }*/

        //Methoden /////////////////////////////////////

    public  Truhe getTruhe1() {
        return t1;
    }

    public  Truhe getTruhe2() {
        return t2;
    }

    public  Truhe getTruhe3() {
        return t3;
    }

    public Truhe getTruhe4() {
        return t4;
    }

    public Schluessel getSchluessel1() { return schluessel1; }

    public Gold getG1() { return g1; }
    public Gold getG2() { return g2; }

    public Tile getExitTile() { return exitTile; }


    private void addComponents(JPanel contentPanel) {
        // Spielelemente in das Fenster einfügen

        // spielFigur

        // truhe1
        // truhe2

        // tile1
    }


    public TextPanel getTextPanel() {
        return textPanel;
    }

    public void setTextPanel(TextPanel textPanel) {
        this.textPanel = textPanel;
    }

    // spielFigur.kannSichBewegen(true); TODO
    /*public boolean getCanMove() {
        return canMove;
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }

    public void canMove (KeyEvent e){
        if (setCanMove() == true) {
            // activate Keylistener

        }
    }*/
    /*// Test Zeit ////////////////////////////////////////////////////////////////////
        while (true) {
           // long currentTime = System.currentTimeMillis();
            LocalDateTime t1 = java.time.LocalDateTime.now();
            System.out.println("Current Time: " + t1);

        }
        https://stackoverflow.com/questions/33703206/prevent-jlabel-positions-from-resetting*/

}