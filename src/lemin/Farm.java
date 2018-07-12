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
        if (what <= 1)
            for (Room r : roomList)
                System.out.println("Room name: "+r.name);
        // if (what < 2)
    }
    
}