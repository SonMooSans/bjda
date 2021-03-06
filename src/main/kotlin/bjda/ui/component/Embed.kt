package bjda.ui.component

import bjda.ui.component.utils.Builder
import bjda.ui.core.ElementImpl
import bjda.ui.core.IProps
import bjda.ui.core.RenderData
import bjda.utils.embed
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.MessageEmbed
import java.awt.Color
import java.time.temporal.TemporalAccessor

class Embed : ElementImpl<Embed.Props>(Props()) {
    class Props : IProps() {
        var title: String? = null
        var url: String? = null
        var description: String? = null
        var author: String? = null
        var authorUrl: String? = null
        var authorIcon: String? = null
        var footer: String? = null
        var footerIcon: String? = null
        var thumbnail: String? = null
        var image: String? = null
        var timestamp: TemporalAccessor? = null
        var color: Color? = null
        var fields: List<MessageEmbed.Field>? = null
    }

    override fun build(data: RenderData) {
        with (props) {
            val builder = EmbedBuilder()
                .setTitle(title, url)
                .setDescription(description)
                .setAuthor(author, authorUrl, authorIcon)
                .setFooter(footer, footerIcon)
                .setColor(color)
                .setThumbnail(thumbnail)
                .setImage(image)
                .setTimestamp(timestamp)

            fields?.forEach {
                builder.fields.add(it)
            }

            data.addEmbeds(builder.build())
        }
    }

    companion object {
        fun MessageEmbed.toComponent(): Builder {

            return Builder { data ->
                data.addEmbeds(this)
            }
        }
    }
}

