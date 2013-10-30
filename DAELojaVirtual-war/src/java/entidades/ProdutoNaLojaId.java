package entidades;

import java.io.Serializable;
import java.util.Objects;

public class ProdutoNaLojaId implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idProduto;
    private Long idLoja;

    public ProdutoNaLojaId() {
    }

    public ProdutoNaLojaId(Long idProduto, Long idLoja) {
        this.idProduto = idProduto;
        this.idLoja = idLoja;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idProduto);
        hash = 53 * hash + Objects.hashCode(this.idLoja);
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
        final ProdutoNaLojaId other = (ProdutoNaLojaId) obj;
        if (!Objects.equals(this.idProduto, other.idProduto)) {
            return false;
        }
        if (!Objects.equals(this.idLoja, other.idLoja)) {
            return false;
        }
        return true;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Long getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(Long idLoja) {
        this.idLoja = idLoja;
    }
}