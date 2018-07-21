package lemin;

import java.util.ArrayList;
import java.util.stream.IntStream;

class FullPathFinder
{
    boolean fullFind(int curSetSize, ArrayList <Set> setsFound)
    {
        Set curSet = new Set();
        ArrayList <Path> curPaths = new ArrayList<>(curSetSize);
        ArrayList <Room> roomsInCurSet = new ArrayList<>();
        int maxCombSum = 0;
        int[] pathIds = new int[curSetSize];

        // think through fullFind, possible restructure to LinkList
        // moving through the list using next instead of get(ind);
        // although if it has a ind-adress table - doesnt matter
        for (int i = 0; i < curSetSize; i++)
            pathIds[i] = i;
        for (int i = 0; i < curSetSize; i++)
            maxCombSum += Farm.pathList.size() - i;
        while (IntStream.of(pathIds).sum() <= maxCombSum)
        {
            
        }
        return true;
    }
}