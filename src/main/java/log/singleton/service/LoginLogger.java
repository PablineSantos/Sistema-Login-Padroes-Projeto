package log.singleton.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.time.LocalDateTime;

import static java.lang.System.lineSeparator;

@Service
public class LoginLogger {
    private static LoginLogger instance ;
    private final Path arquivo;

    private LoginLogger() {
        this.arquivo = Path.of("logs/login.log");
        try {
            Files.createDirectories(arquivo.getParent());
            if (Files.notExists(arquivo)){
                Files.createFile(arquivo);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LoginLogger getInstance() {
        if (instance == null) {
            instance = new LoginLogger();
        }
        return instance;
    }

    public void Log(String usuario, boolean sucesso, String info) {
        String infoLog = Instant.now() + " | usuário=" + usuario + " | resultado=" + (sucesso ? "SUCESSO" : "FALHA") + " | info=" + info;

        try {
            Files.writeString(arquivo, infoLog + lineSeparator(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
