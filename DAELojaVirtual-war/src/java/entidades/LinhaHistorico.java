package entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="LINHAS_HISTORICO")
public class LinhaHistorico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int quantidade;
    private boolean positivo;

    public LinhaHistorico() {
    }

    public LinhaHistorico(int quantidade, boolean positivo) {
        this.quantidade = quantidade;
        this.positivo = positivo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public boolean isPositivo() {
        return positivo;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LinhaHistorico)) {
            return false;
        }
        LinhaHistorico other = (LinhaHistorico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.LinhaHistorico[ id=" + id + " ]";
    }
}
