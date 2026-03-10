package log.singleton.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import log.singleton.service.UserService;

@Controller
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String telaLogin(){
        return "login";
    }

    @PostMapping("/login")
    public String processarLogin(@RequestParam String usuario, @RequestParam String senha, Model model ){
       boolean sucesso = userService.Login(usuario, senha);
         if (sucesso) {
             model.addAttribute("sucesso", "Login realizado com sucesso");
             return "login";
         }

        model.addAttribute("erro", "Usuário ou senha inválidos");
        return "login";

    }
}

//http://localhost:8080/login