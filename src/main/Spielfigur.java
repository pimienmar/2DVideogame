package main;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Spielfigur extends JLabel implements KeyListener {

    private GamePanel gamePanel;  // Attribut GamePanel, referenz zu GamePanel  (wie position 12)
    private TextPanel textPanel;
    private int gesammeltePunkte;
    private int positionX;
    private int positionY;
    private int tileSize;

    private Schluessel schluessel;
    private int anzahlSchluessel;


    //private int newPositionX;
    //private int newPositionY;

    public Spielfigur(GamePanel gamePanel, TextPanel textPanel, int gesammeltePunkte, int tileSize, int positionX, int positionY, int anzahlSchluessel) {
        this.gamePanel = gamePanel;
        this.textPanel = textPanel;
        this.gesammeltePunkte = gesammeltePunkte;
        this.tileSize = tileSize;
        this.positionX = positionX; // 1-16
        this.positionY = positionY; // 1-12
        this.schluessel = schluessel;
        this.anzahlSchluessel = anzahlSchluessel;

        setIcon(new ImageIcon("Images/Spielfiguren/spielFigurScale2.jpg"));

        setBounds(getPositionX(), getPositionY(),
                getTileSize(), getTileSize());

        setOpaque(true);
    }


    @Override //JFrame implements KeyListener
    public void keyTyped(KeyEvent e) {  //  "Pseudogameloop"
        //keyTyped = Invoked when a key is typed. Uses KeyChar, char output
        //keyTyped = Unicode
        //Pfeiltasten haben keine darstellung im Unicode -> mit getkeyCode in keyPressed
        //keyPressed - when the key goes down
        //keyReleased - when the key comes up
        //keyTyped - unicode character represented by this key

        switch (e.getKeyChar()) {
            case 'w':

                if (getPositionY() == tileSize) {  // Wenn Y = 1, hochlaufen nicht möglich (wand)
                    setLocation(getX(), getY());
                } else {
                                                        // TEST KOLISSION TRUHE 1 und Steinblock
                if (getPositionX() == gamePanel.getTruhe1().getPositionX() && getPositionY() == gamePanel.getTruhe1().getPositionY()+getTileSize()
                || getPositionX() == tileSize*4 && getPositionY() == tileSize*3
                || getPositionX() == tileSize && getPositionY() == tileSize*2)  {  //Tile1
                    setLocation(getX(), getY());
                } else {
                    setLocation(getX(), getY() - getTileSize());
                    setPositionY(getPositionY() - getTileSize());
                    textPanel.appendTextNewLine("==============================");
                    textPanel.appendTextNewLine(" Deine Position: " + getPositionX() + ", " + getPositionY());
                    textPanel.appendTextNewLine(" ");
                    textPanel.appendTextNewLine(" Gold: " + getGesammeltePunkte());
                    textPanel.appendTextNewLine(" Schlüssel: " + getAnzahlSchluessel());
                    textPanel.appendTextNewLine("==============================");
                    //System.out.println("Notiz: Truhe 1 position x, y: " + gamePanel.getTruhe1().getPositionX());
                    //textPanel.appendTextNewLine("Tipp: Die erste Truhe befindet sich in Position: 160, 256");
                }
                }
                break;

            case 'a':
                /*if (getPositionX() == (-32) && getPositionY() == 320) {
                    setLocation(getX() + tileSize*15, getY());
                    setPositionX(getPositionX() + tileSize*15);
                }*/
                if (getPositionX() == tileSize && getPositionY() == tileSize           // Eigentlich Richtig: NUR if (getPositionX() == tileSize
                        || getPositionX() == tileSize && getPositionY() == tileSize*2  // und
                        || getPositionX() == tileSize && getPositionY() == tileSize*3  // getPositionX() == tileSize && getPositionY() == tileSize*9
                        || getPositionX() == tileSize && getPositionY() == tileSize*4  // Als Ausnahme
                        || getPositionX() == tileSize && getPositionY() == tileSize*5
                        || getPositionX() == tileSize && getPositionY() == tileSize*6
                        || getPositionX() == tileSize && getPositionY() == tileSize*7
                        || getPositionX() == tileSize && getPositionY() == tileSize*8
                        || getPositionX() == tileSize && getPositionY() == tileSize*9

                        || getPositionX() == tileSize*5 && getPositionY() == tileSize*2  // Steinblock
                        || getPositionX() == tileSize*2 && getPositionY() == tileSize    // Skin Händler
                        ) {  // Wenn Y = 1, links durch wandlaufen nicht möglich
                        setLocation(getX(), getY());  // FUNKTIONIERT FÜR ALLE BLÖCKE EINZELN
                        //setPositionX(getPositionX());
                } else {
                    setLocation(getX() - getTileSize(), getY());
                    setPositionX(getPositionX() - tileSize);

                    if (getPositionX() == tileSize*(-1) && getPositionY() == tileSize*10) {  // "Teleport von Links nach rechts"
                        setLocation(getX() + tileSize*16, getY());
                        setPositionX(getPositionX() + tileSize*16);
                    }
                    textPanel.appendTextNewLine("==============================");
                    textPanel.appendTextNewLine(" Deine Position: " + getPositionX() + ", " + getPositionY());
                    textPanel.appendTextNewLine(" ");
                    textPanel.appendTextNewLine(" Gold: " + getGesammeltePunkte());
                    textPanel.appendTextNewLine(" Schlüssel: " + getAnzahlSchluessel());
                    textPanel.appendTextNewLine("==============================");
                }
                break;

            case 's':
                if (getPositionY() == tileSize*10
                        || getPositionX() == tileSize*4 && getPositionY() == tileSize) {  // Wenn Y = 1, links durch wandlaufen nicht möglich
                    setLocation(getX(), getY());
                } else {
                    setLocation(getX(), getY() + getTileSize());
                    setPositionY(getPositionY() + getTileSize());
                    textPanel.appendTextNewLine("==============================");
                    textPanel.appendTextNewLine(" Deine Position: " + getPositionX() + ", " + getPositionY());
                    textPanel.appendTextNewLine(" ");
                    textPanel.appendTextNewLine(" Gold: " + getGesammeltePunkte());
                    textPanel.appendTextNewLine(" Schlüssel: " + getAnzahlSchluessel());
                    textPanel.appendTextNewLine("==============================");
                }
                break;

            case 'd':
                if (getPositionX() == tileSize*14 && getPositionY() == tileSize    // Eigentlich Richtig: NUR if (getPositionX() == tileSize
                        || getPositionX() == tileSize*14 && getPositionY() == tileSize*2  // und
                        || getPositionX() == tileSize*14 && getPositionY() == tileSize*3  // getPositionX() == tileSize && getPositionY() == tileSize*9
                        || getPositionX() == tileSize*14 && getPositionY() == tileSize*4  // Als Ausnahme
                        || getPositionX() == tileSize*14 && getPositionY() == tileSize*5
                        || getPositionX() == tileSize*14 && getPositionY() == tileSize*6
                        || getPositionX() == tileSize*14 && getPositionY() == tileSize*7
                        || getPositionX() == tileSize*14 && getPositionY() == tileSize*8
                        || getPositionX() == tileSize*14 && getPositionY() == tileSize*9

                        || getPositionX() == tileSize*3 && getPositionY() == tileSize*2 // Steinblock
                ) {  // Wenn Y = 1, links durch wandlaufen nicht möglich
                    setLocation(getX(), getY());  // FUNKTIONIERT FÜR ALLE BLÖCKE EINZELN
                    //setPositionX(getPositionX());
                } else {
                    setLocation(getX() + getTileSize(), getY());
                    setPositionX(getPositionX() + getTileSize());

                    if (getPositionX() == 512 && getPositionY() == 320) {  // Teleport von Rechts nach Links
                        setLocation(getX() - tileSize*16, getY());
                        setPositionX(getPositionX() - tileSize*16);
                    }

                    textPanel.appendTextNewLine("==============================");
                    textPanel.appendTextNewLine(" Deine Position: " + getPositionX() + ", " + getPositionY());
                    textPanel.appendTextNewLine(" ");
                    textPanel.appendTextNewLine(" Gold: " + getGesammeltePunkte());
                    textPanel.appendTextNewLine(" Schlüssel: " + getAnzahlSchluessel());
                    textPanel.appendTextNewLine("==============================");
                }
                break;
        }

        ////////// KOLLISION //////////////////////////
            // Siehe Key Listener



        ///////////////// TRUHEN & Schlüssel/////////////////////////////////////////////////////////

        if (getPositionX() == gamePanel.getSchluessel1().getPositionX() && getPositionY() == gamePanel.getSchluessel1().getPositionY()) {
            setAnzahlSchluessel(getAnzahlSchluessel() + 1);
            gamePanel.getSchluessel1().setPositionX(tileSize*20);
            gamePanel.getSchluessel1().setPositionY(tileSize*20);
            gamePanel.getSchluessel1().setIcon(null);
            gamePanel.getSchluessel1().setBackground(null);
            //gamePanel.repaint();
        }

        Truhe[] truhen = gamePanel.getTruhen();
        for (int i = 0; i < truhen.length; i++) {
            if (getPositionX() == truhen[i].getPositionX() && getPositionY() == truhen[i].getPositionY()) {

                if (truhen[i].getWert() == 0) {
                    textPanel.appendTextNewLine("==============================");
                    textPanel.appendTextNewLine(" Die Truhe ist leer!");
                    textPanel.appendTextNewLine(" ");
                    textPanel.appendTextNewLine(" Gold: " + getGesammeltePunkte());
                    textPanel.appendTextNewLine(" Schlüssel: " + getAnzahlSchluessel());
                    textPanel.appendTextNewLine("==============================");
                    int neuerWert;
                    neuerWert = truhen[i].getWert();
                }
                // optional Wenn gesammeltePunkte == truhen[i] mit wert 1 (zusammengerechnet) dann möglich wert 2 truhe einzusammeln

                else {
                    if (truhen[i].getWert() <= 2) {


                    setGesammeltePunkte(getGesammeltePunkte() + truhen[i].getWert());
                    textPanel.appendTextNewLine("==============================");
                    textPanel.appendTextNewLine(" Du hast " + truhen[i].getWert() + " Gold erhalten");
                    if (truhen[i].getWert() == 1) {
                        truhen[i].setIcon(new ImageIcon("Images/Schatztruhen/truhe1offen.jpg"));
                    }
                    if (truhen[i].getWert() == 2) {
                        truhen[i].setIcon(new ImageIcon("Images/Schatztruhen/truhe2offen.jpg"));
                    }
                    truhen[i].setWert(0);
                    textPanel.appendTextNewLine(" ");
                    textPanel.appendTextNewLine(" Gold: " + getGesammeltePunkte());
                    textPanel.appendTextNewLine(" Schlüssel: " + getAnzahlSchluessel());
                    textPanel.appendTextNewLine("==============================");
                    } else {
                        if (anzahlSchluessel >= 1) {
                            setGesammeltePunkte(getGesammeltePunkte() + truhen[i].getWert());
                            setAnzahlSchluessel(getAnzahlSchluessel() - 1);
                            truhen[i].setWert(0);
                            truhen[i].setIcon(new ImageIcon("Images/Schatztruhen/truhe2offen.jpg"));
                            truhen[i].setBackground(null);

                        } else {
                            textPanel.appendTextNewLine("Du besitzt keinen Schlüssel!");
                            textPanel.appendTextNewLine("==============================");
                        }

                    }
                }
                break; // damit die schleife aufhört sobald eine truhe eingesammelt wurde (ein feld kann nicht 2 truhen haben)
            }
        }

        if (getPositionX() == tileSize*2 && getPositionY() == tileSize  // Händler
        || getPositionX() == tileSize && getPositionY() == tileSize*2) {
            textPanel.appendTextNewLine("==============================");
            textPanel.appendTextNewLine(" Willkommen beim Händler!");
            textPanel.appendTextNewLine(" Ich verkaufe nur beste Ware.");
            textPanel.appendTextNewLine("  ");
            textPanel.appendTextNewLine(" Für 10 Goldstücke verpasse");
            textPanel.appendTextNewLine(" ich dir ein neues aussehen! ");
            textPanel.appendTextNewLine(" Komm jederzeit vorbei. ");
            if (getGesammeltePunkte() >= 10) {
                setIcon(new ImageIcon("Images/Spielfiguren/spielFigurSkin3.jpg"));
                setGesammeltePunkte(getGesammeltePunkte() -10);
                textPanel.appendTextNewLine("  ");
                textPanel.appendTextNewLine(" Gold: " + getGesammeltePunkte());
                textPanel.appendTextNewLine(" Schlüssel: " + getAnzahlSchluessel());
                textPanel.appendTextNewLine("==============================");
            } else {
                textPanel.appendTextNewLine("  ");
                textPanel.appendTextNewLine(" Nicht genug Gold...");
                textPanel.appendTextNewLine("  ");
                textPanel.appendTextNewLine(" Gold: " + getGesammeltePunkte());
                textPanel.appendTextNewLine(" Schlüssel: " + getAnzahlSchluessel());
                textPanel.appendTextNewLine("==============================");
            }
        }


        if (getPositionX() == gamePanel.getG1().getPositionX() && getPositionY() == gamePanel.getG1().getPositionY()) {
            textPanel.appendTextNewLine("==============================");
            textPanel.appendTextNewLine(" Du hast " + gamePanel.getG1().getWert() + " Gold erhalten");
            setGesammeltePunkte(getGesammeltePunkte() + gamePanel.getG1().getWert());
            gamePanel.getG1().setWert(0);
            gamePanel.getG1().setIcon(null);
            gamePanel.getG1().setBackground(null);
            textPanel.appendTextNewLine(" ");
            textPanel.appendTextNewLine(" Gold: " + getGesammeltePunkte());
            textPanel.appendTextNewLine(" Schlüssel: " + getAnzahlSchluessel());
            textPanel.appendTextNewLine("==============================");
        }

        if (getPositionX() == gamePanel.getG2().getPositionX() && getPositionY() == gamePanel.getG2().getPositionY()) {
            textPanel.appendTextNewLine("==============================");
            textPanel.appendTextNewLine(" Du hast " + gamePanel.getG2().getWert() + " Gold erhalten");
            setGesammeltePunkte(getGesammeltePunkte() + gamePanel.getG2().getWert());
            gamePanel.getG2().setWert(0);
            gamePanel.getG2().setIcon(null);
            gamePanel.getG2().setBackground(null);
            textPanel.appendTextNewLine(" ");
            textPanel.appendTextNewLine(" Gold: " + getGesammeltePunkte());
            textPanel.appendTextNewLine(" Schlüssel: " + getAnzahlSchluessel());
            textPanel.appendTextNewLine("==============================");
        }


        //////////////// SPIELENDE /////////////////////////////////////////////////
        //if (gamePanel.spielEnde()) {
        if (getGesammeltePunkte() >= 10) {
            textPanel.appendTextNewLine("==============================");
            textPanel.appendTextNewLine(" Du hast gewonnen");
            textPanel.appendTextNewLine(" Du hast gewonnen");
            textPanel.appendTextNewLine(" Du hast gewonnen");
            textPanel.appendTextNewLine(" ");
            textPanel.appendTextNewLine(" Gold: " + getGesammeltePunkte());
            textPanel.appendTextNewLine(" Schlüssel: " + getAnzahlSchluessel());
            textPanel.appendTextNewLine("==============================");

            //gamePanel.dispose();
            //textPanel.dispose();

            if (getPositionX() == gamePanel.getExitTile().getPositionX() && getPositionY() == gamePanel.getExitTile().getPositionY() ) {
                //System.exit(0);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {    //keyPressed = Invoked when a physical key is pressed down. Uses KeyCode, int output
        switch (e.getKeyCode()) {

            case 38:
                // setLocation(getX(), getY() - getTileSize());
                textPanel.appendTextNewLine("==============================");
                textPanel.appendTextNewLine(" Bitte W benutzen (W, A, S, D)");
                textPanel.appendTextNewLine(" ");
                textPanel.appendTextNewLine(" Gold: " + getGesammeltePunkte());
                textPanel.appendTextNewLine(" Schlüssel: " + getAnzahlSchluessel());
                textPanel.appendTextNewLine("==============================");
                break;
            case 37:
                // setLocation(getX() - getTileSize(), getY());
                textPanel.appendTextNewLine("==============================");
                textPanel.appendTextNewLine(" Bitte A benutzen (W, A, S, D)");
                textPanel.appendTextNewLine(" ");
                textPanel.appendTextNewLine(" Gold: " + getGesammeltePunkte());
                textPanel.appendTextNewLine(" Schlüssel: " + getAnzahlSchluessel());
                textPanel.appendTextNewLine("==============================");
                break;
            case 40:
                // setLocation(getX(), getY() + getTileSize());
                textPanel.appendTextNewLine("==============================");
                textPanel.appendTextNewLine(" Bitte S benutzen (W, A, S, D)");
                textPanel.appendTextNewLine(" ");
                textPanel.appendTextNewLine(" Gold: " + getGesammeltePunkte());
                textPanel.appendTextNewLine(" Schlüssel: " + getAnzahlSchluessel());
                textPanel.appendTextNewLine("==============================");
                break;
            case 39:
                // setLocation(getX() + getTileSize(), getY());
                textPanel.appendTextNewLine("==============================");
                textPanel.appendTextNewLine(" Bitte D benutzen (W, A, S, D)");
                textPanel.appendTextNewLine(" ");
                textPanel.appendTextNewLine(  " Gold: " + getGesammeltePunkte());
                textPanel.appendTextNewLine(  " Schlüssel: " + getAnzahlSchluessel());
                textPanel.appendTextNewLine("==============================");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {   //keyReleased = called whenever a button is released
        /*textPanel.appendTextNewLine("you released key char: " + e.getKeyChar());
        textPanel.appendTextNewLine("you released key code: " + e.getKeyCode());
        textPanel.appendTextNewLine("--------------------------");*/
    }


    public int getGesammeltePunkte() {
        return gesammeltePunkte;
    }

    public void setGesammeltePunkte(int gesammeltePunkte) {
        this.gesammeltePunkte = gesammeltePunkte;
    }

    public int getTileSize() {
        return tileSize;
    }

    public void setTileSize(int tileSize) {
        this.tileSize = tileSize;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getAnzahlSchluessel() {
        return anzahlSchluessel;
    }

    public void setAnzahlSchluessel(int anzahlSchluessel) {
        this.anzahlSchluessel = anzahlSchluessel;
    }
}
