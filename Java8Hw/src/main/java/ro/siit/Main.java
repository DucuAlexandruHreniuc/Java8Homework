package ro.siit;

    public class Main {
        public static void main(String[] args) {
            FileManipulator fm = new FileManipulator();
            String directory = "src/main/resources/";
            fm.executeSorting(directory + "List Of People.txt" , "08", directory + "New Sorted List.txt");
            FileManipulator fm2 = new FileManipulator();
            fm2.executeSorting("src/main/resources/List Of People.txt", "04", "src/main/resources/New Sorted List 2.txt");
        }
    }
    /*Initial am hardcodat directory-ul in FileManipulator dar am vrut sa-l folosesc pt test asa ca am facut un string aici
             */
