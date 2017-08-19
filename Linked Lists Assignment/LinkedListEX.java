/*--------------------------------------------------------------------------------------*/
/*  LinkedListEX.java  -  This program will mimic the t.v. show survivor                */
/*                        and eliminate contestants one by one                          */
/*--------------------------------------------------------------------------------------*/
/*  Author: Narrthanan Seevananthan                                                     */
/*  Date:  December 19, 2012                                                            */
/*--------------------------------------------------------------------------------------*/
/*  Input: contestant names, contestants to be eliminated                               */
/*  Output: starting display, the winner, original list of names, updated list of names */
/*--------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
import java.text.*;

public class LinkedListEX
{

    public static Node summary (Node backup_contestants, Node backup_head, Node winner)
    {
	//check to see if the winner is the current value, if it is
	//display a congratulatory message and enter the loop to print
	//the rest of the names out

	if ((backup_contestants.data).equals (winner.data))
	{
	    System.out.println (((backup_contestants).data) + " <--- Congratulations you are the winner");
	    do
	    {
		if ((backup_contestants.next) != backup_head)
		{
		    backup_contestants = backup_contestants.next;
		    System.out.println (backup_contestants.data);
		}
	    }
	    while ((backup_contestants.next) != backup_head);
	    return backup_contestants;

	}
	//if the current value is not the winner recall the method and
	//move the list down one node

	else
	{
	    System.out.println (backup_contestants.data);
	    return summary (backup_contestants.next, backup_head, winner);


	}

    }



    public static Node elimination (Node head) throws IOException
    {
	BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
	//declare nodes to use and other variables
	Node head_eliminate, curr, prev_eliminate;
	int count = 0;
	int count2 = 0;

	String target;
	prev_eliminate = null;

	//ask for user input
	System.out.println ("Please enter the name you wish to eliminate: ");
	target = stdin.readLine ();

	//start the searching process by
	//asigining current as the head
	//from the original list
	curr = head;

	//check if the head of the original list is the value you wish to eliminate
	//if not then continue and set head, previous to the head of the original list


	if ((head.data).equals (target))        //if head is the target
	{
	    //shift the link down one node and set the new head as the second node
	    head_eliminate = curr.next;
	    curr = curr.next;

	    //check to see if the next node is the first node other wise move through the
	    //list, if the first node is the next node than delete it or skip it
	    while (!(curr.next.data).equals (target))
	    {
		prev_eliminate = curr;
		curr = curr.next;
	    }

	    curr.next = curr.next.next;         //delete head

	}


	//if yes then skip that value and continue on through the list to get the "tail"
	//or end of the list and then connect the tail to the second value to get rid of the
	//first
	else      //middle value
	{

	    head_eliminate = curr;
	    prev_eliminate = curr;
	    curr = curr.next;


	    //Delete middle value
	    while (curr != head)
	    {
		if (!(curr.data).equals (target)) //not equal to target
		{
		    //continue through the linked list
		    prev_eliminate = curr;
		    curr = curr.next;
		}
		else
		{
		    //do not link the value that needs to be eliminated but instead pass over
		    //it, and set that value to null to free up memory
		    prev_eliminate.next = curr.next;
		    curr.data = null;
		    curr = null;
		    break;
		}
	    }

	}




	return head_eliminate;

    }


    public static Node backup (Node curr_contestants, int total)
    {

	//declare nodes to use (no values yet)
	Node head_backup, curr_backup, prev_backup;
	int count = 0;
	curr_backup = null;

	//create the first node with a value from the original list and point the pointer to the new node
	head_backup = new Node (curr_contestants.data);
	curr_contestants = curr_contestants.next;
	prev_backup = head_backup;

	//add one to the counter for every new node created
	count++;

	//create a loop to back up the rest of the list
	while (count < total)
	{
	    //back up the rest of the list

	    curr_backup = new Node (curr_contestants.data);
	    prev_backup.next = curr_backup;
	    prev_backup = curr_backup;
	    curr_contestants = curr_contestants.next;

	    //add one more to the count
	    count++;
	}


	//make the list circular by connecting the "head to the tail"
	prev_backup.next = head_backup;
	prev_backup = head_backup;

	//print a message indicating a back up has been made
	System.out.println ("A copy of the contestants have been backed up.");

	return head_backup;

    }


    public static void main (String str[]) throws IOException
    {
	BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
	DecimalFormat df = new DecimalFormat ("#");

	//small program description
	System.out.println ("This program is designed to simulate the t.v. show Survivor. \nIt will allow a user to enter an undetermined number of contestants of the show's contestants.");
	System.out.println ();
	System.out.println ();
	System.out.println ();
	System.out.println ();
	System.out.println ();
	System.out.println ();
	System.out.println ();
	System.out.println ();

	System.out.println ("*******************************************************");
	System.out.println ("  ______                     _                  ");
	System.out.println (" / _____)                   |_|                 ");
	System.out.println ("| |_____ _   _ _____ __  __  _  _   _   _____  _____");
	System.out.println (" |_____ | | | |  ___)| | | || || | | | |  _  | | ____)");
	System.out.println (" _____| | |_| | |     | V | | | | V |  | |_| | | |    ");
	System.out.println ("(______/|____/|_|      |_|  |_|  |_|   |_____| |_|   ");
	System.out.println ("");
	System.out.println ("*******************************************************");

	System.out.println ();
	System.out.println ();

	// declaring nodes, variables and variable values
	Node curr_contestants, head, prev, backup_contestants, backup_head;
	int total, count, check;
	String data;

	curr_contestants = null;
	total = 0;
	check = 0;


	// asking for user input
	System.out.println ("Please enter a contestant name or\ntype in 'fin' to quit the program.");
	data = stdin.readLine ();
	System.out.println ();

	// only procced as long as data does not equal "fin"
	if (!data.equals ("fin"))
	{
	    // creating a new node for that input
	    head = new Node (data);

	    //assign the first node (head) to prev(pointer node)
	    prev = head;

	    // add to the number of nodes to keep track of the number of nodes
	    total++;

	    //start loop to create the rest of the linked list
	    while (!data.equals ("fin"))
	    {

		// asking for user input
		System.out.println ("Please enter a contestant name or\ntype in 'fin' to quit the program.");
		data = stdin.readLine ();
		System.out.println ();

		//check again so data doesn't equal fin
		if (!data.equals ("fin"))
		{
		    //create new node for input
		    curr_contestants = new Node (data);

		    // link the new node to the last useing the pointer node
		    prev.next = curr_contestants;
		    //point the pointer node to the front of the list
		    prev = curr_contestants;
		    //add one to the toal number of nodes for every node you make
		    total++;
		}

	    }

	    //make the list circular by linking the last value to the first
	    prev.next = head;
	    //            prev = head;

	    //call the back up method (not void)
	    backup_contestants = backup (head, total);

	    //save the starting node into a node for future referance
	    backup_head = backup_contestants;
	    //Printing out the back up
	    do
	    {
		System.out.println (backup_contestants.data);
		backup_contestants = backup_contestants.next;

	    }
	    while (backup_contestants != backup_head);


	    System.out.println ();
	    System.out.println ();


	    //call for elimination method
	    do
	    {
		head = elimination (head);
		curr_contestants = head;
		//Print the modified list

		System.out.println ("The remaining contestants are: \n");
		do
		{

		    System.out.println (curr_contestants.data);
		    curr_contestants = curr_contestants.next;
		}
		while (curr_contestants != head);
	    }
	    while (head.next != head);
	    System.out.println ();
	    System.out.println ();

	    System.out.println ("We will now announce the winner :D, along with the other contestants\nin original order.");
	    //Use summary method to recursivley display the list of original contestants
	    //along with a congradulatory message to the winner
	    summary (backup_contestants, backup_head, head);

	}
    }
}

