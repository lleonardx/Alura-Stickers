//Aula 01
// Desafio 01 - Buscar as Series
 for (int i = 0; i < 3; i++) {
 Map<String, String> filme = listaDeFilmes.get(i);
 System.out.println(filme.get("title"));
 System.out.println(filme.get("image"));
 System.out.println(filme.get("imDbRating"));
 System.out.println();
}

// Desafio 02 - Decorar o terminal
 for (int i = 0; i < 3; i++) {
 Map<String, String> filme = listaDeFilmes.get(i);
 System.out.println("\u001b[1mTítulo: \u001b[m" + filme.get("title"));
 System.out.println("\u001b[1mURL da Imagem: \u001b[m" + filme.get("image"));
 System.out.println("" + filme.get("imDbRating"));
  System.out.println("");
 double classificacao = Double.parseDouble(filme.get("imDbRating"));
 int numeroEstrelinhas = (int) classificacao;

 for (int n = 1; n <= numeroEstrelinhas; n++) {
  System.out.print("");
 }
 System.out.println("\n");

}