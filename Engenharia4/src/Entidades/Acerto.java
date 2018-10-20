package Entidades;

import Util.Banco;

public class Acerto
{
    private int codigo;
    private Produto produto;
    private int quantidade;
    private int tipo;
    
    //tipo 1 = entrada, 2 = saida

    public Acerto(int codigo, Produto produto, int quantidade, int tipo) {
        this.codigo = codigo;
        this.produto = produto;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }

    public Acerto(Produto produto, int quantidade, int tipo) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }

    public Acerto() 
    {
        this(0,null,0,0);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    
    public  boolean gravar()
    {
        String sql = "insert into acerto (pro_cod,ace_quantidade,ace_tipo) values ('$1','$2','$3')";
        //sql = sql.replace("$1", ""+this.getCodigo());
        sql = sql.replace("$1", ""+this.getProduto().getCodigo());
        sql = sql.replace("$2", ""+this.getQuantidade());
        sql = sql.replace("$3", ""+this.getTipo());
        return Banco.con.manipular(sql);
    }
    
}
