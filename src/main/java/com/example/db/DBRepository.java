package com.example.db;
import com.example.AcademicPerfomance.Group;
import com.example.AcademicPerfomance.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DBRepository {
    private static Connection conn = null;
    private static final String URL = "jdbc:sqlite:D:/SQLiteStudio/Project/test.db";
    
    public static void connect(){
        try{
            conn = DriverManager.getConnection(URL);
            System.out.println("Connected");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static void createTableGroups() {
        var sql = "CREATE TABLE IF NOT EXISTS groups (\n"
                + "id integer PRIMARY KEY, \n"
                + "number text NOT NULL,\n"
                + "perfomance double,\n"
                + "quantity double\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(URL)){
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("created group");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void saveGroups(Group g) {
        String sql = "INSERT INTO groups(number, perfomance, quantity) VALUES(?,?,?)";
        
        try (Connection conn = DriverManager.getConnection(URL);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, g.getNumGroup());
            pstmt.setDouble(2, g.getPerfomanse());
            pstmt.setDouble(2, g.getQuantity());
            System.out.println("Save group");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static HashMap<String,Integer> getGroup(){
        String sql = "SELECT number, perfomance FROM groups";
        
        var res = new HashMap<String,Integer>();
        try (Connection conn = DriverManager.getConnection(URL);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while(rs.next()) {
                res.put(rs.getString("number"), rs.getInt("perfomance"));
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return res;
    }
    
    public static void createTableStudents() {
        var sql = "CREATE TABLE IF NOT EXISTS students (\n"
                + "id integer PRIMARY KEY, \n"
                + "fullName text NOT NULL,\n"
                + "numGroup text NOT NULL,\n"
                + "score double\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(URL)){
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("created student");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void saveStudents(Student s) {
        String sql = "INSERT INTO students(fullName, numGroup, score) VALUES(?,?,?)";
        try (Connection conn = DriverManager.getConnection(URL);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, s.getFullName());
            pstmt.setString(2, s.getNumGroup());
            pstmt.setDouble(3, s.getFinalScore());
            System.out.println("Save student");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static HashMap<String,Integer> getStudent(){
        String sql = "SELECT fullName, score FROM students";
        
        var res = new HashMap<String,Integer>();
        try (Connection conn = DriverManager.getConnection(URL);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while(rs.next()) {
                res.put(rs.getString("fullName"), rs.getInt("score"));
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return res;
    }
}
