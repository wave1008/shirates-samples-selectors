import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.commandextension.classIs
import shirates.core.driver.commandextension.restartApp
import shirates.core.driver.commandextension.select
import shirates.core.driver.commandextension.textIs
import shirates.core.testcode.UITest

class SelectWithWidgetFlowTest : UITest() {

    @Test
    @Order(10)
    fun selectWithWidgetFlow() {

        scenario {
            case(1) {
                condition {
                    it.restartApp()
                }.expectation {
                    it.select("<Settings>:flow")
                        .classIs("android.widget.ImageButton")
                    it.select("<Settings>:flow(2)")
                        .textIs("Search settings")
                    it.select("<Settings>:flow(3)")
                        .classIs("android.widget.ImageView")
                    it.select("<Settings>:flow(4)")
                        .textIs("Network & internet")
                    it.select("<Settings>:flow(5)")
                        .textIs("Mobile, Wi‑Fi, hotspot")
                }
            }
            case(2) {
                expectation {
                    it.select("<Settings>") {
                        // Select relatively from <Settings>
                        select(":flow").classIs("android.widget.ImageButton")
                        select(":flow(2)").textIs("Search settings")
                        select(":flow(3)").classIs("android.widget.ImageView")
                        select(":flow(4)").textIs("Network & internet")
                        select(":flow(5)").textIs("Mobile, Wi‑Fi, hotspot")
                    }
                }
            }
        }
    }

    @Test
    @Order(20)
    fun selectWithWidgetFlow2() {

        scenario {
            case(1) {
                condition {
                    it.restartApp()
                }.expectation {
                    it.select("<Settings>") {
                        // Select relatively from <Settings>
                        select(":label").textIs("Search settings")
                        select(":label(2)").textIs("Network & internet")
                        select(":label(3)").textIs("Mobile, Wi‑Fi, hotspot")
                    }
                }
            }
            case(2) {
                expectation {
                    it.select("<Network & internet>") {
                        // Select relatively from <Network & internet>
                        select(":image").classIs("android.widget.ImageView")
                        select(":label").textIs("Mobile, Wi‑Fi, hotspot")
                    }
                }
            }
        }
    }

}