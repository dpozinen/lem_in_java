package lemin;  

import java.util.ArrayList;
import java.util.Iterator;

class Path
{
    int id;
    int length;
    ArrayList<Room> pathRooms;

    Path (int id, int length, ArrayList<Room> pathRooms)
    {
        this.id = id;
        this.length = length;
        this.pathRooms = pathRooms;
    }
    void print()
    {
        System.out.println("path with id: " + id);
        Iterator<Room> i = pathRooms.iterator();
        while (i.hasNext())
        {
            System.out.print(i.next());
        }
    }
}