import java.util.ArrayList;

import java.util.Arrays;

/**
 *
 * @author Anji Xu
 */
public class BruteCollinearPoints {

    private LineSegment[] segments;

    public BruteCollinearPoints(Point[] points) {
        if (points == null) {
            throw new NullPointerException();
        }
        checkNullEntries(points);
        ArrayList<LineSegment> segmentsList = new ArrayList<LineSegment>();
        int num = points.length;
        Point[] clone =  Arrays.copyOf(points, num);
        Arrays.sort(clone);
        checkDuplicatedEntries(clone);
        for (int i = 0; i < num-3; i++) {
            for (int j = i + 1; j < num-2; j++) {
                for (int k = j + 1; k < num-1; k++) {
                    for (int l = k + 1; l < num; l++) {
                        Point p = clone[i];
                        Point q = clone[j];
                        Point r = clone[k];
                        Point s = clone[l];
                        if (p.slopeTo(q) == p.slopeTo(r) && p.slopeTo(q) == p.slopeTo(s)) {
                            LineSegment tempLineSegment = new LineSegment(clone[i], clone[l]);
                            if (!segmentsList.contains(tempLineSegment)) {
                                segmentsList.add(tempLineSegment);
                            }

                        }
                    }
                }
            }
        }
        segments = segmentsList.toArray(new LineSegment[segmentsList.size()]);
    }

    public int numberOfSegments() {
        return segments.length;
    }

    public LineSegment[] segments() {
        return segments;
    }

    private void checkDuplicatedEntries(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i].compareTo(points[i + 1]) == 0) {
                throw new IllegalArgumentException("Duplicated entries in given points");
            }
        }
    }

    private void checkNullEntries(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i] == null) {
                throw new java.lang.NullPointerException("One of the point in points array is null");
            }
        }
    }

}
