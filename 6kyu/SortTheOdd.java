/*
You will be given an array of numbers. You have to sort the odd numbers in ascending order while leaving the even numbers at their original positions.
Examples

[7, 1]  =>  [1, 7]
[5, 8, 6, 3, 4]  =>  [3, 8, 6, 5, 4]
[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]  =>  [1, 8, 3, 6, 5, 4, 7, 2, 9, 0]
*/
public class Kata {
  public static int[] sortArray(int[] array) {
    //selection sort with added conditionals that ensure only odd numbers are being looked at
    for (int i = 0; i < array.length; i++){
      if (array[i] % 2 == 0) continue; // if current i index is even, go to next iteration of the loop
        int smallest = i;

        for (int j = i; j < array.length; j++){
          if (array[j] % 2 == 1 && array[j] < array[smallest]){ //if the current j index is odd and < the smallest odd number found
            smallest = j;
          }
        }

      //swap the odd number with the smallest one found in the previous steps
      int temp = array[smallest];
      array[smallest] = array[i];
      array[i] = temp;
    }
    
    return array;
  }
}