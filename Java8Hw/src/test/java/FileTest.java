import org.junit.Test;
import ro.siit.FileManipulator;
import ro.siit.Person;
import org.junit.jupiter.api.Assertions;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class FileTest {
    @Test
    public void test_sorting(){
        List<Person> testList = new ArrayList<>();
        Person p1 = new Person("Milo" ,"Testovich","01");
        Person p2 = new Person("Benny", "Testovich", "01");
        testList.add(p1);
        testList.add(p2);
        List<Person> sortedList = testList.stream()
                .sorted(Comparator.comparing(Person::getFirstName)).toList();
        Assertions.assertEquals(Optional.of(p2), sortedList.stream().findFirst());
    }
    @Test
    public void test_writing(){
        FileManipulator tf1 = new FileManipulator();
        String sortedFileName = "src/test/resources/New Sorted List Of People Test.txt";
        tf1.executeSorting("src/test/resources/List Of People Test.txt", "04", sortedFileName);
        Assertions.assertTrue(Files.exists(Path.of(sortedFileName)));
    }
}
