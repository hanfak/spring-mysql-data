package versionthree;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.util.ArrayList;
import java.util.List;

// Should implement interface and used in calling class
public class UserDatabaseDataProvider {
    private JdbcTemplate jdbcTemplate;


    public UserDatabaseDataProvider(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> queryAllUsers() {
        List userList = jdbcTemplate.query("SELECT name, email FROM user", (ResultSetExtractor<List>) rs -> {
            List<User> list = new ArrayList<>();
            while(rs.next()) {
                User user = new User(rs.getString("name"), rs.getString("email"));
                list.add(user);
            }
            return list;
        });
        return userList;
    }

    public void addUser(User user) {
        jdbcTemplate.update("INSERT INTO user (name, email) " +
                "VALUES (?, ?)",
                user.getName(), user.getEmail());
    }
}
