import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by oriola on 2015-12-05.
 */
public class Day2 {

    public static void main(String args[]){

        try {
            FileReader fileReader = new FileReader("/Users/oriola/Workspace/AdventOfCode/src/Day2_input.txt");
            BufferedReader textReader = new BufferedReader(fileReader);
            int totalWrappingArea = 0;
            int totalRibbonLength = 0;
            String currentLine;

            while ((currentLine = textReader.readLine()) != null) {
                String[] dimensions = currentLine.split("x",3);
                PresentBox present = new PresentBox(dimensions);

                totalWrappingArea = totalWrappingArea + present.getWrappingPaperArea();
                totalRibbonLength = totalRibbonLength + present.getTotalRibbonLength();

                System.out.println("Length:" + dimensions[0] + ",Width" + dimensions[1] + ",Height" + dimensions[2] + ": " + present.getWrappingPaperArea());
            }

            System.out.println("Total Wrapping Area = " + totalWrappingArea);
            System.out.println("Total Ribbon Length = " + totalRibbonLength);

        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

}
