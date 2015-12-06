package day6;

/**
 * Created by Mihai on 12/6/2015.
 */
public class Grid {
    int[][] houses;

    public Grid() {
        this(1000, 1000);
    }

    public Grid(int x) {
        this(x, x);
    }

    public Grid(int x, int y) {
        houses = new int[x][y];
    }

    public void validate(int x1, int y1, int x2, int y2) {
        if (x1 > x2 || y1 > y2)
            throw new IllegalArgumentException("reverseRectangle");
        if (x1 >= houses.length || x2 >= houses.length || y1 >= houses.length || y2 >= houses.length)
            throw new IllegalArgumentException("outOfgrid");
    }

    public void turnOn(int x1, int y1, int x2, int y2) {
        setHouses(x1, y1, x2, y2, 1);
    }

    public void setHouses(int x1, int y1, int x2, int y2, int power) {
        validate(x1, y1, x2, y2);
        for (int i = x1; i <= x2; i++)
            for (int j = y1; j <= y2; j++)
                if (power > 0) {
                    houses[i][j] += power;
                } else if (houses[i][j] + power >= 0)
                    houses[i][j] += power;
    }

    public void turnOff(int x1, int y1, int x2, int y2) {
        setHouses(x1, y1, x2, y2, -1);
    }

    public void toggle(int x1, int y1, int x2, int y2) {
//        validate(x1, y1, x2, y2);
//        for(int i = x1; i<=x2; i++)
//            for(int j = y1; j<=y2; j++)
//                houses[i][j] = !houses[i][j];
        setHouses(x1, y1, x2, y2, 2);

    }


    public int getLit() {
        int s = 0;
        for (int i = 0; i < houses.length; i++) {
            for (int j = 0; j < houses.length; j++)
//                    if(houses[i][j])
//                        s+=1;
                s += houses[i][j];
        }
        return s;
    }




}

