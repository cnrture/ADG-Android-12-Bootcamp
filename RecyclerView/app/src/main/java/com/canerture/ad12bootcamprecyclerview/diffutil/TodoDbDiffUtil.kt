package com.canerture.ad12bootcamprecyclerview.diffutil

import com.canerture.ad12bootcamprecyclerview.recyclerview.TodoModel

object TodoDbDiffUtil {

    fun getTodos(): ArrayList<TodoModel> {

        return arrayListOf(
            TodoModel(1, "Alışverişe git"),
            TodoModel(2, "16:00 Ekip toplantısı"),
            TodoModel(3, "Bitirme tezine çalış"),
            TodoModel(4, "Telefon faturasını yatır"),
            TodoModel(5, "Çeviriyi tamamla"),
            TodoModel(6, "Ödevleri hazırla"),
            TodoModel(7, "Bilgisayarı temizle"),
            TodoModel(8, "Bug'lara bak"),
            TodoModel(9, "Proje için hazırlık yap"),
            TodoModel(10, "Bankayı ara"),
            TodoModel(11, "Her gün 30dk spor yap"),
            TodoModel(11, "Her gün 30dk kitap oku"),
            TodoModel(12, "Her gün Medium'da bir yazı oku"),
            TodoModel(13, "Her gün 30dk ingilizce çalış")
        )
    }
}