import java.io.FileReader;
import java.util.Scanner;

public class Day18_1 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader("input/day-18"));

        long res = 0;

        while (s.hasNext()){
            String line = s.nextLine();
            res += parse(line);
            System.out.println(parse(line));
        }

        System.out.println(res);
    }

    public static int parse(String expr) {
        if (expr.startsWith("(")) {
            int end = getMatching(0, expr);
            if (end == expr.length()-1) return parse(expr.substring(1, end).trim());
            else {
                if (expr.charAt(end+2) == '*') return parse(expr.substring(1, end).trim()) * parse(expr.substring(end+3).trim());
                if (expr.charAt(end+2) == '+') return parse(expr.substring(1, end).trim()) + parse(expr.substring(end+3).trim());
            }
        } else {
            int end = expr.indexOf(' ');
            if (end == -1) return Integer.parseInt(expr);
            if (expr.charAt(end+1) == '*') return parse(expr.substring(0, end).trim()) * parse(expr.substring(end+3).trim());
            if (expr.charAt(end+1) == '+') return parse(expr.substring(0, end).trim()) + parse(expr.substring(end+3).trim());
        }
        return 0;
    }

    public static int getMatching(int start, String expr) {
        int c = 1;

        while (++start < expr.length() && c > 0) {
            if (expr.charAt(start) == '(') c++;
            if (expr.charAt(start) == ')') c--;
        }
        return start-1;
    }
}

