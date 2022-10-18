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
                    it.select("<バッテリー>:below")
                }.expectation {
                    it.textIs("100%")
                }
            }
            case(2) {
                action {
                    it.select("<バッテリー>:leftImage")
                }.expectation {
                    it.classIs("android.widget.ImageView")
                }
            }
            case(3) {
                action {
                    it.select("<バッテリー>:above(2)")
                }.expectation {
                    it.textIs("通知")
                }
            }
            case(4) {
                condition {
                    it.tap("設定を検索")
                }.action {
                    it.select("<@戻る>:right")
                }.expectation {
                    it.classIs("android.widget.EditText")
                }
            }
        }
    }

}