package entidades;

import java.io.Serializable;
import java.util.LinkedList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity @Table(name="CARRINHOS_COMPRAS")
public class CarrinhoCompras extends GeneralData implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "carrinhoCompras")
    private Consumidor consumidor;
    @OneToMany
    private LinkedList<LinhaEncomenda> listaLinhasEncomenda;

    public CarrinhoCompras() {
        super();
    }

    public CarrinhoCompras(Consumidor consumidor) {
        super();
        this.consumidor = consumidor;
        this.listaLinhasEncomenda = new LinkedList<>();
    }

    public Consumidor getConsumidor() {
        return consumidor;
    }

    public LinkedList<LinhaEncomenda> getListaLinhasEncomenda() {
        return listaLinhasEncomenda;
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
