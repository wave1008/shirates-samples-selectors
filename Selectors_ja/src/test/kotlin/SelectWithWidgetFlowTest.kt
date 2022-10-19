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
                    it.select("<設定>:flow")
                        .classIs("android.widget.ImageButton")
                    it.select("<設定>:flow(2)")
                        .textIs("設定を検索")
                    it.select("<設定>:flow(3)")
                        .classIs("android.widget.ImageView")
                    it.select("<設定>:flow(4)")
                        .textIs("ネットワークとインターネット")
                    it.select("<設定>:flow(5)")
                        .textIs("モバイル、Wi-Fi、アクセス ポイント")
                }
            }
            case(2) {
                expectation {
                    it.select("<設定>") {
                        // <設定>からの相対位置で選択
                        select(":flow").classIs("android.widget.ImageButton")
                        select(":flow(2)").textIs("設定を検索")
                        select(":flow(3)").classIs("android.widget.ImageView")
                        select(":flow(4)").textIs("ネットワークとインターネット")
                        select(":flow(5)").textIs("モバイル、Wi-Fi、アクセス ポイント")
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
                    it.select("<設定>") {
                        // <設定>からの相対位置で選択
                        select(":label").textIs("設定を検索")
                        select(":label(2)").textIs("ネットワークとインターネット")
                        select(":label(3)").textIs("モバイル、Wi-Fi、アクセス ポイント")
                    }
                }
            }
            case(2) {
                expectation {
                    it.select("<ネットワークとインターネット>") {
                        // <ネットワークとインターネット>からの相対位置で選択
                        select(":image").classIs("android.widget.ImageView")
                        select(":label").textIs("モバイル、Wi-Fi、アクセス ポイント")
                    }
                }
            }
        }
    }

}