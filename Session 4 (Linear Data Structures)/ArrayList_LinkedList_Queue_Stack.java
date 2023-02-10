import java.util.*;

public class ArrayList_LinkedList_Queue_Stack {
    public static void main(String[] args) {
        //______________________________________________________ ArrayList _________________________________________________________________

        // Initializing an arrayList
        ArrayList<Integer>arrayList=new ArrayList<>();

        arrayList.add(2);  // .add(x) O(1)
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(2);

        System.out.println("arrayList: "+arrayList); // this will print --> [2,3,4,2]
        System.out.println("size of the arrayList: "+arrayList.size()); //.size() O(1)  this will print 4

        // To get the first appearance of an object x in an ArrayList we use .indexOf(x) O(N)
        System.out.println("first occurrence of 2: "+arrayList.indexOf(2));// this will print 0

        // To get the last appearance of an object x in an ArrayList we use .indexOf(x) O(N)
        System.out.println("last occurrence of 2: "+arrayList.lastIndexOf(2));// this will print 3

        // To delete an object at a specific index we use .remove(i) O(N)
        arrayList.remove(0);
        System.out.println("arrayList after removing object at index 0: "+arrayList); // this will print [3,4,2]

        // To add an object at a certain index we use .add(i,x)   O(N)
        arrayList.add(1,10);
        System.out.println("arrayList after adding 10 in index 1: "+arrayList); // this will print [3,10,4,2]

        Collections.sort(arrayList); // Just like Arrays.sort() with complexity O(N*logN)

        for (Integer integer : arrayList) { // this will print "  2 3 4 10 " as we sorted the arrayList in the previous step
            // To get an object at a certain index we use .get(i) O(1)
            System.out.print(integer + " ");
        }
        System.out.println();

        //______________________________________________________ LinkedList____________________________________________________________________

        //Initializing LinkedList
        LinkedList<Integer>linkedList = new LinkedList<>();

        // To add an element to the end or the beginning of a linkedList O(1)
        linkedList.add(2); // adds at the end of the linkedList  --> [2]
        linkedList.addLast(3); // adds at the end of the linkedList --> [2,3]
        linkedList.addFirst(5); // adds at the beginning of the linkedList -->[5,2,3]
        linkedList.add(10); // --> [5,2,3,10]

        System.out.println("The size of the linkedList "+linkedList.size()); // this will print 4  O(1)

        // To add an element at a specific index O(N)
        linkedList.add(2,100); // --> [5,2,100,3,10]

        System.out.println("The linkedList: "+linkedList); // this will print [5,2,100,3,10]

        //To remove an element from the end or the beginning of a linkedList O(1)
        linkedList.remove(); // removes the element at the head of the linkedList --> [2,100,3,10]
        linkedList.removeFirst(); // removes the element at the head of the linkedList --> [100,3,10]
        linkedList.removeLast(); // removed the element at the end of the linkedList --> [100,3]

        linkedList.add(11); // --> [100,3,11]
        linkedList.addFirst(1); // --> [1,100,3,11]

        // To remove an element at a certain index O(N)
        linkedList.remove(0); //-->[100,3,11]

        // To change the value af an element at a certain index we use .set(i,x) O(N)
        linkedList.set(1,5); // --> [100,5,11]

        System.out.println("The final linkedList: "+ linkedList);

        //______________________________________________________ QUEUE ____________________________________________________________________

        // Initializing a queue
        Queue<Integer> queue =new LinkedList<>(); //FIFO data structure first in first out!

        // To add an element in a queue we use .add(x)   O(1)
                      //      |<-- beginning of our queue
        queue.add(1); // --> [1]
                      //      |<-- beginning of our queue
        queue.add(2); // --> [1,2]
                      //      |<-- beginning of our queue
        queue.add(3); // --> [1,2,3]
                      //      |<-- beginning of our queue
        queue.add(7); // --> [1,2,3,7]

        // to get the size of the queue we use .size()  O(1)
        System.out.println("The size of the queue: "+queue.size()); // this will print 4

        //To check if the queue is empty or not we use .isEmpty() O(1)
        System.out.println(queue.isEmpty()); // this will print false as we added elements in the queue

        //To remove the element at the front of the queue we use .poll() or .remove()  O(1)
        queue.remove(); // --> [2,3,7]
        queue.poll(); // --> [3,7]

        // To see the value of the front element without removing it we use .peek() O(1)
        System.out.println("The element at the front of the queue now is: "+queue.peek()); // this will print 3

        // To remove an element from the queue we use .remove(x)   O(N)
        queue.remove(3); // --> [3]

        //To iterate over the queue:
        while(!queue.isEmpty()) {
            System.out.print(queue.poll()+" ");
        }

        //______________________________________________________ Stack _________________________________________________________________

        // Initializing a Stack
        Stack<Integer>stack= new Stack<>(); //LIFO data structure last in first out!

        // To add an element in a queue we use .push(x)/.add(x)   O(1)
                           //       |<---- Top of our stack
        stack.push(1); // --> [1]
                            //  |<---- Top of our stack
        stack.add(2); // --> [1,2]
                            //          |<---- Top of our stack
        stack.push(3); // --> [1,2,3]
                            //            |<---- Top of our stack
        stack.push(7); // --> [1,2,3,7]
                             //              |<---- Top of our stack
        stack.push(10); // -->[1,2,3,7,10]

        // to get the size of the stack we use .size()  O(1)
        System.out.println("The size of the stack: "+stack.size()); // this will print 5

        //To check if the stack is empty or not we use .isEmpty() O(1)
        System.out.println(stack.isEmpty()); // this will print false as we added elements in the stack

        //To remove the element at the top of the stack we use .pop() O(1)
        stack.pop(); // --> [1,2,3,7]

        // To see the value of the front element without removing it we use .peek() O(1)
        System.out.println("The element at the top of the stack now is: "+stack.peek()); // this will print 7

        // To remove an element at a certain in index from the stack we use .remove(i)  O(N)
        stack.remove(1); // -->[1,3,7]

        //To iterate over the stack:
        while(!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
    }
}