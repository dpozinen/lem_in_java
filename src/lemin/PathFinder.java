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
            // fullFind();
    }
    void fullFind()
    {
        Set curSet = new Set();
        ArrayList <Room> roomsInCurSet = new ArrayList<>();

        // int
    }
    void quickFind()
    {
        Set curSet = new Set();
        ArrayList <Set> foundSets = new ArrayList<>();
        ArrayList <Room> roomsInCurSet = new ArrayList<>();

        Collections.sort(Farm.pathList, Path.bySizeAsc);
        curSet.setPaths.add(Farm.pathList.get(0));
        Iterator <Path> pathIter = Farm.pathList.iterator();
        findNextMin(curSet, roomsInCurSet, pathIter, foundSets);
        Set bestSet = Collections.min(foundSets, Set.byEfficiency);
        bestSet.print();
    }
    void findNextMin(Set curSet,  ArrayList <Room> roomsInCurSet, Iterator <Path> pathIter, ArrayList <Set> foundSets)
    {
        Path newSetPath = null;

        for (Path p : curSet.setPaths)
            for (Room r : p.pathRooms)
                roomsInCurSet.add(r);
        newSetPath = getNotIntersect(newSetPath, roomsInCurSet, pathIter);
        if (newSetPath == null)
            return ;
        curSet.setPaths.add(newSetPath);
        curSet.countEfficiency();
        foundSets.add(curSet);
        findNextMin(curSet, roomsInCurSet, pathIter, foundSets);
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