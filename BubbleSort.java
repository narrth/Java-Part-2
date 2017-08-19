/*--------------------------------------------------------------------------------------*/
/*  template.java  -  Description                                                       */
/*                                                                                      */
/*--------------------------------------------------------------------------------------*/
/*  Author:                                                                             */
/*  Date:                                                                               */
/*--------------------------------------------------------------------------------------*/
/*  Input:                                                                              */
/*  Output:                                                                             */
/*--------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
import java.text.*;

public class BubbleSort
{
    public static void main (String str[]) throws IOException
    {
	BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
	DecimalFormat df = new DecimalFormat ("#");
	final int MAX = 1500;
	int i, j, count2;
	int count = 0;
	String line;
	int temp;
	int [] numbers = new int [MAX];
	String [] num = new String [MAX];

	BufferedReader reader = new BufferedReader (new FileReader ("Num.txt"));

	while ((line = reader.readLine ()) != null)
	{

	    numbers [count] = Integer.parseInt(line);
	    num [count] = line;
	    System.out.println (numbers [count]);

	    count++;
	}
	reader.close ();

	for (i = 0 ; i < count ; i++)
	{
	    for (j = i + 1 ; j < (count) ; j++)
	    {
		if (numbers [i] < numbers [j])
		    {
			temp = numbers [i];
			numbers [i] = numbers [j];
			numbers [j] = temp;
			
			line = num [i];
			num [i] = num [j];
			num [j] = line; 

		    }
	    }
	}
	
	System.out.println();
	System.out.println ("The numbers in order are: ");
	BufferedWriter writer = new BufferedWriter (new FileWriter ("Sorted(Num).txt"));
	for (count2 = 0 ; count2 < count ; count2++)
	{
	    System.out.println (numbers [count2]);
	    writer.write (num [count2]);
	    writer.newLine ();
	}
	writer.close ();


    }
}

