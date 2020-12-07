#!/bin/bash

touch "input/day-$1"

echo "import java.io.FileReader;
import java.util.Scanner;

public class Day$1_1 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader(\"input/day-$1\"));

        int res = 0;

        while (s.hasNext()){
            String line = s.nextLine();
        }

        System.out.println(res);
    }
}
" > "src/Day$1_1.java"

echo "import java.io.FileReader;
import java.util.Scanner;

public class Day$1_2 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader(\"input/day-$1\"));

        int res = 0;

        while (s.hasNext()){
            String line = s.nextLine();
        }

        System.out.println(res);
    }
}
" > "src/Day$1_2.java"