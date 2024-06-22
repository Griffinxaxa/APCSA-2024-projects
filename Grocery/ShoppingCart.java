class ShoppingCart {
  static final String[] FOODS = {"pasta", "cereal", "eggs", "bread", "bananas", "coffee", "milk", "peanut butter", "ice cream"};
  static final double[] PRICES = {1.69, 4.99, 2.99, 3.59, 1.19, 9.79, 2.49, 2.79, 5.99};
  
  String[] items;
  int[] quantities;
  double total;
  int itemCount;
  
  ShoppingCart(int numItems) {
      items = new String[numItems];
      //initialize the qunatities array to measure 
      quantities = new int[numItems];
      total = 0.0;
      itemCount = 0;
  }

  

  private double getPrice(String item) {
    for (int i = 0; i < FOODS.length; i++) {
        // Looks up the price of `item` in the array of prices.
        if (FOODS[i].toLowerCase().equals(item.toLowerCase())) {
            return PRICES[i];
        }
    }
        // Returns -1 if the item cannot be found.
    return -1;
  }

  
  public boolean addItem(String item, int index) {
      double price = getPrice(item);
      if(price != -1) {
          for(int i = 0; i < itemCount; i++) {
              if(items[i].equalsIgnoreCase(item)) {
              quantities[i]++;
              total+=price;
              return true;
          }
      }
      // Adds the item to the cart at the specified index.
      items[itemCount] = item;
      quantities[itemCount] = 1;
      total += price;
      itemCount++;
          // Returns true if the item was added successfully, and
          // false otherwise.
      return true;
      }
    return false;
  }

  // Prints a formatted receipt from the shopping cart,
  // with each item and price on its own line and a total
  // at the end.
  // Once you have completed everything else, have your
  // printReceipt method consolidate duplicate items on
  // the receipt.
  public void printReceipt() {
      System.out.println("Thanks for shopping! heres your receipt");
      System.out.println("==========================");
      for(int i = 0; i < itemCount; i++) {
          System.out.print(items[i]);
          System.out.print(" $");
          System.out.print(getPrice(items[i]));
          System.out.print(" x ");
          System.out.println(quantities[i]);
          }
      System.out.println("==========================");
      System.out.print("total : $" + total);
      System.out.println(total);
      }
  }
