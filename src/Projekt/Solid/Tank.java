package Projekt.Solid;

import Projekt.model.Part;
import Projekt.model.Vertex;
import transforms.Col;

import java.util.ArrayList;

public class Tank extends Solid {



    public Tank() {
        VB = new ArrayList<Vertex>();
        IB = new ArrayList<Integer>();
        PB = new ArrayList<Part>();
        //Tracks on one side
        VB.add(new Vertex(-0.1f,0.15f,0f,new Col(0x000000)));
        VB.add(new Vertex(0.1f,0.15f,0f,new Col(0x000000)));
        VB.add(new Vertex(0.1f,0.1f,0f,new Col(0x000000)));
        VB.add(new Vertex(-0.1f,0.1f,0f,new Col(0x000000)));

        VB.add(new Vertex(-0.15f,0.15f,0.1f,new Col(0x000000)));
        VB.add(new Vertex(0.15f,0.15f,0.1f,new Col(0x000000)));
        VB.add(new Vertex(0.15f,0.1f,0.1f,new Col(0x000000)));
        VB.add(new Vertex(-0.15f,0.1f,0.1f,new Col(0x000000)));

        //Tracks on second side
        VB.add(new Vertex(-0.1f,-0.15f,0f,new Col(0x000000)));
        VB.add(new Vertex(0.1f,-0.15f,0f,new Col(0x000000)));
        VB.add(new Vertex(0.1f,-0.1f,0f,new Col(0x000000)));
        VB.add(new Vertex(-0.1f,-0.1f,0f,new Col(0x000000)));

        VB.add(new Vertex(-0.15f,-0.15f,0.1f,new Col(0x000000)));
        VB.add(new Vertex(0.15f,-0.15f,0.1f,new Col(0x000000)));
        VB.add(new Vertex(0.15f,-0.1f,0.1f,new Col(0x000000)));
        VB.add(new Vertex(-0.15f,-0.1f,0.1f,new Col(0x000000)));


        //First side of tracks
        IB.add(0);
        IB.add(4);
        IB.add(1);
        IB.add(5);
        IB.add(2);
        IB.add(6);
        IB.add(3);
        IB.add(7);
        IB.add(0);
        IB.add(4);

        PB.add(new Part("TriangeStrips",0,10));
        //Top side of first tracks
        IB.add(4);
        IB.add(7);
        IB.add(5);
        IB.add(6);
        PB.add(new Part("TriangeStrips",10,4));

        //Second side of tracks
        IB.add(8);
        IB.add(12);
        IB.add(9);
        IB.add(13);
        IB.add(10);
        IB.add(14);
        IB.add(11);
        IB.add(15);
        IB.add(8);
        IB.add(12);

        PB.add(new Part("TriangeStrips",14,10));
        //Top side of first tracks
        IB.add(12);
        IB.add(15);
        IB.add(13);
        IB.add(14);
        PB.add(new Part("TriangeStrips",24,4));

        //Uper part-lower deck
        VB.add(new Vertex(-0.15f,0.15f,0.1f,new Col(0x255934)));
        VB.add(new Vertex(0.15f,0.15f,0.1f,new Col(0x255934)));

        VB.add(new Vertex(0.15f,-0.15f,0.1f,new Col(0x255934)));
        VB.add(new Vertex(-0.15f,-0.15f,0.1f,new Col(0x255934)));


        //Upper part-upper deck
        VB.add(new Vertex(-0.07f,0.07f,0.12f,new Col(0x269947)));
        VB.add(new Vertex(0.07f,0.07f,0.12f,new Col(0x269947)));

        VB.add(new Vertex(0.07f,-0.07f,0.12f,new Col(0x269947)));
        VB.add(new Vertex(-0.07f,-0.07f,0.12f,new Col(0x269947)));

        IB.add(16);
        IB.add(20);
        IB.add(17);
        IB.add(21);
        IB.add(18);
        IB.add(22);
        IB.add(19);
        IB.add(23);
        IB.add(16);
        IB.add(20);

        PB.add(new Part("TriangeStrips",28,10));

        //Top
        IB.add(21);
        IB.add(20);
        IB.add(22);
        IB.add(23);

        PB.add(new Part("TriangeStrips",38,4));
    }





}


