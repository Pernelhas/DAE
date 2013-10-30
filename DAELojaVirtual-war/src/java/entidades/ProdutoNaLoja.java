package entidades;

import java.io.Serializable;
import java.util.LinkedList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity @Table(name="PRODUTO_LOJA") @IdClass(ProdutoNaLojaId.class) 
public class ProdutoNaLoja extends GeneralData implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    private Long idProduto;
    @Id
    private Long idLoja;

    @ManyToOne
    @PrimaryKeyJoinColumn(name="IDPRODUTO", referencedColumnName="ID")
    private Produto produto;
    @ManyToOne
    @PrimaryKeyJoinColumn(name="IDLOJA", referencedColumnName="ID")
    private Loja loja;
    
    @Column(name = "PRECO_PRODUTO_LOJA") @NotNull
    private double preco;
    @Column(name = "STOCK_PRODUTO_LOJA") @NotNull
    private int stock;
    @Column(name = "REF_PRODUTO_LOJA") @NotNull
    private String codigoBarras;
    @OneToMany
    private LinkedList<LinhaHistorico> listaHistoricoStock;

    public ProdutoNaLoja() {
    }

    public ProdutoNaLoja(Produto produto, Loja loja, double preco, int stock, String codigoBarras) {
        this.produto = produto;
        this.loja = loja;
        this.preco = preco;
        this.stock = stock;
        this.codigoBarras = codigoBarras;
        this.idProduto = produto.getId();
        this.idLoja = loja.getId();
        this.listaHistoricoStock = new LinkedList<>();
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public Long getIdLoja() {
        return idLoja;
    }

    public Produto getProduto() {
        return produto;
    }

    public Loja getLoja() {
        return loja;
    }

    public LinkedList<LinhaHistorico> getListaHistoricoStock() {
        return listaHistoricoStock;
    }
    
    public int getStock() {
        return stock;
    }

    public double getPreco() {
        return preco;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setPreco(double preco) {
        this.setChange();
        this.preco = preco;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.setChange();
        this.codigoBarras = codigoBarras;
    }

    public void addStock(int stock) {
        LinhaHistorico linha = new LinhaHistorico(stock, true);
        listaHistoricoStock.addLast(linha);
        this.stock += stock;
    }
    
    public void remStock(int stock) {
        LinhaHistorico linha = new LinhaHistorico(stock, false);
        listaHistoricoStock.addLast(linha);
        this.stock -= stock;
    }
}
