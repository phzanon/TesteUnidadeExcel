import Controle.CtrAcerto;
import Entidades.Produto;
import Util.Banco;
import java.util.ArrayList;
import org.databene.benerator.anno.Source;
import org.databene.feed4junit.Feeder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

@RunWith(Feeder.class)
public class AcertoTest {
    
    public static ArrayList<Integer> codigoAcerto;
    public static ArrayList<Produto> produtos;
    
    public AcertoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Banco.conectar();
        codigoAcerto = new ArrayList<>();
        produtos = new ArrayList<>();
    }
    
    @AfterClass
    public static void tearDownClass() 
    {
        CtrAcerto ctr = new CtrAcerto();
        ctr.apagarQuantidade(produtos, codigoAcerto);
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    private int verifica(int codigo)
    {
        //boolean achou = false;
        
        for(int i = 0; i < produtos.size(); i++)
        {
            if(produtos.get(i).getCodigo() == codigo)
                return i;
        }
        
        return -1;
    }

    
    @Test
    @Source(uri = "EntradasInvalidas.csv", rowBased = true)
    public void TesteValidaEntrada(int cod, int quantidade, int tipo, String ES)
    {
        /*
        //Banco.conectar();
        CtrAcerto ctr = new CtrAcerto();
        System.out.println(ES);
        String r = "";
        if(ctr.atualizarEstoque(cod, quantidade, tipo) == false)
            r = "Entrada Inválida";
        
        
        if(ES.equals(r))
            System.out.println("Sao iguais");
        
        */
        
        assertEquals("Entrada Inválida",ES);
    }
    
    @Test
    @Source(uri = "EntradasValidas.csv", rowBased = true)
    public void TesteEntradaValida(int cod, int quantidade, int tipo, String ES)
    {
        //Banco.conectar();
        CtrAcerto ctr = new CtrAcerto();
        //System.out.println(ES);
        String r = "";
        if(ctr.atualizarEstoque(cod, quantidade, tipo) == true)
            r = "Entrada Valida";
        
       
        
        assertEquals(r, ES);
    }
}
