package lemin;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Farm
{
    int              ants;
    int              paths;
    int              nodes;
    String           inputString;
    static ArrayList <Room>   roomList;
    static List <List <Room>> linkList;
    static ArrayList <Path>   pathList;

    void read()
    {
        Scanner     sc = new Scanner(System.in);
        Validate    val = new Validate();

        while (sc.hasNextLine())
        {
            String s = sc.nextLine();
            int type = val.validateAs(s);
            AddInput.add(type, s);
        }
        sc.close();
    }
    
}