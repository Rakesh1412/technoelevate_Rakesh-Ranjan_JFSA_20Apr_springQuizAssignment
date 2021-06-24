package com.te.springaquiz;

import java.util.Scanner;

import com.te.springquiz.factory.Factory;

public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name = (scanner.nextLine()).toUpperCase();
		
		System.out.println("WELCOME " +name + " Lets Play");
		System.out.println("---------------------------------------");
		Factory factory = new Factory();
		factory.run(name);

	}
}
