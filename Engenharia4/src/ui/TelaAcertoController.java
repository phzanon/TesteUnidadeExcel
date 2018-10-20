package ui;

import Controle.CtrAcerto;
import Entidades.Acerto;
import Entidades.Produto;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;


public class TelaAcertoController implements Initializable {

    @FXML
    private JFXComboBox<Produto> cbProduto;
    @FXML
    private JFXTextField tfQuantidade;
    @FXML
    private JFXRadioButton radioEntrada;
    @FXML
    private JFXRadioButton radioSaida;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregaCombo();
        radioEntrada.setSelected(true);
    }    
    
     private void carregaCombo()
    {
        ObservableList<Produto> modelo;
        CtrAcerto ctr = new CtrAcerto();
        ArrayList<Produto> produtos = ctr.getProdutos();
        modelo = FXCollections.observableList(produtos);
        cbProduto.setItems(modelo);
        cbProduto.getSelectionModel().select(0);
    }

    @FXML
    private void clkRadioEntrada(ActionEvent event) 
    {
        if(radioSaida.isSelected())
            radioSaida.setSelected(false);
    }

    @FXML
    private void clkRadioSaida(ActionEvent event) 
    {
        if(radioEntrada.isSelected())
            radioEntrada.setSelected(false);
    }

    @FXML
    private void btOK(ActionEvent event) 
    {
        //Produto p = cbProduto.getSelectionModel().getSelectedItem();
        //Acerto a = null;
        if(radioEntrada.isSelected())
        {
            //entrada
            //verificar Quantidade (>0)
            int qtde = Integer.parseInt(tfQuantidade.getText());
            
            CtrAcerto ctr = new CtrAcerto();
            if(ctr.atualizarEstoque(cbProduto.getSelectionModel().getSelectedItem().getCodigo(), qtde, 1))
                System.out.println("Acerto Realizado!");
            else
                System.out.println("Acerto nao realizado!");
        }
        else
        {
            //saida
            int qtde = Integer.parseInt(tfQuantidade.getText());
            
            CtrAcerto ctr = new CtrAcerto();
            if(ctr.atualizarEstoque(cbProduto.getSelectionModel().getSelectedItem().getCodigo(), qtde, 2))
                System.out.println("Acerto Realizado!");
            else
                System.out.println("Acerto nao realizado!");
            
        }
    }

    @FXML
    private void evtTesteEntrada1(MouseEvent event) 
    {
        if(radioSaida.isSelected())
            radioSaida.setSelected(false);
    }
    
}
