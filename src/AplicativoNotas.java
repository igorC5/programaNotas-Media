import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AplicativoNotas {
    private JPanel AplicativoDeNotas;
    private JTextField input;
    private JTextArea txtNotas;
    private JButton btn_media;
    private JLabel status;


    ArrayList<String> notas = new ArrayList<>();

    public static void main(String[] args) {

        JFrame tela = new JFrame("Aplicativo de notas");
        tela.setContentPane(new AplicativoNotas().AplicativoDeNotas);
        tela.pack();
        tela.setSize(600,600);
        tela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        tela.setVisible(true);
    }

    public void updateNotas(ArrayList lista){

        txtNotas.setText("");
        for (int i = 0; i < lista.size(); i++) {
            txtNotas.setText(txtNotas.getText() + " \n" + lista.get(i) );
        }

    }

    public static double toNum(String x){
        return Double.parseDouble(x);
    }

    public AplicativoNotas(){

        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println(toNum(input.getText()));
                notas.add(input.getText());
                updateNotas(notas);
                input.setText("");

            }
        });

        btn_media.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double soma = 0;

                for (int i = 0; i < notas.size(); i++) {
                    soma += Double.parseDouble(notas.get(i));
                }

                double mediaFinal = soma / notas.size();

                if (mediaFinal >= 7){
                    status.setText("STATUS: APROVADO \n SOMA TOTAL: "+ soma + "\n MEDIA FINAL: " + mediaFinal);
                }else {
                    status.setText("STATUS: REPROVADO \n SOMA TOTAL: "+ soma + "\n MEDIA FINAL: " + mediaFinal);
                }
            }
        });
    }
}
