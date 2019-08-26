
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
import com.masivian.binarytree.modules.SearchAncestor;
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
    @Path("/createTree")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createTree(String tree){
        
        JsonObject jsonObject = new Gson().fromJson(tree, JsonObject.class);
        List<Integer> nodes = new ArrayList<>();
        JsonArray jsonNodes =  jsonObject.getAsJsonArray("nodes");
        CreateTree createTree = new CreateTree();
        for(int i=0; i< jsonNodes.size(); i++){
            nodes.add(jsonNodes.get(i).getAsInt());
        }
        TreeDTO treeDTO = createTree.createTree(nodes);
        return Response.status(200).entity(gson.toJson(treeDTO)).build();
    }
    
    @POST
    @Path("/lowestCommonAncestor")
    @Consumes("application/json")
    @Produces("application/json")
    public Response lowestCommonAncestor(String dataRequest){
        
        JsonObject jsonObject = new Gson().fromJson(dataRequest, JsonObject.class);
        int valueA = jsonObject.get("valueA").getAsInt();
        int valueB = jsonObject.get("valueB").getAsInt();
        TreeDTO treeDTO = new Gson().fromJson(jsonObject.getAsJsonObject("tree"), TreeDTO.class);
        SearchAncestor searchAncestor = new SearchAncestor();
        int ancestor = searchAncestor.search(treeDTO.getRoot(), valueA, valueB);
        JsonObject message = new JsonObject();
        message.addProperty("Ancestro común más cercano: ", ancestor);
        return Response.status(200).entity(message.toString()).build();
    }
}
