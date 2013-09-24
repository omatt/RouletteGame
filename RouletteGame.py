# This file is an example of Tech Exam from Bruno
# Rules that need to be given to the candidate for the test :
	# The game is of "roulette" kind :
	# Player is given $1000 at the beginning of the game, and he can :
		# REQ-01: Choose the number he/she wants to deal on. As this is a roulette, numbers are given between 0 and 49.
		# REQ-02: Choose the amount he/she wants to deal,
		# REQ-03 : Play with hazard
	# The benefits are calculated with respect to the following algorithm :
		# ALG-01: If player chooses the good number, he wins 3 times his deal,
		# ALG-02: If player chose the good color, he wins 50% of his deal. The color is determined regarding if number is odd or eaven.
		# ALG-03: If not, then player looses his/her deal.
	# The end of the game occurs when :
		# REQ-04 : player doesn't have any money left,
		# REQ-05 : player chooses to leave the roulette.

import os
from random import randrange
from math import ceil
 
# Declare constants :
playerMoney = 1000
playAgain = True # Boolean : TRUE to say "play agin", FALSE otherwise
 
print("Welcome to our new Casino. You will be playing with $", playerMoney, ".")
 
while playAgain: # As long as you can continue to play
    # Ask for the number player wants to deal on
	# REQ-01: Choose the number he/she wants to deal on. As this is a roulette, numbers are given between 0 and 49.
    playerDeal = -1
    while playerDeal < 0 or playerDeal > 49:
        playerDeal = input("Please type in the number you want to deal on (between 0 and 49) : ")
        # Convert text into integer
        try:
            playerDeal = int(playerDeal)
        except ValueError:
            print("Please type in a number")
            playerDeal = -1
            continue
        if playerDeal < 0:
            print("Please type in a positive number")
        if playerDeal > 49:
            print("Please type in a number lower than 49")
 
    # Ask for the amount of money player wants to deal :
	# REQ-02: Choose the amount he/she wants to deal,
    deal = 0
    while deal <= 0 or deal > playerMoney:
        deal = input("Please type in the amount of money you want to deal on : ")
        # Convert text into integer
        try:
            deal = int(deal)
        except ValueError:
            print("Please type in a number")
            deal = -1
            continue
        if deal <= 0:
            print("Please type in a positive number")
        if deal > playerMoney:
            print("You don't have that money left... Your credit is : $", playerMoney)
 
    # Time to play !
	# REQ-03 : Play with hazard
    winNumber = randrange(50)
    print("The roulette has decided ... it stopped on number ", winNumber)
 
    # Now determine what is the benefits of player
    if winNumber == playerDeal: # ALG-01 : If player chooses the good number, he wins 3 times his deal
        print("Congratulations ! You won $", deal * 3, " !")
        playerMoney += deal * 3
    elif winNumber % 2 == playerDeal % 2: # ALG-02 : If player chose the good color, he wins 50% of his deal
        deal = ceil(deal * 0.5)
        print("You chose the good color. Your gain is $", deal)
        playerMoney += deal
    else: # ALG-03 : If not, then player looses his/her deal
        print("Sorry... you lost your deal.")
        playerMoney -= deal
 
    # If player doesn't have money left, then that's the end of the game
	# REQ-04 : player doesn't have any money left,
    if playerMoney <= 0:
        print("You lost all your money ! That's the end of the game...")
        playAgain = False
    else:
        # If not, then continue
        print("Now you have $", playerMoney)
		# Ask if player wants to continue
		# REQ-05 : player chooses to leave the roulette.
        leaveGame = input("Do you want to leave the game (y/n) ? ")
        if leaveGame == "y" or leaveGame == "Y":
            print("Bye ! See you next time !")
            playAgain = False
 
# Pause system (Windows)
os.system("pause")