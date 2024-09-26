package com.example;

public class Main {
    public static void main(String[] args) {
        // Create a binary tree
        Tree tree = new Tree(50); // Root node

        // Insert nodes
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Print the tree structure
        System.out.println("Tree structure:");
        tree.printTree(tree, 0);

        // Perform inorder traversal
        System.out.println("\nInorder Traversal:");
        tree.inorderTraversal(tree);
        System.out.println();

        // Perform preorder traversal
        System.out.println("\nPreorder Traversal:");
        tree.preorderTraversal(tree);
        System.out.println();

        // Perform postorder traversal
        System.out.println("\nPostorder Traversal:");
        tree.postorderTraversal(tree);
        System.out.println();

        // Search for a node
        int searchValue = 60;
        boolean found = tree.search(searchValue);
        System.out.println("\nSearch for " + searchValue + ": " + (found ? "Found" : "Not Found"));

        // Delete a node
        tree.delete(tree, 70);
        System.out.println("\nAfter deleting 70:");
        tree.printTree(tree, 0);

        // After deletion, perform inorder traversal again
        System.out.println("\nInorder Traversal after deletion:");
        tree.inorderTraversal(tree);
        System.out.println();
    }
}
