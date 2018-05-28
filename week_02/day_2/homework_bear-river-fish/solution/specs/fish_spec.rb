require('minitest/autorun')
require('minitest/rg')
require_relative('../fish.rb')


class FishTest < MiniTest::Test

  def setup()
    @a_fish = Fish.new("Trout")
  end

  def test_fish_species()
    assert_equal("Trout", @a_fish.species)
  end

end
