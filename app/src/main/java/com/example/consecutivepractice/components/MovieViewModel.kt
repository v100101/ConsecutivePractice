package com.example.consecutivepractice.components

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.consecutivepractice.model.Movie
import kotlinx.coroutines.launch

class MovieViewModel: ViewModel() {
    private val _movies = mutableStateListOf<Movie>()

    val movies: List<Movie>
    get() = _movies

    init {
        _movies.addAll(listOf(
                Movie(1, "Профессионал (2024)", "Гангстер хочет встретить старость с семьей, но у подельников другие планы. Бодрый триллер с Лиамом Нисоном", "\n" +
                        "2024", "https://avatars.mds.yandex.net/get-kinopoisk-image/10953618/aa83aa4d-bf5f-41d1-aaee-4024dca539a7/300x", "\n" +
                        "боевик"),
                Movie(2, "Гнев человеческий (2021)", "Хладнокровный Эйч идет по следу грабителей, убивших его сына. Джейсон Стэйтем в брутальном боевике Гая Ричи", "\n" +
                        "\n" +
                        "2021", "https://avatars.mds.yandex.net/get-kinopoisk-image/4774061/f3be8b0b-456c-4499-a4f3-79e1fee1ae3a/300x", "\n" +
                        "боевик"),
                Movie(3, "Достать ножи (2019)", "Частный детектив ведет запутанное дело о смерти известного писателя. Криминальная комедия с Дэниэлом Крэйгом", "\n" +
                        "2019", "https://avatars.mds.yandex.net/get-kinopoisk-image/1946459/e5007694-e213-40cb-ac45-2df3c3dbb600/300x", "\n" +
                        "детектив"),
                Movie(4, "Переводчик (2022)", "Ахмед спас Джона от смерти, и теперь тот должен вернуть долг. Гай Ричи как никогда серьезен — и как всегда крут", "2022", "https://avatars.mds.yandex.net/get-kinopoisk-image/6201401/aad6efb9-61c4-4e7d-acd0-7f9a30951b03/300x", "\n" +
                        "боевик"),
                Movie(5, "Операция «Фортуна»: Искусство побеждать (2022)", "Команда шпионов пытается сорвать продажу супероружия. Джейсон Стэйтем и Хью Грант в экшен-комедии Гая Ричи", "\n" +
                        "2022", "https://avatars.mds.yandex.net/get-kinopoisk-image/6201401/35f8de20-1785-440d-9459-82d34b840acf/300x", "\n" +
                        "боевик"),
            )
        )
    }
}