package lucassamel.br.at_fundamentosamdroid.database

import lucassamel.br.at_fundamentosamdroid.model.Filme

class AppDatabase {
    private val filmes = mutableListOf(
        Filme("Os Incriveis", "2010"),
        Filme("Harry Potter", "2015")
    )

    fun all(): MutableList<Filme> = filmes

    companion object {

        private var instance: AppDatabase? = null

        fun getInstance(): AppDatabase {
            if (instance == null)
                instance = AppDatabase()
            return instance as AppDatabase
        }
    }
}