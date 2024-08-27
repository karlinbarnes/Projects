public class ShowDown extends Moves2Kill {
    boolean Decision;

    ShowDown(){

    }

    public boolean Decision() {
        if(!isHydraDead()){
            Decision = keepGoing();
        }
        else {
            Decision = !isHydraDead();
        }

        return Decision;
    }

    // Just decided to shove this function here because of space. it was at the end of TestRescuePrincessPerly
    // but that made the class too long.











}

