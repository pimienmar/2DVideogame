package main;

import javax.swing.*;
import java.awt.*;

public class Tile extends JLabel {

    // Attribute /////////////////////////////////////////////////////////////////////

    private int positionX;
    private int positionY;

    // Konstruktor /////////////////////////////////////////////////////////////////////
    public Tile(int positionX, int positionY, int tileSize) {
        this.positionX = positionX; // 1-16
        this.positionY = positionY; // 1-12

        setBounds(getPositionX(), getPositionY(),
                tileSize, tileSize);

        setBackground(Color.LIGHT_GRAY);
        setIcon(new ImageIcon("Images/Tiles/Tile1Scale2.jpg"));
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
