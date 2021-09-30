/*
We want to generate all the numbers of three digits where:

    the sum of their digits is equal to 10.

    their digits are in increasing order (the numbers may have two or more equal contiguous digits)

The numbers that fulfill the two above constraints are: 118, 127, 136, 145, 226, 235, 244, 334

Make a function that receives two arguments:

    the sum of digits value

    the desired number of digits for the numbers

The function should output an array with three values: [1,2,3]

1 - the total number of possible numbers

2 - the minimum number

3 - the maximum number

The example given above should be:

HowManyNumbers.findAll(10, 3) == [8, 118, 334]   // as List<Integer>

If we have only one possible number as a solution, it should output a result like the one below:

HowManyNumbers.findAll(27, 3) == [1, 999, 999]

If there are no possible numbers, the function should output the empty array.

HowManyNumbers.findAll(84, 4) == []

The number of solutions climbs up when the number of digits increases.

HowManyNumbers.findAll(35, 6) == [123, 116999, 566666]

Features of the random tests:

    Number of tests: 112
    Sum of digits value between 20 and 65
    Amount of digits between 2 and 17
*/
import java.util.List;
import java.util.ArrayList;

public class HowManyNumbers {
  private static long count;
  private static long min;
  private static long max;

  public static List<Long> findAll(int sumDigits, int numDigits) {
    count = 0;
    min = 0;
    max = 0;

    recursiveSearch(0L, 1, sumDigits, numDigits);

    ArrayList<Long> result = new ArrayList<>();

    if (count > 0) {
      result.add(count);
      result.add(min);
      result.add(max);
    }

    return result;
  }

  private static void recursiveSearch(Long currNum, int prevDigit, int sumLeft, int digitsLeft) {
    if (sumLeft == 0 && digitsLeft == 0) {
      if (count == 0) min = currNum;
      min = min < currNum ? min : currNum;
      max = max > currNum ? max : currNum;
      count++;
    } else if (digitsLeft != 0) {
      for (int i = prevDigit; i < 10; i++) {
          recursiveSearch(10 * currNum + i, i,sumLeft - i, digitsLeft - 1);
      }
    }
  }
}