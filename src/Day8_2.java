import java.io.FileReader;
import java.util.Scanner;

public class Day8_2 {
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

        out: for (int j = 0; j < 608; j++) {
            switch (instructions[j]) {
                case 'a':
                    continue;
                case 'n':
                    instructions[j] = 'j';
                    break;
                case 'j':
                    instructions[j] = 'n';
                    break;
            }
            i = 0;
            visited = new boolean[608];
            while (!visited[i]) {
                visited[i] = true;
                if (i == instructions.length-2) {
                    break out;
                }

                switch (instructions[i]) {
                    case 'a':
                    case 'n':
                        i++;
                        break;
                    case 'j':
                        i += arguments[i];
                        break;
                }
            }

            switch (instructions[j]) {
                case 'n':
                    instructions[j] = 'j';
                    break;
                case 'j':
                    instructions[j] = 'n';
                    break;
            }

        }

        i = 0;
        long acc = 0;
        visited = new boolean[608];
        while (!visited[i]) {
            visited[i] = true;
            if (i == 607) break;

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

