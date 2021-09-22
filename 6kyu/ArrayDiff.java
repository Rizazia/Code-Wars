/*
Your goal in this kata is to implement a difference function, which subtracts one list from another and returns the result.

It should remove all values from list a, which are present in list b keeping their order.

Kata.arrayDiff(new int[] {1, 2}, new int[] {1}) => new int[] {2}

If a value is present in b, all of its occurrences must be removed from the other:

Kata.arrayDiff(new int[] {1, 2, 2, 2, 3}, new int[] {2}) => new int[] {1, 3}
*/

public class Kata {

  public static int[] arrayDiff(int[] a, int[] b) {
    
    for (int i = 0; i < a.length; i++){
      for(int j = 0; j < b.length; j++){
        //if element exists in both arrays
        //remove the element
        //decrement i (because the size of a is now 1 less and we dont want to skip the new i index)
        //break the loop on b
        if (a[i] == b[j]){
          a = removeElement(a, i);
          i--;
          break;
        }
      }
    }
    return a;
  }

  
  
  public static int[] removeElement(int[] arr, int index){
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }
    
        int[] newArr = new int[arr.length - 1];
    
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            newArr[k++] = arr[i];
        }
        return newArr;
    }
}