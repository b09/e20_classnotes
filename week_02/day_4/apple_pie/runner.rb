require_relative('./apple')
require_relative('./apple_pie')
require_relative('./cook')
require_relative('./apple_tree')

apple1 = Apple.new(true)
apple2 = Apple.new(true)
apple3 = Apple.new(true)
apple4 = Apple.new(true)

delia = Cook.new("Delia")

gw_apple_tree = AppleTree.new([apple1, apple2], "Golden Wonder", "Autumn")
cox_apple_tree = AppleTree.new([apple3, apple4], "Cox", "Spring")

gw_apple_tree.grow_new_apple
gw_apple_tree.grow_new_apple
gw_apple_tree.grow_new_apple

delia.pick_apples(gw_apple_tree, 10)
p delia
