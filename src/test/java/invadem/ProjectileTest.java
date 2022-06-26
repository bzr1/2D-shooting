package invadem;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProjectileTest {


    @Test
    public void testProjectileConstruction() {
        Projectile proj = new Projectile(11,11,null,1,3,0,1,1);
        assertNotNull(proj);
    }
    @Test
   public void testProjectiletick() {
       Projectile proj = new Projectile(11, 11, null, 1, 3, 0, 1, 1);
       proj.tick();
       assertNotNull(proj.getY());
   }
//    @Test
//    public void testProjectileIsNotFriendly() {
//        Projectile proj = /* Your Constructor Here */
//        assertFalse(proj.isFriendly());
//    }

//    @Test
//    public void testProjectileIntersect() {
//        Projectile proj = /* Your Constructor Here */
//        Invader inv = /* Your Constructor Here */
//        Tank tank = /* Your Constructor Here */
//        assertFalse(proj.intersect(inv));
//        assertFalse(proj.intersect(tank));
//    }

}
