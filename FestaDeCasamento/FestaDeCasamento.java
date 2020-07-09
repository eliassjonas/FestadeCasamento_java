import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

class Convidado {
	public String id_con;
	public String nome_con;
	public String familia_con;
	public String mesa_con;

	public Convidado() {
		this.id_con = "";
		this.nome_con = "";
		this.familia_con = "";
		this.mesa_con = "";
	}

	public Convidado(String id, String nome, String familia, String mesa) {
		this.id_con = id;
		this.nome_con = nome;
		this.familia_con = familia;
		this.mesa_con = mesa;
	}

	public String getId() {
		return this.id_con;
	}

	public String getNome() {
		return this.nome_con;
	}

	public String getFamilia() {
		return this.familia_con;
	}

	public String getMesa() {
		return this.mesa_con;
	}

}

class Padrinho extends Convidado{
	public String tipo_padr;

	public Padrinho() {
		this.tipo_padr = "";
	}

	public Padrinho(String id, String nome, String familia, String mesa, String tipo_padrinho) {
		this.id_con = id;
		this.nome_con = nome;
		this.familia_con = familia;
		this.mesa_con = mesa;
		this.tipo_padr = tipo_padrinho;
	}

	public String getTipo() {
		return this.tipo_padr;
	}

}

class ListaConvidados {
	public int indice;

	ArrayList<Convidado> convidados = new ArrayList<>();
	ArrayList<Padrinho> padrinhos = new ArrayList<>();

	public ListaConvidados() {
	}

	public void criarLista1(String id, String nome, String familia, String mesa) {
		Convidado novo_convidado = new Convidado(id, nome, familia, mesa);
			this.convidados.add(novo_convidado);
			System.out.println("\n========== Convidados Adicionado ==========\n");
			for(int i = 0; i < convidados.size(); i++){
				System.out.println(
					"ID: "+ convidados.get(i).getId()+ " - "
					+"Nome: "+ convidados.get(i).getNome()+ " - "
					+"Familia: "+ convidados.get(i).getFamilia()+ " - "
					+"Mesa: "+ convidados.get(i).getMesa());
			}
	}

	public void criarLista2(String id, String nome, String familia, String mesa, String tipo_padrinho) {
		Padrinho novo_padrinho = new Padrinho(id, nome, familia, mesa, tipo_padrinho);
			this.padrinhos.add(novo_padrinho);
			System.out.println("\n========== Padrinhos Adicionado ==========\n");
			for(int i = 0; i < padrinhos.size(); i++){
				System.out.println(
					"ID: "+ padrinhos.get(i).getId()+ " - "
					+"Nome: "+ padrinhos.get(i).getNome()+ " - "
					+"Familia: "+ padrinhos.get(i).getFamilia()+ " - "
					+"Mesa: "+ padrinhos.get(i).getMesa()+ " - "
					+"Tipo de Padrinho: "+ padrinhos.get(i).getTipo());
			}
	}

	public void editarConvidado(int indice, String id, String nome, String familia, String mesa) {
		Convidado novo_convidado = new Convidado(id, nome, familia, mesa);
			this.convidados.set(indice - 1, novo_convidado);
			System.out.println("\n========== Convidado Editado ==========\n");
			for(int i = 0; i < convidados.size(); i++){
				System.out.println(
					"ID: "+ convidados.get(i).getId()+ " - "
					+"Nome: "+ convidados.get(i).getNome()+ " - "
					+"Familia: "+ convidados.get(i).getFamilia()+ " - "
					+"Mesa: "+ convidados.get(i).getMesa());
			}
	}

	public void editarPadrinho(int indice, String id, String nome, String familia, String mesa, String tipo_padrinho) {
		Padrinho novo_padrinho = new Padrinho(id, nome, familia, mesa, tipo_padrinho);
			this.padrinhos.set(indice - 1, novo_padrinho);
			System.out.println("\n========== Padrinho Editado ==========\n");
			for(int i = 0; i < padrinhos.size(); i++){
				System.out.println(
					"ID: "+ padrinhos.get(i).getId()+ " - "
					+"Nome: "+ padrinhos.get(i).getNome()+ " - "
					+"Familia: "+ padrinhos.get(i).getFamilia()+ " - "
					+"Mesa: "+ padrinhos.get(i).getMesa()+ " - "
					+"Tipo de Padrinho: "+ padrinhos.get(i).getTipo());
			}
	}

	public void importarLista() throws IOException {
		System.out.println("\n========== Lista de Convidados Importada ==========\n");
		Scanner impList = new Scanner(new FileReader("Lista.txt")).useDelimiter("\\n");
        	while (impList.hasNext()) {
            	System.out.println( impList.next() );
			}
	}

