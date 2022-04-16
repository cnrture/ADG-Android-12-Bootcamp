package com.canerture.ad12bootcamprecyclerview.viewtype

object TodoDbViewType {

    fun getTodos(): ArrayList<Any> {

        return arrayListOf(
            DataItem.HeaderItem("Günlük"),
            DataItem.TodoItem(1, "Alışverişe git"),
            DataItem.TodoItem(2, "16:00 Ekip toplantısı"),
            DataItem.TodoItem(3, "Bitirme tezine çalış"),
            DataItem.TodoItem(4, "Telefon faturasını yatır"),
            DataItem.TodoItem(5, "Çeviriyi tamamla"),
            DataItem.TodoItem(6, "Ödevleri hazırla"),
            DataItem.TodoItem(7, "Bilgisayarı temizle"),
            DataItem.TodoItem(8, "Bug'lara bak"),
            DataItem.TodoItem(9, "Proje için hazırlık yap"),
            DataItem.TodoItem(10, "Bankayı ara"),
            DataItem.HeaderItem("Düzenli"),
            DataItem.TodoItem(11, "Her gün 30dk spor yap"),
            DataItem.TodoItem(11, "Her gün 30dk kitap oku"),
            DataItem.TodoItem(12, "Her gün Medium'da bir yazı oku"),
            DataItem.TodoItem(13, "Her gün 30dk ingilizce çalış")
        )
    }
}