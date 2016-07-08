package ShortestPaths;

import Graphs.BreadthFirstSearch;
import Graphs.UndirectedGraph;

import java.util.HashMap;

/**
 * Created by Kumar_Garg on 7/5/2016.
 */
public class WordLadder {
    private boolean differByOne(String s1, String s2) {
        if(s1.length() != s2.length()) return false;

        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 1) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordLadder ladder = new WordLadder();
        assert ladder.differByOne("green", "greet") : "Green Greet";
        assert !ladder.differByOne("green", "brown") : "Green Brown";

        HashMap<String, Integer> words = new HashMap<>();
        String[] keys = {"green", "brown", "groan", "greet", "grown", "great", "groat"};

        words.put("green", 0);
        words.put("brown", 1);
        words.put("groan", 2);
        words.put("greet", 3);
        words.put("grown", 4);
        words.put("great", 5);
        words.put("groat", 6);

        UndirectedGraph graph = new UndirectedGraph(7);

        for (String word1 : words.keySet()) {
            for (String word2 : words.keySet()) {
                if(word1.length() != word2.length()) throw new RuntimeException("Strings not of equal length");
                if(word1.compareTo(word2) < 0 && ladder.differByOne(word1, word2)) {
                    graph.addEdge(words.get(word1), words.get(word2));
                }
            }
        }

        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, words.get("green"));
        if(bfs.hasPathTo(words.get("groat"))) {
            for (int i : bfs.pathTo(words.get("brown"))) {
                System.out.print(keys[i] + " ");
            }
        }
    }
}
