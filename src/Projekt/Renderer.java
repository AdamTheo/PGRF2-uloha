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
import Projekt.model.Solid;
import Projekt.model.Part;

import java.util.ArrayList;
import java.util.List;

public class Renderer extends AbstractRenderer {
    float angle;
    float velocity = 0;
    //Tank configurable parameters
    float acceleration = 0.00005f;
    float max_min_speed = 0.009f;
    float braking = 0.00002f;
    float rotatinspeed = 0.5f;
    //End of configurable parameters
    float tankX = 0.2f;
    float tankY = 0.1f;
    float  tankZ = 0;
    Tank tank;
    Floor floor;
    boolean Wpressed = false;
    boolean Spressed = false;
    boolean Apressed = false;
    boolean Dpressed = false;


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
                    switch (key) {
                        case GLFW_KEY_W: // body - points
                            Wpressed = false;
                            break;
                        case GLFW_KEY_S: // Cary - lines
                            Spressed = false;
                            break;
                        case GLFW_KEY_A: // Steny - faces
                            Apressed = false;
                            break;
                        case GLFW_KEY_D: // Steny - faces
                            Dpressed = false;
                            break;
                    }

                }
                if (action == GLFW_PRESS) {

                    switch (key) {
                        case GLFW_KEY_W:
                            Wpressed = true;
                            break;
                        case GLFW_KEY_S:
                            Spressed = true;
                            break;
                        case GLFW_KEY_A:
                            Apressed = true;
                            break;
                        case GLFW_KEY_D:
                            Dpressed = true;
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
    public void drawSolid(Solid solid){
        for(int p = 0; p < solid.getPB().size(); p++){ // Geting part from partbuffer
            Part part = solid.getPB().get(p);
            int start = part.getStart();
            int length = part.getLength();
            String type = part.getName();
            List <Vertex> vertexBuffer = solid.getVB();
            List <Integer> indexBuffer = solid.getIB();

            if(type.equals("Triangles")){
                glBegin(GL_TRIANGLES);
                for(int i = 0; i < length ; i++){
                    Vertex a = vertexBuffer.get(indexBuffer.get(start + i*3));
                    Vertex b  = vertexBuffer.get(indexBuffer.get(start + i*3 +1));
                    Vertex c = vertexBuffer.get(indexBuffer.get(start + i*3 +2));

                    glColor3f((float)a.getCol().getR(),(float)a.getCol().getB(),(float)a.getCol().getB());
                    glVertex3f(a.getX(),a.getY(),a.getZ());

                    glColor3f((float)b.getCol().getR(),(float)b.getCol().getB(),(float)b.getCol().getB());
                    glVertex3f(b.getX(),b.getY(),b.getZ());

                    glColor3f((float)c.getCol().getR(),(float)c.getCol().getB(),(float)c.getCol().getB());
                    glVertex3f(c.getX(),c.getY(),c.getZ());

                }
                glEnd();
            }
        }
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

    public void movement(){

        if(Apressed && !Dpressed){
            angle += rotatinspeed;
        }
        if(!Apressed && Dpressed){
            angle -= rotatinspeed;
        }

        if(Wpressed && !Spressed){
            velocity += acceleration;
            if (velocity >= max_min_speed){
                velocity = max_min_speed;
            }
            if(velocity < 0){
                velocity += acceleration *3;
            }// Stronger breaking
        }

        if(!Wpressed && Spressed){
            velocity -= acceleration;
            if (velocity <= -max_min_speed){
                velocity = -max_min_speed;
            }
            if(velocity > 0){
                velocity -= acceleration *3;
            }// Stronger breaking
        }

        if(!Wpressed && !Spressed){
            if(velocity > 0){
                velocity -= braking;
            }
            if(velocity < 0){
                velocity += braking;
            }
        }


        //Angles and moving forward in specific direction
        if(angle >= 360){
            angle = 0;
        }
        if(angle < 0){
            angle = 359.95f;
        }

        //There sure is better solution, but I came up with this.
        if(angle <=90){
            float yratio = (float)angle / 90;
            float xratio = 1 - yratio;

            tankX = tankX + xratio*velocity;
            tankY = tankY + yratio*velocity;
        }
        if(angle > 90 && angle <=180){
            float xratio = ((float)angle - 90)/90;
            float yratio = 1 - xratio;
            tankX = tankX - xratio*velocity;
            tankY = tankY + yratio*velocity;
        }
        if(angle > 180 && angle <=270){
            float yratio = ((float)angle-180)/90;
            float xratio = 1 - yratio;
            tankX = tankX - xratio*velocity;
            tankY = tankY - yratio*velocity;
        }
        if(angle > 270 && angle <=360){
            float xratio = ((float)angle - 270)/90;
            float yratio = 1 - xratio;
            tankX = tankX + xratio*velocity;
            tankY = tankY - yratio*velocity;
        }

    }

    @Override
    public void display() {

        glViewport(0, 0, width, height);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        gluPerspective(45, width / (float) height, 0.1f, 200.0f);



        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
        gluLookAt(1.3f, 1.3f, 0.9f, tankX, tankY, tankZ, 0, 0, 1);
        glPushMatrix();

        drawAxes();
        drawSolid(floor.getVB(),floor.getIB()); // Drawing Floor

        movement();
        glTranslatef(tankX, tankY, tankZ+0.11f);
        glRotatef(angle,0,0,1);
        Solid tank2 = new Tank();
        drawSolid(tank2);
        //drawSolid(tank.getVB(),tank.getIB());






    }



}
