/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.logic.Cards.Monsters;

import java.util.concurrent.ThreadLocalRandom;
import mini_rogue.logic.GameData;
import mini_rogue.logic.Spells.*;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class BossMonsterCard extends Monster {

public BossMonsterCard(GameData game) {
        super("Boss Monster", game);
    }
    public BossMonsterCard(int lvl, int area, GameData game) {
  
        super("Boss Monster", game);
          switch (lvl) {
            case 1:

                super.setHp(10);
                super.setDmg(3);
                super.setName("Undead Giant");
                super.setReward(2);
                break;
            case 2:
                super.setHp(15);
                super.setDmg(5);
                super.setName("Skeleton Lord");
                super.setReward(3);
                break;
            case 3:
                super.setHp(20);
                super.setDmg(7);
                super.setName("Undead Lord");
                super.setReward(4);
                break;
            case 4:
                super.setHp(25);
                super.setDmg(9);
                super.setName("Serpent Demon");                
                super.setReward(5);

                break;
            case 5:
                super.setHp(30);
                super.setDmg(12);
                super.setReward(5);
                super.setName("Og's Remains");
                break;

        }
    }
    
        public void rewardBoss() {
        switch (ThreadLocalRandom.current().nextInt(1, 7)) {
            case 0:
                return;
            case 1:
                getGame().getCharacter().AddOrRemoveArmor(1);
                getGame().setMensage("Armor Piece -> Immediately gain 1 Armor.");
                break;
            case 2:
                getGame().getCharacter().AddOrRemoveXp(2);
                getGame().setMensage("Better Weapon -> Immediately gain 2 XP.");
                break;
            case 3:
                getGame().getCharacter().AddSpell(new FireSpell());
                getGame().setMensage("Fireball Spell -> In combat, inflict 8 damage to a Monster.");
                break;
            case 4:
                getGame().getCharacter().AddSpell(new IceSpell());
                getGame().setMensage("Ice Spell -> In combat, freeze a Monster for one turn. The Monster does not counterattack.");
                break;
            case 5:
                getGame().getCharacter().AddSpell(new PoisonSpell());
                getGame().setMensage("Poison Spell -> In Combat, for the remainder of the Combat sequence, inflict 5 extra damage per turn.");
                break;
            case 6:
                getGame().getCharacter().AddSpell(new HealSpell());
                getGame().setMensage("Healing Spell -> Gain 8 HP in Combat or before resolving a Room card.");
                break;
        }
        switch(getGame().getDungeonLvl()){
            case 1:
                getGame().getCharacter().AddOrRemoveGold(2);
                break;
            case 2:
                getGame().getCharacter().AddOrRemoveGold(2);
                break;
            case 3:
                getGame().getCharacter().AddOrRemoveGold(3);
                break;
            case 4:
                getGame().getCharacter().AddOrRemoveGold(3);
                break;
                
        }
    }

}
