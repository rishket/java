// Assignment #: 10
//         Name: Soln
//    StudentID:
//  Lab Lecture:
//      Section:
//  Description: The LinkedList defines a linked list using its node class
//  object and also defines a iterator class to traverse the linked list.


import java.util.NoSuchElementException;

/**
   A linked list is a sequence of nodes with efficient
   element insertion and removal. This class
   contains a subset of the methods of the standard
   java.util.LinkedList class.
*/
public class LinkedList
{
   /**
      Constructs an empty linked list.
   */
   public LinkedList()
   {
      first = null;
   }

   /**
      Returns the first element in the linked list.
      @return the first element in the linked list
   */
   public Object getFirst()
   {
      if (first == null)
         throw new NoSuchElementException();
      return first.data;
   }

   /**
      Removes the first element in the linked list.
      @return the removed element
   */
   public Object removeFirst()
   {
      if (first == null)
         throw new NoSuchElementException();
      Object element = first.data;
      first = first.next;
      return element;
   }

   /**
      Adds an element to the front of the linked list.
      @param element the element to add
   */
   public void addFirst(Object element)
   {
      Node newNode = new Node();
      newNode.data = element;
      newNode.next = first;
      first = newNode;
   }


   /*************** Added methods *******************************/

   // 1. The add adds the parameter string into the linked list. The linked list
   //     should contain all strings in alphabetical order
    


  
   //2. count method counts how many times the parameter object
   //appears in the linked list and return the number. It returns 0
   //if the parameter object does not exist in the linked list.
   



   
  //3. search method returns the index of the parameter object
  //in the linked list if it exists. It return -1 if it does not
  //exits. If the index is out of bounds, then it throws an exception.
  




   //4. remove method removes the element at the parameter
   //index in the linked list.
   



   //5. The method size return the current size of the linked list,
   //that is, the number of elements in it.
   





   //6. The toString method returns a string containing the content
   //of the linked list. In this assignment, the linked list will
   //contain only string, so it returns a concatenation of all strings
   //in the linked list and a line break
   



   //7. The removeLastFew method removes the parameter specified number
   //of elements from the end of the linked list.
   //If the parameter integer is larger than the current size of
   //the linked list, then the linked-list will be empty.
   //If the parameter integer is less than 0,
   //nothing should be removed from the linked list.
     

   /***************************************************************/

   /**
      Returns an iterator for iterating through this list.
      @return an iterator for iterating through this list
   */
   public ListIterator listIterator()
   {
      return new LinkedListIterator();
   }

   private Node first;

   private class Node
   {
      public Object data;
      public Node next;
   }

   private class LinkedListIterator implements ListIterator
   {
      /**
         Constructs an iterator that points to the front
         of the linked list.
      */
      public LinkedListIterator()
      {
         position = null;
         previous = null;
      }

      /**
         Moves the iterator past the next element.
         @return the traversed element
      */
      public Object next()
      {
         if (!hasNext())
            throw new NoSuchElementException();
         previous = position; // Remember for remove

         if (position == null)
            position = first;
         else
            position = position.next;

         return position.data;
      }

      /**
         Tests if there is an element after the iterator
         position.
         @return true if there is an element after the iterator
         position
      */
      public boolean hasNext()
      {
         if (position == null)
            return first != null;
         else
            return position.next != null;
      }

      /**
         Adds an element before the iterator position
         and moves the iterator past the inserted element.
         @param element the element to add
      */
      public void add(Object element)
      {
         if (position == null)
         {
            addFirst(element);
            position = first;
         }
         else
         {
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = position.next;
            position.next = newNode;
            position = newNode;
         }
         previous = position;
      }

      /**
         Removes the last traversed element. This method may
         only be called after a call to the next() method.
      */
      public void remove()
      {
         if (previous == position)
            throw new IllegalStateException();

         if (position == first)
         {
            removeFirst();
         }
         else
         {
            previous.next = position.next;
         }
         position = previous;
      }

      /**
         Sets the last traversed element to a different
         value.
         @param element the element to set
      */
      public void set(Object element)
      {
         if (position == null)
            throw new NoSuchElementException();
         position.data = element;
      }

      private Node position;
      private Node previous;
   }
}