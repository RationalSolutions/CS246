import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public class Wolf extends Creature implements Movable, Aware, Aggressor, Spawner {

    private int direction;
    boolean ableToSpawn;

    public Wolf() {
        direction = new Random().nextInt(4);
        _health = 1;
        ableToSpawn = false;
    }

    @Override
    public void attack(Creature target) {
        if (target instanceof Animal)
        {
            target.takeDamage(5);
            _health++;
            if (!target.isAlive())
                ableToSpawn = true;
        }
    }

    @Override
    public void senseNeighbors(Creature above, Creature below, Creature left, Creature right) {
        // NORTH = 0 WEST = 1 SOUTH = 2 EAST = 3

        switch (direction){
            case 0:
                if (above instanceof Animal)
                {} //don't change anything
                else if (left instanceof Animal)
                    direction = 1;
                else if (below instanceof Animal)
                    direction = 2;
                else if (right instanceof Animal)
                    direction = 3;
                break;
            case 1:
                if (left instanceof Animal)
                {} //don't change anything
                else if (below instanceof Animal)
                    direction = 2;
                else if (right instanceof Animal)
                    direction = 3;
                else if (above instanceof Animal)
                    direction = 0;
                break;
            case 2:
                if (below instanceof Animal)
                {} //don't change anything
                else if (right instanceof Animal)
                    direction = 3;
                else if (above instanceof Animal)
                    direction = 0;
                else if (left instanceof Animal)
                    direction = 1;
                break;
            case 3:
                if (right instanceof Animal)
                {} //don't change anything
                else if (above instanceof Animal)
                    direction = 0;
                else if (left instanceof Animal)
                    direction = 1;
                else if (below instanceof Animal)
                    direction = 2;
                break;
            default:
                break;
        }
    }

    @Override
    Shape getShape() {
        return Shape.Square;
    }

    @Override
    Color getColor() {
        return new Color(87, 87, 87);
    }

    @Override
    Boolean isAlive() {
        return _health > 0;
    }

    @Override
    public void move() {
        switch (direction){
            case 0:
                _location.y--;
                break;
            case 1:
                _location.x--;
                break;
            case 2:
                _location.y++;
                break;
            case 3:
                _location.x++;
                break;
            default:
                break;
        }
    }

    @Override
    public Creature spawnNewCreature() {
        if (ableToSpawn)
        {
            Wolf w = new Wolf();
            int x = this._location.x - 1;
            int y = this._location.y;
            w.setLocation(new Point(x,y));
            ableToSpawn = false;
            return w;
        }
        return null;
    }
}
