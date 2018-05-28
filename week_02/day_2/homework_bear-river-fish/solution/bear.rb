class Bear
  attr_reader :name, :stomach
  def initialize(new_name)
    @name = new_name
    @stomach = []
  end

  def eat_a_fish(eaten_fish)
    @stomach << eaten_fish
  end

  def is_starving?
    return @stomach.length == 0
  end

  def hunt_for_fish( the_river_to_hunt )
    fish_being_eaten =  the_river_to_hunt.get_one_fish()
    @stomach << fish_being_eaten
  end

  def digest
    @stomach = []
  end

  def hunt_for_many_fish( the_river_to_hunt , how_many_fish_to_catch)
    
    if the_river_to_hunt.fish_count >= how_many_fish_to_catch

      for i in 1..how_many_fish_to_catch
        fish_being_eaten =  the_river_to_hunt.get_one_fish()
        @stomach << fish_being_eaten
      end
    end

  end
end
