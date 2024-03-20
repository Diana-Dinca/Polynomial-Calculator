package org.example;

import gui.CalculatorGUI;
import javax.swing.*;
public class Main {
    public static void main(String[] args) {

        JFrame frame = new CalculatorGUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}