	public void exportarListaConv() {
		try {
			FileWriter escrever = new FileWriter("Lista Exportada Convidados.txt");
				escrever.write("========== Lista de Convidados ==========\n\n");
			for(int i = 0; i < convidados.size(); i++)
				escrever.write(
					"Ordem: "+	convidados.get(i).getId()+ " - "
					+"Nome: "+ convidados.get(i).getNome()+ " - "
					+"Familia: "+ convidados.get(i).getFamilia()+ " - "
					+"Mesa: "+ convidados.get(i).getMesa()+"\n");
				escrever.close();
		} catch (Exception e) {
			System.out.println("Erro ao criar arquivo");
		}
	}

	public void exportarListaPadr() {
		try {
			FileWriter escrever = new FileWriter("Lista Exportada Padrinhos.txt");
				escrever.write("========== Lista de Padrinhos ==========\n\n");
			for(int i = 0; i < padrinhos.size(); i++)
				escrever.write(
					"Ordem: "+	padrinhos.get(i).getId()+ " - "
					+"Nome: "+ padrinhos.get(i).getNome()+ " - "
					+"Familia: "+ padrinhos.get(i).getFamilia()+ " - "
					+"Mesa: "+ padrinhos.get(i).getMesa()+ " - "
					+"Tipo de Padrinho: "+ padrinhos.get(i).getTipo()+"\n");
				escrever.close();
		} catch (Exception e) {
			System.out.println("Erro ao criar arquivo");
		}
	}

}

class Presente {
	public String id_presente;
	public String familiaDeuPresente;
	public String descricao;
	public String localCompra;

	public Presente() {
		this.id_presente = "";
		this.familiaDeuPresente = "";
		this.descricao = "";
		this.localCompra = "";
	}

	public Presente(String idP, String famPres, String desc, String local) {
		this.id_presente = idP;
		this.familiaDeuPresente = famPres;
		this.descricao = desc;
		this.localCompra = local;
	}

	public String getIdP() {
		return this.id_presente;
	}

	public String getFamPres() {
		return this.familiaDeuPresente;
	}

	public String getDesc() {
		return this.descricao;
	}

	public String getLocal() {
		return this.localCompra;
	}

}

class ControlePresente {
	public int indicePresente;

	ArrayList<Presente> presentes = new ArrayList<>();

	public ControlePresente() {
	}

	public void criarListaPresente(String idP, String famPres, String desc, String local) {
		Presente novo_presente = new Presente(idP, famPres, desc, local);
			this.presentes.add(novo_presente);
			System.out.println("\n========== Presente Adicionado ==========\n");
			for(int i = 0; i < presentes.size(); i++){
				System.out.println(
					"Ordem: "+ presentes.get(i).getIdP()+ " - "
					+"Familia: "+ presentes.get(i).getFamPres()+ " - "
					+"Descricao do Presente: "+ presentes.get(i).getDesc()+ " - "
					+"Local de Compra: "+ presentes.get(i).getLocal());
			}
	}

	public void editarListaPresente(int indicePresente, String idP, String famPres, String desc, String local) {
		Presente novo_presente = new Presente(idP, famPres, desc, local);
			this.presentes.set(indicePresente - 1, novo_presente);
			System.out.println("\n========== Presente Editado ==========\n");
			for(int i = 0; i < presentes.size(); i++){
				System.out.println(
					"Ordem: "+ presentes.get(i).getIdP()+ " - "
					+"Familia: "+ presentes.get(i).getFamPres()+ " - "
					+"Descricao do Presente: "+ presentes.get(i).getDesc()+ " - "
					+"Local de Compra: "+ presentes.get(i).getLocal());
			}
	}

	public void importarListaPres() throws IOException {
		System.out.println("\n========== Lista de presentes Importada ==========\n");
		Scanner impListP = new Scanner(new FileReader("Lista de Presentes.txt")).useDelimiter("\\n");
        	while (impListP.hasNext()) {
            	System.out.println( impListP.next() );
			}
	}

	public void exportarListaPres() {
		try {
			FileWriter escreverP = new FileWriter("Lista Exportada Presentes.txt");
				escreverP.write("========== Lista de Presentes ==========\n\n");
			for(int i = 0; i < presentes.size(); i++)
				escreverP.write(
					"Ordem: "+ presentes.get(i).getIdP()+ " - "
					+"Familia: "+ presentes.get(i).getFamPres()+ " - "
					+"Descricao do Presente: "+ presentes.get(i).getDesc()+ " - "
					+"Local de Compra: "+ presentes.get(i).getLocal()+"\n");
				escreverP.close();
		} catch (Exception e) {
			System.out.println("Erro ao criar arquivo");
		}
	}


}

