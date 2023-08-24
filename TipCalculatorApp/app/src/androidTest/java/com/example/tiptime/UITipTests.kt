package com.example.tiptime

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performKeyInput
import androidx.compose.ui.test.performTextInput
import com.example.tiptime.ui.theme.TipTimeTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class UITipTests {

    @get:Rule
    val composeRuleTest = createComposeRule()

    @Test
    fun calculate_20_percent_tip(){
        composeRuleTest.setContent {
            TipTimeTheme {
                TipTimeLayout()
            }
        }
        composeRuleTest.onNodeWithText("Bill Amount")
            .performTextInput("10")
        composeRuleTest.onNodeWithText("Tip Percentage")
            .performTextInput("20")
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        composeRuleTest.onNodeWithText("Tip Amount: $expectedTip")
            .assertExists("No node with this text was found")
    }

}