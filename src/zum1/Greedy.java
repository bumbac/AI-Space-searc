package zum1;
import java.util.PriorityQueue;
import java.util.Queue;

public class Greedy {
    private int nodesExp = 0;
    private int pathLength = 0;

void makePath(Map map, int printflag) {
    Map.Node start = map.list[map.startx][map.starty];
    Map.Node goal = map.list[map.goalx][map.goaly];
    int i, j;
    Queue<Map.Node> open = new PriorityQueue<>(map.xsize * map.ysize, new NodeComparator());
    open.add(start);
    Map.Node node;
    Map.Node previous = start;
    while (!open.isEmpty()) {
        node = open.poll();
        node.flag = 1;
        previous.symbol = 'o';
        if (printflag == 1) {
            System.out.println("-------------");
            map.print();
        }
        if (node == goal) {
            System.out.println("Finish");
            node.symbol = 'E';
            node = node.parent;
            while (node != null) {
                pathLength++;
                node.symbol = 'o';
                node = node.parent;
            }
            start.symbol = 'S';
            System.out.println("Nodes expanded: " + nodesExp);
            System.out.println("Path length: " + pathLength);
            return;
        }

            for (Map.Node n : node.edge) {
                if (n.flag == 0) {
                    open.add(n);
                    nodesExp++;
                    n.symbol = '#';
                    n.flag = 1;
                    n.parent = node;
                }
            }


            node.flag = 2;
        }
        System.out.println("Goal not found.");
        System.out.println("Nodes expanded: " + nodesExp);
        System.out.println("Path length: " + pathLength);
        return;

    }
}