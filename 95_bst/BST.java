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

  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  //main method for testing
  public static void main( String[] args )
  {

      BST arbol = new BST();

      //PROTIP: sketch state of tree after each insertion
      //        ...BEFORE executing these.
      arbol.insert( 4 );
      arbol.insert( 2 );
      arbol.insert( 5 );
      arbol.insert( 6 );
      arbol.insert( 1 );
      arbol.insert( 3 );


      System.out.println( "\n-----------------------------");
      System.out.println( "pre-order traversal:" ); //421356
      arbol.preOrderTrav();

      System.out.println( "\n-----------------------------");
      System.out.println( "in-order traversal:" ); //123456
      arbol.inOrderTrav();

      System.out.println( "\n-----------------------------");
      System.out.println( "post-order traversal:" ); //132654
      arbol.postOrderTrav();

      System.out.println( "\n-----------------------------");
      /*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class
