package org.springmeyer;

public class Point {
  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public Point clone() {
    return new Point(this.x, this.y);
  }
}