package spring.contrato.contratos;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.contrato.contratos.Usuario.*;
import spring.contrato.contratos.repositorio.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordService passwordService;

    @GetMapping("/todos")
    @Transactional
    public Page<Usuario> listar(Pageable paginacao){  //lista de usuario
        return usuarioRepository.findAllByStatusTrue(paginacao);
    }

    @PostMapping
    @Transactional
    public void cadastraUsuario(@RequestBody @Valid Usuariodados dados){
        Usuario usuario = new Usuario(dados, passwordService);  // Passa o PasswordService
        usuarioRepository.save(usuario);

    }

    @PostMapping("/login")
    public ResponseEntity<?> verificaCredenciais (@RequestBody UsuarioLoginDados loginSenha){
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(loginSenha.email());
        if(usuarioOpt.isPresent()){ // email existi verifica a senha
            Usuario usuario = usuarioOpt.get();

            boolean senhaCorreta = passwordService.checkPassoword(loginSenha.senha(), usuario.getSenha());
            if(senhaCorreta){
                UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
                return ResponseEntity.ok(usuarioDTO);
            }else{
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta.");

            }

        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email não encontrado.");
        }

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> excluir(@PathVariable Long id){
        var usuario = usuarioRepository.getReferenceById(id);
        usuario.InativoUsuario();
        return ResponseEntity.ok("Usuário marcado como inativo com sucesso.");

    }

}
