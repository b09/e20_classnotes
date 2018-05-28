require('minitest/autorun')
require('minitest/rg')
require_relative('../bear.rb')
require_relative('../river.rb')
require_relative('../fish.rb')


class BearTest < MiniTest::Test

  def setup()
    @a_fish = Fish.new("Trout")

    some_fish = [
      Fish.new("Trout"),
      Fish.new("Trout"),
      Fish.new("Haddock"),
      Fish.new("Salmon")
    ]
    @a_river = River.new("Amazon", some_fish)

    @a_bear = Bear.new("Yogi")
  end

  def test_bear_name()
    assert_equal("Yogi", @a_bear.name)
  end

  def test_bear_stomach_initially_empty
    assert_equal(0, @a_bear.stomach.length)
  end

  def test_bear_eat_a_fish
    @a_bear.eat_a_fish(@a_fish)
    assert_equal(1, @a_bear.stomach.length)
  end

  def test_bear_is_starving
    assert_equal(true, @a_bear.is_starving?)
  end

  def test_bear_hunt_for_fish
    @a_bear.hunt_for_fish(@a_river)
    assert_equal(false, @a_bear.is_starving?)
  end

  def test_bear_hunt_for_fish_river_looses_that_fish
    @a_bear.hunt_for_fish(@a_river)
    assert_equal(3, @a_river.fish_count)
  end

  def test_bear_hunt_for_many_fish
    @a_bear.hunt_for_many_fish(@a_river, 2)
    assert_equal(2, @a_bear.stomach.length)
  end

  def test_bear_hunt_for_many_fish__not_enough_fish
    @a_bear.hunt_for_many_fish(@a_river, 20)
    assert_equal(0, @a_bear.stomach.length)
  end


end
