package Projekt.model;

import transforms.Col;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    List<Vertex> VB;
    List <Integer> IB;

    public Floor() {
        VB = new ArrayList<Vertex>();
        VB.add(new Vertex(-5,-5,-0.01f,new Col(0x555555)));
        VB.add(new Vertex( 5,-5,-0.01f,new Col(0x555555)));
        VB.add(new Vertex(-5,5,-0.01f,new Col(0x555555)));
        VB.add(new Vertex(5,5,-0.01f,new Col(0x555555)));

        IB = new ArrayList<Integer>();
        IB.add(0);
        IB.add(1);
        IB.add(2);
        IB.add(1);
        IB.add(2);
        IB.add(3);
    }
    public List<Integer> getIB() {
        return IB;
    }
    public List <Vertex> getVB() {
        return VB;
    }
}
