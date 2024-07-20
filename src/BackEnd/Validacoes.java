package BackEnd;


import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rafael
 */
public class Validacoes {
    
    /**
    * Check if is Integer
    */
    public boolean IsInt(JTextField TextField, String Campo){
        try{
            int i = Integer.parseInt(TextField.getText());
            return true;    
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Valor invalido para:" + Campo + "\nInforme um valor Inteiro", "Erro de Entrada",JOptionPane.ERROR_MESSAGE);
            TextField.setText("");
            TextField.requestFocus();
            return false;
        }
    }
    
    /**
    * Check if is Float
    */
    public boolean IsFloat(JTextField TextField, String Campo){
        try{
            float f = Float.parseFloat(TextField.getText());
            return true;    
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Valor invalido para:" + Campo + "\nInforme um valor real", "Erro de Entrada",JOptionPane.ERROR_MESSAGE);
            TextField.setText("");
            TextField.requestFocus();
            return false;
        }
    }
    
    /**
    * Check if greater than zero
    */
    public boolean isGTZ(JTextField TextField){
        float f = 0;
        f = Float.parseFloat(TextField.getText());
        if (f>0){
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "O valor não é maior que zero");
            return false;
        }
    }
    
    /**
    * Check if is empty
    */
    public boolean isEmpty(JTextField TextField, String Campo){
        String s = TextField.getText();
        if (s.equals("")){
            JOptionPane.showMessageDialog(null, "Não foi informado nenhum valor no campo: " + Campo, "Erro de Entrada",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    } 
    
    /**
    * Check if Combobox is selected
    */
    public boolean IsSelected(JComboBox Combobox, String Campo){
        if(Combobox.getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Selecione uma opção para o campo: " + Campo, "Erro de Entrada",JOptionPane.ERROR_MESSAGE);
            Combobox.requestFocus();
            return false;
        }
        else
            return true;
    }
 
    /**
    * Check if ButtonGroup is selected
    */
    public boolean IsSelected(ButtonGroup buttonGroup, String Campo){
        if(buttonGroup.getSelection() == null){
            JOptionPane.showMessageDialog(null, "Selecione uma opção para o campo: " + Campo, "Erro de Entrada",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else
            return true;
    }
}
