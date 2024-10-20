package spring.contrato.contratos.Usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioLoginDados(
        @NotBlank
        @Email
        String email,
        @NotBlank
        String senha) {
}
