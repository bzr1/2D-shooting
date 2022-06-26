package invadem;
import processing.core.PApplet;
import processing.core.PImage;

public class Invader extends Gobject {

    private String state1 = null;
    private String state0 = null;
    private String state2 = null;
    private boolean movestate=false;
    float stepcountright;
    float stepdowncount;
    float stepcountleft;
    boolean right;

    public Invader(float x, float y, PImage image, float width, float height, float vx, float vy, int life) {
        super(x, y, image, width, height, vx, vy, life);
        right=false;

    }

    public void changestate(PApplet app) {
        if(this.getLife()==0){
            this.image=app.loadImage(state0);  //dead image
        }
        else if(this.getLife()!=0) {

            if (movestate == false) {

                this.image = app.loadImage(state1);
            }                                               //2 movement
            if (movestate == true) {

                this.image = app.loadImage(state2);
            }
        }


    }




    public boolean getmovestate(){
        return movestate;
    }
    public void setmovestate(boolean movestate){
        this.movestate=movestate;
    }
    public String getState1() {
        return state1;
    }

    public void setState1(String state1) {
        this.state1 = state1;
    }

    public String getState0() {
        return state0;
    }

    public void setState0(String state0) {
        this.state0 = state0;
    }
    public String getState2() {
        return state2;
    }

    public void setState2(String state2) {
        this.state2 = state2;
    }
    public void moveleft(){

            this.x=this.x-vx;
        }


    public void moveright(){

            this.x=this.x+vx;
        }
     public void movedown(){
        this.y=this.y+vy;
     }

     public void draw(PApplet app){
         app.image(this.getImage(), this.getX(), this.getY(), this.getWidth(), this.getHeight());
         tick(app);
     };
    public void tick(PApplet app) {    //method for move on the certain route
        if ((stepcountright == 30 || stepcountleft == 30) && stepdowncount < 8) {

            this.setmovestate(true);
            this.changestate(app);

            this.movedown();
            stepdowncount += 0.5;
        }





        else if(stepcountright<30 && right==false){

                    this.setmovestate(false);
                    this.changestate(app);

                    this.moveright();
            stepdowncount=0;
            stepcountleft=0;
            stepcountright+=0.5;}

        else if( stepcountleft<30 && right==true ){

                    this.setmovestate(false);
                   this.changestate(app);



                    this.moveleft();

            stepdowncount=0;
            stepcountright=0;
            stepcountleft+=0.5;


        }


        if(stepcountright==30){right=true;}
        else if(stepcountleft==30){right=false; }

    };


}
