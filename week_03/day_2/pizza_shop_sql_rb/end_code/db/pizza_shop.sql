DROP TABLE pizza_orders;

CREATE TABLE pizza_orders (
  id SERIAL4 PRIMARY KEY,
  name VARCHAR(255),
  color VARCHAR(255),
  pizza_type VARCHAR(255),
  quantity INT
);
