package invadem;
import processing.core.PApplet;
import processing.core.PImage;
import java.util.*;

public abstract class Gobject {
  protected float x;
  protected float y;
  protected PImage image;
  protected float width;
  protected float height;
  protected float vx;
  protected float vy;
  protected int life;

    public Gobject(float x, float y, PImage image, float width, float height, float vx, float vy, int life) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.width = width;
        this.height = height;
        this.vx = vx;
        this.vy = vy;
        this.life = life;
    }
    public void draw(PApplet app){};
    public void tick(){};

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public PImage getImage() {
        return image;
    }

    public void setimage(PApplet app,String route){
      this.image=app.loadImage(route);
  }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getVx() {
        return vx;
    }

    public void setVx(float vx) {
        this.vx = vx;
    }

    public float getVy() {
        return vy;
    }

    public void setVy(float vy) {
        this.vy = vy;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }






}

