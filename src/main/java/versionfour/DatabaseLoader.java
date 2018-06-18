package versionfour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final UserDatabaseDataProvider dataProvider;

    @Autowired
    public DatabaseLoader(UserDatabaseDataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    @Override
    public void run(String... args) throws Exception {
        this.dataProvider.addUser(new User("UserOne", "UserOne@gmail.com"));
        this.dataProvider.addUser(new User("UserTwo", "UserTwo@gmail.com"));
    }
}
