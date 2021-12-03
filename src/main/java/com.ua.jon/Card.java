package com.ua.jon;

import javax.swing.*;
import java.awt.*;

/////////////////////////////////////////////////////////////////////////// Card
class Card {
    //=================================================================== fields
    private ImageIcon image;
    private int x;
    private int y;

    //============================================================== constructor
    public Card(ImageIcon image) {
        this.image = image;
    }

    //=================================================================== moveTo
    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //================================================================= contains
    public boolean contains(int x, int y) {
        return (x > this.x && x < (this.x + getWidth()) &&
                y > this.y && y < (this.y + getHeight()));
    }

    //================================================================= getWidth
    public int getWidth() {
        return image.getIconWidth();
    }

    //================================================================ getHeight
    public int getHeight() {
        return image.getIconHeight();
    }

    //===================================================================== getX
    public int getX() {
        return x;
    }

    //===================================================================== getY
    public int getY() {
        return x;
    }

    //===================================================================== draw
    public void draw(Graphics g, Component c) {
        image.paintIcon(c, g, x, y);
    }
}
