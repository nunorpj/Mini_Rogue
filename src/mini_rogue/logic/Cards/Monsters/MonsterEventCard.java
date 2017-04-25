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
public class MonsterEventCard extends Monster { 

     public MonsterEventCard(GameData game) {
        super("Event Monster", game);

    }
    
    public MonsterEventCard(int lvl, int area, GameData game) {
            super("Event Monster ",game);
            super.setName("Event Monster");
            switch (lvl) {
            case 1:

                super.setHp(ThreadLocalRandom.current().nextInt(1, 6 + 1) + area);
                super.setDmg(2);
                super.setReward(2);
                break;
            case 2:
                super.setHp(ThreadLocalRandom.current().nextInt(1, 6 + 1) + area);
                super.setDmg(4);
                super.setReward(2);
                break;
            case 3:
                super.setHp(ThreadLocalRandom.current().nextInt(1, 6 + 1) + area);
                super.setDmg(6);
                super.setReward(2);
                break;
            case 4:
                super.setHp(ThreadLocalRandom.current().nextInt(1, 6 + 1) + area);
                super.setDmg(8);
                super.setReward(2);
                break;
            case 5:
                super.setHp(ThreadLocalRandom.current().nextInt(1, 6 + 1) + area);
                super.setDmg(10);
                super.setReward(2);
                break;

        }
        
    }

}
