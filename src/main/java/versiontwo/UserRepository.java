package versiontwo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
//http://www.baeldung.com/queries-in-spring-data-mongodb
    List<User> findByName(String name);
    List<User> findByEmailEndingWith(String regexp);

}
