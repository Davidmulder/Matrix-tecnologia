package spring.contrato.contratos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.contrato.contratos.Contrato.Contrato;
import spring.contrato.contratos.Contrato.ContratocomServicoDTO;

import java.util.List;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {

    @Query("SELECT new spring.contrato.contratos.Contrato.ContratocomServicoDTO(c.id, c.titulo, c.valor, s.titulo, s.id) " +
            "FROM Contrato c JOIN c.servico s")
    List<ContratocomServicoDTO> findAllContratosComServico();
}
