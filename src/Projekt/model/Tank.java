package Projekt.model;

import transforms.Col;

import java.util.ArrayList;
import java.util.List;

public class Tank {

    List<Vertex> VB;
    List <Integer> IB;

    public Tank() {
        VB = new ArrayList<Vertex>();
        IB = new ArrayList<>();

        VB.add(new Vertex(-0.2f,-0.1f,-0.1f,new Col(0x00ffff)));
        VB.add(new Vertex(0.2f,-0.1f,-0.1f,new Col(0xff00ff)));
        VB.add(new Vertex(-0.2f,0.1f,-0.1f,new Col(0xffff00)));
        VB.add(new Vertex(0.2f,0.1f,-0.1f,new Col(0xffffff)));
        VB.add(new Vertex(-0.2f,-0.1f,0.1f,new Col(0xffffff)));
        VB.add(new Vertex(0.2f,-0.1f,0.1f,new Col(0xffffff)));
        VB.add(new Vertex(-0.2f,0.1f,0.1f,new Col(0xffffff)));
        VB.add(new Vertex(0.2f,0.1f,0.1f,new Col(0xffffff)));
        //Spodek
        IB.add(0);
        IB.add(1);
        IB.add(2);
        IB.add(1);
        IB.add(2);
        IB.add(3);
        //Horejsek
        IB.add(4);
        IB.add(5);
        IB.add(6);
        IB.add(5);
        IB.add(6);
        IB.add(7);
        //Predni strana
        IB.add(0);
        IB.add(1);
        IB.add(4);
        IB.add(5);
        IB.add(1);
        IB.add(4);
        //Zadni strana
        IB.add(2);
        IB.add(3);
        IB.add(7);
        IB.add(6);
        IB.add(7);
        IB.add(2);
        //Prava strana
        IB.add(1);
        IB.add(4);
        IB.add(7);
        IB.add(7);
        IB.add(5);
        IB.add(1);
        //Leva strana
        IB.add(0);
        IB.add(2);
        IB.add(6);
        IB.add(6);
        IB.add(4);
        IB.add(0);
    }

    public Vertex getVertex(int i) {
        return VB.get(i);
    }
    public List<Integer> getIB() {
        return IB;
    }
    public List <Vertex> getVB() {
        return VB;
    }
}


