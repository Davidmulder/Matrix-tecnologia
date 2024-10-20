package spring.contrato.contratos.Usuario;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Esse método é de instância, portanto deve ser chamado a partir de uma instância de PasswordService
    public String encryptPassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    public boolean checkPassoword(String rawPassword, String encryptPassword){
        // verifica senha com banco de dados
        return passwordEncoder.matches(rawPassword, encryptPassword);

    }
}
