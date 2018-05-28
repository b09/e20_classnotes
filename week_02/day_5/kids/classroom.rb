class Classroom
  attr_reader :name, :capacity, :group

  def initialize(name, capacity, group)
    @name = name
    @capacity = capacity
    @group = group
  end

  def assembly()
    result = []

    for a_kid in @group
      result << a_kid.introduce_yourself()
    end

    return result

  end

end
