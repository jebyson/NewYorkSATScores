package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sf = new Scanner(new File("scores.txt"));
        String[] schoolNameScores = new String[450];
        School[] schools = new School[450];

        System.out.println("Here are all the schools and their respective scores:");

        for (int i = 0; i < schoolNameScores.length; i++)
        {
            schoolNameScores[i] = null;
        }

        for (int i = 0; i < schools.length; i++)
        {
            schools[i] = null;
        }

        for (int i = 0; sf.hasNext(); i++)
        {
            schoolNameScores[i] = sf.nextLine();
        }
        sf.close();

        for (int i = 0; i < schoolNameScores.length; i++)
        {
            if (schoolNameScores[i] != null)
            {
                Scanner scanner2 = new Scanner(schoolNameScores[i]);
                int x;
                for (x = 0; scanner2.hasNext(); x++)
                {
                    scanner2.next();
                }
                if (x < 22)
                {
                    schoolNameScores[i] = null;
                }
            }
        }

        for (int i = 1; i < schoolNameScores.length; i++)
        {
            if (schoolNameScores[i] != null)
            {
                Scanner scanner3 = new Scanner(schoolNameScores[i]);
                scanner3.useDelimiter("\t");
                scanner3.next();
                String name = scanner3.next();
                for (int j = 0; j < 16; j++)
                {
                    scanner3.next();
                }
                int math = 0;
                int reading = 0;
                int writing = 0;
                double percent = 0;
                if (scanner3.hasNextInt())
                {
                    math = scanner3.nextInt();
                }
                if (scanner3.hasNextInt())
                {
                    reading = scanner3.nextInt();
                }
                if (scanner3.hasNextInt())
                {
                    writing = scanner3.nextInt();
                }
                if (scanner3.hasNext())
                {
                    String perc = scanner3.next();
                    if (perc.length() != 0)
                    {
                        percent = Double.valueOf(perc.substring(0, (perc.length() - 1)));
                    }
                }
                schools[i] = new School(name, math, reading, writing, percent);
            }

        }

        for (School dummyVar : schools)
        {
            if (dummyVar != null)
            {
                if (dummyVar.getAverage() != 0)
                {
                    System.out.println(dummyVar.schoolName + " - " + dummyVar.getAverage());
                }
            }
        }

        System.out.println("The average SAT score per school in New York is " + NYAverage(schools));
        sortSchools(schools);
        System.out.println("The top three schools are: ");
        System.out.println("#1: " + schools[0].schoolName + " - " + schools[0].getAverage());
        System.out.println("#2: " + schools[1].schoolName + " - " + schools[1].getAverage());
        System.out.println("#3: " + schools[2].schoolName + " - " + schools[2].getAverage());
    }

    public static int NYAverage(School[] schools)
    {
        int cnt = 0;
        int sum = 0;
        for (School randVar : schools)
        {
            if (randVar != null)
            {
                if (randVar.getAverage() != 0)
                {
                    sum += randVar.getAverage();
                    cnt++;
                }
            }

        }
        return (sum/cnt);
    }

    public static void sortSchools(School[] schools)
    {
        boolean sort = true;
        while (sort)
        {
            sort = false;
            for (int i = 0; i < schools.length - 1; i++)
            {
                boolean swtch = false;
                if (schools[i] != null && schools[i + 1] != null)
                {
                    if (schools[i + 1].getAverage() == schools[i].getAverage() && schools[i + 1].percentTested > schools[i].percentTested)
                    {
                        swtch = true;
                        sort = true;
                    }
                    else if (schools[i + 1].getAverage() > schools[i].getAverage())
                    {
                        swtch = true;
                        sort = true;
                    }
                }
                else if (schools[i + 1] != null)
                {
                    swtch = true;
                    sort = true;
                }
                if (swtch)
                {
                    swap(schools, i, i + 1);
                }
            }
        }
    }

    public static void swap(School[] schools, int indx, int indx2)
    {
        School temp = schools[indx];
        schools[indx] = schools[indx2];
        schools[indx2] = temp;
    }
}