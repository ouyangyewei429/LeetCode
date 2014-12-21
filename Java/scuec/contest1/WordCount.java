package scuec.contest1;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordCount {
    /** word delimiter */
    private final static String DELIMITER = " ";
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            TreeMap<String, Integer> wordMap = new TreeMap<String, Integer>();
            String[] strs = sc.nextLine().split(DELIMITER);
            for (String word : strs) {
                if (wordMap.containsKey(word)) {
                    wordMap.put(word, wordMap.get(word)+1);
                } else {
                    wordMap.put(word, 1);
                }
            }
            
            /** output the result */
            for (Map.Entry<String, Integer> map : wordMap.entrySet()) {
                System.out.println(map.getKey()+":"+map.getValue());
            }
        }// end of while
    }
}
