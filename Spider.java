import java.util.Random;

/**
This class is a child class of CreepyCrawler and 
represents a Spider with randomly selected String name
**/
public class Spider extends CreepyCrawler
{
  private String name;

  /**
  Initializes a Centipede with random HP in the range 80 - 100
  and randomly generated name.
  **/
  public Spider(){
    super(Spider.generateHP());
    this.name = Spider.generateType() + " Spider";
  }

  @Override
  public CreepyCrawler clone( ) {
    return new Spider();
  }


  /**
  returns the String representation of this Spider
  **/
  public String toString(){
    
    return String.format("Name: %-20s%-20s%-10s", this.name, super.toString(), "\uD83D\uDD77\n" );
  }

  // returns a random integer in the range 80 - 100
  private static int generateHP(){
    Random rand = new Random();
    int randomHP = rand.nextInt(20) + 80;
    return randomHP;

  }

  // returns a randomly selected type of Spider
  private static String generateType(){
    String[] spiderTypes = {"Tarantula", "Wolf", "Jumping", "Grass", "Orb"};
    Random rand = new Random();
    int idx = rand.nextInt(spiderTypes.length);
    return spiderTypes[idx];
  }
}