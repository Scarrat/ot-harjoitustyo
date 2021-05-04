package dg;

import java.util.*;

public class Dungeon {

    private int xcoord;
    private int ycoord;
    private boolean oneExit;

    private Room[][] rooms;
    private Room[][] backUp;

    public Dungeon() {
        this.rooms = new Room[5][5];
        this.xcoord = 2;
        this.ycoord = 4;
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 4 && j == 2) {
                    rooms[i][j] = new Room(j, i, 0);
                    rooms[i][j].step();
                } else if (!oneExit) {
                    rooms[i][j] = new Room(j, i, r.nextInt(5) + 1);
                    if (rooms[i][j].getType() == "exit") {
                        oneExit = true;
                    }
                } else {
                    rooms[i][j] = new Room(j, i, r.nextInt(5));
                }
            }
        }

    }

    public Room[][] floor() {
        return this.rooms;
    }

    public int getX() {
        return this.xcoord;
    }

    public int getY() {
        return this.ycoord;
    }

    public int move(int way) {
        rooms[ycoord][xcoord].leave();
        if (way == 1) {
            if (ycoord - 1 > -1) {
                ycoord -= 1;
            }
        }
        if (way == 2) {
            if (xcoord + 1 < 5) {
                xcoord += 1;
            }
        }
        if (way == 3) {
            if (ycoord + 1 < 5) {
                ycoord += 1;
            }
        }
        if (way == 4) {
            if (xcoord - 1 > -1) {
                xcoord -= 1;
            }
        }
        rooms[ycoord][xcoord].step();
        String type = rooms[ycoord][xcoord].getType();
        if (type.equals("empty")) {
            System.out.println("Nothing here");
            return 0;
        }
        if (type.equals("trap")) {
            System.out.println("Oof");
            return -1;
        }
        if (type.equals("bigtrap")) {
            System.out.println("OOF");
            return -3;
        }
        if (type.equals("potion")) {
            System.out.println("Heal");
            return +1;
        }
        if (type.equals("bigpotion")) {
            System.out.println("HEAL");
            return +3;
        }
        if (type.equals("exit")) {
            System.out.println("You won");
            return 5;
        }
        return 0;

    }

    public void reset() {
        Room[][] backUp = new Room[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                backUp[i][j] = new Room(j, i, rooms[i][j].getTypeNum());
            }
        }

        rooms = backUp;
        int oldx = xcoord;
        int oldy = ycoord;
        this.xcoord = 2;
        this.ycoord = 4;
        rooms[4][2].step();

    }

}
