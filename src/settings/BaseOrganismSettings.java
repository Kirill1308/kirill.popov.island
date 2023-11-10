package settings;

import lombok.Getter;
import properties.FilePropertyReader;

@Getter
public class BaseOrganismSettings {
    private final FilePropertyReader filePropertyReader = new FilePropertyReader();
    private final String icon;
    private final int weight;
    private final int maxQuantity;
    private final int speed;
    private final double foodNeeded;

    public BaseOrganismSettings(String animalName) {
        filePropertyReader.loadAnimalProperties();
        this.icon = filePropertyReader.loadIcon(animalName);
        this.weight = filePropertyReader.loadWeight(animalName);
        this.maxQuantity = Integer.parseInt(filePropertyReader.loadMaxQuantity(animalName));
        this.speed = filePropertyReader.loadSpeed(animalName);
        this.foodNeeded = filePropertyReader.loadFoodNeeded(animalName);
    }
}
