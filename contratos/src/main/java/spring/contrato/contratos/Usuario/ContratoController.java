package spring.contrato.contratos.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.contrato.contratos.Contrato.Contrato;
import spring.contrato.contratos.Contrato.ContratoDados;
import spring.contrato.contratos.Contrato.ContratocomServicoDTO;
import spring.contrato.contratos.Servico.Servico;
import spring.contrato.contratos.repositorio.ContratoRepository;
import spring.contrato.contratos.repositorio.ServicoRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/contratos")
public class ContratoController {

    private final ContratoRepository contratoRepository;
    @Autowired
    public ContratoController(ContratoRepository contratoRepository){  // garantido que vai pega interface
        this.contratoRepository = contratoRepository;
    }

    @Autowired
    private ServicoRepository servicoRepository;

    @GetMapping("/todos")
    public List<ContratocomServicoDTO> listarTodosComServico(){
        return contratoRepository.findAllContratosComServico();
    }

    @PostMapping
    public ResponseEntity<Contrato>  addContratos(@RequestBody ContratoDados dados){
        // Buscar o serviço pelo ID do DTO
        Servico servico = servicoRepository.findById(dados.id_service().longValue())  // converte long
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado com ID: " + dados.id_service()));

        Contrato contrato=new Contrato (dados,servico);

        // Salvar o contrato
        Contrato novoContrato = contratoRepository.save(contrato);
        return ResponseEntity.ok(novoContrato);


    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrato> BuscaContrato(@PathVariable Long id){
        Optional<Contrato> contrato  = contratoRepository.findById(id);

        if(contrato.isPresent()){
            return ResponseEntity.ok(contrato.get());
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrato> AtualizarContrato(@PathVariable Long id, @RequestBody ContratoDados dados){
      Optional<Contrato> contratoOptional = contratoRepository.findById(id);
      if(contratoOptional.isPresent()){

          Contrato contrato = contratoOptional.get();  // chama os dados do banco

          // Buscar o serviço atualizado, se necessário
          Servico servico = servicoRepository.findById(dados.id_service().longValue())
                  .orElseThrow(() -> new RuntimeException("Servico not found with id: " + dados.id_service()));
      //atualizar campos
          contrato.setTitulo(dados.titulo());
          contrato.setTexto(dados.texto());
          contrato.setValor(BigDecimal.valueOf(dados.valor()));
          contrato.setServico(servico); // Atualiza o serviço, se necessário

          Contrato updatedContrato = contratoRepository.save(contrato);
          return ResponseEntity.ok(updatedContrato);

      }else{
          return ResponseEntity.notFound().build();
      }

    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> deletaContrato(@PathVariable Long id){
        Optional<Contrato> contratoOptional = contratoRepository.findById(id);
        if(contratoOptional.isPresent()){
            Contrato contrato = contratoOptional.get();
            contratoRepository.delete(contrato);
            return ResponseEntity.ok().build(); // Retorna 200 OK sem conteúdo
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
