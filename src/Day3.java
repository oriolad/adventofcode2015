import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by oriola on 2015-12-05.
 *
 * --- Day 3: Perfectly Spherical Houses in a Vacuum ---

 Santa is delivering presents to an infinite two-dimensional grid of houses.

 He begins by delivering a present to the house at his starting location, and then an elf at the North Pole calls him via
 radio and tells him where to move next. Moves are always exactly one house to the north (^), south (v), east (>), or west (<).
 After each move, he delivers another present to the house at his new location.

 However, the elf back at the north pole has had a little too much eggnog, and so his directions are a little off, and Santa
 ends up visiting some houses more than once. How many houses receive at least one present?

 For example:

 > delivers presents to 2 houses: one at the starting location, and one to the east.
 ^>v< delivers presents to 4 houses in a square, including twice to the house at his starting/ending location.
 ^v^v^v^v^v delivers a bunch of presents to some very lucky children at only 2 houses.

 --- Part Two ---

 The next year, to speed up the process, Santa creates a robot version of himself, Robo-Santa, to deliver presents with him.

 Santa and Robo-Santa start at the same location (delivering two presents to the same starting house), then take turns moving
 based on instructions from the elf, who is eggnoggedly reading from the same script as the previous year.

 This year, how many houses receive at least one present?

 For example:

 ^v delivers presents to 3 houses, because Santa goes north, and then Robo-Santa goes south.
 ^>v< now delivers presents to 3 houses, and Santa and Robo-Santa end up back where they started.
 ^v^v^v^v^v now delivers presents to 11 houses, with Santa going one direction and Robo-Santa going the other.

 */
public class Day3 {

    private static final String DAY3_INPUT = "/Users/oriola/Workspace/AdventOfCode/src/Day3_input.txt";

    public static int uniqueHomeCount(Point pointA, Point pointB){

        Set<Point> uniqueHomes = new HashSet<Point>();

        uniqueHomes.add(pointA);
        uniqueHomes.add(pointB);


        // Read from file
        try{
            FileReader fileReader = new FileReader(DAY3_INPUT);
            int cursor;

            Point currentPoint;
            boolean currentTurn = true;


            while((cursor = fileReader.read()) != -1) {
                char input = (char) cursor;

                if(currentTurn){
                    currentPoint = pointA;
                }else{
                    currentPoint = pointB;
                }

                if(input == '^'){
                    currentPoint.incrY();
                }

                if(input == 'v'){
                    currentPoint.decrY();
                }

                if(input == '>'){
                    currentPoint.incrX();
                }

                if(input == '<'){
                    currentPoint.decrX();
                }


                uniqueHomes.add(new Point(currentPoint));
                currentTurn = !currentTurn;

            }

        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        return uniqueHomes.size();
    }


    public static void main(String args[]){

        // Part 1
        Point santasPoint = new Point(0,0);
        int part1_answer = uniqueHomeCount(santasPoint, santasPoint);
        System.out.println("PART 1 This many houses receive at least one present: " + part1_answer);

        // Part 2
        santasPoint = new Point(0,0);
        Point robosantaPoint = new Point(0, 0);
        int part2_answer = uniqueHomeCount(santasPoint, robosantaPoint);
        System.out.println("PART 2 This many houses receive at least one present: " + part2_answer);



    }
}
