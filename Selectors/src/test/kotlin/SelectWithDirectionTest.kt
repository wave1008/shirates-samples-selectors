import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest

class SelectWithDirectionTest : UITest() {

    @Test
    @Order(10)
    fun selectWithDirection() {

        scenario {
            case(1) {
                condition {
                    it.restartApp()
                }.action {
                    it.select("<Battery>:below")
                }.expectation {
                    it.textIs("100%")
                }
            }
            case(2) {
                action {
                    it.select("<Battery>:leftImage")
                }.expectation {
                    it.classIs("android.widget.ImageView")
                }
            }
            case(3) {
                action {
                    it.select("<Battery>:above(2)")
                }.expectation {
                    it.textIs("Notifications")
                }
            }
            case(4) {
                condition {
                    it.tap("Search settings")
                }.action {
                    it.select("<@Back>:right")
                }.expectation {
                    it.classIs("android.widget.EditText")
                }
            }
        }
    }

}