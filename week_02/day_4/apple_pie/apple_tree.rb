require_relative('./apple')

class AppleTree

  attr_reader :apples, :variety, :season

  def initialize(apples, variety, season)
    @apples = apples
    @variety = variety
    @season = season
  end

  def grow_new_apple
    # Add an apple to @apples (Array)
    apple = Apple.new(true)
    @apples << apple
  end

  def drop_apple()
    if @apples.length > 0
      return @apples.shift
    end
    return Apple.new(true)
  end

end
