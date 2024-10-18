from Items import Item

class Func():
    def __init__(self):
        from UserAsk import Ask
        self.ask = Ask()
        self.item = Item()

    def addItem(self):
        name = input("\nEnter the product name: ") # Read the product name

        price = Func.getPrice() # Get the price of the product
        quantity = Func.getQuantity() # Get the quantity of the product

        self.item = Item(price, quantity, name) # Create a new item object

        # Check if the product name already exists in the dictionary.
        if ():
            print("A product with that name already exists.") # Inform the user if the product exists
        else:
            self.ask.dic[name] =  self.item.getPriceAndQuantity() # Add the item to the dictionary.
        

        # Display the details of the added item
        print(f""" 
Added
  - Product: {name}
  - Price: {self.item.getPrice()}$
  - Quantity: {self.item.getQuantity()}
""")
    

    # Removes Item from the dictionary.
    def removeItem(self):
        name = input("Enter the product name: ") # Read the product name

        # Check if the product name exists in the dictionary.
        if (name in self.ask.dic.keys()):
            self.ask.dic.pop(name) # Remove the item from the dictionary.
            print(f"\nProduct: {name} was removed successfully.\n") # Confirm removal
        else:
            # Display an error message if the product does not exist
            print("""
------------- ERROR -------------
The entered product does not exist.
""")

    # Updates the stock of Item
    def updateStock(self):
        name = input("Enter the name of the product to update: ") # Read the product name

        if name in self.ask.dic.keys():
            self.item.setPriceAndQuantity(self.ask.dic[name]) # Retrieve the item from the dictionary.

            # Display the current values of the item
            print(f"\nIts current quantity is: {self.item.getQuantity()}")
        else:
            # Display an error message if the product is not found
            print(f""" 
------------ ERROR ------------
The product {name} was not found
""")
            return # Exit the method
        

        self.changeQuantity(name) # Call method to change the quantity
    

    # Changes the quantity of an existing item
    def changeQuantity(self, name):
        quantity = Func.getQuantity() # Get the new quantity from user input

        self.item.setQuantity(quantity) # Update the item's quantity

        self.ask.dic[name] = self.item.getPriceAndQuantity() # Put the updated item back in the dictionary.
    

    # Shows all Item in the dictionary.
    def showAll(self):
        # Iterate over all keys in the dictionary.
        for key in self.ask.dic.keys():
            self.item.setPriceAndQuantity(self.ask.dic[key]) # Retrieve the item
            # Display the details of each item
            print(f"""
Product: {key}
  - Price: {self.item.getPrice()}$
  - Quantity: {self.item.getQuantity()}
""")
        

    # Searches for an item by name
    def searchItem(self):
        product = input("Enter the product name: ") # Read the product name

        if product in self.ask.dic:
            self.item.setPriceAndQuantity(self.ask.dic[product]) # Retrieve the item from the dictionary.
            # Display the details of the found item
            print(f""" 
Product: {product}
  - Price: {self.item.getPrice()}$
  - Quantity: {self.item.getQuantity()}
""")
        else:
            # Display an error message if the product cannot be found
            print(f"The product {product} cannot be found")
        

    # -------↓↓↓------- DON'T TOUCH -------↓↓↓-------

    # Gets the item's price from user input
    def getPrice():
        while True:
            try:
                price = float(input("Enter the product price: ")) # Read the price input
                break # Exit the loop if input is valid
            except :
                # Display an error message if input is invalid
                print("You can only enter whole numbers or decimals separated by a point.")

        return price # Return the valid price
    

    # Gets the quantity of Item from user input
    def getQuantity():
        while True:
            try:
                quantity = int(input("Enter the product quantity: ")) # Read the quantity input
                break # Exit the loop if input is valid
            except :
                # Display an error message if input is invalid
                print("You can only enter whole numbers.")

        return quantity # Return the valid quantity
    