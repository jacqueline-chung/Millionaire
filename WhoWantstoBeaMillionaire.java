/* [WhoWantstoBeaMillionaire]
 * This program that prompts the user for the answers to 15 questions, with 3 for each level in randomized order. It is the user's objective to get ALL the questions correct to win ONE [fake] MILLION DOLLARS.
 * All the questions are formatted in multiple choice (a, b, c, or d). The level of difficulty increases after each question and an increase in winning earnings.
 * If the user misses a question, it is the game is over. There are three 'lifelines' (50/50, Poll the Audience, Ask An Expert) at the user's disposal, but each can only be used once during the course of the game. 
 * The User can quit whenever they want, and walk away with their previous winnings by entering 'q'. At the end, if they win the million dollars, they have the option to play again (y - yes or n - no)
 * Author: Jacqueline Chung
 * Dates: October 3-16, 2014
 */

import java.util.Scanner; //initating Scanner to allow the user to give input
class WhoWantstoBeaMillionaire { 
  
  public static void main(String args[]) {  //main method
    
    Scanner userInput = new Scanner(System.in); 
    
    String name, answer1, playAgain; //declare String variables 
    int prize = 0, lifeline1 = 1, lifeline2 = 1, lifeline3 = 1, random, poll1, poll2, poll3, winpoll, max; //declare interger variables to store the prize money, random number, lifeline counters
    
    
    
    do { //do while the user doesn't enter 'q' or 'n'
      
      System.out.print ("\nWelcome to WHO WANTS TO BE A MILLIONIARE! Enter your name: "); //prompt the user for their name and store into variable name
      name = userInput.nextLine();
      
      //output the rules for the game to the user
      System.out.println (name + ", here are rules for the game:\n");       
      System.out.println ("You will have to answer 15 questions to receive ONE MILLION DOLLARS!! Each question is presented in multiple choice format: a), b), c), and d). The level of difficulty increases as you progress through the game, with an increase of your winnings also! Miss a question and it is the game is over. HOWEVER there are three 'lifelines' at your disposal, and can only be used once during the course of the game.\n");
      //list lifelines
      System.out.println ("The lifelines are:");      
      System.out.println ("1) 50/50 will randomly remove two incorrect answers, leaving the correct answer and one incorrect answer.");
      System.out.println ("2) Poll the Audience taps into the minds of the audience and tallies what they think the answer to the question(s). Beware! They might answer incorrectly!");
      System.out.println ("3) Ask an Expert taps into the mind of a staff professor at Eastern University to see what they think about the question.\n");      
      System.out.println ("You can quit ('q') the game at any time and take your current winnings home with you."); //the user can quit on any question 
      
      do {
        random = (int) (Math.random() * 3 + 1); //random number between 1, 2, 3
      } while (random > 3 || random < 1);
      
      //LEVEL 1    
      if (random == 1) { //if the random number is 1        
        //LEVEL 1 - Option 1
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3          
          System.out.println ("1. Na is the chemical symbol for which element?\n" + "a) Nitrogen\n" + "b) Sodium\n" + "c) Sulfur\n" + "d) Neptunium\n"); //prompt the user for the answer and b is correct answer         
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //print lifeline options          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable           
            } else if (answer1.equals ("a") || answer1.equals ("c") || answer1.equals ("d") || answer1.equals ("q")) { //if answer is wrong or the the user quits
              System.out.println ("That is incorrect! You earned nothing!! Better luck next time."); //output the amount they earn
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0);   //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines)
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable 
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\na) Nitrogen\n" + "b) Sodium\n"); 
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Nitrogen " + poll1 + "%\n" + "b) Sodium " + winpoll + "%\n" + "c) Sulfur " + poll2 + "%\n" + "d) Neptunium " + poll3 + "%\n");
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n" +  "�Natrium, the Latin name for sodium carbonate.�\n"); //output scientific quote
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                      
          } while (!answer1.equals ("b"));                 
          System.out.println ("YAY! Sodium is the correct answer! Good job! You won $100!\n"); //output a winning message 
          prize = 100; //set the earnings         
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
        
      } else if (random == 2) { //if the random number is 2
        
        //LEVEL 1 - OPTION 2
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n1. In terms of electricity, what does DC stand for (that flows in one direction)?\n" + "a) Direct Current\n" + "b) District of Columbia\n" + "c) Delta Connection\n" + "d) Dielectric Current\n"); //prompt the user for the answer         
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //output the lifelines for the user          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable              
            } else if (answer1.equals ("b") || answer1.equals ("c") || answer1.equals ("d") || answer1.equals ("q")) { //if user quits game or answers inccorectly
              System.out.println ("That is incorrect! You earned nothing! Better luck next time."); //output the amount they won
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0); //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable 
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\na) Direct Current\n" + "b) District of Columbia\n");  
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) {//if user chooses Poll the Audience to poll the audience's answers
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Direct Current " + winpoll + "%\n" + "b) District of Columbia " + poll1 + "%\n" + "c) Delta Connection " + poll2 + "%\n" + "d) Dielectric Current " + poll3 + "%\n");
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n" + "�I believe in terms of electricity, DC stands for Direct Current. It is commonly found in batteries and chargers.�\n"); 
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                      
          } while (!answer1.equals ("a"));               
          System.out.println ("YAY! Direct Current is the correct answer! Good job! You won $100!\n"); //output a winning message 
          prize = 100; //set the earnings         
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
        
      } else if (random == 3) { //if the random number is 3
        
        //LEVEL 1 - OPTION 3
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n1. What�s Earth primary source of energy?\n" + "a) Salt\n" + "b) Water\n" + "c) Sun\n" + "d) Light\n");     //prompt the user for the answer      
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //output the lifelines for the user          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("a") || answer1.equals ("b") || answer1.equals ("d") || answer1.equals ("q")){//if user quits game or answers inccorectly
              System.out.println ("That is incorrect! You earned nothing! Better luck next time."); //output the amount they won
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0); //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable 
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\na) Salt\n" + "c) Sun\n"); //sun is correct answer 
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) {//if user chooses Poll the Audience to poll the audience's answers
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Salt " + poll1 + "%\n" + "b) Water " + poll2 + "%\n" + "c) Sun " + winpoll + "%\n" + "d) Light " + poll3 + "%\n");
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states: \n" + "�The Sun emits light and heat onto the Earth.�\n"); 
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                        
          } while (!answer1.equals ("c"));            
          System.out.println ("YAY! The Sun is the correct answer! Good job! You won $100!\n"); //output that the user won and the amount they won
          prize = 100; //set the earnings to $100             
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));        
      }
      
      //LEVEL 2             
      random = (int) (Math.random() * 3 + 1); //random number between 1, 2, 3      
      if (random == 1) { //if the random number is 1  
        
        //LEVEL 2 $200 - Option 1
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n2. In terms of computing, what does CPU stand for?\n" + "a) Compiling Procedure Union\n" + "b) Central Pervasive Union\n" + "c) Computer Processing Unit\n" + "d) Central Processing Unit\n"); //d is correct answer   and prompt the user for the answer        
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //print lifeline options          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("a") || answer1.equals ("b") || answer1.equals ("c")|| answer1.equals ("q")) { //if user quits game or answers inccorectly
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they earn
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0);   //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable 
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\nc) Computer Processing Unit\n" + "d) Central Processing Unit\n"); //correct answer  is d
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers 
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Compiling Procedure Union " + poll1 + "%\n" + "b) Central Pervasive Union " + poll2 + "%\n" + "c) Computer Processing Unit " + poll3 + "%\n" + "d) Central Processing Unit " + winpoll + "%\n");
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n" + "�CPU stands for central processing unit and is the main core of a computer where every command runs through and is routed to its appropriate location.�\n"); //output scientific quote
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                      
          } while (!answer1.equals ("d"));  
          System.out.println ("YAY! Central Processing Unit is the correct answer! Good job! You won $200!\n"); //output a winning message 
          prize = 200; //set the earnings         
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
        
      } else if (random == 2) { //if the random number is 2
        
        //LEVEL 2 - OPTION 2
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n2. Earth is located in which galaxy?\n" + "a) Milky Way\n" + "b) Solar System\n" + "c) Omega Centauri\n" + "d) Virgo Stellar Stream\n"); //a is correct answer and prompt the user for the answer
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //output the lifelines for the user   
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable   
            } else if (answer1.equals ("b") || answer1.equals ("c") || answer1.equals ("d") || answer1.equals ("q")) { //if user quits game or answers inccorectly
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they won
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0); //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable 
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\na) Milky Way\n" + "c) Omega Centauri\n"); 
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) {//if user chooses Poll the Audience to poll the audience's answers
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Milky Way " + winpoll + "%\n" + "b) Solar System " + poll1 + "%\n" + "c) Omega Centauri " + poll2 + "%\n" + "d) Virgo Stellar Stream " + poll3 + "%\n");
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n" + "�Earth is located in one of the spiral arms of the Milky Way (called the Orion Arm) which lies about two-thirds of the way out from the center of the Galaxy.�\n"); 
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                      
          } while (!answer1.equals ("a"));        
          
          System.out.println ("YAY! Milky Way is the correct answer! Good job! You won $200!\n"); //output that the user won and the amount they won
          prize = 200; //set to winning earnings
          
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") &&  !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
        
      } else if (random == 3) { //if the random number is 3
        
        //LEVEL 2 - OPTION 3
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n2. How many pairs of wings does a bee have?\n" + "a) 4\n" + "b) 1\n" + "c) 2\n" + "d) 3\n");   //prompt the user for the answer and c is correct answer        
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //output the lifelines for the user          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("a") || answer1.equals ("b") || answer1.equals ("d") || answer1.equals ("q")) { //if user quits game or answers inccorectly
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they earned
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0); //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable 
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\nb) 1\n" + "c) 2\n"); 
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) {//if user chooses to poll the audience's answers
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) 4 " + poll1 + "%\n" + "b) 1 " + poll2 + "%\n" + "c) 2 " + winpoll + "%\n" + "d) 3 " + poll3 + "%\n");
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n" + "�Most other insects have two pairs of wings. This is called warning coloration, because predators avoid them, thinking they can sting. However, flies do not have a stinger.�\n"); 
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                        
          } while (!answer1.equals ("c"));            
          System.out.println ("YAY! 2 is the correct answer! Good job! You won $200!\n"); //output that the user won and the amount they won
          prize = 200; //set the amount of earnings         
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));        
      }
      
      //LEVEL 3     
      if (random == 1) { //if the random number is 1
        
        //LEVEL 3 $300 - Option 1
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n3. What are female elephants called?\n" + "a) Elephants\n" + "b) Cows\n" + "c) Bulls\n" + "d) Calves\n");  //b is correct answer         
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //print lifeline options          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("a") || answer1.equals ("c") || answer1.equals ("d") || answer1.equals ("q")) {//if user quits game or answers inccorectly
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they earn
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0);   //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable 
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\nb) Cows\n" + "c) Bulls\n"); 
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers 
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Elephants " + poll1 + "%\n" + "b) Cows " + winpoll + "%\n" + "c) Bulls " + poll2 + "%\n" + "d) Calves " + poll3 + "%\n");
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n" + "�Elephants are the largest land animals. Elephants are very social animals and live in family groups referred to as 'herds.' Female elephants are also called cows and males are called bulls.�\n"); //output scientific quote
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                      
          } while (!answer1.equals ("b"));             
          System.out.println ("YAY! Cows is the correct answer! Good job! You won $300!\n"); //output a winning message 
          prize = 300; //set the earnings          
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
        
      } else if (random == 2) { //if the random number is 2
        
        //LEVEL 3 - OPTION 2
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n3. What orbits the nucleus of an atom?\n" + "a) Shells\n" + "b) Protons\n" + "c) Electrons\n" + "d) Protons and Neutrons\n"); //c is correct answer        
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //output the lifelines for the user          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("b") || answer1.equals ("a") || answer1.equals ("d") || answer1.equals ("q")) { //if user quits game or answers inccorectly
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they won
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0); //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable 
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\nc) Electrons\n" + "d) Protons and Neutrons\n"); 
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) {//if user chooses Poll the Audience to poll the audience's answers
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Shells " + poll1 + "%\n" + "b) Protons " + poll2 + "%\n" + "c) Electrons " + winpoll + "%\n" + "d) Protons and Neutrons " + poll3 + "%\n"); //c is correct answer
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n" + "�While the nucleus in the atom contains protons and neutrons, very light electrons orbit around the nucleus using an electromagnetic force.�\n"); 
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                      
          } while (!answer1.equals ("c"));                
          System.out.println ("YAY! Electrons is the correct answer! Good job! You won $300!\n"); //output that the user won and the amount they won
          prize = 300; //set to winning earnings          
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
        
      } else if (random == 3) { //if the random number is 3
        
        //LEVEL 3 - OPTION 3
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n3. What is the name of the process used by plants to convert sunlight into food?\n" + "a) Photosynthesis\n" + "b) Chlorophyll\n" + "c) Glucose\n" + "d) Cellular Respiration\n");      //prompt the user for the answer and a is correct answer     
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //output the lifelines for the user          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("c") || answer1.equals ("b") || answer1.equals ("d") || answer1.equals ("q")) { //if user quits game or answers inccorectly
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they won
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0); //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable 
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\na) Photosynthesis\n" + "d) Cellular Respiration\n"); 
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) {//if user chooses Poll the Audience to poll the audience's answers
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Photosynthesis " + winpoll + "%\n" + "b) Chlorophyll " + poll1 + "%\n" + "c) Glucose  " + poll2 + "%\n" + "d) Cellular Respiration " + poll3 + "% \n");
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n" + "�The process begins when sunlight is absorbed by specific proteins containing chlorophyll. The food itself comes from carbon dioxide, but the sunlight provides the energy needed to create certain necessary chemical reactions. The carbon dioxide is broken down into a type of sugar and oxygen is emitted as a waste product.�\n"); 
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                        
          } while (!answer1.equals ("a"));           
          System.out.println ("YAY! Photosynthesis is the correct answer! Good job! You won $300!\n"); //output that the user won and the amount they won
          prize = 300; //set the amount of earnings         
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));        
      }
      
      if (random == 1) { //if the random number is 1
        
        //LEVEL 4 $500 - Option 1
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n4. Can frogs live in salt water?\n" + "a) Yes\n" + "b) Only in June to September\n" + "c) No\n" + "d) Only when they are hibernating\n"); //prompt the user for the answer and a correct answer       
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //print lifeline options          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("b") || answer1.equals ("c") || answer1.equals ("d") || answer1.equals ("q")) {//if user quits game or answers inccorectly
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they earn
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0);  //break out of loop 
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable 
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\na) Yes\n" + "c) No\n"); 
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers 
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Yes " + winpoll + "%\n" + "b) Only in June to September " + poll1 + "%\n" + "c) No " + poll2 + "%\n" + "d) Only when they are hibernating " + poll3 + "%\n");
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n" + "�Crab-eating frogs have special skin which stops them from drying out in salt water and allows them to survive in these environments. They are also able to absorb urea from their bladder too (humans can't do this) which helps them to not dry out too.�\n"); //output scientific quote
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                      
          } while (!answer1.equals ("a"));           
          System.out.println ("YAY! Yes is the correct answer! Good job! You won $500!\n"); //output a winning message 
          prize = 500; //set the earnings        
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
        
      } else if (random == 2) { //if the random number is 2
        
        //LEVEL 4 - OPTION 2
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n4. _________ is an example of a conductor.\n" + "a) Silver\n" + "b) Wool\n" + "c) Glass\n" + "d) Pure Water\n"); //prompt the user for the answer and a is correct answer
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //output the lifelines for the user          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("b") || answer1.equals ("c") || answer1.equals ("d") || answer1.equals ("q")) { //if the answer is wrong or user quits game
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they won
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0); //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable 
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\na) Silver\n" + "d) Pure Water\n"); 
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Silver " + winpoll + "%\n" + "b) Wool " + poll1 + "%\n" + "c) Glass " + poll2 + "%\n" + "d) Pure water " + poll3 +"%\n");
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n" + "�A heavy, silvery d-block element, mercury is the only metallic element that is liquid at standard conditions for temperature and pressure; the only other element that is liquid under these conditions is bromine, though metals such as caesium, gallium, and rubidium melt just above room temperature.�\n"); 
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                      
          } while (!answer1.equals ("a"));              
          System.out.println ("YAY! Silver is the correct answer! Good job! You won $500!\n"); //output that the user won and the amount they won
          prize = 500; //set to winning earnings          
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
        
      } else if (random == 3) { //if the random number is 3
        
        //LEVEL 4 - OPTION 3
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n4. What is the third planet from the Sun?\n" + "a) Mars\n" + "b) Earth\n" + "c) Venus\n" + "d) Mercury\n");////prompt the user for the answer and b is corrcet answer
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //output the lifelines for the user          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("a") || answer1.equals ("c") || answer1.equals ("q") || answer1.equals ("d")) { //if the answer is wrong or user quits game
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they won
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0); //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable 
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\na) Mars\n" + "b) Earth\n"); 
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) {//if user chooses Poll the Audience to poll the audience's answers
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Mars " + poll1 + "%\n" + "b) Earth " + winpoll + "%\n" + "c) Venus " + poll2 + "%\n" + "d) Mercury " + poll3 + "%\n"); //b is correct answer
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n" + "�Earth, also known as the world, Terra, or Gaia, is the third planet from the Sun, the densest planet in the Solar System, the largest of the Solar System's four terrestrial planets, and the only celestial body known to accommodate life.�\n"); 
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                        
          } while (!answer1.equals ("b"));             
          System.out.println ("YAY! The Earth is the correct answer! Good job! You won $500!\n"); //output that the user won and the amount they won
          prize = 500; //set the amount of earnings         
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d")&& !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
      }
      
      if (random == 1) { //if the random number is 1
        
        //LEVEL 5 $1,000 - OPTION 1
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n5. The mass of the earth is made up mostly of which two elements?\n" + "a) Carbon and Hydroge\n" + "b) Oxygen and Hydrogen\n"+ "c) Carbon Dioxide and Oxygen\n" + "d) Iron and Oxygen\n");  //prompt the user for the answer and correct answer          
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //print lifeline options          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("b") || answer1.equals ("c") || answer1.equals ("a") || answer1.equals ("q")) { //if the user's input is wrong  or user quits game
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they earn
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0);   //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable 
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\na) Carbon and Hydrogen\n" + "d) Iron ad Oxygen\n"); 
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers 
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Carbon and Hydrogen " + poll1 + "%\n" + "b) Oxygen and Hydrogen " +poll2 + "%\n" + "c) Carbon Dioxide and Oxygen " + poll3 + "%\n" + "d) Iron and Oxygen " + winpoll + "%\n"); //correct answer is d
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n" + "�The vast majority of the Earth's supply of iron is found in the core and the mantle. The solid inner core is almost entirely composed of iron, while the liquid outer core is an alloy of iron and nickel, with small amounts of lighter elements.\n" + "Oxygen, the second most abundant element on Earth, is found mainly in the crust. Although oxygen is most often thought of as an atmospheric gas, it is also one of the primary components of the silicate minerals that make up the vast majority of the Earth's crust.�\n"); //output scientific quote
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                      
          } while (!answer1.equals ("d"));            
          System.out.println ("YAY! Iron and Oxygen is the correct answer! Good job! You won $1,000!\n"); //output a winning message 
          prize = 1000; //set the earnings         
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
        
      } else if (random == 2) { //if the random number is 2
        
        //LEVEL 5 - OPTION 2 $1,000
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n5. The most recognized model of how the universe began is __________.\n" +"a) Adam and Eve\n"+"b) Big Bang Theory\n"+"c) String Theory\n"+"d) There is more than one model\n");    //prompt the user for the answer and b is correct answer        
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //output the lifelines for the user          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("a") || answer1.equals ("c") || answer1.equals ("d") || answer1.equals ("q")) { //if user quits game or answers inccorectly
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they won
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0); //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable 
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\nb) Big Bang Theory\n" + "d) There is more than one model\n"); 
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Adam and Eve " + poll1 + "%\n"+"b) Big Bang Theory " + winpoll + "%\n"+"c) String Theory " + poll2 + "%\n"+"d) There is more than one model " + poll3 + "%\n");
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n"+"�The key idea is that the universe is expanding. Consequently, the universe was denser and hotter in the past. Moreover, the model suggests that at some moment all matter in the universe was contained in a single point, which is considered the beginning of the universe.�\n"); 
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                      
          } while (!answer1.equals ("b"));             
          System.out.println ("YAY! The Big Bang Theory is the correct answer! Good job! You won $1,000!\n"); //output that the user won and the amount they won
          prize = 1000; //set to winning earnings         
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));        
        
      } else if (random == 3) { //if the random number is 3
        
        //LEVEL 5 - OPTION 3
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n5. At room temperature, what is the only metal that is in liquid form?\n"+"a) Boron\n"+"b) Mercury\n"+"c) Rubidium\n"+"d) Potassium\n");         //prompt the user for the answer 
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //output the lifelines for the user          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("a") || answer1.equals ("c") || answer1.equals ("d") || answer1.equals ("q")) { //if user quits game or answers inccorectly
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they won
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0); //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable 
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\nb) Mercury\n"+"c) Rubidium\n"); 
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Boron " + poll1 + "%\n"+"b) Mercury " + winpoll + "%\n"+"c) Rubidium " + poll2 +"%\n"+"d) Potassium " +poll3+"%\n");
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n"+"�A heavy, silvery d-block element, mercury is the only metallic element that is liquid at standard conditions for temperature and pressure; the only other element that is liquid under these conditions is bromine, though metals such as caesium, gallium, and rubidium melt just above room temperature.�\n"); 
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                        
          } while (!answer1.equals ("b"));            
          System.out.println ("YAY! Mercury is the correct answer! Good job! You won $1,000!\n"); //output that the user won and the amount they won
          prize = 1000; //set the amount of earnings         
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
      }
      
      if (random == 1) { //if the random number is 1
        
        //LEVEL 6 $2,000 - OPTION 1
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n6. What is the temperature of absolute zero?\n"+"a) -20 degrees Celsius\n"+"b) 0 Kelvin\n"+"c) 100 Kelvins\n"+"d) 0 degrees Fahrenheit\n");           //prompt the user for the answer and correct answer  is b
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //print lifeline options          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("d") || answer1.equals ("c") || answer1.equals ("a") || answer1.equals ("q")) {//if user quits game or answers inccorectly
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they earn
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0);   //break out of loop   
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable 
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\nb) 0 Kelvin\n" +"d) 0 degrees Fahrenheit\n"); 
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers 
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) -20 degrees Celsius " + poll1 + "%\n"+"b) 0 Kelvin " + winpoll+"%\n"+"c) 100 Kelvins " + poll2 +"%\n"+"d) 0 degrees Fahrenheit " + poll3 +"%\n"); 
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n"+"�Absolute zero is the lowest possible temperature where nothing could be colder and no heat energy remains in a substance.\n"+"Absolute zero is the point at which the fundamental particles of nature have minimal vibrational motion, retaining only quantum mechanical, zero-point energy-induced particle motion.�\n"); //output scientific quote
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                      
          } while (!answer1.equals ("b"));           
          System.out.println ("YAY! 0 Kelvin is the correct answer! Good job! You won $2,000!\n"); //output a winning message 
          prize = 2000; //set the earnings         
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
        
      } else if (random == 2) { //if the random number is 2
        
        //LEVEL 6 - OPTION 2 $2,000
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n6. What do you call molten rock before it has erupted\n"+"a) Lava\n"+"b) Sentiment\n"+"c) Magma\n"+"d) Metaphoric rock\n");         //prompt the user for the answer and c is correct answer
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //output the lifelines for the user          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("a") || answer1.equals ("b") || answer1.equals ("d") || answer1.equals ("q")) { //if the answer is wrong  or user quits game
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they won
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0); //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable 
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\nc) Magma\n"+"d) Metaphoric rock\n"); 
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Lava "+ poll1 +"%\n"+"b) Sentiment " + poll2 +"%\n"+"c) Magma "+winpoll+"%\n"+"d) Metaphoric rock "+poll3+"%\n");
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n"+"�Lava is the molten rock expelled by a volcano during an eruption and the resulting rock after solidification and cooling. Besides molten rock, magma may also contain suspended crystals, dissolved gas and sometimes gas bubbles. Magma often collects in magma chambers that may feed a volcano or turn into a pluton. Magma is capable of intrusion into adjacent rocks (forming igneous dikes and sills), extrusion onto the surface as lava, and explosive ejection as tephra to formpyroclastic rock.�\n"); 
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                      
          } while (!answer1.equals ("c"));           
          System.out.println ("YAY! Magma is the correct answer! Good job! You won $2,000!\n"); //output that the user won and the amount they won
          prize = 2000; //set to winning earnings          
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
        
      } else if (random == 3) { //if the random number is 3
        
        //LEVEL 6 - OPTION 3
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n6. Dinosaur means __________.\n"+"a) �terrible lizard�\n"+"b) �giant beast�\n"+"c) �vicious monster�\n"+"d) �giant reptile�\n");          //prompt the user for the answer and a is correct answer
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //output the lifelines for the user          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("b") || answer1.equals ("c") || answer1.equals ("d") || answer1.equals ("q")) { //if the answer is wrong or user quits game
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they won
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0); //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable 
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\na) �terrible lizard�\n"+ "d) �giant reptile�\n"); 
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) �terrible lizard� "+winpoll+"%\n"+"b) �giant beast� "+poll1+"%\n"+"c) �vicious monster� "+poll2+"%\n"+"d) �giant reptile� "+poll3+"%\n");
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n"+"�The word dinosaur comes from the ancient Greek words deinos ('fearfully great', as in awe-inspiring) and sauros(a lizard). The name was invented in 1842 by Richard Owen, who knew they were not lizards, but thought that they may have been derived from them. Owen used the term deinos as a superlative.�\n"); 
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                        
          } while (!answer1.equals ("a"));                 
          System.out.println ("YAY! �terrible lizard� is the correct answer! Good job! You won $2,000!\n"); //output that the user won and the amount they won
          prize = 2000; //set the amount of earnings             
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));        
      }
      
      if (random == 1) { //if the random number is 1
        
        //LEVEL 7 $4,000 - OPTION 1
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n7. The Great Barrier Reef is found off the coast of which country?\n"+"a) Italy\n"+"b) India\n"+"c) South America\n"+"d) Australia\n");   //prompt the user for the answer and correct answer  is d        
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //print lifeline options          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("b") || answer1.equals ("c") || answer1.equals ("a") || answer1.equals ("q")) {//if answer is wrong or user quits game
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they earn
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0);   //break out of loop   
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable 
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\na) Carbon and Hydrogen\n"+"d) Iron ad Oxygen\n"); 
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers 
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Italy " + poll1 +"%\n"+"b) India " + poll2 +"%\n"+"c) South America "+poll3+"%\n"+"d) Australia "+winpoll+"%\n"); 
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n"+"�The Great Barrier Reef is a mosaic of 2,900 individual reefs off the coast of Queensland in northeast Australia. The sprawling reef can be seen from space and is not only the world's largest coral reef system but also the largest structure on Earth made by living organisms.�\n"); //output scientific quote
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                      
          } while (!answer1.equals ("d"));           
          System.out.println ("YAY! Australia is the correct answer! Good job! You won $4,000!\n"); //output a winning message 
          prize = 4000; //set the earnings         
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
        
      } else if (random == 2) { //if the random number is 2
        
        //LEVEL 7 - OPTION 2 
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n7. What kind of eclipse do we have when the moon is between the sun and the earth?\n"+"a) Lunar Eclipse\n"+"b) Rare Total Penumbral Eclipse\n"+"c) Solar Eclipse\n"+"d) Selenelion Phenomena\n");     //prompt the user for the answer and c correct answer    
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //output the lifelines for the user          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("a") || answer1.equals ("b") || answer1.equals ("d") || answer1.equals ("q")) { //if the answer is wrong or user quits game
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they won
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0); //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable 
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\na) Lunar Eclipse\n"+"c) Solar Eclipse\n");  
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Lunar Eclipse "+poll1+"%\n"+"b) Rare Total Penumbral Eclipse "+poll2+"%\n"+"c) Solar Eclipse "+winpoll+"%\n"+"d) Selenelion Phenomena "+poll3+"%\n");
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) {  //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n"+"�A lunar eclipse and a solar eclipse refer to events involving three celestial bodies: the Sun, the moon, and the Earth. A lunar eclipse occurs when the Earth passes between the Moon and the Sun, and the Earth's shadow obscures the moon or a portion of it. A solar eclipse occurs when the Moon passes between the Earth and the Sun, blocking all or a portion of the Sun.�\n"); 
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                      
          } while (!answer1.equals ("c"));             
          System.out.println ("YAY! Solar Eclipse is the correct answer! Good job! You won $4,000!\n"); //output that the user won and the amount they won
          prize = 4000; //set to winning earnings          
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
        
      } else if (random == 3) { //if the random number is 3
        
        //LEVEL 7 - OPTION 3
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n7. Electric air resistance is typically measured in what units?\n"+"a) Ohms\n"+"b) Resistance\n"+"c) Amps\n"+"d) Volts\n"); //prompt the user for the answer and a is correct answer
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //output the lifelines for the user          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable              
            } else if (answer1.equals ("b") || answer1.equals ("c") || answer1.equals ("d") || answer1.equals ("q")) { //if the answer is wrong or user quits game
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they won
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0); //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable 
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\na) Ohms\n"+"c) Amps\n"); 
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Ohms "+winpoll+"%\n"+"b) Resistance "+poll1+"%\n"+"c) Amps "+poll2+"%\n"+"d) Volts  "+poll3+"%\n");
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n"+"�The electrical resistance of an electrical conductor is the opposition to the passage of an electric current through that conductor. The inverse quantity is electrical conductance, the ease with which an electric current passes. Electrical resistance shares some conceptual parallels with the mechanical notion of friction. The SI unit of electrical resistance is the ohm (?). R = V/I�\n"); 
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                        
          } while (!answer1.equals ("a"));             
          System.out.println ("YAY! Ohms is the correct answer! Good job! You won $4,000!\n"); //output that the user won and the amount they won
          prize = 4000; //set the amount of earnings       
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));        
      }
      
      if (random == 1) { //if the random number is 1       
        //LEVEL 8 $8,000 - OPTION 1
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n8. The Galilean moon orbits around which planet?\n"+"a) Mercury\n"+"b) Uranus\n"+"c) Jupiter\n"+"d) Neptune\n");   //prompt the user for the answer and c is correct answer
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //print lifeline options          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("b") || answer1.equals ("d") || answer1.equals ("a") || answer1.equals ("q")) {//if answer is wrong or user quits game
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they earn
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0);   //break out of loop   
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable 
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\nb) Uranus\n"+"c) Jupiter\n");   
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers 
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Mercury "+poll1+"%\n"+"b) Uranus  "+poll1+"%\n"+"c) Jupiter "+winpoll+"%\n"+"d) Neptune "+poll3+"%\n"); 
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n"+"�The Galilean moons was discovered by Galileo Galilei around January 1610. They derive their names from the lovers of Zeus: Io, Europa,Ganymede, and Callisto. They are among the most massive objects in the Solar System outside the Sun and the eight planets, with radii larger than any of the dwarf planets.�\n"); //output scientific quote
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                      
          } while (!answer1.equals ("c"));            
          System.out.println ("YAY! Jupiter is the correct answer! Good job! You won $8,000!\n"); //output a winning message 
          prize = 8000; //set the earnings         
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
        
      } else if (random == 2) { //if the random number is 2
        
        //LEVEL 8 - OPTION 2 
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n8. What is the name given to substances that are originally involved in the chemical reaction?\n"+"a) Products\n"+"b) Yields\n"+"c) You have to know what the substances are first\n"+"d) Reactants\n");  //prompt the user for the answer and correct answer is d   
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //output the lifelines for the user          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("a") || answer1.equals ("b") || answer1.equals ("c") || answer1.equals ("q")) { //if the answer is wrong or user quits game
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they won
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0); //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable 
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\nc) You have to know what the substances are first\n"+"d) Reactant\n");   
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers            
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Products "+poll1+"%\n"+"b) Yields "+poll2+"%\n"+"c) You have to know what the substances are first "+poll3+"%\n"+"d) Reactants "+winpoll+"%\n"); //correct answer  is d
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) {   //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n"+"�Chemical reactions describe the changes between reactants and products. In a balanced chemical reaction all of the matter (i.e., atoms or molecules) that enter into a reaction must be accounted for in the products of a reaction. Accordingly, associated with the symbols for the reactants and products are numbers (stoichiometry coefficients) that represent the number of molecules, formula units, or moles of a particular reactant or product.�\n"); 
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                      
          } while (!answer1.equals ("d"));    
          
          System.out.println ("YAY! Reactants is the correct answer! Good job! You won $8,000!\n"); //output that the user won and the amount they won
          prize = 8000; //set to winning earnings          
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
        
      } else if (random == 3) { //if the random number is 3
        
        //LEVEL 8 - OPTION 3
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n8. A change of the DNA in an organism that results in a new trait is known as a _______.\n"+"a) GMOs\n"+"b) Mutation\n"+"c) Cytokinesis\n"+"d) Genome and Exome Sequencing\n");          ////prompt the user for the answer and mutation is correct answer
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //output the lifelines for the user          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("a") || answer1.equals ("c") || answer1.equals ("d") || answer1.equals ("q")) { //if the answer is wrong or user quits game
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they won
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0); //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable 
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\na) GMOs\n"+"b) Mutation\n");  
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) GMOs "+poll1+"%\n"+ "b) Mutation "+winpoll+"%\n"+"c) Cytokinesis "+poll2+"%\n"+"d) Genome and Exome Sequencing "+poll3+"%\n");
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n"+"�DNA is a dynamic and adaptable molecule. Since our DNA codes for who we are, if there is a change in it, that change can hurt us by preventing us from coding for our proteins properly.  You already know that a problem in a particular gene can cause a genetic disease (like muscular dystrophy).  Another example can be found in some types of cancers-- where a cell becomes cancerous after a mutation in a cell-cycle-controlling gene.�\n"); 
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                        
          } while (!answer1.equals ("b"));                
          System.out.println ("YAY! Mutation is the correct answer! Good job! You won $8,000!\n"); //output that the user won and the amount they won
          prize = 8000; //set the amount of earnings         
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));        
      }
      
      if (random == 1) { //if the random number is 1
        //LEVEL 9 $16,000 - - OPTION 1
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n9. What is the fourth most abundant element in the universe in terms of mass?\n"+"a) Nitrogen\n"+"b) Carbon\n"+"c) Oxygen\n"+"d) Hydrogen\n");             //prompt the user for the answer and b is correct answer 
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //print lifeline options          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("c") || answer1.equals ("d") || answer1.equals ("a") || answer1.equals ("q")) {//if answer is wrong or user quits game
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they earn
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0);   //break out of loop   
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable 
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\na) Nitrogen\n"+"b) Carbon\n"); 
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers 
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Nitrogen "+poll1+"%\n"+"b) Carbon "+winpoll+"%\n"+"c) Oxygen "+poll2+"%\n"+"d) Hydrogen "+poll3+"%\n"); 
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n"+"�In the Universe, Hydrogen is 739,000 in parts per million; Helium is 240000; Oxygen is 10400; Carbon is 4600.�\n"); //output scientific quote
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                      
          } while (!answer1.equals ("b"));            
          System.out.println ("YAY! Carbon is the correct answer! Good job! You won $16,000!\n"); //output a winning message 
          prize = 16000; //set the earnings         
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
        
      } else if (random == 2) { //if the random number is 2
        
        //LEVEL 9 - OPTION 2 
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n9. How long has the crocodile species believed to have been around for how long?\n"+"a) 20 million years\n"+"b) 20,000 years\n"+"c) 200 million years\n"+"d) 200 years\n");  //prompt the user for the answer, c is correct answer          
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //output the lifelines for the user          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("a") || answer1.equals ("b") || answer1.equals ("d") || answer1.equals ("q")) { //if the answer is wrong or user quits game
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they won
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0); //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable 
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\na) 20 million years"+"c) 200 million years\n"); 
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) 20 million years "+poll1+"%\n"+"b) 20,000 years "+poll2+"%\n"+"c) 200 million years "+winpoll+"%\n"+"d) 200 years "+poll3+"%\n"); 
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) {   //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n"+"�Crocodiles have outlived the dinosaurs by some 65 million years. Even humans, the most fearsome predators ever to stalk the Earth, have failed to force into extinction any of the 23 species of crocodilians.�\n"); 
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                      
          } while (!answer1.equals ("c"));            
          System.out.println ("YAY! 200 million years is the correct answer! Good job! You won $16,000!\n"); //output that the user won and the amount they won
          prize = 16000; //set to winning earnings          
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
        
      } else if (random == 3) { //if the random number is 3
        
        //LEVEL 9 - OPTION 3
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n9. What is the brightest planet in the night sky?\n"+"a) Venus\n"+"b) Mercury\n"+"c) North Star\n"+"d) Moon\n");        //prompt the user for the answer 
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //output the lifelines for the user          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("b") || answer1.equals ("c") || answer1.equals ("d") || answer1.equals ("q")) { //if the answer is wrong or user quits game
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they won
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0); //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable 
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\na) Venus\n"+"d) Moon\n"); 
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Venus "+winpoll+"%\n"+"b) Mercury "+poll1+"%\n"+"c) North Star "+poll2+"%\n"+"d) Moon "+poll3+"%\n");
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n"+"�Venus can often be seen within a few hours after sunset or before sunrise as the brightest object in the sky. It looks like a very bright star.�\n"); 
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                        
          } while (!answer1.equals ("a"));             
          System.out.println ("YAY! Venus is the correct answer! Good job! You won $16,000!\n"); //output that the user won and the amount they won
          prize = 16000; //set the amount of earnings         
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));        
      }
      
      if (random == 1) { //if the random number is 1
        
        //LEVEL 10 $32,000 - - OPTION 1
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n10. The outside layer of skin on the human body is called the _________.\n"+ "a) Epithelium\n"+"b) Subcutaneous\n"+"c) Epidermis\n"+"d) Basal lamina\n");            //prompt the user for the answer, c is correct answer
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //print lifeline options          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("b") || answer1.equals ("d") || answer1.equals ("a") || answer1.equals ("q")) { //if user quits game or answers wrong
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they earn
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0);    //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable 
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\nb) Subcutaneous\n"+"c) Epidermis\n");  
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers 
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Epithelium "+poll1+"%\n"+"b) Subcutaneous "+poll2+"%\n"+"c) Epidermis "+winpoll+"%\n"+"d) Basal lamina "+poll3+"%\n"); 
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n"+"�The outer layer forms the waterproof, protective wrap over the body's surface and is made up of stratified squamous epithelium with an underlying basal lamina.�\n"); //output scientific quote
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                      
          } while (!answer1.equals ("c"));              
          System.out.println ("YAY! Epidermis is the correct answer! Good job! You won $32,000!\n"); //output a winning message 
          prize = 32000; //set the earnings         
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
        
      } else if (random == 2) { //if the random number is 2
        
        //LEVEL 10 - OPTION 2 
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n10. An example of a multivalent is _________.\n"+"a) Products\n"+"b) Zinc\n"+"c) Iron\n"+"d) Neon\n"); //prompt the user for the answer        
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //output the lifelines for the user          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("a") || answer1.equals ("b") || answer1.equals ("d") || answer1.equals ("q")) { //if the answer is wrong or user quits game
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they won
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0); //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable  
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\na) Silver\n"+"c) Iron\n");  
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Silver "+poll1+"%\n"+"b) Zinc "+poll2+"%\n"+"c) Iron "+winpoll+"%\n"+"d) Neon "+poll3+"%\n"); 
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) {   //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n"+"�Polyvalence or multivalence refers to species that are not restricted to a distinct number of valence bonds.�\n"); 
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                      
          } while (!answer1.equals ("c"));                          
          System.out.println ("YAY! Iron is the correct answer! Good job! You won $32,000!\n"); //output that the user won and the amount they won
          prize = 32000; //set to winning earnings          
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
        
      } else if (random == 3) { //if the random number is 3
        
        //LEVEL 10 - OPTION 3
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n10. In physics, a(n) ___________ is a wave that remains in a constant position.\n"+"a) Standing Wave\n"+"b) Stationary Medium\n"+"c) Interference\n"+"d) Mechanical Wave\n");         //prompt the user for the answer, a is correct answer
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //output the lifelines for the user          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("b") || answer1.equals ("c") || answer1.equals ("d") || answer1.equals ("q")) { //if the answer is wrong or user quits game
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they won
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0); //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\na) Standing wave\n"+"d) Mechanical Wave\n"); 
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Standing Wave "+winpoll+"%\n"+"b) Stationary Medium "+poll1+"%\n"+"c) Interference "+poll2+"%\n"+"d) Mechanical Wave "+poll3+"%\n");
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n"+"�This phenomenon can occur because the medium is moving in the opposite direction to the wave, or it can arise in a stationary medium as a result of  interference between two waves traveling in opposite directions. In the second case, for waves of equal amplitude traveling in opposing directions, there is on average no net propagation of energy.�\n"); 
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                        
          } while (!answer1.equals ("a"));                 
          System.out.println ("YAY! Standing Wave is the correct answer! Good job! You won $32,000!\n"); //output that the user won and the amount they won
          prize = 32000; //set the amount of earnings         
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));        
      }
      
      if (random == 1) { //if the random number is 1
        
        //LEVEL 11 $64,000 - OPTION 1
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n11. What are atoms of the same chemical element that have different atomic mass known as?\n"+"a) Ions\n"+"b) Atoms\n"+ "c) Isotopes\n"+"d) Moles\n");  //c is correct answer and prompt the user for the answer   
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //print lifeline options          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("b") || answer1.equals ("d") || answer1.equals ("a") || answer1.equals ("q")) { //if the answer is wrong or user quits game
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they earn
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0);   //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\nba) Ions]n"+"c) Isotopes\n");  
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers 
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Ions "+poll1+"%\n"+"b) Atoms "+poll2+"%\n"+"c) Isotopes "+winpoll+"%\n"+"d) Moles  "+poll3+"%\n"); 
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University              
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n"+"�For many of the chemical elements there are several known isotopes. Isotopes are atoms with different atomic masses which have the same atomic number. The atoms of different isotopes are atoms of the same chemical element; they differ in the number of neutrons in the nucleus.�\n"); //output scientific quote
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                      
          } while (!answer1.equals ("c"));              
          System.out.println ("YAY! Isotopes is the correct answer! Good job! You won $64,000!\n"); //output a winning message 
          prize = 64000; //set the earnings          
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
        
      } else if (random == 2) { //if the random number is 2
        
        //LEVEL 11 - OPTION 2 
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n11. In computing, what does ROM stand for?\n"+"a) Random Only Memory\n"+"b) Royal Ontario Museum\n"+"c) Read Only Memory\n"+"d) Rivers of MUD\n");            //prompt the user for the answer, c is correct answer
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //output the lifelines for the user          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("a") || answer1.equals ("b") || answer1.equals ("d") || answer1.equals ("q")) { //if the answer is wrong or user quits game
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they won
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0); //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable 
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\na) Random Only Memory\n"+"c) Read Only Memory\n");
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\n a) Random Only Memory "+poll1+"%\n"+"b) Royal Ontario Museum "+poll2+"%\n"+"c) Read Only Memory  "+winpoll+"%\n"+"d) Rivers of MUD "+poll3+"%\n");   
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) {   //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n"+"�Although ROM also permits random data access, data stored in ROM cannot be changed or modified. Instead, the data can only be read or displayed.�\n"); 
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                      
          } while (!answer1.equals ("c"));           
          System.out.println ("YAY! Read Only Memory is the correct answer! Good job! You won $64,000!\n"); //output that the user won and the amount they won
          prize = 64000; //set to winning earnings           
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
        
      } else if (random == 3) { //if the random number is 3
        
        //LEVEL 11 - OPTION 3
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n11. What is the name of a place that uses telescopes and other scientific equipment to research space and astronomy?\n"+"a) Laboratory\n"+"b) Observatory\n"+"c) Planetarium\n"+"d) Astronomy Facility\n");//prompt the user for the answer, b is correct answer          
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //output the lifelines for the user          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("a") || answer1.equals ("c") || answer1.equals ("d") || answer1.equals ("q")) { //if the answer is wrong or user quits game
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they won
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0); //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\na) Laboratory\n"+"b) Observatory\n"); 
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) {  //if user chooses Poll the Audience to poll the audience's answers
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Laboratory "+poll1+"%\n"+"b) Observatory "+winpoll+"%\n"+"c) Planetarium "+poll2+"%"+"d) Astronomy Facility 1"+poll3+"%\n");
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n"+"�Most optical telescopes are housed within a dome or similar structure, to protect the delicate instruments from the elements. Telescope domes have a slit or other opening in the roof that can be opened during observing, and closed when the telescope is not in use. In most cases, the entire upper portion of the telescope dome can be rotated to allow the instrument to observe different sections of the night sky. Radio telescopes usually do not have domes.�\n"); 
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                        
          } while (!answer1.equals ("b"));           
          System.out.println ("YAY! Observatory is the correct answer! Good job! You won $64,000!\n"); //output that the user won and the amount they won
          prize = 64000; //set the amount of earnings          
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));        
      }
      
      if (random == 1) { //if the random number is 1
        
        //LEVEL 12 $125,000 - OPTION 1
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n12. The scientific name of the shape of DNA is known as _________.\n"+"a) Chromosome\n"+"b) Adenine\n"+"c) Double Helix\n"+"d) Twisted Ladder\n"); //prompt the user for the answer and c is correct answer
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //print lifeline options          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("b") || answer1.equals ("d") || answer1.equals ("a") || answer1.equals ("q")) { //if answer is wrong or user quits game
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they earn
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0);  //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\na) Chromosome\n"+"c) Double Helix\n");  
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers 
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Chromosome "+poll1+"%\n"+"b) Adenine "+poll2+"%\n"+"c) Double Helix "+winpoll+"%\n"+"d) Twisted Ladder "+poll3+"%\n"); 
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable 
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n"+"�The most common DNA shape illustrated by artists and scientist looks a lot like a twisting ladder that scientist call a double helix.  DNA also folds and coils itself into more complex shapes. The coiled shape makes it very small. In fact, it is small enough to easily fit inside any of our cells. A pretty amazing feat when you find out that our own DNA, if unfolded, would stretch out to a length of six feet.�\n"); //output scientific quote
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                      
          } while (!answer1.equals ("c"));                  
          System.out.println ("YAY! Double Helix is the correct answer! Good job! You won $125,000!\n"); //output a winning message 
          prize = 125000; //set the earnings         
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
        
      } else if (random == 2) { //if the random number is 2
        
        //LEVEL 12 - OPTION 2 
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n12. What is the second longest river on Earth?\n"+"a) Amazon River\n"+"b) Nile River\n"+"c) Mississippi River\n"+"d) Yangtze River\n");   //prompt the user for the answer          
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //output the lifelines for the user          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("d") || answer1.equals ("b") || answer1.equals ("c") || answer1.equals ("q")) { //if the answer is wrong or user quits game
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they won
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0); //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\na) Amazon River\n"+"c) Mississippi River\n");  
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na)Amazon River "+winpoll+"%\n"+"b) Nile River "+poll1+"%\n"+"c) Mississippi River "+poll2+"%\n"+"d) Yangtze River "+poll3+"%\n");  
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) {    //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n"+"�The Nile River is 6,650 km long and drains an area of 3,349,000 square km. The Amazon drains an much larger area and is 250 km.�\n"); 
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                      
          } while (!answer1.equals ("a"));            
          System.out.println ("YAY! Amazon River is the correct answer! Good job! You won $125,000!\n"); //output that the user won and the amount they won
          prize = 125000; //set to winning earnings          
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d")&& !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
        
      } else if (random == 3) { //if the random number is 3
        
        //LEVEL 12 - OPTION 3
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n12. Electric current is measured using what device?\n"+"a) Ohmmeter\n"+"b) Ammeter\n"+"c) Coulomb\n"+"d) Ampere\n");  //prompt the user for the answer, b is correct answer
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //output the lifelines for the user          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("a") || answer1.equals ("c") || answer1.equals ("d") || answer1.equals ("q")) { //if the answer is wrong or user quits game
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they won
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0); //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\nb) Ammeter\n"+"d) Ampere\n"); 
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Ohmmeter "+poll1+"%\n"+"b) Ammeter "+winpoll+"%\n"+"c) Coulomb "+poll2+"%\n"+"d) Ampere  "+poll3+"%\n");
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n"+"�An electric current is a flow of electric charge. In electric circuits this charge is often carried by moving electrons in a wire. It can also be carried by ions in an electrolyte, or by both ions and electrons such as in a plasma.�\n"); 
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                        
          } while (!answer1.equals ("b"));                 
          System.out.println ("YAY! Ammeter is the correct answer! Good job! You won $125,000!\n"); //output that the user won and the amount they won
          prize = 125000; //set the amount of earnings          
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
      }
      
      if (random == 1) { //if the random number is 1       
        //LEVEL 13 $250,000 - OPTION 1
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n13. Over a long period of time while under extreme heat and pressure, graphite turns into precious mineral?\n"+"a) Coal\n"+"b) Crystal\n"+"c) Swarovski\n"+"d) Diamond\n");  //prompt the user for the answer, correct answer  is d         
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //print lifeline options          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("b") || answer1.equals ("d") || answer1.equals ("a") || answer1.equals ("q")) {//if the answer is wrong or user quits game
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they earn
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0);   //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\nb) Crystal\n"+"d) Diamond\n"); 
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers 
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Coal "+poll1+"%\n"+"b) Crystal "+poll2+"%\n"+"c) Swarovski "+poll3+"%\n"+"d) Diamond "+winpoll+"%\n");  
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n"+"�Graphite, the gray-black, soft, greasy 'lead' used in pencils.�\n"); //output scientific quote
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                      
          } while (!answer1.equals ("d"));           
          System.out.println ("YAY! Diamond is the correct answer! Good job! You won $250,000!\n"); //output a winning message 
          prize = 250000; //set the earnings          
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
        
      } else if (random == 2) { //if the random number is 2
        
        //LEVEL 13 - OPTION 2 
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n13. At what temperature is Fahrenheit equal to Centigrade?\n"+"a) -20 degrees Celsius\n"+"b) 10 degrees Celsius\n"+"c) -30 degrees Celsius\n"+"d) -40 degrees Celsius\n");  //prompt the user for the answer, correct answer  is d
          
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //output the lifelines for the user          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("a") || answer1.equals ("b") || answer1.equals ("c") || answer1.equals ("q")) { //if the answer is wrong or user quits game
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they won
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0); //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\na) -20 degrees Celsius\n"+"d) -40 degrees Celsius\n"); 
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\n a) -20 degrees Celsius "+poll1+"%\n"+"b) 10 degrees Celsius "+poll2+"%\n"+"c) -30 degrees Celsius "+poll3+"%\n"+"d) -40 degrees Celsius "+winpoll+"%\n");
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) {   //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n"+"�Using trial and error, the �F = (�C x 1.8) + 32 equation can help find the answer.�\n"); 
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                      
          } while (!answer1.equals ("d"));                 
          System.out.println ("YAY! -40 degrees Celsius is the correct answer! Good job! You won $250,000!\n"); //output that the user won and the amount they won
          prize = 250000; //set to winning earnings          
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
        
      } else if (random == 3) { //if the random number is 3
        
        //LEVEL 13 - OPTION 3
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n13. What is the most recognizable feature of a hedgehog�s appearance?\n"+"a) Balling up\n"+"b) Forehead furrow\n"+"c) Spines of spiky hair\n"+"d) Short, pouty snout\n"); //prompt the user for the answer, correct answer is c
          
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //output the lifelines for the user          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("a") || answer1.equals ("b") || answer1.equals ("d") || answer1.equals ("q")) { //if the answer is wrong or user quits game
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they won
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0); //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\na) Balling up\n"+"c) Spines of spiky hair\n");
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Balling up "+poll1+"%\n"+"b) Forehead furrow "+poll2+"%\n"+"c) Spines of spiky hair "+winpoll+"%\n"+"d) Short, pouty snout "+poll3+"%\n");
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:");
              System.out.println ("�A hedgehog is any of the spiny mammals of thesubfamily Erinaceinae, which is in order Erinaceomorpha.�\n"); 
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                        
          } while (!answer1.equals ("c"));           
          System.out.println ("YAY! Spines of spiky hair is the correct answer! Good job! You won $250,000!\n"); //output that the user won and the amount they won
          prize = 250000; //set the amount of earnings          
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));        
      }
      
      if (random == 1) { //if the random number is 1
        
        //LEVEL 14 $500,000 - OPTION 1
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n14. What is the name of NASA�s most famous space telescope?\n"+"a) Spitzer Space Telescope\n"+"b) Hubble Space Telescope\n"+"c) James Webb Space Telescope\n"+"d) James West Space Telescope\n"); //prompt the user for the answer, correct answer is b
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //print lifeline options          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("a") || answer1.equals ("c") || answer1.equals ("d") || answer1.equals ("q")) {//if the answer is wrong or user quits game
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they earn
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0);   //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\nb) Hubble Space Telescope\n"+"c) James Webb Space Telescopen");  
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers 
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Spitzer Space Telescope "+poll1+"%\n"+"b) Hubble Space Telescope "+winpoll+"%\n"+"c) James Webb Space Telescope "+poll2+"%\n"+"d) James West Space Telescope "+poll3+"%\n"); 
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n"+"�The James Webb Space Telescope (JWST) is the successor to the Hubble Space Telescope, and it will be almost three times the size of Hubble. JWST has been designed to work best at infrared wavelengths.�\n"); //output scientific quote
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                      
          } while (!answer1.equals ("b"));             
          System.out.println ("YAY! Hubble Space Telescopeis the correct answer! Good job! You won $500,000!\n"); //output a winning message 
          prize = 500000; //set the earnings          
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
        
      } else if (random == 2) { //if the random number is 2
        
        //LEVEL 14 - OPTION 2 
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n14. In terms of astronomy, what does NASA stand for?\n"+"a) National Astronomic and Space Administratio\n"+"b) North American Space Administration\n"+"c) National Aeronautics and Space Administration\n"+"d) North Atlantic Space Administration\n"); //prompt the user for the answer, corect answer is c
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //output the lifelines for the user          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("a") || answer1.equals ("b") || answer1.equals ("d") || answer1.equals ("q")) { //if the answer is wrong or user quits game
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they won
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0); //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\na) National Astronomic and Space Administration\n"+"c) National Aeronautics and Space Administration \n");  
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\n a) National Astronomic and Space Administration "+poll1+"%\n"+"b) North American Space Administration "+poll2+"%\n"+"c) National Aeronautics and Space Administration "+winpoll+"%\n"+"d) North Atlantic Space Administration "+poll3+"%\n");  
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) {   //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n"+"�(NASA) is the United States government agency that is responsible for the civilian space program as well as for aeronautics andaerospace research.�\n"); 
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                      
          } while (!answer1.equals ("c"));            
          System.out.println ("YAY! National Aeronautics and Space Administration is the correct answer! Good job! You won $500,000!\n"); //output that the user won and the amount they won
          prize = 500000; //set to winning earnings          
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
        
      } else if (random == 3) { //if the random number is 3
        
        //LEVEL 14 - OPTION 3
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n14. What is the study of fungi specifically is called?\n"+"a) Fungology\n"+"b) Mycology\n"+"c) Botany\n"+"d) Biology\n");//prompt the user for the answer, correct answer is b
          
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //output the lifelines for the user          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("a") || answer1.equals ("c") || answer1.equals ("d") || answer1.equals ("q")) { //if the answer is wrong or user quits game
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they won
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0); //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\b) Mycology\n"+"c) Botany\n"); 
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Fungology  "+poll1+"%\n"+"b) Mycology "+winpoll+"%\n"+"c) Botany "+poll2+"%\n"+"d) Biology "+poll3+"%\n");
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) {  //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n"+"�Botany, also called plant science(s) orplant biology, is the science of plant life and a branch of biology. A botanist orplant scientist is a scientist who specializes in this field of study.�\n"); 
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                        
          } while (!answer1.equals ("b"));              
          System.out.println ("YAY! Mycology is the correct answer! Good job! You won $500,000!\n"); //output that the user won and the amount they won
          prize = 500000; //set the amount of earnings
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));        
      }
      
      if (random == 1) { //if the random number is 1
        
        //LEVEL 15 $1,000,000 - OPTION 1
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n15. What is the colored part of the human eye that controls how much light passes through the pupil is called?\n"+"a) Cornea\n"+"b) Retina\n"+"c) Iris\n"+"d) Lens\n"); //prompt the user for the answer, correct answer is c
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //print lifeline options          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("b") || answer1.equals ("d") || answer1.equals ("a") || answer1.equals ("q")) {//if the answer is wrong or user quits game
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they earn
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0);    //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\na) Cornea\n"+"c) Iris\n");  
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers 
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Cornea "+poll1+"%\n"+"b) Retina "+poll2+"%\n"+"c) Iris "+winpoll+"%\n"+ "d) Lens "+poll3+"%\n"); //correct answer is c
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n"+"�Light is focused primarily by the cornea. The iris of the eye functions like the diaphragm of a camera, controlling the amount of light reaching the back of the eye by automatically adjusting the size of the pupil (aperture).\n"+"The eye's crystalline lens is located directly behind the pupil and further focuses light.�\n"); //output scientific quote
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                      
          } while (!answer1.equals ("c"));                 
          System.out.println ("YAY! Iris is the correct answer! YOU WON $1,000,000! CONGRATULATIONS, YOU WON THE GAME!! \n"); //output that the user won and the amount they won            
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
        
      } else if (random == 2) { //if the random number is 2
        
        //LEVEL 15 - OPTION 2 
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n15. Which country was theoretical physicist James Maxwell was born in?\n"+"a) Ireland\n"+"b) England\n"+"c) Russia\n"+"d) Scotland\n");  ////prompt the user for the answer, d is correct answer           
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //output the lifelines for the user          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("a") || answer1.equals ("b") || answer1.equals ("c") || answer1.equals ("q")) { //if the answer is wrong or user quits game
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they won
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0); //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\na) Ireland\n" +"d) Scotland\n");  
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) { //if user chooses Poll the Audience to poll the audience's answers
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\n a) Ireland "+poll1+"%\n"+"b) England "+poll2+"%\n"+"c) Russia "+poll3+"%\n"+"d) Scotland "+winpoll+"%\n"); 
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) {   //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n"+"�James Clerk Maxwell was born on June 13, 1831 and died on November 5, 1879 in Edinburgh. He was a mathematical physicist. His most notable achievement was to formulate the classical theory of electromagnetic radiation, bringing together for the first time electricity, magnetism, and light as manifestations of the same phenomenon.�\n"); 
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                      
          } while (!answer1.equals ("d"));                
          System.out.println ("YAY! Scotland is the correct answer! YOU WON $1,000,000! CONGRATULATIONS, YOU WON THE GAME!! \n"); //output that the user won and the amount they won 
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));
        
      } else if (random == 3) { //if the random number is 3        
        //LEVEL 15 - OPTION 3
        do { //do while the answer is not a, b, c, d, q, 1, 2, or 3
          System.out.println ("\n15. Nimbus, cumulus and stratus are types of what?\n"+"a) Air Currents\n"+"b) Clouds\n"+"c) Atmospheres\n"+"d) Storms\n");           ////prompt the user for the answer, correct answer is b
          System.out.println ("Lifeline: 1 - 50/50  2 - Poll The Audience  3 - Ask An Expert"); //output the lifelines for the user          
          answer1 = userInput.next(); //store input into variable         
          
          do { //do while the answer is not correct
            if (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("q") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3")) { //if answer is not one of following choices, quit 'q', or one of the lifelines
              System.out.print ("Invalid. Please try again"); // output message to user that their input is invalid
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("a") || answer1.equals ("c") || answer1.equals ("d") || answer1.equals ("q")) { //if the answer is wrong or user quits game
              System.out.println ("That is incorrect! You earned $" + prize); //output the amount they won
              
              try { //pause 
                Thread.sleep(3000); //1000 milliseconds is one second.
              } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              
              System.exit (0); //break out of loop
              
              //validation of lifelines
            } else if ((lifeline1 == 0 && answer1.equals ("1")) || (lifeline2 == 0 && answer1.equals ("2")) || (lifeline3 == 0 && answer1.equals ("3"))) { //if the user enters 1, 2, 3 (lifelines
              System.out.println ("\nIt can't be used!\n"); //output a message that the lifeline has been used
              answer1 = userInput.next(); //store input into variable
              
              //use of lifelines
            } else if (answer1.equals ("1")) { //if user chooses 50/50 to eliminate two answers; gives user hint
              System.out.println ("\na) Air Currents\n"+"b) Clouds\n"); 
              lifeline1 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable  
            } else if (answer1.equals ("2")) {  //if user chooses Poll the Audience to poll the audience's answers
              
              //randomize the polls
              winpoll = ((int) (Math.random() *30))+ 30; //randomize the correct answer
              max = 100-winpoll; //calculate for the maximum number
              poll1 = (int) (Math.random() * max); //randomize the polls
              max = max - poll1; //calculate for the new maximum number
              poll2 = (int) (Math.random() * max); //randomize the polls
              max = max - poll2; //calculate for the new maximum number
              poll3 = 100-(poll1+poll2+winpoll); //calculate the remainder
              
              System.out.println ("\na) Air Currents "+poll1+"%\n"+"b) Clouds "+winpoll+"%\n"+"c) Atmospheres "+poll2+"%\n"+"d) Storms "+poll3+"%\n");
              lifeline2 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            } else if (answer1.equals ("3")) { //if user chooses Ask An Expert to ask a professor from Eastern University
              System.out.println ("\nDr. Anderson, a professor from Eastern University, states:\n"+"�Cumulonimbus, from the Latin cumulus ('heap') and nimbus ('rainstorm', 'storm cloud'), is associated with thunderstorms and atmospheric instability, forming from water vapor carried by powerful upward air curren�\n");              
              lifeline3 = 0; //lifeline can't be used anymore when it equals zero
              answer1 = userInput.next(); //store input into variable
            }                        
          } while (!answer1.equals ("b"));                 
          System.out.println ("YAY! Clouds is the correct answer! YOU WON $1,000,000! CONGRATULATIONS, YOU WON THE GAME!!\n"); //output that the user won and the amount they won          
        } while (!answer1.equals ("a") && !answer1.equals ("b") && !answer1.equals ("c") && !answer1.equals ("d") && !answer1.equals ("1") && !answer1.equals ("2")&& !answer1.equals ("3"));        
      }  
      System.out.print ("Want to play again? n for No, y for Yes\n"); //prompt the user if they want to play the game again and store the user's input
      playAgain = userInput.next();      
      
      name = userInput.nextLine(); //store name       
    } while (!playAgain.equals ("n"));            
  }
}
