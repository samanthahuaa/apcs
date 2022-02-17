/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 * USAGE:
 * 1. Peruse. Transcribe your KtS verbiage into block comments 
 * preceding each method where necessary.
 * 2. Implement solver method.
 */

public class QueenBoard
{

  private int[][] _board;

  public QueenBoard( int size ) 
  {
    _board = new int[size][size];
  }


  /***
   * precondition: board is filled with 0's only.
   * postcondition: 
   * If a solution is found, board shows position of N queens, 
   * returns true.
   * If no solution, board is filled with 0's, 
   * returns false.
   */
  public boolean solve()
  {
    for (int i = 0; i < this._board.length; i++) {
      System.out.println(this.toString());
      if (solveH(i)) {
        return true;
      }
    }

    for (int i = 0; i < _board.length; i++) {
      for (int j = 0; j < _board.length; j++) {
        _board[i][j] = 0;
      }
    } 
    return false;
  }


  /**
   *Helper method for solve. 
   */
  private boolean solveH( int col ) 
  {
    for (int i = 0; i < this._board.length; i++) {

        if (addQueen(i, col)) {
          if (col == this._board.length - 1) {
            return true;
          }
          if (!solveH(col + 1)) {
            removeQueen(i, col);
          }
        }

    }
    removeQueen(this._board.length - 1, col);
    return false;

  }


  public void printSolution()
  {
    /** Print board, a la toString...
        Except:
        all negs and 0's replaced with underscore
        all 1's replaced with 'Q'
    */

    String ans = this.toString();
    String solution = "";
    
    for (int i = 0; i < ans.length(); i++) {
      if (ans.charAt(i) == '\n') {
        solution += "\n";
      }

      else if (ans.charAt(i) == '-') {
        solution += "_";
        i += 1;
      }

      else if (ans.charAt(i) == '\t') {
        solution += "\t";
      }

      else if (ans.charAt(i) == '1') {
        solution += "Q";
      }
      
      else {
        solution += "_";
      }

    }
    System.out.println(solution);

  }



  //================= YE OLDE SEPARATOR =================

  /***
   * A queen is added to the board and all tiles that are horizontal or diagonal
   * (to the right) of it are identified as spaces unfit for a queen with a negative
   * value (subtracted by 1). 
   *
   * precondition: Board exists
   * All cells begin with an initial value of 0
   *
   * postcondition: 
   * Adds a queen to the specified position and subtracts 1 from all positions diagonal
   * and horizontally to the right of the queen.
   * Both diagonals are accounted for (up and down)
   */
  private boolean addQueen(int row, int col)
  {
    if(_board[row][col] != 0){
      return false;
    }
    _board[row][col] = 1;
    int offset = 1;
    while(col+offset < _board[row].length){
      _board[row][col+offset]--;
      if(row - offset >= 0){
        _board[row-offset][col+offset]--;
      }
      if(row + offset < _board.length){
        _board[row+offset][col+offset]--;
      }
      offset++;
    }
    return true;
  }


  /***
   * A queen is removed from the board and all tiles that are horizontal or
   * diagonal (to the right) of it increase by 1.
   * 
   * precondition: 
   * Board exists
   * All cells begin with an initial value of 0
   *
   * postcondition:
   * Removes a queen from the specified position and adds 1 from all positions
   * diagonal and horizontally to the right of the queen.
   * Both diagonals are accounted for (up and down)
   */
  private boolean removeQueen(int row, int col){
    if ( _board[row][col] != 1 ) {
      return false;
    }
    _board[row][col] = 0;
    int offset = 1;

    while( col+offset < _board[row].length ) {
      _board[row][col+offset]++;
      if( row - offset >= 0 ) {
        _board[row-offset][col+offset]++;
      }
      if( row + offset < _board.length ) {
        _board[row+offset][col+offset]++;
      }
      offset++;
    }
    return true;
  }


  /***
   * <General description>
   * precondition: 
   * postcondition: 
   */
  public String toString()
  {
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
      for( int c = 0; c < _board[0].length; c++ ) {
        ans += _board[r][c]+"\t";
      }
      ans += "\n";
    }
    return ans;
  }


  //main method for testing...
  public static void main( String[] args )
  {
    QueenBoard b = new QueenBoard(8);

    b.solve();
  }
}//end class