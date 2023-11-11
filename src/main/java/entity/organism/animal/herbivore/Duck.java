package entity.organism.animal.herbivore;

import settings.BaseOrganismSettings;

public class Duck extends Herbivore{
    public Duck() {
        super(new BaseOrganismSettings(Duck.class.getSimpleName()));
    }
}
