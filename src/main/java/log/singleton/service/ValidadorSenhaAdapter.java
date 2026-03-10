package log.singleton.service;

import org.springframework.stereotype.Component;

@Component
public class ValidadorSenhaAdapter implements ValidadorSenha {
    private final Validador validador;

    public ValidadorSenhaAdapter(Validador validador) {
        this.validador = validador;
    }


    @Override
    public boolean validar(String senha) {
        return validador.verificarSenhaForte(senha);
    }
}
