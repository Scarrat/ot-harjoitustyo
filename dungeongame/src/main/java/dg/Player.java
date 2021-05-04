
package dg;

public class Player {

    private int health;
    private int x;
    private int y;

    public Player() {
        this.health = 10;
        this.x = 2;
        this.y = 4;

    }

    public void healthChange(int amount) {
        this.health += amount;
        if (health < 1) {
            System.out.println("You died");
        }
        if (health > 10) {
            health = 10;
        }
    }

    public int getHealth() {
        return this.health;
    }

    public void setLoc(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
