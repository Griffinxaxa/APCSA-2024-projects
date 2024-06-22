import java.util.ArrayList;
import java.util.Collections;

class ShoppingCart {
  private static final String[] FOODS = {"bananas", "bread", "cereal", "coffee", "eggs", "ice cream", "milk", "pasta", "peanut butter"};
  private static final double[] PRICES = {3.59, 1.19, 4.99, 9.79, 2.99, 5.99, 2.49, 1.69, 2.79};
  
  private ArrayList<String> items;
  private double total;
  
  ShoppingCart() { //instance variables of shoppingCart
    items = new ArrayList<String>();
    double total = 0.0;
    // the total price value
  }

  // Uses binary search to Look up the price of `item` in the array of prices.
  //
  // Returns -1 if the item cannot be found.
  private double getPrice(String item) {
    int start = 0;
    int end = FOODS.length - 1;

    while(start <= end) // the binary search algorithm to find the price of the item
      {
        int mid = (start + end) / 2;
        
        int result = item.compareToIgnoreCase(FOODS[mid]);

        if(result < 0)
        {
          end = mid -1;
        }
        else if (result > 0)
        {
          start = mid +1;
        }
        else
        {
          return PRICES[mid];
        }
      }
    return -1;
  }

  // method to Add the item to the cart.
  //
  // Returns true if the item was added successfully, and
  // false otherwise.
  public boolean addItem(String item) {
    for(int i = 0; i < FOODS.length; i++)
    {
      if(FOODS[i].equalsIgnoreCase(item))
      {
        items.add(item);
        total += PRICES[i];
        return true;
      }
    }
    return false;
  }

  // method to Remove the item from the cart.
  //
  // Returns true if the item was removed successfully, and
  // false otherwise.
  public boolean removeItem(String item) {
    for(int i = 0; i < FOODS.length; i++)
      {
        if(items.get(i).equalsIgnoreCase(item)) //revised on 5/16
        {
          items.remove(item);
          total -= PRICES[i];
          return true;
        }
      }
    return false;
  }
//method to sort the printed items by alphabetical order
  private void sortItems(ArrayList<String> items) {
    int n = items.size();
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n -i - 1; j++) {
      if (items.get(j).compareToIgnoreCase(items.get(j + 1)) > 0) {
        String temp = items.get(j);
        items.set(j, items.get(j + 1));
        items.set(j + 1, temp);
      }
    }
  }
  }

  // method to Print a formatted receipt from the shopping cart,
  // with each item and price on its own line and a total
  // at the end.
  
  public void printReceipt() {
    System.out.println("Thanks for shopping! heres your receipt");
    System.out.println("==========================");

    sortItems(items);
    //call the sortitems method to sort alphabetically.
    
    boolean[] printedItems = new boolean[items.size()];

    for(int i = 0; i < items.size(); i++) 
      //iterating through items in the cart
      {
        if(items.get(i) != null && !printedItems[i]) 
          //check its the item is not null and it isnt already printed
        {
          String current = items.get(i);
          int amount = 1;
          double price = getPrice(current);

          for(int j = i + 1; j < items.size(); j++) 
            //loop to consolidate multiple purchases of the same item
            {
              if(items.get(j).equals(current) && !printedItems[j])
              {
                amount++;
                //increment if duplicate found
                printedItems[j] = true; 
                //mark the item as printed
              }
            }
          // Multiple purchases of the same item are consolidated
          // into a single line on the receipt, with the quantity
          // and total price of the item listed
          System.out.println(amount + " " + current + "(s) - $ "+ (price * amount));
        }
      }
      System.out.println("==========================");
      System.out.println("total : $" + total);
  }
}
