package club.kidgames.liquid.api

import liqp.filters.Filter
import liqp.tags.Tag
import org.bukkit.entity.Player

data class LiquidExtenderInfo(val pluginId: String, val name: String)

enum class LiquidExtenderType {
  SNIPPET,
  FILTER,
  TAG,
  PLACEHOLDER
}

interface LiquidExtender {
  val pluginId: String
  val name: String
  val type: LiquidExtenderType
}

abstract class PlaceholderExtender(override val pluginId: String,
                                   override val name: String) : LiquidExtender {
  final override val type = LiquidExtenderType.PLACEHOLDER
  abstract fun resolvePlaceholder(context: Player?): Any?
}

data class SnippetExtender(override val pluginId: String,
                           override val name: String, val snippetText: String) : LiquidExtender {
  override val type = LiquidExtenderType.PLACEHOLDER
}

data class FilterExtender(override val pluginId: String,
                          override val name: String, val filter: Filter) : LiquidExtender {
  override val type = LiquidExtenderType.PLACEHOLDER
}

data class TagExtender(override val pluginId: String,
                       override val name: String, val tag: Tag) : LiquidExtender {
  override val type = LiquidExtenderType.PLACEHOLDER
}
