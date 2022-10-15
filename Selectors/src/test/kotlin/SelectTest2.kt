import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.branchextension.emulator
import shirates.core.driver.branchextension.realDevice
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest

class SelectTest2 : UITest() {

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
                    it.select("Network &*")
                }.expectation {
                    it.textIs("Network & internet")
                }
            }
            case(3) {
                action {
                    it.select("*internet")
                }.expectation {
                    it.textIs("Network & internet")
                }
            }
            case(4) {
                action {
                    it.select("textMatches=^Network & internet$")
                }.expectation {
                    it.textIs("Network & internet")
                }
            }
            case(5) {
                action {
                    it.selectWithScrollDown("About phone||About emulated device")
                }.expectation {
                    realDevice {
                        it.textIs("About phone")
                    }.emulator {
                        it.textIs("About emulated device")
                    }
                }
            }
        }
    }

    @Test
    @Order(20)
    fun selectById() {

        scenario {
            case(1) {
                condition {
                    it.restartApp()
                }.action {
                    it.select("#search_action_bar_title")
                }.expectation {
                    it.textIs("Search settings")
                }
            }
        }
    }

    @Test
    @Order(30)
    fun selectByAccessibility() {

        scenario {
            case(1) {
                condition {
                    it.restartApp()
                        .tap("Network & internet")
                }.action {
                    it.select("@Network & internet")
                }.expectation {
                    it.idIs("collapsing_toolbar")
                }
            }
        }
    }

    @Test
    @Order(40)
    fun selectByClass() {

        scenario {
            case(1) {
                condition {
                    it.restartApp()
                }.action {
                    it.select(".android.widget.ImageButton")
                }.expectation {
                    it.classIs("android.widget.ImageButton")
                }
            }
        }
    }

    @Test
    @Order(50)
    fun selectByXpath() {

        scenario {
            case(1) {
                condition {
                    it.restartApp()
                }.action {
                    it.select("xpath=//*[@text='Search settings']")
                }.expectation {
                    it.textIs("Search settings")
                }
            }
        }
    }

    @Test
    @Order(60)
    fun selectByPos() {

        scenario {
            case(1) {
                condition {
                    it.restartApp()
                        .tap("Battery")
                }.action {
                    it.select("*Battery*&&[1]")
                }.expectation {
                    it.textIs("Battery Usage")
                }
            }
            case(2) {
                action {
                    it.select("*Battery*&&[2]")
                }.expectation {
                    it.textIs("Battery Saver")
                }
            }
            case(3) {
                action {
                    it.select("*Battery*&&[3]")
                }.expectation {
                    it.textIs("Battery percentage")
                }
            }
        }
    }

}