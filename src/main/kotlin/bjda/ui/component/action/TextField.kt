package bjda.ui.component.action

import bjda.ui.core.init
import bjda.ui.types.Init
import net.dv8tion.jda.api.interactions.components.ItemComponent
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle
import net.dv8tion.jda.internal.interactions.component.TextInputImpl

class TextField(val id: String, props: Init<Props>) : Action {
    class Props {
        var style: TextInputStyle = TextInputStyle.SHORT
        lateinit var label: String
        var minLength: Int = -1
        var maxLength: Int = -1
        var required: Boolean = true
        var value: String? = null
        var placeholder: String? = null
    }

    val props = Props().init(props)

    override fun build(): ItemComponent {
        with (props) {

            return TextInputImpl(
                id,
                style,
                label,
                minLength,
                maxLength,
                required,
                value,
                placeholder
            )
        }
    }
}