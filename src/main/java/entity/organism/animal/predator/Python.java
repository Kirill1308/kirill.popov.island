package entity.organism.animal.predator;

import settings.BaseOrganismSettings;

public class Python extends Predator {
    public Python() {
        super(new BaseOrganismSettings(Python.class.getSimpleName()));
    }
}
