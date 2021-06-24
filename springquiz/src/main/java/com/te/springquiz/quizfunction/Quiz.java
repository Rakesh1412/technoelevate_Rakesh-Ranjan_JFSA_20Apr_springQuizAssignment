package com.te.springquiz.quizfunction;

import java.util.Date;

import com.te.springquiz.orm.QuizQuestions;

import com.te.springquiz.orm.Results;

interface Quiz {

//	abstract  Register login(String username,String Password);
//	
//	abstract  Register register(Register register);

	abstract QuizQuestions questions(int id);

	abstract void results(Results results);

	abstract Results getResults(Date date);

}
