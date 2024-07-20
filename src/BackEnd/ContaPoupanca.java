/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

/**
 *
 * @author Rafael
 */
public class ContaPoupanca extends Conta {
    
    private int TotalSaques;
    
    public ContaPoupanca(int Agencia, int Numero){
        super (Agencia, Numero);
        this.TotalSaques = 0;
        this.Tipo = 2;
    }
    
    public boolean setSaque (float Valor){
        if(super.setSaque(Valor)){
            this.TotalSaques ++;
            
            if(this.TotalSaques>=5){
                this.saldo -= 1.80f;
                this.extrato.add(new Extrato(6, 1.80f));
            }
            return true;
        }
        else{
            return false;
        }
    }
    
}