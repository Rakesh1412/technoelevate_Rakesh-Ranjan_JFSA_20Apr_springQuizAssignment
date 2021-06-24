package com.te.springquiz.factory;

import java.util.Date;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.te.springquiz.orm.QuizQuestions;
import com.te.springquiz.orm.Results;
import com.te.springquiz.quizfunction.Start;

public class Factory {

	ApplicationContext context = new ClassPathXmlApplicationContext("quiz.xml");
	Start loginDetails = (Start) context.getBean("start");
	Scanner scanner = new Scanner(System.in);
	int result = 0;
	int noOfQuestions = 0;

	public void run(String name) {
		int iterate2;
		do {
			System.out.println("ENTER 1 TO SELECT----> Current_Affairs");
			System.out.println("ENTER 2 TO SELECT----> Sports");
			int subject = scanner.nextInt();
			subject(subject);
			questions(subject);
			results(subject);
			System.out.println("Enter 1 for to write one more Quiz");
			System.out.println("Enter 2 for Exit");
			iterate2 = scanner.nextInt();
		} while (iterate2 == 1);
		
		System.out.println("Thank you "+ name +" have a good day");
	}

	public void questions(int subject) {
		QuizQuestions questions1 = loginDetails.questions(subject);
		System.out.println("Please answer below questions by choosing the correct option....");
		
		System.out.println("First Question");
		System.out.println(questions1.getQuestion1());
		System.out.println(questions1.getOption1());
		String answer1 = scanner.next();
		if (questions1.getAnswer1().charAt(0)==answer1.charAt(0)) {
			result++;
		}
		System.out.println("Second Question");
		System.out.println(questions1.getQuestion2());
		System.out.println(questions1.getOption2());
		String answer2 = scanner.next();
		if (questions1.getAnswer2().charAt(0)==answer2.charAt(0)) {
			result++;
		}
		System.out.println("Third Question");
		System.out.println(questions1.getQuestion3());
		System.out.println(questions1.getOption3());
		String answer3 = scanner.next();
		if (questions1.getAnswer3().charAt(0)==answer3.charAt(0)) {
			result++;
		}
		System.out.println("Forth Question");
		System.out.println(questions1.getQuestion4());
		System.out.println(questions1.getOption4());
		String answer4 = scanner.next();
		if (questions1.getAnswer4().charAt(0)==answer4.charAt(0)) {
			result++;
		}
		System.out.println("Fifth Question");
		System.out.println(questions1.getQuestion5());
		System.out.println(questions1.getOption5());
		String answer5 = scanner.next();
		if (questions1.getAnswer5().charAt(0)==answer5.charAt(0)) {
			result++;
		}
	}// End of the Method

	public void subject(int subject) {
		if (subject == 1) {
			QuizQuestions questions = (QuizQuestions) context.getBean("ca");
		} else if (subject == 2) {
			QuizQuestions questions = (QuizQuestions) context.getBean("sport");
		}
	}// End of the Method

	public void results(int subject) {
		noOfQuestions =5;
		Results results = (Results) context.getBean("results");
		results.setId(subject);
		Date date = new Date();
		results.setTime_Date(date);
		results.setMarks(result);
		results.setPercentage((result * 100) / noOfQuestions);
		//results.setUsername(null);
		loginDetails.results(results);
		Results results2 = loginDetails.getResults(date);
		System.out.println("Quiz Completed");
		System.out.println("Total marks obtained: " + results2.getMarks());
		System.out.println("Percentage: " + results2.getPercentage() + "%");
		result = 0;

	}// End of the Method

}// End of the class
