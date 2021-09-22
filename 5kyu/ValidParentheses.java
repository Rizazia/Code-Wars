/*
Write a function that takes a string of parentheses, and determines if the order of the parentheses is valid. The function should return true if the string is valid, and false if it's invalid.
Examples

"()"              =>  true
")(()))"          =>  false
"("               =>  false
"(())((()())())"  =>  true

Constraints

0 <= input.length <= 100

Along with opening (() and closing ()) parenthesis, input may contain any valid ASCII characters. Furthermore, the input string may be empty and/or not contain any parentheses at all. Do not treat other forms of brackets as parentheses (e.g. [], {}, <>).
*/

public class Solution{
  public static boolean validParentheses(String parens){
    int count = 0;
    for (int i = 0; i < parens.length();i++){
      if (parens.charAt(i) == '(')
        count++;
      else if (parens.charAt(i) == ')')
        count--;
      
      if (count < 0)
        return false;
    }
    
    return count == 0  ? true : false;
  }
}