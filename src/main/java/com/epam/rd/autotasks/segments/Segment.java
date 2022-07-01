package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {
    private final double x1, y1, x2, y2;

    public Segment(Point start, Point end) throws IllegalArgumentException {
        this.x1 = start.getX();
        this.y1 = start.getY();
        this.x2 = end.getX();
        this.y2 = end.getY();
        if (this.x1 == this.x2 && this.y1 == this.y2) {
            throw new IllegalArgumentException();
        }
    }

    double length() {
        return sqrt(pow(x2 - x1, 2.0) + pow(y2 - y1, 2.0));
    }

    Point middle() {
        double x = (x1 + x2) / 2.0;
        double y = (y1 + y2) / 2.0;
        return new Point(x, y);

    }

    Point intersection(Segment another) {
        double x, y;
        if (this.x1 == this.x2 && this.y1 == this.y2) {
            return null;
        } else {
            double k1 = (this.y2 - this.y1) / (this.x2 - this.x1);
            double b1 = this.y1 - k1 * this.x1;
            double k2 = (another.y2 - another.y1) / (another.x2 - another.x1);
            double b2 = another.y1 - k2 * another.x1;
            if (k1 - k2 == 0) {
                return null;
            } else {
                x = (b1 - b2) / (k2 - k1);
                y = k1 * x + b1;
            }
            if (x>Math.max(this.x1,this.x2)||x>Math.max(another.x1,another.x2)||x<Math.min(this.x1,this.x2)||x<Math.min(another.x1,another.x2)||y>Math.max(this.y1,this.y2)||y>Math.max(another.y1,another.y2)||y<Math.min(this.y1,this.y2)||y<Math.min(another.y1,another.y2)) {
                return null;
            }
        }
        return new Point(x,y);
    }
}








