package DataAnalysis;

import data.StudyGroup;
import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;

public class ScheduleMatcher {

  private Map<String, ArrayList<StudyGroup>> studyGroups;

  //Constructor - TODO should read in file

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
          bestMatch = group;
        }
      }
    }

  return bestMatch;

  }

}
