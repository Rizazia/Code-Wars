/*
You will be given a number and you will need to return it as a string in Expanded Form. For example:

Kata.expandedForm(12); # Should return "10 + 2"
Kata.expandedForm(42); # Should return "40 + 2"
Kata.expandedForm(70304); # Should return "70000 + 300 + 4"

NOTE: All numbers will be whole numbers greater than 0.
*/

import java.lang.StringBuilder;
public class Kata{
    public static String expandedForm(int num){
      StringBuilder s = new StringBuilder();
      int digit = 1;
      while (num > 0){ //while the number still needs to be processed
          //if a number at the current digit is > 0, write it with 0s representing its digit
          if (num % 10 > 0){s.insert(0, (num % 10) * digit);
          //if this is not the end of the number
          if (num / 10 > 0) s.insert(0, " + ");  
        }
        num /= 10; //remove the last digit of the number
        digit *= 10; //increment the digit the loop is currentkly viewing
      }
      
      return s.toString();
    }
}