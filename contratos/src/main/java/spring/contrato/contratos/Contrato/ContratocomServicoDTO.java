package spring.contrato.contratos.Contrato;

import java.math.BigDecimal;

public record ContratocomServicoDTO(Long idContrato, String titulo, BigDecimal valor, String tituloServico, Long id_servico) {
}
