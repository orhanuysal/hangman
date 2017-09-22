/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hangman;

import java.util.Arrays;
import sun.rmi.runtime.Log;

/**
 *
 * @author ASUS
 */
public class Hangman {
    
    //Ascii value of the 'a'
    private final int asciiValueOfTheChara = 97;
    //Ascii value of the 'z'
    private final int asciiValueOfTheCharz = 122;
    
    private String secretWord;
    private String allLetters;
    private String usedLetters;
    private int numberOfIncorrectTries;
    private int maxAllowedIncorrectTries;
    private char[] knownSoFar;
    
    public Hangman(){
        secretWord = chooseSecretWord();
        allLetters = createAllLetters();
        knownSoFar = new char[secretWord.length()];
        usedLetters = "";
        maxAllowedIncorrectTries = 6;
    }
    
    private String createAllLetters(){
        String letters = "";
        
        for(int i = asciiValueOfTheChara; i <= asciiValueOfTheCharz; i++){
            letters += (char) i;
        }
        
        
        return letters;
    }
    
    private String chooseSecretWord(){
        return "asaa";
    }
    
    public void tryLetters(char letter){
        if(usedLetters.contains(letter + "")){
            System.out.println("Already used");
        }else{
            for(int i = 0 ; i < secretWord.length(); i++){
                
                if(secretWord.charAt(i) == letter){
                    knownSoFar[i] = letter;
                }
                
            }
            printTheTurn();
        }
    }
    
    public void printTheTurn(){
        boolean isFound = false;
        for(char digit: knownSoFar){
            if(Character.isLetter(digit)){
                System.out.print(digit + " ");
                isFound = true;
            }else{
                System.out.print("_ ");
            }
        }
        if(isFound){
            System.out.println();  
        }else{
            System.out.println("Not found");    
            numberOfIncorrectTries++;
        }
    }
    public void checkGameIsOver(){
        
    }
    
    public void checkFailed(){
        
    }
    
    public boolean checkWordFound(){
        if(knownSoFar.length != secretWord.length()){
            return false;
        }
        //Since knownSoFar.length == secretWord.length()
        for(int i = 0; i < knownSoFar.length; i++){
            if(knownSoFar[i] != secretWord.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
