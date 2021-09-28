/*
A Hamming number is a positive integer of the form 2i3j5k, for some non-negative integers i, j, and k.

Write a function that computes the nth smallest Hamming number.

Specifically:

    The first smallest Hamming number is 1 = 203050
    The second smallest Hamming number is 2 = 213050
    The third smallest Hamming number is 3 = 203150
    The fourth smallest Hamming number is 4 = 223050
    The fifth smallest Hamming number is 5 = 203051

The 20 smallest Hamming numbers are given in example test fixture.

Your code should be able to compute all of the smallest 5,000 (Clojure: 2000, NASM: 13282) Hamming numbers without timing out.
*/

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class Hamming {

    public static long hamming(int n) {
      if (n <= 0) return -1;
      
      SortedSet<Long> resultSet = new TreeSet<>();
      resultSet.add(1l);
      
      TreeSet<Long> ts = new TreeSet<>(Arrays.asList(2L, 3L, 5L));
      long smallest = 1;

      for (int i = 1; i < n; i++) {
          smallest = ts.pollFirst();
          ts.add(smallest * 2);
          ts.add(smallest * 3);
          ts.add(smallest * 5);
      }

      return smallest;
    }
}