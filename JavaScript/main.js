const prompt = require('prompt-sync')({ sigint: true });
const colors = require('colors');

process.title = 'Guessing Game';

const secretNumber = Math.floor(Math.random() * 100);
let lifes = 10;

while (true) {
    let inputNumber = prompt('Guess the secret number: '.reset);

    if (isNaN(inputNumber)) {
        console.log('Invalid number!'.red);
        continue;
    }

    inputNumber = Number(inputNumber);

    if (!Number.isInteger(inputNumber)) {
        console.log('Invalid number!'.red);
        continue;
    }

    if (inputNumber < secretNumber) {
        console.log('You are smaller than the secret number!'.red);
    } else if (inputNumber > secretNumber) {
        console.log('You are bigger than the secret number!'.red);
    } else {
        console.log('Congratulations! You found the secret number!'.green);
        break;
    }

    lifes--;

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