package paw.models;

public abstract class Fish extends Pets{
    public Fish(String name, String species, String accs, boolean sick) {
        super(name, species, accs, sick);
    }

    public void spawnEggs() {
        System.out.println(getPetName() + " spawned its eggs!");
        petExperience(10);
        checkHealth();
    }

    @Override
    public void makeSound() {
        System.out.println(getPetName() + "  happily goes: glub glub!!");
        petExperience(1);
        checkHealth();
    }

    @Override
    public void reactToTouch() {
        System.out.println(getPetName() + " does not want to be touched, and swam away!");
        petMood(-3);
        checkHealth();
    }
}
