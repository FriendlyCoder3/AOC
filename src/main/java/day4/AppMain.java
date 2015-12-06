package day4;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by Mihai on 12/4/2015.
 */
public class AppMain {


    public static byte[] getKey(String message ) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] digest = messageDigest.digest(message.getBytes());
        return digest;
    }

    public static String getHex(byte[] data){
        char[] chars = Hex.encodeHex(data);
        return new String(chars);
    }


    public static String getHexKey(String message) throws NoSuchAlgorithmException {
        return getHex(getKey(message));

    }

    public static long getSolution(String original, String target) throws NoSuchAlgorithmException {
        long i =0000;
        while(true){
            String hexKey = getHexKey(original + i);
            if(hexKey.startsWith(target))
                return i;

            i++;

        }
    }

    public static void printSolutin(String message) throws NoSuchAlgorithmException {
        System.out.println(message + " : " + getSolution(message, "00000"));
    }

    public static void printSolutin(String message, String target) throws NoSuchAlgorithmException {
        System.out.println(message + " : " + getSolution(message, target));
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        printSolutin("abcdef");
        printSolutin("pqrstuv");
        printSolutin("iwrupvqb", "000000");



    }
}
