package invadem;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import java.util.ArrayList;
import java.util.*;
import processing.event.KeyEvent;



public class App extends PApplet {


    Tank tank;
    List<Projectile> tpros;
    List<Projectile> ipros;
    ArrayList<List<Invader>>  invaders;
    ArrayList<List<Barrier>>  barriers;
    List<Barrier> barriers1;
    List<Barrier> barriers2;
    List<Barrier> barriers3;

    static int timecount=0;
    static int fr=0;
    static int level=0;
    static int reallevel=1;
    static int score=0;
    static int highscore=10000;
    static int life=3;

    PFont f;



    public App() {




         //Set up your objects
    }
    public boolean check_collision(Gobject r1, Gobject r2) {
        if ((r1.getX()< (r2.getX() + r2.getWidth())) && ((r1.getX() + r1.getWidth()) > r2.getX()) && (r1.getY() < (r2.getY() + r2.getHeight())) && ((r1.getHeight() + r1.getY()) > r2.getY())){
        //Collision has been detected
        return true;}
    else{
        return false;}
    }

    public void setup() {
        frameRate(60);
        size(640,480);
        background(0,0,0);


        tank=new Tank(320, 464, null, 22, 16,  1, 0, 3);


        invaders=new ArrayList<List<Invader>> ();
        List<Invader> invaders1=new ArrayList<Invader>();
        List<Invader> invaders2=new ArrayList<Invader>();   //4 list for each line of invaders
        List<Invader> invaders3=new ArrayList<Invader>();
        List<Invader> invaders4=new ArrayList<Invader>();
        int space=25;
        for(int a=0;a<10;a++){
            invaders1.add(new Invader(191+a*space, 16, null, 16, 16, 0.5f, 0.5f, 3));

            invaders2.add(new Invader(191+a*space, 16+25, null, 16, 16, 0.5f, 0.5f, 1));
            invaders3.add( new Invader(191+a*space, 66, null, 16, 16, 0.5f, 0.5f, 1));
            invaders4.add( new Invader(191+a*space, 91, null, 16, 16, 0.5f, 0.5f, 1));
        }

        //set the position for each invaders




        for(Invader i: invaders1){
            i.setState1("invader1_armoured.png");
            i.setState0("empty.png");                   //set image for armoured invaders
            i.setState2("invader2_armoured.png");
        }
        for(Invader i: invaders2){
            i.setState1("invader1_power.png");
            i.setState0("empty.png");                  //set image for power invaders
            i.setState2("invader2_power.png");
        }


        for(Invader i: invaders3){
               i.setState1("invader1.png");
               i.setState0("empty.png");             //set image for normal invaders
               i.setState2("invader2.png");

            }
        for(Invader i: invaders4){
            i.setState1("invader1.png");
            i.setState0("empty.png");                //set image for normal invaders
            i.setState2("invader2.png");

        }
        invaders.add(invaders1);
        invaders.add(invaders2);                    //add 4 line in 1 list
        invaders.add(invaders3);
        invaders.add(invaders4);



        barriers= new ArrayList<List<Barrier>>();
        barriers1=new ArrayList<Barrier>();
        barriers2=new ArrayList<Barrier>();             //initialize 3 list for each barrier and 1 list to put all 3 in
        barriers3=new ArrayList<Barrier>();



        for (int j = 0; j < 3; j++) {
            barriers1.add( new Barrier(250, 400 - j * 8, null, 8, 8, 0, 0, 3));
        }
        for (int j = 3; j < 5; j++) {
            barriers1.add( new Barrier(250 + (j - 2) * 8, 400 - 2 * 8, null, 8, 8, 0, 0, 3));
        }
        for (int j = 5; j < 7; j++) {
            barriers1.add(new Barrier(250 + 16, 384 + (j - 4) * 8, null, 8, 8, 0, 0, 3));
        }
        for (int j = 0; j < 3; j++) {
            barriers2.add(new Barrier(320, 400 - j * 8, null, 8, 8, 0, 0, 3));
        }
        for (int j = 3; j < 5; j++) {
            barriers2.add(new Barrier(320 + (j - 2) * 8, 400 - 2 * 8, null, 8, 8, 0, 0, 3));
        }
        for (int j = 5; j < 7; j++) {
            barriers2.add(new Barrier(336 , 384 + (j - 4) * 8, null, 8, 8, 0, 0, 3));
        }
        for (int j = 0; j < 3; j++) {
            barriers3.add(new Barrier(390, 400 - j * 8, null, 8, 8, 0, 0, 3));
        }
        for (int j = 3; j < 5; j++) {
            barriers3.add(new Barrier(390 + (j - 2) * 8, 400 - 2 * 8, null, 8, 8, 0, 0, 3));
        }
        for (int j = 5; j < 7; j++) {
            barriers3.add( new Barrier(390 + 16, 384 + (j - 4) * 8, null, 8, 8, 0, 0, 3));
        }
        barriers.add(barriers1);
        barriers.add(barriers2);
        barriers.add(barriers3);

                // set position for each block and add to corresponding list


        for(int i=0; i<3;i++){
            barriers.get(i).get(0).setState1("barrier_solid1.png");
            barriers.get(i).get(0).setState2("barrier_solid2.png");
            barriers.get(i).get(0).setState3("barrier_solid3.png");
            barriers.get(i).get(0).setState4("empty.png");
            barriers.get(i).get(1).setState1("barrier_solid1.png");
            barriers.get(i).get(1).setState2("barrier_solid2.png");
            barriers.get(i).get(1).setState3("barrier_solid3.png");
            barriers.get(i).get(1).setState4("empty.png");
            barriers.get(i).get(2).setState1("barrier_left1.png");
            barriers.get(i).get(2).setState2("barrier_left2.png");
            barriers.get(i).get(2).setState3("barrier_left3.png");
            barriers.get(i).get(2).setState4("empty.png");
            barriers.get(i).get(3).setState1("barrier_top1.png");
            barriers.get(i).get(3).setState2("barrier_top2.png");
            barriers.get(i).get(3).setState3("barrier_top3.png");
            barriers.get(i).get(3).setState4("empty.png");
            barriers.get(i).get(4).setState1("barrier_right1.png");
            barriers.get(i).get(4).setState2("barrier_right2.png");
            barriers.get(i).get(4).setState3("barrier_right3.png");
            barriers.get(i).get(4).setState4("empty.png");
            barriers.get(i).get(5).setState1("barrier_solid1.png");
            barriers.get(i).get(5).setState2("barrier_solid2.png");
            barriers.get(i).get(5).setState3("barrier_solid3.png");
            barriers.get(i).get(5).setState4("empty.png");
            barriers.get(i).get(6).setState1("barrier_solid1.png");
            barriers.get(i).get(6).setState2("barrier_solid2.png");
            barriers.get(i).get(6).setState3("barrier_solid3.png");
            barriers.get(i).get(6).setState4("empty.png");
        }
            //set image for all the states for each block

        tank.setimage(this,"tank1.png");

        for(List<Invader> i : invaders){
            for(Invader j : i){
                j.changestate(this);     //set the image to the initial one
            }
        }

        for(int i=0;i<3;i++){
        for(int j=0;j<7;j++){
            barriers.get(i).get(j).changestate(this);     //set the image to the initial one
        }}


        tpros=new ArrayList<Projectile>();    //tank projectile
        ipros=new ArrayList<Projectile>();


        f=createFont("PressStart2P-Regular.ttf",10);

    }

