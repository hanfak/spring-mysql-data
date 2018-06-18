package versionfour;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

// Should implement interface and used in calling class
public class UserDatabaseDataProvider {
    private JdbcTemplate jdbcTemplate;


    public UserDatabaseDataProvider(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> queryAllUsers() {
        return jdbcTemplate.query("SELECT name, email FROM user",
                (rs, i) -> new User(rs.getString("name"), rs.getString("email")));
    }

    public void addUser(User user) {
        jdbcTemplate.update("INSERT INTO user (name, email) " +
                "VALUES (?, ?)",
                user.getName(), user.getEmail());
    }
}
