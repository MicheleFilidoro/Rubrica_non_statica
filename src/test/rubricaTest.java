package test;
import org.junit.jupiter.api.AfterEach;
import rubrica.Rubrica;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class rubricaTest{
    @AfterEach
    void Clear(){
        Rubrica.clear();
    }

    @Test
    void aggiungiCorrettamente(){
        Rubrica r1= new Rubrica("amici", 7);
        Rubrica r2= new Rubrica("casa", 5);
        int nEl1= r1.numEl();
        int nEl2= r2.numEl();
        int ris1= r1.aggiungi("Paolo=3313987");
        int ris2=r2.aggiungi("Ciccio=3235666");
        assertEquals(nEl1+1,r1.numEl());
        assertEquals(nEl2+1,r2.numEl());
    }

    @Test
    void aggiungiSenzaNomeCorrettamente(){
        Rubrica r1= new Rubrica(7);
        Rubrica r2= new Rubrica("Amici");
        int nEl1= r1.numEl();
        int nEl2= r2.numEl();
        int ris1= r1.aggiungi("Paolo=3313987");
        int ris2=r2.aggiungi("Ciccio=3235666");
        assertEquals(nEl1+1,r1.numEl());
        assertEquals(nEl2+1,r2.numEl());
    }

    @Test
    void aggiungiTroppi(){
        Rubrica r1= new Rubrica("amici", 3);
        int nEl1=r1.numEl();
        int ris1=r1.aggiungi("Pino=3935353");
        int ris2=r1.aggiungi("Ciao=3935353");
        int ris3=r1.aggiungi("Zio=3935353");
        int ris4=r1.aggiungi("Zino=3935353");
        assertEquals(3, r1.numEl());
    }

    @Test
    void ricercaUno(){
        Rubrica r1= new Rubrica("amici", 1);
        int ris1=r1.aggiungi("Pino=32323");
        int num=r1.ricerca("Pino").size();
        assertEquals(1,num);
    }

    @Test
    void elimina(){
        Rubrica r1= new Rubrica("amici", 7);
        Rubrica r2= new Rubrica("casa", 5);
        int ris1= r1.aggiungi("Paolo=3313987");
        int ris2=r2.aggiungi("Ciccio=3235666");
        int nEl1= r1.numEl();
        int nEl2= r2.numEl();
        r1.elimina("Paolo");
        r2.elimina("Ciccio");
        assertEquals(nEl1-1,r1.numEl());
        assertEquals(nEl2-1,r2.numEl());
    }
    @Test
    void lista(){
        Rubrica r1= new Rubrica("amici", 2);
        int ris1=r1.aggiungi("Pino=3935353");
        int ris2=r1.aggiungi("Ciao=3935353");
        assertEquals(r1.toString(),"Pino=3935353,Ciao=3935353,");
    }

    @Test
    void nome(){
        Rubrica r1=new Rubrica(2);
        r1.setNome("Amici");
        assertEquals(r1.getNome(),"Amici");
    }


}