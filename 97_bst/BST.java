/**
 * class BST
 * v1:partial
 * SKELETON
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT)
 *
 * A BST maintains the invariant that, for any node N with value V,
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value,
 *  and any value in its right subtree must be greater.)
 *
 * This BST implementation only holds ints (its nodes have int cargo)
 */

import java.util.LinkedList;

public class BST
{

  //instance variables / attributes of a BST:
  TreeNode _root;

  /**
   * default constructor
   */
  BST()
  {
    _root = null;
  }


  /**
   * void insert( int )
   * Adds a new data element to tree.
   */
  public void insert( int newVal )
  {
    TreeNode newNode = new TreeNode( newVal );
    if (_root == null){
      _root = newNode;
    }
    insert(_root, newNode);
  }

  //recursive helper for insert(int)
  public void insert( TreeNode stRoot, TreeNode newNode )
  {
    if (stRoot.getValue() > newNode.getValue()) {
      if (stRoot.getLeft() == null) {
        stRoot.setLeft(newNode);
        return;
      }
      insert(stRoot.getLeft(), newNode);
    }
    else if (stRoot.getValue() < newNode.getValue()) {
      if (stRoot.getRight() == null) {
        stRoot.setRight(newNode);
        return;
      }
      insert(stRoot.getRight(), newNode);
    }
  }//end insert()




  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

  // each traversal should simply print to standard out
  // the nodes visited, in order

  //process root, recurse left, recurse right
  public void preOrderTrav()
  {
    preOrderTrav( _root );
  }
  public void preOrderTrav( TreeNode currNode )
  {
    System.out.print(currNode.getValue());
    if (currNode.getLeft() != null) {
      preOrderTrav(currNode.getLeft());
    }
    if (currNode.getRight() != null) {
      preOrderTrav(currNode.getRight());
    }
    return;
  }

  //recurse left, process root, recurse right
  public void inOrderTrav()
  {
    if (_root.getLeft() != null) {
      inOrderTrav( _root.getLeft() );
    }
    System.out.print(_root.getValue());
    if (_root.getRight() != null) {
      inOrderTrav( _root.getRight() );
    }
  }
  public void inOrderTrav( TreeNode currNode )
  {
    if (currNode.getLeft() != null) {
      preOrderTrav(currNode.getLeft());
    }
    System.out.print(currNode.getValue());
    if (currNode.getRight() != null) {
      preOrderTrav(currNode.getRight());
    }
    return;
  }

  //recurse left, recurse right, process root
  public void postOrderTrav()
  {
    if (_root.getLeft() != null) {
      postOrderTrav( _root.getLeft() );
    }
    if (_root.getRight() != null) {
      postOrderTrav( _root.getRight() );
    }
    System.out.print(_root.getValue());
  }
  public void postOrderTrav( TreeNode currNode )
  {
    if (currNode.getLeft() != null) {
      preOrderTrav(currNode.getLeft());
    }
    if (currNode.getRight() != null) {
      preOrderTrav(currNode.getRight());
    }
    System.out.print(currNode.getValue());
    return;
  }

 /*****************************************************
   * TreeNode search(int)
   * returns pointer to node containing target,
   * or null if target not found
   *****************************************************/
  public TreeNode search( int target )
  {
    TreeNode temp = searchR(_root, target);
    return temp;
  }

  TreeNode searchR(TreeNode currNode, int target) {
    if (currNode.getValue() == target) {
      return currNode;
    }
    else if (currNode.getValue() > target) {
      if (currNode.getLeft() != null) {
        return searchR(currNode.getLeft(), target);
      }
      else {
        return null;
      }
    }
    else if (currNode.getValue() < target) {
      if (currNode.getRight() != null) {
        return searchR(currNode.getRight(), target);
      }
      else {
        return null;
      }
    }
    return currNode;
  }

  public TreeNode parent(int target) {
    TreeNode temp = searchR(_root, target);
    return temp;
  }

  public TreeNode parentR(TreeNode currNode, int target) {
    if ((currNode.getLeft()).getValue() == target || (currNode.getRight()).getValue() == target) {
      return currNode;
    }
    else if ((currNode.getLeft()).getValue() > target) {
      if (currNode.getLeft() != null) {
        return parentR(currNode.getLeft(), target);
      }
      else {
        return null;
      }
    }
    else if ((currNode.getRight()).getValue() < target) {
      if (currNode.getRight() != null) {
        return searchR(currNode.getRight(), target);
      }
      else {
        return null;
      }
    }
    return currNode;
  }
  /*****************************************************
   * int height()
   * returns height of this tree (length of longest leaf-to-root path)
   * eg: a 1-node tree has height 1
   *****************************************************/
  public int height()
  {
    int a = heightL(_root);
    int b = heightR(_root);
    if (a > b) {
      return a;
    }
    else {
      return b;
    }
  }

