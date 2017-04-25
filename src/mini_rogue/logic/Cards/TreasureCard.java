/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.logic.Cards;

import mini_rogue.logic.GameData;
import mini_rogue.logic.Spells.FireSpell;
import mini_rogue.logic.Spells.HealSpell;
import mini_rogue.logic.Spells.IceSpell;
import mini_rogue.logic.Spells.PoisonSpell;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TreasureCard extends card {

    private int rand = -1;

    public TreasureCard(GameData game) {
        super("Treasure Card", game);
        rand = ThreadLocalRandom.current().nextInt(1, 7);
    }


    public int getTreasureNumber() {
        if (rand == -1)
            return 0;
        else {
            System.out.println("Debug: trap = " + rand);
            return rand;
        }
    }

    public String getMessage() {            // falta modificar
        switch (rand) {
            case -1:
                return null;
            case 1:
                return "Armor Piece -> Immediately gain 1 Armor.";
            case 2:
                return "Better Weapon -> Immediately gain 2 XP.";
            case 3:
                return "Fireball Spell -> In combat, inflict 8 damage to a Monster.";
            case 4:
                return "Ice Spell -> In combat, freeze a Monster for one turn. The Monster does not counterattack.";
            case 5:
                return "Poison Spell -> In Combat, for the remainder of the Combat sequence, inflict 5 extra damage per turn.";
            case 6:
                return "Healing Spell -> Gain 8 HP in Combat or before resolving a Room card.";
            default:
                return null;
        }
    }

    @Override
    public boolean resolveCard(int op) {

        getGame().setMensage(getMessage());

        if (getGame().isLvlMonsterDead())
            getGame().getCharacter().AddOrRemoveGold(2);
        else
            getGame().getCharacter().AddOrRemoveGold(1);

        switch (getTreasureNumber()) {
            case 0:
                return false;
            case 1:
                getGame().getCharacter().AddOrRemoveArmor(1);
                break;
            case 2:
                getGame().getCharacter().AddOrRemoveXp(2);
                break;
            case 3:
                getGame().getCharacter().AddSpell(new FireSpell());
                break;
            case 4:
                getGame().getCharacter().AddSpell(new IceSpell());
                break;
            case 5:
                getGame().getCharacter().AddSpell(new PoisonSpell());
                break;
            case 6:
                getGame().getCharacter().AddSpell(new HealSpell());
                break;
        }
        return true;
    }
}
