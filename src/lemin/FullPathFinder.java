package lemin;

import java.util.ArrayList;
import java.util.stream.IntStream;

class FullPathFinder
{
    void    addRoomsToCurUsedRooms(ArrayList <Room> roomsInCurSet, int[] pathIds)
    {
        for (Path p : curSet.setPaths)
            for (Room r : p.pathRooms)
                if (!roomsInCurSet.contains(r))
                    roomsInCurSet.add(r);
    }
    boolean fullFind(int curSetSize, ArrayList <Set> setsFound)
    {
        Set curSet = new Set();
        // ArrayList <Path> curPaths = new ArrayList<>(curSetSize);
        ArrayList <Room> roomsInCurSet = new ArrayList<>();
        int maxCombSum = 0;
        int[] pathIds = new int[curSetSize];
        Set bestSet = new Set();

        for (int i = 0; i < curSetSize; i++)
            pathIds[i] = i;
        for (int i = 0; i < curSetSize; i++)
            maxCombSum += Farm.pathList.size() - i;
        while (IntStream.of(pathIds).sum() <= maxCombSum)
        {
            bestSet = curSet;
            while (bestSet.   length < curSet.length)/*sum of generatedSet is bigger than bestSet*/
            {
                while (/*setPathsIntersect(curSet)*/)/*paths in set intersect*/
                /*
                    order int[] pathIds;
                    curSet = Set.makeByPathIds();
                */
            }
        }
        return true;
    }
}