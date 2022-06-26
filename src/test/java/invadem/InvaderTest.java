package invadem;

import org.junit.Test;
import static org.junit.Assert.*;


public class InvaderTest {

    @Test
    public void testInvaderConstruction() {
        Invader inv =new Invader(191, 16, null, 16, 16, 0.5f, 0.5f, 3);

        assertNotNull(inv);

    }

    @Test
    public void testInvadergetmovestate() {
        Invader inv =new Invader(191, 16, null, 16, 16, 0.5f, 0.5f, 3);
        inv.setmovestate(false);
        assertNotNull(inv.getmovestate());

    }

    @Test
    public void testInvadergetstate0() {
        Invader inv =new Invader(191, 16, null, 16, 16, 0.5f, 0.5f, 3);
        inv.setState0("xx");
        assertNotNull(inv.getState0());

    }

    @Test
    public void testInvadergetstate1() {
        Invader inv =new Invader(191, 16, null, 16, 16, 0.5f, 0.5f, 3);
        inv.setState1("xx");
        assertNotNull(inv.getState1());

    }

    @Test
    public void testInvadergetstate2() {
        Invader inv =new Invader(191, 16, null, 16, 16, 0.5f, 0.5f, 3);
        inv.setState2("xx");
        assertNotNull(inv.getState2());

    }

    @Test
    public void testInvaderMoveLeft() {
        Invader inv =new Invader(191, 16, null, 16, 16, 0.5f, 0.5f, 3);
        inv.moveleft();
        assertNotNull( inv.getX());
    }

    @Test
    public void testInvaderMoveRight() {
        Invader inv =new Invader(191, 16, null, 16, 16, 0.5f, 0.5f, 3);
        inv.moveright();
        assertNotNull( inv.getX());
    }

    @Test
    public void testInvaderMovedown() {
        Invader inv =new Invader(191, 16, null, 16, 16, 0.5f, 0.5f, 3);
        inv.movedown();
        assertNotNull( inv.getY());
    }




//    @Test
//    public void testInvaderFireProjectile() {
//        Invader inv = /* Your Constructor Here */
//        assertNotNull(inv.fire());
//    }

//    @Test
//    public void testInvaderIsNotDead() {
//        Invader inv = /* Your Constructor Here */
//        assertEquals(false, inv.isDead());
//    }

//    @Test
//    public void testInvaderIsDead() {
//        Invader inv = /* Your Constructor Here */
//        inv.hit();
//        assertEquals(true, inv.isDead());
//    }

//    @Test
//    public void testInvaderIntersectWithPlayerProjectile() {
//        Invader inv = /* Your Constructor Here */
//        Projectile proj = /* Your Constructor Here */
//        assertTrue(proj.intersect(inv));

//    }

//    @Test
//    public void testInvaderIntersectWithPlayerProjectile() {
//        Invader inv = /* Your Constructor Here */
//        Projectile proj = /* Your Constructor Here */
//        assertFalse(proj.intersect(inv));

//    }

}
