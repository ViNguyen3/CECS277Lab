import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.ArrayList;

class Main {

  public static Scanner in = new Scanner(System.in);


  
  public static void main(String[] args) throws FileNotFoundException
  {
      int points = 0;
      String play;

      ArrayList<CreepyCrawler> crawlers = new ArrayList<CreepyCrawler>();
      ArrayList<Question> answeredQuestions = new ArrayList<Question>();
      crawlers.add(new Spider());
      crawlers.add(new Centipede());
      crawlers.add(new Spider());
      crawlers.add(new Centipede());
      System.out.println("You have been placed in a coffin with the following creepy crawlers:");

      CrawlerTriviaUtil.printCrawlers(crawlers);

      System.out.println("The only way to escape the coffin is if you earn enough hit points to kill each crawler.  \nAnswer the trivia questions to earn a random number of points but BEWARE! \nIf you answer incorrectly, a crawler will clone!");


      System.out.println();
      int temp2 = 0 ;
      

      do{
        if(crawlers.size() == 0)
        {
          System.out.println("You win !");
          break; 
        }
        System.out.println("\n===================================================");
        System.out.println("Question: ");
        Question q;
        
        do{
          q = CrawlerTriviaUtil.generateQuestion();
        }while(answeredQuestions.contains(q));
        
        q.displayQuestion();

        System.out.print("\nYour answer: ");
        String response = in.nextLine().trim();
      
        //FIXME: IMPLEMENT THE REST OF THE GAME
        //Checking response 
        int temp1 = q.checkResponse(response);
        if(temp1 != 0) 
        {
          System.out.println("Correct! You've earned " + temp1);
          points += temp1; 
          System.out.println("Your total points: " + Integer.toString(points));
          temp2 = (CrawlerTriviaUtil.getMinCrawler(crawlers)).getHp(); 
          if(points >= temp2)
          {
            System.out.println("You have enough points to kill...");
            System.out.println(CrawlerTriviaUtil.getMinCrawler(crawlers).toString()); 
            for(int n = 0; n < crawlers.size(); n++)
            {
              CreepyCrawler min = CrawlerTriviaUtil.getMinCrawler(crawlers);
              System.out.println("Minimum: " + min);

              CreepyCrawler current = crawlers.get(n);
              System.out.println("Current: " + current);     

              if (min.equals(current))
              {
                System.out.println("index: " + n);
                points -= crawlers.get(n).getHp();
                crawlers.remove(n); 
                break; 
              }
            }
            System.out.println("Your total points: " + Integer.toString(points));        
            CrawlerTriviaUtil.printCrawlers(crawlers);

          }
        }
        else 
        {
          System.out.println("You are wrong");
          System.out.println("\nThe correct one is: " + q.getAnswer()); 
          System.out.println("\nYour incorrect answers led to this crawler's cloning!\n"); 
          crawlers.add(CrawlerTriviaUtil.generateClone(crawlers));
          CrawlerTriviaUtil.printCrawlers(crawlers);
        }

        if(crawlers.isEmpty()) {
          System.out.println("\nYou have killed all the crawlers and have escaped the coffin!\nYOU WIN!");
          break;
        }
        
      
        System.out.print("\nKeep playing? Y/N: ");
        play = in.nextLine().trim();
      }while(!play.equalsIgnoreCase("N"));



  }
}