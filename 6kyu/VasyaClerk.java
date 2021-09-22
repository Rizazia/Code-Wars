/*
The new "Avengers" movie has just been released! There are a lot of people at the cinema box office standing in a huge line. Each of them has a single 100, 50 or 25 dollar bill. An "Avengers" ticket costs 25 dollars.

Vasya is currently working as a clerk. He wants to sell a ticket to every single person in this line.

Can Vasya sell a ticket to every person and give change if he initially has no money and sells the tickets strictly in the order people queue?

Return YES, if Vasya can sell a ticket to every person and give change with the bills he has at hand at that moment. Otherwise return NO.
 */
import java.util.HashMap;

public class Line {
  public static String Tickets(int[] peopleInLine) {
    HashMap<Integer, Integer> billsMap = new HashMap<>();
    billsMap.put(25, 0);
    billsMap.put(50, 0);
    billsMap.put(100, 0);
    
    for (int pay : peopleInLine){
      //take pay and add it to the map
      billsMap.replace(pay, billsMap.get(pay)+1);

      //make change, if I cant, return false
      int change = pay - 25;
      
      //if I need to make $75 and I have at least 1 $25 bill and 1 $50 bill
      if (change == 75 && (billsMap.get(50) >= 1 && billsMap.get(25) >= 1)){
        billsMap.replace(50, billsMap.get(50)-1); //remove a $50 bill
        billsMap.replace(25, billsMap.get(25)-1); //remove a $25 bill
        continue;
        //if I need to make $75 and I didnt have a 50 but have 3 &25 bills
      } else if (change == 75 && billsMap.get(25) >= 3){
        billsMap.replace(25, billsMap.get(25)-3);
        continue;
        //if I need to make $25 and I have at least 1 $25 bill
      } else if (change == 25 && billsMap.get(25) >= 1){
        billsMap.replace(25, billsMap.get(25)-1); //remove a $25 bill
        continue;
        //no change needed
      } else if (change == 0){
        continue;
      }
      //this executes only when change cannot be made
      return "NO"; 
    }

    return "YES";
  }
}