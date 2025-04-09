package com.lab6;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConfigPanel extends JPanel {
    private final MainFrame frame;
    private final JLabel label;
    private JTextField dotsField;
    private final JButton startButton;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        setLayout(new FlowLayout());

        label = new JLabel("Number of dots:");
        dotsField = new JTextField("10", 5);
        startButton = new JButton("Start");

        startButton.addActionListener((ActionEvent e) -> {
            frame.drawingPanel.clearBoard();
            int numDots = Integer.parseInt(dotsField.getText());
            frame.drawingPanel.generateDots(numDots);
        });

        add(label);
        add(dotsField);
        add(startButton);
    }
}