    public void settings() {
        size(640, 480);
    }

    public void draw() {

//        if gameover:
//
//        else:


        background(0, 0, 0);

        textFont(f,10);
        fill(255,255,255);
        if(score>highscore){
            highscore=score;
        }

        text("Score: "+score,50,70);
        text("Level: "+reallevel,50,90);
        text("Life:  "+tank.getLife(),50,110);


        text("High Score: "+highscore,470,70);



//        draw the scores

        for(List<Invader> i : invaders){
            for(Invader j : i){
        if(j.getY()==384-26|| tank.getLife()<=0){


            if(timecount<120){
                image(loadImage("gameover.png"),264,232);
                timecount+=1;
                return;
            }else{
                timecount=0;
                fr=0;
                reallevel=1;
                level=0;
                score=0;
                this.setup();
            }

        }}}

        //gameover section



        tank.draw(this);


        //draw the tank




        //tank's projectile logic part

        if(spacepress){
            for(int i=0;i<tpros.size();i++){
                tpros.get(i).draw(this);
                for(List<Invader> k : invaders){
                    for(Invader j : k){


            if(tpros.size()>0 && i<tpros.size()) {
                if (check_collision(tpros.get(i), j)) {
                    tpros.remove(i);
                    j.setLife(j.getLife() - 1);
                    if(k==invaders.get(0)||k==invaders.get(1)){
                        if(j.getLife()==0){
                            score+=250;
                        }
                    }
                    else if(k==invaders.get(2)||k==invaders.get(3)){
                        if(j.getLife()==0){
                            score+=100;
                        }
                    }



                }
            }

                    }

                    k.removeIf(n -> (n.getLife() == 0));}

                //tank projectile collide with invaders and score count





                for(List<Barrier> q : barriers){
                    for(Barrier l : q){
                        if(tpros.size()>0 && i<tpros.size()) {
                            if (check_collision(tpros.get(i), l)) {

                                l.setLife(l.getLife() - 1);
                                l.changestate(this);
                                tpros.remove(i);



                            }
                    }
                }

            q.removeIf(n -> (n.getLife()==0));}
        }}

        //tank projectile collide with barrier




        //invader projectile part

        Random rannum = new Random();
        int randomline = rannum.nextInt(4);  //select random line
        if(invaders.get(0).size()==0 && invaders.get(1).size()==0 && invaders.get(2).size()==0 &&invaders.get(3).size()==0 ) {
            if(timecount<120){
                this.clear();
                image(loadImage("nextlevel.png"),264,232);    //next level logic
                timecount+=1;
                return;
            }else{
                timecount=0;
                fr=0;
                life=tank.getLife();
                reallevel+=1;
                if(level<4){
                    level+=1;}
                else{level=4;}
                this.setup();
                tank.setLife(life);

            }
        }

            while(invaders.get(randomline).size()==0){
                for(int i=0;i<4;i++){
                    if(invaders.get(i).size()!=0){
                        randomline=i;
                    }
                }
            }                           //if the chosen line is empty choose a line which have live invader



            int randomone=rannum.nextInt(invaders.get(randomline).size());  //select random invader


                                       //fr==fire rate
        fr+=1;
        if(fr==300-level*60) {
            if(randomline==1){     //if power invader was selected
                PImage x= this.loadImage("projectile_lg.png");
                ipros.add(new Projectile(invaders.get(randomline).get(randomone).getX(),invaders.get(randomline).get(randomone).getY(),x,2,5,0,-1,3));
                fr=0;
            }
            else{
            PImage x= this.loadImage("projectile.png");
            ipros.add(new Projectile(invaders.get(randomline).get(randomone).getX(),invaders.get(randomline).get(randomone).getY(),x,1,3,0,-1,1));
            fr=0;}
        }

        //create invader projectile
        for(int i=0;i<tpros.size();i++){
        if(tpros.size()>0 && i<tpros.size()) {
            if(ipros.size()>0){
                for(Projectile k: ipros){
                    if(i<tpros.size()){
                    if (check_collision(tpros.get(i), k)) {
                        tpros.remove(i);
                        k.setLife(0);

                    }}
                }ipros.removeIf(n -> (n.getLife()==0));}}}

        // tank projectile collide with invader projectile

        if(ipros.size()>0){
            for(int i=0;i<ipros.size();i++){
                ipros.get(i).draw(this);

                for(List<Barrier> q : barriers){
                    for(Barrier l : q){
                        if(ipros.size()>0 && i<ipros.size()) {
                            if (check_collision(ipros.get(i), l)) {

                                l.setLife(l.getLife() - ipros.get(i).getLife());
                                l.changestate(this);
                                ipros.remove(i);



                            }
                        }
                    }

                    q.removeIf(n -> (n.getLife()<=0));}

                //invader projectile collide with barrier


                if(ipros.size()>0 && i<ipros.size()) {
                    if (check_collision(ipros.get(i), tank)) {

                        tank.setLife(tank.getLife() - ipros.get(i).getLife());

                        ipros.remove(i);

                    //invader projectile collides tank

                    }
                }


            }}








        for(List<Invader> i : invaders){
            for(Invader j : i){
                j.draw(this);
            }}

        //draw invader



        for(List<Barrier> i : barriers){
            for(Barrier j : i){
                j.changestate(this);
            }}
                //change the barriers' image


        for(List<Barrier> i : barriers){
            for(Barrier j : i){
                image(j.image,j.getX(),j.getY(),j.getWidth(),j.getHeight());
            }}

        //draw the barriers





        if(leftpress){tank.moveleft();}
        if(rightpress){tank.moveright();}//Main Game Loop
    }
    boolean leftpress = false;
    boolean rightpress = false;
    boolean spacepress=false;

    @Override
    public void keyPressed(KeyEvent event) {
        super.keyPressed(event);
        if (keyCode == LEFT) {
                leftpress = true; }
        if (keyCode == RIGHT) {
        rightpress = true;
        }



    }


    @Override
    public void keyReleased(KeyEvent event) {
        super.keyReleased(event);
        if (keyCode == LEFT) {
                leftpress=false;
            }
            if (keyCode == RIGHT) {
               rightpress = false;
            }
            if(keyCode==32){
                PImage x= this.loadImage("projectile.png");
                tpros.add(new Projectile(tank.getX()+11,tank.getY(),x,1,3,0,1,1));

                spacepress=true;

                //create tank projectile
            }

    }



    public static void main(String[] args) {
        PApplet.main("invadem.App");
    }

}
