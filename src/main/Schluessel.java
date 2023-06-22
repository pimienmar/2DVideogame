package main;

import javax.swing.*;
import java.awt.*;

public class Schluessel extends JLabel {

    private int positionX;
    private int positionY;

    public Schluessel (int positionX, int positionY, int tileSize) {
        this.positionX = positionX; // 1-16
        this.positionY = positionY; // 1-12

        setBounds(getPositionX(), getPositionY(),
                tileSize, tileSize);

        setBackground(Color.GREEN);
        setIcon(new ImageIcon("Images/Schatztruhen/key.jpg"));
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
}
