# from old.Functions import Func # Uncoment this line to use the Functions file instead
from DBFunc import DB

class Ask():
    dic = {}
    def start(self):
        self.func = DB() # Change DB() to Func() if you use Functions.py
        while True:
            op = self.getUserOption()
            if op == 6:
                break
            self.executeOption(op)

    def getUserOption(self):
        while True:
            try:
                op = int(input("""
What do you want to do:
[1] Add item
[2] Remove item
[3] Update amount in stock
[4] Show all items
[5] Search by name
[6] Exit
-> """))
                if (op >= 1 and op <= 6):
                    return op
                else:
                    print("You must choose from the previous op.")
            except:
                print("You must enter whole numbers.")

    def executeOption(self, op):
        match op:
            case 1: self.func.addItem() # Call method to add an item
            case 2: self.func.removeItems() # Call method to remove an item | Change removeItems() with removeItem()
            case 3: self.func.updateStock() # Call method to update stock quantity
            case 4: self.func.showAll() # Call method to show all items
            case 5: self.func.searchItem()  # Call method to search for an item