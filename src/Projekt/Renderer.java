package Projekt;


import Projekt.global.AbstractRenderer;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWScrollCallback;
import org.lwjgl.glfw.GLFWWindowSizeCallback;

import static Projekt.global.GluUtils.gluLookAt;
import static Projekt.global.GluUtils.gluPerspective;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F;
import static org.lwjgl.opengl.GL11.*;
import Projekt.model.Tank;
import Projekt.model.Vertex;
import Projekt.model.Floor;

import java.util.ArrayList;
import java.util.List;

public class Renderer extends AbstractRenderer {
    int angle;
    float tankX = 0.2f;
    float tankY = 0.1f;
    float  tankZ = 0;
    Tank tank;
    Floor floor;




    public Renderer() {
        super();
        int angle = 0;




        Boolean keyDown = false; //For looping glwfkeyCallback

        tank = new Tank();
        floor = new Floor();

        glfwKeyCallback = new GLFWKeyCallback() {
            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
                if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE)

                    glfwSetWindowShouldClose(window, true);
                if (action == GLFW_RELEASE) {

                }
                if (action == GLFW_PRESS) {

                    switch (key) {
                        case GLFW_KEY_W: // body - points
                                tankX +=0.05f;
                            break;
                        case GLFW_KEY_S: // Cary - lines
                            tankX += -0.05f;
                            break;
                        case GLFW_KEY_A: // Steny - faces
                            tankY +=0.05f;
                            break;
                        case GLFW_KEY_D: // Steny - faces
                            tankY += -0.05f;
                            break;
                    }
                }
            }
        };
    }

    @Override
    public void init() {
        glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        glEnable(GL_DEPTH_TEST);
    }

    public void drawAxes(){
        glBegin(GL_LINES);
        glColor3f(1.0f, 0.0f, 0.0f);
        glVertex3f(0.0f, 0.0f,0.0f);
        glVertex3f(1f, 0.0f,0.0f);

        glColor3f(0.0f, 1.0f, 0.0f);
        glVertex3f(0.0f,0.0f,0.0f);
        glVertex3f(0.0f,1.0f,0.0f);

        glColor3f(0.0f, 0.0f, 1.0f);
        glVertex3f(0.0f,0.0f,0.0f);
        glVertex3f(0.0f,0.0f,1.0f);
        glEnd();



    }

    public void drawSolid(List <Vertex> vertexBuffer,List <Integer> indexBuffer){
        glBegin(GL_TRIANGLES);
        for(int i = 0; i < indexBuffer.size() ; i+=3){
            Vertex a = vertexBuffer.get(indexBuffer.get(i));
            Vertex b  = vertexBuffer.get(indexBuffer.get(i+1));
            Vertex c = vertexBuffer.get(indexBuffer.get(i+2));

            glColor3f((float)a.getCol().getR(),(float)a.getCol().getB(),(float)a.getCol().getB());
            glVertex3f(a.getX(),a.getY(),a.getZ());

            glColor3f((float)b.getCol().getR(),(float)b.getCol().getB(),(float)b.getCol().getB());
            glVertex3f(b.getX(),b.getY(),b.getZ());

            glColor3f((float)c.getCol().getR(),(float)c.getCol().getB(),(float)c.getCol().getB());
            glVertex3f(c.getX(),c.getY(),c.getZ());

        }
        glEnd();
    }

    @Override
    public void display() {

        glViewport(0, 0, width, height);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
        angle = angle % 360;

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        gluPerspective(45, width / (float) height, 0.1f, 200.0f);



        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
        gluLookAt(1.3f, 1.3f, 0.9f, tankX, tankY, tankZ, 0, 0, 1);
        glPushMatrix();

        drawAxes();
        drawSolid(floor.getVB(),floor.getIB()); // Drawing Floor

        glTranslatef(tankX, tankY, tankZ+0.11f);
        drawSolid(tank.getVB(),tank.getIB());






    }



}
