package Projekt.model;

import transforms.Col;

public class Vertex {

    float x, y, z;
    Col col;

    public Vertex(float x, float y, float z, Col col) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.col = col;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public Col getCol() {
        return col;
    }
}
