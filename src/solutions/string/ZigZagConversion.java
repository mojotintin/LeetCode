package solutions.string;

/**
 * Created by Calabash on 2017/5/31.
 * Problem Number : 6
 * Problem Name : ZigZag Conversion
 * Description : https://leetcode.com/problems/zigzag-conversion/#/description
 * Difficulty : Medium
 * Tags : String
 */
public class ZigZagConversion {

    /**
     * Submission : 1
     * Status : Accepted
     * Runtime : 56ms
     */
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;
    	int range = numRows * 2 - 2;
    	int round = s.length() / range;
    	int tail = s.length() % range;
    	if (tail != 0) round ++;
    	StringBuilder newS = new StringBuilder();

    	for (int j = 0; j < round - 1; j++) {
    	    newS.append(s.charAt(j * range));
    	}
    	if ((round - 1) * range < s.length()){
    	    newS.append(s.charAt((round - 1) * range));
    	}


    	int d = range - 2;
    	for (int i = 1; i < range / 2; i++) {

    		for (int j = 0; j < round - 1; j++) {
    			newS.append(s.charAt(j * range + i));
    			newS.append(s.charAt(j * range + i + d));
    		}
    		if ((round - 1) * range + i < s.length()) {
    			newS.append(s.charAt((round - 1) * range + i));
    		}
    		if ((round - 1) * range + i + d < s.length()) {
    			newS.append(s.charAt((round - 1) * range + i + d));
    		}
    		d -= 2;
    	}

    	for (int j = 0; j < round - 1; j++) {
    	    newS.append(s.charAt(j * range + range / 2));
    	}
    	if ((round - 1) * range + range / 2 < s.length()){
    	    newS.append(s.charAt((round - 1) * range + range / 2));
    	}

    	return newS.toString();
    }
}
