public class Moves2Kill extends RescuePrincessPerly{
    int copyHydraHeads;
    int copyHydraTails;
    int counter;
    boolean impossible_copy;

    //public Moves2Kill(){}

        /*Method will never be used because it is useless!
        Included it here for comprehension anyway.

        public void Move1(){
            copyHydraHeads--;
            copyHydraHeads++;
            counter++;
        }
        */
    public void Move2(){
        copyHydraHeads++;
        counter++;
    }
    public void Move3(){
        copyHydraHeads -= 2;
        counter++;
    }
    public void Move4(){
        copyHydraTails -= 2;
        copyHydraHeads++;
        counter++;
    }
    public boolean Impossible2Kill_copy(){return impossible_copy;}

    /*
    *  Methods to determine the minimum # of moves to kill Hydra
    *
    *
    *  */

    public void HeadsOdd_TailsOdd(int H, int T){
        copyHydraHeads = H;
        copyHydraTails = T;

        impossible_copy = false;

        if(copyHydraTails == 1) {
            Move2();
            Move4();
            while (copyHydraHeads != 0) {
                Move3();
            }
        }
        else if(copyHydraTails >= 3){
            Move4();
            while(copyHydraHeads != 0){
                Move3();
            }

            while(!((copyHydraTails % 4) == 0)){
                Move2();
            }
            while (copyHydraTails != 0){
                Move4();
            }
            while (copyHydraHeads != 0){
                Move3();
            }
        }
    }

    public void HeadsEven_TailsEven(int H,int T){
        copyHydraHeads = H;
        copyHydraTails = T;
        impossible_copy = false;

        while (copyHydraHeads != 0){Move3();}
        while(!((copyHydraTails % 4) == 0 )){
            Move2();
        }
        while(copyHydraTails != 0){
            Move4();
        }
        while (copyHydraHeads != 0){
            Move3();
        }
    }

    public void HeadsOdd_TailsEven(int H, int T){
        copyHydraHeads = H;
        copyHydraTails = T;
        impossible_copy = false;

        if(copyHydraTails == 2){
            Move4();
            while (copyHydraTails != 0){
                Move3();//Kill it!
            }

        }
        else if(copyHydraTails >= 4){
            Move4();
            while (copyHydraHeads != 0){
                Move3();
            }
            while (!((copyHydraTails % 4) == 0)){
                Move2();
            }
            while (copyHydraTails != 0){
                Move4();//Convert Tails to Heads
            }
            while (copyHydraHeads != 0){
                Move3();//Kill it!
            }
        }


    }
    public void HeadsEven_TailsOdd(int H, int T){
        copyHydraHeads = H;
        copyHydraTails = T;
        impossible_copy = false;

        while(copyHydraHeads != 0){
            Move3();
        }
        while(!((copyHydraTails % 4) == 0)){
            Move2();
        }
        while(copyHydraTails != 0){
            Move4();
        }
        while (copyHydraHeads != 0){
            Move3();//Kill Hydra!
        }
    }
    public void Special_Cases(int H, int T){
        copyHydraHeads = H;
        copyHydraTails = T;
        //If Both Heads and Tails are "0" Hydra is already dead.
        if(copyHydraHeads == 0 && copyHydraTails == 0){
            impossible_copy = true;
        }
        //If Heads is positive and Tails is zero -- special case.
        if(copyHydraHeads != 0 && copyHydraTails == 0){
            if(copyHydraHeads %2 != 0){
                impossible_copy = true;
            }
            else if(copyHydraHeads %2 == 0){
                while (copyHydraHeads != 0){
                    Move3();//Kill it!!
                }

            }
        }
        //If Heads is zero and Tails is positive -- special case.
        if(copyHydraHeads == 0 && copyHydraTails != 0){
            while(!((copyHydraTails %2) == 0)){
                Move2();
            }
            while (copyHydraTails != 0){
                Move4();
            }
            while(copyHydraHeads != 0){
                Move3();
            }
        }
    }


}
