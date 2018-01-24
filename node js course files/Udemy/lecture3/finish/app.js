var flight = require('./flight');

flight.setOrigin('Kensignton');
flight.setDestination('London');
flight.setNumber(356);

console.log(flight.getInfo());