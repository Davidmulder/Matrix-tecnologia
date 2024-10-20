package spring.contrato.contratos.Usuario;

public record UsuarioDTO(Long id, String nome, String email, String perfil) {

    public UsuarioDTO(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getPerfil());

    }
}
