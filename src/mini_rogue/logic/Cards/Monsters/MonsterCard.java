/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.logic.Cards.Monsters;

import java.util.concurrent.ThreadLocalRandom;
import mini_rogue.logic.GameData;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class MonsterCard extends Monster {

    public MonsterCard(GameData game) {
        super("Monster Card", game);
    }
    public MonsterCard(int lvl, int area, GameData game) {
            super("Monster Card",game);
            
                  switch (lvl) {
            case 1:

                super.setHp(ThreadLocalRandom.current().nextInt(1, 6 + 1) + area);
                super.setDmg(2);
                super.setReward(1);
                super.setName("Undead Soldier");
                break;
            case 2:
                super.setHp(ThreadLocalRandom.current().nextInt(1, 6 + 1) + area);
                super.setDmg(4);
                super.setReward(1);
                super.setName("Skeleton");
                break;
            case 3:
                super.setHp(ThreadLocalRandom.current().nextInt(1, 6 + 1) + area);
                super.setDmg(6);
                super.setReward(2);
                super.setName("Undead Knight");
                break;
            case 4:
                super.setHp(ThreadLocalRandom.current().nextInt(1, 6 + 1) + area);
                super.setDmg(8);
                super.setReward(2);
                super.setName("Serpent Knight");
                break;
            case 5:
                super.setHp(ThreadLocalRandom.current().nextInt(1, 6 + 1) + area);
                super.setDmg(10);
                super.setReward(3);
                super.setName("Og's Sanctum Guard");
                break;

        }
    }


}
