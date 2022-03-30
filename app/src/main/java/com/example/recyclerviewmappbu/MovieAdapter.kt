package com.example.recyclerviewmappbu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewmappbu.databinding.MovieItemBinding

// RecyclerView.Adapter - Наследуемся от класса RecyclerView, вызываем у класса метод Adapter
// <MovieHolder>() - Cоздаем новый класс снаружи класса MovieHolder. Этот класс будет содержать ссылки на все элементы 1 пункта списка RV
// var movies: ArrayList<MovieModel> - Создаем пустой Списочный массив. (Который имеет тип нашего класса-шаблона) Каждый элемент массива будет содержать все переменные 1 карточки.
// private val action:(MovieModel)->Unit - нужен для того, чтобы в MovieAdapter.kt можно было вызвать функцию action из MainActicity
class MovieAdapter(private val action:(MovieModel)->Unit, var movies: ArrayList<MovieModel>):RecyclerView.Adapter<MovieHolder>() {

    // Это стандартный метод класса RecyclerView, здесь привязываем верстку 1 элемента списка.
    // MovieItemBinding - подключает библиотеку Байндинг сюда. Для привязки верстки. (стандартный код)
    // return MovieHolder(binding) - возвращаем созданный класс MovieHolder с подключенным байндингом (Стандартный код)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : MovieItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.movie_item,parent,false)
        return MovieHolder(binding)
    }

    // holder.bind(movies[position]) - Здесь в классе MovieHolder, мы вызываем функцию bind.
    // Здесь передаем Списочный массив, по позиции каждого элемента списка. Наполнение происходит поочередно.
    // action - нужен для того, чтобы в MovieAdapter.kt можно было вызвать функцию action из MainActicity
    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(movies[position], action)
    }

    // Определяет какой длины будет наш список RecyclerView. В данном случае: Длина всего списочного массива movies.
    override fun getItemCount(): Int {
        return movies.size
    }
}

// Он служит своеобразным контейнером для всех компонентов, которые входят в элемент списка.
class MovieHolder(val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root){

    // Эта функция наполняет каждый элемент 1 пункта списка - своими значениями.
    // action: (MovieModel) -> Unit    - нужен для того, чтобы в MovieAdapter.kt можно было вызвать функцию action из MainActicity
    fun bind(movieModel:MovieModel, action: (MovieModel) -> Unit){

        // Ставит картинку с массива (Переменная в классе шаблоне)
        binding.contentCardMovie.setBackgroundResource(movieModel.banerMovie)
        binding.nameMovie.text = movieModel.nameMovie
        binding.longMovie.text = movieModel.longMovie
        binding.actorsMovie.text = movieModel.actorsMovie
        binding.ratingMovie.text = movieModel.ratingMovie

        binding.play.setOnClickListener(View.OnClickListener {
            action(movieModel)
        })

    }

}
