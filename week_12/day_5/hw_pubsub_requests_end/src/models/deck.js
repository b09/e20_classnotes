const PubSub = require('../helpers/pub_sub.js');

const Deck = function() {
  this.remainingCards = null;
  this.dealtCards = [];
  this.numberOfCardsToDeal = null;
}

Deck.prototype.bindEvents = function() {
  PubSub.subscribe('SelectView:-number-of-cards-selected', (evt) => {
    this.numberOfCardsToDeal = evt.detail;
    this.dealCards(this.numberOfCardsToDeal);
  });

  PubSub.subscribe('DeckData:deck-data-ready', (evt) => {
    this.remainingCards = evt.detail;
    this.publishCards();
  });
};

Deck.prototype.publishCards = function() {
  PubSub.publish('Deck:deck-ready', this.remainingCards);
};

Deck.prototype.dealCards = function(numberOfCardsToDeal) {
  for (let i = 0; i < numberOfCardsToDeal; i++) {
    this.dealCard();
  }
};

Deck.prototype.dealCard = function() {
  const cardToDeal = this.remainingCards.splice(0, 1)[0];
  this.markCardAsToBeDealt(cardToDeal);
};

Deck.prototype.markCardAsToBeDealt = function(cardToDeal) {
  this.dealtCards.push(cardToDeal);
  this.publishCardsToBeDealt();
};

Deck.prototype.publishCardsToBeDealt = function() {
  if (this.dealtCards.length == this.numberOfCardsToDeal) {
    PubSub.publish('Deck:cards-to-deal-ready', this.dealtCards);
  }
};


module.exports = Deck;