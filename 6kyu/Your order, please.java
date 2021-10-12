/*
Your task is to sort a given string. Each word in the string will contain a single number. This number is the position the word should have in the result.

Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).

If the input string is empty, return an empty string. The words in the input String will only contain valid consecutive numbers.
Examples

"is2 Thi1s T4est 3a"  -->  "Thi1s is2 3a T4est"
"4of Fo1r pe6ople g3ood th5e the2"  -->  "Fo1r the2 g3ood 4of th5e pe6ople"
""  -->  ""
*/
import java.util.HashMap;
import java.util.Map;

public class Order {
  public static String order(String words) {
    if (words == "") return "";
    
    //hashmap used to store individual words and the order it appears in
    HashMap<String, Integer> wordOrder = new HashMap<>();
    String[] parts = words.split(" ");
    String res = "";
    //put the words in a hashmap
    for (int i = 0; i < parts.length;i++){
      wordOrder.put(parts[i], 0);
    }
    //find the order of the words
    for(Map.Entry<String, Integer> entry : wordOrder.entrySet()) {
      //find the number within the word and palce that on the hashmap
      int placement = Integer.parseInt(entry.getKey().replaceAll("[*a-zA-Z]", ""));
      wordOrder.replace(entry.getKey(), placement);
    }
    
    //put words in order
    int nextValue = 1;
    while(!wordOrder.isEmpty()){
      //find the next word to be added, add it, then remove it
      for(Map.Entry<String, Integer> entry : wordOrder.entrySet()) {
        if (entry.getValue() == nextValue){
          res += entry.getKey();
          wordOrder.remove(entry.getKey());
          if (!wordOrder.isEmpty()) res += " "; //if more words exist add a space
          break;
        }
      }
      //increment nextValue to find the word in order
      nextValue++;
    }
    
    return res;
  }
}