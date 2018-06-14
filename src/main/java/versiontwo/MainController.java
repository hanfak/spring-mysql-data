package versiontwo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path="/demo")
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/user/{name}")
    public @ResponseBody
    List<User> getAUserByName(@PathVariable String name) {
        return userRepository.findByName(name);
    }


    @GetMapping(path="/user/email/{regexp}")
    public @ResponseBody
    List<User> getAUserByEmailEnding(@PathVariable String regexp) {
        return userRepository.findByEmailEndingWith(regexp);
    }
}
