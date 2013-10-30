package entidades;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity @Table(name="ENCOMENDAS")
public class Encomenda extends GeneralData implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigoEncomenda;
    
    @OneToMany @NotNull
    private LinkedList<LinhaEncomenda> listaLinhasEncomenda;
    @ManyToOne @NotNull
    private Consumidor consumidor;
    @ManyToOne
    private Loja loja;
    @ManyToOne
    private Funcionario funcionario;
    
    private String moradaEntrega;
    @NotNull
    private String estado;

    public Encomenda() {
    }

    public Encomenda(LinkedList<LinhaEncomenda> listaLinhasEncomenda, Consumidor consumidor, String estado) {
        this.consumidor = consumidor;
        this.estado = estado;
        this.listaLinhasEncomenda = listaLinhasEncomenda;
        this.loja = null;
        this.funcionario = null;
        this.moradaEntrega = null;
    }

    public Encomenda(LinkedList<LinhaEncomenda> listaLinhasEncomenda, Consumidor consumidor, Loja loja, Funcionario funcionario, String moradaEntrega, String estado) {
        this.listaLinhasEncomenda = listaLinhasEncomenda;
        this.consumidor = consumidor;
        this.loja = loja;
        this.funcionario = funcionario;
        this.moradaEntrega = moradaEntrega;
        this.estado = estado;
    }
    
    public Encomenda(CarrinhoCompras carrinhoCompras) {
        this.listaLinhasEncomenda = carrinhoCompras.getListaLinhasEncomenda();
        this.consumidor = carrinhoCompras.getConsumidor();
        this.loja = null;
        this.funcionario = null;
        this.moradaEntrega = null;
        this.estado = "Encomendado";
    }
    
    public Encomenda(CarrinhoCompras carrinhoCompras, Loja loja, Funcionario funcionario, String moradaEntrega) {
        this.listaLinhasEncomenda = carrinhoCompras.getListaLinhasEncomenda();
        this.consumidor = carrinhoCompras.getConsumidor();
        this.loja = loja;
        this.funcionario = funcionario;
        this.moradaEntrega = moradaEntrega;
        this.estado = "Encomendado";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.codigoEncomenda);
        hash = 71 * hash + Objects.hashCode(this.listaLinhasEncomenda);
        hash = 71 * hash + Objects.hashCode(this.consumidor);
        hash = 71 * hash + Objects.hashCode(this.loja);
        hash = 71 * hash + Objects.hashCode(this.funcionario);
        hash = 71 * hash + Objects.hashCode(this.moradaEntrega);
        hash = 71 * hash + Objects.hashCode(this.estado);
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
        final Encomenda other = (Encomenda) obj;
        if (!Objects.equals(this.codigoEncomenda, other.codigoEncomenda)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Encomenda{" + "codigoEncomenda=" + codigoEncomenda + ", listaLinhasEncomenda=" + listaLinhasEncomenda + ", consumidor=" + consumidor + ", loja=" + loja + ", funcionario=" + funcionario + ", moradaEntrega=" + moradaEntrega + ", estado=" + estado + '}';
    }

    public Long getCodigoEncomenda() {
        return codigoEncomenda;
    }

    public LinkedList<LinhaEncomenda> getListaLinhasEncomenda() {
        return listaLinhasEncomenda;
    }

    public void setListaLinhasEncomenda(LinkedList<LinhaEncomenda> listaLinhasEncomenda) {
        this.listaLinhasEncomenda = listaLinhasEncomenda;
    }

    public Consumidor getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(Consumidor consumidor) {
        this.consumidor = consumidor;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.setChange();
        this.loja = loja;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.setChange();
        this.funcionario = funcionario;
    }

    public String getMoradaEntrega() {
        return moradaEntrega;
    }

    public void setMoradaEntrega(String moradaEntrega) {
        this.setChange();
        this.moradaEntrega = moradaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.setChange();
        this.estado = estado;
    }

    public void addLinhaEncomenda(LinhaEncomenda linhaEncomenda) {
        this.setChange();
        if (listaLinhasEncomenda == null)
            listaLinhasEncomenda = new LinkedList<>();
        listaLinhasEncomenda.add(linhaEncomenda);
    }
    
    public void remLinhaEncomenda(LinhaEncomenda linhaEncomenda) {
        this.setChange();
        if (listaLinhasEncomenda == null)
            return;
        if (listaLinhasEncomenda.contains(linhaEncomenda))
            linhaEncomenda.remove();
    }
}
