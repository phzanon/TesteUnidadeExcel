package engenharia4;

import Util.Banco;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Engenharia4 extends Application {
    
    @Override
    public void start(Stage stage) 
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ui/TelaAcerto.fxml"));
            Scene scene = new Scene(root);
            //Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        if(Banco.conectar())
        {
            System.out.println("Conectou");
        }
        else
            System.out.println("Nao Conectou: "+Banco.con.getMensagemErro());
            
        launch(args);
    }
    
}
