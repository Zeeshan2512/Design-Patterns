interface ICommand{
    void execute();
}
class Light{
    private boolean isOn = false;
    public boolean isOn(){
        return isOn;
    }
    public void on(){
        isOn = true;
        System.out.println("Light turned ON");
    }
    public void off(){
        isOn = false;
        System.out.println("Light turned OFF");
    }
}
class Fan{
    private boolean isOn = false;
    public boolean isOn(){
        return isOn;
    }
    public void on(){
        isOn = true;
        System.out.println("Fan turned ON");
    }
    public void off(){
        isOn = false;
        System.out.println("Fan turned OFF");
    }
}
class LightCommand implements ICommand{
    private Light light;
    public LightCommand(Light l){
        this.light = l;
    }
    @Override
    public void execute() {
        if(light.isOn()){
            light.off();
        }
        else{
            light.on();
        }
    }
}
class FanCommand implements ICommand{
    private Fan fan;
    public FanCommand(Fan f){
        this.fan = f;
    }
    @Override
    public void execute() {
        if(fan.isOn()){
            fan.off();
        }
        else{
            fan.on();
        }
    }
}
class RemoteController{
    private static final int numButtons=4;
    private ICommand[] buttons;

    public RemoteController(){
        buttons = new ICommand[numButtons];
        for(int i=0;i<numButtons;i++){
            buttons[i] = null;
        }
    }

    public void setCommand(int idx, ICommand command){
        if(idx>=0 && idx<numButtons){
            buttons[idx] = command;
        }
        else{
            System.out.println("Input should be in range between 0 and " + numButtons);
        }
    }

    public void pressButton(int idx){
        if(idx>=0 && idx<numButtons && buttons[idx]!=null){
            buttons[idx].execute();
        }
        else{
            System.out.println("No command assigned at button " + idx);
        }
    }
}
public class CommandDesignPattern {
    public static void main(String[] args){
        Light roomLight = new Light();
        Fan ceilingFan = new Fan();

        ICommand lightCommand = new LightCommand(roomLight);
        ICommand fanCommand = new FanCommand(ceilingFan);

        RemoteController remoteController = new RemoteController();
        remoteController.setCommand(6,lightCommand);

        remoteController.setCommand(0,lightCommand);
        remoteController.setCommand(1,fanCommand);


        remoteController.pressButton(0);
        remoteController.pressButton(0);
        remoteController.pressButton(1);
        remoteController.pressButton(1);

        System.out.println("----Pressing unassigned button----");
        remoteController.pressButton(2);
    }
}
