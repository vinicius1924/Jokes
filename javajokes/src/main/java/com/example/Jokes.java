package com.example;

import java.util.Random;

public class Jokes
{
	private String[] jokes = new String[4];

	public Jokes()
	{
		jokes[0] = "Na delegacia\n\n" +
				  "– Seu delegado meu marido saiu de casa ontem a noite, disse que ia comprar arroz e até agora não voltou. " +
				  "O que eu faço doutor?\n" + "\n" + "– Sei lá, faz macarrão!!";

		jokes[1] = "O médico perguntou:\n\n" +
				  "- Por que você tomou a medicação às seis da manhã se eu disse pra você tomar às nove?\n" +
				  "\n" + "Eu respondi:\n" + "- Doutor, era para ver se eu conseguia pegar as bactérias de surpresa!";

		jokes[2] = "O cara finalmente conseguiu convencer a garota mais bonita do bairro a sair com ele. \n" +
				  "Quando eles entraram no carro, a gata foi colocar o cinto de segurança e deixou escapar um sonoro peido.\n" +
				  "\n" + "- Me desculpe. - disse ela, constrangida - Eu espero que isso fique só entre nós dois...\n" +
				  "- Não sei não! - disse o rapaz, abrindo a janela - Se você não se importa, eu prefiro " +
				  "que se espalhe um pouco!";

		jokes[3] = "Um pastor estava pregando na praça pública dizendo:\n" +
				  "- Sai demônio!\n" + "\n" + "E um bêbado responde:\n" + "- Não sai não! A praça é pública!";
	}

	public String getJoke()
	{
		Random random = new Random();
		int i = random.nextInt(4);

		return jokes[i];
	}
}
