package teach03;

import java.util.Map;
import java.util.HashMap;

public class Player {
    String _name;
    int _health;
    int _mana;
    int _gold;
    Map<String, Integer> _equipment;

    public Player(String _name, int _health, int _mana, int _gold) {
        this._name = _name;
        this._health = _health;
        this._mana = _mana;
        this._gold = _gold;
        _equipment = new HashMap<String, Integer>();
    }

    @Override
    public String toString() {
        return "Player{" +
                "_name='" + _name + '\'' +
                ", _health=" + _health +
                ", _mana=" + _mana +
                ", _gold=" + _gold +
                ", _equipment=" + _equipment +
                '}';
    }

    public void addEquipment(String item, int value) {
        _equipment.put(item, value);
    }
}
