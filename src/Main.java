import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();


        //System.out.println(curso1);
        curso1.setTitulo("curso java");
        curso1.setDescricao("descricao curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descricao curso js");
        curso2.setCargaHoraria(4);


        /**
         * polimorfimo. TUDO que tem em Conteudo  tem em Curso
         * Mas NEM TUDO que TENHO em Curso TENHO em Conteudo
         */
        Conteudo conteudo = new Curso();
        Conteudo conteudo1 = new Mentoria();

        List<String> palavras = new ArrayList<>(); // polimorfismo, instanciou (new) o ArrayList a partir do List
        // Tudod que tem em List em dentro de ArrayList, mas nem tudo que tem dentro de ArrayList tem dentro de List

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descricao mentoria java");
        mentoria.setData(LocalDate.now());

//        System.out.println(curso1);
//        System.out.println(curso2);
//        System.out.println(mentoria);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developter");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1); //adiciona o conteúdo no curso
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devCammila = new Dev(); // instanciou o devCamila
        devCammila.setNome("Camila");// coloca nome Camila em devCamila
        devCammila.inscreverBootcamp(bootcamp);// inscrever no bootcamp
        System.out.println("Conteúdos Incritos " + devCammila.getConteudosInscritos());// imprimi os conteudos inscritos
        devCammila.progredir();// exibe o progresso em conteudos incrito que sao 3 (Java, Js e Mentoria)
        devCammila.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Incritos " + devCammila.getConteudosInscritos());// conteudos inscritos
        System.out.println("Conteúdos Concluídos Camila:" + devCammila.getConteudosConcluidos());
        System.out.println("XP:" + devCammila.calcularTotalXp());

        System.out.println("---------");

        Dev devJoao = new Dev();
        devJoao.setNome("Joao"); // coloca o nome Joao
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Incritos" + devJoao.getConteudosInscritos());
        devJoao.progredir();// essa linha informa o progresso as 3 linhas repetidas informa que Joao concluiu o bootcamp
        devJoao.progredir();
        devJoao.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Incritos" + devJoao.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos Joao" + devJoao.getConteudosConcluidos());
        System.out.println("XP:" +devJoao.calcularTotalXp());






    }
}
