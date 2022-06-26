package invadem;
import processing.core.PApplet;
import processing.core.PImage;







public class Barrier extends Gobject {


    private String state1=null;
    private String state2=null;
    private String state3=null;
    private String state4=null;

    public Barrier(float x, float y, PImage image, float width, float height, float vx, float vy, int life) {
        super(x, y, image, width, height, vx, vy, life);

    }


    public void changestate(PApplet app){
        if(this.life==3){

            this.image=app.loadImage(state1);
        }
        if(this.life==2){

            this.image=app.loadImage(state2);
        }
        if(this.life==1){

            this.image=app.loadImage(state3);
        }
        if(this.life==0){

            this.image=app.loadImage(state4);
        }


    }

    public void hit(){
        this.life-=1;
    }

    public boolean isDestroyed(){
        if(this.life==0){
            return true;
        }
        else{return false;}
    }



    public void setState1(String state1) {
        this.state1 = state1;
    }



    public void setState2(String state2) {
        this.state2 = state2;
    }



    public void setState3(String state3) {
        this.state3 = state3;
    }


    public void setState4(String state4) {
        this.state4 = state4;
    }

    





}
