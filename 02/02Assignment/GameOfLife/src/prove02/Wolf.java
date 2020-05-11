package prove02;

import java.awt.*;
import java.util.Random;
import java.awt.Point;

/**
 * Wolves attack zombies they walk into.
 * Wolves eat and track animals.
 * They are represented by grey squares.
 * When a wolf eats an animal they spawn another wolf.
 * <p>
 * @author  Briana Olsen
 * @version 1.0
 * @since   2020-05-01
 * @see Creature
 */

public class Wolf extends Creature implements Movable, Aggressor, Aware, Spawner{

    Random _rand;
    int _direction;
    boolean _spawn;
    int _frames;

    /**
     * Creates a wolf with 10 health points.
     */
    public Wolf() {
        _rand = new Random();
        _direction = _rand.nextInt(4);
        _health = 10;
        _spawn = false;
        _frames = 0;
    }

    /**
     * Tracks whether or not a wolf can spawn
     */
    public boolean isSpawn() { return _spawn; }


    /**
     * If the creature we've encountered is an animal, eat it.
     * If target is a zombie attack it for 5 damage
     * and take damage in return.
     * @param target The {@link Creature} we've encountered.
     */
    @Override
    public void attack(Creature target) {
        // Wolves only eat animals
        // Wolves spawn a baby and gain health if they eat
        if(target instanceof Animal) {
            target.takeDamage(5);
            _health++;
            _spawn = true;
            _frames = 0;
        }

        // Wolves attack Zombies if they walk over them
        // but they take damage
        if(target instanceof Zombie) {
            target.takeDamage(5);
            _health -= 5;
        }
    }


    /**
     * Wolves sense any animal within a square and
     * turn towards that creature. They will check their
     * current direction first, and then rotate clockwise.
     */
    @Override
    public void senseNeighbors(Creature above, Creature below, Creature left, Creature right) {

        // check for animals starting in the direction of movement
        int d = _direction;

        for(int i = 0; i < 4; i++) {

            // turn in the direction of the nearest animal
            switch(d) {
                case 0:
                    if (right instanceof Animal) {
                        _direction = 0;
                        return;
                    } else {
                        break;
                    }
                case 1:
                    if (left instanceof Animal) {
                        _direction = 1;
                        return;
                    } else {
                        break;
                    }
                case 2:
                    if (below instanceof Animal) {
                        _direction = 2;
                        return;
                    } else {
                        break;
                    }
                case 3:
                    if (above instanceof Animal) {
                        _direction = 3;
                        return;
                    } else {
                        break;
                    }
                default:
                    break;
            }

            // check for other animals in a clockwise pattern
            switch(d) {
                case 0:
                    d = 2;
                    break;
                case 1:
                    d = 3;
                    break;
                case 2:
                    d = 1;
                    break;
                case 3:
                    d = 0;
                    break;
                default:
                    break;
            }
        }

    }

    @Override
    Shape getShape() {
        return Shape.Square;
    }

    @Override
    Color getColor() {
        return new Color(35, 32, 32);
    }

    @Override
    Boolean isAlive() {
        return _health > 0;
    }


    /**
     * Wolves move in their preferred direction until they
     * sense an animal nearby.
     * If wolves have not eaten in 54 frames they will start
     * to take damage.
     *
     */
    @Override
    public void move() {

        // Wolves move in their preferred direction until it is changed
        // in senseNeighbors()
        switch(_direction) {
            case 0:
                _location.x++;
                break;
            case 1:
                _location.x--;
                break;
            case 2:
                _location.y++;
                break;
            case 3:
                _location.y--;
                break;
            default:
                break;
        }

        // Wolves take damage if they have not eaten for 50 frames
        if(_frames > 50) {
            _health--;
        }
        _frames++;

    }

    /**
     * Wolves spawn a new wolf to the left of them
     * if they have recently eaten.
     */
    @Override
    public Wolf spawnNewCreature() {

        if (_spawn) {
            Wolf baby = new Wolf();
            Point babyLocation = new Point(_location.x - 1, _location.y);
            baby.setLocation(babyLocation);
            _spawn = false;
            return baby;
        }
        else
            return null;
    }
}
