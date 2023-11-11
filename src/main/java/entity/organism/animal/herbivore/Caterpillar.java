package entity.organism.animal.herbivore;

import settings.BaseOrganismSettings;

public class Caterpillar extends Herbivore {
    public Caterpillar() {
        super(new BaseOrganismSettings(Caterpillar.class.getSimpleName()));
    }
}
