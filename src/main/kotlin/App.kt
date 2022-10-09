import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import input.HandlerInput
import output.HandlerOutput
import translator.CatTranslator
import translator.CatTranslatorImpl

class App: RequestHandler<HandlerInput, HandlerOutput> {

    private val translator: CatTranslator = CatTranslatorImpl()

    override fun handleRequest(input: HandlerInput?, context: Context?): HandlerOutput {
        input?.let {
            return HandlerOutput(it.message, translator.translate(it.message))
        }
        return HandlerOutput("", "")
    }
}