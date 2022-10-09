import com.google.common.truth.Truth.assertThat
import input.HandlerInput
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class AppTest {

    private lateinit var app: App

    @BeforeEach
    internal fun setUp() {
        app = App()
    }

    @Test
    internal fun should_not_generate_empty_output() {
        val input = HandlerInput().apply {
            message = "meow"
        }
        val output = app.handleRequest(input, null)
        assertThat(output.catMessage).isNotEmpty()
        assertThat(output.message).isNotEmpty()
    }

    @Test
    internal fun should_generate_empty_output_when_input_is_null() {
        val input = null
        val output = app.handleRequest(input, null)
        assertThat(output.catMessage).isEmpty()
        assertThat(output.message).isEmpty()
    }
}