
package dg;

import javafx.scene.image.Image;

public class Room {

    private int x;
    private int y;
    private String type;
    private boolean found;
    private Image image;
    private boolean player;

    Image b = new Image("images/Groundblack.png");
    Image w = new Image("images/Groundwhite.png");
    Image p = new Image("images/Currloc.png");

    public Room(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.found = false;
        this.player = false;
        this.image = b;
        if (type == 0) {
            this.type = "empty";
        }
        if (type == 1) {
            this.type = "trap";
        }
        if (type == 2) {
            this.type = "potion";
        }
        if (type == 3) {
            this.type = "bigtrap";
        }
        if (type == 4) {
            this.type = "bigpotion";
        }
        if (type == 5) {
            this.type = "exit";
        }
    }

    public String getType() {
        return type;
    }

    public int getTypeNum() {
        if (type.equals("empty")) {
            return 0;
        }
        if (type.equals("trap")) {
            return 1;
        }
        if (type.equals("potion")) {
            return 2;
        }
        if (type.equals("bigtrap")) {
            return 3;
        }
        if (type.equals("bigpotion")) {
            return 4;
        }
        if (type.equals("exit")) {
            return 5;
        }
        return -1;
    }

    public Image getImage() {
        return this.image;
    }

    public void leave() {
        this.image = w;
        this.player = false;
    }

    public void step() {
        this.image = p;
        this.player = true;
    }

    public boolean isPlayer() {
        return this.player;
    }

}
