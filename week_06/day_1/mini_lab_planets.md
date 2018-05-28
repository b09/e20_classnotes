# Single Class - minilab (45 mins)

Create a new project 'Planets'

1. Write your tests first! (Hint: You should have at least 3 tests).
2. Convert the following Ruby code into Java. (Hint: You could create a Runner class with a main method to print to the screen).



```
class Planet

  def initialize(name, size)
    @name = name
    @size = size
  end

  def get_name()
    return @name
  end

  def get_size()
    return @size
  end

  def explode()
    return "Boom! #{@name} has exploded."
  end

end

mars = Planet.new("Mars", 908973)
puts "#{mars.get_name()} is #{mars.get_size()}"
puts mars.explode()
```
