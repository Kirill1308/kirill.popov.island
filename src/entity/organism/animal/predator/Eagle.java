package entity.organism.animal.predator;

import settings.BaseOrganismSettings;

public class Eagle extends Predator {
    public Eagle() {
        super(new BaseOrganismSettings(Eagle.class.getSimpleName()));
    }
}
