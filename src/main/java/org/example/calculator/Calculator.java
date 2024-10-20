package org.example.calculator;

public class Calculator {
    private double operand1;
    private double operand2;
    private char operator;
    private double result;
    private boolean isError;

    public void setOperand1(double operand1) // Sets the first operand
    {
        this.operand1 = operand1;
    }
    public void setOperand2(double operand2) // Sets the second operand
    {
        this.operand2 = operand2;
    }
    public void setOperator(char operator) // Sets the arithmetic operator
    {
        this.operator = operator;
    }
    public void calculate() // Performs the calculation based on the operator
    {
        result = 0;
        switch (operator)
        {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                if (operand2 != 0) {
                    result = operand1 / operand2;
                }
                else {
                    isError = true;
                }
                break;
        }
    }
    public double getResult() // Returns the result of the operation
    {
        return result;
    }
    public boolean isError() // Returns true if an error occurred (e.g., division by zero)
    {
        return isError;
    }
    public void reset() // Resets all fields (for a new calculation)
    {
        operand1 = 0;
        operand2 = 0;
        operator = ' ';
    }
}
