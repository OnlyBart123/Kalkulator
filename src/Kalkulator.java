import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Akcja implements ActionListener{
    private int nr;
    static int suma;
    static int nowa;
    private JLabel sumaLabel;
    private JLabel nowaLabel;

    public Akcja(int n, JLabel sumaLabel, JLabel nowaLabel){
        nr=n;
        this.sumaLabel = sumaLabel;
        this.nowaLabel=nowaLabel;
    }
    public void actionPerformed(ActionEvent e){
        if(nr>1){
            if(nowa==0){
                nowa=nr-2;
            }
            else{
                nowa=nowa*10+(nr-2);
            }
        }
        if(nr==1){
            suma=suma+nowa;
            nowa=0;
        }
        if(nr==0){
            nowa=0;
            suma=0;
        }
        sumaLabel.setText("SUMA: " + suma);
        nowaLabel.setText("NOWA:" + nowa);
    }
    public int getSuma(){
        return suma;
    }
    public int getNowa(){
        return nowa;
    }
}

public class Kalkulator {


    public static void main(String[] args){
        JFrame rama = new JFrame("Kalkulator");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 3, 3, 3)); // Ustawienie układu siatki


        JLabel sumaLabel = new JLabel("SUMA: 0");
        JLabel nowaLabel= new JLabel("NOWA: 0");
        panel.add(sumaLabel);
        panel.add(nowaLabel);
        panel.add(new JLabel(""));

        String[] przyciski = {"C", "+", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        JButton[] klawisz = new JButton[przyciski.length];

        for (int i = 0; i < przyciski.length; i++) {
            klawisz[i] = new JButton(przyciski[i]);
            panel.add(klawisz[i]);
            klawisz[i].addActionListener(new Akcja(i, sumaLabel,nowaLabel));
        }
        rama.add(panel);
        rama.setSize(300, 400);
        rama.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        rama.setVisible(true);
    }
}
