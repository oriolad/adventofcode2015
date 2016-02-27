import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by oriola on 2015-12-04.
 */
public class Day1 {

    public static void main(String args[]) throws IOException{


        System.out.println("Enter input:");
        InputStreamReader inputReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputReader);

        String input = bufferedReader.readLine();

        int floor = 0;
        int countInstructions = 1;
        boolean basementFloorHit = false;

        char[] inputCharArray = input.toCharArray();

        for (char c : inputCharArray){
            if(c == '('){
                floor++;
            }else if(c == ')') {
                floor--;
            }

            if(basementFloorHit == false)
                if(floor == -1) {
                    basementFloorHit = true;
                }else {
                    countInstructions++;
                }
            }

        String floorString = String.valueOf(floor);

        System.out.println("Total Number of Floors:" + floorString);
        System.out.println("Basement Hit at Instruction #: " + countInstructions);


    }
}
