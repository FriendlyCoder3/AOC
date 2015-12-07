package day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Mihai on 12/8/2015.
 */



public class AppMain {

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



    public static void main(String[] args) throws IOException {
        int x = 123,y = 456;
        int mask = 0xFFFF;
        System.out.println(x & y);
        System.out.println(x | y);
        System.out.println(x << 2);
        System.out.println(y >> 2);
//        System.out.println(65535- x);
//        System.out.println(65535- y);
//        System.out.println(mask);
        System.out.println(~x & mask);
        System.out.println(~y & mask);


       CommandParser commandParser = new CommandParser();

        commandParser.parse("123 -> x");
        commandParser.parse("456 -> y");
        commandParser.parse("x AND y -> d");
        commandParser.parse("x OR y -> e");
        commandParser.parse("x LSHIFT 2 -> f");
        commandParser.parse("y RSHIFT 2 -> g");
        commandParser.parse("NOT x -> h");
        commandParser.parse("NOT y -> i");

        commandParser.showAll();
        System.out.println("\n\nFisier: ");
        String[] date = readFile("day7");

        CommandParser commandFisier = new CommandParser();

        for(String com : date){
            commandFisier.parse(com);
        }
        commandFisier.showAll();
    }
}
