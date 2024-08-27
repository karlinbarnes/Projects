public class GameOver {
    boolean Continue;

    public void setKeepGoing(boolean input) {
        Continue = input;
    }

    public boolean keepGoing() {
        //true continue
        //false quit
        return Continue;
    }


}
