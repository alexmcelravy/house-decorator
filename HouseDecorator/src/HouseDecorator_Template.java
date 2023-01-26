import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author Alex McElravy
 * 
 * This file is designed to be used as a File > Save As to create your own 
 * version of the program by following the API documentation
 * 
 * Lines for programmer to change are labeled with TODO:
 * Uncomment code in the Start method & use house. Add your desired colors and 
 * change the x, y coordinates of the elements to create your own house!
 * 
 */

public class HouseDecorator_Template extends API_HouseDecorator {

   
    public static void main(String[] args) {
        launch();
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        // To access methods of the API use house.
        API_HouseDecorator house = new API_HouseDecorator();
        Pane p = new Pane();
        
        // TODO: Create scene - house.createScene()
        // Scene scene = 
        
        // TODO: House
        // Draw house outline. 
        // house.createHouse(p, "#", "#");
        
        // TODO: Door
        // Draw door and position on the desired part of the house
        // house.addDoor(p, "#", doorX, doorY);
        
        // TODO: Windows
        // Draw window(s) and position on the desired part of house, use scale
        // as a multiplier to change the size from the base window
        // house.addWindow(p, windowX, windowY, scale);
        
        // TODO: Chimney
        // Draw chimney and position on the desired part of the house
        // house.addChimney(p, "#", chimneyX, chimneyY);
        
        // TODO: Trees
        // Add tree(s) and position on the desired part of the house
        // house.addTree(p, treeX, treeY);
        
        // Note errors will resolve once above code is uncommented and edited
        primaryStage.setTitle("House Decorator 2022");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();
    }
    
}
