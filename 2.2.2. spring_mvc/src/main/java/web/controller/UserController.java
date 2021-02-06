package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.servise.UserService;


import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public ModelAndView listUsers() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> users = userService.listUser();
        modelAndView.setViewName("users");
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createUserForm(User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("newUser");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping("/create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") Integer  id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("update/{id}")
    public ModelAndView updateUserForm(@PathVariable("id") Integer  id, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getUserId(id);
        model.addAttribute("user", user);
        modelAndView.setViewName("/edit");
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    @PostMapping("/update")
    public String updateUser(User user) {
        userService.updateUser(user);
        return"redirect:/users";
    }
}

