require('minitest/autorun')
require('minitest/rg')
require_relative('../river.rb')
require_relative('../fish.rb')


class RiverTest < MiniTest::Test

  def setup()
    some_fish = [
      Fish.new("Trout"),
      Fish.new("Trout"),
      Fish.new("Haddock"),
      Fish.new("Salmon")
    ]
    @a_river = River.new("Amazon", some_fish)
  end

  def test_river_name()
    assert_equal("Amazon", @a_river.name)
  end

  def test_river_has_many_fish
    assert_equal(Array,  @a_river.all_fish.class)
  end

  def test_river_fish_count
    assert_equal(4,  @a_river.fish_count)
  end

  def test_river_get_one_fish
    one_fish = @a_river.get_one_fish()
    assert_equal(Fish,  one_fish.class)
  end

  def test_river_get_one_fish__is_that_fish_gone
    one_fish = @a_river.get_one_fish()
    assert_equal(3,  @a_river.fish_count)
  end

  def test_river_fish_is_born
    @a_river.fish_is_born("Trout")
    assert_equal(5,  @a_river.fish_count)
  end



end
