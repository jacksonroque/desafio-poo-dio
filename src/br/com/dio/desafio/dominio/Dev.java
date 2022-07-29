package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {

    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();// LinkedHashSet só termite que adicione conteudo único
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();// polimorfismo eh usado aqui porque eu estou estanciando (new ) o LinkedHashSet através da classe mãe Set


    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());// pegou todos os conteudo de bootcamp (getConteudo) e colocou dentro de ConteudosInscritos
        bootcamp.getDevsInscritos().add(this); // adiciona o Dev no bootcamp
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();//Optional resolve retornos nulos
        if(conteudo.isPresent()){ // isPresent = existir
            this.conteudosConcluidos.add(conteudo.get());// coloca dentro de ConteudoConcluidos.
            this.conteudosInscritos.remove(conteudo.get());
        }else { // caso a lista de conteudos esteja vazia exibi mensagem de erro
            System.err.println("você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calcularTotalXp() {
        /**
         * foi usado stream
         * pegou cada conteudo de dentro do set ConteudosConcluidos
         * pegou o xp de cada conteudo
         */
        return this.conteudosConcluidos.stream().mapToDouble(conteudo -> conteudo.calcularXp()).sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
