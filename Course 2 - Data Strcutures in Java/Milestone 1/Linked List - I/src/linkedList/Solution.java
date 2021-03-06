package linkedList;
import java.util.Scanner;

public class Solution{

  
  public static void main(String[] args){

	  Operations op = new Operations();
	  AppendLastNToFirst ex = new AppendLastNToFirst();
	  
	  RemoveDuplicates rd = new RemoveDuplicates();
	  
	  PrintReverseLinkedList pLink = new PrintReverseLinkedList();
	  
	  IsPalindrome isPal = new IsPalindrome();
	  
	  System.out.println("Enter nodes to create an Linked List:-");
	  
	  LinkedListNode<Integer> head = op.takeInput();

	  Scanner sc = new Scanner(System.in);
	  
	  int option = 0 ;
	  
	  while(option != 5){
		System.out.println("Enter the operation you want to perform : \n"
			  		+ "1 : Print , 2. InsertNode , 3.DeleteNode, 4. Length of the LinkedList, 5. EXIT"
			  		+ " 6. FindNode , 7. appendLastNToFirst , \n"
			  		+ "8. Remove Duplicates values from a Sorted Singly Linked List, "
			  		+ "9. Print Linked List in reverse Order , \n"
			  		+ "10. Is Linked List Palindrome");
			  
	  option = sc.nextInt();
	  switch(option) {
	  case 1:
		  op.print(head);
		  break;
	  case 2:
		  System.out.print("Enter the node you want to insert :");
		  int newNode = sc.nextInt();
		  System.out.print("Enter the location at which you want to insert the node :");
		  int loc = sc.nextInt();
		  op.insertNode(head, newNode,loc);
	      break;
		  
	  case 3: 
		  System.out.println("Enter the position of the noed you want to delete");
		  int pos = sc.nextInt();
		  head = op.deleteNode(head, pos);
		  System.out.println("After deleteion at pos :"+pos);
		  op.print(head);
		  break;
	  case 4:
		  System.out.println("Length is :"+ op.length(head));
		  break;
	  case 6:
		  System.out.println("Enter the node you want to find ");
		  int node = sc.nextInt();
		  System.out.println("Element is found at : "+op.findNode(head, node));
		  break;
	  case 7:
		  System.out.println("Enter the location from where to appendLastNToFirst : ");
		  int n = sc.nextInt();
		  LinkedListNode<Integer> tempHead = ex.appendLastNToFirst(head,n);
		  op.print(tempHead);
		  break;
	  case 8:
		  LinkedListNode<Integer> headNode = rd.removeDuplicates(head);
		  op.print(headNode);
		  break;
	  case 9:
		  pLink.printReverse(head);
		  System.out.println();
		  break;
	  case 10:
		  System.out.println(isPal.isPalindrome(head));
	  }
	  }
     
	  sc.close();
  }
}
