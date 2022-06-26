package invadem;

import org.junit.Test;
import static org.junit.Assert.*;

public class BarrierTest {

    @Test
    public void barrierConstruction() {
        Barrier b = new Barrier(250, 400 - 2 * 8, null, 8, 8, 0, 0, 3);
        b.hit();
        assertNotNull(b);
    }

    @Test
    public void testBarrierNotDestroyed() {
        Barrier b = new Barrier(250, 400 - 2 * 8, null, 8, 8, 0, 0, 3);
        assertEquals(false, b.isDestroyed());
    }

    @Test
    public void testBarrierIsDestroyed() {
        Barrier b = new Barrier(250, 400 - 2 * 8, null, 8, 8, 0, 0, 3);
        b.setLife(0);
        assertEquals(true, b.isDestroyed());
    }

    @Test
    public void testBarrierHitPointsMax() {
        Barrier b = new Barrier(250, 400 - 2 * 8, null, 8, 8, 0, 0, 3);
        assertEquals(3, b.getLife());
    }

    @Test
    public void testBarrierHitPoints2() {
        Barrier b = new Barrier(250, 400 - 2 * 8, null, 8, 8, 0, 0, 3);
        b.hit();
        assertEquals(2, b.getLife());
    }

    @Test
    public void testBarrierHitPoints3() {
        Barrier b = new Barrier(250, 400 - 2 * 8, null, 8, 8, 0, 0, 3);
        b.hit();
        b.hit();
        assertEquals(1, b.getLife());
    }
    @Test
    public void testBarriergetstate1() {
        Barrier b = new Barrier(250, 400 - 2 * 8, null, 8, 8, 0, 0, 3);
        b.setState1("xx");
        assertNotNull(b);

    }

    @Test
    public void testBarriergetstate2() {
        Barrier b = new Barrier(250, 400 - 2 * 8, null, 8, 8, 0, 0, 3);
        b.setState2("xx");
        assertNotNull(b);

    }

    @Test
    public void testBarriergetstate3() {
        Barrier b = new Barrier(250, 400 - 2 * 8, null, 8, 8, 0, 0, 3);
        b.setState3("xx");
        assertNotNull(b);

    }

    @Test
    public void testBarriergetstate4() {
        Barrier b = new Barrier(250, 400 - 2 * 8, null, 8, 8, 0, 0, 3);
        b.setState4("xx");
        assertNotNull(b);

    }

//    @Test
//    public void testBarrierIsDestroyed() {
//        Barrier b = new Barrier(250, 400 - 2 * 8, null, 8, 8, 0, 0, 3);
//        b.changestate();
//
//    }

}
