package ability;

import entity.organism.animal.Animal;

public interface Reproducible {
    Animal reproduce(Animal partner);
}
