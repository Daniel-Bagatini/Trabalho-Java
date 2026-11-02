//package View;
//
//import DAO.DAO;
//import DAO.DatabaseException;
//import DAO.DispositivosDAO;
//import DAO.HistoricoDAO;
//import DAO.PresencialDAO;
//import Vigilancia.Dispositivos;
//import java.util.Scanner;
//import Vigilancia.Historico;
//import Vigilancia.Presencial;
//import Vigilancia.Vigilancia;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.time.format.DateTimeParseException;
//import java.util.InputMismatchException;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        //VARIAVEIS:
//        int EscMenu, EscSubMenu = 0, EscSubVer;
//        int VerificaTipo;
//        int senha;
//        int Aux_ID;
//
//        PresencialDAO presencialDao = new PresencialDAO();
//        HistoricoDAO historicoDao = new HistoricoDAO();
//        DispositivosDAO dispositivosDAO = new DispositivosDAO();
//
//        Scanner scanner = new Scanner(System.in);
//        LocalDate dataConvertida = null;
//        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        String local;
//        String ocorrencia;
//        boolean isValid = false; // para verificar se a data eh valida
//
//        do {
//
//            System.out.println("=================================\n");
//
//            System.out.println("       Menu de Escolhadas\n           ");
//            System.out.println("           Sair = 0");
//            System.out.println("           ADMINISTRAOR = 1");
//            System.out.println("           USUARIO EXTERNO = 2");
//
//            System.out.println("=================================");
//
//            EscMenu = scanner.nextInt();
//
//            ///////////////////////////////////////////SUB MENUS:   //////////////////////// 
//        
//        if (EscMenu == 1) {
//                System.out.println("\ndica: 123");
//                System.out.println("\nDigite a senha: ");
//                senha = scanner.nextInt();
//                if (senha != 123) {
//
//                    System.out.println("\nSenha invalida");
//
//                } else if (senha == 123) {
//
//                    do {
//
//                        System.out.println("==============ADM=================\n");
//
//                        System.out.println("      SUB Menu de Escolhadas\n           ");
//                        System.out.println("           Sair = 0");
//                        System.out.println("           Criar = 1");
//                        System.out.println("           Ver = 2");
//                        System.out.println("           Editar = 3");
//                        System.out.println("           Deletar = 4");
//
//                        System.out.println("=================================");
//                        EscSubMenu = scanner.nextInt();
//
//                        ///////////////////////////
//                
//
//                switch (EscSubMenu) {
//                            case 1:
//                                do {
//                                    System.out.println("==============TIPO============== \n");
//                                    System.out.println("Verificarcao do tipo de gravacao   ");
//                                    System.out.println("          Remota = 0               ");
//                                    System.out.println("          Presencail = 1           ");
//                                    System.out.println("=================================\n");
//
//                                    VerificaTipo = scanner.nextInt();
//                                    scanner.nextLine(); // limpa o Enter que sobrou do nextInt()
//
//                                    if (VerificaTipo != 0 && VerificaTipo != 1) {
//                                        System.out.println("Numero invalido, digite 0 ou 1");
//                                    }
//
//                                } while (VerificaTipo != 0 && VerificaTipo != 1);
//
//                                isValid = false; // resetando a flag antes do loop
//
//                                do {
//                                    System.out.print("Digite uma data (Ex: 25/12/2024): ");
//                                    String dataTexto = scanner.nextLine();
//
//                                    try {
//                                        // Transforma o texto digitado em um objeto LocalDate
//                                        dataConvertida = LocalDate.parse(dataTexto, formatador);
//
//                                        // Define o limite mínimo (depois de 1942 -> a partir de 01/01/1943)
//                                        LocalDate dataMinima = LocalDate.of(1943, 1, 1);
//
//                                        // Pega a data exata de hoje do sistema
//                                        LocalDate dataAtual = LocalDate.now();
//
//                                        // Valida se a data está no intervalo correto
//                                        if (!dataConvertida.isBefore(dataMinima) && !dataConvertida.isAfter(dataAtual)) {
//                                            System.out.println("Data salva com sucesso: " + dataConvertida);
//                                            System.out.println("Data formatada: " + dataConvertida.format(formatador));
//                                            isValid = true; // Sai do loop
//                                        } else {
//                                            System.out.println("Erro: A data deve ser entre 01/01/1943 e " + dataAtual.format(formatador) + "!");
//                                        }
//
//                                    } catch (DateTimeParseException e) {
//                                        System.out.println("Erro: Formato de data invalido! Use o padrao dd/MM/yyyy.");
//                                    }
//                                } while (!isValid);
//
//                                System.out.println("\nDigite o local: ");
//                                local = scanner.nextLine();
//
//                                System.out.println("\nDigite a ocorrencia: ");
//                                ocorrencia = scanner.nextLine();
//                                //listaHistoricos.add(new Historico(dataConvertida, local, ocorrencia));
//
//                                //se o tipo nao for encontrado acho que vai quebrar tem que arrumar isso
//                                //Vigilancia sistemaVigilancia = null; faz parte do if
//                                if (VerificaTipo == 1) {//presencial
//                                    System.out.println("\n--- Dados do Registro Presencial ---");
//                                    System.out.print("Nome do guarda: ");
//                                    String nome = scanner.nextLine();
//
//                                    int idade = 0;
//                                    boolean idadeValida = false;
//
//                                    do {
//                                        try {
//                                            System.out.print("Idade do guarda: ");
//                                            idade = scanner.nextInt();
//                                            scanner.nextLine(); // Consome a quebra de linha (Enter)
//
//                                            if (idade < 0 || idade > 150) {
//                                                System.out.println("Erro: A idade deve estar entre 0 e 150.");
//                                            } else {
//                                                idadeValida = true; // Idade aceita, sai do loop
//                                            }
//
//                                        } catch (InputMismatchException e) {
//                                            System.out.println("Erro: digite um numero inteiro valido.");
//                                            scanner.nextLine(); // Limpa o buffer do scanner
//                                        }
//                                    } while (!idadeValida);
//
//                                    System.out.print("CPF do guarda: ");
//                                    String cpf = scanner.nextLine();
//
//                                    System.out.print("Posto de guarda: ");
//                                    String posto = scanner.nextLine();
//
//                                    try {
//                                        // cria o objeto Presencial (validacoes sao executadas nos setters)
//                                        Vigilancia sistemaVigilancia = new Presencial(nome, idade, cpf, posto);
//
//                                        // O metodo alertar monta a String completa internamente e gera o Historico
//                                        sistemaVigilancia.alertar(dataConvertida, local, ocorrencia);
//                                        presencialDao.salvar((Presencial) sistemaVigilancia);
//                                        historicoDao.salvar(sistemaVigilancia.getHistorico());
//                                        System.out.println("\nOcorrencia e historico registrados com sucesso!");
//                                    } catch (IllegalArgumentException | DatabaseException e) {
//                                        System.out.println("\nErro ao registrar presencial: " + e.getMessage());
//                                    }
//
//                                } else if (VerificaTipo == 0) { // remota
//                                    System.out.println("\n--- Dados do Registro Remoto ---");
//                                    System.out.print("Tipo de dispositivo: ");
//                                    String tipoDispositivo = scanner.nextLine();
//
//                                    int id = 0;
//                                    boolean idValido = false;
//
//                                    do {
//                                        try {
//                                            System.out.print("Id do(a) " + tipoDispositivo + ": ");
//                                            id = scanner.nextInt();
//                                            scanner.nextLine(); // Consome a quebra de linha (Enter)
//
//                                            if (id < 0) {
//                                                System.out.println("Erro: Id nao pode ser negativo.");
//                                            } else {
//                                                idValido = true; // id aceito, sai do loop
//                                            }
//
//                                        } catch (InputMismatchException e) {
//                                            System.out.println("Erro: digite um numero inteiro valido.");
//                                            scanner.nextLine(); // Limpa o buffer do scanner
//                                        }
//                                    } while (!idValido);
//
//                                    boolean ligado = true;
//
//                                    try {
//                                        // cria o objeto Dispositivos
//                                        Vigilancia sistemaRemoto = new Dispositivos(tipoDispositivo, id, ligado);
//
//                                        // O metodo alertar monta a String completa internamente e gera o Historico
//                                        sistemaRemoto.alertar(dataConvertida, local, ocorrencia);
//
//                                        dispositivosDAO.salvar((Dispositivos) sistemaRemoto);
//                                        historicoDao.salvar(sistemaRemoto.getHistorico());
//
//                                        System.out.println("\nOcorrencia e historico registrados com sucesso!");
//                                    } catch (IllegalArgumentException | DatabaseException e) {
//                                        System.out.println("\nErro ao registrar dispositivo: " + e.getMessage());
//                                    }
//                                } else {
//                                    System.out.println("Tipo nao encontrado");
//                                }
//
//                                break;
//                            case 2:
//                                do {
//                                    System.out.println("\nSelecione a categoria que voce deseja vizualizar...\n");
//
//                                    System.out.println("==============TIPO============== \n");
//                                    System.out.println("       Sair = 0                 ");
//                                    System.out.println("       Remota = 1               ");
//                                    System.out.println("       Presencail = 2           ");
//                                    System.out.println("       Remota e Presencail = 3  ");
//                                    System.out.println("=================================\n");
//
//                                    EscSubVer = scanner.nextInt();
//                                    scanner.nextLine(); // limpa o Enter que sobrou do nextInt()
//
//                                    switch (EscSubVer) {
//                                        case 0:
//                                            System.out.println("\nVoltando ao menu anterior...\n");
//                                            break;
//                                        case 1:
//                                            System.out.println("\n--------- REGISTROS REMOTOS ---------");
//                                            for (Dispositivos d : dispositivosDAO.buscarTodos()) {
//
//                                                //getHistorico() vem da classe abstrata vigilancia, que me retorna o historico
//                                                //no toString de historico eu tenho as informacoes id, data, local e ocorrencia
//                                                System.out.println(d.getHistorico());
//                                            }
//                                            break;
//                                        case 2:
//                                            System.out.println("\n--------- REGISTROS PRESENCIAIS ---------");
//                                            for (Presencial p : presencialDao.buscarTodos()) {
//                                                System.out.println(p.getHistorico());
//                                            }
//                                            break;
//                                        case 3:
//                                            System.out.println("\n--------- TODOS OS REGISTROS ---------");
//                                            for (Historico h : historicoDao.buscarTodos()) {
//                                                System.out.println(h);
//                                            }
//                                            break;
//                                        default:
//                                            System.out.println("\n opção invalida \n");
//                                            break;
//                                    }
//
//                                } while (EscSubVer != 0);
//
//                                break;
//                            case 3:
//                                // 1. Verifica se existem históricos para editar
//                                if (historicoDao.buscarTodos().isEmpty()) {
//                                    System.out.println("\n[Aviso] Nenhum registro cadastrado para editar.");
//                                    break;
//                                }
//
//                                // 2. Solicita o ID do histórico
//                                System.out.print("\nDigite o ID do historico que deseja editar: ");
//                                int idEditar = scanner.nextInt();
//                                scanner.nextLine(); // Limpa o buffer do Enter
//
//                                // 3. Busca o objeto real no DAO
//                                Historico histEditado = historicoDao.buscarPorId(idEditar);
//
//                                if (histEditado == null) {
//                                    System.out.println("Erro: Historico com o ID " + idEditar + " nao foi encontrado.");
//                                    break;
//                                }
//
//                                // 4. Mostra o que está gravado atualmente para o usuário se situar
//                                System.out.println("\n--- REGISTRO ENCONTRADO ---");
//                                System.out.println(histEditado); // Usa o seu toString()
//
//                                // 5. Menu interno para escolher o que alterar
//                                System.out.println("O que voce deseja alterar?");
//                                System.out.println("1 - Data da Ocorrencia");
//                                System.out.println("2 - Local da Ocorrencia");
//                                System.out.println("3 - Descricao da Ocorrencia");
//                                System.out.print("Escolha uma opcao: ");
//                                int opcaoEdicao = scanner.nextInt();
//                                scanner.nextLine(); // Limpa o buffer
//
//                                switch (opcaoEdicao) {
//                                    case 1:
//                                        boolean dataValidaEdicao = false;
//                                        do {
//                                            System.out.print("Digite a nova data (use o padrao dd/MM/yyyy): ");
//                                            String dataTextoEdicao = scanner.nextLine();
//
//                                            try {
//                                                LocalDate dataConvertidaEdicao = LocalDate.parse(dataTextoEdicao, formatador);
//                                                LocalDate dataMinima = LocalDate.of(1943, 1, 1);
//                                                LocalDate dataAtual = LocalDate.now();
//
//                                                if (!dataConvertidaEdicao.isBefore(dataMinima) && !dataConvertidaEdicao.isAfter(dataAtual)) {
//                                                    histEditado.setData(dataConvertidaEdicao); // Grava a nova data no historico!
//                                                    System.out.println("Data atualizada com sucesso: " + dataConvertidaEdicao);
//                                                    System.out.println("Nova data formatada: " + dataConvertidaEdicao.format(formatador));
//                                                    dataValidaEdicao = true; // Sai do loop de validação de data
//                                                } else {
//                                                    // Mensagem dinamica mostrando o dia de hoje como limite máximo
//                                                    System.out.println("Erro: A data deve ser entre 01/01/1943 e " + dataAtual.format(formatador) + "!");
//                                                }
//
//                                            } catch (DateTimeParseException e) {
//                                                System.out.println("Erro: Formato de data invalido! Use o padrao dd/MM/yyyy.");
//                                            } catch (IllegalArgumentException e) {
//                                                System.out.println("Erro: " + e.getMessage());
//                                            }
//                                        } while (!dataValidaEdicao);
//                                        break;
//
//                                    case 2:
//                                        System.out.print("Digite o novo local: ");
//                                        String novoLocal = scanner.nextLine();
//                                        try {
//                                            histEditado.setLocal(novoLocal);
//                                            System.out.println("Sucesso: Local atualizado!");
//                                        } catch (IllegalArgumentException e) {
//                                            System.out.println("Erro: " + e.getMessage());
//                                        }
//                                        break;
//
//                                    case 3:
//                                        System.out.println("Atencao: Isso substituira o texto completo da ocorrencia.");
//                                        System.out.print("Digite a nova descricao detalhada: ");
//                                        String novaDescricao = scanner.nextLine();
//                                        try {
//                                            histEditado.setOcorrencia(novaDescricao);
//                                            System.out.println("Sucesso: Descricao atualizada!");
//                                        } catch (IllegalArgumentException e) {
//                                            System.out.println("Erro: " + e.getMessage());
//                                        }
//                                        break;
//
//                                    default:
//                                        System.out.println("Opcao de edicao invalida.");
//                                        break;
//                                }
//                                break;
//                            case 4:
//                                // Verifica se existem históricos salvos no DAO antes de prosseguir
//                                if (historicoDao.buscarTodos().isEmpty()) {
//                                    System.out.println("\n[Aviso] Nenhum historico cadastrado para deletar.");
//                                    break;
//                                }
//
//                                // Solicita o ID para o usuário
//                                System.out.print("\nDigite o ID do historico que voce deseja deletar: ");
//                                Aux_ID = scanner.nextInt();
//                                scanner.nextLine(); // Limpa o buffer do Enter
//
//                                try {
//                                    // Procuramos se esse historico pertence a alguma Vigilância Presencial
//                                    for (Presencial p : presencialDao.buscarTodos()) {
//                                        if (p.getHistorico() != null && p.getHistorico().getId() == Aux_ID) {
//                                            presencialDao.deletarPorCpfDoEnvolvido(p.getPessoa().getCPF());
//                                            break;
//                                        }
//                                    }
//
//                                    // Procuramos se esse histórico pertence a algum Dispositivo Remoto
//                                    for (Dispositivos d : dispositivosDAO.buscarTodos()) {
//                                        if (d.getHistorico() != null && d.getHistorico().getId() == Aux_ID) {
//                                            dispositivosDAO.deletarPorId(d.getIdDispositivo());
//                                            break;
//                                        }
//                                    }
//
//                                    // Deleta do historico geral
//                                    boolean removido = historicoDao.deletarPorId(Aux_ID);
//
//                                    if (removido) {
//                                        System.out.println("Sucesso: Historico deletado do sistema!");
//                                    } else {
//                                        System.out.println("Erro: Historico com o ID " + Aux_ID + " nao foi encontrado no banco.");
//                                    }
//                                } catch (IllegalArgumentException | DatabaseException e) {
//                                    System.out.println("Erro ao deletar: " + e.getMessage());
//                                }
//                                break;
//                            default:
//                                System.out.println("Digite uma opcao valida");
//                                break;
//                        }
//
//                    } while (EscSubMenu != 0);
//                }
//
//        } else if (EscMenu == 2) {
//
//                do {
//                    System.out.println("\nSelecione a categoria que voce deseja vizualizar...\n");
//
//                    System.out.println("==============TIPO============== \n");
//                    System.out.println("       Sair = 0                 ");
//                    System.out.println("       Remota = 1               ");
//                    System.out.println("       Presencail = 2           ");
//                    System.out.println("       Remota e Presencail = 3  ");
//                    System.out.println("=================================\n");
//
//                    EscSubVer = scanner.nextInt();
//                    scanner.nextLine(); // limpa o Enter que sobrou do nextInt()
//
//                    switch (EscSubVer) {
//                        case 0:
//                            System.out.println("\nVoltando ao menu anterior...\n");
//                            break;
//                        case 1:
//                            System.out.println("\n--------- REGISTROS REMOTOS ---------");
//                            for (Dispositivos d : dispositivosDAO.buscarTodos()) {
//
//                                //getHistorico() vem da classe abstrata vigilancia, que me retorna o historico
//                                //no toString de historico eu tenho as informacoes id, data, local e ocorrencia
//                                System.out.println(d.getHistorico());
//                            }
//                            break;
//                        case 2:
//                            System.out.println("\n--------- REGISTROS PRESENCIAIS ---------");
//                            for (Presencial p : presencialDao.buscarTodos()) {
//                                // toString mais o historico vinculado ao presencial
//                                System.out.println(p.getHistorico());
//                            }
//                            break;
//                        case 3:
//                            System.out.println("\n--------- TODOS OS REGISTROS ---------");
//
//                            // Solicita a lista para o DAO de históricos
//                            for (Historico h : historicoDao.buscarTodos()) {
//                                // Exibe formatado de acordo com o toString() da própria classe Historico
//                                System.out.println(h);
//                            }
//                            break;
//                        default:
//                            System.out.println("\n opção invalida \n");
//                            break;
//                    }
//
//                } while (EscSubVer != 0);
//
//            }
//
//        } while (EscMenu != 0);
//
//        scanner.close();
//    }
//}
