package com.example.exemplomodelos_de_comunicacao;

import android.widget.TextView;

public class PrecisaCalcular {

    TextView tv;
    public PrecisaCalcular(TextView tv){
        this.tv=tv;
    }

    public String calculoLocal(int oper){
        Calculadora calc = new Calculadora();
        String result="";
        if(oper == 1){
            result= calc.soma(20.0,20.0)+"";
        }
        if(oper == 2){
            result= calc.subtracao(20.0,20.0)+"";
        }
        if(oper == 3){
            result= calc.multiplicacao(20.0,20.0)+"";
        }
        if(oper == 4){
            result= calc.divisao(20.0,20.0)+"";
        }
        return result;
    }
    /*
    public String [] calculoLocal(){
        Calculadora calc = new Calculadora();
        String result= calc.subtracao(20.0,20.0)+"";
        String result2 = calc.soma(20.0,20.0)+"";
        String [] results = new String[2];
        results[0] = result;
        results[0] = result2;
        return results;
    }*/

    public void calculoRemoto(int operacao){
        CalculadoraSocket shs = new CalculadoraSocket(this, "15", "18", operacao);
        shs.execute();

    }

    public void calculoRemotoHTTP(int operacao){
        CalculadoraHttpPOST shs = new CalculadoraHttpPOST(this, "15", "18", operacao);
        shs.execute();

    }
    public void result_calculoRemoto(String result){
        tv.setText(result);
    }

}
