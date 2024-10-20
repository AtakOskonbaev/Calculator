package org.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Objects;

public class CalculatorController {
    Calculator calc = new Calculator();
    StringBuilder currentInput = new StringBuilder(); //variable for an inputs

    @FXML
    private Label output;

    private boolean isOperand1Set = false; //checks if the first operator was set
    private boolean moreThanOneDot = false; //checks if there are more than one dot in a number

    @FXML
    protected void onNumberClick(ActionEvent event) //retrieves numbers clicked
    {
        Button clickedButton = (Button) event.getSource();
        String value = clickedButton.getText();
        currentInput.append(value);
        output.setText(currentInput.toString());
        if (!isOperand1Set) {
            calc.setOperand1(Double.parseDouble(currentInput.toString()));
        } else {
            calc.setOperand2(Double.parseDouble(currentInput.toString()));
        }
    }

    @FXML
    protected void onDotClick() //when dot clicked, you cannot add more in one number
    {
        if (!moreThanOneDot)
        {
            currentInput.append(".");
            output.setText(currentInput + ".");
            moreThanOneDot = true;
        }
    }

    @FXML
    protected void onOperatorClick(ActionEvent event) //retrieves the clicked operator
    {
        if (!currentInput.isEmpty()) //checkes if the input is empty
        {
            Button clickedButton = (Button) event.getSource();
            char value = clickedButton.getText().charAt(0);
            calc.setOperator(value);
            isOperand1Set = true;
            output.setText(value + "");
            calc.setOperator(value);
            currentInput.setLength(0);
            moreThanOneDot = false;
        }
        else
        {
            output.setText("Enter a number first!");
        }
    }

    @FXML
    protected void onEqualsClick() //shows the result
    {
        if (!calc.isError())
        {
            currentInput.setLength(0);
            calc.calculate();
            double result = calc.getResult();
            output.setText(String.valueOf(result));
        }
        else
        {
            output.setText("Wrong input!");
        }
    }

    @FXML
    protected void onClearClick() //clears variables and inputs
    {
        calc.reset();
        currentInput.setLength(0);
        output.setText("Welcome to the calculator!");
        isOperand1Set = false;
        moreThanOneDot = false;
    }
}