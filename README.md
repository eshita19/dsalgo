# dsalgo

## Recursion:
   - Recursive Case:  The case where function recur.
   - Base case: Case where function does not recur.
   - ```
      SampleRecursion(args){
        if(base case satisfied)
            return some base case value
        Samplerecursion(some modified args)    
      
      }
      
      ```
   - Method calls are stored in memory stack(LIFO - last in first out) manner. 
   - Pros: Ease of code, Cons: Not space and time efficient(Use of Stack memory, push, pop operation and maintaining pointers).
   - Use of recursion: Stack, Tree, Sorting(Quick sort, merge sort).
