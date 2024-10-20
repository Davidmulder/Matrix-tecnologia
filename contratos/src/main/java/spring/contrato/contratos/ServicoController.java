package spring.contrato.contratos;



import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.contrato.contratos.Servico.Servico;
import spring.contrato.contratos.Servico.ServicoDados;
import spring.contrato.contratos.repositorio.ServicoRepository;


import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    private final ServicoRepository servicoRepository;

    @Autowired
    public ServicoController(ServicoRepository servicoRepository){  // garantido que vai pega interface
        this.servicoRepository = servicoRepository;
    }

    @GetMapping("/todos")
    public  List<Servico> listatodos(){
        return servicoRepository.findAll();
    }

    @PostMapping
    public  Servico addservico(@RequestBody @Valid ServicoDados dados){
        Servico servico = new Servico(dados);
        return servicoRepository.save(servico);
    }




}
