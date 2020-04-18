
package homework2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Q3 extends Application {

    TextArea ta;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("working with menus is very sadd");
        MenuBar menubar = new MenuBar();
        Menu menuFile = new Menu("_File");
        MenuItem MenuItemopen = new MenuItem("_open");
        MenuItem MenuItemclose = new MenuItem("_close");
        MenuItem MenuItemExit = new MenuItem("E_xit");
        menuFile.getItems().addAll(MenuItemopen, MenuItemclose, MenuItemExit);
        Menu menuEdit = new Menu("_Edit");
        MenuItem MenuItemColor = new MenuItem("Co_lor");
        MenuItem MenuItemFont = new MenuItem("_Font");
        
		
        menuEdit.getItems().addAll(MenuItemFont, MenuItemColor);
        menubar.getMenus().addAll(menuFile, menuEdit);
        
        TextArea ta = new TextArea();
        VBox VB = new VBox(10, menubar, ta);
        
        
        
		
        
        MenuItemColor.setOnAction((event) -> {
            
            Dialog<String> dialogColor = new TextInputDialog();
            dialogColor.setTitle("color");
            dialogColor.setHeaderText("Select color");
            String ccolor = (dialogColor.showAndWait()).get();
            
            ta.setStyle(ta.getStyle()+ "-fx-text-fill : " + ccolor+";");
        });
        MenuItemFont.setOnAction((event) -> {
            
            Dialog<String> dialogfont = new TextInputDialog();
            dialogfont.setTitle("Font");
            dialogfont.setHeaderText("Select Font");
            String Font = (dialogfont.showAndWait()).get();
            
            ta.setStyle(ta.getStyle()+ "-fx-font-size : " + Font+";");
        });
        MenuItemclose.setOnAction((event) -> {
           ta.setText("");
           ta.setEditable(false);
        });
        MenuItemExit.setOnAction((event) -> {
          primaryStage.close();
        });
        MenuItemopen.setOnAction((event) -> {
            FileChooser Fc = new FileChooser();
            Fc.setTitle("opinning File");
			
            Fc.setInitialDirectory(new File("."));
            File file = Fc.showOpenDialog(null);
            Scanner Sn;
            ta.setText("");
            
            try {
                Sn = new Scanner(file);
                while (Sn.hasNext()) {
                    ta.appendText(Sn.nextLine());
                    
                }
                
            } catch (Exception e) {
            }
        });
        
        Scene s = new Scene(VB);
        primaryStage.setResizable(false);
        primaryStage.setScene(s);
        primaryStage.show();
    }

   
    public static void main(String[] args) {
        launch(args);
    }

    
}
