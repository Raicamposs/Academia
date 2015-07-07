/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.telas.ultilidades;

/**
 *
 * @author Raiane
 */
public abstract class FormataCampo {

    public static String formataDataBanco(String data) {
        String[] vetData;
        String[] vetNovaData = new String[3];
        vetData = (data.split("/"));
        for (int i = 2; i >= 0; i--) {
            vetNovaData[i] = vetData[i];
        }
        return vetNovaData[2] + "-" + vetNovaData[1] + "-" + vetNovaData[0];
    }

    public static String formataDataBancoAplicacao(String data) {
        String[] vetData = new String[3];
        vetData = (data.split("-"));
        return vetData[2].replace("-", "") + vetData[1].replace("-", "") + vetData[0].replace("-", "");
    }

    public static String formataDocumentosBanco(String doc) {
        doc = doc.replace(".", "");
        doc = doc.replace("-", "");
        return doc;
    }

}
