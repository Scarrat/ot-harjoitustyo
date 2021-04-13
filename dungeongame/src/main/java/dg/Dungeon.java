package dg;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kostajoo
 */
import java.util.*;

public class Dungeon {

    private int xcoord;
    private int ycoord;
    private int[][] floor;

    public Dungeon() {
        this.floor = new int[5][5];
        this.xcoord = 2;
        this.ycoord = 5;
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 4 && j == 2) {
                    floor[i][j] = 0;
                } else {
                    floor[i][j] = r.nextInt(5) + 1;
                }
            }
        }

    }

    public void map() {
        for (int[] i : floor) {
            System.out.println("");
            for (int j : i) {
                System.out.print(j + ", ");
            }
        }
    }
    
    public int[][] floor() {
    return this.floor;
    }

}
