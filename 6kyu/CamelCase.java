/*
Write simple .camelCase method (camel_case function in PHP, CamelCase in C# or camelCase in Java) for strings. All words must have their first letter capitalized without spaces.

For instance:

camelCase("hello case"); // => "HelloCase"
camelCase("camel case word"); // => "CamelCaseWord"

Don't forget to rate this kata! Thanks :)
*/

import java.lang.StringBuilder;
import java.lang.Character;

public class Solution {

    public static String camelCase(String str) {
      StringBuilder ans = new StringBuilder(str);
      int index = 0;
      boolean cap = true;
      
      while(index < ans.length()){
        //if current index is a space delete it, set cap to true, and recheck the index
        if (ans.charAt(index) == ' '){
          ans.deleteCharAt(index);
          cap = true;
          continue;
        }
        //if cap is true, it is either the first char in the string or the previous loop(s) found a space
        else if (cap){
          ans.setCharAt(index, Character.toUpperCase(ans.charAt(index)));
          cap = false;
        } else { //otherwise we are in the middle of a word so make the char lower case
          ans.setCharAt(index, Character.toLowerCase(ans.charAt(index)));
        }
        
        index++;
      }
      
      return ans.toString();
    }

}