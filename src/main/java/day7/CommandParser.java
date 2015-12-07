package day7;

import java.util.*;

/**
 * Created by Mihai on 12/8/2015.
 */
public class CommandParser {


    //in circuite punem valorile
     Map<String, Integer> circuite = new HashMap<String, Integer>();
     static final int mask = 0xFFFF;

    public  int getValueOrNumber(String s) {
        if (//s.length() == 1 && s.charAt(0) >= 'a' && s.charAt(0) <= 'z' &&
                circuite.get(s)!=null)
        {
            return circuite.get(s);
        }
        else
            return Integer.parseInt(s);
    }

    public  int evalOp(int a, int b, String op) {
        switch(op){
            case "AND" : return a & b;
            case "OR" : return a | b;
            case "LSHIFT" : return a << b;
            case "RSHIFT" : return a >> b;
            default: throw new UnsupportedOperationException();}
    }

    public  int evalDoiOperatori(String[] expr) {
        int val1 = getValueOrNumber(expr[0]);
        int val2 = getValueOrNumber(expr[2]);
        return evalOp(val1, val2, expr[1]);
    }

    public  int evalueazaExpresie(String expresie) {
        int val = -1;
        String[] split = expresie.split(" ");
        System.out.println(expresie);
        if (split.length == 1) {
            //caz de numar
            return Integer.parseInt(split[0]);
        }
        if (split.length == 2) { //caz de NOT
            int i = getValueOrNumber(split[1]);
            return (~i) & mask;
        } else return evalDoiOperatori(split);
    }

    public  void parse(String s) {
        String[] split = s.split("-> ");
        int e = evalueazaExpresie(split[0]);
        circuite.put(split[1].trim(), e);
    }

    public Map<String, Integer> getCircuite() {
        return circuite;
    }

    public void setCircuite(Map<String, Integer> circuite) {
        this.circuite = circuite;
    }

    public void showAll(){
        Set<Map.Entry<String, Integer>> entries = circuite.entrySet();

        for(Map.Entry e : entries){
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }
}
