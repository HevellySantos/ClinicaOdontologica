/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaodontologica;

import java.util.Scanner;

public class Menu {

    Scanner entrada = new Scanner(System.in);

    public void menu() {
        //VARIAVEIS
        int opcao = 0;
        String nomepac = null, novoNome = "null", dataC = null, horaC = null;
        int idadepac = 0, conveniopac = 0, novaIdade = 0, novoConvenio = 0, posicao = 0, nTrat = 0;

// INSTANCIAS 
//        Tratamento trat = new Tratamento();
//        Paciente pac = new Paciente("", 0, 0);
//        Dentista dent = new Dentista("", "");
//        Consulta con = new Consulta();
        Clinica cli = new Clinica();

        //INCLUINDO DADOS NAS ARRAYS
        cli.adicionarPacientesSist(nomepac, idadepac, conveniopac);
        cli.incluirDentistas("", "");
        cli.incluirTratamentos("", 0);

        do {
            System.out.print("""
\n***** CLINICA ODONTOLOGICA *****
Escolha uma das opcoes abaixo:
1. Cadastrar paciente                             
2. Agendar Consulta
3. Verificar Consultas
4. Alterar Cadastro Paciente
5. Alterar Consulta   
6. Verificar cadastros pacientes 
7. Excluir Cadastro Paciente
8. Excluir Consulta                                                                                                                                                                                                                
0. Sair do Programa\n """);
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
//CADASTRANDO O PACIENTE                    
                    System.out.print("Digite o nome do paciente: ");
                    nomepac = entrada.nextLine();

                    System.out.print("Digite a idade do paciente: ");
                    idadepac = entrada.nextInt();

                    System.out.println("""
        Qual o convenio do paciente?
        1. Amil
        2. Bradesco
        3. SulAmerica
        4. NotreDame
        5. Unimed """);
                    conveniopac = entrada.nextInt();

                    cli.adicionarPaciente(nomepac, idadepac, conveniopac);
                    break;
                case 2:
// AGENDANDO A CONSULTA

                    //data da consulta
                    System.out.println("Digite a data da consulta na seguinte maneira: DD/MM/AAAA");
                    dataC = entrada.next();

                    //hora da consulta
                    System.out.println("Digite a hora da consulta na seguinte maneira: HH:MM");
                    horaC = entrada.next();

                    //Selecionando o Tratamento
                    double vConsulta = 0;
                    cli.menuTratamentos();
                    System.out.println("Digite o tratamento desejado: ");
                    nTrat = entrada.nextInt() - 1;
//                    cli.tratamentos(nTrat);

                    //Selecionando o Dentista
                    int nDent = 0;
                    cli.listarDentistas();
                    System.out.println("Digite o número do dentista que vai realizar a consulta: ");
                    nDent = (entrada.nextInt() - 1);

                    //Selecionando o Paciente
                    int nPac = 0;
                    cli.exibirPacientes();
                    System.out.println("Digite o indice do paciente para marcar a consulta: ");
                    nPac = (entrada.nextInt() - 1);

                    //ADICIONANDO A ARRAY
                    cli.adicionarConsulta(dataC, horaC, nPac, nDent, nPac);

                    break;
                case 3:
// VERIFICANDO AS CONSULTAS         
                    cli.listarConsulta();

                    break;
                case 4:
// ALTERANDO O CADASTRO DO PACIENTE                    
                    System.out.println("Digite a posicao do paciente a ser alterado: ");
                    posicao = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Digite o novo nome: ");
                    novoNome = entrada.nextLine();
                    System.out.println("Digite a nova idade: ");
                    novaIdade = entrada.nextInt();
                    System.out.println("Digite o novo Convenio: ");
                    System.out.println("1. Amil\n"
                            + "2. Bradesco\n"
                            + "3. SulAmerica\n"
                            + "4. NotreDame\n"
                            + "5. Unimed");
                    novoConvenio = entrada.nextInt();

                    cli.alterarPaciente(posicao, novoNome, novaIdade, novoConvenio);
                    break;
                case 5:
// ALTERANDO A CONSULTA  
                    cli.listarConsulta();
                    System.out.println("Digite a consulta que quer alterar: ");
                    posicao = entrada.nextInt();
                    System.out.println("Digite a nova data da consulta");
                    String novaData = entrada.next();
                    System.out.println("Digite o novo horario: ");
                    String novaHora = entrada.next();

                    cli.menuTratamentos();
                    System.out.println("Digite o novo tratamento: ");
                    int novoTrat = entrada.nextInt() - 1;

                    cli.listarDentistas();
                    System.out.println("Digite o novo dentista: ");
                    int novoDent = entrada.nextInt() - 1;

                    cli.exibirPacientes();
                    System.out.println("Digite o novo paciente: ");
                    int novoPac = entrada.nextInt() - 1;

                    cli.alterarConsulta(posicao, novaData, novaHora, novoTrat, novoDent, novoPac);

                    cli.listarConsulta();

                    System.out.println("Consulta alterada.");

                    break;
                case 6:
//EXIBINDO A LISTA DE PACIENTES                    
                    cli.exibirPacientes();
                    break;
                case 7:
                    cli.exibirPacientes();
                    System.out.println("Digite a posicao do paciente a ser excluido:");
                    posicao = entrada.nextInt() - 1;
                    cli.excluirPaciente(posicao);
//Excluindo Cadastro do Paciente                    
                    break;
                case 8:
//Excluindo Consulta       
                    cli.listarConsulta();
                    System.out.println("Digite a posicao da consulta que quer excluir: ");
                    posicao = entrada.nextInt() - 1;
                    cli.excluirConsulta(posicao);
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
// CASO NAO SEJA DIGITADA NENHUMA DAS OPCOES ACIMA                    
                    System.out.println("Opcao invalida, tente novamente.");
            }

        } while (opcao != 0);
    }

}
