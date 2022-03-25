package com.example.recyclerviewmappbu

class MovieModel (val banerMovie:Int, val nameMovie:String, val longMovie:String, val actorsMovie:String,
                  val ratingMovie:String) {
    // Данные переменные по разному будут наполняться в каждом отдельном элементе списка.
    // val - потому что каждый элемент списка будет назначен ровно 1 раз и неизменяемый.
    //imageId - почему картинка типа Int?  (R.drawable - работает с Id картинки в целочисленном виде).
}