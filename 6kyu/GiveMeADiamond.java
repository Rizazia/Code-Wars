/*
Jamie is a programmer, and James' girlfriend. She likes diamonds, and wants a diamond string from James. Since James doesn't know how to make this happen, he needs your help.
Task

You need to return a string that looks like a diamond shape when printed on the screen, using asterisk (*) characters. Trailing spaces should be removed, and every line must be terminated with a newline character (\n).

Return null/nil/None/... if the input is an even number or negative, as it is not possible to print a diamond of even or negative size.
Examples

A size 3 diamond:

 *
***
 *

...which would appear as a string of " *\n***\n *\n"

A size 5 diamond:

  *
 ***
*****
 ***
  *

...that is:

"  *\n ***\n*****\n ***\n  *\n"
*/

import java.lang.StringBuilder;
import java.util.ArrayList;
class Diamond {
  public static String print(int n) {
    if (n < 1 || n % 2 == 0) return null;
    int odd = 1, nos = n/2;
    String s = "";
    for (int i = 1; i <= n; i++) { // for number of rows i.e n rows
            for (int k = nos; k >= 1; k--) { // for number of spaces i.e
                                                // 3,2,1,0,1,2,3 and so on
                s = s + " ";
            }
            for (int j = 1; j <= odd; j++) { // for number of columns i.e
                                                // 1,3,5,7,5,3,1
                s = s + "*";
            }
            s = s + "\n";
      
            if (i < n/2+1) {
                odd += 2; // columns increasing till center row 
                nos -= 1; // spaces decreasing till center row 
            } else {
                odd -= 2; // columns decreasing
                nos += 1; // spaces increasing

            }
        }
    return s;
    
  }
}