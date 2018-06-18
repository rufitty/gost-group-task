package task;

import java.io.InputStream;
import java.util.*;

public class Text {
    public static void main(String[] arg) {
        Text text = new Text();
        System.out.println("Type some text. Type ^D on Linus or ^Z on Windows to finish input");
        System.out.println(text.countWords(System.in));
    }

    public List<Map.Entry<String, Integer>> countWords(InputStream inputStream) {
        HashMap<String, Integer> map = new HashMap<>();
        Scanner input = new Scanner(inputStream);
        input.useDelimiter("[\\p{Punct}\\p{Blank}\\p{Cntrl}]+");
        while (input.hasNext()){
            String word = input.next().toLowerCase();
            Integer oldCount = map.get(word);
            if (oldCount == null) {
                oldCount = 0;
            }
            map.put(word, oldCount + 1);
        }
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(map.entrySet());
        Comparator<Map.Entry<String, Integer>> entryComparator = Comparator.comparing(Map.Entry::getValue);
        sortedEntries.sort(entryComparator.reversed());
        return sortedEntries;
    }
}
