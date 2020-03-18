package zum1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

public class Map {
    public int xsize,ysize;
    public int startx, starty;
    public int goalx,goaly;
    Node[][] list;

    public void save(String filename) {
        try (PrintWriter out = new PrintWriter(filename)) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < ysize; j++){
                line = new StringBuilder();
                for (int i = 0; i < xsize; i++){
                  line.append(String.valueOf(list[i][j].symbol));
                }
                out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static class Node  {
        int x, y;
        // FLAG:
        // 0 == FRESH
        // 1 == OPEN
        // 2 == CLOSED
        int flag = 0;
        char symbol = '-';
        int manDist = Integer.MAX_VALUE;
        List<Node> edge;
        Node parent;

        Node(int x,int y, char symbol){
            this.x = x;
            this.y = y;
            this.symbol = symbol;
            edge = new ArrayList<>();
        }


    }
    private int heuristic (Map.Node start, Map.Node goal){
        int x = Math.abs(start.x) < Math.abs(goal.x) ? Math.abs(goal.x) - Math.abs(start.x):Math.abs(start.x) - Math.abs(goal.x);
        int y = Math.abs(start.y) < Math.abs(goal.y) ? Math.abs(goal.y) - Math.abs(start.y):Math.abs(start.y) - Math.abs(goal.y);
        return x + y;
    }


    boolean read(String filename){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/dataset/"+filename));
            String line = reader.readLine();
            line = line.trim();
            String[] parts = line.split(" ");
            xsize = Integer.parseInt(parts[0]);
            ysize = Integer.parseInt(parts[1]);
            startx = Integer.parseInt(parts[2]);
            starty = Integer.parseInt(parts[3]);
            goalx = Integer.parseInt(parts[4]);
            goaly = Integer.parseInt(parts[5]);
            list = new Node[xsize][ysize];
            line = reader.readLine();
            for (int j = 0; j < ysize; j++){
                for (int i = 0; i < xsize; i++)
                    if (line.charAt(i) == ' ' || line.charAt(i) == 'X')
                        list[i][j] = new Node(i, j, line.charAt(i));
                line = reader.readLine();
            }
            reader.close();
            list[startx][starty].symbol = 'S';
            list[goalx][goaly].symbol = 'E';
            this.addEdges();
            return true;
        }
        catch (Exception e){
            System.err.format("Exception occurred trying to read '%s'.", filename);
            e.printStackTrace();
        }
        return false;
    }

    void print(){
        for (int j = 0; j < ysize; j++) {
            for (int i = 0; i < xsize; i++) {
                System.out.print((char) list[i][j].symbol);
            }
            System.out.println();
        }
    }


    public void cleanMap(){
        for (int j = 0; j < list[0].length; j++){
            for (int i = 0; i < list.length; i++){
                if (list[i][j].symbol != 'X'){
                    list[i][j].symbol = ' ';
                    list[i][j].flag = 0;
                }
            }
        }
        list[goalx][goaly].symbol = 'E';
        list[startx][starty].symbol = 'S';

    }



    private void addEdges(){

        for (int j = 0; j < this.ysize; j++)
            for (int i = 0; i < this.xsize; i++){
                if (list[i][j].symbol == 'X')
                    continue;
                list[i][j].manDist = heuristic(list[i][j], list[goalx][goaly]);
                //right
                if (i < xsize-1){
                    if (list[i+1][j].symbol != 'X')
                        list[i][j].edge.add(list[i+1][j]);
                }
                //left
                if (i > 0){
                    if (list[i-1][j].symbol != 'X')
                        list[i][j].edge.add(list[i-1][j]);
                }
                //top
                if (j > 0){
                    if (list[i][j-1].symbol != 'X')
                        list[i][j].edge.add(list[i][j-1]);
                }
                //bottom
                if (j < ysize-1){
                    if (list[i][j+1].symbol != 'X')
                        list[i][j].edge.add(list[i][j+1]);
                }
            }
     }
}




