class River
  attr_reader :name, :all_fish

  def initialize(new_name, new_all_fish)
    @name = new_name
    @all_fish = new_all_fish
  end

  def fish_count
    return @all_fish.length
  end

  def get_one_fish
    return @all_fish.pop()
  end

  def fish_is_born(fish_species)
    a_new_fish = Fish.new(fish_species)
    @all_fish.push(a_new_fish)
  end
end
