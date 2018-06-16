package proj3;

import javax.swing.JOptionPane;

/**
 * <p> Title: Project #4: Math Quiz, Part 2 </p>
 *
 * <p> Description: this program generates random addition or subtraction
 * questions. After user inputs answer, the program will determine the answer
 * and let the user know the answer was correct or not. when the program ends,
 * it prompts result. </p>
 *
 * <p> Due 18 June 18 11:59 pm </p>
 *
 * @author Hamin Choi Student (N00765091@students.ncc.edu)
 */

public class Project4App {
    public static void main(String[] args) {
        //number of problems
        int num_problems = 15;

        //stores user inputs
        String[] userInputs = new String[25];

        //stores converted answers
        int[] answer = new int[25];
        int addCorrect = 0; //  number of correct answers from add problems
        int addIncorrect = 0;   //  number of incorrect answers from add problems
        int subCorrect = 0; //  number of correct answers from sub problems
        int subIncorrect = 0;   //  number of incorrect answers from sub problems
        double percentage = 0;  //  percent of correct answers
        double percentOutput = 0;   //  percent with double decimal places


        //for loop
        for (int i = 0; i < num_problems; i++) {
            Question theQuestion = new Question();

            //  it shows input dialog and stores user inputs
            userInputs[i] = JOptionPane.showInputDialog("Question #" + (i+1)
                    + ":" + "\n" + "What is the answer?" + "\n"
                    + theQuestion.toString() + " = ", 0);

            //  it converts String to integer to determine the answer is correct
            answer[i] = Integer.parseInt(userInputs[i]);

            //  this if statement determine the answer
            if (answer[i] == theQuestion.determineAnswer()  //  if add answer is correct
                    && (theQuestion.getOperator() == 0))	{
                addCorrect += 1;    //  add 1
                JOptionPane.showMessageDialog(null, "Congratulations! You got it correct!");
            }
            else if (answer[i] == theQuestion.determineAnswer() //  if sub answer is correct
                    && (theQuestion.getOperator() == 1))	{
                subCorrect += 1;
                JOptionPane.showMessageDialog(null, "Congratulations! You got it correct!");
            }
            else if	(answer[i] != theQuestion.determineAnswer()
                    && theQuestion.getOperator() == 0)	{
                addIncorrect += 1;
                JOptionPane.showMessageDialog(null, "Sorry, "
                        + theQuestion.toString() + " = " + theQuestion.determineAnswer());
            }
            else {
                subIncorrect += 1;
                JOptionPane.showMessageDialog(null, "Sorry, "
                        + theQuestion.toString() + " = " + theQuestion.determineAnswer());
            }

            //  calculate correct percentage
            percentage = 100.0 * (addCorrect + subCorrect) / (addCorrect + addIncorrect + subCorrect + subIncorrect);
            percentOutput = Double.parseDouble(String.format("%.2f", percentage));

            //  FOR EXTRA CREDIT
	//		if (addCorrect + subCorrect == 10 && i == 9)
	//			break;
	//		else if (percentage >= 80 && i >= 10)
	//			break;
	//		else num_problems = 25;
        }

        //  displays output
        JOptionPane.showMessageDialog(null, "Addition:" + "\n" + "You got "
                + addCorrect + " correct, and " + addIncorrect + " incorrect."+ "\n" + "Subtraction:" + "\n"
                + "You got " + subCorrect + " correct, and " + subIncorrect + " incorrect." + "\n"
                + "The percent correct is " + percentOutput + ".");
    }
}
