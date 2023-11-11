**Project Description: Animal Simulation on an Island**

This Java project simulates the interactions between various animal species and plants on a virtual island. The island is represented as a grid of cells, each capable of hosting a population of animals and plants. The simulation introduces a diverse set of animal species, each with unique characteristics and behaviors.

**Key Components:**

**Island and Cells:**
    The Island class represents the entire simulation environment. It is initialized with user-defined dimensions (width and height).
    The island is divided into cells (IslandCell), each of which can contain a mix of plants and animals.
    
**Organisms:**
    Different types of animals are introduced, such as wolves, bears, pythons, eagles, foxes, boars, buffaloes, deers, ducks, goats, mice, sheep, and horses.
    Each animal type has specific properties including weight, maximum quantity per cell, speed, and food needed for survival.

**Plants:**
The island also features plants, represented by the Grass class.

**Simulation:**
    The AnimalSimulator class orchestrates the simulation process. It introduces multi-threading to simulate actions in parallel across different cells.
    Animals move, reproduce, and consume food based on their predefined characteristics.

**User Interaction:**
    The UserHandler class allows users to input the dimensions of the island at the beginning of the simulation.

**Output and Visualization:**
    The StatisticViewProvider class handles the printing of simulation statistics, including the counts of each species in every cell.
    The simulation progress is visually represented with emojis corresponding to each species.

**Simulation Workflow:**
    User provides the dimensions of the island.
    The island is populated with a random distribution of animals and plants.
    Simulation begins, with animals interacting, reproducing, and moving across cells.
    Multi-threading is employed to parallelize the simulation process for improved efficiency.
    The progress and outcome of the simulation are displayed, including the final state of the island and the populations of different species.


**Example:**

![image](https://github.com/Kirill1308/kirill.popov.island/assets/104222407/2b338215-e310-4085-8196-5478ef1aab87)
![image](https://github.com/Kirill1308/kirill.popov.island/assets/104222407/4f842cbf-88e1-494e-b578-754e4e04fb17)
![image](https://github.com/Kirill1308/kirill.popov.island/assets/104222407/3ab146fa-8d41-4998-bb2b-e8ecef29a1bc)
![image](https://github.com/Kirill1308/kirill.popov.island/assets/104222407/844b72af-3b6b-48dd-9e7e-f684327c71e1)
![image](https://github.com/Kirill1308/kirill.popov.island/assets/104222407/c259b6db-a3f2-44e7-9d24-a09f4016ef86)
![image](https://github.com/Kirill1308/kirill.popov.island/assets/104222407/d74233a3-39af-4314-b671-ae4237830bb2)
