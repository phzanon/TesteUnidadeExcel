package Controle;

import Entidades.Acerto;
import Entidades.Produto;
import Util.Banco;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CtrAcerto
{
    
    public Produto get(int cod)
    {
        String sql = "select * from produto where pro_cod="+cod;
        Produto p = null;
        
        ResultSet rs = Banco.con.consultar(sql);
        
        try
        {
            if(rs.next())
                p = new Produto(cod, rs.getString("pro_descricao"), rs.getInt("pro_quantidade"), rs.getDouble("pro_valor"));
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return p;
    }
    
    public ArrayList<Produto> getProdutos()
    {
        ArrayList<Produto> produtos = new ArrayList<>();
        String sql = "select * from produto";
        
        ResultSet rs = Banco.con.consultar(sql);
        
        try
        {
            while(rs.next())
            {
                produtos.add(new Produto(rs.getInt("pro_cod"), rs.getString("pro_descricao"), rs.getInt("pro_quantidade"), rs.getDouble("pro_valor")));
            }
        }
        catch(Exception e)
        {
            
        }
        
        return produtos;
    }
    
    public boolean atualizarEstoque(int codigo, int quantidade, int tipo)
    {
        Produto p = get(codigo);
        Acerto a = new Acerto(p, quantidade, tipo);
        boolean retorno = false;
        if(p != null)
        {
            if(tipo == 1)
            {
                //entrada
                if(quantidade > 0)
                {
                    int qtde = p.getQuantidade() + quantidade;
                    if(qtde > 0)
                        if(a.gravar() && p.atualizarEstoque(qtde))
                            retorno =  true;
                }
                
            }
            else
            {
                if(tipo == 2)
                {
                    if(quantidade > 0)
                    {
                        int qtde = p.getQuantidade() - quantidade;
                        if(qtde > 0 && qtde <= p.getQuantidade())
                            if(a.gravar() && p.atualizarEstoque(qtde))
                                retorno = true;
                    }
                    
                }
                
            }
        }
        return retorno;
    }
    
    
    public void apagarQuantidade(ArrayList<Produto> produtos, ArrayList<Integer> acertos)
    {
        for(int i = 0; i < produtos.size(); i++)
        {
            Produto p = get(produtos.get(i).getCodigo());
            int qtde = p.getQuantidade()- produtos.get(i).getQuantidade();
            String sql = "update produto set pro_quantidade='"+qtde+"' where pro_cod="+p.getCodigo();
            Banco.con.manipular(sql);
        }
        
        for(int i = 0; i < acertos.size(); i++)
        {
            String sql = "delete from acerto where ace_cod="+acertos.get(i);
            Banco.con.manipular(sql);
        }
    }
}
