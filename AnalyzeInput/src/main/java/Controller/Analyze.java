/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.StringInput;
import View.AnalysisView;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author conch
 */
public class Analyze {
    private AnalysisView view;
    private StringInput model;
    public Analyze() {
        this.model = new StringInput();
        this.view = new AnalysisView();
    }
      public HashMap<String, List<Integer>> getNumberAnalysis(String input) {
    HashMap<String, List<Integer>> result = new HashMap<>();
    
    
    
  
StringBuilder numberBuffer = new StringBuilder();

for (int i = 0; i < input.length(); i++) {
    char c = input.charAt(i);

    if (Character.isDigit(c)) {
        numberBuffer.append(c);
    }

    // Check if the current character is not a digit OR if it's the last character in the string
    if (!Character.isDigit(c) || i == input.length() - 1) {
        if (numberBuffer.length() > 0) {
            int number = Integer.parseInt(numberBuffer.toString());
            model.allNumbers.add(number);

            double sqrt = Math.sqrt(number);
            if (sqrt == Math.floor(sqrt)) {
                model.squareNumbers.add(number);
            } 
            if (number % 2 == 0) {
                model.evenNumbers.add(number);
            } else {
                model.oddNumbers.add(number);
            }

            numberBuffer.setLength(0); // Clear the number buffer
        }
    }
}


    result.put("allNumbers", model.allNumbers);
    result.put("evenNumbers",model.evenNumbers);
    result.put("oddNumbers", model.oddNumbers);
    result.put("squareNumbers", model.squareNumbers);
    
    return result;
}

  public HashMap<String, StringBuilder> getCharacterAnalysis(String input) {
    HashMap<String, StringBuilder> result = new HashMap<>();
    
  
    for (char character : input.toCharArray()) {
           
            if (Character.isLetter(character)) {
                if (Character.isUpperCase(character)) {
                     model.allCharacters.append(character);
                    model.uppercaseCharacters.append(character);
                } else {
                     model.allCharacters.append(character);
                    model.lowercaseCharacters.append(character);
                }
            } else if (!Character.isWhitespace(character) && !Character.isDigit(character)) {
                model.specialCharacters.append(character);
            }
        }

    
    result.put("allCharacters", model.allCharacters);
    result.put("specialCharacters", model.specialCharacters);
    result.put("uppercaseCharacters", model.uppercaseCharacters);
    result.put("lowercaseCharacters", model.lowercaseCharacters);
    
    return result;
}
    public void analyzeString() {
        String input = view.getInputString();
        HashMap<String, List<Integer>> numberAnalysis = getNumberAnalysis(input);
        HashMap<String, StringBuilder> characterAnalysis = getCharacterAnalysis(input);
        int totalCharacters = input.length();

        view.displayAnalysisResults(totalCharacters, numberAnalysis, characterAnalysis);
    }
}
