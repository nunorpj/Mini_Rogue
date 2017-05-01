/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.textUI;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import mini_rogue.logic.MiniRogue;
import mini_rogue.logic.states.*;

import java.util.InputMismatchException;
import java.util.Scanner;



public class TextUI {
    private MiniRogue Game;//miniRogue, tem la o GameData e os estados
    private boolean Quit = false;
    private Scanner sc = null;

    public TextUI(MiniRogue game) {
        this.Game = game;
    }

    private void uiAwaitBeginning() {
        int option = -1;
        do {
            System.out.println("\t\tMINI-ROGUE!!");//Nuno o hero nao da para lvl up no
            System.out.println("\t1 - Start Game");//inicio, ja fizeste a area
            System.out.println("\t2 - Set Starting Area");//falta a dificuldade!
            System.out.println("\t3 - Set Dificulty Lvl");
            System.out.println("\t4 - Load Game");
            System.out.println("\t0 - quit");
            System.out.println();
            System.out.print("-> ");
            try {
                if (sc.hasNextInt()) {
                    option = sc.nextInt();
                } else
                    sc.next();

                if (option < 0 || option > 4)
                    throw new InputMismatchException("Not between 0 and 3.");
            } catch (InputMismatchException ex) {
                System.out.println("Invalid Option! -> " + ex.getMessage());
                // System.out.println("Invalid Option! ERROR: "+ ex); --> Diz o erro que ocurreu
                continue;
            }

        } while (option < 0 || option > 4);

        switch (option) {
            case 0:
                Quit = true;
                break;
            case 1:
                Game.StartGame();
                break;
            case 2:
                set_starting_area();
                break;
            case 3:
                set_dificulty();
                break;
            case 4:
                String fileName=null;
                BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("File name: ");
                try {
                    fileName = bin.readLine();
                    }catch(IOException e){}

                    if(fileName==null ||fileName.length() < 1){
                        System.out.println("Invalide SaveGame name");
                        return;
                    }
                    try {
                        Game = loadGame(fileName);
                    }catch(IOException | ClassNotFoundException e){
                        System.out.println("Error Loading SaveGame");
                    }
                        
        }
    }

    private void uiAwaitCardSelection() {//testing
        Scanner sc = new Scanner(System.in);
        int option = -1;
        Boolean cardSelected = false;
        //System.out.println("Start!");
        System.out.print("Level: " + Game.getDungeonLvl());
        System.out.println(" Area: " + Game.getArea());
        System.out.println("Collun: " + Game.Collunlvl());
        do {
            System.out.println(Game.CardOnTableToString());

            System.out.println();
            switch (Game.Collunlvl()) {
                case 1:
                    System.out.println("1- " + Game.CardNameAtIndex(0));
                    System.out.println("0- quit");
                    break;
                case 2:
                    System.out.println("1- " + Game.CardNameAtIndex(1));
                    System.out.println("2- " + Game.CardNameAtIndex(2));
                    System.out.println("0- quit");
                    break;
                case 3:
                    System.out.println("1- " + Game.CardNameAtIndex(3));
                    System.out.println("0- quit");
                    break;
                case 4:
                    System.out.println("1- " + Game.CardNameAtIndex(4));
                    System.out.println("2- " + Game.CardNameAtIndex(5));
                    System.out.println("0- quit");
                    break;
                case 5:
                    System.out.println("1- " + Game.CardNameAtIndex(6));
                    System.out.println("0- quit");
                    break;
            }
            System.out.println();
            System.out.print("-> ");
            try {
                if (sc.hasNextInt())
                    option = sc.nextInt();
                else
                    sc.next();
                if (Game.Collunlvl() == 1 || Game.Collunlvl() == 3 || Game.Collunlvl() == 5) {
                    if (option < 0 || option > 1)
                        throw new InputMismatchException("Not between 0 and 1.");
                } else if (option < 0 || option > 2)
                    throw new InputMismatchException("Not between 0 and 2.");
            } catch (InputMismatchException ex) {
                System.out.println("Invalid Option! -> " + ex.getMessage());
                continue;//volta ao inicio do while
            }
            if (option == 0)
                Quit = true;
            else {
                Game.ResolvSelectedCard(option);
                cardSelected = true;
            }
        } while (!Quit && !cardSelected);
        if (Quit){
            option=-1;
            while(option!=0&&option!=1){
                System.out.println("Do you wanna save this game?");
                System.out.println("1-Yes");
                System.out.println("0-No");
                System.out.println();
                System.out.print("-> ");
                try {
                    if (sc.hasNextInt())
                        option = sc.nextInt();
                    else
                        sc.next();
                } catch (InputMismatchException ex) {
                    System.out.println("Invalid Option! -> " + ex.getMessage());
                    continue;
                }
            }
            if(option==1){
                 handleSaveGameToFileOption();

            }
        }
    }

