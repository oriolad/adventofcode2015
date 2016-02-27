import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by oriola on 2015-12-14.
 */
public class Day5 {



    public static boolean check(List<String> rules, String input){

        for(String rule: rules){
            Pattern pattern = Pattern.compile(rule);
            Matcher matcher = pattern.matcher(input);
//            System.out.println("Rule: " + rule + ", Input: " + input + ", Match: " + matcher.matches());
            System.out.printf("Rule: %s, Input: %s, Match: %s\n",rule,input,matcher.matches());

            if(!matcher.matches()){
                return false;
            }
        }

        return true;
    }



    public static void main(String args[]) throws IOException{

        List<String> rules = new ArrayList<>();
        rules.add(".*[aeiou].*[aeiou].*[aeiou].*");
        rules.add(".*([a-z])\\1.*");
        rules.add(".*(?!ab).*");
        rules.add(".*(?!cd).*");
        rules.add(".*(?!pq).*");
        rules.add(".*(?!xy).*");
//        rules.add(".*(!ab&&!cd|!pq|!xy).*");

        FileReader fileReader = new FileReader("/Users/oriola/Workspace/AdventOfCode/src/Day5_input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String currentLine;
        boolean match;
        int niceStringCount = 0;

        while((currentLine = bufferedReader.readLine()) != null){
            match = check(rules, currentLine);

            if(match){
                niceStringCount++;
            }

            System.out.println(currentLine + " - " + match);

        }

        System.out.println("Number of nice strings is: " + niceStringCount);
    }
}
