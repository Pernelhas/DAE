package entidades;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.swing.ImageIcon;
import javax.validation.constraints.NotNull;

@Entity @Table(name="PRODUTOS")
public class Produto extends GeneralData implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    private String referencia;
    @NotNull
    private String nome;
    
    private String descricao;
    
    private ImageIcon imagem;
    
    @OneToMany(mappedBy = "produto")
    private LinkedList<ProdutoNaLoja> listaProdutosLoja;

    public Produto() {
    }

    public Produto(String referencia, String nome) {
        this.referencia = referencia;
        this.nome = nome;
        this.descricao = null;
        this.imagem = null;
        this.listaProdutosLoja = new LinkedList<>();
    }

    public Produto(String referencia, String nome, String descricao, ImageIcon imagem) {
        this.referencia = referencia;
        this.nome = nome;
        this.descricao = descricao;
        this.imagem = imagem;
        this.listaProdutosLoja = new LinkedList<>();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
        hash = 73 * hash + Objects.hashCode(this.referencia);
        hash = 73 * hash + Objects.hashCode(this.nome);
        hash = 73 * hash + Objects.hashCode(this.descricao);
        hash = 73 * hash + Objects.hashCode(this.imagem);
        hash = 73 * hash + Objects.hashCode(this.listaProdutosLoja);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.referencia, other.referencia)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", referencia=" + referencia + ", nome=" + nome + ", descricao=" + descricao + ", imagem=" + imagem + ", listaProdutosLoja=" + listaProdutosLoja + '}';
    }

    public Long getId() {
        return id;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public ImageIcon getImagem() {
        return imagem;
    }

    public LinkedList<ProdutoNaLoja> getListaProdutosLoja() {
        return listaProdutosLoja;
    }
 
    public void setReferencia(String referencia) {
        this.setChange();
        this.referencia = referencia;
    }

    public void setNome(String nome) {
        this.setChange();
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.setChange();
        this.descricao = descricao;
    }

    public void setImagem(ImageIcon imagem) {
        this.setChange();
        this.imagem = imagem;
    }

    public void setListaProdutosLoja(LinkedList<ProdutoNaLoja> listaProdutosLoja) {
        this.listaProdutosLoja = listaProdutosLoja;
    }
    
    public void addListaProdutosLoja(ProdutoNaLoja produtoNaLoja) {
        if (listaProdutosLoja == null)
            listaProdutosLoja = new LinkedList<>();
        listaProdutosLoja.add(produtoNaLoja);
    }
    
    public void remListaProdutosLoja(ProdutoNaLoja produtoNaLoja) {
        if (listaProdutosLoja == null)
            return;
        if (listaProdutosLoja.contains(produtoNaLoja))
            listaProdutosLoja.remove();
    }
    
}
