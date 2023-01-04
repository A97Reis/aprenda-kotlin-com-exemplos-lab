enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String, val email: String) 

data class ConteudoEducacional(var nome: String, var duracao: Int = 60, val nivelDificuldade: Nivel) 

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

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
        println("")
        println("")
    }
    
    //limpa o contador retornando para um
   	count = 1
    
    var contentList = arrayListOf<ConteudoEducacional>()
    var content: ConteudoEducacional
    var contentName: String
    var contentLevel = content.nivel
    var contentDuration: Int
    
    //faz a leitura de quantos cursos deseja inserir na lista
    println("Informe quantos conteudos pretende cadastrar")
	print(">")
   	quantity = readLine()!!.toInt()
    
    while(count <= quantity) {
		println("Digite o nome do conteudo numero $count")
        print(">")
        contentName = readLine().toString()
        
        println("Digite a duração do conteudo numero $count")
        print(">")
        contentDuration = readLine()!!.toInt()
        
        println("Digite o numero correspondente ao nivel do conteudo numero $count")
        println("""
            1 - BASICO
            2 - INTERMEDIARIO
            3 - DIFICIL   
        """)
        print(">")
        
        contentDuration = readLine()!!.toInt()
        
        //instancia o objeto conteudo
        content = ConteudoEducacional(contentName, contentDuration)
        
        //adiciona o conteudo na lista
        contentList.add(content)
        
        count++
    }
    
    var formationList = arrayListOf<Formacao>()
    var formation: Formacao
    var formationtName: String
    var numberSelect: Int //numero selecionado nas opções
    
    while (numberSelect != -1){
        println("Escolha uma das opções abaixo e digite o numero correspondente.")
    	
        //exibe os conteudos cadastrados na lista
        for(n in contentList) {
            println("$n - Conteudo ${contentList[n].nome}, duração de ${contentList[n].duracao} horas")
        }
        println("-1 - Sair")
        println("")
        println(">")
        
        //recebe o numero da opção escolhida
        numberSelect = readLine().toInt()
        
        formation = Formacao(formationList[numberSelect], Nivel.INTERMEDIARIO, )
        
    }      
    
}
















