package lemin;

import java.util.Collections;
import java.util.Iterator;
import java.util.ArrayList;;

class SetFinder
{
    void chooseBestPathSet()
    {
        if (Farm.getQuickFind())
            quickFind();
        else
        {
            ArrayList <Set> setsFound = new ArrayList<>();
            int curSetSize = 1;
            FullSetFinder fullSetFinder = new FullSetFinder();

            while (fullSetFinder.fullFind(curSetSize, setsFound))
                curSetSize++;
            Collections.sort(setsFound, Set.byEfficiency);
            Farm.setSetsFound(setsFound);
        }
    }

    void quickFind()
    {
        Set curSet = new Set();
        ArrayList <Set> foundSets = new ArrayList<>();
        ArrayList <Room> roomsInCurSet = new ArrayList<>();

        Collections.sort(Farm.getPathList(), Path.bySizeAsc);
        curSet.getpaths().add(Farm.getPathList().get(0));
        Iterator <Path> pathIter = Farm.getPathList().iterator();
        findNextMin(curSet, roomsInCurSet, pathIter, foundSets);
        Set bestSet = Collections.min(foundSets, Set.byEfficiency);
        bestSet.print();
    }

    void findNextMin(Set curSet,  ArrayList <Room> roomsInCurSet, Iterator <Path> pathIter, ArrayList <Set> foundSets)
    {
        Path newSetPath = null;

        for (Path p : curSet.getpaths())
            for (Room r : p.getPathRooms())
                if (!roomsInCurSet.contains(r))
                    roomsInCurSet.add(r);
        newSetPath = getNotIntersect(newSetPath, roomsInCurSet, pathIter);
        if (newSetPath == null)
            return ;
        curSet.getpaths().add(newSetPath);
        curSet.countEfficiency();
        foundSets.add(curSet);
        findNextMin(curSet, roomsInCurSet, pathIter, foundSets);
    }

    Path    getNotIntersect(Path newSetPath, ArrayList <Room> roomsInCurSet, Iterator <Path> pathIter)
    {
        Path    p;
        boolean contains;

        while (pathIter.hasNext())
        {
            p = pathIter.next();
            contains = false;
            for (Room r : roomsInCurSet)
            {
                if (r != Farm.getStart() && r != Farm.getEnd())
                    if (contains = p.getPathRooms().contains(r))
                        break ;
            }
            if (contains == false)
                return p;
        }
        return null;
    }
}