package day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Mihai on 12/6/2015.
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


    public static void printResult(String command){
        Grid grid = new Grid();
        CommandParser commandParser = new CommandParser(grid);
        commandParser.parse(command);
        commandParser.parse("turn off 0,0 through 999,999");
        System.out.println(command + "  -  " + commandParser.getStatus() );
    }



    public static void main(String[] args) throws IOException {
//        printResult("turn on 0,0 through 999,999");
//        printResult("toggle 0,0 through 999,0");
//        printResult("turn off 499,499 through 500,500");

//        printResult("turn on 0,0 through 0,0 ");
        printResult("toggle 0,0 through 999,999");


        String[] date = readFile("date6");
        Grid grid = new Grid();
        CommandParser commandParser = new CommandParser(grid);
        for(String com: date){
            commandParser.parse(com);
        }

        System.out.println("result: " + commandParser.getStatus());

    }
}