    private void uiAwaitTrading() {
        Scanner sc = new Scanner(System.in);
        int option = -2;
        do {
            //System.out.println(Game.CaracterText());
            System.out.println("\tMERCHANT!!");
            System.out.println("1-Buy");
            System.out.println("2-sell");
            System.out.println("0-Skip");

            System.out.println();
            System.out.print("-> ");
            try {
                if (sc.hasNextInt())
                    option = sc.nextInt();
                else
                    sc.next();

                if (option < 0 || option > 3)
                    throw new InputMismatchException("Not between 0 and 3.");
            } catch (InputMismatchException ex) {
                System.out.println("Invalid Option! -> " + ex.getMessage());
                continue;
            }

        } while (option < 0 || option > 3);
        switch (option) {
            case 0:
                Game.BackToCardSelecton();
                break;
            case 1://Buying
                do {
                    System.out.println("\tBUYING!!");
                    System.out.println("1-[-1G] Ration [+1 Food]");
                    System.out.println("2-[-1G] Health Potion [+1 HP]");
                    System.out.println("3-[-3G] Big Health Potion [+4 HP]");
                    System.out.println("4-[-6G] Armor Piece [+1 Armor]");
                    System.out.println("5-[-8G] Any Spell [+1 Spell]");
                    System.out.println("0-Return to Merchant");
                    try {
                        if (sc.hasNextInt())
                            option = sc.nextInt();
                        else
                            sc.next();
                        if (option < 0 || option > 5)
                            throw new InputMismatchException("Not between 0 and 5.");
                    } catch (InputMismatchException ex) {
                        System.out.println("Invalid Option!");
                        continue;
                    }
                    if (option == 5) {
                        System.out.println("\tBUYING SPELLS!!");
                        System.out.println("1-[-8G] Fire Spell ");//4+1=option 5
                        System.out.println("2-[-8G] Ice Spell");//4+2=option 6
                        System.out.println("3-[-8G] Poison Spell");//4+3=option 7
                        System.out.println("4-[-8G] Heal Spell");//4+4=option 8
                        System.out.println("0-Return to Merchant");
                        System.out.println();
                        System.out.print("-> ");
                        try {
                            if (sc.hasNextInt())
                                option = sc.nextInt();
                            else
                                sc.next();

                            if (option < 0 || option > 4)
                                throw new InputMismatchException("Not between 0 and 4.");
                        } catch (InputMismatchException ex) {
                            System.out.println("Invalid Option! -> " + ex.getMessage());
                            continue;
                        }
                        if (option != 0)
                            option = option + 4;
                    }
                    if (option != 0)
                        if (Game.Buying(option) == false)
                            System.out.println("no money, no funny");
                } while (option != 0);
                break;
            case 2:
                do {//selling
                    System.out.println("\tSELLING!!");
                    System.out.println("1-[+3G] Armor Piece [-1 Armor]" + "[stock:" + Game.getStockForSell(1) + "]");
                    System.out.println("2-[+4G] Any Spell [-1 Spell]");
                    System.out.println("0-Return to Merchant");
                    System.out.println();
                    System.out.print("-> ");
                    try {
                        if (sc.hasNextInt())
                            option = sc.nextInt();
                        else
                            sc.next();
                        if (option < 0 || option > 2)
                            throw new InputMismatchException("Not between 0 and 2.");
                    } catch (InputMismatchException ex) {
                        System.out.println("Invalid Option! -> " + ex.getMessage());
                        continue;
                    }
                    if (option == 2) {//spells
                        System.out.println("\tSELLING SPELLS!!");
                        System.out.println("1-[+4G] Fire Spell [stock:" + Game.getStockForSell(2) + "]");//1+1=option 2
                        System.out.println("2-[+4G] Ice Spell [stock:" + Game.getStockForSell(3) + "]");//1+2=option 3
                        System.out.println("3-[+4G] Poison Spell [stock:" + Game.getStockForSell(4) + "]");//1+3=option 4
                        System.out.println("4-[+4G] Heal Spell [stock:" + Game.getStockForSell(5) + "]");//1+4=option 5
                        System.out.println("0-Return to Merchant");
                        System.out.println();
                        System.out.print("-> ");
                        try {
                            if (sc.hasNextInt())
                                option = sc.nextInt();
                            else
                                sc.next();
                            if (option < 0 || option > 4)
                                throw new InputMismatchException("Not between 0 and 4.");
                        } catch (InputMismatchException ex) {
                            System.out.println("Invalid Option! -> " + ex.getMessage());
                            continue;
                        }
                        if (option == 0)
                            break;
                        option++;
                    }
                    if (Game.Selling(option) == false)
                        System.out.println("no stuff, no money");
                } while (option != 0);

                break;
        }
    }

