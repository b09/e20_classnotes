# Weekend Homework

# Option 1 - Fantasy Adventure

Keep working on your Fantasy Adventure

https://github.com/codeclan/e20_classnotes/blob/master/week_07/day_4/fantasy_adventure_lab.md

# Option 2 - Continue something else you're already started

Airports, Restaurants, etc...

# Option 3 - Restart a brief

Take the lessons you've learnt, mistakes you made...and perhaps start a brief from the week again?

# Option 4 - Ray's Music Exchange

You are being asked to model a music shop. This shop will contain items which can be sold. These items might be instruments, which someone may play e.g. guitar, saxophone, piano, etc, or, they might be other items, e.g. guitar strings, drum sticks, sheet music  etc. Think about the shared behaviour and properties of instruments and how you could reflect this in your class heirachy. Each item which can be sold will have both a price at which the shop bought the item, and a price at which the item will be sold. It should be possible to play instruments. The shop should be able to manage stock.


<details>
<summary>Paint by numbers...(click the triangle)</summary>

1. Create a IPlay interface that could be applied to instruments. This should have a play method that returns the sound of the instrument being played as a String.

2. Create classes for different types of instruments e.g. guitars, pianos, etc. (any you can think of). Each class will have its own instance variables for attributes particular to that instrument e.g. a guitar may have a number of strings, a trumpet may have a number of valves etc.

3. Create an Instrument superclass which contains attributes you see as being common to all instruments e.g. material it is made from, colour, type (Brass, String, Woodwind, Keyboard etc). The classes created in step 2 above can then inherit from this Instruments class.

4. Create a ISell interface which has a calculateMarkup method, which returns an int/double, based on the buying price and the selling price. 

5. Create classes for items the shop may sell, i.e. which implement the ISell interface. Such items should have the following:
  - a type/description e.g. guitar, drum sticks, guitar strings, sheet music etc.
  - a price at which the shop bought the item.
  - a price at which the shop plans to sell the item.
  
  Some ISell items will be musical instruments i.e. instruments can be both IPlay and ISell.

6. Create a Shop class, which has a collection of ISell items, called stock. In your shop you should be able to:
  -  add items to stock.
  -  remove items from stock.

</details>

### Possible Extensions

1. Using the calculateMarkup method for each item in stock, create a method which gives the total potential profit for the shop.
2. Create and use an enum for instrument types e.g. keyboard, wind, brass etc
3. Any other extensions you may wish to add.

# Remember for all briefs -
Use TDD, with separate test files for each class. 
