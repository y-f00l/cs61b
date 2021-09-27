# Summary

- This is a very easy project.But I have learned a little about test the program randomly
- The solution is map each method to a number.Then generate the number in [0,4) to choose the method.And use random to generate the data for add* method. Then use a StringBuilder to record called method by using `append()` method.
- Eg: when you call the `addLast()` method, the StringBuild shouldd append("addLast(").append(data).append("\n");
- When call remove* method.Use `!list.isEmpty()` method to ensure the list is not empty to avoid the NullPtrException.
