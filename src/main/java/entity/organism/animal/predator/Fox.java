package entity.organism.animal.predator;

import settings.BaseOrganismSettings;

public class Fox extends Predator {
    public Fox() {
        super(new BaseOrganismSettings(Fox.class.getSimpleName()));
    }
}
