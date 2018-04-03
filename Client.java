import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Client extends Application
{
    CharacterControl cc;
    public static void main(String[] args) {
        launch(args);
    }
   
    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("Ablegó");
        Button btn = new Button("Ablegó");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) 
            {

                cc.populateServer(10);
            }
            
        });
        
               
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        StackPane CharacterList = new StackPane();
        
        
        Scene scene = new Scene(root, 300, 250);
       
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
