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
   - Use of recursion: Stack, Tree, Sorting(Quick sort, merge sort), divide and conquor.

## Algo Runtime analysis:
   - Omega notation - minimum time taken by algo(Best case)
   - Big o notation - maximum time taken by algo(Worst case)
   - Theta notation - Average case
   - Predefined complexities:
      - O(1) - Constant - Adding an element in front of linked list.
      - O(log n) - Logarithmic - Finding an element in sorted array.
      - O(n) - linear - Finding an element in unsorted array.
      - O(nlogn) - Linear logarithmic - Merge sort
      - O(n2) - Quadratic - Shortest path between two nodes.
      - O(n3) - Cubic - Matrix multiplication
      - O(2n) - Exponential - Tower of hanoi
      
