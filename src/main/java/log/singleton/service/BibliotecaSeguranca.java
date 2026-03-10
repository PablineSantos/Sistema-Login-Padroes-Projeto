package log.singleton.service;

import org.springframework.stereotype.Component;

@Component
public class BibliotecaSeguranca implements  Validador{
        public boolean verificarSenhaForte(String senha)  {
            if (senha == null) {
                return false;
            }

            if (senha.length() < 8) {
                return false;
            }

            boolean temMaiuscula = senha.matches(".*[A-Z].*");
            boolean temNumero = senha.matches(".*\\d.*");

            return temMaiuscula && temNumero;
        }

}
