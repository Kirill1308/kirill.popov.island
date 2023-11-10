package entity.organism.animal.herbivore;

import entity.organism.animal.Animal;
import entity.organism.plant.Plant;
import settings.BaseOrganismSettings;

public abstract class Herbivore extends Animal {
    public Herbivore(BaseOrganismSettings organismSettings) {
        super(organismSettings);
    }

}
