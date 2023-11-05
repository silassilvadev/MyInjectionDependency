# Exemplo de estrutura simplificado para injeção de dependência

### Descrição

Dado alguns problemas ja sofridos com as bibliotecas atuais de injeção de dependências no Android, 
este projeto foi criado com o intuito de auxiliar na criação numa estrutura simples e que facilite
os casos de uso mais comuns de injeção de dependências.

Basicamente o projeto utiliza a estrutura abaixo e visa a criação de módulos baseados em um contrato
`ModuleFactory` que pode ser interpretado pelo `ModulesContext`. 

Por fim o `ModulesInitializer` faz a limpeza inicial para evitar lixos de execuções anteriores, e 
inicializza novamente todas as dependências.

`ModulesInitializer` -> Inicializa as dependências sequenciamente conforme necessidade
    |...`ModulesContext` -> Gerenciador dos módulos de dependências
        |...`ModuleFactory` -> Contrato padronizado para inicializar as dependências sob demanda

### Implementação

Implementação das dependências para sua feature.

```kotlin
internal class MainModuleFactory(
    private val dataSource: ContractDataSource,
    private val service: ContractService
) : ModuleFactory {

    private val repository: MainRepository by lazy {
        MainRepositoryImpl(dataSource, service)
    }
    private val useCase: MainUseCase by lazy {
        MainUseCase(repository)
    }
    private val viewModel: MainViewModel by lazy {
        MainViewModel(useCase)
    }

    override fun getInstance(clazz: Class<*>): Any? {
        return when (clazz) {
            MainRepository::class.java -> repository
            MainUseCase::class.java -> useCase
            MainViewModel::class.java -> viewModel
            else -> null
        }
    }
}
```
[MainModuleFactory.kt](app/src/main/java/com/example/simplifyinjections/di/features/MainModuleFactory.kt)

Implementação para inicializar os módulos

```kotlin
internal class ModulesInitializer {

    init {
        clearAll()
    }

    fun initialize() {
        addModule(CommonModuleFactory())
        addModule(MainModuleFactory(get(), get()))
    }
}
```
[ModulesInitializer.kt](app/src/main/java/com/example/simplifyinjections/di/ModulesInitializer.kt)

Depois é só utilizar na classe que precisa de injeção

```kotlin
class MainActivity : AppCompatActivity() {

    //...

    private val mainViewModel: MainViewModel by viewModel()

    //...
}
```
[MainActivity.kt](app/src/main/java/com/example/simplifyinjections/ui/main/MainActivity.kt)

### Evidências

![](docs/gifs/simplify-injections-record.gif =540x1200)
