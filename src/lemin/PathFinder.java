package lemin;

import java.util.ArrayList;
import java.util.Collections;

class  PathFinder
{
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