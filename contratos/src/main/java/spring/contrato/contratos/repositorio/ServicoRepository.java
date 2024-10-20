package spring.contrato.contratos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.contrato.contratos.Servico.Servico;
@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long > {
}
