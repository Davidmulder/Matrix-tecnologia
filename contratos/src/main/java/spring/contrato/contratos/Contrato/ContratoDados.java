package spring.contrato.contratos.Contrato;

import jakarta.validation.constraints.NotBlank;

public record ContratoDados(
        @NotBlank
        String titulo,
        @NotBlank
        String texto,
        @NotBlank
        Double valor,
        @NotBlank
        Integer id_service) {
}
