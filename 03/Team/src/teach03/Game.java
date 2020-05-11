package teach03;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Game {

    Player _player;

    public Game(Player _player) {
        this._player = _player;
    }

    public void saveGame(String fileName) {

        Gson gson = new Gson();
        String player = gson.toJson(this._player);

        File myFile = new File(fileName);

        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(player);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public static Game loadGame(String fileName) {

        Gson gson = new Gson();

        try {
            File myFile = new File(fileName);
            Scanner myScanner = new Scanner(myFile);
            String player = myScanner.nextLine();
            Player newPlayer = gson.fromJson(player, Player.class);
            return new Game(newPlayer);
        } catch (FileNotFoundException e){
            System.out.println("An error occurred.");
        }
        return null;
    }

    @Override
    public String toString() {
        return "Game{" +
                "_player=" + _player +
                '}';
    }
}
