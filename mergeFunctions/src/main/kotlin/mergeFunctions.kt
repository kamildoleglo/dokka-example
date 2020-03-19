package dupa
import org.jetbrains.dokka.CoreExtensions
import org.jetbrains.dokka.plugability.DokkaPlugin
import org.jetbrains.dokka.transformers.pages.SameMethodNamePageMergerStrategy

class TestPlugin : DokkaPlugin() {
    val functionMerger by extending {
        CoreExtensions.pageMergerStrategy with SameMethodNamePageMergerStrategy
    }
}
