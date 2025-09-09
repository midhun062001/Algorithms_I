package com.coursera.algorithms.chapter.two.one.convex_hull;

import java.util.Comparator;

public class PointPolarComparator implements Comparator<Point2D>{
    private final Point2D origin;

    public PointPolarComparator(Point2D origin) {
        this.origin = origin;
    }

    @Override
    public int compare(Point2D p1, Point2D p2) {
        return Point2D.ccw(origin, p1, p2);
    }

}
