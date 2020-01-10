package Command;
//是具体命令(ConcreteCommand)角色
//打开电灯命令
public class LightOnCommand implements Command {
    Light light;
    public LightOnCommand(Light light){
        this.light = light;
    }
    public void execute(){
        light.on();
    }
}
