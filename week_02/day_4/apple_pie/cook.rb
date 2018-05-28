class Cook

  attr_reader :name

  def initialize(name)
    @name = name
    @apples = []
  end

  def pick_apples(apple_tree, num_of_apples)

    i = 0

    while i < num_of_apples
      @apples << apple_tree.drop_apple
      i = i + 1
    end

  end

end
