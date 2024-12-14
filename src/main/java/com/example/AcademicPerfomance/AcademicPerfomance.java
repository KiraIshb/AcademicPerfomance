package com.example.AcademicPerfomance;
import com.example.db.DBRepository;
import java.io.IOException;
import java.util.HashMap;

public class AcademicPerformance {
    public static void main(String[] args) {
        var path = "assets/basicprogramming_2.csv";
	var data = new HashMap<String, Group>();
	try {
            data = CSVParser.getData(path, data);
	} catch (IOException e) {
            e.printStackTrace();
	}
	//System.out.println(data.entrySet());  
        System.out.println(DBRepository.getGroup());
        System.out.println(DBRepository.getStudent());
    }
}
