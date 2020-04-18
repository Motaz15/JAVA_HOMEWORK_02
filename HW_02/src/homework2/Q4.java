
package homework2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Q4 extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Label l1 = new Label("Welcome");
        Label l2 = new Label("user name :");
        Label l3 = new Label("Password :");
        l1.setId("l1");
        l2.setId("l2");
        l3.setId("l2");
        TextField tf = new TextField();
        TextField tf1 = new TextField();
        Button btn1 = new Button("Sign up");
        Button btn2 = new Button("Exit");
        Button btn3 = new Button("Add Student");
        Button btn4 = new Button("view Student");
        HBox hb = new HBox(10,l2,tf);
        HBox hb1 = new HBox(10,l3,tf1);
        HBox hb2 = new HBox(10,btn1,btn2);
        hb.setAlignment(Pos.CENTER);
        hb1.setAlignment(Pos.CENTER);
        hb2.setAlignment(Pos.BASELINE_RIGHT);
        VBox vb = new VBox(10,l1,hb,hb1,hb2);
        VBox vb1 = new VBox(10,btn3,btn4);
        vb.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vb, 300, 250);
        scene.getStylesheets().add("Style.css");
        primaryStage.setTitle("LOGIN FORM");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        String filepath = "password.txt";
        File file = new File(filepath);
        file.createNewFile();
        Scanner scanner = new Scanner(file);
        btn1.setOnAction((ActionEvent event) -> {
            while (scanner.hasNextLine()) {
                 String line = scanner.nextLine();
                if (line.contains(tf.getText()) && line.contains(tf1.getText())){
                     Scene s = new Scene(vb1);
                     primaryStage.setScene(s);
         }}
        
        });

       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
