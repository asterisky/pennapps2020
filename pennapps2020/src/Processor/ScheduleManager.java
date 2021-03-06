package Processor;

import data.StudyGroup;
import data.User;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

public class ScheduleManager {

  //TODO make private once constructor is ready
  Map<String, TreeMap<UUID, StudyGroup>> studyGroups = new HashMap<>();

  //Constructor - Should get data base from DataAnalysis bucket
  //TODO add constructor

  //TODO remove main - only here for testing
  public static void main(String[] args) {
    ScheduleManager sm = new ScheduleManager();
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

    return bestMatch;

  }

  void addUserToStudyGroup(StudyGroup sg, User user) {

    //Calculate new Schedule for Study Group and update it
    int[][] newSchedule = mergeSchedule(sg.getSchedule(), user.getSchedule());
    sg.setSchedule(newSchedule);

    //add User
    sg.addMember(user);

    //Check if StudyGroup reached capacity, update
    if (sg.getMembers().size() >= 4) {
      sg.setFull(true);
    }

    //update study group in running DB
    studyGroups.get(sg.getCategory()).put(sg.getId(), sg);

  }

  void addNewStudyGroup(StudyGroup sg, String category){
    //error checking
    if (category == null || !studyGroups.keySet().contains(category)) {
      System.out.println("Key invalid");
      return;
    }

    if(studyGroups.get(category).keySet().contains(sg.getId())){
      System.out.println("StudyGroup with this ID exists already");
      return;
    }

    studyGroups.get(category).put(sg.getId(),sg);

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


