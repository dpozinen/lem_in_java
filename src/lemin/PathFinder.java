package lemin;

import java.util.ArrayList;

class  PathFinder
{
    void findAllPaths() // DFS
    {
        ArrayList <Room> curPath = new ArrayList<>();
        Room curRoom = Farm.getStart();
        curPath.add(curRoom);
        findPath(curRoom, curPath);
    }
    void findPath(Room curRoom, ArrayList <Room> curPath)
    {
        if (curRoom.equals(Farm.getEnd()))
        {
            ArrayList <Room> fullPath = new ArrayList<>(curPath);
            Farm.getPathList().add(new Path(fullPath.size(), fullPath));
            return ;
        }
        int i = 0;
        while (Farm.getRoomList().get(i) != curRoom)
            i++;
        ArrayList <Room> curRoomLinks = Farm.getRoomList().get(i).getLinks();
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