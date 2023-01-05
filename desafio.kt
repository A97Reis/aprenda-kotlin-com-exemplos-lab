enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String, val email: String) 

data class ConteudoEducacional(var nome: String, var duracao: Int = 60, val nivelDificuldade: Nivel) 

data class Formacao(val nome: String, var conteudos: ArrayList<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        inscritos.add(usuario)
    }
    
    fun removerInscrito(usuario: Usuario) {
        inscritos.remove(usuario)
    }
}

fun main() {
    
    var usersList = arrayListOf<Usuario>()
    var user: Usuario
    var userName: String
    var userEmail: String
    var quantity: Int
    var count = 1
    var formation: Formacao
    var contentList = arrayListOf<ConteudoEducacional>()
    var content: ConteudoEducacional
    var contentName: String
    var contentLevel: Nivel = Nivel.BASICO
    var contentDuration: Int
    var numberSelect = 0 //numero selecionado nas opções
    
    println("Informe quantos usuários pretende cadastrar")
	print(">")
   	quantity = readLine()!!.toInt()
    
    
    //cadastra usuários na lista
    while(count <= quantity) {
		println("Digite o nome do $count° usuário")
        print(">")
        userName = readLine().toString()
        
        println("Digite o e-mail do $count° usuário")
        print(">")
        userEmail = readLine().toString()
        
        // instancia usuário com os dados inseridos anteriormente
        user = Usuario(userName, userEmail)
        
        //adiciona o usuário na lista
        usersList.add(user)
        
        count++
    }
    
    if (quantity == 0) {
        println("Você não cadastrou nenhum usuario")
    } else {
        println("$quantity usuarios cadastrados com sucesso!!!")
        println("....")
        println("....")
    }
    
    //limpa o contador retornando para um
   	count = 1
    
   
    
   //faz a leitura de quantos cursos deseja inserir na lista
    println("Informe quantos conteudos pretende cadastrar")
	print(">")
   	quantity = readLine()!!.toInt()
    
    while (count <= quantity) {
		println("Digite o nome do conteudo numero $count")
        print(">")
        contentName = readLine().toString()
        
        println("Digite a duração do conteudo numero $count")
        print(">")
        contentDuration = readLine()!!.toInt()
        
        
        // loop para inserir a dificuldade do conteudo, enquanto não inserir a informação correta o loop não finaliza
        while (numberSelect < 1 || numberSelect > 3) {
            
            println("Digite o numero correspondente ao nivel do conteudo numero $count")
            println(
            """
            1 - BASICO
            2 - INTERMEDIARIO
            3 - DIFICIL   
            """.trimIndent())
            print(">")
            numberSelect = readLine()!!.toInt()
            
            //if para determinar o nivel do conteudo
            if (numberSelect == 1) {
            	contentLevel = Nivel.BASICO
        	} else if (numberSelect == 2) {
            	contentLevel = Nivel.INTERMEDIARIO
        	} else if (numberSelect == 3) {
            	contentLevel = Nivel.DIFICIL
            } else {
                println("Digite uma opção valida")
            }
            
        } 
        // redefine o valor para zero
        //Para ser chamado o nivel quando existe mais de um conteudo
        numberSelect = 0 
        //instancia o objeto conteudo
        content = ConteudoEducacional(contentName, contentDuration, contentLevel)

        //adiciona o conteudo na lista
        contentList.add(content)

        count++
   }
    
    
    
    //limpa o contador retornando para um
   //	count = 0
    
    while (numberSelect != -1){
        println("....")
        println("Escolha uma das opções abaixo e digite o numero correspondente.")
        println("....")
    	
        //exibe os conteudos cadastrados na lista
        for (i in contentList.indices) {
            println("")
            println("$i - Conteudo ${contentList[i].nome}, duração de ${contentList[i].duracao} horas")
        }
        println("-1 - Sair")
        println("....")
        println(">")
        //recebe o numero da opção escolhida
        numberSelect = readLine()!!.toInt()
        
        formation = Formacao("$contentList[numberSelect]", contentList)
        
        //dessa linha para baixo será onde vai listar os usuários e possibilita a matricula
        println("....")
        println("Qual usuário deseja cadastrar no conteudo ${contentList[numberSelect].nome}?")
        println("....")
        
        //redefine valor de count para zero, para utilizar no for abaixo
       // count = 0
        
        //lista usuários
        println("....")
        for (i in usersList.indices) {
           
           println("$i - ${usersList[i].nome}, e-mail ${usersList[i].email}")
        }
        println("-1 - Sair")
        println("....")
        println(">")
        
        //recebe o numero correspondente ao usuário
        numberSelect = readLine()!!.toInt()
        
        //amtricula o usuário da linha selecionada anteriormente
        formation.matricular(usersList[numberSelect])
       	
        println("....")
        println("Usuário matriculado com sucesso!!!")
        println("....")
		println("Deseja matricular outro usuário?")
        println("....")
		println(
        """
        1- Matricular novo usuário
        -1 - Sair
        """.trimIndent())
        
        numberSelect = readLine()!!.toInt()
        
        if (numberSelect == -1) {
            break
        } else {
            continue
        }
    }
    println("Usuarios matriculados com sucesso, volte sempre!!!")
}