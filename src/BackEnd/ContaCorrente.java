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
public class ContaCorrente extends Conta{
    final float taxa = 1.889f;
    public ContaCorrente(int Agencia, int Numero){
        super (Agencia, Numero);
        this.Tipo = 1;
    }
    
    public boolean setSaque (float Valor){
        if(super.setSaque(Valor)){
            if(this.getSaldo()<0){
                this.saldo -= ((taxa*Valor)/100);
                this.extrato.add(new Extrato(5, ((taxa*Valor)/100)));
            }
            return true;
        }
        else{
            return false;
        }
    }
    
    public String getExtrato (){
        String txt = super.getExtrato();
        txt += "\nLimite: 500\nSaldo Total: " + (this.getSaldo() + 500); 
        return txt;
    }
    
}
