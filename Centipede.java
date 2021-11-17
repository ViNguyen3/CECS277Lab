import java.util.Random;
/**
This class is a child class of CreepyCrawler and 
represents a Centipede with given String name "Centipede"
**/
public class Centipede extends CreepyCrawler
{

  private String name;

  /**
  Initializes a Centipede with random HP in the range 90 - 120
  and name "Centipede"
  **/
  public Centipede(){
    super(Centipede.generateHP());
    this.name = "Centipede";
  }
 
  @Override
  public CreepyCrawler clone( ) {
    return new Centipede();
  }

  public String toString(){
    return String.format("Name: %-20s%-20s%-10s", this.name, super.toString(), "\uD83D\uDC1B\n" );
  }

  // returns a random integer in the range 90 - 120
  private static int generateHP(){
    Random rand = new Random();
    int randomHP = rand.nextInt(30) + 90;
    return randomHP;

  }
  
}