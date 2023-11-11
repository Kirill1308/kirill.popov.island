package entity.organism.animal.herbivore;

import settings.BaseOrganismSettings;

public class Deer extends Herbivore{
    public Deer() {
        super(new BaseOrganismSettings(Deer.class.getSimpleName()));
    }
}
