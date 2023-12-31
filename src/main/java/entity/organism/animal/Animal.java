package entity.organism.animal;

import ability.Eatable;
import ability.Movable;
import ability.Reproducible;
import entity.organism.animal.predator.Predator;
import entity.organism.plant.Plant;
import entity.organism.Organism;
import entity.organism.animal.herbivore.Herbivore;
import lombok.Getter;
import lombok.Setter;
import settings.BaseOrganismSettings;

@Getter
@Setter
public abstract class Animal extends Organism implements Movable, Eatable, Reproducible {
    private boolean eaten = false;
    private boolean reproduced = false;
    private Animal pair;
    private double currentSatiety;

    public Animal(BaseOrganismSettings animalSettings) {
        super(animalSettings);
        this.currentSatiety = animalSettings.getFoodNeeded();
    }

    @Override
    public void eat(Object food) {
        if (food instanceof Animal) {
            if (this instanceof Predator) {
                eatPrey((Animal) food);
            }
        } else if (food instanceof Plant) {
            if (this instanceof Herbivore) {
                eatPlant((Plant) food);
            }
        }
    }

    public void eatPrey(Animal prey) {
        prey.setEaten(true);
    }

    public void eatPlant(Plant plant) {
        plant.setEaten(true);
    }

    @Override
    public Animal reproduce(Animal partner) {
        if (partner != null && partner.getClass() == getClass()) {
            try {
                return partner.getClass().getConstructor().newInstance();
            } catch (Exception e) {
                throw new RuntimeException("Error while reproducing!", e);
            }
        }
        return null;
    }

    @Override
    public void move() {

    }

    public boolean hasEaten() {
        return eaten;
    }

    public boolean hasReproduced() {
        return reproduced;
    }

    public boolean hasPair() {
        return pair != null;
    }

}
