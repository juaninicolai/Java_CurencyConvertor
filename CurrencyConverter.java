package module2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CurrencyConverter {

  private JFrame frame;
  private JPanel panel;
  private JButton button;
  private JTextField field1;
  private JTextField field2;
  private JLabel dkk;
  private JLabel usd;
  private JOptionPane pane;


  CurrencyConverter(){

    frame = new JFrame("Currency Converter");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 100);
    frame.setLocationRelativeTo(null);
    frame.add(panel = new JPanel());
    panel.add(dkk = new JLabel("DKK"));
    panel.add(field1 = new JTextField(6));
    panel.add(usd = new JLabel("USD"));
    panel.add(field2 = new JTextField(6));
    panel.add(button = new JButton("Convert"));
    frame.setVisible(true);


    //ActionListener
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (field2.getText().equals("") && !field1.getText().equals("")) {
          field2.setText(dkkToUsd(field1.getText()));
        }  else if (field1.getText().equals("") && !field2.getText().equals("")){
            field1.setText(usdToDkk(field2.getText()));
        } else error();
      }
    });
  }

  public double checkInput(String currencyString){
    double currencyDouble = -1;
    try {
      return currencyDouble = Double.parseDouble(currencyString);
    } catch(NumberFormatException e){
        System.out.println("Wrong input type!");
    } return currencyDouble;
  }

  public void error(){
    JOptionPane.showMessageDialog(frame, "Something went wrong! Check the text fields", "Oops", JOptionPane.ERROR_MESSAGE);
    field1.setText("");
    field2.setText("");
  }

  public String dkkToUsd(String usd) {
    if (checkInput(usd) <= 0) {
      error();
      return "";
    } else {
      double doubleUsd = Double.parseDouble(usd);
      return String.valueOf(doubleUsd * 6.11);
    }
  }


  public String usdToDkk(String dkk) {
    if (checkInput(dkk) <= 0) {
      error();
      return "";
    } else {
      double doubleDkk = Double.parseDouble(dkk);
      return String.valueOf(doubleDkk * 0.16);
    }
  }

  public static void main (String[] args){
    new CurrencyConverter();
  }

}
