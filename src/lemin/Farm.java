package lemin;

import java.util.ArrayList;

class Farm
{
    static int       ants;
    static int       start;
    static int       end;
    static boolean   quickFind = false;
    static ArrayList <Room> roomList = new ArrayList<>();
    static ArrayList <Path> pathList = new ArrayList<>();

    void print(int what)
    {
        System.out.println("Ants count: "+ ants);
        System.out.println("Start: "+ roomList.get(start).getName());
        System.out.println("End: "+ roomList.get(end).getName());

        if (what >= 1) // print room list
            for (Room r : roomList)
                System.out.println("Room name: " + r.getName());
        if (what >= 2) // print link list
            for (Room r : roomList)
            {
                System.out.println("Links for room: " + r.getName());
                for (Room rlinks : r.getLinks())
                    System.out.println(rlinks.getName());
            }
        if (what >= 3) // print path list
            for (Path p : pathList)
            {
                System.out.printf("path with id %4d : ", pathList.indexOf(p));
                p.print();
                System.out.println();
            }
    }
}