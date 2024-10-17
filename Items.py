class Item():
    def __init__(self, price: float = 0.0, quantity: int = 0, name: str = ""):
        self.price = price
        self.quantity = quantity
        self.name = name

    def __str__(self):
        return f"Name: {self.name} | Price: {self.price} | Quantity: {self.quantity}"

    def getPrice(self):
        return self.price

    def getQuantity(self):
        return self.quantity

    def getName(self):
        return self.name

    def getPriceAndQuantity(self):
        return (self.price, self.quantity)

    def setPrice(self, price):
        self.price = price

    def setQuantity(self, quantity):
        self.quantity = quantity

    def setName(self, name):
        self.name = name

    def setPriceAndQuantity(self, value: tuple = (0,0)):
        self.price = value[0]
        self.quantity = value[1]