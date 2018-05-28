require('minitest/autorun')
require_relative('../kid')

class TestKid < MiniTest::Test
  def setup
    @kid1 = Kid.new("Jimmy", 6)
  end

  def test_kid_has_name
    assert_equal("Jimmy", @kid1.name)
  end

  def test_kid_introruces_itself
    assert_equal("My name is Jimmy, I'm 6", @kid1.introduce_yourself())
  end
end
