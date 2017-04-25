/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.logic.Cards;

import mini_rogue.logic.GameData;

/**
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class MerchantCard extends card {

    public MerchantCard(GameData game) {
        super("Merchant Card", game);
    }

    @Override
    public boolean resolveCard(int op) {

        return false;
    }
}
