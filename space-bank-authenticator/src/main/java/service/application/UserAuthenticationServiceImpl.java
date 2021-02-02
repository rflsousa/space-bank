package service.application;

import service.infrastructure.User;
import service.infrastructure.UserRepository;
import service.interfaces.CreateUserRequest;
import service.interfaces.TokenRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class UserAuthenticationServiceImpl implements UserAuthenticationService{

    @Inject
    private UserRepository repository;

    @Override
    public Optional<User> login(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void create(CreateUserRequest userRequest) {
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setGender(userRequest.getGender());
        user.setName(userRequest.getName());
        user.setPhone(userRequest.getPhone());
        user.setPassword(userRequest.getPassword());

        repository.save(user);
    }

    @Override
    public boolean validate(TokenRequest token) {
        return false;
    }
}