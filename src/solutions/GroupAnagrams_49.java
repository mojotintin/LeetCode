package solutions;

import java.util.*;

/**
 * Created by Calabash on 2017/5/7.
 *
 */
public class GroupAnagrams_49 {


    public List<List<String>> groupAnagrams(String[] strs) {

        if(strs == null || strs.length == 0) return new ArrayList<List<String>>();

        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String s = String.valueOf(ca);
            if (!groups.containsKey(s)) {
                groups.put(s, new ArrayList<String>());
            }
            groups.get(s).add(str);
        }

        return new ArrayList<List<String>>(groups.values());
    }
}
