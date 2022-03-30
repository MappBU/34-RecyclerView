package com.example.recyclerviewmappbu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewmappbu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Создаем Объект Байндинга
    private var binding: ActivityMainBinding? = null
    // Создаем ссылку на MovieAdapter
    private var movieAdapter:MovieAdapter? = null
    // Создаем списочный массив. Списочный массив собирается по конструктору MovieModel
    private var movies:ArrayList<MovieModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Подключаем разметку к активити по байндингу.
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        // Инициализируем списочный массив. Чтобы наполнять его.
        movies = ArrayList<MovieModel>()

        // Добавляем 1 пункт списочного массива. По конструктору MovieModel. Для этого мы и создавали класс-шаблон MovieModel.kt
        movies?.add(MovieModel(R.drawable.bad_boys,getString(R.string.badBoys), getString(R.string.badBoysLong),
            getString(R.string.badBoysActors),getString(R.string.badBoysRating)))
        movies?.add(
            MovieModel(R.drawable.avengers, getString(R.string.avengers), getString(R.string.avengersLong),
                getString(R.string.avengersActors), getString(R.string.avengersRating))
        )
        movies?.add(
            MovieModel(R.drawable.transformers, getString(R.string.transformers), getString(R.string.transformersLong),
                getString(R.string.transformersActors), getString(R.string.transformersRating))
        )
        movies?.add(
            MovieModel(R.drawable.fast, getString(R.string.fast), getString(R.string.fastLong),
                getString(R.string.fastActors), getString(R.string.fastRating))
        )
        movies?.add(
            MovieModel(R.drawable.mk, getString(R.string.mk), getString(R.string.mkLong),
                getString(R.string.mkActors), getString(R.string.mkRating))
        )
        movies?.add(
            MovieModel(R.drawable.underworld, getString(R.string.underworld), getString(R.string.underworldLong),
                getString(R.string.underworldActors), getString(R.string.underworldRating))
        )
        movies?.add(
            MovieModel(R.drawable.pirates, getString(R.string.pirates), getString(R.string.piratesLong),
                getString(R.string.piratesActors), getString(R.string.piratesRating))
        )
        movies?.add(
            MovieModel(R.drawable.future, getString(R.string.future), getString(R.string.futureLong),
                getString(R.string.futureActors), getString(R.string.futureRating))
        )

        // По байндингу обращаемся к виджету RecyclerView. Говорим макет будет линейный, сверху вниз, по вертикали. (Стандартный)
        binding?.catalogMovies?.layoutManager = LinearLayoutManager(this)
        // Инициализируем movieAdapter и передаем наш списочный массив movies!!. Эта строчка нужна, потому что работаем с массивом в MovieAdapter.kt
        // Здесь же делаем так, чтобы в MovieAdapter.kt можно было вызвать функцию action из MainActicity
        movieAdapter = MovieAdapter({movieModel: MovieModel->action(movieModel)}, movies!!)
        // По байндингу обращаемся к виджету RecyclerView. И к его адаптеру присваиваем свой адаптер.
        binding?.catalogMovies?.adapter = movieAdapter

    }

    // Создаем метод Тапа по кнопке Каждого элемента списка: Посмотреть.
    // Будет выезжать Боттом Сшит Диалог Фрагмент.
    // В качестве аргумента здесь класс-шаблон MovieModel, через который собирался списочный массив.
    // Мувимодел берем из MovieAdapter.kt, для этого нужно дописать код в MovieAdapter.kt (Аргументы класса, и кнопка)
    private fun action(movieModel: MovieModel) {

        // Инициализируем Боттом Сшит Диалог Фрагмент
        val detailsMovie = DetailsMovie()
        // Передаем с помощью Бандл параметры в Боттом Сшит Диалог Фрагмент
        val parameters = Bundle()
        parameters.putString("nameMovie", movieModel.nameMovie)
        parameters.putString("longMovie", movieModel.longMovie)
        parameters.putString("actorsMovie", movieModel.actorsMovie)
        parameters.putString("ratingMovie", movieModel.ratingMovie)

        detailsMovie.arguments = parameters

        detailsMovie.show(supportFragmentManager, "details")

    }

}