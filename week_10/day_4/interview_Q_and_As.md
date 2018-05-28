**1. What are the 4 pillars of OOP?**

|Pillar|Definition|
|--|--|
|Abstraction|Is the process of exposing essential features of an entity while hiding other irrelevant detail.|
|Encapsulation|Is the process of wrapping data (properties) and operations on that data (functions) in a class. This leads us to be able to protect data from the outside world.|
|Inheritance|When a class adapts behaviours from a “parent class” or “super class”. The child class inherits from the parent class and may have additional properties and methods.|
|Polymorphism|Many forms. E.G if a Dog inherits from Mammal it is both a Dog AND a Mammal. Overloading methods is another example of polymorphism|

**2. Can you describe the request-response cycle?**

- User clicks a link, submits a form etc
- Browser sends HTTP request to server with headers describing the request and a body if the client is supplying some data to the server (e.g. form fields)
- Server parses request and provides a response with a status code (e.g. 200 - OK, 404 - not found). 
- If the a valid resource was requested it is returned in the body of the response.

**3. How would you protect your website from an SQL injection attack?**

We could use prepared statements that ensure the user cannot cause the execution of arbritary queries. 

**4. If your database was running slowly, what could you do to speed it up**

Locate the queries that are running slowly. Add indexes. Remove `SELECT *` if not all fields are required. 

**5. What are user journeys and what other UX methods would you use in a small project?**

A user journey describes a set of steps / interactions a user might undertake when using your system. We use them to better understand our users and the ways in which they will interact or expect to interact with the system.


**6. Describe a real example of refactoring and changing Designs mid project**

**7. What is MVC pattern?**

**Model-View-Controller** is a pattern used to separate an application’s concerns.  
**Model:**  represents knowledge. Could be a single object or structure of objects. Can contain logic for updating the controller if data changes.  
**View:** is the visualization of it’s model.  
**Controller:** is the link between a user and the system and acts on both model and view. Controls the data flow into model object and updates the view whenever data changes.

**8. Two classes share some things, how will you decide whether to use a Parent class (Inheritance) or a common interface (Polymorphism)**

Decide whether the shared things are behaviour or the essential nature of the thing. For example a Broomstick and a Dragon are both things a wizard could fly, but the similarites end there. A Broomstick cannot breath fire. And so Inheritance - a shared Superclass could enforce unncessary behaviour on classes. However in this situation an Interface would be perfect. 

If however the two things are more closely related - a Witch a Wizard for example then Inheritance may fit. We could have a Magician (abstract?) superclass capturing the shared behavior and properties that the child classes can use or override as needed.

**9. What has been your favourite part of the CodeClan course and what kind of job role are you most interested in?**

**10. What’s the difference between a class and an object?**

- An object models a real world (physical or abstract) thing by having a state in which its properties have values that are defined and methods that define its behaviour.
- An object is an instance of a class and every object has a class. 
- The class is a kind of ‘blueprint’ for the object. It is used to describe how an object should be made.	
- Objects have a lifespan (they are created and destroyed) and classes do not.

**11. What is the difference between an Array and an ArrayList?**

||Array|ArrayList|
|-|---|---|
|**Scalability**|Static in size|Resizable|
|**Performance**||Resizing of ArrayList will slow down performance as it will use temporary array to copy elements from old array to new one.|
|**Data Types**|Can contain primitives and objects|Cannot contain primitives|
|**Iterators**|For loop|Iterator and for loop|
|**Length**|length|size()|
|**Adding**|Assignment operator|add()
|**Methods**|Limited set of methods|More compreheshive set of methods|


1**2. What is the difference between overriding and overloading in OOP**


|Overloading|Overriding|
|-|-|
|Overloading is when multiple methods have the same name but differing number/type of arguments. Overloading happens within the same class.|Overriding happens in a child class where a method inherited from a parent is given a different implementation.|


**13. What is the difference between an array and a linked list?**


|array|linked list|
|-|-|
|An array is a collection of items which are arranged adjacently in memory|A linked list is a sequence of elements arranged arbitrarily in memory, but where each element (node) has a pointer to its successor|
