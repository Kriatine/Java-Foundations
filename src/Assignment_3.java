public class Assignment_3 {
    public static void main(String[] args){
        System.out.println("--- Welcome to the Digital Monster Creation Arena ---");
        System.out.print("Let's create your first monster. Give it a cool name: ");
        String monsterName = "Pyro";

        System.out.println("\nNow, choose your monster's element. This choice will determine its core strength.");
        System.out.println("[1] Fire (Attack-oriented)");
        System.out.println("[2] Water (Health-oriented)");
        System.out.println("[3] Earth (Defense-oriented)");
        System.out.print("Your choice(1-3): ");
        int element = 1;
        if(element > 3 ||element < 1) {
            System.out.println("ERROR: Invalid element choice. Exiting program.");
            return;
        }
        System.out.println("\nEvery monster has a potential. Choose its potential: ");
        System.out.println("[1] Normal (Standard stats)");
        System.out.println("[2] Rare (Bonus to all stats)");
        System.out.print("Your choice (1-2): ");
        int potential = 2;
        if(potential != 1 && potential != 2){
            System.out.println("ERROR: Invalid potential choice. Exiting program.");
            return;
        }
        System.out.print("\nFinally, enter a number between 1 and 10 to influence its destiny: ");
        int destiny = 10;
        if(destiny < 1 || destiny > 10) {
            System.out.println("ERROR: Destiny Number must be between 1 and 10. Exiting program.");
            return;
        }
        System.out.println();
        System.out.println("Excellent choices! Your monster " + monsterName + " is being created...");

        int hp = 50;
        int ap = 10;
        int dp = 5;
        String elementName = "Fire";
        String potentialName = "Rare";

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
        System.out.println("Name: " + monsterName);
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
        int trainingDays = 10;
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
                trainingFocus = 1;
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
        int hpFinalOrig = hpFinal;
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


        else {
            System.out.println("VICTORY! The Guardian deems your monster worthy. The path to new adventures is now open!");

            System.out.println("\nTwo skilled adventurers, Swiftclaw and Ironhide, are impressed by " + monsterName + " strength and decide to join the team!");

            String[] teamMemberNames = new String[3];
            int[] teamMemberCurrentHP = new int[3];
            int[] teamMemberMaxHP = new int[3];
            int[] teamMemberAP = new int[3];
            int[] teamMemberDP = new int[3];
            boolean[] teamMemberAlive = new boolean[3];
            int totalHp = 0, totalAp = 0, totalDp = 0;

            initializeTeam(monsterName, hpFinalOrig, apFinal, dpFinal, teamMemberNames, teamMemberCurrentHP, teamMemberMaxHP, teamMemberAP, teamMemberDP, teamMemberAlive);

            int[] totalTeamStats = calculateTotalTeamStats(teamMemberCurrentHP, teamMemberAP, teamMemberDP, teamMemberAlive);

            displayTeamStats(teamMemberNames, teamMemberCurrentHP, teamMemberMaxHP, teamMemberAP, teamMemberDP, teamMemberAlive,totalTeamStats);

            boolean[] regionsExploredStatus = new boolean[3];

                triggerEvent(0, 0, 1, teamMemberNames, teamMemberCurrentHP, teamMemberMaxHP, teamMemberAP, teamMemberDP, teamMemberAlive);
                regionsExploredStatus[0] = true;
                totalTeamStats = calculateTotalTeamStats(teamMemberCurrentHP, teamMemberAP, teamMemberDP, teamMemberAlive);
                displayTeamStats(teamMemberNames, teamMemberCurrentHP, teamMemberMaxHP, teamMemberAP, teamMemberDP, teamMemberAlive, totalTeamStats);
            if (!checkTeamStatus(teamMemberAlive)) {
                System.out.println("\nDEFEAT! Your team has fallen.");
                return;
            }
                triggerEvent(1, 1, 2, teamMemberNames, teamMemberCurrentHP, teamMemberMaxHP, teamMemberAP, teamMemberDP, teamMemberAlive);
                regionsExploredStatus[1] = true;
                totalTeamStats = calculateTotalTeamStats(teamMemberCurrentHP, teamMemberAP, teamMemberDP, teamMemberAlive);
                displayTeamStats(teamMemberNames, teamMemberCurrentHP, teamMemberMaxHP, teamMemberAP, teamMemberDP, teamMemberAlive, totalTeamStats);
            if (!checkTeamStatus(teamMemberAlive)) {
                System.out.println("\nDEFEAT! Your team has fallen.");
                return;
            }

                triggerEvent(2, 0, 1, teamMemberNames, teamMemberCurrentHP, teamMemberMaxHP, teamMemberAP, teamMemberDP, teamMemberAlive);
                regionsExploredStatus[2] = true;
                totalTeamStats = calculateTotalTeamStats(teamMemberCurrentHP, teamMemberAP, teamMemberDP, teamMemberAlive);
                displayTeamStats(teamMemberNames, teamMemberCurrentHP, teamMemberMaxHP, teamMemberAP, teamMemberDP, teamMemberAlive, totalTeamStats);
            if (!checkTeamStatus(teamMemberAlive)) {
                System.out.println("\nDEFEAT! Your team has fallen.");
                return;
            }
            if(allRegionsExplored(regionsExploredStatus)){
                System.out.println("\nVICTORY! All regions explored successfully!");
            }
        }
    }
    public static void initializeTeam(String monsterName, int monsterHP, int monsterAP, int monsterDP,
                                      String[] teamMemberNames, int[] teamMemberCurrentHP,
                                      int[] teamMemberMaxHP, int[] teamMemberAP,
                                      int[] teamMemberDP, boolean[] teamMemberAlive){
        teamMemberNames[0] = monsterName;
        teamMemberCurrentHP[0] = monsterHP;
        teamMemberMaxHP[0] = monsterHP;
        teamMemberAP[0] = monsterAP;
        teamMemberDP[0] = monsterDP;
        teamMemberAlive[0] = true;

        teamMemberNames[1] = "Swiftclaw";
        teamMemberCurrentHP[1] = 80;
        teamMemberMaxHP[1] = 80;
        teamMemberAP[1] = 40;
        teamMemberDP[1] = 10;
        teamMemberAlive[1] = true;

        teamMemberNames[2] = "Ironhide";
        teamMemberCurrentHP[2] = 120;
        teamMemberMaxHP[2] = 120;
        teamMemberAP[2] = 20;
        teamMemberDP[2] = 30;
        teamMemberAlive[2] = true;

        System.out.println("--- TEAM ROSTER INITIALIZED ---");
    }
    public static int[] calculateTotalTeamStats(int[] teamMemberCurrentHP, int[] teamMemberAP,
                                                int[] teamMemberDP, boolean[] teamMemberAlive){
        int totalHp = 0;
        int totalAp = 0;
        int totalDp = 0;

        for(int i = 0; i < teamMemberAlive.length; i++){
            if(teamMemberAlive[i]){
                totalHp += teamMemberCurrentHP[i];
                totalAp += teamMemberAP[i];
                totalDp += teamMemberDP[i];
            }
        }
        return new int[]{totalHp, totalAp, totalDp};
    }
    public static void displayTeamStats(String[] teamMemberNames, int[] teamMemberCurrentHP,
                                        int[] teamMemberMaxHP, int[] teamMemberAP, int[] teamMemberDP,
                                        boolean[] teamMemberAlive, int[] totalTeamStats){
        String[] status = new String[teamMemberAlive.length];
        for(int i = 0; i < teamMemberAlive.length; i++){
            if(teamMemberAlive[i])
                status[i] = "Alive";
            else
                status[i] = "Unconscious";
        }
        System.out.printf("""
                +--------------+---------+---------+----+--------+
                | Member       | HP      | AP | DP | Status      |
                +--------------+---------+----+----+-------------+
                | %-11s  | %3d/%-3d | %-3d| %-3d| %-11s |
                | %-11s  | %3d/%-3d | %-3d| %-3d| %-11s |
                | %-11s  | %3d/%-3d | %-3d| %-3d| %-11s |
                +--------------+---------+----+----+-------------+
                | %-11s  | HP: %-4d| AP: %-4d| DP: %-4d    |
                +--------------+---------+----+----+-------------+
                
                """, teamMemberNames[0], teamMemberCurrentHP[0], teamMemberMaxHP[0], teamMemberAP[0], teamMemberDP[0], status[0],
                teamMemberNames[1], teamMemberCurrentHP[1], teamMemberMaxHP[1], teamMemberAP[1], teamMemberDP[1], status[1],
                teamMemberNames[2], teamMemberCurrentHP[2], teamMemberMaxHP[2], teamMemberAP[2], teamMemberDP[2], status[2], "TOTAL STATS", totalTeamStats[0], totalTeamStats[1], totalTeamStats[2]);

    }
    public static boolean allRegionsExplored(boolean[] regionsExploredStatus){
        boolean temp = true;
        for(int i = 0; i < regionsExploredStatus.length; i++){
            if(regionsExploredStatus[i] == false){
                temp = false;
                break;
            }
        }
        return temp;
    }


    public static void triggerEvent(int regionIndex, int scenarioIndex, int simulatedChoice, String[] teamMemberNames, int[] teamMemberCurrentHP, int[] teamMemberMaxHP, int[] teamMemberAP, int[] teamMemberDP, boolean[] teamMemberAlive) {
        if (scenarioIndex != 0 && scenarioIndex != 1)
            scenarioIndex = 0;
        if (simulatedChoice != 1 && simulatedChoice != 2)
            simulatedChoice = 1;

        int aliveMemberCount = 0;
        for (int i = 0; i < teamMemberAlive.length; i++) {
            if (teamMemberAlive[i])
                aliveMemberCount++;
        }if (regionIndex == 0) {

            if (scenarioIndex == 0) {
                System.out.println("--- Exploring Region Index: 0, Scenario Index: 0 ---");

                if (simulatedChoice == 1) {
                    System.out.println("Event: Your team is ambushed by wild monsters.");
                    int damageInitial = 40;
                    int damageFinal;
                    int totalDP = 0;
                    for(int i = 0; i < teamMemberAlive.length; i++){
                        if(teamMemberAlive[i])
                        totalDP += teamMemberDP[i];
                    }
                    damageFinal = damageInitial - totalDP;
                    if(damageFinal < 5)
                        damageFinal = 5;
                    applyDamageToTeam(damageFinal, teamMemberCurrentHP, teamMemberDP, teamMemberAlive);


                    int minAP = Integer.MAX_VALUE;
                    int minAPIndex = 0;
                    for(int i = 0; i < teamMemberAlive.length; i++){
                        if(teamMemberAlive[i] && teamMemberAP[i] < minAP) {
                            minAP = teamMemberAP[i];
                            minAPIndex = i;
                        }
                    }
                    if(checkTeamStatus(teamMemberAlive)){
                    if(minAPIndex != -1) {
                        System.out.println("Outcome: The team fights back bravely! They take damage in the skirmish. " + teamMemberNames[minAPIndex] + "'s resolve is hardened, increasing its AP by 5.");
                        teamMemberAP[minAPIndex] += 5;
                    }
                }
                }
                else if(simulatedChoice == 2){
                    System.out.println("Event: Your team tries to distract and flee. ");
                    System.out.println("Outcome: Your attemp fails. Your team takes damage.");
                    applyDamageToTeam(15, teamMemberCurrentHP, teamMemberDP, teamMemberAlive);

                }
            }
            else if(scenarioIndex == 1){
                System.out.println("--- Exploring Region Index: 0, Scenario Index: 1 ---");
                if(simulatedChoice == 1){
                    System.out.println("Event: Your team finds a place to meditate.");
                    healTeam(20, teamMemberCurrentHP, teamMemberMaxHP, teamMemberAlive);
                    int maxDPIndex = -1;
                    int maxDP = -1;
                    for(int i=0; i<3; i++) {
                        if(teamMemberAlive[i] && teamMemberDP[i] > maxDP) {
                            maxDP = teamMemberDP[i];
                            maxDPIndex = i;
                        }

                    }

                    if(maxDPIndex != -1) {
                        teamMemberDP[maxDPIndex] += 3;
                        System.out.println("Outcome: Your team heals by 20." + teamMemberNames[maxDPIndex] + "'s DP increased by 3!");
                    }
                }
                else if(simulatedChoice == 2){
                    System.out.println("Your team continues their journey.");
                }
            }
        }
        if (regionIndex == 1) {
            System.out.println("Your team enters the Crystal Caves.");

            if(scenarioIndex == 0) {
                System.out.println("--- Exploring Region Index: 1, Scenario Index: 0 ---");
                System.out.println("Event: The ceiling seems unstable.");

                if(simulatedChoice == 1){
                    System.out.println("Outcome: You try to run through, but the ceiling collapses. Your team takes 30 damage.");
                    applyDamageToTeam(30, teamMemberCurrentHP, teamMemberDP, teamMemberAlive);
                }
                else if(simulatedChoice == 2){
                    System.out.println("You try to take cover but fail. Member with the lowest HP takes 10 damage.");
                    int minHPIndex = -1;
                    int minHP = Integer.MAX_VALUE;
                    for(int i=0; i<3; i++) {
                        if(teamMemberAlive[i] && teamMemberCurrentHP[i] < minHP) {
                            minHP = teamMemberCurrentHP[i];
                            minHPIndex = i;
                        }
                    }
                    if(minHPIndex != -1) {
                        teamMemberCurrentHP[minHPIndex] -= 10;
                        if(teamMemberCurrentHP[minHPIndex] <= 0) {
                            teamMemberCurrentHP[minHPIndex] = 0;
                            teamMemberAlive[minHPIndex] = false;
                        }
                    }
                }
            }
            else if(scenarioIndex == 1){
                System.out.println("--- Exploring Region Index: 1, Scenario Index: 1 ---");
                System.out.println("Event: You found a glowing crystal vein.");
                if(simulatedChoice == 1){
                    System.out.println("Outcome: You feel the power flowing through you when you hold these crystals. Your members gain 5 AP.");
                    for(int i = 0; i < teamMemberAlive.length; i++){
                        if(teamMemberAlive[i])
                            teamMemberAP[i] += 5;
                    }

                }
                else if(simulatedChoice == 2){
                    System.out.println("Outcome: These crystals will be a nice addition for your armor. Your members gain 10 max HP.");
                    for(int i = 0; i < teamMemberAlive.length; i++){
                        if(teamMemberAlive[i]){
                            teamMemberMaxHP[i] += 10;
                            teamMemberCurrentHP[i] += 10;
                        }
                    }
                }
            }
        }
        if (regionIndex == 2) {
            System.out.println("You step into the ancient ruins.");
            if(scenarioIndex == 0){
                System.out.println("--- Exploring Region Index: 2, Scenario Index: 0 ---");
                System.out.println("Event: There seems an ancient mechanism. Your members checks it.");
                if(simulatedChoice == 1){
                    System.out.println("Outcome: It's a trap! Your team takes 20 damage.");
                    applyDamageToTeam(20, teamMemberCurrentHP, teamMemberDP, teamMemberAlive);
                }
                else if(simulatedChoice == 2){
                    System.out.println("Outcome: Nothing seems to happen. Probably it's broken.");
                }
            }
            else if(scenarioIndex == 1){
                System.out.println("--- Exploring Region Index: 2, Scenario Index: 1 ---");
                System.out.println("Event: Your members found a sacrificial altar.");
                if(simulatedChoice == 1){
                    System.out.println("Outcome: You make a sacrifice. For the greater good...");
                    for(int i = 0; i < teamMemberAlive.length; i++){
                        if(teamMemberAlive[i]) {
                            teamMemberCurrentHP[i] /= 4;
                            if (teamMemberCurrentHP[i] < 1)
                                teamMemberCurrentHP[i] = 1;
                            teamMemberAP[i] += 5;
                            teamMemberDP[i] += 5;
                        }
                    }
                }
                else if(simulatedChoice == 2){
                    System.out.println("Eh, who needs sacrifices when you have friendship anyways, right? Your team continues the journey.");
                }
            }
    }
}

    public static void applyDamageToTeam(int damage, int[] teamMemberCurrentHP, int[] teamMemberDP, boolean[] teamMemberAlive){
        int aliveTeamMemberCount = 0;
        for(int i = 0; i < teamMemberAlive.length; i++){
            if(teamMemberAlive[i])
                aliveTeamMemberCount++;
        }


        if(damage < 5)
            damage = 5;

        int damagePerMember = damage / aliveTeamMemberCount;
        for(int i = 0; i < teamMemberAlive.length; i++){
            if (teamMemberAlive[i]) {
                teamMemberCurrentHP[i] -= damagePerMember;

                if (teamMemberCurrentHP[i] <= 0) {
                    teamMemberCurrentHP[i] = 0;
                    teamMemberAlive[i] = false;
                }
            }
        }


    }

    public static void healTeam(int healAmount, int[] teamMemberCurrentHP, int[] teamMemberMaxHP, boolean[] teamMemberAlive){
        int healPerMember;
        int memberToHealAmount = teamMemberAlive.length;
        for(int i = 0; i < teamMemberAlive.length; i++){
            if(teamMemberCurrentHP[i] == 0)
                teamMemberAlive[i] = true;

            if(teamMemberCurrentHP[i] == teamMemberMaxHP[i])
                memberToHealAmount--;
        }
        healPerMember = healAmount / memberToHealAmount;

        for(int i = 0; i < teamMemberAlive.length; i++){
            if(teamMemberCurrentHP != teamMemberMaxHP){
                teamMemberCurrentHP[i] += healPerMember;
                if(teamMemberCurrentHP[i] > teamMemberMaxHP[i])
                    teamMemberCurrentHP = teamMemberMaxHP;
            }

        }

    }
    public static boolean checkTeamStatus(boolean[] teamMemberAlive){
        boolean temp = false;
        for(int i = 0; i < teamMemberAlive.length; i++){
            if(teamMemberAlive[i]){
                temp = true;
                break;
            }
        }
        return temp;
    }
}
