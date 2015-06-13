/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.telas.ultilidades;

import gerenciador.telas.*;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Raiane
 */
public class FuncoesJanelas {

    public static void navegador(String url, JFrame frame) {
        try {
            Desktop.getDesktop().browse(new URI(
                    url));
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.setExtendedState(LoginGUI.ICONIFIED);
    }


}
