package lemin;

import java.util.Comparator;
import java.util.ArrayList;

class Path
{
    int id;
    int length;
    ArrayList<Room> pathRooms;

    Path (int length, ArrayList<Room> pathRooms)
    {
        this.length = length;
        this.pathRooms = pathRooms;
    }
    void print()
    {
        for (Room r : pathRooms)
        {
            System.out.print(r);
            if (pathRooms.indexOf(r) != length - 1)
                System.out.print("-");
        }
        System.out.println();
    }
    public static Comparator<Path> bySizeAsc = new Comparator<Path>()
    {
        public int compare(Path one, Path two)
        {
            return one.length - two.length;
        }
    };
}