package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Controller {

	private int numb1;
	private int numb2;
	private String operator;

	private int answer;
	private int realAnswer;
	
	private int minNumber = 0;
	private int maxNumber = 10;
	
	private int questionCount = 0;
	private int correctCount = 0;
	
	@FXML
	private Button yesButton;
	
	@FXML
	
	private Button noButton;
	@FXML
	private Label questionLabel;
	
	@FXML
	private Label responseLabel;
	
	@FXML
	private Label accuracyLabel;
	
	@FXML
	public void initialize() {
		responseLabel.setText("");
		accuracyLabel.setText("");
		setUpProblem();
	}
	
	public void setUpProblem() {
		double chance;
		numb1 = (int) (Math.random() * (maxNumber - minNumber) + minNumber);
		numb2 = (int) (Math.random() * (maxNumber - minNumber) + minNumber);
		
		//choose operator
		chance = Math.random();
		if (chance < 0.5) {
			operator = "+";
			realAnswer = numb1 + numb2;
		}
		else {
			operator = "*";
			realAnswer = numb1 * numb2;
		}
		
		//maybe make the given answer wrong
		answer = realAnswer;
		chance = Math.random();
		if (chance < 0.5) {
			answer += (int) (Math.random() * (5 - 1) + 1);
		}
		
		questionLabel.setText("Is " + String.valueOf(numb1) + " " + operator + " " + String.valueOf(numb2) + " = " + String.valueOf(answer) + "?");
		accuracyLabel.setText("Accuracy: " + String.valueOf(correctCount) + "/" + String.valueOf(questionCount));
	}
	
	@FXML
	private void answerYes(ActionEvent e) {
		questionCount++;
		if (answer == realAnswer) {
			correctCount++;
			responseLabel.setText("Correct!");
			responseLabel.setTextFill(Color.GREEN);
		}
		else {
			responseLabel.setText("Incorrect.");
			responseLabel.setTextFill(Color.RED);
		}
		
		setUpProblem();
	}
	

	@FXML
	private void answerNo(ActionEvent e) {
		questionCount++;
		if (answer != realAnswer) {
			correctCount++;
			responseLabel.setText("Correct!");
			responseLabel.setTextFill(Color.GREEN);
		}
		else {
			responseLabel.setText("Incorrect.");
			responseLabel.setTextFill(Color.RED);
		}
		
		setUpProblem();
	}
}
