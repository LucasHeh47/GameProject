package com.LucasJ.GameProject.Math;

import java.awt.Dimension;

public class Vector2D {

    public double x, y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Add vectors
    public Vector2D add(Vector2D v) {
        return new Vector2D(this.x + v.x, this.y + v.y);
    }
    public Vector2D addX(double v) {
        return new Vector2D(this.x + v, this.y);
    }
    public Vector2D addY(double v) {
        return new Vector2D(this.x, this.y + v);
    }

    // Subtract vectors
    public Vector2D subtract(Vector2D v) {
        return new Vector2D(this.x - v.x, this.y - v.y);
    }
    public Vector2D subtractX(double v) {
        return new Vector2D(this.x - v, this.y);
    }
    public Vector2D subtractY(double v) {
        return new Vector2D(this.x, this.y - v);
    }

    // Multiply vector by a scalar
    public Vector2D multiply(double scalar) {
        return new Vector2D(this.x * scalar, this.y * scalar);
    }

    // Dot product of two vectors
    public double dot(Vector2D v) {
        return this.x * v.x + this.y * v.y;
    }

    // Get the magnitude (length) of the vector
    public double magnitude() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    // Normalize the vector (make its magnitude equal to 1)
    public Vector2D normalize() {
        double magnitude = magnitude();
        return new Vector2D(this.x / magnitude, this.y / magnitude);
    }

    // Return a new vector that's perpendicular to this one
    public Vector2D perpendicular() {
        return new Vector2D(-this.y, this.x);
    }
    
    public Dimension toDimension() {
        return new Dimension((int) x, (int) y);
    }

    @Override
    public String toString() {
        return "Vector2D(" + x + ", " + y + ")";
    }
}
