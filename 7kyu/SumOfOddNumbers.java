/*
Given the triangle of consecutive odd numbers:

             1
          3     5
       7     9    11
   13    15    17    19
21    23    25    27    29
...

Calculate the sum of the numbers in the nth row of this triangle (starting at index 1) e.g.: (Input --> Output)

1 -->  1
2 --> 3 + 5 = 8
*/

import java.util.ArrayList;

class RowSumOddNumbers {
    public static int rowSumOddNumbers(int n) {
      ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
      int num = 1;
      
      //create the triangle structure
      for (int i = 0; i < n; i++){ //to make the triangle with n rows
        ArrayList<Integer> row = new ArrayList<>();
        for (int j = 0; j <= triangle.size(); j++){ //to make the individual rows
          row.add(num);
          num += 2;
        }
        triangle.add(row);
      }
      
      int sum = 0;
      for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++){ //add the values of the last row
        sum += triangle.get(triangle.size()-1).get(i);
      } 
      return sum;
    }
}