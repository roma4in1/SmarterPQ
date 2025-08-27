// -----------------------------------------------------
// Assignment 3
// Written by: Romain Corbel 40257534
// -----------------------------------------------------
/**
 * Romain Corbel 40257534
 * COMP352
 * Assignment #3
 */
public class Main {
    public static void main(String[] args) {
        SmarterPQ pq = new SmarterPQ();
        //INSERTION
        pq.insert(3, 0);
        pq.insert(2, 1);
        pq.insert(15, 2);
        pq.insert(5, 3);
        pq.insert(4, 4);
        pq.insert(45, 5);
        //Toggling
        pq.toggle();
        System.out.println("State after toggling: " + pq.state());
        //REMOVAL OF TOP
        System.out.println("Remove top: " + pq.removeTop());

        //GETTING TOP
        System.out.println("Top element: " + pq.top());

        //REPLACING KEY
        pq.replaceKey(2, 1);

        //REPLACING VALUE
        pq.replaceValue(5, 6);

        //REMOVING SPECIFIC ENTRY
        pq.remove(15);

        //CHECKING IF EMPTY
        System.out.println("Is empty: " + pq.isEmpty());

        //GETTING SIZE
        System.out.println("Size: " + pq.size());

        //INSERTING MORE ELEMENTS
        pq.insert(19,15);
        pq.insert(8, 7);
        pq.insert(7, 8);

        //REMOVAL OF TOP
        pq.removeTop();

        //GETTING TOP
        System.out.println("Top element: " + pq.top());

        //TOGGLING
        pq.toggle();
        System.out.println("State after toggling: " + pq.state());

        //REMOVING SPECIFIC ENTRY
        pq.remove(8);

        //CHECKING IF EMPTY
        System.out.println("Is empty: " + pq.isEmpty());

        //GETTING SIZE
        System.out.println("Size: " + pq.size());

    }
}