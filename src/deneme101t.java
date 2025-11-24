import java.util.Scanner;

public class deneme101t {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Welcome to the Digital Monster Creation Arena ---");
        System.out.print("Let's create your first monster. Give it a cool name: ");
        String name = scanner.nextLine();

        System.out.println();
        System.out.println("Now, choose your monster's element. This choice will determine its core strength.");
        System.out.println("[1] Fire (Attack-oriented)");
        System.out.println("[2] Water (Health-oriented)");
        System.out.println("[3] Earth (Defense-oriented)");
        System.out.print("Your choice(1-3): ");
        int element = scanner.nextInt();
        if(element > 3 ||element < 1){
            System.out.println("ERROR: Invalid element choice. Exiting program.");
            return;
        }
        System.out.println();
        System.out.println("Every monster has a potential. Choose its potential: ");
        System.out.println("[1] Normal (Standard stats)");
        System.out.println("[2] Rare (Bonus to all stats)");
        System.out.print("Your choice (1-2): ");
        int potential = scanner.nextInt();
        if(potential != 1 && potential != 2){
            System.out.println("ERROR: Invalid potential choice. Exiting program.");
            return;
        }
        System.out.println();
        System.out.print("Finally, enter a number between 1 and 10 to influence its destiny: ");
        int destiny = scanner.nextInt();
        if(destiny < 1 || destiny > 10) {
            System.out.println("ERROR: Destiny Number must be between 1 and 10. Exiting program.");
            return;
        }
        System.out.println();
        System.out.println("Excellent choices! Your monster " + name + " is being created...");

        int hp = 50;
        int ap = 10;
        int dp = 5;
        String elementName;
        String potentialName;

        if(element == 1) {
            elementName = "Fire";
            ap += 5;
        }
        else if(element == 2) {
            elementName = "Water";
            hp += 20;
        }
        else{
            elementName = "Earth";
            dp += 10;
        }

        if(potential == 1){
            potentialName = "Normal";
        }
        else{
            potentialName = "Rare";
            hp += 10;
            ap += 10;
            dp += 10;
        }

        if(element == 1)
            ap += destiny;
        else if(element == 2)
            hp += destiny;
        else
            dp += destiny;

        System.out.println();
        System.out.println("--- MONSTER PROFILE CARD ---");
        System.out.println("Name: " + name);
        System.out.println("Element: " + elementName);
        System.out.println("Potential: " + potentialName);
        System.out.println();
        System.out.println("Health Points (HP): " + hp);
        System.out.println("Attack Power (AP): " + ap);
        System.out.println("Defense Power (DP): " + dp);
        System.out.println("---------------------------");

        int levelInitial = 1;
        int levelFinal = 1;
        int currentXP = 0;
        int xpToNextLevel = levelFinal * 100;
        int trainingFocus = 0;
        int week = 0;
        int hpFinal = hp;
        int apFinal = ap;
        int dpFinal = dp;
        
        System.out.println("\n--- Now, let's train your new monster! ---");
        System.out.print("\nHow many days would you like to train your monster? ");
        int trainingDays = scanner.nextInt();
        if(trainingDays < 0){
            System.out.println("ERROR: Training days can not be a negative number. Exiting program.");
        }
        for(int day = 1; day <= trainingDays; day++) {
            if ((day - 1) % 7 == 0) {
                week = (day - 1) / 7 + 1;
                System.out.println("-- Training Week " + week + "--");
                System.out.println("Select your training focus for this week:");
                System.out.println("[1] Focus on Health (Bonus HP on level-up)");
                System.out.println("[2] Focus on Attack (Bonus AP on level-up)");
                System.out.println("[3] Focus on Defense (Bonus DP on level-up)");
                System.out.print("Your choice: ");
                trainingFocus = scanner.nextInt();
                if(trainingFocus < 1 || trainingFocus > 3){
                    System.out.println("ERROR: Training Focus must be between 1 and 3. Exiting program.");
                    return;
                }
            }
            currentXP += 30;
            System.out.println("Day " + day + "... (XP +30) Total XP: " + currentXP + "/" + xpToNextLevel);
            while(currentXP >= xpToNextLevel) {
                levelFinal++;
                System.out.println("*** LEVEL UP! Your monster is now Level " + levelFinal + "! ***");

                hpFinal += 10;
                apFinal += 5;
                dpFinal += 5;

                if(trainingFocus == 1)
                    hpFinal += 5;
                else if(trainingFocus == 2)
                    apFinal += 5;
                else if(trainingFocus == 3)
                    dpFinal += 5;

                currentXP = currentXP - xpToNextLevel;
                xpToNextLevel = levelFinal * 100;
            }

        }
        System.out.println("\n--- Training Results ---");
        System.out.printf("""
                    +------------------+------------------+
                    |   Initial Stats  |    Final Stats   |
                    +------------------+------------------+
                    | HP: %-4d         | HP: %-4d         |
                    | AP: %-4d         | AP: %-4d         |
                    | DP: %-4d         | DP: %-4d         |
                    | Level: %-4d      | Level: %-4d      |
                    +------------------+------------------+
                    """,hp ,hpFinal, ap, apFinal, dp, dpFinal, levelInitial, levelFinal );
        System.out.println("--- The Guardian's Trial Begins! ---");
        int guardianHP = 150;
        int guardianAP = 35;
        int guardianDP = 15;
        int guardianHPInitial = guardianHP;
        int hpFinalInitial = hpFinal;


        while(guardianHP > 0 && hpFinal > 0){
            int damageDealtMonster = apFinal - guardianDP;
            if(damageDealtMonster < 5)
                damageDealtMonster = 5;
            System.out.println("> Your monster attacks and deals " + damageDealtMonster + " damage!");

            guardianHP -= damageDealtMonster;
            System.out.println("(Guardian HP: " + guardianHP + "/" + guardianHPInitial + ")");
            if(guardianHP <= 0)
                break;


            int damageDealtGuardian = guardianAP - dpFinal;
            if(damageDealtGuardian < 5)
                damageDealtGuardian = 5;
            System.out.println("> The Stone Guardian attacks and deals " + damageDealtGuardian + " damage!");

            hpFinal -= damageDealtGuardian;
            System.out.println("(Your HP: " + hpFinal + "/" + hpFinalInitial + ")");
        }
        if(hpFinal <= 0)
            System.out.println("DEFEAT! Your monster has fallen. Return to training to prepare for the trial once more.");


        else
            System.out.println("VICTORY! The Guardian deems your monster worthy. The path to new adventures is now open!");
    }
}