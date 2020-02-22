package Coding_Exam_A;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class CodingExamA {
	public static void main(String[] args) {
		/*
		 * Write a program that asks the user for three pieces of information.
		 * 1. How many robots
		 * 2. The color of the shapes
		 * 3. How many sides each shape will have
		 * 
		 * Once the information has been collected, the program will then make the requested number of robots
		 * each draw the requested shape in the requested color. The robots should execute at the same time so 
		 * Threads will need to be used. Arrange the robots so that the shapes do not overlap.
		 * For full credit, define the Thread functions using lambdas.
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product should look like.
		 */
		int num = Integer.parseInt(JOptionPane.showInputDialog("How many robots?"));
		String color = JOptionPane.showInputDialog("What color? Enter 'Red', 'Green', or 'Blue'.");
		int side = Integer.parseInt(JOptionPane.showInputDialog("How many sides will the shapes have?"));
		Thread[] threads = new Thread[num];
		for (int i = 0; i < num; i++) {
			int k = i;
			System.out.println("making robot");
			threads[i]= new Thread(() -> {
				System.out.println("drawing shape");
				Robot kaito = new Robot("mini");
				kaito.moveTo(100 * 2*k, 300);
				kaito.penDown();
				kaito.setSpeed(100000);
				if (color.equalsIgnoreCase("red")) {
					kaito.setPenColor(Color.RED);
				} else if (color.equalsIgnoreCase("green")) {
					kaito.setPenColor(Color.GREEN);
				} else if (color.equalsIgnoreCase("blue")) {
					kaito.setPenColor(Color.BLUE);
				} else {
					kaito.setPenColor(Color.BLACK);
				}
				for (int j = 0; j < side; j++) {
					kaito.move(100);
					kaito.turn(360/side);
				}
			});
			System.out.println("done");
		}
		
		for (Thread t: threads) {
			t.start();
		}
		
	}
}
