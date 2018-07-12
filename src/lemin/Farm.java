package lemin;

import java.util.List;
import java.util.ArrayList;

class Farm
{
    static int       ants;
    int              paths;
    int              nodes;
    String           inputString;
    static int       start;
    static int       end;
    static ArrayList <Room>        roomList = new ArrayList<>();
    static List <ArrayList <Room>> linkList = new ArrayList <>();
    static ArrayList <Path>        pathList = new ArrayList<>();

    void print(int what)
    {
        if (ants != 0)
            System.out.println("Ants count: "+ ants);
        System.out.println("Start: "+ start);
        System.out.println("End: "+ end);
        // print room list
        if (what >= 1)
            for (Room r : roomList)
                System.out.println("Room name: "+r.name);
        // print link list
        if (what >= 2)
            for (ArrayList <Room> rList : linkList)
            {
                String roomOne = rList.get(0).name;
                if (rList.size() > 1)
                {
                    System.out.println("Links for room: " + roomOne);
                        for (int i = 1; i < rList.size(); i++)
                            System.out.println(roomOne + "-" + rList.get(i).name);
                    System.out.println();
                }
            }
        // print path list 
        if (what >= 3)
            for (Path p : pathList)
                p.print();
    }
    static void fillLinkList()
    {
        for (Room r : roomList)
        {
            ArrayList <Room> newRoom = new ArrayList <Room>();
            newRoom.add(r);
            Farm.linkList.add(newRoom);
        }
    }
}