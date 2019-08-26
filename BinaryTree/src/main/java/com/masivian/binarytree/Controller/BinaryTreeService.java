
package com.masivian.binarytree.Controller;

/**
 *
 * @author David
 */

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.masivian.binarytree.DTO.TreeDTO;
import com.masivian.binarytree.modules.CreateTree;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/MasivianBinaryTree")
public class BinaryTreeService {
    
    private Gson gson = new Gson();
         
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response createTree(String tree){
        
        System.out.println("11111111111");
        JsonObject jsonObject = new Gson().fromJson(tree, JsonObject.class);
        System.out.println("22222222222222");
        List<Integer> nodes = new ArrayList<>();
        JsonArray jsonNodes =  jsonObject.getAsJsonArray("nodes");
        CreateTree createTree = new CreateTree();
        System.out.println("3333333333333333333333333333333333");
        for(int i=0; i< jsonNodes.size(); i++){
            nodes.add(jsonNodes.get(i).getAsInt());
        }
        System.out.println("444444444444444444444444444444444444");
        TreeDTO treeDTO = createTree.createTree(nodes);
        System.out.println("555555555555555555555555555555555");
        return Response.status(200).entity(gson.toJson(treeDTO)).build();
    }
    
    @GET
    @Produces("application/json")
    public Response lowestCommonAncestor(){
        return Response.status(200).entity("Prueba").build();
    }
}
