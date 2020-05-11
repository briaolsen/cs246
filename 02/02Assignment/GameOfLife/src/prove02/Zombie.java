package prove02;

import java.awt.*;
import java.util.Random;

/**
 * Zombies walk in a straight direction, left to right.
 * They damage any creature (besides plants) that they walk over.
 * <p>
 * @author  Briana Olsen
 * @version 1.0
 * @since   2020-05-01
 * @see Creature
 */

public class Zombie extends Creature implements Movable, Aggressor {

    /**
     * Creates a zombie with 20 health points.
     */
    public Zombie() {
        _health = 20;
    }

    /**
     * Damage any creature (other than plant)
     * for 10 damage that is encountered.
     *
     * @param target The {@link Creature} we've encountered.
     */
    @Override
    public void attack(Creature target ) {

        // Zombies eat creatures other than plants
        // and do 10 damage when they attack.
        if(target instanceof Creature && !(target instanceof Plant)) {
            target.takeDamage(10);
        }
    }

    @Override
    Shape getShape() {
        return Shape.Square;
    }

    @Override
    Color getColor() {
        return new Color(0, 0, 255);
    }

    @Override
    Boolean isAlive() {
        return _health > 0;
    }

    /**
     * Zombies move from left to right.
     */
    @Override
    public void move() {

        // zombies move from left to right
        _location.x++;
    }
}
