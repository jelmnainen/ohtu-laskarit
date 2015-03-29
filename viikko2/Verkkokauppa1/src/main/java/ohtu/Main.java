package ohtu;

import ohtu.verkkokauppa.Kauppa;
import ohtu.verkkokauppa.Kirjanpito;
import ohtu.verkkokauppa.Pankki;
import ohtu.verkkokauppa.Varasto;
import ohtu.verkkokauppa.Viitegeneraattori;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        
        ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/resources/spring-context.xml");

        Kirjanpito kirjanpito = new Kirjanpito();
        Kauppa kauppa = ctx.getBean(Kauppa.class);

        // kauppa hoitaa yhden asiakkaan kerrallaan seuraavaan tapaan:
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(3);
        kauppa.lisaaKoriin(3);
        kauppa.poistaKorista(1);
        kauppa.tilimaksu("Pekka Mikkola", "1234-12345");

        // seuraava asiakas
        kauppa.aloitaAsiointi();
        for (int i = 0; i < 24; i++) {
            kauppa.lisaaKoriin(5);
        }

        kauppa.tilimaksu("Arto Vihavainen", "3425-1652");

        // kirjanpito
        for (String tapahtuma : kirjanpito.getTapahtumat()) {
            System.out.println(tapahtuma);
        }
    }
    
    public static int[][][] multipleNestedFors(){
            int[][][] matrix = new int[10][10][10];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                for (int k = 0; k < matrix.length; k++) {
                    matrix[i][j][k] = 0;   
                }
            }
        }
        return matrix;
    }
    
    public static int[][][] multipleNestedForsDuplicate(){
            int[][][] matrix = new int[10][10][10];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                for (int k = 0; k < matrix.length; k++) {
                    matrix[i][j][k] = 0;   
                }
            }
        }
        return matrix;
    }
    
    public static String multipleNestedIfs(int n){
        
        if(n>10){
            if(n<50){
                if(n == 42){
                    return "It is the meaning of Life!";
                }
            }
        }
        
        return "it wasn't the meaning of life :(";
        
    }
}
