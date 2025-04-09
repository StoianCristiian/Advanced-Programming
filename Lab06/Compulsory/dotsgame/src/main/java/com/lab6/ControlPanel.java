package com.lab6;

import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {
    private final MainFrame frame;
    private final JButton loadButton, saveButton, exitButton, resetButton, exportButton;

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        setLayout(new FlowLayout());
        
        loadButton = new JButton("Load");
        saveButton = new JButton("Save");
        exitButton = new JButton("Exit");
        resetButton = new JButton("Reset");
        exportButton = new JButton("Export PNG");

        exitButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        resetButton.addActionListener((ActionEvent e) -> {
            frame.drawingPanel.clearBoard();
        });

        saveButton.addActionListener(e -> {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("game.ser"))) {
                out.writeObject(frame.drawingPanel.getDots());
                out.writeObject(frame.drawingPanel.getLines());
                out.writeBoolean(frame.drawingPanel.isPlayerOneTurn());
                System.out.println("Game saved!");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        loadButton.addActionListener(e -> {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("game.ser"))) {
                ArrayList<Point> dots = (ArrayList<Point>) in.readObject();
                ArrayList<Line> lines = (ArrayList<Line>) in.readObject();
                boolean turn = in.readBoolean();
                frame.drawingPanel.setGameState(dots, lines, turn);
                System.out.println("Game loaded!");
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        });

        exportButton.addActionListener(e -> {
            frame.drawingPanel.saveAsPNG("D:/Facultate/AP/Lab06/Compulsory/dotsgame/src/main/java/com/lab6/images/GameSave.png");
        });

        add(exportButton);
        add(loadButton);
        add(saveButton);
        add(resetButton);
        add(exitButton);
    }
}
