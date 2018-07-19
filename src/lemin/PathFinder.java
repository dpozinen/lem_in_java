package lemin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

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
        if (curRoom.id == Farm.end)
        {
            ArrayList <Room> fullPath = new ArrayList<>(curPath);
            Farm.pathList.add(new Path(curPath.size(), fullPath));
            return ;
        }
        int i = 0;
        while (Farm.linkList.get(i).mainRoom != curRoom)
            i++;
        ArrayList <Room> curRoomLinks = Farm.linkList.get(i).links;
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
        // if (Farm.quickFind)
            quickFind();
        // else
        //     fullFind();
    }
    void quickFind()
    {
        ArrayList <Path> curPathSet = new ArrayList<>();
        ArrayList <Room> roomsInCurSet = new ArrayList<>();

        Collections.sort(Farm.pathList, Path.bySizeAsc);
        curPathSet.add(Farm.pathList.get(0));
        Iterator <Path> pathIter = Farm.pathList.iterator();
        findNextMin(curPathSet, roomsInCurSet, pathIter);
        for (Path p : curPathSet)
            p.print();
    }
    void findNextMin(ArrayList <Path> curPathSet,  ArrayList <Room> roomsInCurSet, Iterator <Path> pathIter)
    {
        Path newSetPath = null;

        for (Path p : curPathSet)
            for (Room r : p.pathRooms)
                roomsInCurSet.add(r);
        newSetPath = getNotIntersect(newSetPath, roomsInCurSet, pathIter);
        if (newSetPath == null)
            return ;
        curPathSet.add(newSetPath);
        findNextMin(curPathSet, roomsInCurSet, pathIter );
    }
    Path getNotIntersect(Path newSetPath, ArrayList <Room> roomsInCurSet, Iterator <Path> pathIter)
    {
        Path    p;
        boolean contains;

        while (pathIter.hasNext())
        {
            p = pathIter.next();
            contains = false;
            for (Room r : roomsInCurSet)
            {
                if (r.id != Farm.start && r.id != Farm.end)
                    if (contains = p.pathRooms.contains(r))
                        break ;
            }
            if (contains == false)
                return p;
        }
        return null;
    }
}