package invadem;

import org.junit.Test;
import static org.junit.Assert.*;

public class TankTest {

    @Test
    public void testTankConstruction() {
        Tank tank = new Tank(320, 464, null, 22, 16,  1, 0, 3);
        assertNotNull(tank);
    }

    @Test
    public void testTankMoveLeft() {
        Tank tank = new Tank(320, 464, null, 22, 16,  1, 0, 3);
        tank.moveleft();
        assertNotNull( tank.getX());
    }

    @Test
    public void testTankMoveRight() {
        Tank tank = new Tank(320, 464, null, 22, 16,  1, 0, 3);
        tank.moveright();
        assertNotNull( tank);
    }



    @Test
    public void testTankIsNotDead() {
        Tank tank = new Tank(320, 464, null, 22, 16,  1, 0, 3);
        assertEquals(3, tank.getLife());
    }

    @Test
    public void testTankItick() {
        Tank tank = new Tank(320, 464, null, 22, 16,  1, 0, 3);
        tank.tick();
        assertNotNull(tank);
    }

    @Test
    public void testTanksetheight() {
        Tank tank = new Tank(320, 464, null, 22, 16,  1, 0, 3);
        tank.setHeight(2);
        assertNotNull(tank);
    }

    @Test
    public void testTanksetwidth() {
        Tank tank = new Tank(320, 464, null, 22, 16,  1, 0, 3);
        tank.setWidth(2);
        assertNotNull(tank);
    }

    @Test
    public void testTanksetvx() {
        Tank tank = new Tank(320, 464, null, 22, 16,  1, 0, 3);
        tank.setVx(2);
        assertNotNull(tank);
    }

    @Test
    public void testTanksetvy() {
        Tank tank = new Tank(320, 464, null, 22, 16,  1, 0, 3);
        tank.setVy(2);
        assertNotNull(tank);
    }

    @Test
    public void testTanksetx() {
        Tank tank = new Tank(320, 464, null, 22, 16,  1, 0, 3);
        tank.setX(2);
        assertNotNull(tank);
    }

    @Test
    public void testTanksety() {
        Tank tank = new Tank(320, 464, null, 22, 16,  1, 0, 3);
        tank.setY(2);
        assertNotNull(tank);
    }

    @Test
    public void testTankgetwidth() {
        Tank tank = new Tank(320, 464, null, 22, 16,  1, 0, 3);

        assertNotNull(tank.getWidth());
    }

    @Test
    public void testTankgetvx() {
        Tank tank = new Tank(320, 464, null, 22, 16,  1, 0, 3);

        assertNotNull(tank.getVx());
    }

    @Test
    public void testTankgetvy() {
        Tank tank = new Tank(320, 464, null, 22, 16,  1, 0, 3);

        assertNotNull(tank.getVy());
    }

    @Test
    public void testTankgetlife() {
        Tank tank = new Tank(320, 464, null, 22, 16,  1, 0, 3);

        assertNotNull(tank.getLife());
    }
    @Test
    public void testTanksetlife() {
        Tank tank = new Tank(320, 464, null, 22, 16,  1, 0, 3);
        tank.setLife(3);
        assertNotNull(tank.getLife());
    }

    @Test
    public void testTankgetheight() {
        Tank tank = new Tank(320, 464, null, 22, 16,  1, 0, 3);

        assertNotNull(tank.getHeight());
    }



//    @Test
//    public void testTankMoveDraw() {
//        Tank tank = new Tank(320, 464, null, 22, 16,  1, 0, 3);
//
//        assertNotNull( tank.draw ());
//    }

}
