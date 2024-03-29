public class Person {
    private int health;
    private int shelter;
    private int food;
    private boolean isDead;
    private boolean printable;
    public final String name;

    public Person(String name) {
        this.health = 10;
        this.shelter = 10;
        this.food = 10;
        this.isDead = false;
        this.name = name;
    }

    public void increaseFood(int x) {
        if (this.isDead) {return;}
        this.food += x;
    }

    public void increaseShelter(int x) {
        if (this.isDead) {return;}
        this.shelter += x;
        if (this.shelter > 10) {this.shelter = 10;}
    }

    public void increaseHealth(int x) {
        if (this.isDead) {return;}
        this.health += x;
        if (this.health > 10) {this.health = 10;}
    }

    public void decreaseFood(int x) {
        if (this.isDead) {return;}
        this.food -= x;
        if (this.food < 0) {this.food = 0;}
    }

    public void decreaseShelter(int x) {
        if (this.isDead) {return;}
        this.shelter -= x;
        if (this.shelter < 0) {this.shelter = 0;}
    }

    public void decreaseHealth(int x) {
        if (this.isDead) {return;}
        this.health -= x;
        if (this.health < 0) {this.health = 0;}
    }

    public int getShelter() {
        return this.shelter;
    }

    public int getHealth() {
        return this.health;
    }

    public int getFood() {
        return this.food;
    }

    public boolean isDead() {
        return this.isDead;
    }

    public void setIsDead(boolean x) {
        this.isDead = x;
    }

    public void checkIfDead() {
        if (this.health <= 0 || this.food <= 0) {this.isDead = true;}
    }

    public String toString() {
        return (this.health + " " + this.food + " " + this.shelter);
    }
}