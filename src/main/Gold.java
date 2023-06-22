package main;

import javax.swing.*;
import java.awt.*;

public class Gold extends JLabel {


    private int positionX;
    private int positionY;

    private int wert;

    public Gold (int positionX, int positionY, int tileSize, int wert) {
        this.positionX = positionX; // 1-16
        this.positionY = positionY; // 1-12
        this.wert = wert;

        setBounds(getPositionX(), getPositionY(),
                tileSize, tileSize);

        setBackground(Color.orange);
        setIcon(new ImageIcon("Images/Schatztruhen/gold.jpg"));
        setOpaque(true);
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

    public int getWert() {
        return wert;
    }

    public void setWert(int wert) {
        this.wert = wert;
    }
}
