
package com.masivian.binarytree.Controller;

/**
 *
 * @author David
 */

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/MasivianBinaryTree")
public class BinaryTreeService {
    
    @GET
    @Produces("application/json")
    public Response prueba(){
        return Response.status(200).entity("Pr")
    }
            

    
}
