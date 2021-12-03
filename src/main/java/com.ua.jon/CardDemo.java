package com.ua.jon;

import javax.swing.*;
import java.net.URL;

////////////////////////////////////////////////////////////// class CardDemoGUI

class CardDemo extends JFrame {
    //=================================================================== fields

    private static Card[] deck = new Card[52];

    //===================================================================== main
    public static void main(String[] args) {
        CardDemo window = new CardDemo();
        window.setTitle("Card Demo 1");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new CardTable(deck));
        window.setBounds(100, 100, 800, 600);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    //============================================================== constructor
    public CardDemo() {
        //... ClassLoader is where to get images from this .jar file.
        ClassLoader cldr = this.getClass().getClassLoader();

        int n = 0;         // Which card.
        int xPos = 0;      // Where it should be placed initially.
        int yPos = 0;

        //... Read in the cards using particular file name conventions.
        //    Images for the backs and Jokers are ignored here.
        String suits = "shdc";
        String faces = "a23456789tjqk";
        for (int suit = 0; suit < suits.length(); suit++) {
            for (int face = 0; face < faces.length(); face++) {
                //... Get the image from the images subdirectory.
                String imagePath = "cards/images/" + faces.charAt(face) +
                        suits.charAt(suit) + ".gif";
                URL imageURL = cldr.getResource(imagePath);
                ImageIcon img = new ImageIcon(imageURL);

                //... Create a card and add it to the deck.
                Card card = new Card(img);
                card.moveTo(xPos, yPos);
                deck[n] = card;

                //... Update local vars for next card.
                xPos += 5;
                yPos += 4;
                n++;
            }
        }
    }
}
