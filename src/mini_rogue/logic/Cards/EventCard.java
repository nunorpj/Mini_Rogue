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
public class EventCard extends card {

    private int event = -1;

    public EventCard(GameData game) {
        super("Event Card", game);
        randamEvent();
    }

    private void randamEvent() {
        event = ThreadLocalRandom.current().nextInt(1, 7);
    }

    public int getEventNumber() {
        if (event == -1)
            return 0;
        else {
            System.out.println("Debug: event = " + event);
            return event;
        }
    }

    public String getMessage() {
        switch (event) {
            case -1:
                return null;
            case 1:
                return "You don’t know what this meat is, and you don’t care. Gain 1 Food.";
            case 2:
                return "A Monster’s favorite drink. Might as well drink a sip too. Gain 2 HP.";
            case 3:
                return "You’ve found a coin hidden in a crack between two stones. Gain 2 Gold.";
            case 4:
                return "You’ve found a Monster’s blade sharpening tools. Gain 2 XP.";
            case 5:
                return "A piece of armor found on a Monster’s carcass. Gain 1 Armor.";
            case 6:
                return "Fight!";
            default:
                return null;
        }
    }

    @Override
    public boolean resolveCard(int op) {

        getGame().setMensage(getMessage());

        switch (getEventNumber()) {
            case 0:
                return false;
            case 1:
                getGame().getCharacter().AddOrRemoveFood(1);
                break;
            case 2:
                getGame().getCharacter().AddOrRemoveHp(2);
                break;
            case 3:
                getGame().getCharacter().AddOrRemoveGold(2);
                break;
            case 4:
                getGame().getCharacter().AddOrRemoveXp(2);
                break;
            case 5:
                getGame().getCharacter().AddOrRemoveArmor(1);
                break;
            case 6:
                return true;
        }
        return false;
    }
}
