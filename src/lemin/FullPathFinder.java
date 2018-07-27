package lemin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

class FullPathFinder
{
    boolean fullFind(int curSetSize, ArrayList <Set> setsFound)
    {
        Set curSet = new Set();
        Set bestSet = new Set();
        int maxCombSum = 0;
        int[] pathIds = new int[curSetSize];

        for (int i = 0; i < curSetSize; i++)
            pathIds[i] = i;
        curSet.makeByPathIds(pathIds, curSet);
        for (int i = 0; i < curSetSize; i++)
            maxCombSum += Farm.pathList.size() - i - 1;
        while (IntStream.of(pathIds).sum() < maxCombSum - 1)
        {
            bestSet = new Set(curSet);
            while (bestSet.getLength() <= curSet.getLength()) // sum of generatedSet is bigger than bestSet
            {
                if (!getNextPathIDs(pathIds, curSet) || !checkIds(pathIds))
                    break ;
            }
        }
        if (bestSet.pathsIntersect() == -1)
            setsFound.add(bestSet);
        if (curSetSize == 3)
            return false;
        return true;
    }
    boolean     checkIds(int[] pathIds)
    {
        for (int i = 0; i < pathIds.length; i++) // go through paths
        {
            if (pathIds[i] >= Farm.pathList.size() - 1)
            {
                if (!orderIds(pathIds, i))
                    return false;
            }
            else if (i == pathIds.length - 1 && pathIds[i] + 1 < Farm.pathList.size()) // if it`s the last elem
                pathIds[i]++;
        }
        return true;
    }
    boolean     getNextPathIDs(int[] pathIds, Set curSet)
    {
        curSet = curSet.makeByPathIds(pathIds, curSet); // generate Set
        if (curSet == null)
            return false;
        int i = curSet.pathsIntersect(); // check if paths in set intersect and get the path ID that intersects
        if (i >= 0)
        {
            if (!orderIds(pathIds, i + 1))
                return false;
            return getNextPathIDs(pathIds, curSet);
        }
        return true;
    }
    boolean     orderIds(int[] pathIds, int i) // if order at intersect, i = i + 1
    {
        if (i == 0)
            return false;
        if (pathIds.length == 1) // if has one elem, increase to over bounds, it will be catched
        {
            pathIds[i]++;
            return true;
        }
        if (pathIds[i - 1] + 1 < Farm.pathList.size())
            pathIds[i - 1]++;
        else
            return checkIds(pathIds);
        while (i < pathIds.length)
        {
            if (pathIds[i - 1] + 1 < Farm.pathList.size())
                pathIds[i] = pathIds[i - 1] + 1;
            i++;
        }
        return true;
    }
}