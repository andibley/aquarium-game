import java.awt.*;

public class ArrayFish {
    public int height;
    public int length;

    public Image pic;


        public String name;                //holds the name of the hero
        public int xpos;                //the x position
        public int ypos;                //the y position
        public int dx;                    //the speed of the hero in the x direction
        public int dy;                    //the speed of the hero in the y direction
        public int width;
        public boolean isAlive;
        public Rectangle rec;
    public ArrayFish(int pHeight) {height = pHeight;
    }

    public ArrayFish (int Pxpos, int Pypos){
        xpos = Pxpos;
        ypos = Pypos;
        dx = 8;
        dy = 1;
        width = 60;
        height = 60;
        isAlive = true;

    }
    public void move(){
        if (xpos > 1000-60) {
            dx = -dx;

        }
        if (ypos > 700-60) {
            dy = -dy;
        }
        if (xpos < 0) {
            dx = -dx;

        }
        if (ypos < 0) {
            dy = -dy;
        }
        xpos = xpos + dx;
        ypos = ypos + dy;
        rec = new Rectangle(xpos,ypos,height,width);
    }

}
