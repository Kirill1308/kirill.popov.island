package entity.organism.animal.herbivore;

import settings.BaseOrganismSettings;

public class Buffalo extends Herbivore{
    public Buffalo() {
        super(new BaseOrganismSettings(Buffalo.class.getSimpleName()));
    }
}
