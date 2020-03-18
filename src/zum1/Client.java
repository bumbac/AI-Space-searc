package zum1;


import java.awt.desktop.SystemEventListener;
import java.util.Objects;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Type the file name please, for example: 84.txt");
            String filename = scanner.nextLine();
            Map map = new Map();
            if (! map.read(filename))
                return;
            System.out.println("Do you wish to print the map " + filename + "?" );
            System.out.println("Write Y or N");
            String response = scanner.nextLine();
            if (Objects.equals(response, "y") ||Objects.equals(response, "Y") || Objects.equals(response, "yes"))
                map.print();
            System.out.println("===========================");
            System.out.println("Do you wish to print the steps of BFS?" );
            System.out.println("Write Y or N");
            response = scanner.nextLine();
            int printflag = 0;
            if (Objects.equals(response, "y") ||Objects.equals(response, "Y") || Objects.equals(response, "yes"))
                printflag = 1;
            System.out.println("BFS path:");
            BFS bfs = new BFS();
            bfs.makePath(map, printflag);
            map.print();
            System.out.println(">>>>>>>>>>>>>>>>Text file with map saved as outBFS.txt");
            map.save("testBFS.txt");
            map.cleanMap();
            System.out.println("===========================");
            System.out.println("Do you wish to print the steps of Greedy algorithm?" );
            System.out.println("Write Y or N");
            response = scanner.nextLine();
            printflag = 0;
            if (Objects.equals(response, "y") ||Objects.equals(response, "Y") || Objects.equals(response, "yes"))
                printflag = 1;
            System.out.println("Greedy path:");
            Greedy greedy = new Greedy();
            greedy.makePath(map, printflag);
            map.print();
            System.out.println(">>>>>>>>>>>>>>>>Text file with map saved as outGreedy.txt");
            map.save("testGreedy.txt");
            map.cleanMap();
            System.out.println("===========================");


            System.out.println("Do you wish to try another map?");
            System.out.println("Write Y or N");
            response = scanner.nextLine();
            if (Objects.equals(response, "y") ||Objects.equals(response, "Y") || Objects.equals(response, "yes"))
                flag = true;
            else flag = false;
        }
        System.out.println("Thank you for your time. Bye.");
    }
}
