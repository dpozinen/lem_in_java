package lemin;

import java.util.ArrayList;

class  PathFinder
{
    void findAllPaths() // DFS
    {
        ArrayList <Room> curPath = new ArrayList<>();
        Room curRoom = Farm.roomList.get(Farm.start);
        curPath.add(curRoom);
        findPath(curRoom, curPath);
    }
    void findPath(Room curRoom, ArrayList <Room> curPath)
    {
        if (curRoom.getId() == Farm.end)
        {
            ArrayList <Room> fullPath = new ArrayList<>(curPath);
            Farm.pathList.add(new Path(fullPath.size(), fullPath));
            return ;
        }
        int i = 0;
        while (Farm.roomList.get(i) != curRoom)
            i++;
        ArrayList <Room> curRoomLinks = Farm.roomList.get(i).getLinks();
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
}