package entity.organism.animal.herbivore;

import settings.BaseOrganismSettings;

public class Mouse extends Herbivore{
    public Mouse() {
        super(new BaseOrganismSettings(Mouse.class.getSimpleName()));
    }
}
