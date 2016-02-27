import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by oriola on 2015-12-10.
 *
 * --- Day 4: The Ideal Stocking Stuffer ---

 Santa needs help mining some AdventCoins (very similar to bitcoins) to use as gifts for all the economically forward-thinking little girls and boys.

 To do this, he needs to find MD5 hashes which, in hexadecimal, start with at least five zeroes. The input to the MD5 hash is some secret key (your puzzle input, given below) followed by a number in decimal. To mine AdventCoins, you must find Santa the lowest positive number (no leading zeroes: 1, 2, 3, ...) that produces such a hash.

 For example:

 If your secret key is abcdef, the answer is 609043, because the MD5 hash of abcdef609043 starts with five zeroes (000001dbbfa...), and it is the lowest such number to do so.
 If your secret key is pqrstuv, the lowest number it combines with to make an MD5 hash starting with five zeroes is 1048970; that is, the MD5 hash of pqrstuv1048970 looks like 000006136ef....
 Your puzzle answer was 117946.

 --- Part Two ---

 Now find one that starts with six zeroes.

 Your puzzle answer was 3938038.


 */
public class Day4 {

    public static byte[] getMD5(String input) throws UnsupportedEncodingException, NoSuchAlgorithmException{

            byte[] bytesOfMessage = input.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] result = md.digest(bytesOfMessage);

            return result;


    }

    public static void main(String args[]){

        String main = "ckczppom";


        try {

            boolean found = false;
            Integer integer = new Integer(0);

            while(found == false){
                String input = main.concat(integer.toString());
                byte[] result = getMD5(input);


                if(result[0] == 0 && result[1] == 0 && result[2] < 16 && result[2] >= 0) {
                    found = true;
                    for(byte b : result){
                        System.out.printf("%02x \n", b);
                    }
                    System.out.println("The 5 zero number is: " + integer.toString());
                }else{
                    found = false;
                    integer++;
                }

            }

            //reset
            found = false;
            integer = 0;
            while(found == false){
                String input = main.concat(integer.toString());
                byte[] result = getMD5(input);


                if(result[0] == 0 && result[1] == 0 && result[2] == 0 ) {
                    found = true;
                    for(byte b : result){
                        System.out.printf("%02x \n", b);
                    }
                    System.out.println("The 6 zero number is: " + integer.toString());
                }else{
                    found = false;
                    integer++;
                }

            }



         //   System.out.printf("%x \n", result[0]);



        }catch(UnsupportedEncodingException e){
            System.out.println(e.getMessage());
        }catch(NoSuchAlgorithmException e){
            System.out.println(e.getMessage());
        }



    }

}
