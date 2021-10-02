/*
Count the number of Duplicates

Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits that occur more than once in the input string. The input string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.
Example

"abcde" -> 0 # no characters repeats more than once
"aabbcde" -> 2 # 'a' and 'b'
"aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
"indivisibility" -> 1 # 'i' occurs six times
"Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
"aA11" -> 2 # 'a' and '1'
"ABBA" -> 2 # 'A' and 'B' each occur twice
*/
import java.util.HashMap;
import java.util.Map;

public class CountingDuplicates {
  public static int duplicateCount(String text) {
    int count = 0;
    HashMap<Character, Integer> letters = new HashMap<>();
    
    text = text.toLowerCase();
    
    for (int i = 0; i  < text.length(); i++){
      //if letter already exisits, add one to its count, otherwise add it to the map with a value of 0 as it has 0 multiples
      if (letters.containsKey(text.charAt(i))) letters.replace(text.charAt(i), letters.get(text.charAt(i))+1);
      else letters.put(text.charAt(i), 0);
    }
    
    for (Map.Entry<Character, Integer> pair : letters.entrySet()) {
      if (pair.getValue() > 0) count++;
    }
    
    return count;
  }
}