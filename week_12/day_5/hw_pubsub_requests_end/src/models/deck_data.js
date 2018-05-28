const Request = require('../helpers/request.js');
const PubSub = require('../helpers/pub_sub.js');

const DeckData = function() {

}

DeckData.prototype.getData = function() {
  this.getDeckId();
};

DeckData.prototype.getDeckId = function() {
  const request = new Request('https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1');
  request.get( (data) => {
    this.getCardData(data.deck_id);
  });
};

DeckData.prototype.getCardData = function(deck_id) {
  const request = new Request(`https://deckofcardsapi.com/api/deck/${deck_id}/draw/?count=52`);
  request.get( (data) => {
    PubSub.publish('DeckData:deck-data-ready', data.cards);
  });
};


module.exports = DeckData;
