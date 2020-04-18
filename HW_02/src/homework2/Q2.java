
package homework2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Q2 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Label L1 = new Label("Enter Celsius temperature:");
        Label L2 = new Label();
        TextField tf = new TextField();
        tf.setText("1");
        RadioButton rb = new RadioButton("Fahrenheit");
        RadioButton rb1 = new RadioButton("Kelvin");
        rb.setSelected(true);
		
         ToggleGroup tg = new ToggleGroup();
        rb.setToggleGroup(tg);
        rb1.setToggleGroup(tg);
       
	   
	   
         rb.setOnAction((event) -> {
			 
          double m = ((Double.parseDouble(tf.getText())*9/5)+32);
                  L2.setText("New Temperature in is :"+m);
        });
         rb1.setOnAction((event) -> {
          double m = (Double.parseDouble(tf.getText())+273.15);
                  L2.setText("Neww Temperature in is :"+m);
        });
         HBox hb = new HBox(10,rb,rb1);
        VBox vb = new VBox(10,L1,tf,hb,L2);
        Scene scene = new Scene(vb, 300, 250);
        
		
        primaryStage.setTitle("Temperature converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	

    public static void main(String[] args) {
        launch(args);
    }
    
}
