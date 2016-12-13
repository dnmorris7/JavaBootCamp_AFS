package com.accenture.adf.newcodington.module10.sample;

/**
 * Topic : Inheritance
 * 
 * Instructions:
 * 
 * 	The RectangleDemo.java file will be used during the 
 * 	See It tasks in the Inheritance module.
 * 	Ensure that you have created the Shape interface 
 * 	and the Rectangle classes before running this program
 *	
 */
public class RectangleDemo {

        public static void main(String[] args) {

                Rectangle rectangle = new Rectangle(10, 12);
          
                System.out.println("Rectangle Demo!");

                System.out.println("Rectangle Area: " + rectangle.calculateArea());

                System.out.println("Rectangle Perimeter: " + rectangle.calculatePerimeter());
        }

}

