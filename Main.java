import java.util.*;

public class Main {
    public static void main(String[] args) {
        Hashtable<String, List<String>> table = DicoEditor.buildTable("dico.txt");

        String phrase = " le jaune !";
        System.out.println("\nWith the phrase : " + phrase + "\n");
        phrase = phrase.replaceAll("[!?.,: ]", "" );


        Set<SeparatedWord> sum2= find2Sum(phrase, table);
        for (SeparatedWord word : sum2) {
            System.out.println(word);
        }

    }

    private static Set<SeparatedWord> find2Sum(String phrase, Hashtable<String, List<String>> table) {
        Set<SeparatedWord> sum2 = new HashSet<>();
        int count = 0;
        int pairs = 0;

        for (String first : table.keySet()) {
            if (first.length() < phrase.length()) {
                String complementary = DicoEditor.getComplementary(phrase, first);
                assert complementary != null;
                complementary = DicoEditor.sort(complementary);
                if (first.length() + complementary.length() == phrase.length()) {

                    if (table.containsKey(complementary)) {
                        for (String second : table.get(complementary)) {
                            for (String first2 : table.get(first)) {
                                SeparatedWord half = new SeparatedWord(first2, second);
                                if (!sum2.contains(half) && !sum2.contains(half.switchHalves())) {
                                    sum2.add(half);
                                    pairs++;
                                }
                            }
                        }
                    }
                }
            }
            count++;
        }
        return sum2;
    }

}
