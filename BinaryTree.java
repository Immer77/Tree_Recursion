package binartreestuderende;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A binary tree in which each node has two children.
 */
public class BinaryTree<E> {
    private Node root;
    private ArrayList<E> preoder = new ArrayList<>();
    private ArrayList<E> inOrder = new ArrayList<>();
    private ArrayList<E> postOrder = new ArrayList<>();

    /**
     * Constructs an empty tree.
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Constructs a tree with one node and no children.
     *
     * @param rootData the data for the root
     */
    public BinaryTree(E rootData) {
        root = new Node();
        root.data = rootData;
        root.left = null;
        root.right = null;
    }

    /**
     * Constructs a binary tree.
     *
     * @param rootData the data for the root
     * @param left     the left subtree
     * @param right    the right subtree
     */
    public BinaryTree(E rootData, BinaryTree<E> left, BinaryTree<E> right) {
        root = new Node();
        root.data = rootData;
        if (left != null) {
            root.left = left.root;
        }
        if (right != null) {
            root.right = right.root;
        }
    }

    /**
     * Checks whether this tree is empty.
     *
     * @return true if this tree is empty
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Gets the data at the root of this tree.
     *
     * @return the root data
     */
    public E data() {
        return root.data;
    }

    /**
     * Gets the left subtree of this tree.
     *
     * @return the left child of the root
     */
    public BinaryTree<E> left() {
        BinaryTree<E> result = new BinaryTree<E>();
        result.root = root.left;
        return result;
    }

    /**
     * Gets the right subtree of this tree.
     *
     * @return the right child of the root
     */
    public BinaryTree<E> right() {
        // TODO exercise 1
        BinaryTree<E> result = new BinaryTree<>();
        result.root = root.right;
        return result;

    }

    /**
     * @param rootData the new data for the root
     * @return the data previous in the root
     */
    public E replace(E rootData) {
        // TODO exercise 1
        E data = root.data;
        root.data = rootData;
        return data;

    }

    /**
     * @param n
     * @return true in n has no children
     */
    private boolean isLeaf(Node n) {
        // TODO exercise 1
        boolean result = true;
        if (n.left != null || n.right != null) {
            result = false;
        }
        return result;
    }

    /**
     * @param n
     * @return true in n has at least one child
     */
    private boolean isInternal(Node n) {
        // TODO exercise 1
        boolean result = false;
        if (n.left != null || n.right != null) {
            result = true;
        }
        return result;
    }

    /**
     * @return the number of nodes in the tree
     */
    public int size() {
        return size(root);
    }

    private int size(Node n) {
        // TODO exercise 1
        if (n == null)
            return 0;
        else
            return size(n.left) + 1 + size(n.right);
    }

    public int calcHeight() {
        return calcHeight(root);
    }

    private int calcHeight(Node n) {
        if (n == null) {
            return -1;
        } else {
            int heightleft = calcHeight(n.left) + 1;
            int heightRight = calcHeight(n.right) + 1;
            if (heightleft > heightRight) {
                return heightleft;
            }else{
                return heightRight;
            }
        }
    }

    public void preorder(){
        preorder(root);
    }
    private void preorder(Node n){
        if(n == null){
            return;
        }
        System.out.print("->" + n.data);
        //Rend igennem left child
        preorder(n.left);
        //Rend igennem right child
        preorder(n.right);
    }

    public void inorder(){
        inorder(root);
    }

    private void inorder(Node n){
        if(n == null){
            return;
        }
        //Rend igennem left child
        inorder(n.left);

        System.out.print("->" + n.data);

        //Rend igennem right child
        inorder(n.right);
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node n){
        if(n == null){
            return;
        }

        //Rend igennem left child
        postOrder(n.left);
        //Rend igennem right child
        postOrder(n.right);

        System.out.print("->" + n.data);
    }

    public ArrayList<E> preOrderToArray(){
        return preOrderToArray(root);
    }

    private ArrayList<E> preOrderToArray(Node n){
        if(n == null){
            return null;
        }

        preoder.add(n.data);

        preOrderToArray(n.left);

        preOrderToArray(n.right);

        return preoder;
    }


    public ArrayList<E> inOrderToArray(){
        return inOrderToArray(root);
    }

    private ArrayList<E> inOrderToArray(Node n){
        if(n == null){
            return null;
        }
        inOrderToArray(n.left);

        inOrder.add(n.data);

        inOrderToArray(n.right);

        return inOrder;
    }

    public ArrayList<E> postOrderToArray(){
        return postOrderToArray(root);
    }

    private ArrayList<E> postOrderToArray(Node n){

        if(n == null){
            return null;
        }
        postOrderToArray(n.left);

        postOrderToArray(n.right);

        postOrder.add(n.data);
        return postOrder;
    }

    public int sumValues(){
        return sumValues(root);
    }

    /**
     * Pre: Det skal være en integer
     * @param n
     * @return
     */
    private int sumValues(Node n){
        if(n == null){
            return 0;
        }
        return (Integer)n.data + sumValues(n.left) + sumValues(n.right);
    }



    private class Node {
        public E data;
        public Node left;
        public Node right;
    }
}

