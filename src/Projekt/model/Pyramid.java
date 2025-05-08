package Projekt.model;

import transforms.Col;

import java.util.ArrayList;

public class Pyramid extends Solid {

    public Pyramid(){
    VB = new ArrayList<Vertex>();
    IB = new ArrayList<Integer>();
    PB = new ArrayList<Part>();

    VB.add(new Vertex(-0.1f,-0.1f,0,new Col(0x151515)));
    VB.add(new Vertex(0.1f,-0.1f,0,new Col(0x151515)));
    VB.add(new Vertex(0f,0.1f,0,new Col(0x151515)));
    VB.add(new Vertex(0.0f,0f,0.1f,new Col(0x151515)));

    IB.add(0);
    IB.add(3);
    IB.add(1);
    IB.add(2);


    }
}
