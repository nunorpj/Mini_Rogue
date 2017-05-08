/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.logic;

import java.io.Serializable;
import mini_rogue.logic.Cards.*;

import java.util.ArrayList;
import java.util.Collections;
import mini_rogue.logic.Cards.Monsters.BossMonsterCard;
import mini_rogue.logic.Cards.Monsters.MonsterCard;
import mini_rogue.logic.states.IStates;

/**
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */

public class GameData implements Serializable {

    private int area;
    private Character Hero;
    private int DungeonLvl;
    private int Dificulty;
    private ArrayList<card> cards;
    private int Collunlvl;
    private boolean lvlMonsterDead;
    private boolean featsUsed;
    private boolean win=false;
    private String mensage;
    private IStates lastStat; 

    public GameData() {
        this.area = 1;
        this.Collunlvl = 1;
        this.Dificulty = 2;//normal
        this.DungeonLvl = 1;
        lvlMonsterDead = false;
        featsUsed = false;
        mensage = "";
        Hero = new Character();
        cards = new ArrayList<>();//cartas viradas para baixo e ter outra com as cartas viradas para cima??
    }                           //ou simplesmente ter um int que guarda a coluna em que vamos e apartir dai 

    //mostrar as que estao para tras e esconder as que estao para a frente
    public int getArea() {
        return this.area;
    }

    public void SetStartingArea(int lvl) {
        this.area = lvl;
        setCards();
        this.Collunlvl = 1;
        if (this.area > 0 && this.area <= 2)
            this.DungeonLvl = 1;
        if (this.area > 2 && this.area <= 4)
            this.DungeonLvl = 2;
        if (this.area > 4 && this.area <= 7)
            this.DungeonLvl = 3;
        if (this.area > 7 && this.area <= 10)
            this.DungeonLvl = 4;
        if (this.area > 10 && this.area <= 14)
            this.DungeonLvl = 5;

        lvlMonsterDead = false;
    }

    public void SetDificulty(int lvl) {
        this.Dificulty = lvl;
        switch (lvl) {
            case 1:                     //armor,hp,gold,food
                Hero.setCharacterStatos(1, 5, 5, 6);//casual
                break;
            case 2:
                Hero.setCharacterStatos(0, 5, 3, 6);//normal
                break;
            case 3:
                Hero.setCharacterStatos(0, 4, 2, 5);//hard
                break;
            case 4:
                Hero.setCharacterStatos(0, 3, 1, 3);//impossible
                break;
        }
    }

    public int getDificulty() {
        return this.Dificulty;
    }

    public boolean initialize() {//preparar o jogo
        setCards(); //meter as cartas viradas para baixo
        return true;
    }

    public String CharacterText() {//foi para testar as caractristicas do "heroi"
        return Hero.toString();
    }


    private void setCards() {

        randomCardsSelection();
    }

    public String CardOnTableToString() {
        String str = "";
        if (!mensage.isEmpty()) {
            str += mensage;
            str += "\n";
            mensage = "";
        }

        switch (this.Collunlvl) {
            case 1:
                str = str + "\t#\n";
                break;
            case 2:
                str = str + "\t    #\n";
                break;
            case 3:
                str = str + "\t\t      #\n";
                break;
            case 4:
                str = str + "\t\t\t      #\n";
                break;
            case 5:
                str = str + "\t\t\t\t      #\n";
                break;

        }
        if (this.Collunlvl >= 2)
            str = str + "     \t" + cards.get(1).getName();
        else
            str = str + "\t\tCard";

        if (this.Collunlvl >= 4)
            str = str + "\t" + cards.get(4).getName() + "\n\n";
        else
            str = str + "\t\tCard" + "\n\n";

        str = str + cards.get(0).getName();//primeira coluna aparece sempre
        if (this.Collunlvl >= 3)
            str = str + "  \t" + cards.get(3).getName();
        else
            str = str + "\t\tCard";
        if (this.Collunlvl == 5 && cards.size() == 7)//isto porque se naquele nivel nao houver boss
            str = str + "\t" + cards.get(6).getName() + "\n\n";//nao se mete no ARRAYLIST
        else if (this.Collunlvl < 5 && cards.size() == 7)
            str = str + "\t\tCard" + "\n\n";
        else
            str = str + "\n\n";
        if (this.Collunlvl >= 2)
            str = str + "     \t" + cards.get(2).getName();
        else
            str = str + "\t\tCard";

        if (this.Collunlvl >= 4)
            str = str + "\t" + cards.get(5).getName();
        else
            str = str + "\t\tCard";

        return str;
    }

    public void setDungeonLvlArea(int dungeonLvl, int area) {
        this.DungeonLvl = dungeonLvl;
        this.area = area;
        this.Collunlvl = 1;
        lvlMonsterDead = false;
        setCards();
    }

    public int getCollun() {
        return this.Collunlvl;
    }

    public String CardNameAtIndex(int index) {
        return cards.get(index).getName();
    }

    public card getCard(int index) {
        return cards.get(index);
    }

    public int GetGold() {
        return Hero.getGold();
    }

    public Character getCharacter() {
        return this.Hero;
    }

    public void nexColumm() {
        this.Collunlvl++;
    }

    public int getArmor() {
        return Hero.getArmor();
    }

    public int GetHowManySpells(int i) {
        return Hero.GetHowManySpells(i);
    }

    public void setMensage(String mensage) {
        this.mensage = mensage;
    }
    public String getMensage() {
        String s = this.mensage;
        this.mensage="";
        return s;
    }

    public int getDungeonLvl() {
        return DungeonLvl;
    }

    public boolean isLvlMonsterDead() {
        return lvlMonsterDead;
    }

    public void monsterDead() {
        this.lvlMonsterDead = true;
    }

    public boolean isFeatsUsed() {
        return featsUsed;
    }

    public void setFeatsUsed(boolean featsUsed) {
        this.featsUsed = featsUsed;
    }

    public ArrayList<Dice> getDiceList() {
        return Hero.getDices();
    }


    private void randomCardsSelection() {

        cards.clear();
        cards.add(new MonsterCard(this));
        cards.add(new RestingCard(this));
        cards.add(new TreasureCard(this));
        cards.add(new TrapCard(this));
        cards.add(new MerchantCard(this));
        cards.add(new EventCard(this));
        Collections.shuffle(cards);

        if (this.area == 2 || this.area == 4 || this.area == 10 || this.area == 14)
            cards.add(new BossMonsterCard(this));
    }
    public void win(){
        this.win=true;
        
    }
    public boolean isaWinner(){
        return this.win;
    }
    public void setLastState(IStates s){
        this.lastStat=s;
    }
    
    public IStates getLastState(){
        return this.lastStat;
    }
}
