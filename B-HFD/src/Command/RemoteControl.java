package Command;
//是请求者(Invoker)角色
public class RemoteControl {
    Command slot;
    public RemoteControl(){}
    public void setCommand(Command command){
        slot = command;
    }
    public void buttonWasPressed() {
        slot.execute();
    }
}
