# Ecosystems


## Bears, River, Fish

We are going to build a small ecosystem! We want to create an ecosystem made up of 3 parts: bears, river and fish. You will need a class for each of these. From this you can make instances and build your ecosystem.

### MVP - Minimum Viable Product (50%)

- A fish should have a species e.g. "Trout"
- A river should have a name e.g. "Amazon"
- A river should have many fish
- A bear should have a name e.g. "Yogi"
- A bear should have an stomach which can fit some fish ( maybe an array? ). Stomach is initially empty
- A bear has a method ```eat_a_fish( Fish )``` which takes a Fish object and puts it in bear's stomach

### Taking It Further

- A river has a method ```fish_count()``` which returns a number of fish in it
- A bear has a method ```is_starving?()``` which checks if bear's stomach is empty
- A bear should be able to eat a fish from the river. Bear will have a function ```hunt_for_fish( River )``` which takes a River object as an argument. Inside it will check if there is any fish in the river, take the first fish and bear will eat that fish
- A river should lose a fish when a bear eats a fish

### Extras

- A river has a method ```a_fish_is_born( String )``` which will take a String which will become newborn fish's name
- A bear has a method digest() which will empty it's stomach
- A bear has a method ```hunt_for_many_fish( River, fish_count )``` which takes many fish objects and puts it in bear's stomach
- A bear should be able to only eat many fish if they are that many in the river.
