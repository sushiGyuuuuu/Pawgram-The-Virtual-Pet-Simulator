package paw.models;

public abstract class Mammal extends Pets{
    public Mammal(String name, String species, String accs, boolean sick) {
        super(name, species, accs, sick);
    }

    public void groomFur() {
        System.out.println(getPetName() + " is getting its fur groomed.");
        petMood(5);
        petExperience(8);
        checkHealth();
    }

    public void giveBirth() {
        System.out.println(getPetName() + " gave birth!");
        petExperience(10);
        checkHealth();
    }

    @Override
    public void reactToTouch() {
        if(getMoodLevel() >= 30) {
            System.out.println(getPetName() + " enjoys being petted!");
            petExperience(10);
            petMood(10);
        }else {
            System.out.println(getPetName() + " feels scared and backed away...");
            petMood(-5);
        }
        checkHealth();
    }
}
