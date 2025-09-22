package jsp_restful_api.resources;


import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jsp_restful_api.model.User;
import jsp_restful_api.service.UserService;

@Path("/users")
public class UserResource {
	
	private UserService userService =new UserService();
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> fetchAll() {

    	return userService.fetchAll();
    }
    
    @GET
    @Path("user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
    	
        return Response.ok().entity(userService.fetchBy(id)).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(User user) {
    	//此处使用curl发送请求时，json数据转实体类对象总是出错
    	//改用postman发送请求，成功
    	userService.Create(user);
        return Response.status(Status.CREATED).build();
    }

}
