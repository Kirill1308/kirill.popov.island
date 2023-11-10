package entity.organism.plant;

import settings.BaseOrganismSettings;

public class Grass extends Plant {
    public Grass(){
        super(new BaseOrganismSettings(Grass.class.getSimpleName()));
    }
}
