const PubSub = require('../helpers/pub_sub.js');
const CardView = require('./card_view.js');

const HandView = function(container) {
  this.container = container;
}

HandView.prototype.bindEvents = function () {
  PubSub.subscribe('Deck:cards-to-deal-ready', (evt) => {
    this.renderCards(evt.detail);
    this.activateClearCardsButton();
  });
};

HandView.prototype.renderCards = function(cards) {
  this.container.innerHTML = '';
  cards.forEach((card) => {
    const cardToDisplay = this.createCardView(card);
    this.container.appendChild(cardToDisplay);
  });
};

HandView.prototype.createCardView = function(cardDetails) {
  const cardView = new CardView(cardDetails);
  return cardView.displayCard();
};

HandView.prototype.activateClearCardsButton = function() {
  const clearCardsButton = document.querySelector('button#clear-cards');
  clearCardsButton.addEventListener('click', (evt) => {
    this.container.innerHTML = '';
  });
};

module.exports = HandView;
