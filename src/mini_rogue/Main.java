/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue;

import mini_rogue.logic.MiniRogue;
import mini_rogue.textUI.TextUI;

/**
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Main {

    public static void main(String[] args) {
        TextUI textUI = new TextUI(new MiniRogue());
        textUI.run();

    }
}
