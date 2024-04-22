class ATM:

    def __init__(self):
        self.notes = [0] * 5
        self.denominations = [20,50,100,200,500]

    def deposit(self, banknotesCount: List[int]) -> None:
        for i, addedNote in enumerate(banknotesCount): 
            self.notes[i] += addedNote

    def withdraw(self, amount: int) -> List[int]:
        used = [0] * 5
        for i in range(4, -1, -1):
            if not self.notes[i]:   continue
            while self.notes[i] - used[i] > 0 and amount >= self.denominations[i]:
                cur = min(self.notes[i], amount // self.denominations[i])
                amount -= cur * self.denominations[i]
                used[i] += cur
           
            if amount == 0:
                for i in range(5):
                    self.notes[i] -= used[i]
                return used
            
        return [-1]