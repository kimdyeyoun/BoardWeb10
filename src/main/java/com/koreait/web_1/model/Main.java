package com.koreait.web_1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] arr ;
        for(int i = 0 ; i < num ; i++) {
            int student = sc.nextInt();
            arr = new int[student];
            double sum = 0;
            for (int j=0; j<student; j++){

                int stunum = sc.nextInt();
                arr[j] = stunum;
                sum = sum + (double)(stunum);
            }
            double avg = 0;
            avg = sum / (double)student;
            int cnt = 0;
            for (int k = 0; k < student; k++){
                if (avg > arr[k]){
                    cnt++;
                }
            }
            double result = (double)cnt/student*100;
            System.out.printf("%.3f%%\n", result);
        }
    }
}
