import java.util.Random;

public class Simulation {
    public static void main(String[] args) {
        Person farmer = new Person("farmer");
        Person doctor = new Person("doctor");
        Person carpenter = new Person("carpenter");
        Person hunter = new Person("hunter");
        Person[] village = {farmer, doctor, carpenter, hunter};
        String disaster = "";

        boolean mode = false;
        int day = 0;
        Random rand = new Random();

        if (args.length > 1) {
            System.out.println("Usage 1: java Simulation [-s | -a]");
            System.exit(-1);
        } else if (args.length == 1) {
            if (args[0].equals("-a")) {}
            else if (args[0].equals("-s")) {mode = true;}
            else {
                System.out.println("Usage 2: java Simulation [-s | -a]");
                System.exit(-1);
            }
        }

        if (mode) {
            System.out.println("Running in Society mode...\n");
        } else {
            System.out.println("Running in Anarchy mode...\n");
        }

        // MAIN DAILY LOOP
        while ((!farmer.isDead() || !doctor.isDead() || !hunter.isDead() || !carpenter.isDead()) && day <= 365) {

            day++;

            if (mode) {

                //DOCTOR SKILLS
                if (doctor.getFood() == 1) {doctor.increaseFood(1);}
                else {
                    for (Person p : village) {p.increaseHealth(2);}
                }

                //FARMER SKILLS
                if (day % 3 == 0) {
                    for (Person p : village) {p.increaseFood(3);}
                }

                //CARPENTER SKILLS
                if (carpenter.getFood() == 1) {carpenter.increaseFood(1);}
                else {
                    for (Person p : village) {p.increaseShelter(1);}
                }

                //HUNTER SKILLS
                if (rand.nextInt(5) == 0) {
                    for (Person p : village) {p.increaseFood(2);}
                }

                //DECREASE FOOD
                for (Person p : village) {p.decreaseFood(1);}

                //GENERATE DISASTER
                int x = rand.nextInt(5);

                if (x == 0) {disaster = "none";}

                else if (x == 1) {
                    disaster = "hurricane";
                    for (Person p : village) {
                        if (p.getShelter() <= 0) {p.decreaseHealth(5); }
                        else {p.decreaseShelter(3);}
                    }
                }

                else if (x == 2) {
                    disaster = "famine";
                    for (Person p : village) {p.decreaseFood(2);}
                }

                else if (x == 3) {
                    disaster = "disease";
                    for (Person p : village) {p.decreaseHealth(2);}
                }

                else if (x == 4) {
                    disaster = "wolves";
                    if (!hunter.isDead()) {for (Person p : village) {p.decreaseHealth(1);}}
                    else {for (Person p : village) {p.decreaseHealth(3);}}
                }

            } else {

                //DOCTOR SKILLS
                if (doctor.getFood() == 1) {doctor.increaseFood(1);}
                else {doctor.increaseHealth(2);}

                //FARMER SKILLS
                if (day % 3 == 0) {farmer.increaseFood(3);}

                //CARPENTER SKILLS
                if (carpenter.getFood() == 1) {carpenter.increaseFood(1);}
                else {carpenter.increaseShelter(1);}

                //HUNTER SKILLS
                if (rand.nextInt(5) == 0) {hunter.increaseFood(2);}

                //DECREASE FOOD
                for (Person p : village) {p.decreaseFood(1);}

                //GENERATE DISASTER
                int x = rand.nextInt(5);

                if (x == 0) {disaster = "none";}

                else if (x == 1) {
                    disaster = "hurricane";
                    for (Person p : village) {
                        if (p.getShelter() == 0) {p.decreaseHealth(5); }
                        else {p.decreaseShelter(3);}
                    }
                }

                else if (x == 2) {
                    disaster = "famine";
                    for (Person p : village) {p.decreaseFood(2);}
                }

                else if (x == 3) {
                    disaster = "disease";
                    for (Person p : village) {p.decreaseHealth(2);}
                }

                else if (x == 4) {
                    disaster = "wolves";
                    hunter.decreaseHealth(1);
                    farmer.decreaseHealth(3);
                    doctor.decreaseHealth(3);
                    carpenter.decreaseHealth(3);
                }
            }

            //PRINT STATS
            System.out.println("Day " + day + ": " + disaster);
            System.out.println("-".repeat(25));
            for (Person p : village) {
                if (!p.isDead()) {
                    System.out.println(p.name + ": " + p.toString());
                }
            }

            //CHECK FOR DEAD VILLAGERS
            for (Person p : village) {p.checkIfDead();}

            System.out.println("");

            //SHOW DEAD VILLAGERS
            for (Person p : village) {
                if (p.isDead() && p.isPrintable()) {
                    System.out.println(p.name + " is dead");
                    p.setPrintable(false);
                }
            }

            System.out.println("");
        }

        System.out.println("Everyone is dead\n");
        System.out.println(day + " days");



    }
}
