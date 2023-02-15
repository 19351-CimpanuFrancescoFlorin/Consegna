/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * Classe Main.
 *
 * @author <a href="19351@studenti.marconiverona.edu.it">Cimpanu Francesco Florin</a>
 * @version 1.0 20230215
 * @see Main
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Medico md1 = new Medico(12345, "Parini", "Giorio", "RHM569BV54D");
        Medico md2 = new Medico(14368, "Foscolo", "Ugo", "ITA456BV86T");
        Paziente paz1 = new Paziente(17984,"Cimpanu","Francesco","CMP056HQE71R","Verona");
        Paziente paz2 = new Paziente(14693,"Sofric","Kristian","FDK475FD43W","Vicenza");
        Paziente paz3 = new Paziente(10454,"Russo","Carmine","RYY649FJ278S","Napoli");
        Paziente paz4 = new Paziente(14825,"Suckman","Cheema","DGN358ZN30N","Trento");
        Paziente paz5 = new Paziente(11377,"Romano","Antonio","SDJ482ZF83F","Mantova");
        md1.AddPaziente(17984);
        md1.AddPaziente(14825);
        md2.AddPaziente(10454);
        md2.AddPaziente(11377);
        md1.AddPaziente(14693);
        paz1.setMedicoById(12345);
        paz2.setMedicoById(14368);
        paz3.setMedicoById(14368);
        paz4.setMedicoById(12345);
        paz5.setMedicoById(12345);
        System.out.println(paz1);
        System.out.println(paz1.getMedicoById());
        System.out.println(paz3.getMedicoById());
        System.out.println(paz3);
        System.out.println(md1);
        System.out.println(md2);
        System.out.println(md1.getMedicoById(14368));
        System.out.println(md1.toStringMedicoPazienti());
        System.out.println(paz1.toStringPazienteMedico());
    }
    
}
