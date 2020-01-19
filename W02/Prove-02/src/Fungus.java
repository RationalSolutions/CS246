import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public class Fungus extends Creature implements Spawner, Aware {
    int growthDirection;
    boolean surrounded;

    public Fungus(){
        _health = 10;
        growthDirection = new Random().nextInt(4);
        surrounded = false;
    }

    @Override
    Shape getShape() {
        return Shape.Square;
    }

    @Override
    public Color getColor() {
        return new Color(98, 132, 3);
    }

    @Override
    Boolean isAlive() {
        return _health > 0;
    }

    @Override
    public Creature spawnNewCreature() {
        int chanceToSpawn = new Random().nextInt(100);
        int x;
        int y;
        if((chanceToSpawn == 0) && (!surrounded))
        {
            Fungus f = new Fungus();
            switch (growthDirection){
                case 0:
                    x = this._location.x;
                    y = this._location.y - 1;
                    f.setLocation(new Point(x,y));
                    break;
                case 1:
                    x = this._location.x - 1;
                    y = this._location.y;
                    f.setLocation(new Point(x,y));
                    break;
                case 2:
                    x = this._location.x;
                    y = this._location.y + 1;
                    f.setLocation(new Point(x,y));
                    break;
                case 3:
                    x = this._location.x + 1;
                    y = this._location.y;
                    f.setLocation(new Point(x,y));
                    break;
                default:
                    break;
            }
            return f;
        }
        return null;
    }

    @Override
    public void senseNeighbors(Creature above, Creature below, Creature left, Creature right) {
        if ((above != null) && (below != null) && (left != null) && (right != null))
            surrounded = true;

        switch (growthDirection){
            case 0:
                if (above == null)
                    {} // don't change anything
                else if (left == null)
                    growthDirection = 2;
                else if (below == null)
                    growthDirection = 2;
                else if (right == null)
                    growthDirection = 3;
                break;
            case 1:
                if (left == null)
                {} //don't change anything
                else if (below == null)
                    growthDirection = 2;
                else if (right == null)
                    growthDirection = 3;
                else if (above == null)
                    growthDirection = 0;
                break;
            case 2:
                if (below == null)
                {} //don't change anything
                else if (right == null)
                    growthDirection = 3;
                else if (above == null)
                    growthDirection = 0;
                else if (left == null)
                    growthDirection = 1;
                break;
            case 3:
                if (right == null)
                {} //don't change anything
                else if (above == null)
                    growthDirection = 0;
                else if (left == null)
                    growthDirection = 1;
                else if (below == null)
                    growthDirection = 2;
                break;
            default:
                break;
        }

    }
}
