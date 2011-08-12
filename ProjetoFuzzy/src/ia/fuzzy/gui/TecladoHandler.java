/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.fuzzy.gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author gabriel
 */
public class TecladoHandler extends KeyAdapter {
    private FuzzyGUI gui;
    private String label;

    public TecladoHandler(FuzzyGUI gui, String label){
        this.gui = gui;
        this.label = label;
    }

    @Override
    public void keyPressed(KeyEvent ke)
        {
            switch(ke.getKeyCode())
            {
                // Enter
                case 10:
                {
                   System.out.println("Apertou Enter");
                    if (label.equals("Temperatura")) {
                        //gui.setTemperaturaInput();
                    }
                    if (label.equals("Volume")) {
                        gui.setVolumeInput();
                    }
                }
            }
        }

}
