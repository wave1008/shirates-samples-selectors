import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest

class SelectTest : UITest() {

    @Test
    @Order(10)
    fun selectByText() {

        scenario {
            case(1) {
                condition {
                    it.restartApp()
                }.action {
                    it.select("Network & internet")
                }.expectation {
                    it.textIs("Network & internet")
                }
            }
            case(2) {
                action {
                    it.selectWithScrollDown("System")
                }.expectation {
                    it.textIs("System")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun selectByAccessibility() {

        scenario {
            case(1) {
                condition {
                    it.tapWithScrollDown("System")
                }.action {
                    it.select("@Navigate up")
                }.expectation {
                    it.accessIs("Navigate up")
                }
            }
        }
    }

}