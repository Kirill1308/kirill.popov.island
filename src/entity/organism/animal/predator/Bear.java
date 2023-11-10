package entity.organism.animal.predator;

import settings.BaseOrganismSettings;

public class Bear extends Predator {
    public Bear() {
        super(new BaseOrganismSettings(Bear.class.getSimpleName()));
    }
}
