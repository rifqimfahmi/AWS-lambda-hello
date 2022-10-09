package translator

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CatTranslatorImplTest {

    private lateinit var catTranslator: CatTranslator

    @BeforeEach
    internal fun setUp() {
        catTranslator = CatTranslatorImpl()
    }


    @Test
    internal fun should_output_as_a_cat_when_input_is_meow() {
        verifyIAmACat(catTranslator.translate("meow"))
    }

    @Test
    internal fun should_output_as_a_cat_when_input_is_meoow() {
        verifyIAmACat(catTranslator.translate("meoow"))
    }

    @Test
    internal fun should_output_as_a_cat_when_input_is_mmmeeeeoowww() {
        verifyIAmACat(catTranslator.translate("mmmeeeeoowww"))
    }

    @Test
    internal fun should_output_as_a_cat_when_input_is_case_sensitive() {
        verifyIAmACat(catTranslator.translate("MeeoOwWW"))
    }

    @Test
    internal fun test_other_valid_cat_input() {
        verifyIAmACat(catTranslator.translate("Meeow!@#"))
        verifyIAmACat(catTranslator.translate("!@@Meeow!@#"))
        verifyIAmACat(catTranslator.translate("Meow!"))
    }

    @Test
    internal fun test_invalid_cat_input() {
        verifyIAmNotACat(catTranslator.translate("me ow"))
        verifyIAmNotACat(catTranslator.translate("MeEe ow"))
        verifyIAmNotACat(catTranslator.translate("me#ow"))
        verifyIAmNotACat(catTranslator.translate("me00w"))
        verifyIAmNotACat(catTranslator.translate("ackmeaaow"))
        verifyIAmNotACat(catTranslator.translate(""))
    }

    private fun verifyIAmACat(output: String) {
        assertThat(output).isIn(CatTranslatorImpl.messages)
    }

    private fun verifyIAmNotACat(output: String) {
        assertThat(output).matches(CatTranslatorImpl.NOT_A_CAT_MSG)
    }
}