  public int height(TreeNode x) {
    int a = heightL(x);
    int b = heightR(x);
    if (a > b) {
      return a;
    }
    else {
      return b;
    }
  }

  public int heightL(TreeNode currNode) {
    if (currNode.getLeft() != null) {
      return 1 + heightL(currNode.getLeft());
    }
    return 1;
  }

  public int heightR(TreeNode currNode) {
    if (currNode.getRight() != null) {
      return 1 + heightR(currNode.getRight());
    }
    return 1;
  }
  /*****************************************************
   * int numLeaves()
   * returns number of leaves in tree
   *****************************************************/
  // public int numLeaves()
  // {
  //   return numLeavesR(_root);
  // }
  //
  // public int numLeavesR(TreeNode currNode) {
  //   int foo = 0;
  //   if ( currNode == null )
  //     return 0;
  //   foo += numLeaves( currNode.getLeft() );
  //   if ( isLeaf(currNode) )
  //     foo++;
  //   foo += numLeaves( currNode.getRight() );
  //   return foo;
  // }

  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  public void remove(int a) {
    TreeNode target = search(a);
    TreeNode piggyBack = parent(a);
    remove(target, piggyBack);
  }

  public void remove(TreeNode target, TreeNode piggyBack) {
    int left = 0;
    int right = 0;

    // check the height of the left branch
    if (target.getLeft() != null) {
      left = height(target.getLeft());
    }
    //check the height of the right branch
    if (target.getRight() != null) {
      right = height(target.getRight());
    }

    // case 1 : no children
    if (left == 0 && right == 0) {
      if (piggyBack.getValue() > target.getValue()) {
        piggyBack.setLeft(null);
      } else {
        piggyBack.setRight(null);
      }
    }
    // case 2 : 1 child on the left
    else if (left == 1) {
      piggyBack.setLeft(target.getLeft());
    }
    // case 2 : 1 child on right
    else if (right == 1) {
      piggyBack.setRight(target.getRight());
    }
    // case 3 : 2 children
    else {
      if (left > right) {
        remove(target.getRight(), piggyBack.getRight());
      }
      else {
        remove(target.getLeft(), piggyBack.getLeft());
      }
    }
    return;
  }

  public String toString(){
            LinkedList<TreeNode> q = new LinkedList<TreeNode>();
            q.add(_root);
            return toString(q,1,this.height());
        }


      String toString(LinkedList<TreeNode> printQueue,int layerNum,int height){
          if (height==0){return "";}
          int printLen = printQueue.size();
          int initialSpace = (int) Math.pow(2,height-layerNum)-1;
          String thisLayer = "";
          for (int sp = 0;sp<initialSpace;sp++)
              thisLayer+=" ";
          for (int i = 0; i<printLen;i++){
              TreeNode item = printQueue.removeFirst();
              if (item ==null){
                  thisLayer+=" ";
                  printQueue.addLast(null);
                  printQueue.addLast(null);
              } else {
                  thisLayer+=item.getValue();
                  printQueue.addLast(item.getLeft());
                  printQueue.addLast(item.getRight());
              }
              for (int sp = 0;sp<2*initialSpace+1;sp++)
                  thisLayer+=" ";
          }
          if (layerNum==height){return thisLayer;}
          else {
              return thisLayer+"\n"+toString(printQueue,layerNum+1,height);
          }
  }


  //main method for testing
  public static void main( String[] args ) {

    BST arbol = new BST();

    //huh? if it's init'd shouldn't it have a null value? that creates an error
    // System.out.println( "tree init'd: " + arbol );

    //inserting in this order will build a perfect tree
    arbol.insert( 3 );
    arbol.insert( 1 );
    arbol.insert( 0 );
    arbol.insert( 2 );
    arbol.insert( 5 );
    arbol.insert( 4 );
    arbol.insert( 6 );
    /*
    */

    //insering in this order will build a linked list to left

    arbol.insert( 6 );
    arbol.insert( 5 );
    arbol.insert( 3 );
    arbol.insert( 4 );
    arbol.insert( 2 );

    System.out.println( "tree after insertions:\n" + arbol );
    System.out.println();

    System.out.println();
    for( int i=-1; i<8; i++ ) {
        System.out.println(" searching for "+i+": " + arbol.search(i) );
    }

    System.out.println();
    System.out.println();
    System.out.println( arbol );

    arbol.remove(5);
    System.out.println();
    System.out.println( arbol );

    arbol.remove(4);
    System.out.println();
    System.out.println( arbol );

    arbol.remove(3);
    System.out.println();
    System.out.println( arbol );
    System.out.println();
    arbol.remove(1);
    System.out.println();
    System.out.println( arbol );

    arbol.remove(0);
    System.out.println();
    System.out.println( arbol );
  }

}//end class

