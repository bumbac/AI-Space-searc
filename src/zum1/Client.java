package zum1;


import java.util.Objects;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Do you wish to start testing?");
            System.out.println("Write Y or N");
            String response = scanner.nextLine();
            Map map = new Map();
            if (Objects.equals(response, "y") ||Objects.equals(response, "Y") || Objects.equals(response, "yes"))
                startTest();

            System.out.println("Available maps: " + "0.txt " + "4.txt " + "6.txt " +"26.txt " + "36.txt " + "42.txt " +"72.txt " + "84.txt " + "114.txt " +"220.txt " + "332.txt ");
            System.out.println("Type the file name please:");

            String filename = scanner.nextLine();
            if (! map.read(filename)) {
                System.out.println("Wrong filename.");
                break;
            }
            System.out.println("Do you wish to print the map " + filename + "?" );
            System.out.println("Write Y or N");
            response = scanner.nextLine();
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

    private static void startTest() {
        Map map = new Map();
        int i = 0;
        String[] s = {"testovaci_data/00_11_11_1550177690.txt", "testovaci_data/01_71_51_156.txt", "testovaci_data/02_71_51_1552235384.txt"};
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            map.read(s[i]);
            i =  (i + 1) % 3;
            System.out.println("Do you wish to print the map " + s[i] + " ?" );
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
            System.out.println(">>>>>>>>>>>>>>>>Text file with map saved as outGreedy.txt");
            map.save("testGreedy.txt");
            map.cleanMap();
            System.out.println("===========================");


            System.out.println("Do you wish to try another in testing dataset?");
            System.out.println("Write Y or N");
            response = scanner.nextLine();
            if (Objects.equals(response, "y") ||Objects.equals(response, "Y") || Objects.equals(response, "yes"))
                flag = true;
            else flag = false;
        }


    }
}
