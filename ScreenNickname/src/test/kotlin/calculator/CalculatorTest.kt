package calculator

import org.junit.jupiter.api.Test
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest

class CalculatorTest : UITest() {

    @Test
    fun withoutNickname() {

        scenario {
            case(1) {
                condition {
                    it.tapAppIcon("Calculator")
                }.expectation {
                    it.exist("#clr")
                    it.exist("#parens")
                }
            }
            case(2) {
                action {
                    it.tap("#clr")
                }.expectation {
                    it.select("#formula")
                        .textIsEmpty()
                    it.select("#result_preview")
                        .textIsEmpty()
                }
            }
            case(3) {
                action {
                    it.tap("#digit_1")
                }.expectation {
                    it.select("#formula")
                        .textIs("1")
                    it.select("#result_preview")
                        .textIsEmpty()
                }
            }
            case(4) {
                action {
                    it.tap("#op_add")
                }.expectation {
                    it.select("#formula")
                        .textIs("1+")
                    it.select("#result_preview")
                        .textIsEmpty()
                }
            }
            case(5) {
                action {
                    it.tap("#digit_2")
                }.expectation {
                    it.select("#formula")
                        .textIs("1+2")
                    it.select("#result_preview")
                        .textIs("3")
                }
            }
            case(6) {
                action {
                    it.tap("#eq")
                }.expectation {
                    it.select("#result_final")
                        .textIs("3")
                }
            }
        }
    }

    @Test
    fun withNickname() {

        scenario {
            case(1) {
                condition {
                    it.tapAppIcon("Calculator")
                }.expectation {
                    it.screenIs("[Calculator Main Screen]")
                }
            }
            case(2) {
                action {
                    it.tap("[AC]")
                }.expectation {
                    it.select("[formula]")
                        .textIsEmpty()
                    it.select("[result preview]")
                        .textIsEmpty()
                }
            }
            case(3) {
                action {
                    it.tap("[1]")
                }.expectation {
                    it.select("[formula]")
                        .textIs("1")
                    it.select("[result preview]")
                        .textIsEmpty()
                }
            }
            case(4) {
                action {
                    it.tap("[+]")
                }.expectation {
                    it.select("[formula]")
                        .textIs("1+")
                    it.select("[result preview]")
                        .textIsEmpty()
                }
            }
            case(5) {
                action {
                    it.tap("[2]")
                }.expectation {
                    it.select("[formula]")
                        .textIs("1+2")
                    it.select("[result preview]")
                        .textIs("3")
                }
            }
            case(6) {
                action {
                    it.tap("[=]")
                }.expectation {
                    it.select("[result final]")
                        .textIs("3")
                }
            }
        }
    }
}