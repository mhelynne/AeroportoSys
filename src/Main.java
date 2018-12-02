import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import entidades.Aeroporto;
import entidades.Endereco;
import entidades.Voo;

public class Main {

	public static void main(String[] args) {
		
		// Criando um aeroporto (MCZ)
		
		Aeroporto aeroportoMCZ = new Aeroporto();
		aeroportoMCZ.setNome("Aeroporto Internacional Zumbi dos Palmares");
		aeroportoMCZ.setCodigo("MCZ");
		aeroportoMCZ.setAnoDeInauguracao(2005);
		
		Endereco enderecoMCZ = new Endereco();
		enderecoMCZ.setLogradouro("Rodovia BR");
		enderecoMCZ.setNumero(104);
		enderecoMCZ.setCidade("Rio Largo");
		enderecoMCZ.setEstado("Alagoas");
		enderecoMCZ.setPais("Brasil");
		
		aeroportoMCZ.setEndereco(enderecoMCZ); // Associação entre Aeroporto e Endereço
		
		
		// Criando outro aeroporto (GRU)
		
		Aeroporto aeroportoGRU = new Aeroporto();
		aeroportoGRU.setNome("Aeroporto Internacional de São Paulo/Guarulhos - Governador André Franco Montoro");
		aeroportoGRU.setCodigo("GRU");
		aeroportoGRU.setAnoDeInauguracao(1985);
		
		Endereco enderecoGRU = new Endereco();
		enderecoGRU.setLogradouro("Rodovia Hélio Smidt");
		enderecoGRU.setNumero(0);
		enderecoGRU.setCidade("Guarulhos");
		enderecoGRU.setEstado("São Paulo");
		enderecoGRU.setPais("Brasil");
		
		aeroportoMCZ.setEndereco(enderecoGRU); // Associação entre Aeroporto e Endereço
		
		
		// Criando um voo de MCZ para GRU		
		Voo voo1 = new Voo();
		voo1.setPartida(parseDate("02-12-2018 23:45:00"));
		voo1.setChegada(parseDate("03-12-2018 02:45:00"));
		voo1.setDuracaoHoras(3);
		voo1.setQutPassageiros(252);
		voo1.setOrigem(aeroportoMCZ);
		voo1.setDestino(aeroportoGRU);
			

		Date dia02dez = parseDate("02-12-2018 00:00:00");
		Date dia03dez = parseDate("03-12-2018 00:00:00");		
		
		
		// Prints
		resumoDeVoos(aeroportoMCZ, dia02dez);
		resumoDeVoos(aeroportoGRU, dia03dez);	

	}
	
	private static void resumoDeVoos(Aeroporto aeroporto, Date dia) {
		List<Voo> voos;
		DateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		String diaString = sdf.format(dia);
		
		System.out.println("Resumo de voos do "+ aeroporto.getNome() + " em : "+ diaString);
		
		System.out.println("*** Decolagens ***");
		voos = aeroporto.listaDecolagens(dia);
		
		if(voos.isEmpty()){
			System.out.println("Não há decolagens no dia informado!");
		} else {
			for (Voo voo : voos) {
				System.out.println(voo);
			}
		}
		
		System.out.println("*** Pousos ***");
		voos = aeroporto.listaPousos(dia);
		
		if(voos.isEmpty()){
			System.out.println("Não há pousos no dia informado!");
		} else {
			for (Voo voo : voos) {
				System.out.println(voo);
			}
		}
		
		System.out.println();
	}

	static Date parseDate(String dataString) {
		DateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		
		Date data = new Date();
		try {
			data = sdf.parse(dataString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return data;
	}

}
