/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public abstract class Conta {
    
    private int Agencia;
    private int Numero;
    protected float saldo;
    protected ArrayList<Extrato> extrato;
    protected int Tipo;
    
    
    public Conta(int Agencia, int Numero){
      this.Agencia = Agencia;
      this.Numero = Numero;
      this.saldo = 0;  
      this.extrato = new ArrayList<Extrato>();
    }

    public String getTipo(){
        if(this.Tipo == 1)
            return "Corrente";
        else
            return "Poupança";
    }
    
    public boolean IsCorrente(){
        if(this.Tipo == 1)
            return true;
        else
            return false;
    }
    
    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getAgencia() {
        return Agencia;
    }

    public void setAgencia(int Agencia) {
        this.Agencia = Agencia;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }
    
    public void setDeposito(float Valor){
        if(Valor>0){
            this.saldo += Valor;
            this.extrato.add(new Extrato(1, Valor));
        }
        else{
            JOptionPane.showMessageDialog(null, "Depósito não realizado. Valor inferior a 0.");
        }
    }
    
    public boolean setSaque(float Valor){
        if(this.saldo + 500 >= Valor){
           this.saldo -= Valor;
            JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
            this.extrato.add(new Extrato (2, Valor));
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Saque não realizado. Saldo insuficiente.");
            return false;
        }
    }
    
    public String getExtrato () {
        if (this.extrato.isEmpty()){
            return "Essa conta ainda não possui Transações." + "\nSaldo: " + this.saldo;
               
        }
        else{
            String txt = "";
            for(int i=0; i<this.extrato.size(); i++){
                txt = txt + (0 + i) + " - " + this.extrato.get(i).getTipo() + ": " + 
                this.extrato.get(i).getValor() + "\n";
            }
            txt = txt + "\nSaldo: " + this.saldo;
            return txt;
        }
    }
    
    public void transferencia(Conta c,float valor){
          if(this.saldo + 500 >= valor){
              this.saldo -= valor;
              c.saldo += valor;
              this.extrato.add(new Extrato (4, valor));
              if(this.saldo<0){
                  this.saldo-= valor * 1.889f/100;
                  this.extrato.add(new Extrato (5,valor*1.889f/100));
              }
              c.extrato.add(new Extrato (3,valor));
              JOptionPane.showMessageDialog(null, "Transferencia efetuada com sucesso!");
          }
          else{
              JOptionPane.showMessageDialog(null, "Transferencia não efetuada. Valor Insuficiente");
          }
    }
    
}