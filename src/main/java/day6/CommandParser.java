package day6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Mihai on 12/6/2015.
 */
public class CommandParser {

    Grid grid;

    Pattern regex = Pattern.compile("\\d+");

    public CommandParser(Grid grid) {
        this.grid = grid;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public int getStatus(){
        return grid.getLit();
    }

    public void revertOriginalState(){
        this.grid = new Grid();
    }

    private void passComand(int[] corners, int command){
    int x1 = corners[0],
        y1 = corners[1],
        x2 = corners[2],
        y2 = corners[3];

        if(command == 1)
            grid.turnOn(x1,y1,x2,y2);
        else if(command ==2)
            grid.turnOff(x1,y1,x2,y2);
        else if(command == 3)
            grid.toggle(x1,y1,x2,y2);
    }




    public void parse(String command){
        Matcher matcher = regex.matcher(command);
        int[] colturi = new int[4]; int i = 0;

        while(matcher.find()){
            colturi[i++] = Integer.parseInt(matcher.group());
        }
        if(i!=4){
            System.out.println(command);
            System.out.println(i);
            for(int j=0;j<i;j++){
                System.out.println(colturi[j]);
            }
            throw new IllegalArgumentException("numere");

        }
        if(command.startsWith("turn on"))
        {
            passComand(colturi,1);
        }
        else if(command.startsWith("turn off")){
            passComand(colturi,2);

        }
        else if(command.startsWith("toggle")){
            passComand(colturi,3);
        }

    }

}
