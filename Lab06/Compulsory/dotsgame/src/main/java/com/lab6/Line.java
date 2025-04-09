package com.lab6;

import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;

public class Line implements Serializable {
    private final Point start;
    private final Point end;
    private final Color color;

    public Line(Point start, Point end, Color color) {
        this.start = start;
        this.end = end;
        this.color = color;
    }

    public Point getStart() { return start; }
    public Point getEnd() { return end; }
    public Color getColor() { return color; }
}