class CPU{
    public void freeze(){
        System.out.println("CPU: Freezed");
    }
    public void execute(){
        System.out.println("Starting OS......");
    }
}
class Memory{
    public void load(){
        System.out.println("Loading memory......");
    }
}
class HardDrive{
    public void read(){
        System.out.println("Reading from memory......");
    }
}
class ComputerFacade{
    private final CPU cpu;
    private final Memory memory;
    private final HardDrive hardDrive;
    public ComputerFacade(){
        cpu = new CPU();
        memory = new Memory();
        hardDrive = new HardDrive();
    }
    public void start(){
        System.out.println("------Starting Computer------");
        cpu.freeze();
        hardDrive.read();
        memory.load();
        cpu.execute();
        System.out.println("------Computer Started Successfully------");
    }
}
public class FacadeDesignPattern {
    public static void main(String[] args){
        ComputerFacade computerFacade = new ComputerFacade();
        computerFacade.start();;
    }
}