    private void uiAwaitOptionSelection() {
        Scanner sc = new Scanner(System.in);
        int option = -2;
        do {
            //System.out.println(Game.CaracterText());
            System.out.println("\tRESTING!!");
            System.out.println("1-Reinforce your weapon [+1 xp]");
            System.out.println("2-Search for Ration [+1 Food]");
            System.out.println("3-Heal [+2 Hp]");

            System.out.println();
            System.out.print("-> ");
            try {
                if (sc.hasNextInt())
                    option = sc.nextInt();
                else
                    sc.next();
                if (option < 1 || option > 3)
                    throw new InputMismatchException("Not between 0 and 3.");
            } catch (InputMismatchException ex) {
                System.out.println("Invalid Option! -> " + ex.getMessage());
                continue;
            }
        } while (option < 1 || option > 3);
        Game.ResolveResting(option);
    }


    private void set_starting_area() {
        int option = -1;
        boolean cancel = false;
        do {
            System.out.println("Enter de Starting area [1-14] (0 to cancel):");
            System.out.print("-> ");
            try {
                if (sc.hasNextInt())
                    option = sc.nextInt();
                else {
                    sc.next();
                    throw new InputMismatchException("Invalid Option!");
                }
                if (option == 0) {
                    cancel = true;
                } else if (option < 1 || option > 14)
                    throw new InputMismatchException("Not between 1 and 14.");

            } catch (InputMismatchException ex) {
                System.out.println(ex.getMessage());
                continue;
            }
            break;
        } while (true);
        if (!cancel)
            Game.SetStartingArea(option);
    }

    private void set_dificulty() {
        int option = -1;
        do {
            System.out.println("\tDificulty Lvl:");//Nuno o hero nao da para lvl up no
            System.out.println("\t1-Casual");//inicio, ja fizeste a area
            System.out.println("\t2-Normal.");//falta a dificuldade!
            System.out.println("\t3-Hard!");
            System.out.println("\t4-IMPOSSIBLE!!");
            System.out.println("\t0-Return");
            System.out.println();
            System.out.print("-> ");
            try {
                if (sc.hasNextInt())
                    option = sc.nextInt();
                else {
                    sc.next();
                    throw new InputMismatchException();
                }
                if (option == 0)
                    return;
                if (option < 0 || option > 4)
                    throw new InputMismatchException("Not between 0 and 4.");
            } catch (InputMismatchException ex) {
                System.out.println("Invalid Option!" + ex.getMessage());
                continue;
            }
        } while (option < 0 || option > 4);

        Game.SetDificultylvl(option);
    }

    private void uiRolledDices() {
        int option = -1;
        do {
            System.out.print("Monster hp: " +  ((RolledDices)Game.getState()).getMonsterLife());
            System.out.println("\t Monster attack: " +((RolledDices)Game.getState()).getMonsterAttack());
            System.out.println("\t" + Game.getEnemyName() + "!!");//Nuno o hero nao da para lvl up no
            System.out.println("1 - attack! [DMG=" + Game.getCharacterAtack() + "]");//inicio, ja fizeste a area
            if (!Game.featsUsed())
                System.out.println("2 - Use Feats");//falta a dificuldade!
            System.out.println("0 - quit");
            System.out.println();
            System.out.print("-> ");
            try {
                if (sc.hasNextInt()) {
                    option = sc.nextInt();
                } else
                    sc.next();

                if (option < 0 || option > 2)
                    throw new InputMismatchException("Not between 0 and 2.");
            } catch (InputMismatchException ex) {
                System.out.println("Invalid Option! -> " + ex.getMessage());
                continue;
            }
        } while (option < 0 || option > (!Game.featsUsed() ? 2 : 1));

        switch(option){
            case 1:
            Game.atack();
                break;
            case 2:
            Game.useFeats();
                break;
            case 3:
                break;
        }

    }

    public void run() {
        sc = new Scanner(System.in);
        
        while (!Quit) {
            IStates state = Game.getState();
            System.out.println("==========================================================");
            if (!(state instanceof AwaitBeginning))
                System.out.println(Game.CaracterText());

            if (state instanceof AwaitBeginning)
                uiAwaitBeginning();
            else if (state instanceof AwaitCardSelection)
                uiAwaitCardSelection();
            else if (state instanceof AwaitTrading)
                uiAwaitTrading();
            else if (state instanceof AwaitOptionSelection)
                uiAwaitOptionSelection();
            else if (state instanceof RolledDices)
                uiRolledDices();
            else if (state instanceof AwaitForSpell)
                uiaWaitForSpell();
            else if (state instanceof WaitForFeats)
                uiWaitForFealt();
            else if (state instanceof AwaitToEnd)
                uiAwaintToEnd();
        }
    }

