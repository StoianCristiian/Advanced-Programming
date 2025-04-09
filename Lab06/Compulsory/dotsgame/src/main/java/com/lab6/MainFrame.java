package com.lab6;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame 
{   
    ConfigPanel configPanel;
    DrawingPanel drawingPanel;
    ControlPanel controlPanel;

    public MainFrame() {
        super("Dots Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        configPanel = new ConfigPanel(this);
        drawingPanel = new DrawingPanel();
        controlPanel = new ControlPanel(this);

        add(configPanel, BorderLayout.NORTH);
        add(drawingPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
    public static void main( String[] args )
    {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
