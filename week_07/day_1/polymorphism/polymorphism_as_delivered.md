# Polymorphism to the rescue

### Learning Objectives

- Understand the power of polymorphism
- Use polymorphic methods and collections

# Intro

So we saw a solution to add both Computers and Printers to our network. However, we weren't very happy with it since it wasn't very DRY and or scaleable.

We can solve all of our problems with "polymorphism". This isn't as scary as it sounds, it just means we can wrap our objects up in an enclosing type that defines a contract between them all.

## What is polymorphism?

The term polymorphism comes from two Greek words: 'poly' meaning 'many' and "morph" meaning 'change'. When we talk of something being 'polymorphic' we mean that it can have 'many forms'. 

I know... let's look at classic example - Shapes. We can have many **forms** of `Shape` -

	Square
	Circle
	Tringle

We can also think about a Square as having two **forms** - `Square` and `Shape`.

> Draw diagram on board with different 'roles' or 'forms'

We can do the same thing in programming. We can treat an instance of a class as if it is also another class/type at the same time. And this is what we will expolit to simplify our code and make it more extensible.

## How to implement polymorphism in Java

Polymorphism can be implemented using both abstract classes and interfaces. Remember that all classes which inherit from a class can take the type of the superclass. To use an abstract class we create a superclass which all the classes we want to treat as being the same can inherit from. But, inheritance is fraught with problems and we can quickly get into a mess. We can also just have one superclass.

Interfaces also allow us to treat a class as being of another type.  When a class implements an interface it gains the type of the interface without having a horrible inheritance chain. We can have as many interfaces as we like, too. Rather than just one super class.

## Modify our example to be polymorphic

What we want to do in our `Network` class is to be able to just create a single ArrayList for `devices` and be able to add different things e.g. Computers and Printers to the ArrayList, but to do this they need to be of the same Computers. This is where polymorphism comes in. We need to be able to treat anything we add to the ArrayList as being of the one type. We can do this using an interface. We can create an interface which both `Computer` and `Printer` inherit, and then have a single ArrayList where the type is the interface that we implement. 

Let's have an interface, `INetworkable` that both of our types implement. Both a `Computer` and a `Printer` are networkable. Once we have created our interface and made our classes implement it, we can than create an ArrayList of `INetworkable` which means that it can contain both `Computer` and `Printer` objects.

> Give out starter code.

Lets create a new interface called `INetworkable` in the main package. This interface will have one method `getStatus` which will return a String. We've decided that any device that connects to our network should be able to return us a status - perhaps so some can query all devices to determine what issues need resolving.

```
#IntelliJ

Create a new interface in the main package called INetworkable. 
```

```java
//INetworkable.java
public interface INetworkable {
  public String getStatus();
}
```

> TASK: get the `Computer` and `Printer` classes to implement this interface. Remember to write tests.

```java
//ComputerTest.java

  @Test
  public void canGetStatus(){
    assertEquals("Hard Drive Broken", computer.getStatus());
  }
```

```java
//Computer.java
public class Computer implements INetworkable {

    public String getStatus() {
      return "Hard Drive Broken";
    }
}

```


```java
//PrinterTest.java

    @Test
    public void canGetStatus(){
        assertEquals("Ink Low", printer.getStatus());
    }
```

```java
//Printer.java

  public class Printer implements INetworkable{

      //AS BEFORE

      public String getStatus(String data) {
        return "Ink Low";
      }
  }

  
```


Great. Now, in Ruby this didn't really mean much since we could pass anything to any method, and put anything we wanted into Arrays. In Java, this concept is extremely important. Our `Computer ` is both a `Computer` AND an `INetworkable`. Our `Printer` is both a `Printer` AND an `INetworkable`.

What does this mean for us though? Let's revist our networks device list.

## Polymorphic collections

We can now delete some of our stinky code!

First lets replace our separate collections with a more generic one `devices`-

```java
//Network.java

public class Network {
    private String name;
    private ArrayList<INetworkable> devices; // REPLACED SEPARATE COLLECTIONS

    public Network(String name){
        this.devices = new ArrayList<>(); // REPLACES SEPARATE COLLECTIONS
        this.name = name;
    }
```

Now let's change the methods that handle these collections -


```java
//Network.java

    public int deviceCount(){
        return devices.size(); // CHANGED 
    }

    public void connect(INetworkable device){ // REPLACES SEPARATE METHODS 
        devices.add(device);
    }

    public void disconnectAll(){
        devices.clear(); // CHANGED
    }
}
```
And our tests all still pass - as a `Computer` and a `Printer` can both take on multiple forms - their own class or the interface they implement - `INetworkable`

## Magic

The beauty of "polymorphism" is that any type can behave as if it is any of it's super class types as well as it own. Our Computer can be both a Computer and an INetworkable, like we mentioned earlier. So anything accepting INetworkable can accept a Computer.

However, it does NOT apply the other way round. Anything accepting a Computer does NOT accept an INetworkable. Not every INetworkable is a Computer! But every Computer is an INetworkable.


