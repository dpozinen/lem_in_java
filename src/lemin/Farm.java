package lemin;

import java.util.ArrayList;

class Farm
{
    static int       ants;
    int              paths;
    int              nodes;
    String           inputString;
    static int       start;
    static int       end;
    static boolean   quickFind = false;
    static ArrayList <Room> roomList = new ArrayList<>();
    static ArrayList <Link> linkList = new ArrayList<>();
    static ArrayList <Path> pathList = new ArrayList<>();

    void print(int what)
    {
        System.out.println("Ants count: "+ ants);
        System.out.println("Start: "+ start);
        System.out.println("End: "+ end);

        if (what >= 1) // print room list
            for (Room r : roomList)
                System.out.println("Room name: "+r.name);
        if (what >= 2) // print link list
            for (Link l : linkList)
                l.print();
        if (what >= 3) // print path list
            for (Path p : pathList)
            {
                System.out.printf("path with id %4d : ", pathList.indexOf(p));
                p.print();
                System.out.println();
            }
    }
    static void fillLinkList()
    {
        for (Room r : roomList)
        {
            Link newRoomLink = new Link(r);
            Farm.linkList.add(newRoomLink);
        }
    }
}