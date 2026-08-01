// Chapter 4: Java Basics
// Topic: variables, conditionals, loops, methods, and inheritance --
// framed through a small Android-style scoring example.

/*
 UNSOLVED (exercise) -- will NOT compile.
 Task: two bugs. (1) a loop variable is used outside its scope.
 (2) a method is called with the wrong number of arguments.

 public class ScoreTrackerExercise {
     void printAllScores(int[] scores) {
         for (int i = 0; i < scores.length; i++) {
             int current = scores[i];
         }
         System.out.println(current);       // <-- bug: current is out of scope here

         addBonus(current);                 // <-- bug: addBonus needs 2 args
     }

     int addBonus(int score, int bonus) {
         return score + bonus;
     }
 }
*/

// SOLVED
package com.codingcompany.androidbeginners.ch04;

import java.util.ArrayList;
import java.util.List;

public class ScoreTracker {

    private final List<Integer> scores = new ArrayList<>();
    private boolean roundInProgress = false;

    void startRound() {
        roundInProgress = true;
    }

    void recordScore(int points) {
        if (!roundInProgress) {
            System.out.println("No round in progress -- ignoring score.");
            return; // early return: a common Android pattern for guard clauses
        }
        scores.add(points);
    }

    void endRound() {
        roundInProgress = false;
    }

    int total() {
        int sum = 0;
        for (int score : scores) { // enhanced for-loop
            sum += score;
        }
        return sum;
    }

    int addBonus(int score, int bonus) {
        return score + bonus;
    }

    void printAllScores() {
        for (int i = 0; i < scores.size(); i++) {
            int current = scores.get(i); // 'current' is scoped to this loop iteration
            System.out.println("Score #" + i + ": " + current);
        }
        System.out.println("Total: " + total());
    }

    // Inheritance: a specialized tracker that adds a difficulty multiplier.
    static class BonusScoreTracker extends ScoreTracker {
        private final double multiplier;

        BonusScoreTracker(double multiplier) {
            this.multiplier = multiplier;
        }

        @Override
        void recordScore(int points) {
            super.recordScore((int) (points * multiplier));
        }
    }

    public static void main(String[] args) {
        ScoreTracker tracker = new BonusScoreTracker(1.5);
        tracker.startRound();
        tracker.recordScore(10);
        tracker.recordScore(20);
        tracker.endRound();
        tracker.printAllScores(); // shows the 1.5x multiplier applied
    }
}
