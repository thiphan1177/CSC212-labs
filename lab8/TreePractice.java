/**
 *
 * TreePractice class to practice the 3 recursive methods
 * @author Thao Phan, CSC212
 * @version 30 March 2017
 */
public class TreePractice {
    public static void main(String[] args) {
        BinaryTree<Double> t1 = new BinaryTree<Double>(4.0);
        t1.setLeft( new BinaryTree<Double>(3.5) );
        t1.setRight( new BinaryTree<Double>(5.5) );
        t1.getLeft();
        t1.getLeft().setLeft( new BinaryTree<Double>(1.25) );
        t1.getLeft().setRight( new BinaryTree<Double>(3.75) );
        t1.getRight().setLeft( new BinaryTree<Double>(4.75));
        t1.getRight().setRight( new BinaryTree<Double>(8.5));
        t1.getRight().getRight().setLeft( new BinaryTree<Double>(7.0) );
        t1.getRight().getRight().setRight( new BinaryTree<Double>(13.0));

        System.out.println( "t1 tree :" );
        t1.print();

        System.out.println( "print1 method :" );
        t1.print1(t1);

        System.out.println( "print2 method :" );
        t1.print2(t1);

        System.out.println( "print3 method :" );
        t1.print3(t1);


    }
}
