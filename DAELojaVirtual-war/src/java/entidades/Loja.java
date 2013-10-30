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
import javax.validation.constraints.NotNull;

@Entity @Table(name="LOJAS")
public class Loja extends GeneralData implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToMany(mappedBy = "loja")
    private LinkedList<Funcionario> listaFuncionarios;
    @OneToMany(mappedBy = "loja")
    private LinkedList<Encomenda> listaEncomendas;
    
    @OneToMany(mappedBy = "loja")
    private LinkedList<ProdutoNaLoja> listaProdutosLoja;
    
    private String morada;
    @NotNull
    private String codigoPostal;
    @NotNull
    private String numeroContribuinte;
    
    public Loja() {
    }

    public Loja(String codigoPostal, String numeroContribuinte) {
        this.codigoPostal = codigoPostal;
        this.numeroContribuinte = numeroContribuinte;
        this.morada = null;
        this.listaFuncionarios = new LinkedList<>();
        this.listaEncomendas = new LinkedList<>();
        this.listaProdutosLoja = new LinkedList<>();
    }

    public Loja(String morada, String codigoPostal, String numeroContribuinte) {
        this.morada = morada;
        this.codigoPostal = codigoPostal;
        this.numeroContribuinte = numeroContribuinte;
        this.listaFuncionarios = new LinkedList<>();
        this.listaEncomendas = new LinkedList<>();
        this.listaProdutosLoja = new LinkedList<>();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.listaFuncionarios);
        hash = 29 * hash + Objects.hashCode(this.listaEncomendas);
        hash = 29 * hash + Objects.hashCode(this.listaProdutosLoja);
        hash = 29 * hash + Objects.hashCode(this.morada);
        hash = 29 * hash + Objects.hashCode(this.codigoPostal);
        hash = 29 * hash + Objects.hashCode(this.numeroContribuinte);
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
        final Loja other = (Loja) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Loja{" + "id=" + id + ", listaFuncionarios=" + listaFuncionarios + ", listaEncomendas=" + listaEncomendas + ", listaProdutosLoja=" + listaProdutosLoja + ", morada=" + morada + ", codigoPostal=" + codigoPostal + ", numeroContribuinte=" + numeroContribuinte + '}';
    }

    public Long getId() {
        return id;
    }

    public String getNumeroContribuinte() {
        return numeroContribuinte;
    }
    
    public String getMorada() {
        return morada;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public LinkedList<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public LinkedList<Encomenda> getListaEncomendas() {
        return listaEncomendas;
    }

    public LinkedList<ProdutoNaLoja> getListaProdutosLoja() {
        return listaProdutosLoja;
    }

    public void setListaFuncionarios(LinkedList<Funcionario> listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
    }

    public void setListaEncomendas(LinkedList<Encomenda> listaEncomendas) {
        this.listaEncomendas = listaEncomendas;
    }

    public void setListaProdutosLoja(LinkedList<ProdutoNaLoja> listaProdutosLoja) {
        this.listaProdutosLoja = listaProdutosLoja;
    }

    public void setNumeroContribuinte(String numeroContribuinte) {
        this.setChange();
        this.numeroContribuinte = numeroContribuinte;
    }
    
    public void setMorada(String morada) {
        this.setChange();
        this.morada = morada;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.setChange();
        this.codigoPostal = codigoPostal;
    }

    public void addFuncionario(Funcionario funcionario) {
        if (listaFuncionarios == null)
            listaFuncionarios = new LinkedList<>();
        listaFuncionarios.add(funcionario);
    }
    
    public void remFuncionario(Funcionario funcionario) {
        if (listaFuncionarios == null)
            return;
        if (listaFuncionarios.contains(funcionario))
            listaFuncionarios.remove(funcionario);
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
            listaEncomendas.remove(encomenda);
    }
    
    public void addProdutosLoja(ProdutoNaLoja produtoNaLoja) {
        if (listaProdutosLoja == null)
            listaProdutosLoja = new LinkedList<>();
        listaProdutosLoja.add(produtoNaLoja);
    }
    
    public void remProdutosLoja(ProdutoNaLoja produtoNaLoja) {
        if (listaProdutosLoja == null)
            return;
        if (listaProdutosLoja.contains(produtoNaLoja))
            listaProdutosLoja.remove(produtoNaLoja);
    }
}
