algoritmo "semnome"
// Função :
// Autor :
// Data : 11/06/2013
// Seção de Declarações 
var
   nome, senha, cpf, endereco, cidade, email: caracter
   estado: inteiro
inicio
// Seção de Comandos 

   estado <- 0

	escreval("Cadastrar Usuário")
	escreval()
	escreval("Nome Completo")
	leia(nome)
	escreval("Senha")
	leia(senha)
	escreval("CPF")
	leia(cpf)
	escreval("Endereço")
	leia(endereco)
	escreval("Cidade")
	leia(cidade)
	enquanto (estado < 1) ou (estado > 4) faca
		escreval("Para selecionar um estado, digite o número ao lado do estado de sua escolha")
		escreval()	
		
		escreval("1 - RJ")
		escreval("2 - SP")
		escreval("3 - MG")
		escreval("4 - ES")
		
		leia(estado)
	fimenquanto	
	escreval("E-Mail")
	leia(email)
	
	escreval()
	escreval()
	escreval("usuário cadastrado:")
	
	escreval("Nome Completo: ", nome)
	escreval("CPF: ", cpf)
	escreval("Endereço: ", endereco)	
	escreval("Cidade: ", cidade)
	escolha(estado)
   	caso 1
   	     	escreval("Estado: RJ")
   	caso 2
   	     	escreval("Estado: SP")
   	caso 3
   	     	escreval("Estado: MG")
   	caso 4
   	     	escreval("Estado: ES")
	fimescolha
	escreval("E-Mail: ", email)

fimalgoritmo
