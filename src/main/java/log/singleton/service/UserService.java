package log.singleton.service;

import log.singleton.entity.User;
import log.singleton.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ValidadorSenha validadorSenha ;

    public UserService(UserRepository userRepository, ValidadorSenha validadorSenha) {
        this.userRepository = userRepository;
        this.validadorSenha = validadorSenha;
    }

    public boolean cadastrar(String usuario, String senha) {
        if (usuario != null && senha != null && !usuario.isEmpty() && !senha.isEmpty()) {
            if (userRepository.findByUsuario(usuario).isEmpty()) {
                if (!validadorSenha.validar(senha)) {
                    throw new RuntimeException("Senha fora do padrão");
                }
                userRepository.save(new User(usuario, senha));
                LoginLogger.getInstance().Log(usuario, true, "Cadastro realizado com sucesso");
                return true;
            }
        }
        LoginLogger.getInstance().Log(usuario, false, "Cadastro realizado falhou, usuário já existe");
        return false;
    }

    public boolean Login(String usuario, String senha) {
        if (usuario != null && senha != null && !usuario.isEmpty() && !senha.isEmpty()) {
            User user = userRepository.findByUsuario(usuario).orElse(null);
            if (user != null && user.getSenha().equals(senha)) {
                LoginLogger.getInstance().Log(usuario, true, "Login realizado com sucesso");
                return true;
            }
        }
        LoginLogger.getInstance().Log(usuario, false, "Login falhou, usuário ou senha inválidos");
        return false;
    }
}

