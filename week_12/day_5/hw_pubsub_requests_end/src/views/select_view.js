const pubSub = require('../helpers/pub_sub');

const SelectView = function(selectElement) {
  this.selectElement = selectElement;
}

SelectView.prototype.bindEvents = function() {
  pubSub.subscribe('Deck:deck-ready', (evt) => {
    this.populateSelect(evt.detail.length);
  });

  this.selectElement.addEventListener('change', (evt) => {
    const selectedNumber = evt.target.value;
    pubSub.publish('SelectView:-number-of-cards-selected', selectedNumber);
  });
};

SelectView.prototype.populateSelect = function(numberOfCards) {
  for (let i=0; i < numberOfCards; i++) {
    const option = this.createNumberOfCardsOption(i + 1);
    this.selectElement.appendChild(option);
  }
};

SelectView.prototype.createNumberOfCardsOption = function(numberOfCards) {
  const option = document.createElement('option');
  option.textContent = numberOfCards;
  option.value = numberOfCards;
  return option;
};

module.exports = SelectView;
