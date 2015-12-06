package day5;

import java.io.*;
import java.util.LinkedList;

/**
 * Created by Mihai on 12/5/2015.
 */
public class AppMain {

    static String[] bad = new String[]{"ab", "cd", "pq", "xy"};


    public static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

    public static boolean checkTwiceGroup(String input){
        for(int i =0 ; i<input.length()-1;i++){
            String group =  input.substring(i, i + 2);
            String restOfString = (input.substring(i+2,input.length()));
            if (restOfString.contains(group) ) return true;

        }

        return false;}


    public static boolean checkTwiceCharacter(String string){
        char[] input = string.toCharArray();
        for(int i = 0; i<input.length-2; i++){
            if(input[i] == input[i+2])
                return  true;
        }
        return false;
    }

    static int nrC = 0 , nrG = 0;

    public static boolean checkStringComplicated(String inputString){

        boolean b = checkTwiceCharacter(inputString);
        boolean c  = checkTwiceGroup(inputString);
        System.out.println("tc: " + b);
        System.out.println("tG: " + c);
        if(!b ) nrC++;
        if(!c ) nrG++;
        return b && c;
    }

    public static boolean checkString(String inputString) {
        for (String s : bad) {
            if (inputString.contains(s)) {
                return false;
            }
        }

        char[] input = inputString.toCharArray();
        boolean vowel = false, twice = false;

        int nrVowel = 0;

        for (int i = 0; i < input.length - 1; i++) {
            if (isVowel(input[i]))
                nrVowel++;

            if (!twice && input[i] == input[i + 1])
                twice = true;

        }

        if (isVowel(input[input.length - 1]))
            nrVowel++;

        return (nrVowel > 2) && twice;
    }

    public static String[] readFile(String fileName) throws IOException {
        LinkedList<String> linkedList = new LinkedList<String>();
        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                linkedList.add(line);
            }
        } finally {
            String[] read = new String[linkedList.size()];
            int i = 0;
            for (String s : linkedList) {
                read[i++] = s;
            }
            return read;
        }
    }

    public static void printCheck(String input) {
        System.out.println(input + " : " + (checkString(input) ? "nice" : "naughty"));
    }

    public static void printComplicatedCheck(String input){
        System.out.println(input + " : " + (checkStringComplicated(input) ? "nice" : "naughty"));
    }

    public static void main(String[] args) throws IOException {

//        printComplicatedCheck("qjhvhtzxzqqjkmpb");
//        printComplicatedCheck("xxyxx");
//        printComplicatedCheck("uurcxstgmygtbstg");
//        printComplicatedCheck("ieodomkazucvgmuy");


        String[] date = readFile("date5");

        int i = 0, j = 0;

        for (String input : date) {
//            if (checkString(input))
//                i++;
            printComplicatedCheck(input);
            if(checkStringComplicated(input))
                j++;
        }
        System.out.println(date.length);
        System.out.println(nrC);
        System.out.println(nrG);
        System.out.println("Computed: " + i);
        System.out.println("Complicated: " + j);


    }
}
