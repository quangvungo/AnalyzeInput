/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author conch
 */
public class AnalysisView {
      public void displayAnalysisResults(int totalCharacters, HashMap<String, List<Integer>> numberAnalysis,
                                       HashMap<String, StringBuilder> characterAnalysis) {
        System.out.println("Number of characters in the string: " + totalCharacters);

    System.out.println("All characters: " + characterAnalysis.get("allCharacters").toString());
    System.out.println("Uppercase characters: " + characterAnalysis.get("uppercaseCharacters").toString());
    System.out.println("Lowercase characters: " + characterAnalysis.get("lowercaseCharacters").toString());

    List<Integer> allNumbers = numberAnalysis.get("allNumbers");
    List<Integer> evenNumbers = numberAnalysis.get("evenNumbers");
    List<Integer> oddNumbers = numberAnalysis.get("oddNumbers");
    List<Integer> squareNumbers = numberAnalysis.get("squareNumbers");

    System.out.println("All Numbers: " + allNumbers.toString());
    System.out.println("Even Numbers: " + evenNumbers.toString());
    System.out.println("Odd Numbers: " + oddNumbers.toString());
    System.out.println("Perfect Square Numbers: " + squareNumbers.toString());

    System.out.println("Special Characters: " + characterAnalysis.get("specialCharacters").toString());    }

    public String getInputString() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        return scanner.nextLine();
    }
}
