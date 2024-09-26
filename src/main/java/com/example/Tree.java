package com.example;

public class Tree {
    public int data;
    public Tree leftNode;
    public Tree rightNode;

    //constructor to initialize tree node with data
    public Tree(int data){
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }

    //getters and setters
    public int getData() {
        return data;
    }

    public Tree getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Tree leftNode) {
        this.leftNode = leftNode;
    }

    public Tree getRightNode() {
        return rightNode;
    }

    public void setRightNode(Tree rightNode) {
        this.rightNode = rightNode;
    }
    
    //inserting new node into tree (leftNode < parent < rightNode)
    public void insert(int value){
        if(value < data){ //value should be smaller than parent to enter into left node
            if(leftNode == null){ //if theres no left subtree
                leftNode = new Tree(value); //then create a left subtree
            } else{
                leftNode.insert(value); //if theres already a left subtree, then move until you find empty left subtree location
            }
        } else if (value > data){ //if value is greater its going to right node
            if(rightNode == null){
                rightNode = new Tree(value);
            } else{
                rightNode.insert(value);
            }
        }
    }
}
