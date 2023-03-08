import os, random, colorama

os.system("title Guessing Game")

secret_number = random.randint(0, 100)
lifes = 10
lifes_color = colorama.Fore.GREEN

while True:
    input_number = input(colorama.Fore.RESET + "Guess the number between 0 and 100: ")
    
    if not input_number.isdigit():
        print(colorama.Fore.RED + "Invalid number!")
        continue

    input_number = int(input_number)

    if input_number < secret_number:
        print(colorama.Fore.RED + "You are smaller than the secret number!")
    elif input_number > secret_number:
        print(colorama.Fore.RED + "You are bigger than the secret number!")
    else:
        print(colorama.Fore.GREEN + f"Congratulations! You found the secret number!")
        break

    lifes -= 1

    if lifes <= 0:
        print(colorama.Fore.RED + "Game over! You have no more life!")
        break

    if lifes <= 5 and lifes > 3:
        lifes_color = colorama.Fore.YELLOW
    elif lifes <= 3:
        lifes_color = colorama.Fore.RED
    
    print(lifes_color + f"Lifes: {lifes}")

os.system("pause>nul")