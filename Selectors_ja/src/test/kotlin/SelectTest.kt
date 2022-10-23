import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest

class SelectTest : UITest() {

    @Test
    @Order(10)
    @DisplayName("テキスト属性で要素を取得する")
    fun selectByText() {

        scenario {
            case(1) {
                condition {
                    it.restartApp()
                }.action {
                    it.select("ネットワークとインターネット")
                }.expectation {
                    it.textIs("ネットワークとインターネット")
                }
            }
            case(2) {
                action {
                    it.selectWithScrollDown("システム")
                }.expectation {
                    it.textIs("システム")
                }
            }
        }
    }

    @Test
    @Order(20)
    @DisplayName("アクセシビリティ属性(content-desc)で要素を取得する")
    fun selectByAccessibility() {

        scenario {
            case(1) {
                condition {
                    it.tapWithScrollDown("システム")
                }.action {
                    it.select("@上へ移動")
                }.expectation {
                    it.accessIs("上へ移動")
                }
            }
        }
    }

}