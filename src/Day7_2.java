import java.io.FileReader;
import java.util.*;

public class Day7_2 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader("input/day-7"));

        HashMap<String, HashSet<String>> childBags = new HashMap<>();
        while (s.hasNext()){
            String line = s.nextLine();
            String parent = line.split(" bags contain ")[0].replaceAll(" ", "");
            String[] children = line.split(" bags contain ")[1].split(", ");
            for (int i = 0; i < children.length; i++) {
                children[i] = children[i].replaceAll("bag[s]*", "");
                children[i] = children[i].replaceAll("\\.", "");
                children[i] = children[i].replaceAll(" ", "");
                if (childBags.get(parent) == null) {
                    childBags.put(parent, new HashSet<>());
                }
                childBags.get(parent).add(children[i]);
            }
        }

        System.out.println(getCount(childBags, "shinygold")-1);
    }

    static int getCount(HashMap<String, HashSet<String>> bags, String name) {
        int ret = 1;
        for (String s : bags.get(name)) {
            if (s.equals("noother")) return 1;
            ret += Integer.parseInt(s.substring(0,1)) * getCount(bags, s.substring(1));
        }
        return ret;
//        return bags.get(name).stream()
//                .mapToInt(s -> s.equals("noother") ? 1 : Integer.parseInt(s.substring(0,1)) * getCount(bags, s.substring(1)))
//                .sum() + 1;
        // why is this lambda not working aaaaa
    }
}

