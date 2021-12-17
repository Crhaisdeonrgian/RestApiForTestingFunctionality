package ru.chidorirasengan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ru.chidorirasengan.config.GoogleMail;
import ru.chidorirasengan.dao.ShoppingCartDao;
import ru.chidorirasengan.dao.OrderDao;
import ru.chidorirasengan.dao.ProductDao;
import ru.chidorirasengan.dao.UserDetailsDao;
import ru.chidorirasengan.entity.Order;
import ru.chidorirasengan.entity.Product;
import ru.chidorirasengan.entity.ShoppingCart;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Collection;
import java.util.List;

@Controller
@Transactional
@EnableWebMvc
public class MainController {
    @Autowired
    private GoogleMail googleMailSender;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private UserDetailsDao userDetailsDao;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @GetMapping("/hello")
    public String hello(Principal principal, Authentication auth, Model model){
        List<Product> list =productDao.getAllProducts();
        list.removeIf(p -> p.getQuantity() == 0);
        model.addAttribute("list", list);
        System.out.println(productDao.getAllProducts());
        String username = principal.getName();
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        ShoppingCart shoppingCart = shoppingCartDao.createShoppingCart(principal.getName());
        System.out.println(shoppingCart.getCart_id());
        model.addAttribute("sum", shoppingCart.getSum());
        model.addAttribute("username", username);
        model.addAttribute("roles", authorities);
        return "helloworld";
    }
    // TODO: Разобраться с изменением юзеров
    /*@Autowired
    private UserDetailsService userDetailsService;
    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("username")String username){
        userDetailsService.deleteUser(username);
        return "redirect:/loginpage";
    }
    @GetMapping("/changePassword")
    public String changePassword(Model model){
        model.addAttribute("passwordchng", new ChangePassword());
        return "changepasswordpage";
    }
    @PostMapping("/save-password")
    public String savepassword(Principal principal, ChangePassword changePasswordModel){
        UserDetails userDetails = userDetailsManager.loadUserByUsername(principal.getName());
        boolean matches = passwordEncoder.matches(changePasswordModel.getOldPassword(),userDetails.getPassword());
        if(!changePasswordModel.getNewPassword().equals(changePasswordModel.getConfirmPassword())){
            return "redirect:/changePassword?notMatched";
        }
        if(matches) {
            userDetailsManager.changePassword(changePasswordModel.getOldPassword(), passwordEncoder.encode(changePasswordModel.getConfirmPassword()));
            return "redirect:/";}
        return "redirect:/changePassword?invalidPassword";
    }*/
    @RequestMapping("/")
    public String main(){
        return "mainpage";
    }
    @RequestMapping("/signup")
    public String signup(){return "signup";}
    /*@RequestMapping("/buyproduct")
    public String buyProduct(HttpServletRequest request, Model model,
                             @RequestParam(value = "code", defaultValue = "") String code){
        if(code.isEmpty())
        {
            return "redirect:/hello";
        }
        Product product = null;
        if(code.length()>0){
            product = productDao.findProduct(code);
        }
        if(product!=null){
            if(product.getQuantity()==0){
                //TODO: Разобраться с нулевым колвом
                //throw new ProductOutOfStockExceprion();
            }
            model.addAttribute("product",product);
        }
        return "confirmation";
    }*/
    //TODO: Сохранять ли заказы?
   /* @PostMapping("/purchase")
    @Transactional(propagation = Propagation.NEVER)
    public String purchaseProduct(HttpServletRequest request, Model model){
    }*/

    @RequestMapping(value = { "/add-to-cart" }, method = RequestMethod.GET)
    public String addtocart(Principal principal,HttpServletRequest request, Model model){
        String code = request.getParameter("code");
        int quantity =Integer.parseInt( request.getParameter("quantity") );
        ShoppingCart shoppingCart = shoppingCartDao.pushOrder(code, quantity, principal.getName());
        model.addAttribute("sum",shoppingCart.getSum());
        return "redirect:/hello";
    }
    @GetMapping("/clear-cart")
    public String clearcart(Principal principal){
        shoppingCartDao.clearCart(principal.getName());
        return "redirect:/hello";
    }
    @GetMapping("cart")
    public String cart(Principal principal, Model model){
        ShoppingCart shoppingCart = shoppingCartDao.findShoppingCart(principal.getName());
        model.addAttribute("list",shoppingCart.getOrders());
        model.addAttribute("sum", shoppingCart.getSum());
    return "cartpage";}

    @GetMapping("/productinfo")
    public String productinfo(HttpServletRequest request, Model model,
                              @RequestParam(value = "code") String code){


        Product product = productDao.findProduct(code);
        model.addAttribute(product);
        return "productinfopage";
    }
    @GetMapping("/categoryproducts")
    public String categoryproducts(HttpServletRequest request, Model model,
                                   @RequestParam(value = "category") String category){
        model.addAttribute("list",productDao.getAllProductsWithCategory(category));
        model.addAttribute("category",category);
        return "categorypage";
    }

    @GetMapping("/finish-cart")
    public String finish(Principal principal) throws MessagingException {
        ShoppingCart shoppingCart = shoppingCartDao.findShoppingCart(principal.getName());
        String message = principal.getName() + ", Вы оформили заказ на сумму: " + shoppingCart.getSum() + "руб. \n" + "Позиции в заказе: \n";
        for (Order order:shoppingCart.getOrders()) {
            message += order.getProduct().getName() + " " +order.getQuantity() + "шт " + order.getAmount()+"руб."+ "\n";
        }
        shoppingCartDao.purchaseCart(principal.getName());
        googleMailSender.send("bibaboss1488","Bosspassword", principal.getName(), "title", message);
        return "finish";
    }
    @GetMapping("/admin")
    public String adminzone(Model model){
        List<Product> list = productDao.getAllProducts();
        list.removeIf(p -> p.getQuantity() != 0);
        model.addAttribute("list",list);
        return "adminpage";
    }
    @GetMapping("/accessDenied")
    public String accessdenied(){
        return "accessdenied";
    }
    @RequestMapping(value = { "/add-to-stock" }, method = RequestMethod.GET)
    public String addtostock(HttpServletRequest request,Model model){
        String code = request.getParameter("code");
        int quantity =Integer.parseInt( request.getParameter("quantity") );
        productDao.updateProduct(code, quantity);
        return "redirect:/admin";
    }
}
