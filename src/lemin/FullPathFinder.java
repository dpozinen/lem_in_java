package lemin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

class FullPathFinder
{
    boolean fullFind(int curSetSize, ArrayList <Set> setsFound)
    {
        Set curSet = new Set();
        int maxCombSum = 0;
        int[] pathIds = new int[curSetSize];
        Set bestSet = new Set();

        for (int i = 0; i < curSetSize; i++)
            pathIds[i] = i;
        curSet = curSet.makeByPathIds(pathIds, curSet);
        bestSet = null;
        for (int i = 0; i < curSetSize; i++)
            maxCombSum += Farm.pathList.size() - i - 1;
        System.out.println(maxCombSum);
        while (IntStream.of(pathIds).sum() < maxCombSum - 1)
        {
            bestSet.copySet(curSet);
            while (bestSet.getLength() <= curSet.getLength()) // sum of generatedSet is bigger than bestSet
            {
                if (!checkIds(pathIds) || !getNextPathIDs(pathIds, curSet))
                    break ;
            }
        }
        if (bestSet != null)
            setsFound.add(bestSet);
        if (curSetSize == 4)
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
        System.out.println(Arrays.toString(pathIds));
        curSet = curSet.makeByPathIds(pathIds, curSet); // generate Set
        if (curSet == null)
            return false;
        int i = curSet.pathsIntersect(); // check if paths in set intersect and get the path ID that intersects
        if (i >= 0)
        {
            orderIds(pathIds, i);
            getNextPathIDs(pathIds, curSet);
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
        while (i < pathIds.length)
        {
            if (pathIds[i - 1] + 1 < Farm.pathList.size())
                pathIds[i] = pathIds[i - 1] + 1;
            i++;
        }
        return true;
    }
}