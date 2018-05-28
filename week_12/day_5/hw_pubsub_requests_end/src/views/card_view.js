const CardView = function(cardDetails) {
  this.details = cardDetails;
}

CardView.prototype.displayCard = function() {
  const cardImage = document.createElement('img');
  cardImage.src = this.details.image;
  return cardImage;
};

module.exports = CardView;

