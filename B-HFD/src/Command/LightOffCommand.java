package Command;
//是具体命令(ConcreteCommand)角色
//关闭电灯命令
public class LightOffCommand implements Command{
    Light light;
    public LightOffCommand(Light light){
        this.light = light;
    }
    public void execute(){
        light.off();
    }
}
