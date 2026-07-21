interface ICharacter{
    String getAbilities();
}
class Mario implements ICharacter{
    @Override
    public String getAbilities() {
        return "Mario";
    }
}

abstract class CharacterDecorator implements ICharacter {
    protected ICharacter character;

    public CharacterDecorator(ICharacter character) {
        this.character = character;
    }
}

class HeightUp extends CharacterDecorator{
    public HeightUp(ICharacter character) {
        super(character);
    }

    @Override
    public String getAbilities() {
        return character.getAbilities() + " with HeightUp";
    }
}
class GunPower extends CharacterDecorator{
    public GunPower(ICharacter character) {
        super(character);
    }

    @Override
    public String getAbilities() {
        return character.getAbilities() + " with GunPower";
    }
}
class StarPower extends CharacterDecorator{
    public StarPower(ICharacter character) {
        super(character);
    }

    @Override
    public String getAbilities() {
        return character.getAbilities() + " with StarPower";
    }
}
public class DecoratorDesignPattern {
    public static void main(String[] args){
        ICharacter mario = new Mario();
        System.out.println("Basic Character: "+mario.getAbilities());

        mario = new HeightUp(mario);
        System.out.println("After Height Up: "+mario.getAbilities());

        mario = new StarPower(mario);
        System.out.println("After Star Power: "+mario.getAbilities());

        mario = new GunPower(mario);
        System.out.println("After Gun Power: "+mario.getAbilities());
    }
}
