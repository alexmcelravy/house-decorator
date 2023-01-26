import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.stage.Stage;

/**
 *
 * @author Alex McElravy
 * This class is designed to help the user draw a house.
 * The user will call the method to draw the house outline,
 * then call the appropriate methods to add decor to the house.
 * 
 * * Docs McElravy_API_HouseDecorator.pdf
 */

public class API_HouseDecorator extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
    }
     /**
     * Creates scene of the given width & height. If either value is less
     * than 100 then the window will default to a size of 500 X 500
     * @param pane Pane used in application
     * @param w Desired WIDTH of the GUI
     * @param h Desired HEIGHT of the GUI
     * @return a Scene with desired Width & Height
     */
     
    public Scene createScene(Pane pane, int w, int h) {
        
        int[] sizeArr = {w, h};
        
        if (w < 100 || h < 100) {
            System.err.println("Invalid height or width. Default size " +
                    "(1000, 500) has been set");
            sizeArr[0] = 1000;
            sizeArr[1] = 500;
        }
        Scene scene = new Scene(pane, sizeArr[0], sizeArr[1]);
        return scene;
    }
    
    /**
     * Draws a house based on the Scene's width and height.
     * @param pane Pane used in the Application
     * @param houseColor Desired hex color of the house
     * @param roofColor Desired hex color of house roof
     */
    public void createHouse(Pane pane, String houseColor, String roofColor){
        double centerX = (pane.getWidth())/2;
        double centerY = (pane.getHeight())/2;
        
        Rectangle rightSide = new Rectangle(centerX, centerY, (0.7 * centerX), (0.9 * centerY));
        rightSide.setFill(Color.web(houseColor));
        setStandardStroke(rightSide);
        
        Polygon leftSide = new Polygon();
        leftSide.getPoints().addAll(new Double[]{
        centerX, (0.75*centerY),
        centerX, (1.9*centerY),
        (0.25*centerX), (1.9*centerY),
        (0.25*centerX),(0.75*centerY),
        (0.625*centerX),(0.25*centerY)});
        leftSide.setFill(Color.web(houseColor));
        setStandardStroke(leftSide);
        
        Polygon rightRoof = new Polygon();
        rightRoof.getPoints().addAll(new Double[]{
        (1.7*centerX), centerY,
        (1.8*centerX), centerY,
        (1.7*centerX), (0.35*centerY),
        (0.7*centerX), (0.35*centerY),
        centerX,(0.75*centerY),
        centerX, centerY});
        rightRoof.setFill(Color.web(roofColor));
        setStandardStroke(rightRoof);
        
        Polygon leftRoof = new Polygon();
        leftRoof.getPoints().addAll(new Double[]{
            (0.25*centerX),(0.75*centerY),
            (0.625*centerX),(0.25*centerY),
            centerX, (0.75*centerY),
            (1.05*centerX), (0.75*centerY),
            (0.625*centerX),(0.18*centerY),
            (0.2*centerX),(0.75*centerY)
        });
        leftRoof.setFill(Color.web(roofColor));
        setStandardStroke(leftRoof);
        
        pane.getChildren().addAll(rightSide, leftSide, rightRoof, leftRoof);
    }
    
    /**
     * Draws a door for the house.
     * @param pane Pane used in Application
     * @param color Desired hex color of the door
     * @param x X-coordinate of the top left of the door
     * @param y Y-coordinate of the top left of the door
     */
    public void addDoor(Pane pane, String color, double x, int y){
        double centerX = (pane.getWidth())/2;
        double centerY = (pane.getHeight())/2;
        Rectangle doorBase = new Rectangle(x, y, (0.2*centerX), (0.6*centerY));
        doorBase.setFill(Color.web(color));
        setStandardStroke(doorBase);
        Circle doorHandle = new Circle((x + (0.91*doorBase.getWidth())),(y + (0.47*doorBase.getHeight())), (0.05*doorBase.getWidth()), Color.PALEGOLDENROD);
        
        Rectangle doorTop = new Rectangle((x + (0.1*doorBase.getWidth())), (y + (0.1*doorBase.getHeight())), (0.8*doorBase.getWidth()), (0.3*doorBase.getHeight()));
        doorTop.setFill(Color.TRANSPARENT);
        setStandardStroke(doorTop);
        
        Rectangle doorBottom = new Rectangle((x + (0.1*doorBase.getWidth())), (y + (0.55*doorBase.getHeight())), (0.8*doorBase.getWidth()), (0.35*doorBase.getHeight()));
        doorBottom.setFill(Color.TRANSPARENT);
        setStandardStroke(doorBottom);
                
        pane.getChildren().addAll(doorBase, doorTop, doorBottom, doorHandle);
    }
    
    /**
     * Adds a tree image to the house.
     * @param pane Pane used in Application
     * @param x X-coordinate of the top left of the tree
     * @param y Y-coordinate of the top left of the tree
     */
    public void addTree(Pane pane, double x, double y){
        Image treeIMG = new Image("https://clipartix.com/wp-content/uploads/2016/08/Trees-green-tree-clip-art-at-clker-vector-clip-art.png");
        ImageView tree = new ImageView(treeIMG);
        tree.setX(x);
        tree.setY(y);
        pane.getChildren().add(tree);
    }
    
    /**
     * Draws a window to add to the house.
     * @param pane Pane used in Application
     * @param x X-coordinate of the top left of the window
     * @param y Y-coordinate of the top left of the window
     * @param scale Size multiplier of the base window size
     */
    public void addWindow(Pane pane, double x, double y, double scale){
        double centerX = (pane.getWidth())/2;
        double centerY = (pane.getHeight())/2;
        
        Rectangle windowBase = new Rectangle(x, y, (scale * (0.4*centerX)), (scale * (0.6*centerY)));
        windowBase.setFill(Color.LIGHTSLATEGRAY);
        windowBase.setStroke(Color.BLACK);
        windowBase.setStrokeWidth(5);
        
        Line windowPane1 = new Line((x+(0.5*windowBase.getWidth())), y, (x+(0.5*windowBase.getWidth())), (y + windowBase.getHeight()));
        setStandardStroke(windowPane1);
        
        Line windowPane2 = new Line(x, (y+(0.5*windowBase.getHeight())), (x+windowBase.getWidth()), (y+(0.5*windowBase.getHeight())));
        setStandardStroke(windowPane2);
        
        pane.getChildren().addAll(windowBase, windowPane1, windowPane2);
        
    }
    
    /**
     * Draws a chimney to add to the house.
     * @param pane Pane used in Application
     * @param color Desired hex color of the chimney
     * @param x X-coordinate of the top left of the chimney
     * @param y Y-coordinate of the top left of the chimney
     */
    public void addChimney(Pane pane, String color, int x, int y){
        double centerX = (pane.getWidth())/2;
        double centerY = (pane.getHeight())/2;
        
        Rectangle chimneyTop = new Rectangle(x, y, (0.15*centerX), (0.07*centerY));
        chimneyTop.setFill(Color.web(color));
        setStandardStroke(chimneyTop);
        Rectangle chimneyBottom = new Rectangle((x+(0.15*chimneyTop.getWidth())), (y+chimneyTop.getHeight()), (0.1*centerX), (0.2*centerY));
        chimneyBottom.setFill(Color.web(color));
        setStandardStroke(chimneyBottom);
        
        pane.getChildren().addAll(chimneyTop, chimneyBottom);
    }
    
    /**
     * Sets any shape objects Stroke Width to 3
     * and Stroke Color to black.
     * @param s Shape to be set
     */
    public void setStandardStroke(Shape s){
        s.setStroke(Color.BLACK);
        s.setStrokeWidth(3);
    }

    
}
