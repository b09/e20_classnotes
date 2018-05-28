require('pry')
require_relative('models/pizza_order')

options_hash = { 'name' => 'Raphael', 'color' => 'red', 'pizza_type' => 'margherita', 'quantity' => '3' }
order1 = PizzaOrder.new( options_hash )

options_hash2 = { 'name' => 'Donatello', 'color' => 'purple', 'pizza_type' => 'margherita', 'quantity' => '6' }
order2 = PizzaOrder.new( options_hash2 )

options_hash3 = { 'name' => 'Leo', 'color' => 'blue', 'pizza_type' => 'margherita', 'quantity' => '1' }
order3 = PizzaOrder.new( options_hash3 )


PizzaOrder.delete_all()

order1.save()
order2.save()
order3.save()

all_pizzas = PizzaOrder.all()
p all_pizzas
puts ""

first_object = all_pizzas.first
first_object.name = "AAAA"
first_object.update()

p PizzaOrder.all()
puts ""

first_object.delete()

puts ""
p PizzaOrder.all()

puts ""
