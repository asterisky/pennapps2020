package DataAnalysis;

import data.StudyGroup;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.UUID;

public class FileProcessor {

  protected String filename;

  public FileProcessor(String filename) {
    this.filename = filename;
  }

  // Map<String, TreeMap<UUID, StudyGroup>> studyGroups = new HashMap<>();

  public static void main(String[] args) {
    FileProcessor fr = new FileProcessor("C:\\Users\\Claudia\\Documents\\MCIT\\PennAps2020"
        + "\\pennapps2020\\test.csv");
    fr.read();
  }

  Map<String, TreeMap<UUID, StudyGroup>> read(){

    Map<String, TreeMap<UUID, StudyGroup>> db = new HashMap<>();

    try (Scanner in = new Scanner(new File(filename))) {


      String line;

      if (in.hasNextLine()) {
        line = in.nextLine();
        String[] lineSplit = line.split(",");
        String key = lineSplit[0];
        Boolean status = Boolean.parseBoolean(lineSplit[1] );
        ArrayList<String> members = new ArrayList<>(Arrays.asList(lineSplit[2].split(";")));

        String[] timetable1D = Arrays.copyOfRange(lineSplit,3,168+3+1);
        int[][] timetable = new int[7][24];
        int i = 0;
          for (int j = 0; j < 7; j++) {
            for (int k = 0; k < 24; k++) {
              timetable[j][k]=Integer.parseInt(timetable1D[i]);
              i++;
            }

          }

          StudyGroup sg = new StudyGroup(key,timetable);
          //TODO


        }
    }catch (FileNotFoundException e) {
      System.out.println("File \"" + filename + "\" could not be read");
    }



    return null;

  }
}
