/*
    "7777...8?!??!", exclaimed Bob, "I missed it again! Argh!" Every time there's an interesting number coming up, he notices and then promptly forgets. Who doesn't like catching those one-off interesting mileage numbers?

Let's make it so Bob never misses another interesting number. We've hacked into his car's computer, and we have a box hooked up that reads mileage numbers. We've got a box glued to his dash that lights up yellow or green depending on whether it receives a 1 or a 2 (respectively).

It's up to you, intrepid warrior, to glue the parts together. Write the function that parses the mileage number input, and returns a 2 if the number is "interesting" (see below), a 1 if an interesting number occurs within the next two miles, or a 0 if the number is not interesting.

Note: In Haskell, we use No, Almost and Yes instead of 0, 1 and 2.
"Interesting" Numbers

Interesting numbers are 3-or-more digit numbers that meet one or more of the following criteria:

    Any digit followed by all zeros: 100, 90000
    Every digit is the same number: 1111
    The digits are sequential, incementing†: 1234
    The digits are sequential, decrementing‡: 4321
    The digits are a palindrome: 1221 or 73837
    The digits match one of the values in the awesomePhrases array

    † For incrementing sequences, 0 should come after 9, and not before 1, as in 7890.
    ‡ For decrementing sequences, 0 should come after 1, and not before 9, as in 3210.

So, you should expect these inputs and outputs:

// "boring" numbers
CarMileage.isInteresting(3, new int[]{1337, 256});    // 0
CarMileage.isInteresting(3236, new int[]{1337, 256}); // 0

// progress as we near an "interesting" number
CarMileage.isInteresting(11207, new int[]{}); // 0
CarMileage.isInteresting(11208, new int[]{}); // 0
CarMileage.isInteresting(11209, new int[]{}); // 1
CarMileage.isInteresting(11210, new int[]{}); // 1
CarMileage.isInteresting(11211, new int[]{}); // 2

// nearing a provided "awesome phrase"
CarMileage.isInteresting(1335, new int[]{1337, 256}); // 1
CarMileage.isInteresting(1336, new int[]{1337, 256}); // 1
CarMileage.isInteresting(1337, new int[]{1337, 256}); // 2

Error Checking

    A number is only interesting if it is greater than 99!
    Input will always be an integer greater than 0, and less than 1,000,000,000.
    The awesomePhrases array will always be provided, and will always be an array, but may be empty. (Not everyone thinks numbers spell funny words...)
    You should only ever output 0, 1, or 2.
*/
import java.lang.StringBuilder;

public class CarMileage {

  public static int isInteresting(int number, int[] awesomePhrases) {
    if (number < 98) return 0;
    if (number < 100) return 1;
    if (checkIfIntresting(number, awesomePhrases)) return 2;
    if (checkIfIntresting(number+1, awesomePhrases)) return 1;
    if (checkIfIntresting(number+2, awesomePhrases)) return 1;
    return 0;
  }
  
  public static boolean checkIfIntresting (int number, int[] awesomePhrases){
    String num = Integer.toString(number);
    int lastDigit;
    System.out.println(number);
    //after first digit all zeros
    if (Integer.parseInt(num.substring(1)) == 0) return true;
    
    //all same digit
    lastDigit = Integer.parseInt(String.valueOf(num.charAt(0)));
    for (int i = 1; i < num.length(); i++){
      if (lastDigit != Integer.parseInt(String.valueOf(num.charAt(i)))) break;
      if (i == num.length() - 1) return true;
    }
    
    //incrementing
    if ("1234567890".contains(num)) return true;
    
    //decrementing
    if ("9876543210".contains(num)) return true;
    
    //palindrome
    StringBuilder reverseNum = new StringBuilder();
    reverseNum.append(String.valueOf(num));
    reverseNum.reverse();
    if (num.equals(reverseNum.toString())) return true;
    
    //matches awesomePhrases
    for (int i = 0; i < awesomePhrases.length; i++){
      if (number == awesomePhrases[i]) return true;
    }
    
    //at this point, number is not intresting
    return false;
  }
}