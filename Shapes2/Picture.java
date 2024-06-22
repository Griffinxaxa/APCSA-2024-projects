import java.io.File;
import java.io.IOException;

public class Picture {
    public static void main(String[] args) {
        // Get a reference to the canvas for this drawing
        // The size of the canvas is 800 x 600 with a white background.
        Canvas pic = Canvas.getCanvas();

        // Set the title and background for the picture
        pic.setTitle("My Picture");
        pic.setBackgroundColor("blue");

        // Draw a picture using two kinds of composite shapes,
        // that are implemented internally using circles, triangles,
        // and rectangles.
        Cloud cloud1 = new Cloud(50, 50);
        cloud1.makeVisible();
        Cloud cloud2 = new Cloud(350, 150);
        cloud2.makeVisible();
        Tree Tree1 = new Tree(200, 200);
        Tree1.makeVisible();
        System.out.println("the first tree coords:" + Tree1.toString());
        //another
        Tree Tree2 = new Tree(400, 100);
        Tree2.makeVisible();
        System.out.println("the second tree coords:" + Tree2.toString());
        //custom object house
        House house1 = new House(300, 320);
        House house2 = new House(500, 200);
        //the cords with labels
        System.out.println("the first house coords: " + house1.toString());
        System.out.println("the second house coords: " + house2.toString());
        house1.makeVisible();
        house2.makeVisible();
        // You'll need to create a new file for each new custom
        // shape class that you create.
        
        
        pic.redraw();
        
        // Don't make ANY changes to the code below!
        String filename = "pic.png";
        try {
            pic.saveToFile(new File(filename));
            System.err.println("Picture saved to " + filename);
        } catch (IOException e) {
            System.err.println(e);
            System.err.println("Could not save file.");
        }
    }
}
