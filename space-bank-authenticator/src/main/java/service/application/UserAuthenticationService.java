package service.application;

import service.infrastructure.User;
import service.interfaces.CreateUserRequest;
import service.interfaces.CreateUserResponse;
import service.interfaces.TokenRequest;

import java.util.Optional;

public interface UserAuthenticationService {

    public Optional<User> login(String email, String password);

    public void create(CreateUserRequest user);

    public boolean validate(TokenRequest token);

}
