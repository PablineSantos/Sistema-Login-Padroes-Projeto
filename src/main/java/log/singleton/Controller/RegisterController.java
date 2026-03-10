package log.singleton.Controller;

import log.singleton.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String telaregistero(){
        return "register";
    }

    @PostMapping("/register")
    public String processarregister(@RequestParam String usuario, @RequestParam String senha, Model model ){
       boolean sucesso = userService.cadastrar(usuario, senha);
         if (sucesso) {
             model.addAttribute("sucesso", "Cadastro realizado com sucesso");
             return "login";
         }

        model.addAttribute("erro", "Usuário já existe ou senha inválida");
        return "register";

    }
}

//http://localhost:8080/register