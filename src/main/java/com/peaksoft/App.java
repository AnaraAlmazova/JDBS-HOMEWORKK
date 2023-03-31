package com.peaksoft;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

    public static void main(String[] args) throws SQLException {
        // table();
addMayor("Emilbek Abdykadyrov", 45);
addMayor("Almaz Mambetov", 40);
addMayor("Kanbolot Tutuev", 42);
addMayor("Iliyaz Imanbetiov", 45);
addMayor("Askar Shabdanov", 45);
   //    addCity("Bishkek", 1);
//        addCity("Osh", 2);
//        addCity("Naryn", 3);
//        addCity("YssykKol", 4);
  //      addCity("Talas", 5);
    //    addCountry("Kyrfgyzstan", "Bishkek");


    }


    public static void table() {
        String SQL = " CREATE TABLE IF NOT EXISTS mayor(" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(58)," +
                "age INT );" +

                "CREATE TABLE IF NOT EXISTS city(" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(45)," +
                "mayor_id INT," +
                "FOREIGN KEY (mayor_id) REFERENCES mayor(id));" +

                "CREATE TABLE IF NOT EXISTS country(" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(55)," +
                "city_id INT," +
                "FOREIGN KEY (city_id) REFERENCES city(id)); ";
        try (Connection conn = DBase.connection();
             Statement statement = conn.createStatement()) {
            statement.executeUpdate(SQL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addMayor(String name, int age) {
        String SQL = " INSERT INTO mayor (name,age) VALUES (?,?)";
        try (Connection conn = DBase.connection();
             PreparedStatement statement = conn.prepareStatement(SQL)) {
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void addCity(String name, int mayor) {
        String SQL1 = " INSERT INTO city (name,mayor_id) VALUES (?,?)";
        try (Connection conn = DBase.connection();
             PreparedStatement statement = conn.prepareStatement(SQL1)) {
            statement.setString(1, name);
            statement.setInt(2, mayor);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void addCountry(String name, String city) {
        String SQL2 = " INSERT INTO country (name, city_id) VALUES (?,?)";
        try (Connection conn = DBase.connection();
             PreparedStatement statement = conn.prepareStatement(SQL2)) {
            statement.setString(1, name);
       //     statement.setNull(2, mayor);
            statement.setInt(2, city.indexOf(1));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}































//    public static void add(String name, Mayor mayor, City city) {
//        String SQL = " INSERT INTO country (name, mayor, city) VALUES (?,?,?)";
//
//        try (Connection conn = DBase.connection();
//             PreparedStatement statement = conn.prepareStatement(SQL)) {
//            statement.setString(1, name);
//            statement.setInt(2, age);
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//}

