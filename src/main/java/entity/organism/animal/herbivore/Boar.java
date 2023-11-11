package entity.organism.animal.herbivore;

import settings.BaseOrganismSettings;

public class Boar extends Herbivore{
    public Boar() {
        super(new BaseOrganismSettings(Boar.class.getSimpleName()));
    }
}
