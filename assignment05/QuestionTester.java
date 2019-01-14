package assignment05;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuestionTester {

	@Test
	void testCheckAnswer() {
		ChoiceQuestion testQ = new ChoiceQuestion("Test");
		testQ.addChoice("1", true);
		testQ.addChoice("2", false);
		assert(testQ.checkAnswer("1"));
		assert(!testQ.checkAnswer("2"));
	}
	@Test
	void testCheckAnswerMulti() {
		MultichoiceQuestion testQ = new MultichoiceQuestion("Test");
		testQ.addChoice("1", true);
		testQ.addChoice("2", false);
		testQ.addChoice("3", true);
		testQ.addChoice("4", false);
		assert(testQ.checkAnswer("1 3"));
		assert(!testQ.checkAnswer("1 2"));
		assert(!testQ.checkAnswer("2 4"));
	}

}
