import java.io.FileReader;
import java.util.Scanner;

public class Day8_1 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader("input/day-8"));

        char[] instructions = new char[608];
        int[] arguments = new int[608];
        boolean[] visited = new boolean[608];

        int i = 0;
        while (s.hasNext()){
            String line = s.nextLine();
            instructions[i] = line.charAt(0);
            arguments[i] = Integer.parseInt(line.split(" ")[1]);

            i++;
        }

        i = 0;
        long acc = 0;
        while (!visited[i]) {
            visited[i] = true;

            switch (instructions[i]) {
                case 'a':
                    acc += arguments[i];
                    i++;
                    break;
                case 'n':
                    i++;
                    break;
                case 'j':
                    i += arguments[i];
                    break;
            }
        }

        System.out.println(acc);
    }
}

