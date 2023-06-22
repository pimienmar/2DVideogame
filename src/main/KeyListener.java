/*package main;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class KeyListener extends JFrame implements java.awt.event.KeyListener {


    //Methoden //////////////////////////////

    public boolean kannSichBewegen (KeyEvent e) {
            keyTyped(e);
            return true;
    }
                    // Wie KeyListener als eigene Klasse?
                    // Wie getTileSize statt + - 32 in keyTyped?
    @Override
    public void keyTyped(KeyEvent e) {  //keyTyped = Invoked when a key is typed. Uses KeyChar, char output
        switch (e.getKeyChar()) {
            case 'a': new JLabel().setLocation(new JLabel().getX()-32, new JLabel().getY());
                break;
            case 'w': new JLabel().setLocation(new JLabel().getX(), new JLabel().getY()-32);
                break;
            case 's': new JLabel().setLocation(new JLabel().getX(), new JLabel().getY()+32);
                break;
            case 'd': new JLabel().setLocation(new JLabel().getX()+32, new JLabel().getY());
                break;
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {    //keyPressed = Invoked when a physical key is pressed down. Uses KeyCode, int output


    }

    @Override
    public void keyReleased(KeyEvent e) {   //keyReleased = called whenever a button is released
        System.out.println("you released key char: " + e.getKeyChar());
        System.out.println("you released key code: " + e.getKeyCode());

    }




    *//*@Override //JFrame implements KeyListener
    public void keyTyped(KeyEvent e) {  //keyTyped = Invoked when a key is typed. Uses KeyChar, char output

        switch (e.getKeyChar()) {
            case 'a': spielFigur.setLocation(spielFigur.getX()-getTileSize(), spielFigur.getY());
                break;
            case 'w': spielFigur.setLocation(spielFigur.getX(), spielFigur.getY()-getTileSize());
                break;
            case 's': spielFigur.setLocation(spielFigur.getX(), spielFigur.getY()+getTileSize());
                break;
            case 'd': spielFigur.setLocation(spielFigur.getX()+getTileSize(), spielFigur.getY());
                break;
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {    //keyPressed = Invoked when a physical key is pressed down. Uses KeyCode, int output


    }

    @Override
    public void keyReleased(KeyEvent e) {   //keyReleased = called whenever a button is released
        System.out.println("you released key char: " + e.getKeyChar());
        System.out.println("you released key code: " + e.getKeyCode());

    }*//*
}*/
