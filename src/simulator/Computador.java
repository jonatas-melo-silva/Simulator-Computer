/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator;

/**
 *
 * @author jonatas-melo
 */
public class Computador {
    private Integer registrador[];
    private Integer pilha[];
    private int sp;
    private Integer Mdados[];
    private String Minstrucao[];
    private int mi;
    private int pc;
    private String ir;
    private int md;
    
    public Computador(){
        this.registrador = new Integer[10];
        this.pilha = new Integer[10];
        this.Mdados = new Integer[10];
        this.Minstrucao = new String[10];
        this.mi = 9;
        this.pc = 0;
        this.ir = this.Minstrucao[9];
        this.sp = 9;
        this.md = 9;
    }
    
    public boolean push(int index){
        if (sp >= 0) {
            if (this.registrador[index] == null) {
                return false;
            }
            this.pilha[sp] = this.registrador[index];
            setMd(this.pilha[sp]);
            this.sp--;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean and(){
        if (this.pilha[8] == null) {
            return false;
        } else {
            this.pilha[sp+2] = (this.pilha[sp+1] & this.pilha[sp+2]);
            setMd(this.pilha[sp+2]);
            this.pilha[sp+1] = null;
            this.sp++;
            return true;
        }
    }
    
    public boolean not(){
        if (this.pilha[9] == null) {
            return false;
        } else {
            this.pilha[sp+1] = ~(this.pilha[sp+1]);
            setMd(this.pilha[sp+1]);
            return true;
        }
    }
    
    public boolean mult(){
        if (this.pilha[8] == null) {
            return false;
        } else {
            this.pilha[sp+2] = (this.pilha[sp+1] * this.pilha[sp+2]);
            setMd(this.pilha[sp+2]);
            this.pilha[sp+1] = null;
            this.sp++;
            return true;
        }
    }
    
    public boolean div(){
        if (this.pilha[8] == null) {
            return false;
        } else {
            this.pilha[sp+2] = (this.pilha[sp+1] / this.pilha[sp+2]);
            setMd(this.pilha[sp+2]);
            this.pilha[sp+1] = null;
            this.sp++;
            return true;
        }
    }
    
    public boolean sub(){
        if (this.pilha[8] == null) {
            return false;
        } else {
            this.pilha[sp+2] = (this.pilha[sp+1] - this.pilha[sp+2]);
            setMd(this.pilha[sp+2]);
            this.pilha[sp+1] = null;
            this.sp++;
            return true;
        }
    }
    
    public boolean add(){
        if (this.pilha[8] == null) {
            return false;
        } else {
            this.pilha[sp+2] = (this.pilha[sp+1] + this.pilha[sp+2]);
            setMd(this.pilha[sp+2]);
            this.pilha[sp+1] = null;
            this.sp++;
            return true;
        }
    }
    
    public boolean pop(int index){
        if(this.sp < 9){
            this.sp++;
            this.registrador[index] = this.pilha[this.sp];
            setMd(registrador[index]);
            this.pilha[this.sp] = null;
            return true;
        }else{
            return false;
        }
    }
    
    
    public boolean removerMI(){
        if (this.mi < 9) {
            this.mi++;
            this.pc--;
            this.Minstrucao[mi] = null;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean adicionarMI(String instrucao){
        if (mi >= 0) {
            this.Minstrucao[mi] = instrucao;
            mi--;
            this.pc++;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean mov(int index, int valor){
        if(index <= this.registrador.length-1 || index >= 0) {
            this.registrador[index] = valor;
            setMd(this.registrador[index]);
            return true;
        }
        return false;
    }

    public void setMd(int dado) {
         if(md >= 0){
            System.out.print("antes mov"+md);
            this.Mdados[md] = dado;
            this.md--;
            System.out.println("\t"+md);
        }else{
            this.md = 9;
            System.out.print("antes mov"+md);
            this.Mdados[md] = dado;
            this.md--;
            System.out.println("\t"+md);
        }
    }
    

    public Integer[] getRegistrador() {
        return registrador;
    }

    public void setRegistrador(Integer[] registrador) {
        this.registrador = registrador;
    }

    public Integer[] getPilha() {
        return pilha;
    }

    public void setPilha(Integer[] pilha) {
        this.pilha = pilha;
    }

    public Integer[] getMdados() {
        return Mdados;
    }

    public void setMdados(Integer[] Mdados) {
        this.Mdados = Mdados;
    }

    public String[] getMinstrucao() {
        return Minstrucao;
    }

    public void setMinstrucao(String[] Minstrucao) {
        this.Minstrucao = Minstrucao;
    }

    public String getIr() {
        return ir;
    }

    public void setIr(String ir) {
        this.ir = ir;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public int getMi() {
        return mi;
    }

    public void setMi(int mi) {
        this.mi = mi;
    }
    
    
}
