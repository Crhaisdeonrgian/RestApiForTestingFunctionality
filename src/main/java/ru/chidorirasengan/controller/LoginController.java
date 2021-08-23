package ru.chidorirasengan.controller;
import ru.chidorirasengan.dao.ShoppingCartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * See some comments later...
 * @author crhaisdeonrgian [https://github.com/Crhaisdeonrgian]
 */
@Controller
public class LoginController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ShoppingCartDao shoppingCartDao;
/*    @Autowired
    private JdbcUserDetailsManager jdbcUserDetailsManager;*/
    @GetMapping("/loginpage")
    public String loginpage(){
        return "loginpage";
    }
    //TODO: Разобраться с регистрацией
/*    @GetMapping("/signup")
    public String signpage(@ModelAttribute("signupdto") User userModel){
        return "signup";
    }
    @PostMapping("/process-signup")
    public String signprocess(User userModel){
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        //signupDAO.saveUser(userModel);
        UserDetails userDetails = User.withUsername(userModel.getUsername()).password(userModel.getPassword()).roles("USER").build();

        jdbcUserDetailsManager.createUser(userDetails);
        return "redirect:/loginpage";
    }*/
}

