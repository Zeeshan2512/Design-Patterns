interface Burger{
    void prepare();
}
class BasicBurger implements Burger{
    @Override
    public void prepare() {
        System.out.println("Preparing Basic Burger");
    }
}
class StandardBurger implements Burger{
    @Override
    public void prepare() {
        System.out.println("Preparing Standard Burger");
    }
}
class PremiumBurger implements Burger{
    @Override
    public void prepare() {
        System.out.println("Preparing Premium Burger");
    }
}
class BasicWheatBurger implements Burger{
    @Override
    public void prepare() {
        System.out.println("Preparing Basic Burger");
    }
}
class StandardWheatBurger implements Burger{
    @Override
    public void prepare() {
        System.out.println("Preparing Standard Burger");
    }
}
class PremiumWheatBurger implements Burger{
    @Override
    public void prepare() {
        System.out.println("Preparing Premium Burger");
    }
}

interface GarlicBread{
    void prepare();
}
class BasicGarlicBread implements GarlicBread{
    @Override
    public void prepare() {
        System.out.println("Preparing Basic Garlic Bread");
    }
}
class CheeseGarlicBread implements GarlicBread{
    @Override
    public void prepare() {
        System.out.println("Preparing Cheese Garlic Bread");
    }
}

class BasicWheatGarlicBread implements GarlicBread{
    @Override
    public void prepare() {
        System.out.println("Preparing Basic Wheat Garlic Bread");
    }
}
class CheeseWheatGarlicBread implements GarlicBread{
    @Override
    public void prepare() {
        System.out.println("Preparing Cheese Wheat Garlic Bread");
    }
}

interface MealFactory{
    Burger createBurger(String type);
    GarlicBread createGarlicBread(String type);
}
class SinghBurger implements MealFactory {
    public Burger createBurger(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicBurger();
        } else if (type.equalsIgnoreCase("standard")) {
            return new StandardBurger();
        } else if (type.equalsIgnoreCase("premium")) {
            return new PremiumBurger();
        } else {
            System.out.println("Invalid burger type!");
            return null;
        }
    }

    public GarlicBread createGarlicBread(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicGarlicBread();
        } else if (type.equalsIgnoreCase("cheese")) {
            return new CheeseGarlicBread();
        } else {
            System.out.println("Invalid Garlic bread type!");
            return null;
        }
    }
}

class KingBurger implements MealFactory {
    public Burger createBurger(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicWheatBurger();
        } else if (type.equalsIgnoreCase("standard")) {
            return new StandardWheatBurger();
        } else if (type.equalsIgnoreCase("premium")) {
            return new PremiumWheatBurger();
        } else {
            System.out.println("Invalid burger type!");
            return null;
        }
    }

    public GarlicBread createGarlicBread(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicWheatGarlicBread();
        } else if (type.equalsIgnoreCase("cheese")) {
            return new CheeseWheatGarlicBread();
        } else {
            System.out.println("Invalid Garlic bread type!");
            return null;
        }
    }
}
public class FactoryDesignPattern {
    public static void main(String[] args) {
        String burgerType="Premium";
        String garlicBreadType="Cheese";

        MealFactory mealFactory = new KingBurger();
        Burger burger = mealFactory.createBurger(burgerType);
        GarlicBread garlicBread = mealFactory.createGarlicBread(garlicBreadType);
        if(burger!=null)burger.prepare();;
        if(garlicBread!=null)garlicBread.prepare();
    }
}
