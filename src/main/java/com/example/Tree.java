package com.example;
public class Tree {
    private int data;
    private Tree leftNode;
    private Tree rightNode;

    // Constructor
    public Tree(int data) {
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }

    // Getters
    public int getData() {
        return data;
    }

    public Tree getLeftNode() {
        return leftNode;
    }

    public Tree getRightNode() {
        return rightNode;
    }

    // Setters
    public void setLeftNode(Tree leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Tree rightNode) {
        this.rightNode = rightNode;
    }

    // Insert a node into the binary tree
    public void insert(int value) {
        if (value < this.data) {
            if (this.leftNode == null) {
                this.leftNode = new Tree(value);
            } else {
                this.leftNode.insert(value);
            }
        } else if (value > this.data) {
            if (this.rightNode == null) {
                this.rightNode = new Tree(value);
            } else {
                this.rightNode.insert(value);
            }
        }
    }

    // Search for a node in the binary tree
    public boolean search(int value) {
        if (value == this.data) {
            return true;
        } else if (value < this.data) {
            return this.leftNode != null && this.leftNode.search(value);
        } else {
            return this.rightNode != null && this.rightNode.search(value);
        }
    }

    // Delete a node from the binary tree
    public Tree delete(Tree root, int value) {
        if (root == null) {
            return root;
        }

        if (value < root.data) {
            root.leftNode = delete(root.leftNode, value);
        } else if (value > root.data) {
            root.rightNode = delete(root.rightNode, value);
        } else {
            // Node with only one child or no child
            if (root.leftNode == null)
                return root.rightNode;
            else if (root.rightNode == null)
                return root.leftNode;

            // Node with two children: get the inorder successor (smallest in the right subtree)
            root.data = minValue(root.rightNode);

            // Delete the inorder successor
            root.rightNode = delete(root.rightNode, root.data);
        }

        return root;
    }

    // Find the minimum value in the tree (used during deletion)
    private int minValue(Tree root) {
        int minValue = root.data;
        while (root.leftNode != null) {
            minValue = root.leftNode.data;
            root = root.leftNode;
        }
        return minValue;
    }

    // In-order traversal: Left, Root, Right
    public void inorderTraversal(Tree node) {
        if (node != null) {
            inorderTraversal(node.leftNode);
            System.out.print(node.data + " ");
            inorderTraversal(node.rightNode);
        }
    }

    // Pre-order traversal: Root, Left, Right
    public void preorderTraversal(Tree node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderTraversal(node.leftNode);
            preorderTraversal(node.rightNode);
        }
    }

    // Post-order traversal: Left, Right, Root
    public void postorderTraversal(Tree node) {
        if (node != null) {
            postorderTraversal(node.leftNode);
            postorderTraversal(node.rightNode);
            System.out.print(node.data + " ");
        }
    }

    // Print the tree horizontally for better visualization
    public void printTree(Tree root, int space) {
        if (root == null) {
            return;
        }

        // Increase distance between levels
        space += 10;

        // Print the right subtree first
        printTree(root.rightNode, space);

        // Print the current node after the appropriate amount of space
        System.out.println();
        for (int i = 10; i < space; i++) {
            System.out.print(" ");
        }
        System.out.println(root.data);

        // Print the left subtree
        printTree(root.leftNode, space);
    }
}
