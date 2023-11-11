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

Enter the WIDTH (number of columns) of your Island: 2
Enter the HEIGHT (number of rows) of your Island: 2
=====================================================================================================================
Island is populated!
=====================================================================================================================
(0,  0)	🐺(0)	🐻(0)	🐍(0)	🦅(0)	🦊(0)	🐗(0)	🦢(0)	🦌(1)	🦆(0)	🐐(0)	🐭(1)	🐑(0)	🐴(0)	🌱(4)	
(0,  1)	🐺(1)	🐻(1)	🐍(0)	🦅(0)	🦊(1)	🐗(0)	🦢(0)	🦌(1)	🦆(1)	🐐(0)	🐭(2)	🐑(2)	🐴(0)	🌱(6)	
(1,  0)	🐺(0)	🐻(1)	🐍(0)	🦅(0)	🦊(0)	🐗(1)	🦢(1)	🦌(0)	🦆(1)	🐐(0)	🐭(0)	🐑(1)	🐴(0)	🌱(8)	
(1,  1)	🐺(0)	🐻(1)	🐍(2)	🦅(1)	🦊(1)	🐗(2)	🦢(0)	🦌(0)	🦆(0)	🐐(0)	🐭(1)	🐑(0)	🐴(1)	🌱(5)	
=====================================================================================================================
Current organisms in cell [0][0]:
🌱 id = 0
🌱 id = 1
🌱 id = 2
🌱 id = 3
🦌 id = 4
🐭 id = 5
=====================================================================================================================
🦌 (id=4) ate a 🌱 (id=0)
🐭 (id=5) ate a 🌱 (id=1)

(0,  0)	🐺(0)	🐻(0)	🐍(0)	🦅(0)	🦊(0)	🐗(0)	🦢(0)	🦌(1)	🦆(0)	🐐(0)	🐭(1)	🐑(0)	🐴(0)	🌱(2)	
=====================================================================================================================
Simulation ended in cell [0][0].
=====================================================================================================================
Current organisms in cell [1][1]:
🌱 id = 36
🌱 id = 37
🌱 id = 38
🌱 id = 39
🌱 id = 40
🦊 id = 41
🐴 id = 42
🐍 id = 43
🐻 id = 44
🦅 id = 45
🐭 id = 46
🐗 id = 47
🐍 id = 48
🐗 id = 49
=====================================================================================================================
🦊 (id=41) ate a 🐴 (id=42)
🐍 (id=43) moved to cell[1][0]
🐻 (id=44) ate a 🐭 (id=46)
🦅 (id=45) moved to cell[0][1]
🐗 (id=47) ate a 🌱 (id=36)
🐍 (id=48) ate a 🐗 (id=47)
🐗 (id=49) ate a 🌱 (id=37)

(1,  1)	🐺(0)	🐻(1)	🐍(1)	🦅(0)	🦊(1)	🐗(1)	🦢(0)	🦌(0)	🦆(0)	🐐(0)	🐭(0)	🐑(0)	🐴(0)	🌱(3)	
=====================================================================================================================
Simulation ended in cell [1][1].
=====================================================================================================================
Current organisms in cell [1][0]:
🌱 id = 21
🌱 id = 22
🌱 id = 23
🌱 id = 24
🌱 id = 25
🌱 id = 26
🌱 id = 27
🌱 id = 28
🐻 id = 29
🐑 id = 30
🦢 id = 31
🐗 id = 32
🐰 id = 33
🐰 id = 34
🦆 id = 35
🐍 id = 43
=====================================================================================================================
🐻 (id=29) did not find a suitable partner for reproduction.
🐑 (id=30) moved to cell[1][0]
🦢 (id=31) moved to cell[1][1]
🐗 (id=32) moved to cell[0][0]
🐰 (id=33) ate a 🌱 (id=21)
🐰 (id=34) and 🐰 (id=33) reproduced, creating a new 🐰 (id=50)
🦆 (id=35) moved to cell[0][0]
🐍 (id=43) ate a 🐰 (id=33)

(1,  0)	🐺(0)	🐻(1)	🐍(1)	🦅(0)	🦊(0)	🐗(0)	🦢(0)	🦌(0)	🦆(0)	🐐(0)	🐭(0)	🐑(1)	🐴(0)	🌱(7)	
=====================================================================================================================
Simulation ended in cell [1][0].
=====================================================================================================================
Current organisms in cell [0][1]:
🌱 id = 6
🌱 id = 7
🌱 id = 8
🌱 id = 9
🌱 id = 10
🌱 id = 11
🐑 id = 12
🐭 id = 13
🐻 id = 14
🦌 id = 15
🦊 id = 16
🐭 id = 17
🐺 id = 18
🦆 id = 19
🐑 id = 20
🦅 id = 45
=====================================================================================================================
🐑 (id=12) ate a 🌱 (id=6)
🐭 (id=13) moved to cell[0][0]
🐻 (id=14) moved to cell[0][0]
🦌 (id=15) moved to cell[1][1]
🦊 (id=16) ate a 🐑 (id=12)
🐭 (id=17) moved to cell[0][0]
🐺 (id=18) moved to cell[1][1]
🦆 (id=19) did not find a suitable partner for reproduction.
🐑 (id=20) ate a 🌱 (id=7)
🦅 (id=45) did not find a suitable partner for reproduction.

(0,  1)	🐺(0)	🐻(0)	🐍(0)	🦅(1)	🦊(1)	🐗(0)	🦢(0)	🦌(0)	🦆(1)	🐐(0)	🐭(0)	🐑(1)	🐴(0)	🌱(4)	
=====================================================================================================================
Simulation ended in cell [0][1].
=====================================================================================================================
Finish!
=====================================================================================================================
(0,  0)	🐺(0)	🐻(1)	🐍(0)	🦅(0)	🦊(0)	🐗(1)	🦢(0)	🦌(1)	🦆(1)	🐐(0)	🐭(3)	🐑(0)	🐴(0)	🌱(2)	
(0,  1)	🐺(0)	🐻(0)	🐍(0)	🦅(1)	🦊(1)	🐗(0)	🦢(0)	🦌(0)	🦆(1)	🐐(0)	🐭(0)	🐑(1)	🐴(0)	🌱(4)	
(1,  0)	🐺(0)	🐻(1)	🐍(1)	🦅(0)	🦊(0)	🐗(0)	🦢(0)	🦌(0)	🦆(0)	🐐(0)	🐭(0)	🐑(1)	🐴(0)	🌱(7)	
(1,  1)	🐺(1)	🐻(1)	🐍(1)	🦅(0)	🦊(1)	🐗(1)	🦢(1)	🦌(1)	🦆(0)	🐐(0)	🐭(0)	🐑(0)	🐴(0)	🌱(3)	
=====================================================================================================================
