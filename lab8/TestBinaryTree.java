/**
 * test class for BinaryTree
 *
 * @author Thao Phan, CSC212
 * @version 30 March 2017
 */
public class TestBinaryTree {
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


        // System.out.println( "Root: "+t1.getData() );
        // System.out.println( "Left: "+t1.getLeft().getData() );
        // System.out.println( "Left: "+t1.getLeft().getLeft().getData() );
        //
        // System.out.println( "Right: "+t1.getLeft().getRight().getData() );
        // System.out.println( "Right: "+t1.getRight().getData() );
        // System.out.println( "Left: "+t1.getRight().getLeft().getData() );
        // System.out.println( "Right: "+t1.getRight().getRight().getData() );
        //
        //
        // System.out.println( "Root: "+t1.getRight().getRight().getLeft().getData() );
        // System.out.println( "Left: "+t1.getRight().getRight().getRight().getData() );


        // deep copy
        BinaryTree<Double> t2 = new BinaryTree<Double>(t1);
        t2.setData( -1.0 );

        System.out.println( "t1 tree printed again :" );
        t1.print();

        System.out.println( "t2 tree :" );
        t2.print();


        //reference copy
        BinaryTree<Double> t3 = t1;

        t3.getRight().setRight( new BinaryTree<Double>(6.25) );

        System.out.println( "t1 tree printed again after changing something in t3 tree:" );
        t1.print();
        BinaryTree<Double> t4 = new BinaryTree<Double>(0.0);
        t4.setLeft(t1);
        t4.setRight(t1);
        System.out.println("t4 tree: ");
        t4.print();

        System.out.println( "t1 tree printed again :" );
        t1.print();

        //change element in t1
        t1.getRight().getRight().setLeft( new BinaryTree<Double>(999.0) );

        System.out.println("t1 tree again: ");
        t1.print();

        System.out.println("t4 tree again: ");
        t4.print();




    }
}
