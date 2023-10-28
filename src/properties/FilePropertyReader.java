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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String loadMaxQuantity(String animalName) {
        String maxQuantityKey = animalName + ".max_quantity";
        return String.valueOf(Integer.parseInt(animalProperties.getProperty(maxQuantityKey, "0")));
    }

    public int loadHungerLevel(String animalName) {
        int hunger = 0;
        try {
            FileInputStream input = new FileInputStream("./src/properties/animal_properties.properties");
            animalProperties.load(input);
            String hungerKey = animalName + ".food_needed";
            hunger = Integer.parseInt(animalProperties.getProperty(hungerKey));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return hunger;
    }
}
