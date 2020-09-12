package Processor;

import data.StudyGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

public class ScheduleMatcher {

  //TODO make private once constructor is ready
  Map<String, TreeMap<UUID, StudyGroup>> studyGroups = new HashMap<>();

  //Constructor - Should get data base from DataAnalysis bucket
  //TODO add constructor

  //TODO remove main - only here for testing
  public static void main(String[] args) {
    ScheduleMatcher sm = new ScheduleMatcher();
    TreeMap<UUID, StudyGroup> treeMap = new TreeMap<>();
    int[][] schedule1 = {{0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0,
            0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, {0, 1, 0, 0, 0, 0
        , 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0,
            0, 1, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}};
    StudyGroup sg1 = new StudyGroup("591", schedule1);
    treeMap.put(sg1.getId(), sg1);
    int[][] schedule2 = {{0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0,
            0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, {0, 1, 0, 0, 0, 0
        , 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0,
            0, 1, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}};
    StudyGroup sg2 = new StudyGroup("591", schedule2);
    treeMap.put(sg2.getId(), sg2);
    sm.studyGroups.put("591", treeMap);

    int[][] schedule3 = {{0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0,
            0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, {0, 1, 0, 0, 0, 0
        , 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0,
            0, 1, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}};
    sm.findStudyGroup("591", schedule3);
  }


  StudyGroup findStudyGroup(String category, int[][] timetable) {

    //error checking
    if (category == null || !studyGroups.keySet().contains(category)) {
      System.out.println("Key invalid");
      return null;
    }

    //check timetable valid format
    if (timetable == null || !(timetable.length == 7 && timetable[0].length == 24)) {
      return null;
    }

    //get relevant array List of studyGroups
    TreeMap<UUID, StudyGroup> selection = studyGroups.get(category);

    //check if there are any studygroups
    if (selection.isEmpty()) {
      return null;
    }

    int maxSlots = 0;
    StudyGroup bestMatch = null;
    for (Map.Entry<UUID, StudyGroup> groupEntry : selection.entrySet()) {
      //get StudyGroup
      StudyGroup group = groupEntry.getValue();

      //check if group is full
      if (!group.isFull()) {
        int[][] groupSchedule = group.getSchedule();
        int matches = 0;
        for (int i = 0; i < timetable.length; i++) {
          for (int j = 0; j < timetable[0].length; j++) {
            matches += groupSchedule[i][j] & timetable[i][j];
          }
        }
        //update overall max
        if (matches > maxSlots) {
          maxSlots = matches;
          bestMatch = group;
        }
      }
    }
    //System.out.println(bestMatch.getId());

    //Calculate new Schedule for Study Group to show user
    int[][] newSchedule = mergeSchedule(bestMatch.getSchedule(),timetable);

    //update StudyGroup with new schedule but not yet saved to Map Data Base in ScheduleMatcher
    //only done once user confirms that joins study group

    bestMatch.setSchedule(newSchedule);

    return bestMatch;

  }

  //HelperMethod - Calculate new schedule based on current studygroup schedule and new user added
  private int[][] mergeSchedule(int[][] scheduleGroup, int[][] scheduleUser) {

    //error handling size does not match
    if (scheduleGroup.length != scheduleUser.length
        || scheduleGroup[0].length != scheduleUser.length) {
      return null;
    }

    int[][] newSchedule = new int[scheduleGroup.length][scheduleGroup[0].length];

    for (int i = 0; i < scheduleGroup.length; i++) {
      for (int j = 0; j < scheduleGroup[0].length; j++) {
        newSchedule[i][j] = scheduleGroup[i][j] & scheduleUser[i][j];
      }
    }

    return newSchedule;
  }

}


