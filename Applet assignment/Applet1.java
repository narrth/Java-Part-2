/*--------------------------------------------------------------------------------------*/
/*  Applet1.java  -  This program will display a selected shape from a selected colour  */
/*                   from a given size, it will also animate the shape                  */
/*--------------------------------------------------------------------------------------*/
/*  Author: Narrthanan Seevananthan                                                     */
/*  Date: Friday March 22 2013                                                          */
/*--------------------------------------------------------------------------------------*/
/*  Input: Shape, Colour, Size                                                          */
/*  Output: Animated shape with colour                                                  */
/*--------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Applet1 extends Applet implements ItemListener, ActionListener
{
    //Declare and initialize variables, buttons, textboxes and groups of checkboxes(radio buttons)
    int colournum, shapenum;
    int X = 100;
    int Size1 = -1;
    int Size2 = -1;

    boolean animatecheck = false;

    CheckboxGroup shape = new CheckboxGroup ();
    CheckboxGroup colour = new CheckboxGroup ();

    Checkbox Shape1 = new Checkbox ("Oval", shape, false);
    Checkbox Shape2 = new Checkbox ("Circle", shape, false);
    Checkbox Shape3 = new Checkbox ("Rectangle", shape, false);
    Checkbox Shape4 = new Checkbox ("Square", shape, false);
    Checkbox Shape5 = new Checkbox ("Triangle", shape, false);

    Checkbox Colour1 = new Checkbox ("Red", colour, false);
    Checkbox Colour2 = new Checkbox ("Blue", colour, false);
    Checkbox Colour3 = new Checkbox ("Green", colour, false);
    Checkbox Colour4 = new Checkbox ("Yellow", colour, false);
    Checkbox Colour5 = new Checkbox ("Orange", colour, false);

    Button draw = new Button ("Draw");
    Button animate = new Button ("Animate");
    Button stop = new Button ("Stop");

    String msg1 = "Please enter a horizontal size.";
    String msg2 = "Please enter a vertical size.";
    Font textFont = new Font ("Comic Sans", Font.BOLD, 14);
    TextField size1 = new TextField (msg1, 30);
    TextField size2 = new TextField (msg2, 30);




    public void init ()
    {

    //Set default layout to null so i can set manual points
	setLayout (null);
	setBackground (Color.lightGray);

	Colour1.setBounds (20, 20, 80, 20);
	Colour2.setBounds (20, 40, 80, 20);
	Colour3.setBounds (20, 60, 80, 20);
	Colour4.setBounds (20, 80, 80, 20);
	Colour5.setBounds (20, 100, 80, 20);

	Shape1.setBounds (100, 20, 80, 20);
	Shape2.setBounds (100, 40, 80, 20);
	Shape3.setBounds (100, 60, 80, 20);
	Shape4.setBounds (100, 80, 80, 20);
	Shape5.setBounds (100, 100, 80, 20);

	size1.setBounds (200, 20, 200, 20);
	size2.setBounds (200, 40, 200, 20);
	draw.setBounds (250, 60, 200, 20);
	animate.setBounds (250, 80, 200, 20);
	stop.setBounds (250, 100, 200, 20);
	//Display radio buttons, textboxes etc.

	add (Colour1);
	add (Colour2);
	add (Colour3);
	add (Colour4);
	add (Colour5);


	add (Shape1);
	add (Shape2);
	add (Shape3);
	add (Shape4);
	add (Shape5);


	add (size1);
	add (size2);



	add (draw);
	add (animate);
	add (stop);

	//Make the clicks on the buttons detectable
	draw.addActionListener (this);
	animate.addActionListener (this);
	stop.addActionListener (this);

	Colour1.addItemListener (this);
	Colour2.addItemListener (this);
	Colour3.addItemListener (this);
	Colour4.addItemListener (this);
	Colour5.addItemListener (this);

	Shape1.addItemListener (this);
	Shape2.addItemListener (this);
	Shape3.addItemListener (this);
	Shape4.addItemListener (this);
	Shape5.addItemListener (this);
    }


    public void paint (Graphics g)
    {



	//menu system to choose the colour based on the user input(colournum)
	switch (colournum)
	{
	    case 1:
		g.setColor (Color.red);
		break;
	    case 2:
		g.setColor (Color.blue);
		break;
	    case 3:
		g.setColor (Color.green);
		break;
	    case 4:
		g.setColor (Color.yellow);
		break;
	    case 5:
		g.setColor (Color.orange);
		break;
	}
	//draw function performed for animation, do not change order or animation will flicker
	if (animatecheck == true)
	{


	    //menu to repeatedly draw shape as x co-ordinates change
	    X = X + 5;


	    switch (shapenum)
	    {
		case 1:

		    g.fillOval (X, 500, Size1, Size2);
		    break;
		case 2:
		    //only Size1 is used for cirlcles and squaes
		    g.fillOval (X, 500, Size1, Size1);
		    break;
		case 3:

		    g.fillRect (X, 500, Size1, Size2);
		    break;
		case 4:

		    g.fillRect (X, 500, Size1, Size1);
		    break;
		case 5:

		    // method to create a triangle (polygon with three points)
		    Polygon poly = new Polygon ();
		    poly.addPoint (X, 500 + Size2);
		    poly.addPoint (X + (Size1 / 2), 500);
		    poly.addPoint ((X + Size1), 500 + Size2);
		    g.fillPolygon (poly);
		    break;
	    }
	    // sleep requires the exception to be caught
	    try
	    {

		Thread.sleep (10);
	    }
	    catch (InterruptedException ie)
	    {
	    }
	    //exception to end the animation
	    if (X >= 1000)
	    {
		X = 100;
		animatecheck = false;
		repaint ();
	    }

	    repaint ();



	}

	//check to see if size is valid
	//if so menu system for type of shape is run

	if (Size1 > 0 && Size2 > 0 && Size1 < 10000 && Size2 < 10000 && animatecheck == false)
	{
	    switch (shapenum)
	    {
		case 1:
		    g.fillOval (X, 500, Size1, Size2);
		    break;
		case 2:
		    //only Size1 is used for cirlcles and squaes
		    g.fillOval (X, 500, Size1, Size1);
		    break;
		case 3:
		    g.fillRect (X, 500, Size1, Size2);
		    break;
		case 4:
		    g.fillRect (X, 500, Size1, Size1);
		    break;
		case 5:
		    // method to create a triangle (polygon with three points)
		    Polygon poly = new Polygon ();
		    poly.addPoint (X, 500 + Size2);
		    poly.addPoint (X + (Size1 / 2), 500);
		    poly.addPoint ((X + Size1), 500 + Size2);
		    g.fillPolygon (poly);
		    break;
	    }
	}






    }


    public void itemStateChanged (ItemEvent ie)
    {
	//radio button check system
	//if statement checks to see if and buttons are selected
	if (Colour1.getState () == true || Colour2.getState () == true || Colour3.getState () == true || Colour4.getState () == true || Colour5.getState () == true)
	{
	    //method to identify checkbox, then saved in a variable and compared with button labels
	    Checkbox chk = colour.getSelectedCheckbox ();
	    if (chk.getLabel ().equals ("Red"))
	    {
		colournum = 1;
	    }


	    else if (chk.getLabel ().equals ("Blue"))
	    {
		colournum = 2;
	    }


	    else if (chk.getLabel ().equals ("Green"))
	    {
		colournum = 3;
	    }


	    else if (chk.getLabel ().equals ("Yellow"))
	    {
		colournum = 4;
	    }


	    else
	    {
		colournum = 5;
	    }
	}

	//above proccess is repeated for shapes
	if (Shape1.getState () == true || Shape2.getState () == true || Shape3.getState () == true || Shape4.getState () == true || Shape5.getState () == true)
	{
	    Checkbox chk = shape.getSelectedCheckbox ();
	    if (chk.getLabel ().equals ("Oval"))
	    {
		shapenum = 1;
	    }


	    else if (chk.getLabel ().equals ("Circle"))
	    {
		shapenum = 2;
	    }


	    else if (chk.getLabel ().equals ("Rectangle"))
	    {
		shapenum = 3;
	    }


	    else if (chk.getLabel ().equals ("Square"))
	    {
		shapenum = 4;
	    }


	    else
	    {
		shapenum = 5;
	    }
	}
    }


    //process to check clicks for buttons
    //method used to identify clicked button and compared to button names
    public void actionPerformed (ActionEvent evt)
    {
	Button button = (Button) evt.getSource ();

	//check for invalid size values, size cap in place
	if (button == draw)
	{
	    try
	    {
		Size1 = Integer.parseInt (size1.getText ());
		Size2 = Integer.parseInt (size2.getText ());
		repaint ();
	    }

	    //display error message if size values are too large or are not valid numbers
	    catch (Throwable t)
	    {
		JOptionPane.showMessageDialog (null, "Size values entered are not valid or too large", "Exception or Error", 0);
	    }
	}
	//set the boolean to false by clicking the stop button to stop the animation
	else if (button == stop)
	{
	    animatecheck = false;
	    repaint ();
	}
	//set the boolean to true by clicking the animate button to trigger the animation
	else if (button == animate)
	{
	    animatecheck = true;
	    repaint ();
	}
	//display error message for other errors
	else
	{
	    JOptionPane.showMessageDialog (null, "Size values entered are not valid or too large", "Exception or Error", 0);
	}
    }
}


