package Projekt.Solid;

import Projekt.model.Part;
import Projekt.model.Vertex;
import transforms.Col;

import java.util.ArrayList;

public class Explosion extends Solid {

    public Explosion() {
        VB = new ArrayList<Vertex>();
        IB = new ArrayList<Integer>();
        PB = new ArrayList<Part>();

        VB.add(new Vertex(-0.0157f, 0.0282f, -0.0073f, new Col(0xff0000)));
        VB.add(new Vertex(0.0149f, -0.0361f, 0.0417f, new Col(0xff0e00)));
        VB.add(new Vertex(0.1000f, -0.0051f, 0.0303f, new Col(0xe67b00)));

        VB.add(new Vertex(0.0198f, -0.0216f, 0.0152f, new Col(0xff0000)));
        VB.add(new Vertex(-0.0237f, 0.0419f, -0.0458f, new Col(0xff0e00)));
        VB.add(new Vertex(0.1000f, 0.0194f, -0.0341f, new Col(0xe67b00)));

        VB.add(new Vertex(0.0052f, -0.0347f, -0.0139f, new Col(0xff0000)));
        VB.add(new Vertex(0.0301f, 0.0395f, 0.0293f, new Col(0xff0e00)));
        VB.add(new Vertex(0.1000f, 0.0121f, 0.0177f, new Col(0xe67b00)));

        VB.add(new Vertex(-0.0224f, 0.0156f, 0.0452f, new Col(0xff0000)));
        VB.add(new Vertex(0.0273f, -0.0284f, -0.0362f, new Col(0xff0e00)));
        VB.add(new Vertex(0.1000f, -0.0167f, -0.0269f, new Col(0xe67b00)));

        VB.add(new Vertex(0.0181f, -0.0298f, 0.0195f, new Col(0xff0000)));
        VB.add(new Vertex(-0.0354f, 0.0231f, -0.0407f, new Col(0xff0e00)));
        VB.add(new Vertex(0.1000f, 0.0169f, -0.0186f, new Col(0xe67b00)));

        VB.add(new Vertex(-0.0103f, 0.0196f, -0.0421f, new Col(0xff0000)));
        VB.add(new Vertex(0.0367f, -0.0333f, 0.0314f, new Col(0xff0e00)));
        VB.add(new Vertex(0.1000f, 0.0045f, 0.0256f, new Col(0xe67b00)));

        VB.add(new Vertex(-0.0312f, -0.0114f, 0.0229f, new Col(0xff0000)));
        VB.add(new Vertex(0.0293f, 0.0275f, -0.0276f, new Col(0xff0e00)));
        VB.add(new Vertex(0.1000f, -0.0097f, -0.0205f, new Col(0xe67b00)));

        VB.add(new Vertex(0.0129f, 0.0307f, 0.0358f, new Col(0xff0000)));
        VB.add(new Vertex(-0.0248f, -0.0355f, -0.0331f, new Col(0xff0e00)));
        VB.add(new Vertex(0.1000f, -0.0142f, -0.0287f, new Col(0xe67b00)));

        VB.add(new Vertex(-0.0201f, 0.0219f, -0.0302f, new Col(0xff0000)));
        VB.add(new Vertex(0.0327f, -0.0223f, 0.0379f, new Col(0xff0e00)));
        VB.add(new Vertex(0.1000f, 0.0078f, 0.0146f, new Col(0xe67b00)));

        VB.add(new Vertex(0.0163f, -0.0271f, -0.0387f, new Col(0xff0000)));
        VB.add(new Vertex(-0.0305f, 0.0346f, 0.0262f, new Col(0xff0e00)));
        VB.add(new Vertex(0.1000f, -0.0111f, 0.0219f, new Col(0xe67b00)));

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


        PB.add(new Part("Triangles", 0, 10));


    }
}
