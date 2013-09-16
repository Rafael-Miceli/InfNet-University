algoritmo "semnome"
// Função :
// Autor :
// Data : 11/06/2013
// Seção de Declarações 
var
	Usuarios: vetor[1..4, 1..3] de caracter
	email, senha, usuario: caractere
	
funcao BuscarUsuario(email, senha: caractere): caractere
var
   i: inteiro   
   usu: caractere
inicio
	i <- 1
	usu <- "nulo"
	
	repita
		se (email = Usuarios[i, 1]) e (senha = Usuarios[i, 2]) entao
			usu <- Usuarios[i, 3]
		fimse		
		i <- i + 1
	ate (usu <> "nulo") ou (i > 4)

	retorne usu
fimfuncao

inicio
// Seção de Comandos 

	//CarregarUsuarios()
	
	Usuarios[1, 1] <- "rafael@teste.com"
	Usuarios[1, 2] <- "123456"
	Usuarios[1, 3] <- "Rafael"
	
	Usuarios[2, 1] <- "lorena@teste.com"
	Usuarios[2, 2] <- "teste"
	Usuarios[2, 3] <- "Lorena"
	
	Usuarios[3, 1] <- "Jp@teste.com"
	Usuarios[3, 2] <- "senha123"
	Usuarios[3, 3] <- "João"
	
	Usuarios[4, 1] <- "rivs@teste.com"
	Usuarios[4, 2] <- "senha"
	Usuarios[4, 3] <- "Ricardo"
	
	//CarregarUsuarios()
	
	
	
	escreval("Digite seu E-mail")
	leia(email)
	escreval("Digite sua senha")
	leia(senha)
		
	usuario <- BuscarUsuario(email, senha)
	
	escreval()	
	se (usuario <> "nulo") entao
		escreval("Bem-Vindo ", usuario)
	senao
		escreval("E-mail ou senha incorretos")
	fimse
	
fimalgoritmo
