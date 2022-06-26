package invadem;
import processing.core.PApplet;
import processing.core.PImage;

public class Tank extends Gobject {


    public Tank(float x, float y, PImage image, float width, float height, float vx, float vy, int life) {
        super(x, y, image, width, height, vx, vy, life);
    }

    public void moveleft(){
        if (this.x >= 180+11) {
            this.x=this.x-vx;
        }

    }
    public void moveright(){
        if(this.x<=460-11){
        this.x=this.x+vx;
    }}

    public void draw(PApplet app){
        app.image(this.getImage(), this.getX(), this.getY(), this.getWidth(), this.getHeight());

    }

}
