/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe3;

/**
 *
 * @author Kareem_29
 */

import java.util.Random;


public class TicTacToe3 {


    public static void main(String[] args) {
        Board b = new Board();//instantiate board
        Random rand = new Random();//instantiate random value
        
        b.displayBoard();//display board

        System.out.println("Who's gonna move first? (1)Computer (2)User: ");
        int choice = b.scan.nextInt();
        if(choice == 1){
            Point p = new Point(rand.nextInt(4), rand.nextInt(4));
            b.placeAMove(p, 1);
            b.displayBoard();
        }
        
        while (!b.isGameOver()) {
            System.out.println("Your move: ");
            Point userMove = new Point(b.scan.nextInt(), b.scan.nextInt());

            b.placeAMove(userMove, 2); //2 for X and X is the user
            b.displayBoard();
            if (b.isGameOver()) {
                break;
            } 
            b.callMinimax(0, 1);
            for (PointsAndScores pas : b.rootsChildrenScores) {
                System.out.println("Point: " + pas.point + " Score: " + pas.score);
            }
            b.placeAMove(b.returnBestMove(), 1);
            b.displayBoard();
        }
        if (b.hasOWon()) {
            System.out.println("Unfortunately, you lost!");
        } else if (b.hasXWon()) {
            System.out.println("You win! This is not going to get printed.");
        } else {
            System.out.println("It's a draw!");
        }
    }
    
}
