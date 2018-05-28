# Recap: Record Store & Record Collector

## MVP

What is the benefit of having a Transaction model, over the RecordStore or RecordCollector being responsible for the exchange of a record?

<details>
<summary>Answer</summary>

It helps us to adhere to good Object Oriented design by preventing the buyer or the seller from needing to know about each other. The RecordStore and RecordCollector are responsible for knowing how how they buy and sell records and nothing else. This helps make our application extensible and maintainable.

</details>

What is a helper method?

<details>
<summary>Answer</summary>

A helper method is a method that is called by other methods and assists the method that it is called by implementing a small piece of functionality.

</details>

What is the benefit of having helper methods, such as the Record Collector's `hasFunds` method?

<details>
<summary>Answer</summary>

Having helper methods enables us to keep our code DRY and readable.

DRY - There may be a number of situations that we want to check that the RecordCollector has enough funds. By abstracting the functionality into a helper method, we can reuse the helper method, rather than repeating the same logic multiple times.

Readable - In the following method, `subtractFunds`, having the helper method `hasFunds` makes the `if` statement more readable. This is a reason for having well-named functions.

```js
RecordCollector.prototype.subtractFunds = function (amount) {
  if (!this.hasFunds(amount)) return;
  this.funds -= amount;
};
```
</details>

Make a list of the helper methods in the example solution and compare them to your own helper methods.

<details>
<summary>Answer</summary>

Record Store:

- `addFunds`
- `addRecordToStock`
- `hasRecord`
- `removeRecordFromStock`

Record Collector:

- `hasFunds`
- `subtractFunds`
- `addFunds`
- `hasRecord`
- `addRecordToCollection`
- `removeRecordFromCollection`

Transaction:

- `exchangeIsValid`

</details>

## Extensions

The task was the implement the following functionality:

A record collector should be able to sort its collection by artist name.

### Sorting Numerical Data

When sorting an array of numbers in JavaScript, we can use the `sort` method without passing it any arguments.

```js
const numbers = [1, 4, 2, 5, 3]

const sorted = numbers.sort();
console.log(sorted);
// -> [ 1, 2, 3, 4, 5 ]
```

When we have an array of objects with a numerical property that we want to sort by, we have to be explicit about which property we want it to sort by. To do this, we pass `sort` a callback, which gets passed the object from the previous and next iterations (`a` and `b`) as arguments. We can then compare them.

`sort` is implemented so that if we return less than 0 from the callback, `a` will be placed before `b` in the sorted array. If 0 is returned from the callback (i.e if `a` and `b` are the same), their order will remain unchanged. If we return more the 0, `b` will be placed before `a` in the sorted array. Therefore, we can return the value of `a.age - b.age` to sort the array in ascending order.

```js
const people = [
  { name: 'Eleanore', age: 52 },
  { name: 'Pip', age: 2 },
  { name: 'Dave', age: 32 }
];

const sorted = people.sort((a, b) => {
  return a.age - b.age;
});

console.log(sorted);
```


### Sorting String Data

When sorting strings alphabetically, we can use the [`localeCompare`](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/localeCompare). `localeCompare` is a method on the String prototype. We call it on string 1, pass it string 2 as an argument, and it returns a number indicating whether whether string 1 comes before or after string 2 in the alphabet. This allows us to use it in a callback that we pass to `sort`. So when we are sorting an array of objects on their `artist` property, we can do the following:

```js
RecordCollector.prototype.sortCollection = function () {
  const sortedCollection = this.collection.sort((prev, next) => {
    return prev.artist.localeCompare(next.artist);
  });
  return sortedCollection;
};
```

The callback we pass to `sort` will return the appropriate number for the objects to be sorted by their artist name alphabetically.


### Finding using a search query object

The task was the implement the following functionality:

A record store should be able to find all records which match on multiple attributes.

The brief specifies that the record store should be able to handle a query object (for example, `{ title: 'Thriller', artist: 'Michael Jackson' }`), and it should return all the records that match all the properties of the query object.

We know that we want to return a subset of the original array of records based on a condition, so this tells us that the `filter` enumeration method is appropriate. We also know we want to find records that match on _every_ property of the query object, which indicates the `every` enumeration method might also be useful.

`every` returns true is every element of the array meets a specified condition, and false if not every element meets the condition. If the callback we pass `every` returns true for every iteration, `every` will return true. If the callback ever returns false, `every` will return false.

For each record in the array, we iterate over the query object's keys, and check the the corresponding property of the current record matches. If all the properties match, `every` returns true and the record is added to the new `foundRecords` array by `filter`. If any of the properties don't match, `every` return false, and `filter` does not add the record into the `foundRecords` array.


```js
RecordStore.prototype.findRecord = function (query) {
  const foundRecords = this.stock.filter((record) => {
    return Object.keys(query).every((attribute) => {
      return record[attribute] === query[attribute];
    });
  });
  return foundRecords;
};
```
