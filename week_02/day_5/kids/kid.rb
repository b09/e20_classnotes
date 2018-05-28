class Kid
  attr_reader :name, :age
  def initialize( n, a )
    @name = n
    @age = a
  end

  def introduce_yourself
    return "My name is #{@name}, I'm #{@age}"
  end

end
