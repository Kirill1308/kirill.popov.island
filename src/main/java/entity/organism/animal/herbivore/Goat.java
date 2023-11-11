package entity.organism.animal.herbivore;

import settings.BaseOrganismSettings;

public class Goat extends Herbivore{
    public Goat() {
        super(new BaseOrganismSettings(Goat.class.getSimpleName()));
    }
}
