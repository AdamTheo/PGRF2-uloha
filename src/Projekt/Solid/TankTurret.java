package Projekt.Solid;

import Projekt.model.Part;
import Projekt.model.Vertex;
import transforms.Col;

import java.util.ArrayList;

public class TankTurret extends Solid {

    public TankTurret() {
        VB = new ArrayList<Vertex>();
        IB = new ArrayList<Integer>();
        PB = new ArrayList<Part>();

        VB.add(new Vertex(-0.06f, 0.06f, 0.12f, new Col(0x376932)));
        VB.add(new Vertex(0.06f, 0.06f, 0.12f, new Col(0x376932)));

        VB.add(new Vertex(0.06f, -0.06f, 0.12f, new Col(0x376932)));
        VB.add(new Vertex(-0.06f, -0.06f, 0.12f, new Col(0x376932)));


        VB.add(new Vertex(-0.06f, 0.06f, 0.15f, new Col(0x376932)));
        VB.add(new Vertex(0.02f, 0.06f, 0.15f, new Col(0x376932)));

        VB.add(new Vertex(0.02f, -0.06f, 0.15f, new Col(0x376932)));
        VB.add(new Vertex(-0.06f, -0.06f, 0.15f, new Col(0x376932)));

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

        PB.add(new Part("TriangeStrips", 0, 10));

        IB.add(5);
        IB.add(4);
        IB.add(6);
        IB.add(7);

        PB.add(new Part("TriangeStrips", 10, 4));

        //Cannon
        VB.add(new Vertex(-0.06f, 0.02f, 0.125f, new Col(0x376932)));
        VB.add(new Vertex(0.15f, 0.02f, 0.125f, new Col(0x376932)));

        VB.add(new Vertex(0.15f, -0.02f, 0.125f, new Col(0x376932)));
        VB.add(new Vertex(-0.06f, -0.02f, 0.125f, new Col(0x376932)));

        VB.add(new Vertex(-0.06f, 0.02f, 0.145f, new Col(0x376932)));
        VB.add(new Vertex(0.15f, 0.02f, 0.145f, new Col(0x376932)));

        VB.add(new Vertex(0.15f, -0.02f, 0.145f, new Col(0x376932)));
        VB.add(new Vertex(-0.06f, -0.02f, 0.145f, new Col(0x376932)));

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

        PB.add(new Part("TriangeStrips", 14, 10));
        //Upper deck
        IB.add(13);
        IB.add(12);
        IB.add(10);
        IB.add(11);
        PB.add(new Part("TriangeStrips", 24, 4));
        //Lower deck
        IB.add(9);
        IB.add(8);
        IB.add(10);
        IB.add(11);
        PB.add(new Part("TriangeStrips", 28, 4));
    }
}
