/*
Complete the method/function so that it converts dash/underscore delimited words into camel casing. The first word within the output should be capitalized only if the original word was capitalized (known as Upper Camel Case, also often referred to as Pascal case).
Examples

"the-stealth-warrior" gets converted to "theStealthWarrior"
"The_Stealth_Warrior" gets converted to "TheStealthWarrior"
*/

import java.lang.StringBuilder;
import java.lang.Character;

class Solution{

  static String toCamelCase(String s){
    StringBuilder ans = new StringBuilder(s);
    int index = 0;
    boolean toCap = false;
    
    while (index < ans.length()){
      if (!Character.isLetter(ans.toString().charAt(index))){
        ans.deleteCharAt(index);
        toCap = true;
        continue;
      } else if (toCap && index != 0){
        //make index upper case
        ans.setCharAt(index, Character.toUpperCase(ans.charAt(index)));
        toCap = false;
      } else if (index != 0){ //make index lower case
        ans.setCharAt(index, Character.toLowerCase(ans.charAt(index)));
      }
      
      index++;
    }
    
    return ans.toString();
  }
}