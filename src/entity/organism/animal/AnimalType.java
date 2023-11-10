package entity.organism.animal;

import entity.organism.animal.herbivore.Horse;
import entity.organism.animal.herbivore.Rabbit;
import entity.organism.animal.predator.Bear;
import entity.organism.animal.predator.Wolf;
import lombok.Getter;
import settings.BaseOrganismSettings;

@Getter
public enum AnimalType {
    WOLF(Wolf.class, new BaseOrganismSettings(Wolf.class.getSimpleName())),
    BEAR(Bear.class, new BaseOrganismSettings(Bear.class.getSimpleName())),
    RABBIT(Rabbit.class, new BaseOrganismSettings(Rabbit.class.getSimpleName())),
    HORSE(Horse.class, new BaseOrganismSettings(Horse.class.getSimpleName()));

    private final Class<? extends Animal> animalClass;
    private final BaseOrganismSettings animalSettings;

    AnimalType(Class<? extends Animal> animalClass, BaseOrganismSettings animalSettings) {
        this.animalClass = animalClass;
        this.animalSettings = animalSettings;
    }
}
