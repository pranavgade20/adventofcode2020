import java.io.FileReader;
import java.util.Scanner;

public class Day18_2 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader("input/day-18"));

        long res = 0;

        while (s.hasNext()){
            String line = s.nextLine();
            res += parse(line);
        }

        System.out.println(res);
    }

    public static long parse(String expr) {
        while (expr.contains("(")) {
            int opening = expr.indexOf("(");
            int closing = getMatching(opening, expr);
            expr = expr.substring(0, opening) + parse(expr.substring(opening+1, closing)) + expr.substring(closing+1);
        }
//        while (expr.contains("+")) {
//            int mid = expr.indexOf('+');
//            int a = Integer.parseInt(expr.substring(expr.lastIndexOf(' ', mid-1), mid-1));
//            int b = Integer.parseInt(expr.substring(mid+1, expr.indexOf(' ', mid+1)));
//            expr = expr.substring(0, expr.lastIndexOf(' ', mid-1)) + (a+b) + expr.substring(expr.indexOf(' ', mid+1));
//        }
        long ret = 1;
        for (String e : expr.split("\\*")) {
            if (e.contains("+")) {
                long res = 0;
                for (String s : e.split("\\+")) {
                    res += Integer.parseInt(s.trim());
                }
                ret *= res;
            } else ret *= Integer.parseInt(e.trim());
        }

        return ret;
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

