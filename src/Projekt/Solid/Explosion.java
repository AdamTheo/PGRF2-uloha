package Projekt.Solid;

import Projekt.model.Part;
import Projekt.model.Vertex;
import transforms.Col;

import java.util.ArrayList;

public class Explosion extends Solid {

    public Explosion(){
        VB = new ArrayList<Vertex>();
        IB = new ArrayList<Integer>();
        PB = new ArrayList<Part>();

        VB.add(new Vertex(0.0f, 0.0f, 0.0f, new Col(0xff0000)));
        VB.add(new Vertex(-0.0342f, 0.0491f, -0.0257f, new Col(0xff0e00)));
        VB.add(new Vertex(0.1000f, 0.0153f, -0.0314f, new Col(0xe67b00)));

        VB.add(new Vertex(0.0f, 0.0f, 0.0f, new Col(0xff0000)));
        VB.add(new Vertex(0.0295f, -0.0412f, 0.0376f, new Col(0xff0e00)));
        VB.add(new Vertex(0.1000f, -0.0201f, 0.0298f, new Col(0xe67b00)));

        VB.add(new Vertex(0.0f, 0.0f, 0.0f, new Col(0xff0000)));
        VB.add(new Vertex(-0.0218f, -0.0383f, 0.0419f, new Col(0xff0e00)));
        VB.add(new Vertex(0.1000f, 0.0327f, 0.0103f, new Col(0xe67b00)));

        VB.add(new Vertex(0.0f, 0.0f, 0.0f, new Col(0xff0000)));
        VB.add(new Vertex(0.0157f, 0.0302f, -0.0391f, new Col(0xff0e00)));
        VB.add(new Vertex(0.1000f, -0.0066f, 0.0221f, new Col(0xe67b00)));

        VB.add(new Vertex(0.0f, 0.0f, 0.0f, new Col(0xff0000)));
        VB.add(new Vertex(-0.0276f, 0.0155f, 0.0447f, new Col(0xff0e00)));
        VB.add(new Vertex(0.1000f, 0.0059f, -0.0192f, new Col(0xe67b00)));

        VB.add(new Vertex(0.0f, 0.0f, 0.0f, new Col(0xff0000)));
        VB.add(new Vertex(0.0319f, -0.0191f, -0.0365f, new Col(0xff0e00)));
        VB.add(new Vertex(0.1000f, 0.0257f, 0.0334f, new Col(0xe67b00)));

        VB.add(new Vertex(0.0f, 0.0f, 0.0f, new Col(0xff0000)));
        VB.add(new Vertex(-0.0178f, -0.0432f, -0.0143f, new Col(0xff0e00)));
        VB.add(new Vertex(0.1000f, -0.0149f, 0.0277f, new Col(0xe67b00)));

        VB.add(new Vertex(0.0f, 0.0f, 0.0f, new Col(0xff0000)));
        VB.add(new Vertex(0.0355f, 0.0124f, 0.0308f, new Col(0xff0e00)));
        VB.add(new Vertex(0.1000f, -0.0082f, -0.0156f, new Col(0xe67b00)));

        VB.add(new Vertex(0.0f, 0.0f, 0.0f, new Col(0xff0000)));
        VB.add(new Vertex(-0.0401f, 0.0276f, -0.0174f, new Col(0xff0e00)));
        VB.add(new Vertex(0.1000f, 0.0133f, 0.0367f, new Col(0xe67b00)));

        VB.add(new Vertex(0.0f, 0.0f, 0.0f, new Col(0xff0000)));
        VB.add(new Vertex(0.0203f, -0.0335f, 0.0409f, new Col(0xff0e00)));
        VB.add(new Vertex(0.1000f, -0.0221f, -0.0265f, new Col(0xe67b00)));

        IB.add(0);
        IB.add(1);
        IB.add(2);
        IB.add(3);
        IB.add(4);
        IB.add(5);
        IB.add(6);
        IB.add(7);
        IB.add(8);
        IB.add(9);
        IB.add(10);
        IB.add(11);
        IB.add(12);
        IB.add(13);
        IB.add(14);
        IB.add(15);
        IB.add(16);
        IB.add(17);
        IB.add(18);
        IB.add(19);
        IB.add(20);
        IB.add(21);
        IB.add(22);
        IB.add(23);
        IB.add(24);
        IB.add(25);
        IB.add(26);
        IB.add(27);
        IB.add(28);
        IB.add(29);



        PB.add(new Part("Triangles",0,10));



    }
}
