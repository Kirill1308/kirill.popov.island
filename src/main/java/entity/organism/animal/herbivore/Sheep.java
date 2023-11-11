package entity.organism.animal.herbivore;

import settings.BaseOrganismSettings;

public class Sheep extends Herbivore{
    public Sheep() {
        super(new BaseOrganismSettings(Sheep.class.getSimpleName()));
    }
}
