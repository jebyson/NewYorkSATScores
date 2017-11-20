package com.company;

public class School {
    String schoolName;
    int mathScore;
    int readingScore;
    int writingScore;
    double percentTested;

    public School(String school, int math, int reading, int writing, double percentStudents)
    {
        schoolName = school;
        mathScore = math;
        readingScore = reading;
        writingScore = writing;
        percentTested = percentStudents;
    }

    public int getAverage()
    {
        return (mathScore + readingScore + writingScore);
    }
}
