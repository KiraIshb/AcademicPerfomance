package com.example.httpRequests;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.Arrays;

public class HttpRepository {
    private static final String API_URL = "https://api.api-ninjas.com/v1/exercises?muscle=";
    //ПЕРЕД ПУШЕМ УДАЛИТЬ!
    private static final String API_KEY = "TI5FrejA5fcq5pMBrXpVqg==oJDLqVI7Js9dwsu4";
    
    public static void getExerciesData (String param) throws IOException {
        URL url = new URL(API_URL + param);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");
        connection.setRequestProperty("x-api-key", API_KEY);
        InputStream responseStream = connection.getInputStream();
        
        ObjectMapper mapper = new ObjectMapper();
        Exercise[] exercises = mapper.readValue(responseStream, Exercise[].class);
        //System.out.println(Arrays.toString(exercises));
        for (Exercise exercise : exercises){
            System.out.println(exercise);
        }
    }
}
