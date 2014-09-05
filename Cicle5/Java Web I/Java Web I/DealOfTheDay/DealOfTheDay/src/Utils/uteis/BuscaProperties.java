/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package uteis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Administrador
 */
public class BuscaProperties {

    private static InputStream is = null;

 //*********************** busca properties em arquivo ********************************
    public static Properties emArquivo(String caminhoProperties) {
        Properties temp = new Properties();
        InputStream inputStream2 = BuscaProperties.class.getClassLoader().getResourceAsStream(caminhoProperties);//"servicos/acessobasico.properties");
        setIs(inputStream2);
        try {
            temp.load( getIs() );
        } catch (IOException ex) {
          String mensagem_erro;  mensagem_erro = "Erro ao executar buscarPropertiesBasicasEmArquivo" ;     mensagem_erro += ex.getMessage();
          System.out.println(mensagem_erro);
        }
        return temp;
    }

    public static void setIs(InputStream is) {
        BuscaProperties.is = is;
    }

    public static InputStream getIs() {
        return is;
    }
}
