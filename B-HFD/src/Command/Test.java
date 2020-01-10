package Command;
//命令模式的客户端
public class Test {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();//是请求者，会传入一个对象，调用发出请求
        Light light = new Light();//接收者
        LightOnCommand lightOn = new LightOnCommand(light);//创建了一个命令，将接收者传给它
        LightOffCommand lightOff = new LightOffCommand(light);
        remote.setCommand(lightOn);//把命令传给调用者
        remote.buttonWasPressed();
    }
}
