# Summary
## LinkedListDeque
- I didn't consider the situation which is the LinkList is empty when I implement the addFirst and addLast methods.So it is buggy.I can't pass the easy test
- Another is when I implement the removeFirst and removeLast, I forgot to consider the situation which is the LinkList will be empty aftert remove.So I can't pass the autograder.
- Fix these two bug I pass the autograder

## ArrayList
- I can't pass the performance test.This is so hard for me.I will consider it later.
- I don't shrink the memory when the R-factor(`used memory / total memory`) is less than 0.25.So I can't pass the autograder
