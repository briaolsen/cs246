package teach03;

public class Main {

    public static void main(String[] args) {
        Player player = new Player("Briana", 150, 20, 300);
        player.addEquipment("Breastplate", 1);
        player.addEquipment("Helm", 40);
        player.addEquipment("Bread", 2);
        player.addEquipment("The Master Sword", 50);
        Game game = new Game(player);
        game.saveGame("03texttest.txt");

        System.out.println(game);

        Game game2 = game.loadGame("03texttest.txt");
        System.out.println(game2);
    }
}
