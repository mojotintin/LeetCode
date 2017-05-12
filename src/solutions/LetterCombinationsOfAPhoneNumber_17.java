package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Calabash on 2017/5/8.
 *
 */
public class LetterCombinationsOfAPhoneNumber_17 {

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
    		return new ArrayList<String>();
    	}

    	String[] cha = new String[]{"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> letters = new ArrayList<>();
        letters.add("");

        for (int i = 0; i < digits.length(); i ++) {
        	List<String> list = new ArrayList<>();
        	String digit = cha[Character.getNumericValue(digits.charAt(i)) - 1];
        	if (digit == "") {
        		return new ArrayList<String>();
        	}
        	for (String s : letters) {
        		for (int j = 0; j < digit.length(); j ++) {
        			list.add(s + digit.charAt(j));
        		}
        	}
        	letters = list;
        }
        return letters;
    }
}
