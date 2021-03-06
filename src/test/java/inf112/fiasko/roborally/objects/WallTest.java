package inf112.fiasko.roborally.objects;

import inf112.fiasko.roborally.objects.properties.Direction;
import inf112.fiasko.roborally.objects.properties.WallType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WallTest {
    @Test
    public void testWallGetWallTypeNormal() {
        Wall testGetWall = new Wall(WallType.WALL_NORMAL, Direction.NORTH);
        assertEquals(WallType.WALL_NORMAL, testGetWall.getType());
    }

    @Test
    public void testWallGetWallTypeCorner() {
        Wall testGetWall = new Wall(WallType.WALL_CORNER, Direction.NORTH);
        assertEquals(WallType.WALL_CORNER, testGetWall.getType());
    }

    @Test
    public void testWallGetWallTypeLaserSingle() {
        Wall testGetWall = new Wall(WallType.WALL_LASER_SINGLE, Direction.NORTH);
        assertEquals(WallType.WALL_LASER_SINGLE, testGetWall.getType());
    }

    @Test
    public void testWallGetDirectionNorth() {
        Wall testGetWall = new Wall(WallType.WALL_CORNER, Direction.NORTH);
        assertEquals(Direction.NORTH, testGetWall.getDirection());
    }

    @Test
    public void testWallGetDirectionEast() {
        Wall testGetWall = new Wall(WallType.WALL_CORNER, Direction.EAST);
        assertEquals(Direction.EAST, testGetWall.getDirection());
    }

}
