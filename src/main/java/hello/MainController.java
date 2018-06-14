package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(path="/demo")
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/user")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path="/user/{id}")
    public @ResponseBody User getAUser(@PathVariable String id) {
        return userRepository.findById(Long.parseLong(id)).get();
    }

    @PostMapping(path="/user")
    public @ResponseBody User AddAUser(@RequestBody Map<String, String> body) {
        String name = body.get("name");
        String email = body.get("email");
        return userRepository.save(new User(name, email));
    }

    @PutMapping(path="/user/{id}")
    public @ResponseBody User updateAUser(@PathVariable String id,  @RequestBody Map<String, String> body) {
        long id1 = Long.parseLong(id);
        String name = body.get("name");
        String email = body.get("email");
        return userRepository.save(new User(id1, name, email));
    }

    @DeleteMapping(path="/user/{id}")
    public @ResponseBody void DeleteAUser(@PathVariable String id) {
        User user = userRepository.findById(Long.parseLong(id)).get();
        userRepository.delete(user);
    }
}
