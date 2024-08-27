public class RescuePrincessPerly extends GameOver {

    int HydraHeads;
    int HydraTails;
    boolean HydraDead;
    boolean impossible;
    RescuePrincessPerly(){};
/*
    RescuePrincessPerly() {
        System.out.print("""
                ****************************************************************************************
                *****************************************  !  ******************************************
                ****                                      !!!                                ***********
                ****                                     !!!!!                               ***********
                ****                                    !!!!!!!                              ***********
                ****                        !!!!RESCUE PRINCESS PERLY!!!!                    ***********
                ****                                    !!!!!!!                              ***********
                ****                                     !!!!!                               ***********
                ****                                      !!!                                ***********
                *****************************************  !  ******************************************
                ****************************************************************************************
                """);

    }
*/

    //getter and setter functions for the Hydra's heads and tails
    public int getHydraHeads() {
        return HydraHeads;
    }

    public int getHydraTails() {
        return HydraTails;
    }

    public void setHydraHeads(int hydraHeads) {
        HydraHeads = hydraHeads;
    }

    public void setHydraTails(int hydraTails) {
        HydraTails = hydraTails;
    }

    //Knight PyPy's Moves
    public void PyPyMove1() {
        HydraHeads--;
    }

    public void PyPyMove2() {
        HydraTails--;
    }

    public void PyPyMove3() {
        HydraHeads -= 2;
    }

    public void PyPyMove4() {
        HydraTails -= 2;
    }

    //Hydra's Moves
    public void HydraResilience1() {
        HydraHeads++;
    }

    public void HydraResilience2() {
        HydraTails += 2;
    }

    public void HydraResilience4() {
        HydraHeads++;
    }

    public boolean isImpossible(){return impossible;}

    public void Impossible2Kill(){
        if(HydraHeads != 0 && HydraTails == 0){
            impossible = HydraHeads % 2 != 0;
        }
    }

    //true if hydra dead
    //false otherwise
    public boolean isHydraDead(){
        return HydraDead;
    }
    public boolean HydraNotDead(){
        return !HydraDead;
    }
    public void checkHydraDead() {
        //Is it dead?
        if (HydraHeads == 0 && HydraTails == 0) {
            HydraDead = true;
        }
        else {
            HydraDead = false;
        }
    }
}