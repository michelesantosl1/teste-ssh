package br.com.caelum.ed.vetores;

public class Vetor {

    private Aluno[] alunos = new Aluno [100000];
    private int totalDeAlunos = 0;

    public void adiciona (Aluno aluno) {
        this.garantaEspaco();
        this.alunos[this.totalDeAlunos] = aluno;
        this.totalDeAlunos++;
        
    } 

     public void adiciona(int posicao, Aluno aluno){

        if (!this.posicaoValida(posicao)){
            throw new IllegalArgumentException("Posição Invalilida");

        }
        for(int i = this.totalDeAlunos -1; i >= posicao; i--){
            this.alunos[i + 1] = this.alunos[i];
        } 
        this.alunos[posicao] = aluno;
        this.totalDeAlunos++;
    }
          /*Segunda maneira 
         
          public void adiciona(Aluno aluno) {
          this.alunos[this.totalDeAlunos] = aluno;
          this.totalDeAlunos++;
          }
        */

        public static void main(String[] args) {
            Vetor vetor = new Vetor();
            long inicio = System.currentTimeMillis();
            for (int i = 1; i < 100000; i++) {
            Aluno aluno = new Aluno();
            vetor.adiciona(aluno);
            }
            long fim = System.currentTimeMillis();
            double tempo = (fim - inicio) / 1000.0;
            System.out.println("Tempo em segundos = " + tempo);
            }

    private boolean posicaoValida(int posicao){
        return posicao >= 0 && posicao <= this.totalDeAlunos;
    }
    
        public Aluno pega (int posicao){
            if(!this.posicaoOcupada(posicao)){
                throw new IllegalArgumentException("Posição inválida");
            }
            return this.alunos(posicao);
        }  
        public void remove(int posicao){

            if(!this.posicaoOcupada(posicao)){
                throw new IllegalArgumentException("Posição inválida");
            }
            for(int i = posicao; i < this.totalDeAlunos - 1; i++){
                this.alunos[i] = this.alunos[i + 1];
            }
            this.totalDeAlunos--;
        }
        public boolean contem(Aluno aluno){
            for(int i = 0; i < this.alunos.length; i++){
                if(aluno == this.alunos[i]){
                    return true;
                }
            }
            return false;
        }
            public static void main(String[] args) {
                Vetor vetor = new Vetor();
                long inicio = System.currentTimeMillis();
                // Adicionado 100000 alunos e
                // Verificando se eles foram realmente adicionados.
                for (int i = 1; i < 30000; i++) {
                Aluno aluno = new Aluno();
                vetor.adiciona(aluno);
                if(!vetor.contem(aluno)){
                System.out.println("Erro: aluno " + aluno + " não foi adicionado.");
                }
                }
                // Verificando se o Vetor não encontra alunos não adicionados.
                for (int i = 1; i < 30000; i++) {
                Aluno aluno = new Aluno();
                if(vetor.contem(aluno)){
                System.out.println("Erro: aluno " + aluno + " foi adicionado.");
                }
                }
                long fim = System.currentTimeMillis();
                double tempo = (fim - inicio) / 1000.0;
        
                System.out.println("Tempo = " + tempo);
                }
        }
        public int tamanho(){
            return this.totalDeAlunos;
        }
        public String toString() {
            if(this.totalDeAlunos == 0) {
                return "[]";
            }
            StringBuilder builder = new StringBuilder();
            builder.append("[");
        }
        for (int i = 0; i < this.totalDeAlunos - 1; i++){
            builder.append(this.alunos[i]);
            builder.append(",");

        }
        builder.append(this.alunos[this.totalDeAlunos - 1]);
        builder.append("]");
        
        return builder.toString();    
    }  
    private boolean posicaoOcupada(int posicao){
        return posicao >= 0 && posicao < this.totalDeAlunos;
    }
    
    public void garantaEspaco(){
        if (this.totalDeAlunos == this.alunos.length){
            Aluno[] novaArray = new Aluno[this.alunos.length * 2];
            for (int i = 0; i < this.alunos.length; i++){
                novaArray[i] = this.alunos[i];
            }
            this.alunos = novaArray;
        }
    }
    public Aluno pega(int i) {
        return null;
    }
}
