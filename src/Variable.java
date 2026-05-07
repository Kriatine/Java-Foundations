public class Variable {
    public static void main(String[] args) {
        System.out.println("---Welcome to the Digital Monster Creation Arena---");
        System.out.println("Let's create your first monster. Give it a cool name:Sparky");
        String Name = "Sparky";
        System.out.println("Now, choose your monster's Element. This choice will determine its core strength.\n[1] Fire (Attack-oriented)\n[2] Water (Health-oriented)\n[3] Earth (Defense-oriented)\nYour choice (1-3):1");
        int ElementNumber = 1;
        if (ElementNumber != 1 && ElementNumber != 2 && ElementNumber != 3){
            System.out.println("ERROR : Invalid Element choice. Exiting program.");}
        else {
            System.out.println("Every monster has a Potential. Choose its Potential:\n[1] Normal (Standard stats)\n[2] Rare (Bonus to all stats)\nYour choice (1-2):2");
            int PotentialNumber = 2;
            if (PotentialNumber != 1 && PotentialNumber != 2){
                System.out.println("ERROR : Invalid Potential choice. Exiting program.");}
            else{
                System.out.println("Finally, enter a number between 1 and 10 to influence its destiny:10");
                int Destiny = 10;
                if (Destiny > 10 || Destiny < 1) {
                    System.out.println("ERROR : Destiny number must be between 1-10. Exiting program.");}
                else {
                    int MaxHP = 50;
                    int AP = 10;
                    int DP = 5;
                    String Element = "None";
                    switch (ElementNumber) {
                        case 1 -> {
                            AP += 5 + Destiny;
                            Element = "Fire";}
                        case 2 -> {
                            MaxHP += 20 + Destiny;
                            Element = "Water";}
                        case 3 -> {
                            DP += 10 + Destiny;
                            Element = "Earth";}
                        default -> {}}
                    String Potential = "Normal";
                    if (PotentialNumber == 2) {
                        AP += 10;
                        MaxHP += 10;
                        DP += 10;
                        Potential = "Rare";}
                    System.out.println("--- MONSTER PROFILE CARD ---");
                    System.out.printf("Name : %s\n",Name);
                    System.out.printf("Element : %s\n",Element);
                    System.out.printf("Potential : %s\n\n",Potential);
                    System.out.printf("Health Points(HP) : %d\n",MaxHP);
                    System.out.printf("Attack Power(AP) : %d\n",AP);
                    System.out.printf("Defense Power(DP) : %d\n",DP);
                    int CurrentHP = MaxHP;
                    int DP1 = DP;
                    int AP1 = AP;
                    System.out.println("--- Now, let's train your new monster! ---");
                    System.out.println("How many days would you like to train your monster?14");
                    int day = 14;
                    int week = 1;
                    int daycounter = 1;
                    int level = 1;
                    int TotalXP = 0;
                    boolean bool = false;
                    while (week<=(day/7)+1 && daycounter<=day) {
                        System.out.printf("-- Training Week %d --\n",week);
                        System.out.println("""
                Select your training focus for this week:
                [1] Focus on Health (Bonus HP on level-up)
                [2] Focus on Attack (Bonus AP on level-up)
                [3] Focus on Defense (Bonus DP on level-up)3""");
                        int choice = 3;
                        System.out.printf("Your choice: %d\n",choice);
                        if (choice<1 || choice>3){
                            System.out.println("ERROR : Invalid focus choice. Exiting program.");
                            bool = false;
                            break;}
                        else {
                            bool = true;
                            while (daycounter <= week*7 && daycounter<=day){
                                TotalXP += 30;
                                System.out.printf("Day %d... (XP +30) Total XP: %d/%d\n",daycounter,TotalXP,level*100);
                                if (TotalXP >= level*100) {
                                    TotalXP %= level*100;
                                    level++;
                                    System.out.printf("* LEVEL UP! Your monster is now Level %d! *\n",level);
                                    MaxHP += 10;
                                    AP+=5;
                                    DP+=5;
                                    switch(choice) {
                                        case 1 -> MaxHP+=5;
                                        case 2 -> AP+=5;
                                        case 3 -> DP+=5;}}
                                daycounter++;}
                            week++;}}
                    if (bool) {
                        System.out.printf("""
                    +------------------+------------------+
                    |   Initial Stats  |    Final Stats   |
                    +------------------+------------------+
                    | HP: %-4d         | HP: %-4d         |
                    | AP: %-4d         | AP: %-4d         |
                    | DP: %-4d         | DP: %-4d         |
                    | Level: %-4d      | Level: %-4d      |
                    +------------------+------------------+
                    """,CurrentHP ,MaxHP, AP1, AP, DP1, DP, 1, level);
                        System.out.println("--- The Guardian's Trial Begins! ---");
                        int GHP = 150;
                        int GAP = 35;
                        int GDP = 15;
                        int damageDealt = AP - GDP;
                        if (damageDealt<5) {
                            damageDealt = 5;}
                        int damageTaken = GAP - DP;
                        if (damageTaken<5) {
                            damageTaken = 5;}
                        int hp = MaxHP;
                        int order = 0;
                        while (true) {
                            if (order%2 == 0){
                                System.out.printf("> Your monster attacks and deals %d damage!\n",damageDealt);
                                GHP -= damageDealt;
                                if (GHP<0){
                                    GHP = 0;}
                                System.out.printf("(Guardian HP: %d/150)\n",GHP);}
                            if (GHP<=0) {
                                System.out.println("VICTORY! The Guardian deems your monster worthy. The path to new adventures is now open!");
                                break;}
                            else if (order%2==1){
                                System.out.printf("> The Stone Guardian attacks and deals %d damage!\n",damageTaken);
                                hp -= damageTaken;
                                if (hp<0){
                                    hp = 0;}
                                System.out.printf("(Your HP: %d/%d)\n",hp,MaxHP);
                                if (hp<=0) {
                                    System.out.println("DEFEAT! Your monster has fallen. Return to training to prepare for the trial once more.");
                                    break;}}
                            order++;}}}}}
        int MaxHP = 80;
        int CurrentHP = MaxHP;
        int AP = 45;
        int DP = 35;
        String[] teamMemberNames = new String[3];
        int[] teamMemberCurrentHP = new int[3];
        int[] teamMemberMaxHP = new int[3];
        int[] teamMemberAP = new int[3];
        int[] teamMemberDP = new int[3];
        boolean[] teamMemberAlive = new boolean[3];
        boolean[] regionsExploredStatus = {false, false, false};
        initializeTeam(Name, CurrentHP, AP, DP, teamMemberNames, teamMemberCurrentHP,
                teamMemberMaxHP, teamMemberAP, teamMemberDP, teamMemberAlive);
        System.out.println("TEAM ROSTER INITIALIZED");
        int[] teamStats = calculateTotalTeamStats(teamMemberCurrentHP, teamMemberAP, teamMemberDP, teamMemberAlive);
        displayTeamStats(teamMemberNames, teamMemberCurrentHP, teamMemberMaxHP,
                teamMemberAP, teamMemberDP, teamMemberAlive, teamStats);
        int[] regions = {0, 1, 2};
        int[] scenarios = {0, 1, 0};
        int[] testChoices = {1, 2, 1};
        for (int i = 0; i < regions.length; i++) {
            if (!checkTeamStatus(teamMemberAlive)) {
                System.out.println("DEFEAT! Your team has fallen during exploration.");
                return;}
            System.out.println("\n--- Exploring Region " + regions[i] + " ---");
            triggerEvent(regions[i], scenarios[i], testChoices[i],
                    teamMemberNames, teamMemberCurrentHP, teamMemberMaxHP,
                    teamMemberAP, teamMemberDP, teamMemberAlive);
            regionsExploredStatus[regions[i]] = true;
            int[] currentStats = calculateTotalTeamStats(teamMemberCurrentHP, teamMemberAP,
                    teamMemberDP, teamMemberAlive);
            displayTeamStats(teamMemberNames, teamMemberCurrentHP, teamMemberMaxHP,
                    teamMemberAP, teamMemberDP, teamMemberAlive, currentStats);}
        if (checkTeamStatus(teamMemberAlive) && allRegionsExplored(regionsExploredStatus)) {
            System.out.println("VICTORY! All regions explored successfully!"); }
        else {
            System.out.println("DEFEAT! Mission failed.");}}
    public static void initializeTeam(String monsterName, int monsterHP, int monsterAP, int monsterDP,
                                      String[] teamMemberNames, int[] teamMemberCurrentHP,
                                      int[] teamMemberMaxHP, int[] teamMemberAP,
                                      int[] teamMemberDP, boolean[] teamMemberAlive) {
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
        teamMemberAlive[2] = true;}
    public static int[] calculateTotalTeamStats(int[] teamMemberCurrentHP, int[] teamMemberAP,
                                                int[] teamMemberDP, boolean[] teamMemberAlive) {
        int totalHP = 0;
        int totalAP = 0;
        int totalDP = 0;
        for (int i = 0; i <=2; i++) {
            if (teamMemberAlive[i]) {
                totalHP += teamMemberCurrentHP[i];
                totalAP += teamMemberAP[i];
                totalDP += teamMemberDP[i];}}
        return new int[]{totalHP, totalAP, totalDP};}
    public static void displayTeamStats(String[] teamMemberNames, int[] teamMemberCurrentHP,
                                        int[] teamMemberMaxHP, int[] teamMemberAP,
                                        int[] teamMemberDP, boolean[] teamMemberAlive,
                                        int[] totalTeamStats) {
        System.out.printf("""
                  +-------------+---------+----+----+--------+\r
                  | Member      | HP      | AP | DP | Status |\r
                  +-------------+---------+----+----+--------+\n""");
        for (int i = 0; i<=2; i++) {
            String status = teamMemberAlive[i] ? "Alive" : "Unconscious";
            System.out.printf("| %-11s | %3d/%-3d | %-2d | %-2d | %-6s |\n",
                    teamMemberNames[i], teamMemberCurrentHP[i], teamMemberMaxHP[i],
                    teamMemberAP[i], teamMemberDP[i], status);}
        System.out.printf("""
                          +-------------+---------+---------+--------+
                          | TOTAL STATS | HP: %-3d | AP: %-3d | DP: %-2d |
                          +-------------+---------+---------+--------+
                          """,
                totalTeamStats[0], totalTeamStats[1], totalTeamStats[2]);}
    public static boolean allRegionsExplored(boolean[]regionsExploredStatus) {
        for (boolean status : regionsExploredStatus) {
            if (status==false) {
                return false;}}
        return true;}
    public static boolean checkTeamStatus(boolean[]
                                                  teamMemberAlive) {
        for (boolean isAlive : teamMemberAlive) {
            if (isAlive) {
                return true;}}
        return false;}
    public static void applyDamageToTeam(int damage, int[]
            teamMemberCurrentHP, int[] teamMemberDP, boolean[]
                                                 teamMemberAlive) {
        int alive = 0;
        for (boolean isAlive : teamMemberAlive) {
            if (isAlive) {
                alive++;}}
        if (alive==0) {return;}
        int damageTaken = damage / alive;
        for (int i=0;i<2;i++) {
            if (teamMemberAlive[i]) {
                teamMemberCurrentHP[i] -= damageTaken;
                if (teamMemberCurrentHP[i] <= 0) {
                    teamMemberCurrentHP[i] = 0;
                    teamMemberAlive[i] = false;}}}}
    public static void healTeam(int healAmount, int[] teamMemberCurrentHP,
                                int[] teamMemberMaxHP, boolean[] teamMemberAlive) {
        int eligibleCount = 0;
        for (int i = 0; i < teamMemberAlive.length; i++) {
            if ((teamMemberAlive[i] && teamMemberCurrentHP[i] < teamMemberMaxHP[i]) || !teamMemberAlive[i]) {
                eligibleCount++;}}
        if (eligibleCount == 0) return;
        int healPerPerson = healAmount / eligibleCount;
        for (int i = 0; i < teamMemberAlive.length; i++) {
            if ((teamMemberAlive[i] && teamMemberCurrentHP[i] < teamMemberMaxHP[i]) || !teamMemberAlive[i]) {
                teamMemberCurrentHP[i] += healPerPerson;
                if (teamMemberCurrentHP[i] > teamMemberMaxHP[i]) {
                    teamMemberCurrentHP[i] = teamMemberMaxHP[i];}
                if (teamMemberCurrentHP[i] > 0) {
                    teamMemberAlive[i] = true;}}}}
    public static void triggerEvent(int regionIndex, int scenarioIndex, int simulatedChoice,
                                    String[] teamMemberNames, int[] teamMemberCurrentHP,
                                    int[] teamMemberMaxHP, int[] teamMemberAP,
                                    int[] teamMemberDP, boolean[] teamMemberAlive) {
        if (scenarioIndex != 0 && scenarioIndex != 1) {
            scenarioIndex = 0;}
        if (simulatedChoice != 1 && simulatedChoice != 2) {
            simulatedChoice = 1;}
        switch (regionIndex) {
            case 0 -> {
                if (scenarioIndex == 0) {
                    System.out.println("Event: Your team is ambushed by wild monsters.");
                    if (simulatedChoice == 1) {
                        int totalDP = 0;
                        for (int i = 0; i < 3; i++) if (teamMemberAlive[i]) totalDP += teamMemberDP[i];
                        int damage = 40 - totalDP;
                        if (damage < 5) damage = 5;
                        System.out.println("Outcome: The team fights back! Taking " + damage + " damage.");
                        applyDamageToTeam(damage, teamMemberCurrentHP, teamMemberDP, teamMemberAlive);
                        int minAP = 9999;
                        int targetIndex = -1;
                        for (int i = 0; i < 3; i++) {
                            if (teamMemberAlive[i] && teamMemberAP[i] < minAP) {
                                minAP = teamMemberAP[i];
                                targetIndex = i;}}
                        if (targetIndex != -1) {
                            teamMemberAP[targetIndex] += 5;
                            System.out.println(teamMemberNames[targetIndex] + "'s AP increased by 5!");}}
                    else {
                        System.out.println("Outcome: Flee failed. Taking 15 damage.");
                        applyDamageToTeam(15, teamMemberCurrentHP, teamMemberDP, teamMemberAlive);}}
                else {
                    System.out.println("Event: You find a peaceful Whispering Grove.");
                    if (simulatedChoice == 1) {
                        System.out.println("Outcome: The team meditates. Healing 20 HP.");
                        healTeam(20, teamMemberCurrentHP, teamMemberMaxHP, teamMemberAlive);
                        int maxDP = -1;
                        int targetIndex = -1;
                        for (int i = 0; i < 3; i++) {
                            if (teamMemberAlive[i] && teamMemberDP[i] > maxDP) {
                                maxDP = teamMemberDP[i];
                                targetIndex = i;}}
                        if (targetIndex != -1) {
                            teamMemberDP[targetIndex] += 3;
                            System.out.println(teamMemberNames[targetIndex] + "'s DP increased by 3!");}}
                    else {
                        System.out.println("Outcome: You ignored the grove.");}}}
            case 1 -> {
                if (scenarioIndex == 0) {
                    System.out.println("Event: The cave ceiling begins to crumble!");
                    if (simulatedChoice == 1) {
                        System.out.println("Outcome: You run through falling rocks. Taking 30 damage.");
                        applyDamageToTeam(30, teamMemberCurrentHP, teamMemberDP, teamMemberAlive);}
                    else {
                        System.out.println("Outcome: Cover failed. Weakest member takes 10 damage.");
                        int minHP = 9999;
                        int targetIndex = -1;
                        for (int i = 0; i < 3; i++) {
                            if (teamMemberAlive[i] && teamMemberCurrentHP[i] < minHP) {
                                minHP = teamMemberCurrentHP[i];
                                targetIndex = i;}}
                        if (targetIndex != -1) {
                            teamMemberCurrentHP[targetIndex] -= 10;
                            if (teamMemberCurrentHP[targetIndex] <= 0) {
                                teamMemberCurrentHP[targetIndex] = 0;
                                teamMemberAlive[targetIndex] = false;}}}}
                else {
                    System.out.println("Event: You discover a glowing crystal vein.");
                    if (simulatedChoice == 1) {
                        System.out.println("Outcome: Crystals empower the team! AP +5 for all.");
                        for (int i = 0; i < 3; i++) if (teamMemberAlive[i]) teamMemberAP[i] += 5;
                    } else {
                        System.out.println("Outcome: Vitality surge! MaxHP and CurrentHP +10 for all.");
                        for (int i = 0; i < 3; i++) {
                            if (teamMemberAlive[i]) {
                                teamMemberMaxHP[i] += 10;
                                teamMemberCurrentHP[i] += 10;}}}}}
            case 2 -> {
                if (scenarioIndex == 0) {
                    System.out.println("Event: You find an ancient mechanism.");
                    if (simulatedChoice == 1) {
                        System.out.println("Outcome: It's a trap! Taking 20 damage.");
                        applyDamageToTeam(20, teamMemberCurrentHP, teamMemberDP, teamMemberAlive);}
                    else {
                        System.out.println("Outcome: You walk around safely.");}}
                else {
                    System.out.println("Event: A dark altar demands a sacrifice.");
                    if (simulatedChoice == 1) {
                        System.out.println("Outcome: HP reduced by 25%. AP and DP increased by 5.");
                        for (int i = 0; i < 3; i++) {
                            if (teamMemberAlive[i]) {
                                int damage = teamMemberCurrentHP[i] / 4;
                                teamMemberCurrentHP[i] -= damage;
                                if (teamMemberCurrentHP[i] < 1) teamMemberCurrentHP[i] = 1;
                                teamMemberAP[i] += 5;
                                teamMemberDP[i] += 5;}}}
                    else {
                        System.out.println("Outcome: You ignore the altar.");}}}
            default -> {}}}}
