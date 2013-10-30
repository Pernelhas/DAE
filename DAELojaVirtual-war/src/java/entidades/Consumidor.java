package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

@Entity
public class Consumidor extends Utilizador implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @OneToMany(mappedBy = "consumidor")
    private LinkedList<Encomenda> listaEncomendas;
    
    @NotNull
    private String codigoPostal;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ultimoAcesso;

    public Consumidor() {
    }

    public Consumidor(String codigoPostal, String username, String password, String email, String primeiroNome, String ultimoNome, String morada, String contacto, String numeroContribuinte) {
        super(username, password, email, primeiroNome, ultimoNome, morada, contacto, numeroContribuinte);
        this.codigoPostal = codigoPostal;
        this.listaEncomendas = new LinkedList<>();
        Long current = System.currentTimeMillis();
        this.ultimoAcesso = new Date();
        this.ultimoAcesso.setTime(current);
    }

    public Consumidor(String codigoPostal, String username, String password, String email, String primeiroNome, String contacto, String numeroContribuinte) {
        super(username, password, email, primeiroNome, contacto, numeroContribuinte);
        this.codigoPostal = codigoPostal;
        this.listaEncomendas = new LinkedList<>();
        Long current = System.currentTimeMillis();
        this.ultimoAcesso = new Date();
        this.ultimoAcesso.setTime(current);
    }

    public LinkedList<Encomenda> getListaEncomendas() {
        return listaEncomendas;
    }

    public Date getUltimoAcesso() {
        return ultimoAcesso;
    }
    
    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setUltimoAcesso(Date ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }
    
    public void setCodigoPostal(String codigoPostal) {
        this.setChange();
        this.codigoPostal = codigoPostal;
    }
    
    public void setListaEncomendas(LinkedList<Encomenda> listaEncomendas) {
        this.listaEncomendas = listaEncomendas;
    }

    public void addEncomenda(Encomenda encomenda) {
        if (listaEncomendas == null)
            listaEncomendas = new LinkedList<>();
        listaEncomendas.add(encomenda);
    }
    
    public void remEncomenda(Encomenda encomenda) {
        if (listaEncomendas == null)
            return;
        if (listaEncomendas.contains(encomenda))
            listaEncomendas.remove();
    }
}
