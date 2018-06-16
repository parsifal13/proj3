package proj3;

import java.util.Random;

/**
 * <p>Title: The Question class</p>
 *
 * <p>Description: This class will represent a single math problem
 * that can be addition or subtraction. Operands will be also randomly
 * generated within given range. It also provides the answer of the problem
 * </p>
 *
 * @author Hamin Choi Student (N00765091@students.ncc.edu)
 */

public class Question {
    //instance variables
    private int firstOperand = 0;
    private int secondOperand = 0;
    private int operator;

    /**
     * Question method -- default constructor. it generates random integer number
     * within given range to determine operands and operator.
     */

    public Question() {
        Random random = new Random();
        operator = random.nextInt(2); //decide the operator of the problem
        if(operator == 0) { // if operator = 0, question type = addition
            firstOperand = random.nextInt(12) + 1; // 0 =< firstOperand =< 12
            secondOperand = random.nextInt(12) + 1; // 0 =< secondOperand =< 12
        }
        else
            if (operator == 1) { // if operator = 1, question type = subtraction
            firstOperand = random.nextInt(7) + 6; // 6 =< firstOperand =< 12
            secondOperand = random.nextInt(firstOperand); // 0 =< secondOperand < firstOperand
        }
    }

    /**
     * toString method -- this method returns the state of the question object
     * @return a reference to a String object that contains the value of
     * firstOperand, secondOperand and operator
     */

    public String toString() {
        String returnMe = null;
        if(operator == 0) { // if the question type is addition
            returnMe = (firstOperand + " + " + secondOperand);
        }
        else
            if(operator == 1) { // if the question type is subtraction
                returnMe = (firstOperand + " - " + secondOperand);
            }
        return returnMe;
    }

    /**
     * determineAnswer method -- this method will calculate random operands
     * based on the operator decided
     * @return the sum of two operands
     */

    public int determineAnswer() {
        int returnMe = 0;
        if(operator == 0) { // if the question type is addition
            returnMe = (firstOperand + secondOperand);
        }
        else
            if(operator == 1) { // if the question type is subtraction
                returnMe = (firstOperand - secondOperand);
            }
        return returnMe;
    }

    /**
     * determineOperator method -- this method will determine operator
     * whether addition or subtraction
     * @return true if operator is add, false otherwise
     */

    public boolean determineOperator() {
        boolean returnMe = false;
        if(operator == 0) // if the question type is addition
            returnMe = true;
        else
        if(operator == 1) // if the question type is subtraction
            returnMe = false;
        return returnMe;
    }
}
