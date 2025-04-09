package com.lab6;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
    private final ArrayList<Point> dots = new ArrayList<>();
    private final ArrayList<Line> lines = new ArrayList<>();

    private final Random random = new Random();
    private boolean isPlayerOneTurn = true;
    private Point firstDot = null;

    public DrawingPanel() {
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
                Point clicked = getDotAt(e.getPoint());
                // System.out.println(clicked);
                if(firstDot == null){
                    firstDot = clicked;
                }
                else if(!firstDot.equals(clicked)) {
                    Color color = isPlayerOneTurn ? Color.RED : Color.BLUE;
                    lines.add(new Line(firstDot, clicked, color));
                    firstDot = null;
                    isPlayerOneTurn = !isPlayerOneTurn;
                    repaint();
                }
            }
        });
    }

    public void saveAsPNG(String filePath) {
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        paint(g2d); 
        g2d.dispose();
        try {
            ImageIO.write(image, "png", new File(filePath));
            System.out.println("Board exported to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Point getDotAt(Point p) {
        for (Point dot : dots) {
            if (p.distance(dot) < 10) return dot;
        }
        return null;
    }

    public void generateDots(int numDots) {
        dots.clear();
        for (int i = 0; i < numDots; i++) {
            int x = random.nextInt(getWidth() - 20) + 10;
            int y = random.nextInt(getHeight() - 20) + 10;
            dots.add(new Point(x, y));
        }
        repaint();
    }

    public void setGameState(ArrayList<Point> loadedDots, ArrayList<Line> loadedLines, boolean isPlayerOneTurn) {
        dots.clear();
        dots.addAll(loadedDots);
    
        lines.clear();
        lines.addAll(loadedLines);
    
        this.isPlayerOneTurn = isPlayerOneTurn;
    
        repaint(); 
    }

    public int getDotSize()
    {
        int dot_size = dots.size();
        int cnt = 0;
        while(dot_size>9)
        {
            cnt++;
            dot_size/=10;
        }
        return cnt;
    }

    void clearBoard() {
        dots.clear();
        lines.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        int dot_size = this.getDotSize();
        for (Point dot : dots) {
            g.fillOval(dot.x - 5, dot.y - 5, 11-dot_size, 11-dot_size);
        }

        for(Line line : lines)
        {
            g.setColor(line.getColor());
            g.drawLine(line.getStart().x, line.getStart().y, line.getEnd().x, line.getEnd().y);
        }
    }

    public ArrayList<Point> getDots() {return new ArrayList<>(dots);}
    public ArrayList<Line> getLines() {return new ArrayList<>(lines);}
    public boolean isPlayerOneTurn() {return isPlayerOneTurn;}
}