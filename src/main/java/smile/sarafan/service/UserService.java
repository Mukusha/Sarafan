package smile.sarafan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Service;
import smile.sarafan.domain.Provider;
import smile.sarafan.domain.User;

import smile.sarafan.repo.UserRepo;

import java.time.LocalDateTime;


@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    /**
     * Сохраняем в базу данных
     *
     * @param defaultOidcUser то что мы получаем о пользователе при входе/регистрации
     */
    public void processOAuthPostLogin(DefaultOidcUser defaultOidcUser) {
        String id = defaultOidcUser.getName();
        //  User existUser = userRepo.getUserById(id);
        User newUser = new User();
        newUser.setId(id);
        newUser.setName(defaultOidcUser.getAttribute("given_name"));
        newUser.setUserpic(defaultOidcUser.getAttribute("picture"));
        newUser.setEmail(defaultOidcUser.getEmail());
        newUser.setProvider(Provider.GOOGLE);
        newUser.setLastVisit(LocalDateTime.now());
        userRepo.save(newUser);
    }
}