/*--------------------------------------------------------------------------------------*/
/*  Binary.java  -  Program created for the binary search assignment, uses linear       */
/*                  search and binary search to search into a phone index.              */
/*--------------------------------------------------------------------------------------*/
/*  Author: Narrthanan Seevananthan                                                     */
/*  Date: November 12, 2012                                                             */
/*--------------------------------------------------------------------------------------*/
/*  Input: Phone numbers from an index, the phone number that is choosen to be          */
/*         searched for                                                                 */
/*  Output: location of the number within the index, the number of comparision          */
/*          operations used                                                             */
/*--------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
import java.text.*;

public class Binary
{
    //The counter for the number of recursive operations is a static because
    //it can't be placed within its own method and count properly
    //you would have to add it to one of the method inputs and it would be complicated
    //because of recursion
    static int count = 0;

    //void method used for linear searching because it is easier and you would have to
    //return two values anyways, so you would have to display one of the values anyways
    static void linear (int right, long search, long[] number)
    {
	//here "i" acts as a cap so when the array values are surpassed the program will stopped
	//Stopper is used here just because there are no multiple values within the index
	//but can be removed to display them all
	int i, count, times, stopper;
	times = 0;
	count = 0;
	stopper = 0;
	for (i = 0 ; i < right && stopper < 2 ; i++)
	{
	    count = count + 2;
	    if (number [i] == search)
	    {
		System.out.println ("The number " + search + " is found at: " + i);
		stopper = 3;
	    }
	    else
	    {
		times++;
	    }

	}
	count = count + 1;
	//back up plan just incase the number does not exist
	if (times == right)
	{
	    System.out.println ("The number is not within the database.");
	}
	System.out.println ("The number of comparision operations used to locate the telephone number is " + count + " times.");
    }


    //return method used for the binary search using recursion
    //left and right are the range values, or in other terms the max and the min
    //long is used here because the phone numbers wouldn't fit in an int value, it was too big
    //three if state ments used for three different situations, if the number is greater,
    //less than or equal to
    public static int binaryS (int left, int right, long search, long[] numbers)
    {
	//If the number doesn't exist return zero so later the code can recognize
	//this and display a message stating the number doesn't exist
	//you have to make sure that if the difference between right and left is zero to state
	//that the value doesn't exist other wise it will
	//loop infinite number of times if the number doesn't exist without this,
	//But make sure that this parameter is after the equals statment because if the
	//value is found it will meet the parameter as well
	//also the maximum number of times it takes to search for a number is about 10 times
	//so a cutt off value of 23 is more than enough

	int mid = (right + left) / 2;

	//(main base case) if the number exists, when target value is equal to the current value
	count = count + 1;
	if (numbers [mid] == search)
	{
	    System.out.println ("The number of comparision operations used to locate the telephone number is " + count + " times.");
	    System.out.println (mid);
	    return mid;
	}

	//base case incase the number doesn't exist
	//when "max" and "min" are equal but the number is not equal to rh target value
	else if (right - left == 0)
	{

	    return 0;
	}


	//If the value is less than the target value
	else if (numbers [mid] < search)
	{

	    left = mid + 1;
	    //recursive sequence
	    return binaryS (left, right, search, numbers);
	}

	//(numbers [mid] > search)
	//The above is what the parameter for the method below would be but
	//since it is the only situation left you can state it as an else
	//If the value is greater than the target value
	else
	{

	    right = mid - 1;
	    //recursive sequence
	    return binaryS (left, right, search, numbers);
	}
	//If the number doesn't exist return zero so later the code can recognize
	//This and display a message stating the number doesn't exist

    }


    public static void main (String str[]) throws IOException
    {
	//description of the program and some starter stuff like variable definitions
	BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
	DecimalFormat df = new DecimalFormat ("#");
	System.out.println ("This program will read telephone numbers from a datbase and search for any given numbers within the database. Returning the position that number is located and the number of steps required to get there.");

	BufferedReader reader = new BufferedReader (new FileReader ("phone.txt"));
	String[] phone = new String [1600];
	long[] numbers = new long [1600];
	String line = null;
	int right = 1;
	String replace = "";
	int responsecase, location;
	long search;
	int left = 0;

	//Part where numbers are stored into the array
	//right is used as the total
	System.out.println ("Here are the numbers: ");
	while ((line = reader.readLine ()) != null)
	{
	    phone [right] = line;
	    numbers [right] = Long.parseLong (phone [right].replaceAll ("-", replace));
	    right++;
	}
	System.out.println ("There are " + (right - 1) + " many numbers.");
	System.out.println ("Please enter the number you wish to search for with no dashes: ");
	search = Long.parseLong (stdin.readLine ());
	System.out.println ("Please enter the method you would like to search with: \n[1] linear search \n[2] binary search");
	responsecase = Integer.parseInt (stdin.readLine ());

	switch (responsecase)
	{
	    case 1:
		linear (right, search, numbers);
		break;
	    case 2:
		location = binaryS (left, right, search, numbers);
		if (location == 0)
		{
		    System.out.println ("Sorry. The number is not within the database.");
		}
		else
		{
		    System.out.println ("The location of the number is " + location + ".");
		}
		break;
	    default:
		System.out.println ("You have entered and invalid value, please try again with the numbers 1-2.");
		break;

	}
    }
}

