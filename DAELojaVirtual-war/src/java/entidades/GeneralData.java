package entidades;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Temporal;

public class GeneralData {
    private static final long serialVersionUID = 1L;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataUltimaAlteracao;
    
    private Boolean isActive;

    public GeneralData() {
        Long current = System.currentTimeMillis();
        this.dataCriacao = new Date();
        this.dataCriacao.setTime(current);
        this.dataUltimaAlteracao = new Date();
        this.dataUltimaAlteracao.setTime(current);
        this.isActive = true;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.dataCriacao);
        hash = 53 * hash + Objects.hashCode(this.dataUltimaAlteracao);
        hash = 53 * hash + Objects.hashCode(this.isActive);
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
        final GeneralData other = (GeneralData) obj;
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        if (!Objects.equals(this.dataUltimaAlteracao, other.dataUltimaAlteracao)) {
            return false;
        }
        if (!Objects.equals(this.isActive, other.isActive)) {
            return false;
        }
        return true;
    }

    public Boolean isActive() {
        return isActive;
    }
    
    public void remove() {
        isActive = false;
    }
    
    public void setChange() {
        dataUltimaAlteracao.setTime(System.currentTimeMillis());
    }
    
    public Boolean hasChanged() {
        return (dataCriacao != dataUltimaAlteracao);
    }
}
