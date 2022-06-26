package invadem;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import java.util.ArrayList;
import java.util.*;
import processing.event.KeyEvent;


public class AppTest {
    @Test
    public void testcollesion() {
        Projectile proj = new Projectile(11,11,null,1,3,0,1,1);
        Projectile proj2 = new Projectile(11,11,null,1,3,0,1,1);
        App app = new App();
        assertTrue(app.check_collision(proj,proj2));
    }






}
