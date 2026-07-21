//////////////////   ThreadSafeLockingSingleton  ///////////////////////
class ThreadSafeLockingSingleton{
    public static ThreadSafeLockingSingleton instance = null;
    private ThreadSafeLockingSingleton(){
        System.out.println("ThreadSafeLockingSingleton Constructor called");
    }
    public static ThreadSafeLockingSingleton getInstance(){
        synchronized (ThreadSafeLockingSingleton.class){
            if(instance == null){
                instance = new ThreadSafeLockingSingleton();
            }
            return instance;
        }
    }
}
////////////////////// ThreadSafeEagerSingleton ///////////////////////
class ThreadSafeEagerSingleton{
    public static ThreadSafeEagerSingleton instance = new ThreadSafeEagerSingleton();
    private ThreadSafeEagerSingleton(){
        System.out.println("ThreadSafeEagerSingleton constructor called");
    }
    public static ThreadSafeEagerSingleton getInstance(){
        return  instance;
    }
}
////////////////////// ThreadSafeDoubleLockingSingleton /////////////////
class ThreadSafeDoubleLockingSingleton{
    public static ThreadSafeDoubleLockingSingleton instance = null;
    private ThreadSafeDoubleLockingSingleton(){
        System.out.println("ThreadSafeDoubleLockingSingleton constructor called");
    }
    public static ThreadSafeDoubleLockingSingleton getInstance(){
        if(instance == null){
            synchronized (ThreadSafeDoubleLockingSingleton.class){
                if(instance == null){
                    instance = new ThreadSafeDoubleLockingSingleton();
                }
            }
        }
        return instance;
    }
}
public class SingletonDesignPattern {
    public static void main(String[] args){
        ThreadSafeLockingSingleton s1 = ThreadSafeLockingSingleton.getInstance();
        ThreadSafeLockingSingleton s2 = ThreadSafeLockingSingleton.getInstance();
        System.out.println(s1 == s2);

        ThreadSafeEagerSingleton s3 = ThreadSafeEagerSingleton.getInstance();
        ThreadSafeEagerSingleton s4 = ThreadSafeEagerSingleton.getInstance();
        System.out.println(s3 == s4);

        ThreadSafeDoubleLockingSingleton s5 = ThreadSafeDoubleLockingSingleton.getInstance();
        ThreadSafeDoubleLockingSingleton s6 = ThreadSafeDoubleLockingSingleton.getInstance();
        System.out.println(s5 == s6);
    }
}
