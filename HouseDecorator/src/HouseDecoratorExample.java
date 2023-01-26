import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author alexismcelravy
 */
public class HouseDecoratorExample extends API_HouseDecorator {

     public static void main(String[] args) {
        launch();
    }
     
    @Override
    public void start(Stage primaryStage) {
        API_HouseDecorator house = new API_HouseDecorator();
        //StackPane sp = new StackPane();
 
        Pane p = new Pane();
        Scene scene = house.createScene(p, 0, 0);
        
        scene.setFill(Color.DEEPSKYBLUE);
        house.createHouse(p, "#ba9f77", "#1d3d27");
        house.addDoor(p, "#1d3d27", 700 ,390);
        house.addWindow(p, 870, 375, 0.5);
        house.addWindow(p, 233, 250, 1.2);
        house.addChimney(p, "#1d3d27", 900, 50);
        house.addTree(p, 0, 300);
        house.addTree(p, 1000, 300);
        
        primaryStage.setTitle("House Decorator 2022");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();
    }
    
}
