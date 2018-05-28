require('minitest/autorun')
require_relative('../kid')
require_relative('../classroom')

class TestClassroom < MiniTest::Test
  def setup
    kid1 = Kid.new("Jimmy", 6)
    kid2 = Kid.new("Hamish", 9)
    kid3 = Kid.new("Emmily", 7)
    kids_arr = [kid1, kid2, kid3]
    @classroom1 = Classroom.new(12, 20, kids_arr)
  end

  def test_claroom_has_kids
    group_length =  @classroom1.group.length
    assert_equal(3, group_length)
  end

  def test_assembly
    assembly_result = @classroom1.assembly()
    assembly_expected = [
      "My name is Jimmy, I'm 6",
      "My name is Hamish, I'm 9",
      "My name is Emmily, I'm 7"
    ]

    assert_equal(assembly_expected, assembly_result)
  end
end
