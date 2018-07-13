package lemin;

import java.util.*;

class Path
{
    int id;
    int length;
    ArrayList<Room> pathRooms;

    Path (int length, ArrayList<Room> pathRooms)
    {
        this.id = id;
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
    static void findAllPaths() // DFS
    {
        ArrayList <Room> curPath = new ArrayList<>();
        Room curRoom = Farm.roomList.get(Farm.start);
        curPath.add(curRoom);
        findPath(curRoom, curPath);
    }
    static void findPath(Room curRoom, ArrayList <Room> curPath)
    {
        if (curRoom.index == Farm.end)
        {
            ArrayList <Room> fullPath = new ArrayList<>(curPath);
            Farm.pathList.add(new Path(curPath.size(), fullPath));
            return ;
        }
        int i = 0;
        while (Farm.linkList.get(i).get(0) != curRoom)
            i++;
        ArrayList <Room> curRoomLinks = Farm.linkList.get(i);
        for (Room r : curRoomLinks)
        {
            if (!curPath.contains(r))
            {
                curPath.add(r);
                findPath(r, curPath);
                curPath.remove(r);
            }
        }
    }
    void chooseBestPathSet()
    {
        Collections.sort(Farm.pathList, Path.bySizeAsc);
    }
}