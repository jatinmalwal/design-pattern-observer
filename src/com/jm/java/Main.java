package com.jm.java;

/**
 * @author Jatin Malwal
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.jm.java.College.Student;

public class Main {

	public static void main(String[] args) {
		College college = new College();
		Listener listener = new Listener();
		college.registerPropertyChangeListener(listener);

		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		Scanner scanner = new Scanner(System.in);

		for (Student temp : college.getStudents()) {
			System.out.println("Name : " + temp.getName() + " Age : " + temp.getAge());
		}

		System.out.print("Enter index value which to want to edit...");
		int index = 0;

		try {
			index = Integer.parseInt(bufferedReader.readLine());

			// index = scanner.nextInt();
			Student student;
			if (index < college.getStudents().size()) {
				System.out.print("Name : ");
				student = college.getStudents().get(index);
				student.setName(bufferedReader.readLine());
				System.out.print("Age :");
				student.setAge(Byte.parseByte(bufferedReader.readLine()));
				// student.setName(scanner.nextLine());
				// student.setAge(scanner.nextByte());
			} else {
				System.out.print("Invalid index....");
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// student.setName(student.getName() + "1");
		//
		// student.setAge((byte) ((student.getAge()) + 1));

	}
}