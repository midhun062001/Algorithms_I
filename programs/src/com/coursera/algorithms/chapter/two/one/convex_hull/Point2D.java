package com.coursera.algorithms.chapter.two.one.convex_hull;

import java.util.Comparator;

public class Point2D {
    private double x;
    private double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static int ccw(Point2D a, Point2D b, Point2D c) {
        double area2 = (b.x - a.x) * (c.y - a.y)
                - (b.y - a.y) * (c.x - a.x);

        if (area2 < 0)
            return -1; // clockwise
        else if (area2 > 0)
            return 1; // counter clockwise
        else
            return 0; // collinear
    }

    public static Comparator<Point2D> polarOrder(Point2D origin) {
        return (p1,p2) -> Point2D.ccw(origin, p2, p1); // sort by increasing polar order
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return String.format("(%.2f,%.2f)", this.x, this.y);
    }
}
