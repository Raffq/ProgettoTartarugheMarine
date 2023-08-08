package Gui.MedicoVeterinarioGUI;

import javax.swing.*;
import java.awt.*;

public class Medico_VeterinarioTemp extends JFrame {
    private JButton compilaComponente;
    private JButton compilaCartellaClinica;
    private JButton modificaComponente;
    private JButton modificaCartellaClinica;
    public Medico_VeterinarioTemp(){
        super("Medico veterinario");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        setLayout(flowLayout);

        compilaComponente = new JButton();
        compilaCartellaClinica = new JButton();
        modificaComponente = new JButton();
        modificaCartellaClinica = new JButton();

        

        add(compilaComponente);
        add(compilaCartellaClinica);
        add(modificaComponente);
        add(modificaCartellaClinica);

        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
