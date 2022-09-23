package ro.siit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FileManipulator {
    public void executeSorting(String fileName, String targetMonth, String sortedFileName) {
        List<Person> listOfPeople = new ArrayList<>();
        {
            try {
                BufferedReader br = new BufferedReader(new FileReader(fileName));
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    String firstName = values[0];
                    String lastName = values[1];
                    String month = values[2].substring(4,6);
                    if (month.equals(targetMonth)){
                        listOfPeople.add(new Person(firstName, lastName, month));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try{
                FileWriter fw = new FileWriter(sortedFileName);
                List<Person> sortedList = listOfPeople.stream()
                        .sorted(Comparator.comparing(person -> person.firstName)).toList();
                fw.write("Alphabetically ordered (first name) list of people with birth month "+
                        targetMonth + sortedList);
                fw.close();
            }catch (IOException e)
            {e.printStackTrace();}
        }
    }
}