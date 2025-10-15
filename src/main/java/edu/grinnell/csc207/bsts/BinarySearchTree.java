package edu.grinnell.csc207.bsts;

import java.util.List;

/**
 * A binary tree that satisifies the binary search tree invariant.
 */
public class BinarySearchTree<T extends Comparable<? super T>> {

    ///// From the reading
    /// 
    /// 
    /// 
    



    /**
     * A node of the binary search tree.
     */
    private static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        /**
         * @param value the value of the node
         * @param left the left child of the node
         * @param right the right child of the node
         */
        Node(T value, Node<T> left, Node<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        /**
         * @param value the value of the node
         */
        Node(T value) {
            this(value, null, null);
        }
    }

    private Node<T> root;

    /**
     * Constructs a new empty binary search tree.
     */
    public BinarySearchTree() {
        root = null;
    }


    /**
     * @param node the root of the tree
     * @return the number of elements in the specified tree
     */
    private int sizeH(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + sizeH(node.left) + sizeH(node.right);
        }
    }

    /**
     * @return the number of elements in this tree
     */
    public int size() {
        return sizeH(root);
    }


    /** @return the updated tree after inserting h into the given tree */
    private Node<T> insertH(T v, Node<T> cur) {
        if (cur == null) {
            return new Node<>(v);
        } else {
            if (v.compareTo(cur.value) < 0) {
                cur.left = insertH(v, cur.left);
            } else {
                cur.right = insertH(v, cur.right);
            }
            return cur;
        }
    }

    /**
     * @param value the value to add to the tree
     */
    public void insert(T value) {
        root = insertH(value, root);
    }

    ///// Part 1: Contains
   
    // If the v is equal to the value of the Node, return true. 
    // Else if v is less than the value, recursively search the left branch.
    // Else recursively search the right branch.

    /**
     * @param v the value to find
     * @return true iff this tree contains <code>v</code>
     */

    public boolean containsHelper(T v, Node<T> branch) {
        if (branch == null) {
            return false;
        } else if (v == branch.value) {
            return true;
        } else if (v.compareTo(branch.value) < 0) {
            return containsHelper(v, branch.left);
        } else {
            return containsHelper(v, branch.right);
        }
    }
    
    public boolean contains(T v) {
        return containsHelper(v, root);
    }

    ///// Part 2: Ordered Traversals

    /**
     * recursively process the left-hand subtree, visit the value at the node,
     * recursively process teh right-hand subtree.
     * @return the (linearized) string representation of this BST
     */
    @Override
    public String toString() {
        StringBuffer newBuf = new StringBuffer("[");
        if(root == null){
            return "[]";
        }
        else{
            StrHelper(newBuf, root.left);
            newBuf.append(root.value);
            StrHelper(newBuf, root.right);
            newBuf.append("]");
            return newBuf.toString();
        }
    }

    public void StrHelper(StringBuffer newBuf, Node<T> branch){
        if(branch==null){
            return;
        }

        StrHelper(newBuf, branch.left);

        newBuf.append(", "); 
        newBuf.append(branch.value); 
        StrHelper(newBuf, branch.right);
    }

    /**
     * @return a list contains the elements of this BST in-order.
     */
    public List<T> toList() {
        throw new UnsupportedOperationException();
    }

    ///// Part 3: BST Sorting

    /**
     * @param <T> the carrier type of the lists
     * @param lst the list to sort
     * @return a copy of <code>lst</code> but sorted
     * @implSpec <code>sort</code> runs in ___ time if the tree remains balanced. 
     */
    public static <T extends Comparable<? super T>> List<T> sort(List<T> lst) {
        throw new UnsupportedOperationException();
    }

    ///// Part 4: Deletion
  
    /*
     * The three cases of deletion are:
     * 1. (TODO: fill me in!)
     * 2. (TODO: fill me in!)
     * 3. (TOOD: fill me in!)
     */

    /**
     * Modifies the tree by deleting the first occurrence of <code>value</code> found
     * in the tree.
     *
     * @param value the value to delete
     */
    public void delete(T value) {
        throw new UnsupportedOperationException();
    }
}
