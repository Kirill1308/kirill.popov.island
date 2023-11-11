package entity.organism.plant;

import entity.organism.Organism;
import lombok.Getter;
import settings.BaseOrganismSettings;

@Getter
public abstract class Plant extends Organism {

    private boolean eaten = false;


    public Plant(BaseOrganismSettings organismSettings) {
        super(organismSettings);
    }

    public void setEaten(boolean eaten) {
        this.eaten = eaten;
    }

    public boolean hasEaten() {
        return eaten;
    }

}