class LocalDaFesta {
	public String noivo_noiva;
	public String local_festa;
	public String data_festa;
	public String hora_festa;


	public LocalDaFesta() {
		this.noivo_noiva = "";
		this.local_festa = "";
		this.data_festa = "";
		this.hora_festa = "";
	}

	public LocalDaFesta(String noivos, String lFesta, String dFesta, String hFesta) {
		this.noivo_noiva = noivos;
		this.local_festa = lFesta;
		this.data_festa = dFesta;
		this.hora_festa = hFesta;
	}

	public String getNoivos() {
		return this.noivo_noiva;
	}

	public String getLFesta() {
		return this.local_festa;
	}

	public String getDFesta() {
		return this.data_festa;
	}

	public String getHFesta() {
		return this.hora_festa;
	}

}


public class FestaDeCasamento {
	public static void main(String[] args) throws IOException {
		ListaConvidados listaConvidados = new ListaConvidados();
		ListaConvidados listaPadrinhos = new ListaConvidados();
		ControlePresente listaPresente = new ControlePresente();
		LocalDaFesta localFesta = new LocalDaFesta();
		Console console = System.console();
		Scanner input = new Scanner(System.in);

		int opcao = 14;
		do {
			System.out.println("\n========== Festa de Casamento ==========");
			System.out.println("\n==============  Menu  ==================");
			System.out.println(" 1 -  Adicionar Dados da Festa");
			System.out.println(" 2  - Adicionar Convidado");
			System.out.println(" 3  - Adicionar Padrinho");
			System.out.println(" 4  - Exibir Lista de Convidados");
			System.out.println(" 5  - Exibir Lista de Padrinhos");
			System.out.println(" 6  - Editar Convidados");
			System.out.println(" 7  - Editar Padrinhos");
			System.out.println(" 8  - Importar Lista");
			System.out.println(" 9  - Exportar Lista de Convidados");
			System.out.println(" 10 - Exportar Lista de Padrinhos");
			System.out.println(" 11 - Adicionar Presente");
			System.out.println(" 12 - Editar Presente");
			System.out.println(" 13 - Importar Lista de Presentes");
			System.out.println(" 14 - Exportar Lista de Presentes");
			System.out.println(" 0  - Sair");
			opcao = input.nextInt();

			if (opcao == 1) {
				System.out.println("========== Adicionar Dados da Festa ==========\n");
					System.out.println("Digite os nomes do noivo e da noiva: ");
					localFesta.noivo_noiva = console.readLine();
					System.out.println("Digite o local da festa: ");
					localFesta.local_festa = console.readLine();
					System.out.println("Digite a data da festa: ");
					localFesta.data_festa = console.readLine();
					System.out.println("Digite a hora da festa: ");
					localFesta.hora_festa = console.readLine();

					System.out.println("\n");
			}

			if (opcao == 2) {
				System.out.println("========== Adicionar Convidados ==========\n");
					System.out.println("Digite o numero de ordem do convidado: ");
					String id = console.readLine();
					System.out.println("Digite o nome do convidado: ");
					String nome = console.readLine();
					System.out.println("Digite o nome da familia: ");
					String familia = console.readLine();
					System.out.println("Digite o numero da mesa: ");
					String mesa = console.readLine();

					listaConvidados.criarLista1(id, nome, familia, mesa);
					System.out.println("\n");
			}
			if (opcao == 3) {
				System.out.println("========== Adicionar Padrinhos ==========\n");
					System.out.println("Digite o numero de ordem do convidado: ");
					String id = console.readLine();
					System.out.println("Digite o nome do convidado: ");
					String nome = console.readLine();
					System.out.println("Digite o nome da familia: ");
					String familia = console.readLine();
					System.out.println("Digite o numero da mesa: ");
					String mesa = console.readLine();
					System.out.println("Digite se eh padrinho do noivo ou noiva: ");
					String tipo_padrinho = console.readLine();

					listaPadrinhos.criarLista2(id, nome, familia, mesa, tipo_padrinho);
					System.out.println("\n");
			}
			if (opcao == 4) {
				System.out.println("========== Dados da Festa ==========\n");
				System.out.println(
					"Noivos: "+ localFesta.getNoivos()+"\n"+
					"Local da Festa: "+ localFesta.getLFesta()+"\n"+
					"Data da Festa: "+ localFesta.getDFesta()+"\n"+
					"Hora da Festa: "+ localFesta.getHFesta()+"\n");
				System.out.println("========== Lista de Convidados ==========\n");
				for (int i = 0; i < listaConvidados.convidados.size(); i++){
					System.out.println(
					"Ordem: "+	listaConvidados.convidados.get(i).getId()+ " - "
					+"Nome: "+ listaConvidados.convidados.get(i).getNome()+ " - "
					+"Familia: "+ listaConvidados.convidados.get(i).getFamilia()+ " - "
					+"Mesa: "+ listaConvidados.convidados.get(i).getMesa());
				}
			}
			if (opcao == 5) {
				System.out.println("========== Dados da Festa ==========\n");
				System.out.println(
					"Noivos: "+ localFesta.getNoivos()+"\n"+
					"Local da Festa: "+ localFesta.getLFesta()+"\n"+
					"Data da Festa: "+ localFesta.getDFesta()+"\n"+
					"Hora da Festa: "+ localFesta.getHFesta()+"\n");
				System.out.println("========== Lista de Padrinhos ==========\n");
				for (int i = 0; i < listaPadrinhos.padrinhos.size(); i++){
					System.out.println(
					"Ordem: "+	listaPadrinhos.padrinhos.get(i).getId()+ " - "
					+"Nome: "+ listaPadrinhos.padrinhos.get(i).getNome()+ " - "
					+"Familia: "+ listaPadrinhos.padrinhos.get(i).getFamilia()+ " - "
					+"Mesa: "+ listaPadrinhos.padrinhos.get(i).getMesa()+ " - "
					+"Tipo de Padrinho: "+ listaPadrinhos.padrinhos.get(i).getTipo());
				}
			}
			if (opcao == 6) {
				System.out.println("========== Editar Convidados ==========\n");
					System.out.println("Digite o numero de ordem do convidado a ser editado: ");
					int indice = input.nextInt();
					System.out.println("Digite o numero de ordem do convidado: ");
					String id = console.readLine();
					System.out.println("Digite o nome do convidado: ");
					String nome = console.readLine();
					System.out.println("Digite o nome da familia: ");
					String familia = console.readLine();
					System.out.println("Digite o numero da mesa: ");
					String mesa = console.readLine();

					listaConvidados.editarConvidado(indice, id, nome, familia, mesa);
					System.out.println("\n");
			}
			if (opcao == 7) {
				System.out.println("========== Editar Padrinhos ==========\n");
					System.out.println("Digite o numero de ordem do padrinho a ser editado: ");
					int indice = input.nextInt();
					System.out.println("Digite o numero de ordem do convidado: ");
					String id = console.readLine();
					System.out.println("Digite o nome do convidado: ");
					String nome = console.readLine();
					System.out.println("Digite o nome da familia: ");
					String familia = console.readLine();
					System.out.println("Digite o numero da mesa: ");
					String mesa = console.readLine();
					System.out.println("Digite se eh padrinho do noivo ou noiva: ");
					String tipo_padrinho = console.readLine();

					listaPadrinhos.editarPadrinho(indice, id, nome, familia, mesa, tipo_padrinho);
					System.out.println("\n");
			}
			if (opcao == 8) {
				ListaConvidados importList = new ListaConvidados();
				importList.importarLista();
			}
			if (opcao == 9) {
				listaConvidados.exportarListaConv();
			}
			if (opcao == 10) {
				listaPadrinhos.exportarListaPadr();
			}
			if (opcao == 11) {
				System.out.println("========== Adicionar Presente ==========\n");
					System.out.println("Digite o numero de ordem do presente: ");
					String idP = console.readLine();
					System.out.println("Digite o nome da familia que deu o presente: ");
					String famPres = console.readLine();
					System.out.println("Digite a descricao do presente: ");
					String desc = console.readLine();
					System.out.println("Digite o local de compra do presente: ");
					String local = console.readLine();

					listaPresente.criarListaPresente(idP, famPres, desc, local);
					System.out.println("\n");
			}
			if (opcao == 12) {
				System.out.println("========== Editar Presente ==========\n");
					System.out.println("Digite o numero de ordem do presente a ser editado: ");
					int indicePresente = input.nextInt();
					System.out.println("Digite o numero de ordem do presente: ");
					String idP = console.readLine();
					System.out.println("Digite o nome da familia que deu o presente: ");
					String famPres = console.readLine();
					System.out.println("Digite a descricao do presente: ");
					String desc = console.readLine();
					System.out.println("Digite o local de compra do presente: ");
					String local = console.readLine();

					listaPresente.editarListaPresente(indicePresente, idP, famPres, desc, local);
					System.out.println("\n");
			}
			if (opcao == 13) {
				ControlePresente importListP = new ControlePresente();
				importListP.importarListaPres();
			}
			if (opcao == 14) {
				listaPresente.exportarListaPres();
			}

		} while ( opcao != 0 );
	}
}