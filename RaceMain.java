//PROVIDED BY: JONATHAN LUZINCOURT
//EMAIL: jluzinc000@citymail.cuny.edu

import java.util.Random;
import java.util.Arrays;
public class RaceMain {
    public static int tRun;
    public static int hRun;
    public static char[] race = new char[70];
    public static final Random rand = new Random();
    
     public static void action(){ //Race track method    
        Arrays.fill(race, ' '); //Fills the array with 70 space characters
        String same = "B "; 
        if(tRun == hRun){ //When Hare and Tortoise are tied it inserts B
            for(int i = tRun; i < same.length(); i++){
               race[i] = same.charAt(i - tRun);
        }
        }else{
            if(tRun <= 0){
                tRun = 0;
            }else if(hRun <= 0){
                hRun = 0;
            }
            // Keeps track of the positions of the animals
                race[tRun] = 'T';
                race[hRun] = 'H';
        }
        for(char t : race){
            System.out.print(t);
        }
    } 
    public static void moveT(){ //Tortoise movement method
            int randomizer = 1 + rand.nextInt(10);
            if(randomizer <= 5){ //Fast Plod
                tRun += 3;
            }else if(randomizer == 8 || randomizer == 9){ //Slip
               tRun -= 6;
            }else{ //Slow plod
                tRun += 1;
            }
            if(tRun < 1){
              tRun = 0;
            }
    }
    public static void moveH(){ //Hare movement method
             int randomizer = 1 + rand.nextInt(10);
             if(randomizer <= 2){ // Sleep
                 hRun += 0;
             }else if(randomizer > 2 && randomizer < 5){ //Big Hop
                 hRun += 9;
             }else if(randomizer == 5){ //Big slip
                 tRun -= 12;
             }else if(randomizer > 5 && randomizer < 9){ //Small hop
                 tRun += 1;
             }else{ //Small slip
                 tRun -= 2;
             }
             if(hRun < 1){
                 hRun = 0;
             }
    } 
    public static void main(String[] args) {
        tRun = 0;
        hRun = 0;
        
        System.out.print("ON YOUR MARK, GET SET \nBANG !!!!! \nAND THEY'RE OFF !!!!!\n");
        int timer = 0;
        while(tRun < 70 && hRun < 70){// Loop to continue the race
            System.out.println();
            System.out.printf("Time: %d%n", timer);
            action();
            moveT();
            moveH();
            int[] x = new int[70];
            System.out.println();
            for(int i = 1; i < x.length; ++i){ //Race Track
                char c = '-';
                System.out.printf("%s", c);
            }
            ++timer;// Each time it loops the timer increments
        }
        
        System.out.println();
        //Cases at the end of the race
        if(tRun >= 70){
             System.out.println("TORTOISE WINS!!! YAY!!!");
         }
         if(hRun >= 70){
             System.out.println("Hare wins.Yuch.");
         }
         System.out.printf("Time Elapsed = " + timer + " seconds");
        
    }
}