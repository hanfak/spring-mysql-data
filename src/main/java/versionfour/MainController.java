package versionfour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/demo")
public class MainController {

    @Autowired
    private UserDatabaseDataProvider userDatabaseDataProvider;


    @GetMapping(path="/user")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userDatabaseDataProvider.queryAllUsers();
    }

}
