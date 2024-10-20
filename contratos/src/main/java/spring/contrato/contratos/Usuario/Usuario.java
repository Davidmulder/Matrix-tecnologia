package spring.contrato.contratos.Usuario;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name="Usuario")
@Table(name="usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private  String senha;
    private Boolean status;
    private LocalDateTime dataInsercao;

    private String perfil;

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDateTime getDataInsercao() {
        return dataInsercao;
    }

    public void setDataInsercao(LocalDateTime dataInsercao) {
        this.dataInsercao = dataInsercao;
    }

    @PrePersist
    protected void OnCreate(){
        this.dataInsercao = LocalDateTime.now();
    }

    public Usuario(Usuariodados dados, PasswordService passwordService) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = passwordService.encryptPassword(dados.senha()); // Criptografa a senha
        this.status = true;
        this.perfil = dados.perfil();
    }

    public void InativoUsuario(){
        this.status = false;
    }

}
