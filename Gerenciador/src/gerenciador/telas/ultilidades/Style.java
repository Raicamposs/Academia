/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.telas.ultilidades;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 *
 * @author wagner
 */
public abstract class Style {

    public static void styleBorderEntered(JLabel label) {
        label.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 3));
    }

    public static void styleBorderExited(JLabel label) {
        label.setBorder(null);
    }

}
