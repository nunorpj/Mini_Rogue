/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.logic.Cards;

import mini_rogue.logic.GameData;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TrapCard extends card {
    private int rand = -1;

    public TrapCard(GameData game) {
        super("Trap Card", game);
        rand = ThreadLocalRandom.current().nextInt(1, 7);
    }

    public int getTrapNumber() {
        if (rand == -1)
            return 0;
        else {
            System.out.println("Debug: trap = " + rand);
            return rand;
        }
    }

    public String getMessage() {
        switch (rand) {
            case -1:
                return null;
            case 1:
                return "A terrible stench seems to have added a layer of white and blue hair on your meat. Lose 1 Food ration.";
            case 2:
                return "You tripped and fell hard to the ground. A Gold piece was ejected from your bag. Lose 1 Gold.";
            case 3:
                return "Powerful acid falls from the ceiling and damages your equipment. Lose 1 Armor.";
            case 4:
                return "You walked on a pressure plate and jumped just in time to avoid losing your head. Lose 1 HP.";
            case 5:
                return "Moving walls were about to crush you, but you sacrificed your sword to save yourself. Lose 1 XP.";
            case 6:
                return "You fell into a hole and landed a Level below. You broke a bone.";
            default:
                return null;
        }
    }

    @Override
    public boolean resolveCard(int op) {


        getGame().setMensage(getMessage());
        switch (getTrapNumber()) {
            case 0:
                return false;
            case 1:
                getGame().getCharacter().AddOrRemoveFood(-1);
                break;
            case 2:
                getGame().getCharacter().AddOrRemoveGold(-1);
                break;
            case 3:
                getGame().getCharacter().AddOrRemoveArmor(-1);
                break;
            case 4:
                getGame().getCharacter().AddOrRemoveHp(-1);
                break;
            case 5:
                getGame().getCharacter().AddOrRemoveXp(-1);
                break;
            case 6:
                getGame().getCharacter().AddOrRemoveHp(-2);
                if (getGame().getDungeonLvl() < 5) {
                    int lvl = getGame().getDungeonLvl();
                    int area = getGame().getArea();
                    lvl++;
                    area = area < 5 ? area + 2 : area + 3;
                    getGame().setDungeonLvlArea(lvl, area);
                }
        }
        return true;
    }
}
