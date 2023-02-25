package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
  public static void main(String[] args) {
    String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto"}; 
    for(String candidato : candidatos) {
      entrandoEmContato(candidato);
    }
    
    selecaoCandidatos();
    imprimirSelecionados();
  }
  
  static void entrandoEmContato(String candidato) {
    int tentativasRealizadas = 1;
    boolean continuarTentando = true;
    boolean atendeu = false;
    do{
      atendeu = atender();
      continuarTentando = !atendeu;
      if(continuarTentando) {
        tentativasRealizadas++;
      }else {
        System.out.println("Contato realizado com sucesso");
      }
    }while(continuarTentando && tentativasRealizadas < 3);
    
    if (atendeu) {
      System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativa.");
    }else {
      System.out.println("N�o conseguimos contato com " + candidato + ", n�mero m�ximo de tentativas (" + tentativasRealizadas + ") atingido.");
    }
      
  }
  
  static boolean atender() {
    return new Random().nextInt(3)==1;
  }
  
  static void selecaoCandidatos() {
    String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto", "Monica", "Fabricio", "Mirela", "Daniela", "Jorge"};
    int candidatosSelecionados = 0;
    int candidatoAtual = 0;
    double salarioBase = 2000.00;
    
    while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
      String candidato = candidatos[candidatoAtual];
      double salarioPretendido = valorPretendido();

      System.out.println("O candidato solicitou " + candidato + " solicitou este valor de sal�rio: " + salarioPretendido);
      if(salarioBase >= salarioPretendido) {
        System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
        candidatosSelecionados++;
      }
      candidatoAtual++;
    }
  }
  
  static void imprimirSelecionados() {
    String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto"}; 
    System.out.println("Imprimindo a lista de candidatos informando o �ndice do elemento.");
    
    for(int indice = 0; indice < candidatos.length; indice++) {
      System.out.println("O candidato de n� " + (indice + 1) + " � o " + candidatos[indice] );
    }
    
    System.out.println("Forma abreviada de intera��o for each");
    for(String candidato : candidatos) {
      System.out.println("O candidato selecionado foi " + candidato);
    }
  }
  
  static double valorPretendido() {
    return ThreadLocalRandom.current().nextDouble(1800,2200);
  }
  
  static void analisarCandidato(double salarioPretendido) {
    double salarioBase = 2000.00;
    if(salarioBase > salarioPretendido) {
      System.out.println("Ligar para o candidato");
    }else if(salarioBase == salarioPretendido) {
      System.out.println("Ligar para o candidato com contraproposta");
    }else {
      System.out.println("Aguardando o resultado dos demais candidatos");
    }
  }
}
