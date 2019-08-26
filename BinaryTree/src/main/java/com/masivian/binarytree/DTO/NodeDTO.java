
package com.masivian.binarytree.DTO;

/**
 *
 * @author David
 */
public class NodeDTO {
    
    private int value;
    private NodeDTO leftChild;
    private NodeDTO rightChild;
    
    public NodeDTO (int value){
        this.value = value;
        this.leftChild = null;
    }

    
    //Getters and Setters.
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public NodeDTO getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(NodeDTO leftChild) {
        this.leftChild = leftChild;
    }

    public NodeDTO getRightChild() {
        return rightChild;
    }

    public void setRightChild(NodeDTO rightChild) {
        this.rightChild = rightChild;
    }
    
    
    
}