    private void uiaWaitForSpell() {
        int option = 0;
        do {
            System.out.println("\t Using Spells!!");
            System.out.println("1 - Fire Spell [stock:" + Game.getStockForSell(2) + "]");
            System.out.println("2 - Ice Spell [stock:" + Game.getStockForSell(3) + "]");
            System.out.println("3 - Poison Spell [stock:" + Game.getStockForSell(4) + "]");
            System.out.println("4 - Heal Spell [stock:" + Game.getStockForSell(5) + "]");
            System.out.println("0 - Skip");
            System.out.println();
            System.out.print("-> ");
            try {
                if (sc.hasNextInt()) {
                    option = sc.nextInt();
                } else
                    sc.next();

                if (option < 0 || option > 4)
                    throw new InputMismatchException("Not between 0 and 4.");
            } catch (InputMismatchException ex) {
                System.out.println("Invalid Option! -> " + ex.getMessage());
                continue;
            }
        } while (option < 0 || option > 4);
        if (option != 0)
            if (Game.useSpells(option) == false) {
                System.out.println("no spell, no funny");
            }
        if (option == 0)
            Game.letsFight();
    }

    public void uiWaitForFealt() {
        int option = 0;
        do {
            for (int i = 0; i < ((WaitForFeats) Game.getState()).getNumberOfDices(); ++i) {
                System.out.println(" Dice " + (i + 1) + " : " + ((WaitForFeats) Game.getState()).getDiceNumber(i));
            }

            System.out.println("0 - Skip");
            System.out.print("-> ");

            try {
                if (sc.hasNextInt()) {
                    option = sc.nextInt();
                } else
                    sc.next();
                if (option < 0 || option > 4)
                    throw new InputMismatchException("Not between 0 and " + ((WaitForFeats) Game.getState()).getNumberOfDices() + ".");
            } catch (InputMismatchException ex) {
                System.out.println("Invalid Option! -> " + ex.getMessage());
                continue;
            }

            ((WaitForFeats) Game.getState()).analize(option);
            Game.backToRollDices();             // devia voltar ao RolledDices
            break;
        } while (option < 0 || option > ((WaitForFeats) Game.getState()).getNumberOfDices() - 1);
    }

    private void uiAwaintToEnd() {
               int option = 0;
        do {
            if(Game.win()==true)
                System.out.println("\tVictorious!!");
            else
                System.out.println("\t GameOver!!");
            System.out.println("1- New Game!");
            System.out.println("0- Quit");
            System.out.print("-> ");

            try {
                if (sc.hasNextInt()) {
                    option = sc.nextInt();
                } else
                    sc.next();
                if (option < 0 || option > 1)
                    throw new InputMismatchException("Not between 0 and 1.");
            } catch (InputMismatchException ex) {
                System.out.println("Invalid Option! -> " + ex.getMessage());
                continue;
            }
         
            
           
        } while (option < 0 || option > 1);
        
        if(option==0)
           Quit=true;
        else
            this.Game=new MiniRogue();
        
    }

    private void saveGame(String fileName) throws IOException {
        ObjectOutputStream oout = null;
        try {

            //Create an object output stream connected to a file named fileName.
            oout = new ObjectOutputStream(new FileOutputStream(fileName));

            //Write/serialize the game object to the open object output stream.
            oout.writeObject(Game);
        } catch(IOException e){
            return;
        }
        finally{
            
            //If the object output stream was successfuly created, close it.
            if(oout != null)
                try {
                    oout.close();
                }catch(IOException e){}
            
        }
    }

    private MiniRogue loadGame(String fileName) throws IOException, ClassNotFoundException  {
 
        MiniRogue loadedGame;
        ObjectInputStream oin = null;
        
        try {

            //Create an object input stream connected to a file named fileName.
            oin = new ObjectInputStream(new FileInputStream(fileName));
            
            //Retrieve a serialized instance of ThreeInRowGame from the object input stream and return a reference to it.
            loadedGame = (MiniRogue)oin.readObject();

            try{
                if(oin != null)
                    oin.close();
            } catch(IOException e){e.printStackTrace();}


        }finally{
            //If the object input stream was successfuly created, close it.
            if(oin != null)
                oin.close();
        }
        return loadedGame;
    
    }
    private void handleSaveGameToFileOption() {
        String fileName = null;
        
        System.out.print("SaveGame name: ");
         try {
            fileName = new BufferedReader(new InputStreamReader(System.in)).readLine();
        }catch(IOException e){}

        if(fileName==null)
            return;

        if(fileName.length() < 1)
            return;

        try {
            saveGame(fileName);
        } catch (IOException ex) {
            System.out.println("error saving game");
        }
    }
}


