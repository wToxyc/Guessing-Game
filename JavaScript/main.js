const prompt = require('prompt-sync')({ sigint: true });
const colors = require('colors');

process.title = 'Guessing Game';

/*
Generating a random integer between 0 and 100
Notice:
  Math.floor() returns the rounded number entered
  Math.random() returns a float between 0 and 1
For example:
  Math.random() will return 0.28974250666343415
  Math.floor(Math.random() * 100) will return 2 numbers of Math.random() after decimal point
  So, for Math.random() = 0.28974250666343415, Math.floor(Math.random() * 100) will return 28
WARNING:
  If you don't multiply Math.random(), Math.floor(Math.random()) will return 0.0 or 1.0
*/
const secretNumber = Math.floor(Math.random() * 100);
let lifes = 10;

while (true) {
    // Asking the user for the secret number
    let inputNumber = prompt('Guess the secret number: '.reset);

    // Returning an error if the user's input isn't a number
    if (isNaN(inputNumber)) {
        console.log('Invalid number!'.red);
        continue;
    }

    // Converting the user's input (string) to a number
    inputNumber = Number(inputNumber);

    // Returning an error if the number input isn't a number
    if (!Number.isInteger(inputNumber)) {
        console.log('Invalid number!'.red);
        continue;
    }

    // Comparing the input number with the secret number
    if (inputNumber < secretNumber) {
        console.log('You are smaller than the secret number!'.red);
    } else if (inputNumber > secretNumber) {
        console.log('You are bigger than the secret number!'.red);
    } else {
        console.log('Congratulations! You found the secret number!'.green);
        break;
    }

    // Decrementing lifes for each iteration
    lifes--;

    // Coloring the text depending of lifes
    if (lifes > 5) {
        console.log(`Lifes: ${lifes}`.green);
    } else if (lifes <= 5 && lifes > 3) {
        console.log(`Lifes: ${lifes}`.yellow);
    } else if (lifes <= 3 && lifes > 0) {
        console.log(`Lifes: ${lifes}`.red);
    } else {
        console.log(`Game over! No more life!`.red);
        break;
    }
}