package lemin;

import java.util.ArrayList;
import java.util.stream.IntStream;

class FullSetFinder
{
    boolean fullFind(int curSetSize, ArrayList <Set> setsFound)
    {
        Set curSet = new Set();
        Set bestSet = new Set();
        int maxCombSum = 0;
        int[] pathIds = new int[curSetSize];

        for (int i = 0; i < curSetSize; i++)
            pathIds[i] = i;
        curSet.makeByPathIds(pathIds);
        for (int i = 0; i < curSetSize; i++)
            maxCombSum += Farm.getPathList().size() - i - 1;
        while (IntStream.of(pathIds).sum() < maxCombSum - 1)
        {
            bestSet = new Set(curSet);
            while (bestSet.getLength() <= curSet.getLength())
            {
                if (!getNextPathIDs(pathIds, curSet) || !checkIds(pathIds))
                    break ;
            }
        }
        if (bestSet.pathsIntersect() == -1)
            setsFound.add(bestSet);
        if (curSetSize == 6)
            return false;
        return true;
    }

    boolean     checkIds(int[] pathIds)
    {
        for (int i = 0; i < pathIds.length; i++)
        {
            if (pathIds[i] >= Farm.getPathList().size() - 1)
            {
                if (!orderIds(pathIds, i))
                    return false;
            }
            else if (i == pathIds.length - 1 && pathIds[i] + 1 < Farm.getPathList().size()) // if it`s the last elem
                pathIds[i]++;
        }
        return true;
    }

    boolean     getNextPathIDs(int[] pathIds, Set curSet)
    {
        curSet.makeByPathIds(pathIds);
        int i = curSet.pathsIntersect();
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
        if (pathIds.length == 1)
        {
            pathIds[i]++;
            return true;
        }
        if (pathIds[i - 1] + 1 < Farm.getPathList().size())
            pathIds[i - 1]++;
        else
            return checkIds(pathIds);
        while (i < pathIds.length)
        {
            if (pathIds[i - 1] + 1 < Farm.getPathList().size())
                pathIds[i] = pathIds[i - 1] + 1;
            i++;
        }
        return true;
    }
}