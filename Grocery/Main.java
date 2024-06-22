GRADE:91/100
import java.util.Scanner;

class Main {
  public static void main(String[] args) {  
    // Ask the user how many items they'd like to
      System.out.println("how many things are we buying today");
      Scanner scan = new Scanner(System.in);
      int numberOfPurchases = scan.nextInt();
    // and create a shopping cart with enough size to
      ShoppingCart cart = new ShoppingCart(numberOfPurchases);
    // hold that many items.
      System.out.println("this is what all we ahve : pasta, cereal, eggs, bread, bananas, coffee, milk, peanut butter, ice cream");

      int counter = 0;
    
      while(numberOfPurchases > counter){
      
          // Ask in a loop what the user would like to buy,
          // and add each item to the shopping cart.
          System.out.println("What are we buying now? " + "(" + (counter + 1) + "/" + numberOfPurchases + ")");
          counter++;
          Scanner inputPurchase = new Scanner(System.in);
          String food = inputPurchase.next();
          if(!cart.addItem(food, counter-1)) {
              System.out.println("we dont have that");
              counter--;
          }
        
      }
      // Once they've finished shopping, give the user
      // their receipt.
      cart.printReceipt();

  }
}
