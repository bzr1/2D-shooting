package invadem;

import processing.core.PApplet;
import processing.core.PImage;

public class Projectile  extends Gobject{

    public Projectile(float x, float y, PImage image, float width, float height, float vx, float vy, int life) {
        super(x, y, image, width, height, vx, vy, life);
    }
    public void draw(PApplet app){
        app.image(this.getImage(), this.getX(), this.getY(), this.getWidth(), this.getHeight());
        tick();
    }
    public void tick(){
        this.y-=vy;
    }
}
