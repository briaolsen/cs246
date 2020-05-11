package prove02;

import java.awt.*;
import java.util.Random;

/**
*  Animals move around and eat plants. They are represented by red squares.
* <p>
* @author  Brother Falin
* @version 1.0
* @since   2016-12-08 
* @see Creature
*/
public class Animal extends Creature implements Movable, Aggressor, Spawner, Aware {
	
	Random _rand;
	boolean _spawn;
	int _spawns;
	int _frames;
	
	/**
	* Creates an animal with 1 health point.
	*/
	public Animal() {
		_rand = new Random();
		_health = 1;
		_spawn = false;
		_frames = 0;
	}
	
	// No javadocs are necessary for these methods because they will inherit the 
	// documentation from the superclass. We only need to add docs here if we are
	// doing something non-obvious in our overridden version.
	
	public Boolean isAlive() {
		return _health > 0;
	}
	
	public Shape getShape() {
		return Shape.Square;
	}
	
	public Color getColor() {
		return new Color(165, 33, 135);
	}
	
	/**
	* If the creature we've encountered is a plant, we'll eat it. Otherwise, we ignore it.
	* @param target The {@link Creature} we've encountered.
	*/
	public void attack(Creature target) {
		// Animals only eat plants. Give the plant 1 damage
		// and increase our health by one.
		if(target instanceof Plant) {
			target.takeDamage(1);
			_health++;
			_spawns += 3;
			_frames = 0;
		}
	}
	
	/**
	* Move the animal in a random direction.
	*/
	public void move() {
		
		// Choose a random direction each time move() is called.
		switch(_rand.nextInt(4)) {
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

		// Animals take damage if they haven't eaten in 100 frames
		if(_frames > 100) {
			_health--;
		}
		_frames++;
	}

	@Override
	public Creature spawnNewCreature() {
		if (isSpawn()) {
			Animal baby = new Animal();
			Point babyLocation = new Point(_location.x - 1, _location.y);
			baby.setLocation(babyLocation);
			_spawns--;
			return baby;
		}
		else
			return null;
	}

	@Override
	public boolean isSpawn() {
		if (_spawns > 0) {
			_spawn = true;
		} else {
			_spawn = false;
		}

		return _spawn;
	}

	@Override
	public void senseNeighbors(Creature above, Creature below, Creature left, Creature right) {

		for(int i = 0; i < 4; i++) {
			// eat nearest plant
			switch (i) {
				case 0:
					if (right instanceof Plant) {
						attack(right);
						return;
					} else {
						break;
					}
				case 1:
					if (left instanceof Plant) {
						attack(left);
						return;
					} else {
						break;
					}
				case 2:
					if (below instanceof Plant) {
						attack(below);
						return;
					} else {
						break;
					}
				case 3:
					if (above instanceof Plant) {
						attack(above);
						return;
					} else {
						break;
					}
				default:
					break;
			}
		}
	}
}
