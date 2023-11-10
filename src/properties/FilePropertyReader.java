package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FilePropertyReader {
    private final Properties animalProperties = new Properties();

    public void loadAnimalProperties() {
        try {
            FileInputStream input = new FileInputStream("./src/properties/animal_properties.properties");
            animalProperties.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Error loading properties from the file!", e);
        }
    }

    public String loadIcon(String animalName) {
        String icon = animalName + ".icon";
        return animalProperties.getProperty(icon, "");
    }

    public String loadMaxQuantity(String animalName) {
        String maxQuantityKey = animalName + ".max_quantity";
        return String.valueOf(Integer.parseInt(animalProperties.getProperty(maxQuantityKey, "0")));
    }

    public int loadWeight(String animalName) {
        String weight = animalName + ".weight";
        return Integer.parseInt(animalProperties.getProperty(weight, "0"));
    }

    public int loadSpeed(String animalName) {
        String speed = animalName + ".speed";
        return Integer.parseInt(animalProperties.getProperty(speed, "0"));
    }

    public double loadFoodNeeded(String animalName) {
        String foodNeeded = animalName + ".food_needed";
        return Double.parseDouble(animalProperties.getProperty(foodNeeded, "0"));
    }

}