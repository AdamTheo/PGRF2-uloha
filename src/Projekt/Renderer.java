package Projekt;


import Projekt.Solid.Explosion;
import Projekt.Solid.Solid;
import Projekt.Solid.Tank;
import Projekt.Solid.TankTurret;
import Projekt.global.AbstractRenderer;
import Projekt.model.Part;
import Projekt.model.Vertex;
import lwjglutils.OGLTexture2D;
import org.lwjgl.glfw.GLFWKeyCallback;

import java.io.IOException;
import java.util.List;

import static Projekt.global.GluUtils.gluLookAt;
import static Projekt.global.GluUtils.gluPerspective;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class Renderer extends AbstractRenderer {
    float angle;
    float turretAngle = 0f;
    float velocity = 0;
    //Tank configurable parameters
    float acceleration = 0.00005f;
    float max_min_speed = 0.009f;
    float braking = 0.00002f;
    float rotatinspeed = 0.7f;
    float turretSpeed = 0.7f;
    int fireTime = 20;
    //End of configurable parameters
    int fireTimer = 0;

    float tankX = 0.2f;
    float tankY = 0.1f;
    float tankZ = 0;

    float explosionX = 0;
    float explosionY = 0;
    //Textures
    OGLTexture2D groundTexture;
    OGLTexture2D skyBox_back;
    OGLTexture2D skyBox_bottom;
    OGLTexture2D skyBox_front;
    OGLTexture2D skyBox_left;
    OGLTexture2D skyBox_right;
    OGLTexture2D skyBox_top;
    boolean Wpressed = false;
    boolean Spressed = false;
    boolean Apressed = false;
    boolean Dpressed = false;
    boolean Mpressed = false;
    boolean Npressed = false;
    boolean FirePressed = false;
    Solid tankTurret;
    Solid tank;
    Solid explosion;
    private final float explosionZ = 0.24f;

    public Renderer() {
        super();
        int angle = 0;
        tank = new Tank();
        tankTurret = new TankTurret();
        explosion = new Explosion();

        Boolean keyDown = false; //For looping glwfkeyCallback

        tank = new Tank();

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
                        case GLFW_KEY_M: // Steny - faces
                            Mpressed = false;
                            break;
                        case GLFW_KEY_N: // Steny - faces
                            Npressed = false;
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
                        case GLFW_KEY_M:
                            Mpressed = true;
                            break;
                        case GLFW_KEY_N:
                            Npressed = true;
                            break;
                        case GLFW_KEY_F:
                            fireTimer = fireTime;
                            break;
                    }
                }
            }
        };
    }

    @Override
    public void init() {
        super.init();
        glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        glEnable(GL_DEPTH_TEST);
        glEnable(GL_TEXTURE_2D);
        glDisable(GL_CULL_FACE);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();

        System.out.println("Loading textures...");
        try {

            groundTexture = new OGLTexture2D("textures/ground.jpg");
            skyBox_back = new OGLTexture2D("textures/skybox_back.jpg");
            skyBox_bottom = new OGLTexture2D("textures/skybox_bottom.jpg");
            skyBox_front = new OGLTexture2D("textures/skybox_front.jpg");
            skyBox_left = new OGLTexture2D("textures/skybox_left.jpg");
            skyBox_right = new OGLTexture2D("textures/skybox_right.jpg");
            skyBox_top = new OGLTexture2D("textures/skybox_top.jpg");

        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    public void drawAxes() {
        glColor3f(1.0f, 1.0f, 1.0f);
        glBegin(GL_LINES);
        glColor3f(1.0f, 0.0f, 0.0f);
        glVertex3f(0.0f, 0.0f, 0.0f);
        glVertex3f(1f, 0.0f, 0.0f);

        glColor3f(0.0f, 1.0f, 0.0f);
        glVertex3f(0.0f, 0.0f, 0.0f);
        glVertex3f(0.0f, 1.0f, 0.0f);

        glColor3f(0.0f, 0.0f, 1.0f);
        glVertex3f(0.0f, 0.0f, 0.0f);
        glVertex3f(0.0f, 0.0f, 1.0f);
        glEnd();

    }

    public void drawFloor() {
        glColor3f(1.0f, 1.0f, 1.0f);
        glEnable(GL_TEXTURE_2D);
        groundTexture.bind();
        glBegin(GL_QUADS);
        //glNormal3f(0,0,1);
        glTexCoord2f(0, 0);
        glVertex3f(-5f, -5f, -0.01f);

        glTexCoord2f(0, 1);
        glVertex3f(-5f, 5f, -0.01f);

        glTexCoord2f(1, 1);
        glVertex3f(5f, 5f, -0.01f);

        glTexCoord2f(1, 0);
        glVertex3f(5f, -5f, -0.01f);

        glEnd();
        glDisable(GL_TEXTURE_2D);
    }

    public void drawSkybox() {
        glColor3f(1.0f, 1.0f, 1.0f);
        glEnable(GL_TEXTURE_2D);
        glTexEnvi(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_REPLACE);

        skyBox_left.bind();
        glBegin(GL_QUADS);
        glTexCoord2f(0.0f, 0.0f);
        glVertex3d(-100, -100, 100);

        glTexCoord2f(1.0f, 0.0f);
        glVertex3d(-100, 100, 100);

        glTexCoord2f(1.0f, 1.0f);
        glVertex3d(-100, 100, -100);

        glTexCoord2f(0f, 1.0f);
        glVertex3d(-100, -100, -100);
        glEnd();

        skyBox_front.bind();
        glBegin(GL_QUADS);
        glTexCoord2f(0.0f, 0.0f);
        glVertex3d(-100, 100, 100);

        glTexCoord2f(1.0f, 0.0f);
        glVertex3d(100, 100, 100);

        glTexCoord2f(1.0f, 1.0f);
        glVertex3d(100, 100, -100);

        glTexCoord2f(0f, 1.0f);
        glVertex3d(-100, 100, -100);
        glEnd();

        skyBox_right.bind();
        glBegin(GL_QUADS);
        glTexCoord2f(0.0f, 0.0f);
        glVertex3d(100, 100, 100);

        glTexCoord2f(1.0f, 0.0f);
        glVertex3d(100, -100, 100);

        glTexCoord2f(1.0f, 1.0f);
        glVertex3d(100, -100, -100);

        glTexCoord2f(0f, 1.0f);
        glVertex3d(100, 100, -100);
        glEnd();

        skyBox_back.bind();
        glBegin(GL_QUADS);
        glTexCoord2f(0.0f, 0.0f);
        glVertex3d(100, -100, 100);

        glTexCoord2f(1.0f, 0.0f);
        glVertex3d(-100, -100, 100);

        glTexCoord2f(1.0f, 1.0f);
        glVertex3d(-100, -100, -100);

        glTexCoord2f(0f, 1.0f);
        glVertex3d(100, -100, -100);
        glEnd();

        skyBox_bottom.bind();
        glBegin(GL_QUADS);
        glTexCoord2f(0.0f, 0.0f);
        glVertex3d(-100, -100, -100);

        glTexCoord2f(1.0f, 0.0f);
        glVertex3d(-100, 100, -100);

        glTexCoord2f(1.0f, 1.0f);
        glVertex3d(100, 100, -100);

        glTexCoord2f(0f, 1.0f);
        glVertex3d(-100, 100, -100);
        glEnd();

        skyBox_top.bind();
        glBegin(GL_QUADS);
        glTexCoord2f(0.0f, 0.0f);
        glVertex3d(-100, -100, 100);

        glTexCoord2f(1.0f, 0.0f);
        glVertex3d(-100, 100, 100);

        glTexCoord2f(1.0f, 1.0f);
        glVertex3d(100, 100, 100);

        glTexCoord2f(0f, 1.0f);
        glVertex3d(-100, -100, 100);
        glEnd();


        glDisable(GL_TEXTURE_2D);
    }

    public void drawSolid(Solid solid) {
        glColor3f(1.0f, 1.0f, 1.0f);
        for (int p = 0; p < solid.getPB().size(); p++) { // Geting part from partbuffer
            Part part = solid.getPB().get(p);
            int start = part.getStart();
            int length = part.getLength();
            String type = part.getName();
            List<Vertex> vertexBuffer = solid.getVB();
            List<Integer> indexBuffer = solid.getIB();

            if (type.equals("Triangles")) {
                glBegin(GL_TRIANGLES);
                for (int i = 0; i < length; i++) {
                    Vertex a = vertexBuffer.get(indexBuffer.get(start + i * 3));
                    Vertex b = vertexBuffer.get(indexBuffer.get(start + i * 3 + 1));
                    Vertex c = vertexBuffer.get(indexBuffer.get(start + i * 3 + 2));

                    glColor3f((float) a.getCol().getR(), (float) a.getCol().getG(), (float) a.getCol().getB());
                    glVertex3f(a.getX(), a.getY(), a.getZ());

                    glColor3f((float) b.getCol().getR(), (float) b.getCol().getG(), (float) b.getCol().getB());
                    glVertex3f(b.getX(), b.getY(), b.getZ());

                    glColor3f((float) c.getCol().getR(), (float) c.getCol().getG(), (float) c.getCol().getB());
                    glVertex3f(c.getX(), c.getY(), c.getZ());

                }
                glEnd();
            }
            if (type.equals("TriangeStrips")) {
                glBegin(GL_TRIANGLE_STRIP);
                Vertex a = vertexBuffer.get(indexBuffer.get(start));
                Vertex b = vertexBuffer.get(indexBuffer.get(start + 1));
                Vertex c = vertexBuffer.get(indexBuffer.get(start + 2));

                glColor3f((float) a.getCol().getR(), (float) a.getCol().getG(), (float) a.getCol().getB());
                glVertex3f(a.getX(), a.getY(), a.getZ());

                glColor3f((float) b.getCol().getR(), (float) b.getCol().getG(), (float) b.getCol().getB());
                glVertex3f(b.getX(), b.getY(), b.getZ());

                glColor3f((float) c.getCol().getR(), (float) c.getCol().getG(), (float) c.getCol().getB());
                glVertex3f(c.getX(), c.getY(), c.getZ());

                for (int i = 3; i < length; i++) {
                    Vertex d = vertexBuffer.get(indexBuffer.get(start + i));
                    glColor3f((float) d.getCol().getR(), (float) d.getCol().getG(), (float) d.getCol().getB());
                    glVertex3f(d.getX(), d.getY(), d.getZ());
                }
                glEnd();

            }
        }
    }

    public void movement() {

        if (tankX > 4.9 || tankY > 4.9 || tankX < -4.9 || tankY < -4.9) {
            tankX = 0;
            tankY = 0;
        }

        if (Apressed && !Dpressed) {
            angle += rotatinspeed;
        }
        if (!Apressed && Dpressed) {
            angle -= rotatinspeed;
        }

        if (Wpressed && !Spressed) {
            velocity += acceleration;
            if (velocity >= max_min_speed) {
                velocity = max_min_speed;
            }
            if (velocity < 0) {
                velocity += acceleration * 3;
            }// Stronger breaking
        }

        if (!Wpressed && Spressed) {
            velocity -= acceleration;
            if (velocity <= -max_min_speed) {
                velocity = -max_min_speed;
            }
            if (velocity > 0) {
                velocity -= acceleration * 3;
            }// Stronger breaking
        }

        if (!Wpressed && !Spressed) {
            if (velocity > 0) {
                velocity -= braking;
            }
            if (velocity < 0) {
                velocity += braking;
            }
        }

        //Angles and moving forward in specific direction
        if (angle >= 360) {
            angle = 0;
        }
        if (angle < 0) {
            angle = 359.95f;
        }

        float radians = (float) Math.toRadians(angle);
        tankX = tankX + (float) (Math.cos(radians) * velocity);
        tankY = tankY + (float) (Math.sin(radians) * velocity);


    }

    public void turretMovement() {
        if (Mpressed && !Npressed) {
            turretAngle -= turretSpeed;
        }
        if (!Mpressed && Npressed) {
            turretAngle += turretSpeed;
        }
        if (turretAngle >= 360) {
            turretAngle = 0;
        }
        if (turretAngle < 0) {
            turretAngle = 359.99f;
        }

        //For shooting purposes

        float radians = (float) Math.toRadians(turretAngle);
        explosionX = tankX + (float) (Math.cos(radians) * 0.18f);
        explosionY = tankY + (float) (Math.sin(radians) * 0.18f);
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
        gluLookAt(1.3f, 1.3f, 1.5f, tankX, tankY, tankZ, 0, 0, 1);
        glPushMatrix();
        glPushMatrix();

        drawAxes();
        drawFloor();
        drawSkybox();

        movement();
        glTranslatef(tankX, tankY, tankZ + 0.11f);
        glRotatef(angle, 0, 0, 1);
        drawSolid(tank);
        glPopMatrix();
        turretMovement();
        glTranslatef(tankX, tankY, tankZ + 0.11f);
        glRotatef(turretAngle, 0, 0, 1);
        drawSolid(tankTurret);
        glPopMatrix();

        //Only firing effect nad projectile
        if (fireTimer > 0) {
            fireTimer--;
            glTranslatef(explosionX, explosionY, explosionZ);
            drawSolid(explosion);
        }

        textRenderer.clear();
        textRenderer.addStr2D(width - 80, height - 60, "Pohyb WSAD");
        textRenderer.addStr2D(width - 160, height - 40, "Nataceni veze-M,N. Vystrel F");
        textRenderer.addStr2D(width - 340, height - 20, "PGRF2-Adam Theodor, Projekt Tank. Posledni editace 9.5.25");


    }


}
