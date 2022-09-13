import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.*;

//Scuze ca arata asa sql text ul, l am scris in notepad si i am dat copy-paste, voiam sa fie usor de citit dar a iesit asta

public class DatabaseTest {
    private Connection connection;
    @BeforeEach
    public void initializeConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:h2:mem:test_mem");
        connection.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS accomodation(id INT PRIMARY KEY, type VARCHAR (32),\n" +
                "\t\t\t  bed_type VARCHAR(32), max_guests INT,\n" +
                "\t\t\t  description VARCHAR(512));\n" +
                "\n" +
                "CREATE TABLE IF NOT EXISTS room_fair(id INT PRIMARY KEY, \"value\" DOUBLE PRECISION,\n" +
                "\t\t       season VARCHAR(32));\n" +
                "\n" +
                "CREATE TABLE IF NOT EXISTS accomodation_fair_relation(id INT PRIMARY KEY, id_accomodation INT,\n" +
                "\t\t\t\t\tid_room_fair INT,\n" +
                "\t\t\t\t\tCONSTRAINT fk_accomodation\n" +
                "\t\t\t\t\t\tFOREIGN KEY(id_accomodation)\n" +
                "\t\t\t\t\t\t\tREFERENCES accomodation(id),\n" +
                "\t\t\t\t\tCONSTRAINT fk_room_fair\n" +
                "\t\t\t\t\t\tFOREIGN KEY(id_room_fair)\n" +
                "\t\t\t\t\t\t\tREFERENCES room_fair(id));");
    }

    @Test
    public void test_insert()throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:test_mem");
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO accomodation VALUES(?, ?, ?, ?, ?)");
        preparedStatement.setString(1, "1");
        preparedStatement.setString(2,"deluxe");
        preparedStatement.setString(3, "Matrimonial bed");
        preparedStatement.setString(4, "3");
        preparedStatement.setString(5, "High quality room");
        preparedStatement.execute();

        connection.createStatement().executeUpdate(
                "INSERT INTO accomodation(id, type  ,bed_type , max_guests, description)" +
                "VALUES('2' , 'cheap' , 'Single bed', 1 ,'Low quality room') ;");

        ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM accomodation");
        resultSet.next();
        //System.out.println(resultSet.getString("id"));
        Assertions.assertEquals("Matrimonial bed", resultSet.getString("bed_type"));
    }

    @Test
    public void test_interrogation()throws SQLException{
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:test_mem");
        connection.createStatement().executeUpdate(
                "INSERT INTO room_fair(id, \"value\", season)" +
                        "VALUES('1' , '5000' , 'summer')");
        ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM room_fair");
        rs.next();
        //System.out.println(rs.getString("value"));
        Assertions.assertEquals("5000.0", rs.getString("value"));
    }
}




