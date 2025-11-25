package com.mycompany.csc229_bst_example;
/**
 *
 * @author MoaathAlrajab
 */
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private BstNode root;

    public boolean isEmpty() {
        return (this.root == null);
    }

    public void insert(Integer data) {

        System.out.print("[input: " + data + "]");
        if (root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }
        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    private BstNode insertNode(BstNode root, Integer data) {

        BstNode tmpNode = null;
        System.out.print(" ->" + root.getData());
        if (root.getData() >= data) {
            System.out.print(" [L]");
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print(" [R]");
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
        return insertNode(tmpNode, data);
    }

    public void inOrderTraversal() {
        doInOrder(this.root);
    }

    private void doInOrder(BstNode root) {
        if (root == null) return;
        //This part of the program will traverse to the left and right sides of the tree.
        doInOrder(root.getLeft());
        //This part will find the node, and travel to it.
        System.out.print(root.getData() + " ");
        doInOrder(root.getRight());
        // ToDo 1: complete InOrder Traversal
    }

    public void preOrderTraversal() {
        doPreOrder(this.root);

        // ToDo 2: complete the pre-order travesal .
    }

    private void doPreOrder(BstNode root) {
        if (root == null) return;
        //This will travel to the node.
        System.out.print(root.getData() + " ");
        //These two, similar to above, will traverse to the left and right sides of the tree.
        doPreOrder(root.getLeft());
        doPreOrder(root.getRight());
    }

    public Integer findHeight() {
        //this part of the program will call the recursive method, that begins atr the root.
        return height(this.root);
        // ToDo 3: Find the height of a tree
    }

    private int height(BstNode root) {
        //The Base case: empty subtree ->height = -1
        //This also ensures a node ends up with height = 0
        if (root == null) return -1; // height of empty tree = -1
        return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
    }


    public int getDepth(BstNode node) {
        return depthHelper(this.root, node, 0);
        //ToDo 4: complete getDepth of a node
    }

    private int depthHelper(BstNode current, BstNode target, int depth) {
        if (current == null) return -1; //If the node isn't found
        if (current == target) return depth;
        //The left side will be searched
        int left = depthHelper(current.getLeft(), target, depth + 1);
        if (left != -1) return left;
        //The right side will be searched
        return depthHelper(current.getRight(), target, depth + 1);
    }

    public void print() {
        System.out.println("\n==== BST Print ===== \n");

        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        Queue<BstNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BstNode current = queue.poll();

            //This will print the value of the node.
            System.out.print(current.getData() + " ");

            //This will add to the queue.
            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }

        System.out.println();
    }
}
