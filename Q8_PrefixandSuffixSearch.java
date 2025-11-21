import java.util.HashMap;
import java.util.Map;

public class Q8_PrefixandSuffixSearch {

    Map<String, Integer> map = new HashMap<>();

    // Constructor (must match class name)
    public Q8_PrefixandSuffixSearch(String[] words) {
        for (int index = 0; index < words.length; index++) {
            String word = words[index];
            int n = word.length();

            // generate all prefix + suffix combinations
            for (int i = 0; i <= n; i++) {
                String prefix = word.substring(0, i);
                for (int j = 0; j <= n; j++) {
                    String suffix = word.substring(j);
                    map.put(prefix + "#" + suffix, index);
                }
            }
        }
    }

    // Normal method (not static)
    public int f(String prefix, String suffix) {
        return map.getOrDefault(prefix + "#" + suffix, -1);
    }

    // MAIN function
    public static void main(String[] args) {

        String[] words = {"apple", "apply", "ape"};

        Q8_PrefixandSuffixSearch obj = new Q8_PrefixandSuffixSearch(words);

        System.out.println(obj.f("ap", "le")); // 0 (apple)
        System.out.println(obj.f("ap", "ly")); // 1 (apply)
        System.out.println(obj.f("a", "e"));   // 2 (ape)
        System.out.println(obj.f("zz", "yy")); // -1 (not found)
    }
}
