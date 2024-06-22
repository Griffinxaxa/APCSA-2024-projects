//GRADE: 95.5/100
import java.util.Scanner;

class Main {
  public static void main(String[] args) { 
    // Create a new shopping cart and scanner for user input.
    Scanner scan = new Scanner(System.in);
    ShoppingCart Cart = new ShoppingCart();
    System.out.println("Welcome, what would you like to buy today");
    String userInput = scan.nextLine();
    //changed it so that the condition to break the while look is inside the while loop paramted (5/17/24)
    while(!userInput.equalsIgnoreCase("done"))
      {
        // Ask in a loop what the user would like to do,
        // and add/remove items from the cart as requested
        // until the user is done
        // Welcome the user to the grocery store and explain
        // the commands they can use to shop: "add", "remove",
        // and "done" when they're finished.
        System.out.println("What do you want to do now, you can \"add\" or \"remove\" an item, after the keyword name the food you would like to add, when you are done you may write \"done\" ");
        
          if(userInput.startsWith("add ")) 
            //use the startsWith method of the string class to check if they are adding 
          {
            String item = userInput.substring(4); 
            //tries to add the remainder of their input to the cart 
            if(Cart.addItem(item))
            {
              System.out.println(item + " added to cart");
            } else {
              System.out.println("We dont have that");
            }
          } else if(userInput.startsWith("remove")) 
            //use the startsWith method of the string class to check if they are removing 
          {
            String item = userInput.substring(7); 
            //tries to remove the remainder of their input to the cart 
            if(Cart.removeItem(item))
            {
              System.out.println(item + " removed from cart");
            } else {
              System.out.println(item + " is not in your cart");
            }
          }
        else //error handling in case they dont say a valid command
          {
            System.out.println("not a valid command");
          }
        userInput = scan.nextLine();
        }
    // Once they've finished shopping, give the user
    // their receipt.
    Cart.printReceipt();
  }
}
