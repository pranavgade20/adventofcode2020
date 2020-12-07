import java.io.FileReader;
import java.util.*;

public class Day7_1 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader("input/day-7"));

        HashMap<String, HashSet<String>> bagToParent = new HashMap<>();
        while (s.hasNext()){
            String line = s.nextLine();
            String parent = line.split(" bags contain ")[0].replaceAll(" ", "");
            String[] children = line.split(" bags contain ")[1].split(", ");
            for (int i = 0; i < children.length; i++) {
                children[i] = children[i].replaceAll("bag[s]*", "");
                children[i] = children[i].replaceAll("\\.", "");
                children[i] = children[i].replaceAll(" ", "");
                children[i] = children[i].replaceAll("[1-9]", "");
                if (bagToParent.get(children[i]) == null) {
                    bagToParent.put(children[i], new HashSet<>());
                }
                bagToParent.get(children[i]).add(parent);
            }
        }

        HashSet<String> res = new HashSet<>();
        Deque<String> deque = new LinkedList<>();
        deque.add("shinygold");
        while (!deque.isEmpty()) {
            String current = deque.removeFirst();
            Set<String> c = bagToParent.get(current) == null ? Collections.emptySet() : bagToParent.get(current);
            deque.addAll(c);
            res.addAll(c);
        }

        System.out.println(res.size());
    }
}

