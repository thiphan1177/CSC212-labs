/**
*  Implements binary trees.
*
*  @author  Nicholas R. Howe, Thao Phan
*  @version CSC 212, 3 April 2017
*/
public class BinaryTree<E> {
  /** The value at this node */
  private E data;

  /** Left child of this node */
  private BinaryTree<E> left;

  /** Right child of this node */
  private BinaryTree<E> right;

  /** This constructor creates a leaf node */
  public BinaryTree(E data) {
    this.data = data;
    left = right = null;
  }

  /** This constructor creates a branch node */
  public BinaryTree(E data, BinaryTree<E> left, BinaryTree<E> right) {
    this.data = data;
    this.right = right;
    this.left = left;
  }

  /** This constructor creates a deep copy of the entire tree structure */
  public BinaryTree(BinaryTree<E> tree) {
    this.data = tree.data;
    this.left = (tree.left == null)? null:(new BinaryTree<E>(tree.left));
    this.right = (tree.right == null)? null:(new BinaryTree<E>(tree.right));
  }

  /** Accessor for node data*/
  public E getData() {  // FILL IN RETURN TYPE
    return data;
  }

  /** Accessor for left child */
  public BinaryTree<E> getLeft() {  // FILL IN RETURN TYPE
    return left;
  }

  /** Accessor for right child */
  public BinaryTree<E> getRight() {  // FILL IN RETURN TYPE
    return right;
  }

  /** Manipulator for node data */
  public void setData(E data) {  // FILL IN ARGUMENT TYPE
    this.data = data;
  }

  /** Manipulator for left child */
  public void setLeft(BinaryTree<E> left) {  // FILL IN ARGUMENT TYPE
    this.left = left;
  }

  /** Manipulator for right child */
  public void setRight(BinaryTree<E> right) {  // FILL IN ARGUMENT TYPE
    this.right = right;
  }

  /** Determines whether a tree is empty */
  public static boolean isEmpty(BinaryTree node) {
    return (node == null);
  }

  /** Determines whether this tree is a leaf */
  public boolean isLeaf() {
    return (left == null && right == null);
    // checks if BinaryTree<E> t has children. If left & right == null, then it's a leaf.
    //Else, it's a branch with kids.
    //Note: A branch always has 2 kids. A leaf has none (aka, it's kids are null)
  }

  /** Determines whether this tree is a branch */
  public boolean isBranch() {
    return (left != null && right != null);
    //checks if BinaryTree<E> t has children. If left & right != null, then it has children and is a branch.
    // else, it's a leaf.
  }

  /**
  *  Indents by the specified number of spaces
  *
  *  @param n  Number of spaces
  */
  private static void indent(int n) {
    for (int i = 0; i < n; i++) {
      System.out.print(' ');
    }
  }

  /** Prints the tree nodes with indentation indicating level */
  public void print() {
    System.out.print("Root:  ");
    printIndented(0);
  }

  /** Simple recursive routine to print a tree */
  public static void print1(BinaryTree tree) {
    if (tree != null) {
      System.out.println(tree.data);
      print1(tree.left);
      print1(tree.right);
    }
  }


  /** Simple recursive routine to print a tree */
  public static void print2(BinaryTree tree) {
    if (tree != null) {
      print2(tree.left);
      System.out.println(tree.data);
      print2(tree.right);
    }
  }


  /** Simple recursive routine to print a tree */
  public static void print3(BinaryTree tree) {
    if (tree != null) {
      print3(tree.left);
      print3(tree.right);
      System.out.println(tree.data);

    }
  }

  /**
  *  Prints the tree with indentation corresponding to level.
  *  Basically a fancy version of preorder.
  *
  *  @param depth  Level of this node, for indentation
  */
  public void printIndented(int depth) {
    System.out.println(data);
    depth++;
    if (left != null) {
      indent(2*depth);
      System.out.print("Left:  ");
      left.printIndented(depth);
    }
    if (right != null) {
      indent(2*depth);
      System.out.print("Right:  ");
      right.printIndented(depth);
    }
  }
}
