package prove02;

import java.awt.*;
import java.util.Random;

/**
 * Hunters kill wolves, animals, and zombies at range of one block.
 * They are represented by orange circles.
 * <p>
 * @author  Briana Olsen
 * @version 1.0
 * @since   2020-05-01
 * @see Creature
 */

public class Hunter extends Creature implements Movable, Aggressor, Aware {

    Random _rand;
    int _direction;
    int _frames;

    /**
     * Creates a hunter with 20 health points.
     */
    public Hunter() {
        _rand = new Random();
        _direction = _rand.nextInt(4);
        _health = 20;
    }

    /**
     * If the creature we've encountered is an animal, eat it.
     * If target is a zombie or wolf, attack it for 30 damage
     * and take damage in return.
     * @param target The {@link Creature} we've encountered.
     */
    @Override
    public void attack(Creature target) {
        // Hunters will attack and kill a zombie/wolf
        // but will take damage
        if(target instanceof Zombie || target instanceof Wolf) {
            target.takeDamage(30);
            _health--;
        }

        // Hunters will eat animals and gain health
        if(target instanceof Animal) {
            target.takeDamage(30);
            _health++;
        }
    }

    /**
     * Hunters sense any animal, wolf, or zombie within a square
     * turn towards that creature, and attack it.
     */
    @Override
    public void senseNeighbors(Creature above, Creature below, Creature left, Creature right) {

        // check for animals starting in the direction of movement
        int d = _direction;

        for(int i = 0; i < 4; i++) {

            // Hunters attack any neighboring creature (except Hunters)
            switch(d) {
                case 0:
                    if (right instanceof Animal ||
                        right instanceof Wolf   ||
                        right instanceof Zombie   ) {

                        _direction = 0;
                        _frames = 0;
                        attack(right);
                        return;
                    } else {
                        break;
                    }
                case 1:
                    if (left instanceof Animal ||
                        left instanceof Wolf   ||
                        left instanceof Zombie   ) {

                        _direction = 1;
                        _frames = 0;
                        attack(left);
                        return;
                    } else {
                        break;
                    }
                case 2:
                    if (below instanceof Animal ||
                        below instanceof Wolf   ||
                        below instanceof Zombie   ) {

                        _direction = 2;
                        _frames = 0;
                        attack(below);
                        return;
                    } else {
                        break;
                    }
                case 3:
                    if (above instanceof Animal ||
                        above instanceof Wolf   ||
                        above instanceof Zombie   ) {

                        _direction = 3;
                        _frames = 0;
                        attack(above);
                        return;
                    } else {
                        break;
                    }
                default:
                    break;
            }

            // check for other zombies in a clockwise pattern
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
        return Shape.Circle;
    }

    @Override
    Color getColor() {
        return new Color(255, 113, 0);
    }

    @Override
    Boolean isAlive() {
        return _health > 0;
    }

    /**
     * Hunter changes direction every 10 frames if they
     * haven't attacked anything.
     */
    @Override
    public void move() {

        _frames++;

        // Hunter will change direction every 10 frames
        // if they haven't attacked anything
        if (_frames > 10) {
            _direction = _rand.nextInt(4);
            _frames = 0;
        }

        // Hunter will continue in preferred direction
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

    }
}
