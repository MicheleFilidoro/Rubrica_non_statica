package rubrica;
import java.util.ArrayList;
public class Rubrica {
    private ArrayList<String> rubrica;
    private ArrayList<String> ret;
    private static int DEFAULT_MAX_DIM;
    public static String DEFAULT_NOME;
    private static int numRubriche;

    static{
        DEFAULT_NOME = "Rubrica n.";
        DEFAULT_MAX_DIM = 6;
        numRubriche = 0;
    };

    public Rubrica(String nome, int maxDim){
        DEFAULT_MAX_DIM=maxDim;
        DEFAULT_NOME=nome;
        rubrica=new ArrayList<String>();
        numRubriche++;
    }
    public Rubrica(String nome){
        this(nome,DEFAULT_MAX_DIM);
    }
    public Rubrica(int maxDim){
        this(DEFAULT_NOME + numRubriche, maxDim);
    }
    public Rubrica(){
        this(DEFAULT_MAX_DIM);
    }

    public int numEl(){
        return rubrica.size();
    }

    public int aggiungi(String string){
        if(rubrica.contains(string)) return 0;
        if(rubrica.size()>=DEFAULT_MAX_DIM) return -1;
        rubrica.add(string);
        return 1;
    }

    public ArrayList<String> ricerca(String string){
        ret= new ArrayList<String>();
        for (int i=0;i<rubrica.size();i++){
            if(rubrica.get(i).contains(string)){
                ret.add(rubrica.get(i));
            }
        }
        return ret;
    }

    public boolean elimina(String string){
        return rubrica.removeAll(ricerca(string));
    }

    public String toString(){
        String ritorna="";
        for(int i=0;i<rubrica.size();i++){
            ritorna+=rubrica.get(i)+",";
        }
        return ritorna;
    }

    public static void clear(){
        numRubriche=0;
    }

    public String getNome(){
        return DEFAULT_NOME;
    }

    public void setNome(String stringa){
        this.DEFAULT_NOME=stringa;
    }


}
