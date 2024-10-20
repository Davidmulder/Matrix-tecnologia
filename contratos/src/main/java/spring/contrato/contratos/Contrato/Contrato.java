package spring.contrato.contratos.Contrato;

import jakarta.persistence.*;
import lombok.*;
import spring.contrato.contratos.Servico.Servico;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name="Contrato")
@Table(name="contrato")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_servico",referencedColumnName ="id")
    private Servico servico;

    private String titulo;
    private String texto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataInsercao() {
        return dataInsercao;
    }

    public void setDataInsercao(LocalDateTime dataInsercao) {
        this.dataInsercao = dataInsercao;
    }

    private BigDecimal valor;
    private LocalDateTime dataInsercao;

    public Contrato(ContratoDados dados, Servico servico) {
        this.titulo = dados.titulo();
        this.texto = dados.texto();
        this.valor = BigDecimal.valueOf(dados.valor());
        this.servico = servico; // Associar o serviço ao contrato

    }

    @PrePersist
    protected void onCreate() {
        this.dataInsercao = LocalDateTime.now();
    }

}
