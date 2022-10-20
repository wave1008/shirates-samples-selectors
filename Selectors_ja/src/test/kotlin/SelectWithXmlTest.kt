import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.commandextension.classIs
import shirates.core.driver.commandextension.restartApp
import shirates.core.driver.commandextension.select
import shirates.core.testcode.UITest

class SelectWithXmlTest : UITest() {

    @Test
    @Order(10)
    fun selectWithXml() {

        scenario {
            case(1) {
                condition {
                    it.restartApp()
                }.expectation {
                    it.select("ネットワークとインターネット") {
                        select(":next").classIs("android.widget.TextView")
                        select(":next(2)").classIs("android.widget.LinearLayout")
                        select(":next(3)").classIs("android.widget.LinearLayout")
                        select(":next(4)").classIs("android.widget.ImageView")
                        select(":next(5)").classIs("android.widget.RelativeLayout")
                        select(":next(6)").classIs("android.widget.TextView")
                        select(":next(7)").classIs("android.widget.TextView")
                    }
                }
            }
        }
    }

}