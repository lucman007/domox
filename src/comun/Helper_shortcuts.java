package comun;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.KeyStroke;
import javax.swing.text.JTextComponent;
import Controlador.ControladorPedido;

/**
 *
 * @author Luciano Ces
 */
public class Helper_shortcuts {

    private JInternalFrame frame;
    private JDialog dialog;
    private int key;
    private String actionKey;
    private JTextComponent componente;

    //shortcuts para Internal frames
    public Helper_shortcuts(JInternalFrame frame, int key, String actionKey, JTextComponent componente, ControladorPedido controladorPedido) {
        this.frame = frame;
        this.key = key;
        this.actionKey = actionKey;
        this.componente = componente;
    }

    public void frame_putKeys() {

        this.frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(key, 0), actionKey);
        this.frame.getRootPane().getActionMap().put(actionKey, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame_acciones();
            }
        });
    }

    private void frame_acciones() {
        switch (this.actionKey) {
            case "buscar":
                this.componente.setText("");
                this.componente.requestFocus();
                break;
            case "escape":
                this.frame.dispose();
                //Script para traer al frente ventana pedidos cuando se cierra ventana historial con "ESC"
                break;
            case "historial":
                ControladorPedido controladorPedido = new ControladorPedido();
                controladorPedido.iniciar_historial();
                break;
        }
    }

    //shortcuts para diálogos
    public Helper_shortcuts(JDialog dialog, int key, String actionKey) {
        this.dialog = dialog;
        this.key = key;
        this.actionKey = actionKey;
    }

    public void dialog_putKeys() {

        this.dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(key, 0), actionKey);
        this.dialog.getRootPane().getActionMap().put(actionKey, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dialog_acciones();
            }
        });
    }

    private void dialog_acciones() {
        switch (this.actionKey) {
            case "escape":
                this.dialog.dispose();
                break;
        }
    }
}
