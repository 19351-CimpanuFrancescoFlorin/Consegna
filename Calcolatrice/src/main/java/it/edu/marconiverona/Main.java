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
        root.setLayout(new GridLayout(2,true));

        //---- Istanze oggetti grafici + model + control=> CallBack/Listener
        //------------------------------------
        // istanze degli oggetti grafici
        //------------------------------------
        Label myLabel01 = new Label(root, SWT.NORMAL);
        myLabel01.setText("operatore 1");
        Text myField01 = new Text(root, SWT.BORDER);
        Label myLabel02 = new Label(root, SWT.NORMAL);
        myLabel02.setText("operatore 2");
        Text myField02 = new Text(root, SWT.BORDER);
        Label myLabel03 = new Label(root, SWT.NORMAL);
        myLabel03.setText("operazione");
        /*
        Button myButton0 = new Button(root, SWT.PUSH);
        myButton0.setText("+");
        Button myButton02 = new Button(root, SWT.PUSH);
        myButton02.setText("-");
        Button myButton03 = new Button(root, SWT.PUSH);
        myButton03.setText("*");
        Button myButton04 = new Button(root, SWT.PUSH);
        myButton04.setText("/");
        */
        ToolBar toolBar = new ToolBar(root, SWT.BORDER);
        ToolItem myButton01 = new ToolItem(toolBar, SWT.PUSH);
        myButton01.setText("+");
        ToolItem myButton02 = new ToolItem(toolBar, SWT.PUSH);
        myButton02.setText("-");
        ToolItem myButton03 = new ToolItem(toolBar, SWT.PUSH);
        myButton03.setText("*");
        ToolItem myButton04 = new ToolItem(toolBar, SWT.PUSH);
        myButton04.setText("/");
        Label myLabel04 = new Label(root, SWT.NORMAL);
        myLabel04.setText("risultato");
        Text myField03 = new Text(root, SWT.BORDER);

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
        myButton01.addListener(SWT.Selection,
                (Listener) Repository.repository_Listener.get("myButton01_listener"));
        myButton02.addListener(SWT.Selection,
                (Listener) Repository.repository_Listener.get("myButton02_listener"));
        myButton03.addListener(SWT.Selection,
                (Listener) Repository.repository_Listener.get("myButton03_listener"));
        myButton04.addListener(SWT.Selection,
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