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
  
## Arrays:
   - **1D Array** : 
      - Stored in contigious memory location.
        <img src="https://github.com/eshita19/dsalgo/blob/master/src/main/resources/Screenshot%202020-01-11%20at%202.52.38%20PM.png">
        
   - **2D Array**:
     - https://github.com/eshita19/dsalgo/blob/master/src/main/java/com/esh/array/TwoDArray.java
     - Ex:  a[row][col]
     ``` 
        int a[][]= [{1,2,3},  // Row1   
                   {4,5,6},   //Row2
                   {7,8,9}]   //Row3
         ```          
         
## Linked List: 
   - Linear datastructure.
   - Each element contains its own value and a link to the next element.
   - Variable in size(linked list), Random access(Array), Element separate objects(linked list).
   - <img src="https://github.com/eshita19/dsalgo/blob/master/src/main/resources/Screenshot%202020-01-11%20at%203.40.44%20PM.png">
   - Types of linked list:
     - Singly linked list
     - Circular Single linked list
     - Doubly linked list
     - Circular Double linked list

## Stack
  - Last in first out.
  - insertFirst(), deleteFirst()
## Queue
   - First in first out.
   - insertEnd(), deleteFirst()
   - **Circular Queue using array**:
     - We resuse the deleted element space.
     - Maintain two pointers front - pointing to the first element, rear - pointing to the last element.
     - front = (front + 1) % size.
  
## Tree
   - Used to represent data in hierarchical form.
   - Every node has two compoenent, its data and reference to child nodes.
   - Terminologies:
      - Root: Node with no parent.
      - Edge: Link from parent to child.
      - Leaf: Node with no children.
      - Sibling: Children of same parent.
      - Ancestor: parent, grand parent, great grand parent etc.
      - Depth of node: Length of the path from root to node.
      - Height of node: Length of the path from node to the deepest node.
      - Height of tree: Same ass height of root node.
      - Depth of tree: Same as depth of root node, i.e 0.
      - Predecessor:Previous node in Inorder traversal(Left sibiling, node, right sibling)
      - Sucessor: Next node in Inorder traversal.
   - **Binary Tree**: A tree is called binary tree if it has zero, one or two child.(At the most 2).
      - Strict Binary tree: If each node has either zero or two children.
      - Full Binary tree: Non leaf node has 2 children and all Leaf nodes are on same level.
      - Complete Binary tree: If all levels are completely filled except possibly the last level and the last level has all key as left as possible.
      - Search in Binary tree:
        - Depth First Search: O(n)
          - PreOrder traversal - Root, Left subtree, Right subtree.
            ```
            PreOrder(Node root):
            if(root ==null){
               return;
            }
            Print root
            PreOrder(root.left)
            PreOrder(root.right)
            ```
          - InOrder trversal - Left subtree, root, Right subtree.
          - PostOrder traversal - Left subtree, right subtree, root
       - Breadth First search: O(n)
         - Level order traversal - Traverse from level 0 to last last level from left to right.
           ```
           LevelOrderTraversal(root):
           if(root ==null){
              return;
           }
           Create queue
           enqueue(root)
           while(front.elem != null){
               enqueue front elem's childs
               dequeue front element and print
           }       
           ```
      - Insertion of node in Binary Tree: O(n)
         ```
         insertNode(Node root):
         if(root == null){
            //Insert
         }else{
            //do level order traversal to find first empty space.
            //Insert element.
         }
         
         ```
     - Deletion of node in Binary tree: O(n)
       ```
       deleteNode(int elem):
         Search for node to be deleted.
         find deepest node in the tree, by using level order traversal.
         Copy deepest node data to node to be deleted. 
         delete deepest node.
       ```
      
        
           
         
         
      

     
     
   
   
  
      
