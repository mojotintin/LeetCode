/*
 * Created by calabash on 2017/8/9.
 * Problem Number: 187
 * Problem Name: Repeated DNA Sequences
 * Difficulty: Medium
 * Related Topics: Hash Table, Bit Manipulation
 * Source: https://leetcode.com/problems/repeated-dna-sequences/
 */
package algorithms.bitmanipulation;

import java.util.*;

/**
 * #---------------------------------------------------------------------------
 * # All DNA is composed of a series of nucleotides abbreviated as A, C, G, and
 * # T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to
 * # identify repeated sequences within the DNA.
 * #
 * # Write a function to find all the 10-letter-long sequences (substrings)
 * # that occur more than once in a DNA molecule.
 * #
 * # For example,
 * # Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * # Return:
 * # ["AAAAACCCCC", "CCCCCAAAAA"].
 * #---------------------------------------------------------------------------
 */
public class RepeatedDNASequences {
  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 71ms
   */
  public List<String> findRepeatedDnaSequences(String s) {
    List<String> list = new ArrayList<>();
    Set<Integer> sequences = new HashSet<>();
    Set<Integer> repeatedSequences = new HashSet<>();
    Map<Integer, Integer> nucleotides = new HashMap<>();
    nucleotides.put(0, 0);
    nucleotides.put('C' - 'A', 1);
    nucleotides.put('G' - 'A', 2);
    nucleotides.put('T' - 'A', 3);
    for (int i = 0; i < s.length() - 9; i++) {
      int sequence = 0;
      for (int j = i; j < i + 10; j++) {
        sequence |= nucleotides.get(s.charAt(j) - 'A');
        sequence <<= 2;
      }
      if (!sequences.add(sequence) && repeatedSequences.add(sequence)) {
        list.add(s.substring(i, i + 10));
      }
    }
    return list;
  }
}
