require('pry')
require_relative('models/pizza_order')

options_hash = { 'name' => 'Raphael', 'color' => 'red', 'pizza_type' => 'margherita', 'quantity' => '3' }
order1 = PizzaOrder.new( options_hash )

options_hash2 = { 'name' => 'Donatello', 'color' => 'purple', 'pizza_type' => 'margherita', 'quantity' => '6' }
order2 = PizzaOrder.new( options_hash2 )

order1.save()
order2.save()

all_pizzas = PizzaOrder.all()
p all_pizzas.length
