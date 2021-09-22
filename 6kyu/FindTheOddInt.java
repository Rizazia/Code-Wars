/*
Given an array of integers, find the one that appears an odd number of times.

There will always be only one integer that appears an odd number of times.
Examples

[7] should return 7, because it occurs 1 time (which is odd).
[0] should return 0, because it occurs 1 time (which is odd).
[1,1,2] should return 2, because it occurs 1 time (which is odd).
[0,1,0,1,0] should return 0, because it occurs 3 times (which is odd).
[1,2,2,3,3,3,4,3,3,3,2,2,1] should return 4, because it appears 1 time (which is odd).
*/

import java.util.Arrays;
public class FindOdd {
  public static int findIt(int[] a) {
    Arrays.sort(a);
    int curr = a[0], count = 0;
    
    for (int i = 0; i < a.length; i++){
      //if this is the last index, the value of the last index must be the correct answer
      //otehrwise, return curr; would have occured by now
      if (i == a.length-1) return a[a.length-1];
      //if a[i] is not curr, see if count is odd and if so return curr
      if (a[i] != curr && count % 2 == 1) return curr;
      //else make curr equal the value of index i and reset count
      else if (a[i] != curr) {
        curr = a[i];
        count = 0;
      }
      //otherwise a[i] matches curr so increment count
      count++;
    }
    
    //default return statement
    return a[0];
  }
}