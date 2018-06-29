package com.mycompany.app;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Game {

    ArrayList<String> moviesList = new ArrayList<String>();
    String chosenMovie;
    ArrayList<String> resolvedLetters = new ArrayList<String>();
    ArrayList<String> wrongLetters = new ArrayList<String>();
    int countLetters;
    

    public Game() throws Exception {
        File movies = new File("movies.txt");
        Scanner textScanner = new Scanner(movies);
        

        while(textScanner.hasNextLine()) {
            String currentLine = textScanner.nextLine();
            this.moviesList.add(currentLine);
        }
        int randomNumber = (int) (Math.random()*(this.moviesList.size()-1));
        chosenMovie = this.moviesList.get(randomNumber);
        countLetters = this.chosenMovie.length();
        for(int i=0;i<this.countLetters;i++) {
            this.resolvedLetters.add("_");
        
        }
        System.out.println("\nJava GuessTheMovie");
        System.out.println("Solution: [ "+ this.chosenMovie + " ]");
    }

    void play() {
        while(this.wrongLetters.size()<10) {
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("You are guessing: " + this.formatLetters());
            System.out.println("You have guessed ( " + this.wrongLetters.size() + " ) wrong letters " + this.wrongLetters);
            System.out.println("Guess a letter:");
            if(this.guessLetter()) {
                System.out.println("\n" +"correct");
            } else {
                System.out.println("\n" +"wrong");
            }

            if(this.end()) {
                System.out.println("You win!");
                System.out.println("\n" + this.formatLetters()+ " is the choosen movie");
                break;
            }
        }

    }

    String formatLetters() {
        String formatted = "";
        for(int i=0;i<this.countLetters;i++) {
            formatted += this.resolvedLetters.get(i) +" ";
        }
    
        return formatted;
    }

    boolean guessLetter() {
        Scanner inputScanner = new Scanner(System.in);
        String guessedLetter = inputScanner.nextLine();
        ArrayList<String> temp = new ArrayList<String>();
        if(this.chosenMovie.contains(guessedLetter)) {
            for(int i=0;i<this.countLetters;i++){
                if(Character.toString(this.chosenMovie.charAt(i)).equals(guessedLetter)) {
                    temp.add(guessedLetter);
                } else {
                    temp.add(this.resolvedLetters.get(i));
                }
            }
            this.resolvedLetters=temp;
            return true;
        } else if (!this.wrongLetters.contains(guessedLetter)) {
            this.wrongLetters.add(guessedLetter);
        }
        return false;
    }

    boolean end() {
        for(int i=0;i<this.countLetters;i++){
            if(!(Character.toString(this.chosenMovie.charAt(i)).equals(this.resolvedLetters.get(i)))) {
                return false;
            }
        
        
        }
        return true;
    }

}
