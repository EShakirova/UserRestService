package servece;

import entity.Sex;
import entity.User;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/hello")
@Api(value = "users", description = "Manage users")
public class UserRestService {
    private List<User> userList;

    public UserRestService(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Produces({MediaType.APPLICATION_JSON})
    @GET
    @Path("/users/{login}")
    @ApiOperation(
            value = "Find user by login",
            notes = "Find user by login",
            response = User.class
    )
    @ApiResponses( {
            @ApiResponse( code = 404, message = "User with such login not found" )
    } )
    public User getUser(@ApiParam( value = "Login to lookup for ", required = true )
                        @PathParam("login") String login){
        User result = null;
        for (User user: userList){
            if (user.getLogin() == login){
                result = user;
            }
        }
        return result;
    }

    @Produces({MediaType.APPLICATION_JSON})
    @GET
    @Path("/users")
    @ApiOperation(value = "List all users",
                  notes = "List all users",
                  response = User.class,
                  responseContainer = "List")
    public List<User> getAll(){
        return userList;
    }

    @POST
    @Path("/users")
    @ApiOperation(value = "user", response = User.class)
    @ApiResponses( {
            @ApiResponse( code = 409, message = "User with such login already exists" )
    } )
    public void addUser(@ApiParam(value = "Create new user object", required = true) User user){
        if (!userList.contains(user)) {
            userList.add(user);
        }
    }

    @POST
    @Path("/users/{login}")
    @ApiOperation(value = "user", response = User.class)
    @ApiResponses( {
            @ApiResponse( code = 404, message = "User with such login doesn't exists" )
    } )
    public void updateUser(@ApiParam(value = "login that need to be updated", required = true)
                           @PathParam("login") String login,
                           @ApiParam(value = "Updated user object", required = true) User user){
        User userByLogin = getUserByLogin(login);
        if (userByLogin != null) {
            userByLogin.setName(user.getName());
            userByLogin.setPassword(user.getPassword());
            userByLogin.setBirthday(user.getBirthday());
            userByLogin.setSex(user.getSex());
        }
    }

    @DELETE
    @Path("/users/{login}")
    @ApiResponses( {
            @ApiResponse( code = 404, message = "User with such login doesn't exists" )
    } )
    public void  deluser(@ApiParam(value = "login that need to be deleted", required = true)
                             @PathParam("login") String login){
        User user = getUserByLogin(login);
        if (userList.contains(user)){
            userList.remove(user);
        }
    }

    private User getUserByLogin(String login){
        for (User user: userList){
            if (user.getLogin() == login){
                return user;
            }
        }
        return null;
    }
}
