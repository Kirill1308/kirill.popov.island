package entity.organism.animal.predator;

import settings.BaseOrganismSettings;

public class Wolf extends Predator {
    public Wolf() {
        super(new BaseOrganismSettings(Wolf.class.getSimpleName()));
    }

}
