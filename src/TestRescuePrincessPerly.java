import java.util.Scanner;

public class TestRescuePrincessPerly extends ShowDown {
    TestRescuePrincessPerly(){}


    public int getMoves(int H, int T){

        if(H %2 != 0 && T %2 != 0){
            HeadsOdd_TailsOdd(H, T);
        }
        if(H % 2 == 0 && T %2 == 0){
            HeadsEven_TailsEven(H, T);
        }
        if(H %2 == 0 && T %2 != 0){
            HeadsEven_TailsOdd(H, T);
        }
        if(H %2 != 0 && T %2 == 0){
            HeadsOdd_TailsEven(H, T);
        }

        //Beginning of special cases
        if(H != 0 && T == 0){
            Special_Cases(H, T);
            //  SAY it is impossible to kill hydra.
        }
        if(H == 0 && T == 0){
            Special_Cases(H, T);
        }
        if(H == 0 && T != 0){
            Special_Cases(H, T);
        }

        return counter;
    }



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ShowDown battle = new ShowDown();
        /*
        RescuePrincessPerly class code
        * */

        //How many heads?
        System.out.print("\n\nHow many heads for the Magical Hydra?     ");
        int read = input.nextInt();
        battle.setHydraHeads(read);
        int heads = battle.getHydraHeads();

        //How many tails?
        System.out.print("How many tails for the Magical Hydra?         ");
        read = input.nextInt();
        battle.setHydraTails(read);
        int tails = battle.getHydraTails();

        /*
        Moves2Kill          class code
        * */
        battle.Impossible2Kill();
        battle.checkHydraDead();

        if (battle.isImpossible()) {
            System.out.print("This Hydra is Impossible to kill. ");
            return;
        }
        if (battle.isHydraDead()) {
            System.out.print("This Hydra is already dead! ");
            return;
        }
        else
            System.out.print("Magical Hydra now has " + heads + " heads and " + tails + " tails. \n\n");




        boolean again;
        do {
            System.out.println("""
                    Enter a move for Knight PyPy:
                    (1)    Cut off one of Hydra's heads.
                           (Hydra grows a new head)
                    (2)    Cut off one of Hydra's tails
                           (Hydra grows two new tails)
                    (3)    Cut off two of Hydra's heads
                           (No growth)
                    (4)    Cut off two of Hydra's tails
                           (Hydra grows a new head)
                    """);

            int move = input.nextInt();

            switch (move) {
                case 1:
                    if (battle.getHydraHeads() < 1) {
                        System.out.print("not enough heads for this move.\n");
                    }
                    else if (battle.getHydraHeads() >= 1) {
                        //Battle Moves
                        battle.PyPyMove1();
                        battle.HydraResilience1();
                        battle.Impossible2Kill();
                        battle.checkHydraDead();
                        if (battle.isHydraDead()) {
                            System.out.print("""
                                                This Hydra is dead,
                                                And is thus impossible to kill""");
                           // return;
                            }
                        else if (battle.isImpossible()) {
                            System.out.print("This Hydra is now Impossible to kill.");
                           // return;
                        } else {
                            System.out.print("Hydra now has " + battle.getHydraHeads() + " heads and " + battle.getHydraTails() + " tails.\n");
                        }
                    }
                    break;
                case 2:
                    if (battle.getHydraTails() < 1) {
                        System.out.print("not enough tails for this move.\n");
                    }
                    else if (battle.getHydraTails() >= 1) {
                        //Battle Moves
                        battle.PyPyMove2();
                        battle.HydraResilience2();
                        battle.Impossible2Kill();
                        battle.checkHydraDead();

                        if (battle.isHydraDead()) {
                            System.out.print("This Hydra is dead.\n");
                           // return;
                        }
                        else if (battle.isImpossible()) {
                            System.out.print("This Hydra is now Impossible to kill.");
                           // return;
                        }
                        else {
                            System.out.print("Hydra now has " + battle.getHydraHeads() + " heads and " + battle.getHydraTails() + " tails.\n");
                        }
                    }
                    break;
                case 3:
                    if (battle.getHydraHeads() < 2) {
                        System.out.print("not enough heads for this move.\n");
                    }
                    else if (battle.getHydraHeads() >= 2) {
                        battle.PyPyMove3();
                        battle.Impossible2Kill();
                        battle.checkHydraDead();

                        if (battle.isHydraDead()) {
                            System.out.print("This Hydra is dead.\n");
                            //return;
                        }
                        else if (battle.isImpossible()) {
                            System.out.print("This Hydra is now Impossible to kill.");
                            //return;
                        }
                        else {System.out.print("Hydra now has " + battle.getHydraHeads() + " heads and " + battle.getHydraTails() + " tails.\n");}
                    }
                    break;
                case 4:
                    if (battle.getHydraTails() < 2) {
                        System.out.print("not enough tails for this move.\n");
                    }
                    else if (battle.getHydraTails() >= 2) {
                        battle.PyPyMove4();
                        battle.HydraResilience4();
                        battle.Impossible2Kill();
                        battle.checkHydraDead();
                        if (battle.isHydraDead()) {
                            System.out.print("This Hydra is dead.\n");
                           // return;
                        }
                        else if (battle.isImpossible()) {
                            System.out.print("This Hydra is now Impossible to kill.");
                            //return;
                        }
                        else {System.out.print("Hydra now has " + battle.getHydraHeads() + " heads and " + battle.getHydraTails() + " tails.\n");}
                    }
                    break;
                default:
                    System.out.print("Enter a valid move.");
                    break;
            }

            //return statement of sorts here...Not really
            // the following keep going will be determined by a methods
            // that will include booleans for UserQuit, HydraDead, and something else...
            if(!battle.isHydraDead()) {
                System.out.print("""
                        Keep going?
                        Enter true for yes
                        Enter false for no
                                           
                                           
                        """);

                again = input.nextBoolean();
                battle.setKeepGoing(again);
            }


        } while (battle.Decision());// Must be --> while hydra dead or player quit //Should get this value from another class/function
        TestRescuePrincessPerly moves = new TestRescuePrincessPerly();
        int min = moves.getMoves(heads, tails);

        if(battle.isHydraDead()){
            System.out.print("GAME OVER");

            if(moves.Impossible2Kill_copy()){
                System.out.print("This Hydra is impossible to kill");
            }
            else{
                System.out.print("\n\nIt takes " + min + " moves to kill this Hydra.");
            }
        }
















    }
}