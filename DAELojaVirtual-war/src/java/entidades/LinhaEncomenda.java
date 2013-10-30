package entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity @Table(name="LINHAS_ENCOMENDA")
public class LinhaEncomenda extends GeneralData implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull @ManyToOne
    private Produto produto;
    @NotNull 
    private int quantidade;
    
    public LinhaEncomenda() {
    }

    public LinhaEncomenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }
    
    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setProduto(Produto produto) {
        this.setChange();
        this.produto = produto;
    }

    public void setQuantidade(int quantidade) {
        this.setChange();
        this.quantidade = quantidade;
    }
}