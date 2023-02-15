
import java.util.HashMap;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * Classe Paziente.
 *
 * @author <a href="19351@studenti.marconiverona.edu.it">Cimpanu Francesco Florin</a>
 * @version 1.0 20230215
 * @see Paziente
 */
public class Paziente {
    private long id;
    private long id_medico;
    private String cognome;
    private String nome;
    private String codice_fis;
    private String domicilio;
    private static Map<Long, Paziente> pazienti = new HashMap<>();

    /**
     *
     * @param id
     * @param cognome
     * @param nome
     * @param codice_fis
     * @param domicilio
     */
    public Paziente(long id, String cognome, String nome, String codice_fis, String domicilio) {
        this.id = id;
        this.id_medico = 0L;
        this.cognome = cognome;
        this.nome = nome;
        this.codice_fis = codice_fis;
        this.domicilio = domicilio;
        this.pazienti.put(this.id, this);
    }

    public static Map<Long, Paziente> getPazienti() {
        return pazienti;
    }

    /**
     *
     * @return cognome
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @return cognome
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
    
    /**
     *
     * @param id
     */
    static Paziente getPazienteById(long id) {
        return Paziente.pazienti.get(id);
    } 
    
    /**
     *
     * @param Id
     */
    public void removePaziente(long Id){
        this.pazienti.remove(id);
    }

    /**
     *
     * @param id
     */
    public void setMedicoById(long id){
        this.id_medico = id;
    }
    
    /**
     *
     * @return
     */
    public long getMedicoById(){
        return this.id_medico;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Paziente{" + "id=" + id + ", cognome=" + cognome + ", nome=" + nome + ", codice_fis=" + codice_fis + '}';
    }

    /**
     *
     * @return
     */
    public String toStringPazienteMedico(){
        return "Pazienti{" +  "id=" + id + ", cognome=" + cognome + ", nome=" + nome + ", codice_fis=" + codice_fis + ", medico=" +  this.getMedicoById() + '}';
    }
}
