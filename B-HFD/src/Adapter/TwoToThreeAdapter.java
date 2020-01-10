package Adapter;

//需要实现想转换成的类型接口
public class TwoToThreeAdapter implements TwoHoleSocket{
    ThreeHoleSocket threeHoleSocket;
    //需要获得要适配对象的引用
    public TwoToThreeAdapter(BullThree bullThree) {
        threeHoleSocket = bullThree;
    }

    //需要实现接口中的所有方法
    public void useTwoHole() {
        threeHoleSocket.useThreeHole();
    }
}
