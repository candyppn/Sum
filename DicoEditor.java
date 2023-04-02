import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DicoEditor {

    //Create a hashtable with the key being the sorted word and the value being the list of words

    public static Hashtable<String, List<String>> buildTable(String path) {
        Hashtable<String, List<String>> table = new Hashtable<>();
        try{
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine();
                String sortedWord = sort(word);
                if (table.containsKey(sortedWord)) {
                    table.get(sortedWord).add(word);
                } else {
                    List<String> temp = new ArrayList<>();
                    temp.add(word);
                    table.put(sortedWord, temp);
                }
            }
        } catch (FileNotFoundException error) {
            throw new RuntimeException(error);
        }
        return table;
    }

    //Sort the word

    public static String sort(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

    public static String getComplementary(String fullPhrase, String word) {
        if(fullPhrase.length() <= word.length() || word.length() == 0) {
            return null;
        }
        String[] phrase = fullPhrase.split(" ");
        String complementary = "";
        //remove the letters in word from phrase
        for (char c : fullPhrase.toCharArray()){
            if (!word.contains(String.valueOf(c))) {
                complementary += c;
            }
            word = word.replaceFirst(String.valueOf(c), "");
        }
        if(complementary.length() == 0) {
            return null;
        }
        return complementary;
    }

}
