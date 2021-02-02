package service.interfaces;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import service.application.TokenService;
import service.application.UserAuthenticationService;
import service.infrastructure.User;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/api/authenticate")
public class AuthenticatorResource {

    @Inject
    private UserAuthenticationService userAuthenticationService;

    @Inject
    private TokenService tokenService;

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@RequestBody String email, @RequestBody String password){
        final Optional<User> user = userAuthenticationService.login(email, password);
        if (user.isEmpty()){
            return Response.status(Response.Status.UNAUTHORIZED).entity("Login failed").build();
        } else {
            LoginResponse token = new LoginResponse(tokenService.generateToken());
            return Response.ok(token).build();
        }
    }
}
