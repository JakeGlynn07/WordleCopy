import java.io.*;
import java.util.*;

public class Wordle {
    
    // This method will generate a real 5 letter word based on a seperate list of words
    public static String pickFiveLetterWord() {        
        try {
            // Count the amount of words
            int numOfWords = 0;
            Scanner countLines = new Scanner (new File("wordle-answers.txt"));
            while(countLines.hasNextLine()) {
                countLines.nextLine();
                numOfWords ++;
            }
            countLines.close();

            // Create an fill an array
            String[] words = new String[numOfWords];
            Scanner reader = new Scanner (new File("wordle-answers.txt"));
            for (int i=0; i<numOfWords; i++) {
                words[i] = reader.nextLine();
            }
            reader.close();

            Random r = new Random();
            return words[r.nextInt(numOfWords)];

        } catch (IOException e) {
            System.out.println("Can't read word file.");
            return null;
        }
    }
    
    public static void main (String[] argv) {
        String answer = pickFiveLetterWord();
        System.out.println(answer);
    }
}