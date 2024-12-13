package com.example.gradleproject1;
import com.example.httpRequests.HttpRepository;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a muscle (abdominals|abductorsadductors|biceps|calves|chest"
                + "|forearms|glutes|hamstrings|lats|lower_back|middle_back|neck|quadriceps|traps|triceps): ");
        String muscle = in.nextLine();
        try{
            HttpRepository.getExerciesData(muscle);
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
