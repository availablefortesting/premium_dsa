class TextEditor:
    def __init__(self):
        self.text = ''
        self.cur_idx = 0

    def addText(self, text: str) -> None:
        self.text = self.text[: self.cur_idx] + text + self.text[self.cur_idx :]
        self.cur_idx += len(text)

    def deleteText(self, k: int) -> int:
        new_cursor = max(0, self.cur_idx - k)
        noOfChars = k if self.cur_idx - k >= 0 else self.cur_idx
        self.text = self.text[: new_cursor] + self.text[self.cur_idx :]
        self.cur_idx = new_cursor
        return noOfChars

    def cursorLeft(self, k: int) -> str:
        self.cur_idx = max(0, self.cur_idx - k)
        return self.text[max(0, self.cur_idx - 10) : self.cur_idx]
    
    def cursorRight(self, k: int) -> str:
        self.cur_idx = min(len(self.text), self.cur_idx + k)
        return self.text[max(0, self.cur_idx - 10) : self.cur_idx]


# Your TextEditor object will be instantiated and called as such:
# obj = TextEditor()
# obj.addText(text)
# param_2 = obj.deleteText(k)
# param_3 = obj.cursorLeft(k)
# param_4 = obj.cursorRight(k)