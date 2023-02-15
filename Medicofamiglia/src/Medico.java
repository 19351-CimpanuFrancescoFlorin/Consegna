
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * Classe Medico.
 *
 * @author <a href="19351@studenti.marconiverona.edu.it">Cimpanu Francesco Florin</a>
 * @version 1.0 20230215
 * @see Medico
 */
public class Medico {
    private long id;
    private String cognome;
    private String nome;
    private String codice_fis;
    private List<Long> lista_paz = new ArrayList<>();
    static Map<Long, Medico> medici = new HashMap<>();

    /**
     *
     * @param id
     * @param cognome
     * @param nome
     * @param codice_fis
     */
    public Medico(long id, String cognome, String nome, String codice_fis) {
        this.id = id;
        this.cognome = cognome;
        this.nome = nome;
        this.codice_fis = codice_fis;
        this.medici.put(this.id,this);
    }

    /**
     *
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getCognome() {
        return cognome;
    }

    /**
     *
     * @param cognome
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public String getCodice_fis() {
        return codice_fis;
    }

    /**
     *
     * @param codice_fis
     */
    public void setCodice_fis(String codice_fis) {
        this.codice_fis = codice_fis;
    }

    static Medico getMedicoById(long id) {
        return Medico.medici.get(id);
    } 
    
    /**
     *
     * @param Id
     */
    public void removeMedico(long Id){
        this.medici.remove(id);
    }
    
    /**
     *
     * @param Id_paziente
     */
    public void AddPaziente(long Id_paziente){
        this.lista_paz.add(Id_paziente);
    }
    
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Medico{" + "id=" + id + ", cognome=" + cognome + ", nome=" + nome + ", codice_fis=" + codice_fis + '}';
    }

    /**
     *
     * @return
     */
    public String toStringMedicoPazienti(){
        return "Medico{" + "id=" + id + ", cognome=" + cognome + ", nome=" + nome + ", codice_fis=" + codice_fis + ", Lista pazienti" + lista_paz + '}';
    }
    
    public String toStringMedicoPazienti_Parte2(){
        String stringa = "Medico{" + "id=" + id + ", cognome=" + cognome + ", nome=" + nome + ", codice_fis=" + codice_fis + ", Lista pazienti=[\n";
        for(Long paz : lista_paz){
            stringa += Paziente.getPazienti().get(paz) + "\n";
        }
        stringa += "]}";
        return stringa;
    }
}
