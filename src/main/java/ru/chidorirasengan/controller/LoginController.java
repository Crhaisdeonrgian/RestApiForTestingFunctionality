package ru.chidorirasengan.controller;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.chidorirasengan.dao.ShoppingCartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.chidorirasengan.dao.UserDetailsDao;
import ru.chidorirasengan.dao.UserDetailsDaoImpl;
import ru.chidorirasengan.entity.User;

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
    @Autowired
    private UserDetailsDao userDetailsDao;
    @GetMapping("/loginpage")
    public String loginpage(){
        return "loginpage";
    }
    //TODO: Разобраться с регистрацией
    @GetMapping("/signup")
    public String signpage(@ModelAttribute("signupdto") User userModel){
        return "signup";
    }
    @PostMapping("/process-signup")
    public String signprocess(User userModel){
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userDetailsDao.saveUser(userModel);
        return "redirect:/loginpage";
    }
}

