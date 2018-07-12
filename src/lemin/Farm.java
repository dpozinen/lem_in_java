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
        if (what <= 1)
            for (Room r : roomList)
                System.out.println("Room name: "+r.name);
        // print link list
        if (what <= 2)
            for (ArrayList <Room> rList : linkList)
            {
                String roomOne = rList.get(0).name;
                System.out.println("Links for room: " + roomOne);
                for (Room r : rList)
                    System.out.println(roomOne + "-" + r);    
            }

    }
    
}