package zum1;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
private Queue<Map.Node> q = new LinkedList<>();
private int nodesExp = 0;
private int pathLength = 0;

public void makePath(Map map, int printflag) {
    Map.Node start = map.list[map.startx][map.starty];
    Map.Node goal = map.list[map.goalx][map.goaly];
    start.flag = 0;
    goal.flag = 0;
    start.parent = null;
    q.add(start);
    while (!q.isEmpty()) {
        Map.Node tmp = q.remove();
        if (printflag == 1) {
            System.out.println("-------------");
            map.print();
        }
        if (tmp == goal) {
            System.out.println("Finish");
            tmp.symbol = 'E';
            tmp = tmp.parent;
            while (tmp != null) {
                pathLength++;
                tmp.symbol = 'o';
                tmp = tmp.parent;
            }
            start.symbol = 'S';
            System.out.println("Nodes expanded: " + nodesExp);
            System.out.println("Path length: " + pathLength);
            return;
        }
        if (tmp.flag == 0 || tmp.flag == 1) {
            for (Map.Node n : tmp.edge) {
                if (n.flag == 0) {
                    n.symbol = '#';
                    n.parent = tmp;
                    n.flag = 1;
                    nodesExp++;
                }
                q.add(n);
            }
            tmp.flag = 2;
        }
    }
    System.out.println("Goal not found.");
    System.out.println("Nodes expanded: " + nodesExp);
    System.out.println("Path length: " + pathLength);


 }
}
