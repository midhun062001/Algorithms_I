package com.coursera.algorithms.chapter.two.one.convex_hull;

import java.util.Arrays;
import edu.princeton.cs.algs4.ResizingArrayStack;

public class GrahamScan {

    public static Point2D[] convexHull(Point2D[] points) {
        if (points == null || points.length == 0) return new Point2D[]{};
        if (points.length <= 2) return points.clone();

        // Remove duplicates
        points = Arrays.stream(points).distinct().toArray(Point2D[]::new);

        // Step 1: Find the point with the lowest y (pivot)
        Arrays.sort(points, (p1, p2) -> Double.compare(p1.getY(), p2.getY()));

        // Step 2: Sort points by polar angle w.r.t pivot
        Arrays.sort(points, Point2D.polarOrder(points[0]));

        // Step 3: Handle collinear points at the start by keeping farthest
        int k1 = 1;
        for (int i = 1; i < points.length; i++) {
            while (i < points.length - 1 && Point2D.ccw(points[0], points[i], points[i + 1]) == 0) {
                i++; // skip points that are collinear with pivot
            }
            points[k1++] = points[i];
        }
        if (k1 < 3) return Arrays.copyOf(points, k1); // All points collinear

        // Step 4: Graham scan
        ResizingArrayStack<Point2D> hull = new ResizingArrayStack<>();
        hull.push(points[0]);
        hull.push(points[1]);
        hull.push(points[2]);

        for (int i = 3; i < k1; i++) {
            Point2D top = hull.pop();
            while (Point2D.ccw(hull.peek(), top, points[i]) <= 0) {
                top = hull.pop();
            }
            hull.push(top);
            hull.push(points[i]);
        }

        // Step 5: Convert stack to array
        Point2D[] result = new Point2D[hull.size()];
        int index = 0;
        for (Point2D p : hull) {
            result[index++] = p;
        }

        return result;
    }

    public static void main(String[] args) {
        Point2D[] points = {
            new Point2D(2, 5),
            new Point2D(1, 1),
            new Point2D(3, 3),
            new Point2D(5, 3),
            new Point2D(3, 2),
            new Point2D(2, 2),
            new Point2D(1, 1) // duplicate
        };

        Point2D[] hull = convexHull(points);

        System.out.println("Convex Hull:");
        for (Point2D p : hull) {
            System.out.println(p);
        }
    }
}
