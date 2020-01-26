import com.google.gson.Gson;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Game {

  Player player;
  final static String FILESAVED = "G:\\Coby\\school_projects\\CS246\\W03\\Teach-03\\src\\savedGame.txt";

  public Game(Player player) {
    this.player = player;
  }

  public Player getPlayer() {
    return player;
  }


  public void saveGame(String fileName) {
    Gson gson = new Gson();
    String playerData = gson.toJson(player);


   // String newFile = createFile(fileName);
    writeFile (fileName, playerData);

  }

  public static Game loadGame(String fileName) {
    String playerData = readFile(fileName);
    Gson gson = new Gson();
    Player loadedPlayer = gson.fromJson(playerData, Player.class);

    Game newGame = new Game(loadedPlayer);
    return newGame;
  }


  /*private String createFile(String fileName) {
    File myObj = new File(fileName);
    try {
      myObj.createNewFile();

    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    return myObj.getName();
  }
*/
  private void writeFile(String fileName, String playerData) {
    try {
      FileWriter myWriter = new FileWriter(fileName);
      myWriter.write(playerData);
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  private static String readFile(String fileName) {
    String data = "";
    try {
      File myObj = new File(fileName);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        data += myReader.nextLine();
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
     return data;

  }

  public static void main(String[] args) {
    Player newPlayer = new Player("Bob",1000, 2000, 3000);
    newPlayer.addEquipment("helmet", 50000);
    Game game = new Game(newPlayer);
    game.saveGame(FILESAVED);

    Game newGame = loadGame(FILESAVED);

  }
}
