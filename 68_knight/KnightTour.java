// Rotating Cocoa (Perry Huang, Samantha Hua, Eric He)
// APCS pd7
// HW68 -- recursively probing for a closed cycle
// 2022-02-28m
// time spent:  hrs

/***
 * SKELETON
 * class KnightTour (and supporting class TourFinder)
 * Animates generation of a Knight's Tour on a square chess board.
 *
 * USAGE: (default N value: 8)
 * $ javac KnightTour.java
 * $ java KnightTour
 * $ java KnightTour [N]
 *
 * ALGO
 *
 * DISCO
 * By having the methods return without a boolean, we are able to remove the
 usage of if statements and boolean expressions to check whether a tour is
 finished.
 * man [COMMAND] allows you to see the manual of any command in terminal. It shows you
 what the function can do, how it's used, ways to alter/specify your command,
 and is overall very helpful in trying to understand a new command.
  ex: man time

 * QCC
 * We edited the skeleton to combine the animation stopping and the returning.
 Is there a benefit to seperating the two processes?
 *
 *
 * Mean execution times for boards of size n*n:
 * n=5   .2054s    across 10 executions
 * n=6   2.7166s    across 10 executions
 * n=7   __s    across __ executions
 * n=8   __s    across __ executions
 *
 * POSIX PROTIP: to measure execution time from BASH, use time program:
 * $ time java KnightTour 5
 *
 ***/


import java.io.*;
import java.util.*;


public class KnightTour
{
  public static void main( String[] args )
  {
    int n = 8;

    try {
      n = Integer.parseInt( args[0] );
    } catch( Exception e ) {
      System.out.println( "Invalid input. Using board size "
                          + n + "..." );
    }

    TourFinder tf = new TourFinder( n );

    //clear screen using ANSI control code
    System.out.println( "[2J" );

    //display board
    System.out.println( tf );

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //for fixed starting location, use line below:
    tf.findTour( 2, 2, 1 );
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //for random starting location, use lines below:
    // int startX = (int) Math.random() * n;
    // int startY = (int) Math.random() * n;
    // tf.findTour( startX, startY, 1 );   // 1 or 0 ?
    // We said it would be 8 so that we know how many knights are on the board
    // at a time
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // PUSHING FARTHER...
    // Systematically attempt to solve from every position on the board?
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  }//end main()

}//end class KnightTour


class TourFinder
{
  //instance vars
  private int[][] _board;
  private int _sideLength; //board has dimensions n x n
  private boolean _solved = false;

  //constructor -- build board of size n x n
  public TourFinder( int n )
  {
    _sideLength = n;

    //init 2D array to represent square board with moat
    _board = new int[_sideLength+4][_sideLength+4];

    //SETUP BOARD --  0 for unvisited cell
    //               -1 for cell in moat
    //---------------------------------------------------------
    // rows 2 to n+2 are iterated through. the first two and the last two columns
    // become -1

    for (int r = 0; r < 2; r++) {
      // iterates through the first two rows
      for (int c = 0; c < _sideLength+4; c++) {
        // iterates through all of the columns
        _board[r][c] = -1;
      }
    }

    // moat on the left and right
    for (int r = 2; r< n+2; r++) {
      // iterates through the first two rows
      for (int c = 0; c < _sideLength+4; c++) {
        if (c == 0 || c == 1 || c == n+2 || c == n+3) {
          _board[r][c] = -1;
        }
      }
    }

    // moat for the bottom two rows
    for (int r = n+2; r < _sideLength+4; r++) {
      // iterates through the first two rows
      for (int c = 0; c < _sideLength+4; c++) {
        // iterates through all of the columns
        _board[r][c] = -1;
      }
    }
    //---------------------------------------------------------

  }//end constructor


  /**
   * "stringify" the board
   **/
  public String toString()
  {
    //send ANSI code "ESC[0;0H" to place cursor in upper left
    String retStr = "[0;0H";
    //emacs shortcut: C-q, then press ESC
    //emacs shortcut: M-x quoted-insert, then press ESC

    int i, j;
    for( i=0; i < _sideLength+4; i++ ) {
      for( j=0; j < _sideLength+4; j++ )
        retStr = retStr + String.format( "%3d",  _board[j][i] );
      //"%3d" allots 3 spaces for each number
      retStr = retStr + "\n";
    }
    return retStr;
  }


  /**
   * helper method to keep try/catch clutter out of main flow
   * @param n      delay in ms
   **/
  private void delay( int n )
  {
    try {
      Thread.sleep(n);
    } catch( InterruptedException e ) {
      System.exit(0);
    }
  }


  /**
   * void findTour(int x,int y,int moves) -- use depth-first w/ backtracking algo
   * to find valid knight's tour
   * @param x      starting x-coord
   * @param y      starting y-coord
   * @param moves  number of moves made so far
   **/
  public void findTour( int x, int y, int moves )
  {
    // delay(50); //slow it down enough to be followable

    //primary base case: tour completed
    if ( moves == _sideLength*_sideLength && _board[x][y] == 0) {
      _board[x][y] = moves;
      System.out.println( this ); //refresh screen
      // if a tour has been completed, stop animation
      System.exit(0);
      return;
    }

    //other base case: stepped off board or onto visited cell
    if ( _board[x][y] != 0 ) {
      return;
    }
    // otherwise, mark current location
    // and recursively generate tour possibilities from current pos
    else {

      //mark current cell with current move number
      _board[x][y] = moves;

      System.out.println( this ); //refresh screen

      // delay(1000); //uncomment to slow down enough to view

      /******************************************
       * Recursively try to "solve" (find a tour) from
       * each of knight's available moves.
       *     . e . d .
       *     f . . . c
       *     . . @ . .
       *     g . . . b
       *     . h . a .
      ******************************************/
      findTour(x+1, y-2,moves+1); // a
      findTour(x+2, y-1,moves+1); // b
      findTour(x+2, y+1,moves+1); // c
      findTour(x+1, y+2,moves+1); // d
      findTour(x-1, y+2,moves+1); // e
      findTour(x-2, y+1,moves+1); // f
      findTour(x-2, y-1,moves+1); // g
      findTour(x-1, y-2,moves+1); // h

      //If made it this far, path did not lead to tour, so back up...
      // (Overwrite number at this cell with a 0.)
      _board[x][y] = 0;

      System.out.println( this ); //refresh screen

    }
  }//end findTour()

}//end class TourFinder
