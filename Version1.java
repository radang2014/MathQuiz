/* Version1.java
 * Purpose: The user can take a randomly generated math quiz by running the main method of this class.
 * Written by: Randy Dang
 */
import java.io.*;
import java.util.*;
public class Version1 {
    
    public static void main(String args[]) {
        //Prompt user to select a difficulty and determine range accordingly.
        System.out.println("Welcome to Math Quiz! Select a difficulty");
        System.out.println("(1 = easiest, 5 = hardest)");
        Scanner kbReader = new Scanner(System.in);
        double difficulty = kbReader.nextDouble();
        int maxNum = 101;
        if (difficulty < 1.5) {
            difficulty = 1;
            maxNum = 6;
        } else if (difficulty < 2.5) {
            difficulty = 2;
            maxNum = 11;
        } else if (difficulty < 3.5) {
            difficulty = 3;
            maxNum = 21;
        } else if (difficulty < 4.5) {
            difficulty = 4;
            maxNum = 51;
        } else  {
            difficulty = 5;
            maxNum = 101;
        }
        
        //Prompts user for number of questions.
        System.out.println("How many questions?");
        int totalQuestionCount = (int)(0.5 + kbReader.nextDouble());
        int score = 0;
        boolean nextQuestion = true;
        
        //Continue asking randomly generated math questions until the amount of questions asked matches the user
        //inputted number of questions.
        for (int i = 1; i <= totalQuestionCount; i++) {
            //Generates addends or factors and the mathematical operation of this question.
            int a = (int)(Math.random() * maxNum);
            int b = (int)(Math.random() * maxNum);
            int symbol = (int)(Math.random() * 4);
            int c = 0;
            int answer = 0;
            
            //Executes appropriate code depending on generated mathematical operation.
            if (symbol == 0) {
                answer = a + b;
                System.out.println(i + ". What is " + a + "+" + b + "?");
            } else if (symbol == 1) {
                c = a + b;
                answer = c - a;
                System.out.println(i + ". What is " + c + "-" + a + "?");
            } else if (symbol == 2) {
                answer = a * b;
                System.out.println(i + ". What is " + a + "*" + b + "?");
            } else if (symbol == 3) {
                c = a * b;
                
                //If divisor is 0, generate a new number that cannot be 0.
                if (a == 0) {
                    a = (int)(Math.random() * (maxNum - 1)) + 1;
                }
                answer = c / a;
                System.out.println(i + ". What is " + c + "/" + a + "?");
            }
            
            //Compare user inputted answer with the correct answer. Print appropriate message and adjust score as appropriate.
            //Special case: A bonus point is awarded if the question asks for 9 + 10 and the user answers 21.
            double input = kbReader.nextDouble();
            if ((a == 9 && b == 10) && (symbol == 0 && input == 21)) {
                System.out.println("Nice! Bonus point for you!");
                score += 2;
            } else if (input == answer) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was " + answer + ".");
            }
        }
        
        //Displays the question score (number of questions answered correctly) and the difficulty score (a score out of 10 
        //that depends on the difficulty that the user inputted).
        System.out.print("QUESTION SCORE: ");
        System.out.println(score + "/" + totalQuestionCount);
        System.out.print("DIFFICULTY SCORE: ");
        System.out.println((int)(2 * difficulty) + "/10");
        
        //Calculates the final score, which is the sum of the question score and the difficulty score, and displays it.
        int finalScore = score + (2 * (int)difficulty);
        int finalQuestionCount = totalQuestionCount + 10;
        System.out.print("FINAL SCORE: ");
        System.out.println(finalScore + "/" + finalQuestionCount);
        double scorePercent = (double)Math.round(((double)finalScore / finalQuestionCount) * 10000) / 100;
        System.out.println(scorePercent + "%");
        
        //Displays appropriate letter grade depending on the final score.
        String letterGrade = "";
        if (scorePercent >= 97) {
            letterGrade = "A+";
        } else if (scorePercent >= 93) {
            letterGrade = "A";
        } else if (scorePercent >= 90) {
            letterGrade = "A-";
        } else if (scorePercent >= 87) {
            letterGrade = "B+";
        } else if (scorePercent >= 83) {
            letterGrade = "B";
        } else if (scorePercent >= 80) {
            letterGrade = "B-";
        } else if (scorePercent >= 77) {
            letterGrade = "C+";
        } else if (scorePercent >= 73) {
            letterGrade = "C";
        } else if (scorePercent >= 70) {
            letterGrade = "C-";
        } else if (scorePercent >= 67) {
            letterGrade = "D+";
        } else if (scorePercent >= 63) {
            letterGrade = "D";
        } else if (scorePercent >= 60) {
            letterGrade = "D-";
        } else if (scorePercent >= 0) {
            letterGrade = "F";
        }
        System.out.println(letterGrade);
    }
}