/**
 *
 * @author <a href="19351@studenti.marconiverona.edu.it">Cimpanu Francesco Florin</a>
 * @version 1.0 20230419
 * 
 */
package it.edu.marconiverona;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.widgets.Listener;

public class Main {

    public static void main(String[] args) {
        
        //------------------------------------
        // istanza finestra principale root
        //------------------------------------
        Display display = new Display();
        Shell root = new Shell(display);
        root.setLayout(new GridLayout(5,true));

        //---- Istanze oggetti grafici + model + control=> CallBack/Listener
        //------------------------------------
        // istanze degli oggetti grafici
        //------------------------------------
        Label myLabel01 = new Label(root, SWT.NORMAL);
        myLabel01.setText("operatore 1");
        Text myField01 = new Text(root, SWT.BORDER);
        myField01.setSize(10, 1);
        Label myLabel05 = new Label(root, SWT.NORMAL);
        myLabel05.setText("");
        Label myLabel06 = new Label(root, SWT.NORMAL);
        myLabel06.setText("");
        Label myLabel07 = new Label(root, SWT.NORMAL);
        myLabel07.setText("");
        
        Label myLabel02 = new Label(root, SWT.NORMAL);
        myLabel02.setText("operatore 2");
        Text myField02 = new Text(root, SWT.BORDER);
        Label myLabel08 = new Label(root, SWT.NORMAL);
        myLabel08.setText("");
        Label myLabel09 = new Label(root, SWT.NORMAL);
        myLabel09.setText("");
        Label myLabel010 = new Label(root, SWT.NORMAL);
        myLabel010.setText("");
       
        Label myLabel03 = new Label(root, SWT.NORMAL);
        myLabel03.setText("operazione ");
        Button myButton01 = new Button(root, SWT.PUSH);
        myButton01.setText("+");
        Button myButton02 = new Button(root, SWT.PUSH);
        myButton02.setText("-");
        Button myButton03 = new Button(root, SWT.PUSH);
        myButton03.setText("*");
        Button myButton04 = new Button(root, SWT.PUSH);
        myButton04.setText("/");
        
        Label myLabel04 = new Label(root, SWT.NORMAL);
        myLabel04.setText("risultato");
        Text myField03 = new Text(root, SWT.BORDER);
        Label myLabel011 = new Label(root, SWT.NORMAL);
        myLabel011.setText("");
        Label myLabel012 = new Label(root, SWT.NORMAL);
        myLabel012.setText("");
        Label myLabel013 = new Label(root, SWT.NORMAL);
        myLabel013.setText("");

        // Operazioni sulla finestra principale
        root.pack(); 
        root.open();

        //------------------------------------
        // repository view
        // Nota: viene usato il blocco staic  on the fly  della classe
        // HashMap per far eseguire in un metodo static i put delle key-Object
        //------------------------------------
        Map<String, Object> repository_View = new HashMap<String, Object>() {
            {
                put("root", root);
                put("myLabel01", myLabel01);
                put("myLabel02", myLabel02);
                put("myLabel03", myLabel03);
                put("myLabel04", myLabel04);
                put("myLabel05", myLabel05);
                put("myLabel06", myLabel06);
                put("myLabel07", myLabel07);
                put("myLabel08", myLabel08);
                put("myLabel09", myLabel09);
                put("myLabel010", myLabel010);
                put("myLabel011", myLabel011);
                put("myLabel012", myLabel012);
                put("myLabel013", myLabel013);
                put("myButton01", myButton01);
                put("myButton02", myButton02);
                put("myButton03", myButton03);
                put("myButton04", myButton04);  
                put("myField01", myField01);
                put("myField02", myField02);
                put("myField03", myField03);
            }
        };

        //------------------------------------
        // Istanza di una classe capace di fare una elaborazione
        //------------------------------------
        Operazione operazioni_model = new Operazione();

        //------------------------------------
        // repository model
        //------------------------------------
        Map<String, Object> repository_Model = new HashMap<String, Object>() {
            {
                // costruttore della classe, non dell'istanza
                put("operazioni_model", operazioni_model);
            }
        };

        //------------------------------------
        // istanze oggetti  aventi interface Listener : Listener / CallaBack
        //------------------------------------
        Listener myButton01_listener
                = new Listener() {
            @Override
            public void handleEvent(Event e) {
                // legge contenuto delle TextEdit myField01 e myField02
                Text myField01 = (Text) Repository.repository_View.get("myField01");
                String text1 = myField01.getText();

                Text myField02 = (Text) Repository.repository_View.get("myField02");
                String text2 = myField02.getText();

                // recupera l'oggetto model per i calcoli
                Operazione op_model = (Operazione) Repository.repository_Model
                        .get("operazioni_model");

                // aggiorna il campo  myFiel
                try{
                    int operatore1 = Integer.parseInt(text1);
                    int operatore2 = Integer.parseInt(text2);
                    myField03.setText(""
                        + op_model.somma(operatore1,
                                operatore2));
                }catch (NumberFormatException ex){
                    myField03.setText("Format error");
                }
            }
        };
        
        Listener myButton02_listener
                = new Listener() {
            @Override
            public void handleEvent(Event e) {
                // legge contenuto delle TextEdit myField01 e myField02
                Text myField01 = (Text) Repository.repository_View.get("myField01");
                String text1 = myField01.getText();

                Text myField02 = (Text) Repository.repository_View.get("myField02");
                String text2 = myField02.getText();

                // recupera l'oggetto model per i calcoli
                Operazione op_model = (Operazione) Repository.repository_Model
                        .get("operazioni_model");

                // aggiorna il campo  myFiel
                try{
                    int operatore1 = Integer.parseInt(text1);
                    int operatore2 = Integer.parseInt(text2);
                    myField03.setText(""
                        + op_model.differenza(operatore1,
                                operatore2));
                }catch (NumberFormatException ex){
                    myField03.setText("Format error");
                }

            }
        };
        
        Listener myButton03_listener
                = new Listener() {
            @Override
            public void handleEvent(Event e) {
                // legge contenuto delle TextEdit myField01 e myField02
                Text myField01 = (Text) Repository.repository_View.get("myField01");
                String text1 = myField01.getText();

                Text myField02 = (Text) Repository.repository_View.get("myField02");
                String text2 = myField02.getText();

                // recupera l'oggetto model per i calcoli
                Operazione op_model = (Operazione) Repository.repository_Model
                        .get("operazioni_model");

                // aggiorna il campo  myFiel
                try{
                    int operatore1 = Integer.parseInt(text1);
                    int operatore2 = Integer.parseInt(text2);
                    myField03.setText(""
                        + op_model.moltiplicazione(operatore1,
                                operatore2));
                }catch (NumberFormatException ex){
                    myField03.setText("Format error");
                }

            }
        };
        
        Listener myButton04_listener
                = new Listener() {
            @Override
            public void handleEvent(Event e) {
                // legge contenuto delle TextEdit myField01 e myField02
                Text myField01 = (Text) Repository.repository_View.get("myField01");
                String text1 = myField01.getText();

                Text myField02 = (Text) Repository.repository_View.get("myField02");
                String text2 = myField02.getText();

                // recupera l'oggetto model per i calcoli
                Operazione op_model = (Operazione) Repository.repository_Model
                        .get("operazioni_model");

                // aggiorna il campo  myFiel
                try{
                    int operatore1 = Integer.parseInt(text1);
                    int operatore2 = Integer.parseInt(text2);
                    myField03.setText(""
                        + op_model.divisione(operatore1,
                                operatore2));
                }catch (NumberFormatException ex){
                    myField03.setText("Format error");
                }

            }
        };

        //------------------------------------
        // repository listener o callback
        //------------------------------------
        Map<String, Object> repository_Listener = new HashMap<String, Object>() {
            {
                // costruttore della classe, non dell'istanza
                put("myButton01_listener", myButton01_listener);
                put("myButton02_listener", myButton02_listener);
                put("myButton03_listener", myButton03_listener);
                put("myButton04_listener", myButton04_listener);
            }
        };

        //------------------------------------
        // inizializza il repository (ovvero l'App)
        //------------------------------------
        Repository.repository_View = repository_View;
        Repository.repository_Model = repository_Model;
        Repository.repository_Listener = repository_Listener;

        //------------------------------------
        // inizializza gli oggetti view che attivano i bottoni
        //------------------------------------
        myButton01.addListener(SWT.MouseDown,
                (Listener) Repository.repository_Listener.get("myButton01_listener"));
        myButton02.addListener(SWT.MouseDown,
                (Listener) Repository.repository_Listener.get("myButton02_listener"));
        myButton03.addListener(SWT.MouseDown,
                (Listener) Repository.repository_Listener.get("myButton03_listener"));
        myButton04.addListener(SWT.MouseDown,
                (Listener) Repository.repository_Listener.get("myButton04_listener"));

        //------------------------------------
        // finche'  la finestra non viene chiusa _
        //        { se ci sono eventi leggi coda degli eventi => esegui
        //          altrimenti in attesa }
        //-------------------------------------          
        while (!root.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();

    }
}