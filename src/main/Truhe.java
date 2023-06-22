package main;

import javax.swing.*;
import java.awt.*;

public class Truhe extends JLabel { // extends gamepanel für getScale -> getScale static gemacht

    // Attribute /////////////////////////////////////////////////////////////////////
    private int wert;
    private int positionX;
    private int positionY;

    // Konstruktor /////////////////////////////////////////////////////////////////////
    public Truhe(int wert, int positionX, int positionY, int tileSize) {
        this.wert = wert;
        this.positionX = positionX; // 1-16
        this.positionY = positionY; // 1-12

        setBounds(getPositionX(), getPositionY(),
                tileSize, tileSize);

        if (getWert() == 1) {
            setBackground(Color.LIGHT_GRAY);
            setIcon(new ImageIcon("Images/Schatztruhen/truhe1.jpg"));
        }
        if (getWert() == 2) {
            setBackground(Color.yellow);
            setIcon(new ImageIcon("Images/Schatztruhen/truhe2.jpg"));
        }
        if (getWert() == 4) {
            setBackground(Color.yellow);
            setIcon(new ImageIcon("Images/Schatztruhen/struhe2.jpg"));
        }

        if(getWert() <= 0 || getWert() >= 5) {
            setBackground(Color.MAGENTA);
        }

        /*if (getWert() == 0) {
            setIcon(new ImageIcon("C:\\Users\\PimienMar\\Desktop\\Schule\\SRH 2322 FIA\\DO IT Projekt\\IntelliJ\\Images\\Schatztruhen\\truhe1offen.jpg"));
        }*/

        setOpaque(true);
    }


    // Methoden /////////////////////////////////////////////////////////////

    public int getWert() {
        return wert;
    }

    public void setWert(int wert) {
        this.wert = wert;
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

    public boolean istOffen (){
        // Wenn false dann SpielFigur -> keylistener möglich
        // Wenn Truhe offen dann keylistener -> nicht möglich

        return false;
    }
}
