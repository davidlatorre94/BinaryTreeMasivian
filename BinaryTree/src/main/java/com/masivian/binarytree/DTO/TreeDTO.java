
package com.masivian.binarytree.DTO;

/**
 *
 * @author David
 */
public class TreeDTO {
    
    private int value;
    
    private NodeDTO root;
    
    public TreeDTO (int value){
        this.root = new NodeDTO(value);
    }
    
    public TreeDTO (NodeDTO root){
        this.root = root;
    }
    
    
    //Getters and Setters.
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public NodeDTO getRoot() {
        return root;
    }

    public void setRoot(NodeDTO root) {
        this.root = root;
    }
    
    
    
}
