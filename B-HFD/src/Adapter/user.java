package Adapter;

public class user {
    public static void main(String[] args) {
        BullThree bullThree = new BullThree();
        TwoToThreeAdapter twoToThreeAdapter = new TwoToThreeAdapter(bullThree);
        twoToThreeAdapter.useTwoHole();
    }
}
