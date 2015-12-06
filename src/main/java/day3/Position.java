package day3;

/**
 * Created by Mihai on 12/4/2015.
 */
public class Position {


    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position getNewPosition(char move){
        switch(move) {
            case 'v': return new Position(x -1, y );
            case '^': return new Position(x + 1, y );
            case '>': return new Position(x , y+ 1);
            case '<': return new Position(x, y -1);

            default: return null;
        }
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        return y == position.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main(String[] args) {
        for(int i = 0; i<10-1; i+=2){
            System.out.println(i);
            System.out.println(i+1);
        }
    }
}
