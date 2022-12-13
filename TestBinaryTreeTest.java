package binartreestuderende;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TestBinaryTreeTest {
    BinaryTree<Integer> fifteen;
    BinaryTree<Integer> twentyFive;
    BinaryTree<Integer> eightyEight;
    BinaryTree<Integer> eleven;
    BinaryTree<Integer> thirty;
    BinaryTree<Integer> ninety;
    BinaryTree<Integer> twentyTwo;
    BinaryTree<Integer> seventySeven;
    BinaryTree<Integer> root;

    @BeforeEach
    void setUp() {
        fifteen = new BinaryTree<>(15,null,null);
        twentyFive = new BinaryTree<>(25,null,null);
        eightyEight = new BinaryTree<>(88,null,null);
        eleven = new BinaryTree<>(11,null,fifteen);
        thirty = new BinaryTree<>(30,twentyFive,null);
        ninety = new BinaryTree<>(90,eightyEight,null);
        twentyTwo = new BinaryTree<>(22,eleven,thirty);
        seventySeven = new BinaryTree<>(77,null,ninety);
        root = new BinaryTree<Integer>(45, twentyTwo,seventySeven);
    }

    @Test
    void testSize(){
        // Arrange & Act
        assertEquals(9,root.size());
    }

    @Test
    void testHeight(){
        //Act & Assert
        int actualHeight = root.calcHeight();
        assertEquals(3,actualHeight);
    }

    @Test
    void testPreOrder(){
        System.out.println("\nPreorder  Expected ->45->22->11->15->30->25->77->90->88");
        System.out.print("Preorder Actual ");
        root.preorder();


        System.out.println("\n");
        System.out.println("Inorder Expected ->11->15->22->25->30->45->77->88->90");
        System.out.print("Inorder Actual ");
        root.inorder();

        System.out.println("\n");
        System.out.println("PostOrder Expected ->15->11->25->30->22->88->90->77->45");
        System.out.print("PostOrder Actual ");
        root.postOrder();
    }

    @Test
    void arraySortPreorder() {
        ArrayList<Integer> expectedPreOrder = new ArrayList<>(Arrays.asList(45, 22, 11, 15, 30, 25, 77, 90, 88));
        assertEquals(expectedPreOrder,root.preOrderToArray());
        ArrayList<Integer> expectedInOrder = new ArrayList<>(Arrays.asList(11, 15, 22, 25, 30, 45, 77, 88, 90));
        assertEquals(expectedInOrder,root.inOrderToArray());
        ArrayList<Integer> expectedPostOrder = new ArrayList<>(Arrays.asList(15, 11, 25, 30, 22, 88, 90, 77, 45));
        assertEquals(expectedPostOrder,root.postOrderToArray());
    }

    @Test
    void testOfSumValues(){
        int expected = 403;
        assertEquals(expected,root.sumValues());
    }
}