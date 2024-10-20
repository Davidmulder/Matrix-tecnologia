package spring.contrato.contratos.Servico;

import jakarta.validation.constraints.NotBlank;

public record ServicoDados(
        @NotBlank
        String titulo,
        @NotBlank
        String descricao) {
}
