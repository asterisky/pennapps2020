package Processor;

import data.StudyGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ScheduleMatcher {

  Map<String, ArrayList<StudyGroup>> studyGroups = new HashMap<>();

  //Constructor - Should get data base from DataAnalysis bucket

  public static void main(String[] args) {
    ScheduleMatcher sm = new ScheduleMatcher();
    ArrayList<StudyGroup> al = new ArrayList<>();
    int[][] schedule1 = {{0,1,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0},{0,1,0,0,0,0,0,0,1,0,0,
        0,0,1,0,0,0,0,0,0,1,0,0,0},{0,1,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0},{0,1,0,0,0,0
        ,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0},
        {0,1,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0},{0,1,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,
        0,1,0,0,0},{0,1,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0}};
    al.add(new StudyGroup("591", schedule1));
    int[][] schedule2 = {{0,1,1,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0},{0,1,0,0,0,0,0,0,1,0,0,
        0,0,1,0,0,0,0,0,0,1,0,0,0},{0,1,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0},{0,1,0,0,0,0
        ,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0},
        {0,1,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0},{0,1,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,
        0,1,0,0,0},{0,1,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0}};
    al.add(new StudyGroup("591", schedule2));
    sm.studyGroups.put("591",al);

    int[][] schedule3 = {{0,1,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0},{0,1,0,0,0,0,0,0,1,0,0,
        0,0,1,0,0,0,0,0,0,1,0,0,0},{0,1,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0},{0,1,0,0,0,0
        ,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0},
        {0,1,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0},{0,1,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,
        0,1,0,0,0},{0,1,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0}};
    sm.findStudyGroup("591",schedule3);
  }


  StudyGroup findStudyGroup(String id, int[][] timetable ){

    //error checking
    if(id == null || !studyGroups.keySet().contains(id)){
      System.out.println("Key invalid");
      return null;
    }

    //check timetable valid format
    if(timetable==null || !(timetable.length == 7 && timetable[0].length == 24)) return null;

    //get relevant array List of studyGroups
    ArrayList<StudyGroup> selection = studyGroups.get(id);

    //check if there are any studygroups
    if(selection.isEmpty()) return null;

    int maxSlots = 0;
    StudyGroup bestMatch = null;
    for (StudyGroup group : selection) {
      //check if group is full
      if(!group.isFull()){
        int[][] groupSchedule = group.getSchedule();
        int matches = 0;
        for (int i = 0; i < timetable.length; i++) {
          for (int j = 0; j < timetable[0].length; j++) {
            matches+= groupSchedule[i][j]&timetable[i][j];
          }
        }
        //update overall max
        if(matches>maxSlots){
          maxSlots = matches;
          bestMatch = group;
        }
      }
    }

  return bestMatch;

  }

}
