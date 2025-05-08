package Projekt.model;

import java.util.List;

public abstract class Solid {
    protected List<Vertex> VB;
    protected List <Integer> IB;
    protected List <Part> PB;


    public Vertex getVertex(int i) {
        return VB.get(i);
    }
    public List<Integer> getIB() {
        return IB;
    }
    public List <Vertex> getVB() {
        return VB;
    }
    public List <Part> getPB() { return PB; }
}
