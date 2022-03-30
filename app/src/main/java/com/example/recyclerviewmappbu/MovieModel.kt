package com.example.recyclerviewmappbu

class MovieModel (val banerMovie:Int, val nameMovie:String, val longMovie:String, val actorsMovie:String,
                  val ratingMovie:String) {
    // Эти переменные динамически будут изменяться в каждом пункте списка списка. (Карточке)
    // val - потому что каждый элемент списка будет назначен ровно 1 раз и неизменяемый.
    // imageId - почему картинка типа Int?  (R.drawable - работает с Id картинки в целочисленном виде).
    // По этому шаблону будем наполнять Массив данными для RV
}