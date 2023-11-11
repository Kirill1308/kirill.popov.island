package entity.organism.animal.herbivore;

import settings.BaseOrganismSettings;

public class Horse extends Herbivore {
    public Horse() {
        super(new BaseOrganismSettings(Horse.class.getSimpleName()));
    }
}
