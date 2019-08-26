
package com.masivian.binarytree.DTO;

/**
 *
 * @author David
 */
public class TreeDTO {
    
    private NodeDTO root;
    
    public TreeDTO (NodeDTO root){
        this.root = root;
    }
    
    
    //Getters and Setters.
    public NodeDTO getRoot() {
        return root;
    }

    public void setRoot(NodeDTO root) {
        this.root = root;
    }
    
    
    
}
