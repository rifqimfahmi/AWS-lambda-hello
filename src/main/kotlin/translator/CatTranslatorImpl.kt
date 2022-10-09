package translator

import java.lang.StringBuilder


class CatTranslatorImpl: CatTranslator {

    companion object {
        val messages = listOf(
            "Feed me!", "Pet me!!", "Rub my belly", "I am superior", "F*ck you!", "I'm hungry",
            "Time to break something!", "Purrr!", "I'm sleepy", "Don't touch me"
        )
        const val NOT_A_CAT_MSG = "You're not a Cat!"
    }

    override fun translate(message: String): String {
        if (message.isFromCat()) {
            return messages[(0..messages.lastIndex).random()]
        }
        return NOT_A_CAT_MSG
    }

    private fun String.isFromCat(): Boolean {
        val words = split(" ")
        val identifier = "meow"
        for (word in words) {
            val compactWord = word.lowercase()
                .removeConsecutiveWord()
                .replace(Regex("\\W"), " ")
                .trim()
                .split("")
                .joinToString("")
            if (compactWord.contains(identifier, ignoreCase = true)) {
                return true
            }
        }
        return false
    }

    private fun String.removeConsecutiveWord(): String {
        val sb = StringBuilder()
        forEach {
            if (sb.isEmpty() || (sb.isNotEmpty() && sb.last() != it)) {
                sb.append(it)
            }
        }
        return sb.toString()
    }
}

