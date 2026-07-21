import java.util.ArrayList;
import java.util.List;

interface ISubscriber{
    void update();
}
interface IChannel{
    void subscribe(ISubscriber subscriber);
    void unsubscribe(ISubscriber subscriber);
    void notifySubscribers();
}
class Channel implements IChannel{
    private String name;
    private List<ISubscriber> subscribers;
    private String latestVideo;

    public Channel(String name){
        this.name = name;
        subscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(ISubscriber subscriber) {
        if(!subscribers.contains(subscriber)){
            subscribers.add(subscriber);
        }
    }
    @Override
    public void unsubscribe(ISubscriber subscriber) {
            subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for(ISubscriber sub:subscribers){
            sub.update();
        }
    }

    public void uploadVideo(String title){
        latestVideo = title;
        System.out.println("\n[" + name + " uploaded \"" + title + "\"]");
        notifySubscribers();
    }
    public String getVideoData(){
        return "\nCheckout our new Video : " + latestVideo + "\n";
    }
}

class Subscriber implements ISubscriber{
    private String name;
    private Channel channel;

    public Subscriber(String name, Channel channel) {
        this.name = name;
        this.channel = channel;
    }

    @Override
    public void update() {
        System.out.println("Hey " + name + "," + channel.getVideoData());
    }
}
public class ObserverDesignPattern {
    public static void main(String[] args){
        Channel channel = new Channel("CodeWithZeeshan");
        Subscriber subscriber1 = new Subscriber("Mike", channel);
        Subscriber subscriber2 = new Subscriber("John", channel);

        channel.subscribe(subscriber1);
        channel.subscribe(subscriber2);
        channel.uploadVideo("System Design LLD");

        channel.unsubscribe(subscriber2);
        channel.uploadVideo("System Design HLD");
    }
}
