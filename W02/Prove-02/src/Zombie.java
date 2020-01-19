import java.awt.Color;

public class Zombie extends Creature implements Movable, Aggressor{

    public Zombie(){
        _health = 1;
    }

    @Override
    Shape getShape() {
        return Shape.Square;
    }

    @Override
    Color getColor() {
        return new Color(0, 0, 165);
    }

    @Override
    Boolean isAlive() {
        return _health > 0;
    }

    @Override
    public void attack(Creature target) {
        if(target instanceof Animal)
        {
            target.takeDamage(10);
            if (!target.isAlive())
                _health++;
        }
    }

    @Override
    public void move() {
        _location.x++;
    }
}
