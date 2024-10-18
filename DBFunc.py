import logging
import sqlite3

class DB():
    def __init__(self):
        logging.basicConfig(filename="logFile.log", filemode='a' ,level=logging.DEBUG)
        self.con = sqlite3.connect("products.db")
        self.createTable()

    # Crates the table
    def createTable(self):
        cur = self.con.cursor()
        cur.execute("""
create table if not exists management(
	id integer primary key autoincrement not null,
    name char(30) not null unique,
    price double(10, 2) not null,
    quantity int(10) not null
)""")
        cur.close()
        logging.info("TABLE CREATED")
        
    def addItem(self):
        cur = self.con.cursor()
        
        # Get all the values to insert
        _name = input("\nEnter the product name: ")
        _price = DB.getPrice() # Get the _price of the product
        _quantity = DB.getQuantity() # Get the _quantity of the product

        try:
            cur.execute("""
INSERT OR IGNORE INTO management (name, price, quantity)
VALUES (?, ?, ?)
    """, (_name, _price, _quantity))
            row_affected = cur.rowcount
            self.con.commit()
            if row_affected == 0:
                print("The entered product does already exist\n")
                logging.info("User tried to add a product that already exist")
            else:
                print(f"Prodct with name {_name} was added successfuly\nPRODUCT: {_name} | PRICE: {_price}€ | QUANTITY: {_quantity}\n")
                logging.info(f"User added product {_name}\nPRODUCT: {_name} | PRICE: {_price}$ | QUANTITY: {_quantity}")
        except Exception as e:
            print(f"There was an error: \n{e}\n")
            logging.error(f"There was an error: \n{e}")

        cur.close()
    
    # Remove item
    def removeItems(self):
        cur = self.con.cursor()

        _name = input("Enter the product to remove: ")

        try:
            # Save old quantity
            cur.execute("SELECT * FROM management WHERE name=?", _name)
            row = cur.fetchone()
            _idO = row[0]
            _priceO = row[2]
            _quantityO = row[3]
        except:
            print("The entered product does not exist\n")
            logging.info("User tried to remove a product that doesn't exist")
            return

        cur.execute("DELETE FROM management WHERE name=?", _name)
        self.con.commit()
        
        print(f"Prodct with name {_name} was removed successfuly\n")
        logging.info(f"User removed product {_name}\nID: {_idO} | PRICE: {_priceO} | QUANTITY: {_quantityO}")

    # Update stock
    def updateStock(self):
        cur = self.con.cursor()

        _name = input("Enter the name of the product to update: ")
        _quantity = DB.getQuantity()
        try:
            # Save old quantity
            cur.execute("SELECT * FROM management WHERE name=?", (_name,))
            row = cur.fetchone()

            # Verifica si el producto existe
            if row is None:
                print("The entered product could not be found")
                logging.info("User searched for a non-existing product")
                return  # Salir de la función si no se encontró el producto

            _quantityO = row[3]  # Cantidad antigua

            # Update
            cur.execute("UPDATE management SET quantity=? WHERE name=?", (_quantity, _name))
            self.con.commit()  # No olvides hacer commit para guardar cambios

            # Obtener la fila actualizada
            cur.execute("SELECT * FROM management WHERE name=?", (_name,))
            row = cur.fetchone()

            # Return info to user
            print(f"Product {_name} updated successfully\nID: {row[0]}, Name: {row[1]}, Price: {row[2]}, Quantity: {row[3]}")
            logging.info(f"User updated product {_name} stock from {_quantityO} to {row[3]}")
        except Exception as e:
            print("An error occurred while updating the product.")
            logging.error(f"Error updating product: {e}")


    # Show all items
    def showAll(self):
        print("\nShowing all...")
        cur = self.con.cursor()
        cur.execute("SELECT * FROM management")
        rows = cur.fetchall()

        for row in rows:
            print(f"ID: {row[0]}, Name: {row[1]}, Price: {row[2]}, Quantity: {row[3]}")
        logging.info("User searched for all items")

    # Search for specific item by name
    def searchItem(self):
        cur = self.con.cursor()

        _name = input("Enter the product to find: ")
        
        try:
            cur.execute("SELECT * FROM management WHERE name=?", _name)
            row = cur.fetchone()

            print(f"ID: {row[0]}, Name: {row[1]}, Price: {row[2]}, Quantity: {row[3]}")
            logging.info(f"User searched for {_name}\nID: {row[0]}, Name: {row[1]}, Price: {row[2]}, Quantity: {row[3]}")
        except:
            print("The entered product could not be found")
            logging.info("User searched for a non-existing product")
            

    # -------↓↓↓------- DON'T TOUCH -------↓↓↓-------

    # Gets the item's _price from user input
    def getPrice():
        while True:
            try:
                _price = float(input("Enter the product price: ")) # Read the _price input
                break # Exit the loop if input is valid
            except :
                # Display an error message if input is invalid
                print("You can only enter whole numbers or decimals separated by a point.")

        return _price # Return the valid _price
    

    # Gets the _quantity of Item from user input
    def getQuantity():
        while True:
            try:
                _quantity = int(input("Enter the product quantity: ")) # Read the _quantity input
                break # Exit the loop if input is valid
            except :
                # Display an error message if input is invalid
                print("You can only enter whole numbers.")

        return _quantity # Return the valid _quantity