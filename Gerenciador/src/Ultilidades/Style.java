/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ultilidades;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 *
 * @author wagner
 */
public class Style {
    public static void styleBorder(JLabel label) {
     label.setBorder(BorderFactory.createLineBorder(Color.ORANGE));  
    }
}
