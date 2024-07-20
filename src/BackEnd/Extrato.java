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
public class Extrato {
    
    private int Tipo; 
    //1- Deposito, 2-Saque, 3-Crédito de Transferencia, 4-Débito de Transferencia
    private float Valor;
    
    public Extrato(int Tipo, float Valor){
        this.Tipo = Tipo;
        this.Valor = Valor;
    }

    public String getTipo() {
        if(this.Tipo == 1){
            return "Deposito";
        }
        else if(this.Tipo == 2){
            return "Saque";
        }
        else if(this.Tipo == 3){
            return "Crédito de Transferencia";
        }
        else if(this.Tipo == 4){
            return "Débito de Transferencia";
        }
        else if(this.Tipo == 5){
            return "Imposto limite";
        }
        else{
            return "Imposto de Saque excedente";
        }
    }

    public void setTipo(int Tipo) {
        this.Tipo = Tipo;
    }

    public float getValor() {
        return Valor;
    }

    public void setValor(float Valor) {
        this.Valor = Valor;
    }
    
    
}