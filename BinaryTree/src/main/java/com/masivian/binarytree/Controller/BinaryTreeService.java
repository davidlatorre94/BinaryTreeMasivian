package com.masivian.binarytree.Controller;

/**
 *
 * @author David
 */
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.masivian.binarytree.DTO.TreeDTO;
import com.masivian.binarytree.modules.CreateTree;
import com.masivian.binarytree.modules.SearchAncestor;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/MasivianBinaryTree")
public class BinaryTreeService {

    private final Gson gson = new Gson();

    @POST
    @Path("/createTree")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createTree(String tree) {
        
        try {
            JsonObject jsonObject = new Gson().fromJson(tree, JsonObject.class);
            List<Integer> nodes = new ArrayList<>();
            JsonArray jsonNodes = jsonObject.getAsJsonArray("nodes");
            CreateTree createTree = new CreateTree();
            
            for (int i = 0; i < jsonNodes.size(); i++) {
                nodes.add(jsonNodes.get(i).getAsInt());
            }
            
            TreeDTO treeDTO = createTree.createTree(nodes);
            return Response.status(200).entity(gson.toJson(treeDTO)).build();
            
        } catch (JsonSyntaxException ex) {
            JsonObject message = new JsonObject();
            message.addProperty("Error", "Por favor verifique que el request tenga el formato JSON indicado.");
            return Response.status(406).entity(message.toString()).build();
            
        } catch (Exception ex) {
            JsonObject message = new JsonObject();
            message.addProperty("Error", "Por favor contacte al administrador.");
            message.addProperty("Error del sistema", ex.getMessage());
            return Response.status(500).entity(message.toString()).build();
        }
    }

    @POST
    @Path("/lowestCommonAncestor")
    @Consumes("application/json")
    @Produces("application/json")
    public Response lowestCommonAncestor(String dataRequest) {

        try {
            JsonObject jsonObject = new Gson().fromJson(dataRequest, JsonObject.class);
            int valueA = jsonObject.get("valueA").getAsInt();
            int valueB = jsonObject.get("valueB").getAsInt();
            TreeDTO treeDTO = new Gson().fromJson(jsonObject.getAsJsonObject("tree"), TreeDTO.class);
            
            SearchAncestor searchAncestor = new SearchAncestor();
            int ancestor = searchAncestor.search(treeDTO.getRoot(), valueA, valueB);
            
            JsonObject message = new JsonObject();
            message.addProperty("Ancestro común más cercano: ", ancestor);
            
            return Response.status(200).entity(message.toString()).build();
            
        } catch (JsonSyntaxException ex) {
            JsonObject message = new JsonObject();
            message.addProperty("Error", "Por favor verifique que el request tenga el formato JSON indicado.");
            return Response.status(406).entity(message.toString()).build();
            
        } catch (Exception ex) {
            JsonObject message = new JsonObject();
            message.addProperty("Error", "Por favor contacte al administrador.");
            message.addProperty("Error del sistema", ex.getMessage());
            return Response.status(500).entity(message.toString()).build();
        }
    }
}
