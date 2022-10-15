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
                    it.select("ネットワークとインターネット")
                }.expectation {
                    it.textIs("ネットワークとインターネット")
                }
            }
            case(2) {
                action {
                    it.select("ネットワークと*")
                }.expectation {
                    it.textIs("ネットワークとインターネット")
                }
            }
            case(3) {
                action {
                    it.select("*とインターネット")
                }.expectation {
                    it.textIs("ネットワークとインターネット")
                }
            }
            case(4) {
                action {
                    it.select("textMatches=^ネットワークとインターネット$")
                }.expectation {
                    it.textIs("ネットワークとインターネット")
                }
            }
            case(5) {
                action {
                    it.selectWithScrollDown("デバイス情報||エミュレートされたデバイスについて")
                }.expectation {
                    realDevice {
                        it.textIs("デバイス情報")
                    }.emulator {
                        it.textIs("エミュレートされたデバイスについて")
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
                    it.textIs("設定を検索")
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
                        .tap("ネットワークとインターネット")
                }.action {
                    it.select("@ネットワークとインターネット")
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
                    it.select("xpath=//*[@text='設定を検索']")
                }.expectation {
                    it.textIs("設定を検索")
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
                        .tap("バッテリー")
                }.action {
                    it.select("*バッテリー*&&[1]")
                }.expectation {
                    it.textIs("バッテリー使用量")
                }
            }
            case(2) {
                action {
                    it.select("*バッテリー*&&[2]")
                }.expectation {
                    it.textIs("バッテリーセーバー")
                }
            }
            case(3) {
                action {
                    it.select("*バッテリー*&&[3]")
                }.expectation {
                    it.textIs("バッテリーを長持ちさせ、充電を最適化します")
                }
            }
        }
    }

}