package entidades;

import java.io.Serializable;
import java.util.LinkedList;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Funcionario extends Utilizador implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @ManyToOne
    private Loja loja;
    
    @NotNull
    private int hierarquia;
    
    @OneToMany(mappedBy = "funcionario")
    private LinkedList<Encomenda> listaEncomendas;

    public Funcionario() {
    }

    public Funcionario(Loja loja, int hierarquia, String username, String password, String email, String primeiroNome, String ultimoNome, String morada, String contacto, String numeroContribuinte) {
        super(username, password, email, primeiroNome, ultimoNome, morada, contacto, numeroContribuinte);
        this.loja = loja;
        this.hierarquia = hierarquia;
        this.listaEncomendas = new LinkedList<>();
    }

    public Funcionario(Loja loja, int hierarquia, String username, String password, String email, String primeiroNome, String contacto, String numeroContribuinte) {
        super(username, password, email, primeiroNome, contacto, numeroContribuinte);
        this.loja = loja;
        this.hierarquia = hierarquia;
        this.listaEncomendas = new LinkedList<>();
    }

    public Funcionario(int hierarquia, String username, String password, String email, String primeiroNome, String ultimoNome, String morada, String contacto, String numeroContribuinte) {
        super(username, password, email, primeiroNome, ultimoNome, morada, contacto, numeroContribuinte);
        this.hierarquia = hierarquia;
        this.loja = null;
        this.listaEncomendas = new LinkedList<>();
    }

    public Funcionario(int hierarquia, String username, String password, String email, String primeiroNome, String contacto, String numeroContribuinte) {
        super(username, password, email, primeiroNome, contacto, numeroContribuinte);
        this.hierarquia = hierarquia;
        this.loja = null;
        this.listaEncomendas = new LinkedList<>();
    }

    public int getHierarquia() {
        return hierarquia;
    }

    public LinkedList<Encomenda> getListaEncomendas() {
        return listaEncomendas;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        setChange();
        this.loja = loja;
    }

    public void setHierarquia(int hierarquia) {
        setChange();
        this.hierarquia = hierarquia;
    }

    public void setListaEncomendas(LinkedList<Encomenda> listaEncomendas) {
        this.listaEncomendas = listaEncomendas;
    }
    
    public void addEncomenda(Encomenda encomenda) {
        this.setChange();
        if (listaEncomendas == null)
            listaEncomendas = new LinkedList<>();
        listaEncomendas.add(encomenda);
    }
    
    public void remEncomenda(Encomenda encomenda) {
        this.setChange();
        if (listaEncomendas == null)
            return;
        if (listaEncomendas.contains(encomenda))
            listaEncomendas.remove();
    }
}
