package prove02;

/**
 * Returns true if a creature can spawn.
 * Creatures can create new creatures.
 * <p>
 * @author  Briana Olsen
 * @version 1.0
 * @since   2020-04-01
 * @see Creature
 */

public interface Spawner {

    /**
     * Returns a creature that has been spawned
     * @return
     */
    public Creature spawnNewCreature();

    /**
     * Returns true if a creature can spawn another creature.
     * @return
     */
    public boolean isSpawn();

}
