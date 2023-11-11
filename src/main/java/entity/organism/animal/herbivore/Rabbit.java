package entity.organism.animal.herbivore;

import settings.BaseOrganismSettings;

public class Rabbit extends Herbivore {
    public Rabbit() {
        super(new BaseOrganismSettings(Rabbit.class.getSimpleName()));
    }
}
