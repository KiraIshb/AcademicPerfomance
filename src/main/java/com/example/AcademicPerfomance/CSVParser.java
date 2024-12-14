package com.example.AcademicPerfomance;
import com.example.db.DBRepository;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Scanner;

public class CSVParser {
	
    private static Scanner getScanner(String path) throws IOException {
        String content = Files.readString(Path.of(path), StandardCharsets.UTF_8);
        return new Scanner(content);
    }
	
    public static HashMap<String, Group> getData(String path, HashMap<String, Group> data) throws IOException {
        DBRepository.connect();
        DBRepository.createTableGroups();
        DBRepository.createTableStudents();
        Scanner sc = getScanner(path);
        sc.nextLine();
        sc.nextLine();
        sc.nextLine();
        while (sc.hasNextLine()) {
                var student = sc.nextLine().split(";");
                createStudent(student, data);
        }
        return data;
    }
	
    private static void createStudent(String[] student, HashMap<String, Group> data) {

        var fullName = student[0];
        var group = student[1];
        var activity = Integer.parseInt(student[2]);
        var exercises = Integer.parseInt(student[3]);
        var homework = Integer.parseInt(student[4]);
        var st = new Student(fullName, group, activity, exercises, homework);
        DBRepository.saveStudents(st);
        
        if (data.containsKey(group)) {
                var gr = data.get(group);
                gr.addStudent(st);
        }
        else {
                var Gr = new Group(group);
                data.put(group, Gr);
                var gr = data.get(group);
                DBRepository.saveGroups(Gr);
                gr.addStudent(st);
        }
    }
}
