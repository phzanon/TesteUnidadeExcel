package Util;

public class Banco 
{
    static public Conexao con=null;
    
    private Banco(){}    
    static public boolean conectar()
    {
        if (con != null)
            return true;
        
        con = new Conexao();
        return con.conectar("jdbc:postgresql://localhost:5432/", "eng4", "postgres", "postgres123");
    }
    
    
}
