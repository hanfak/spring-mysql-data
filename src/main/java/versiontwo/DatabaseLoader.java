package versiontwo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final UserRepository repository;

    @Autowired
    public DatabaseLoader(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.repository.save(new User("UserOne", "UserOne@gmail.com"));
        this.repository.save(new User("UserTwo", "UserTwo@gmail.com"));
        this.repository.save(new User("UserThree", "UserTwo@gmail.co.uk"));
    }
}
