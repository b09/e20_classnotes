require('pg')
require('pry')
class PizzaOrder
  attr_accessor :name, :color, :pizza_type,
  :quantity

  def initialize( options )
    @name = options['name']
    @color = options['color']
    @pizza_type = options['pizza_type']
    @quantity = options['quantity'].to_i
  end

  def save
    # save all the info about this object in a DB
    db = PG.connect( { dbname: 'pizza_shop', host: 'localhost'} )
    # stuff
    # a_sql = "
    #   INSERT INTO pizza_orders
    #     (name, color, pizza_type, quantity)
    #     VALUES
    #     ('#{@name}', '#{@color}', '#{@pizza_type}', #{@quantity})
    #     ;
    #   "
    #   binding.pry
    #
    #   db.exec(a_sql)

    pretty_sql = "
    INSERT INTO pizza_orders
      (name, color, pizza_type, quantity)
      VALUES
        ($1,$2,$3,$4)
      ;
    "
    values = [@name, @color, @pizza_type, @quantity]

    db.prepare("save_it", pretty_sql)
    db.exec_prepared("save_it", values)

    db.close()
  end

  def PizzaOrder.all
      db = PG.connect( { dbname: "pizza_shop", host: "localhost" })

      sql = "SELECT * FROM pizza_orders;"
      db.prepare("get all", sql)
      orders = db.exec_prepared("get all")
      # binding.pry

      db.close()

      pizza_order_objects = orders.map { |order_hash| PizzaOrder.new(order_hash) }

      # pizza_order_objects = []
      # for order_hash in orders
      #   pizza_order_objects << PizzaOrder.new(order_hash)
      # end

      return pizza_order_objects
  end



end
