package com.example.uitesting

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule


@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun button(){
        val number = mutableStateOf(0)
        val button = composeTestRule.onNode(hasTestTag("button"), useUnmergedTree = true)
        button.assertIsDisplayed()
        button.performClick()
        composeTestRule.onNodeWithText("Compose testing").assertIsDisplayed()
        val clickNumber = composeTestRule.onNode(hasTestTag("click_number"), useUnmergedTree = true)
            .assertIsDisplayed()

        composeTestRule.setContent {
            Number{ result ->
                clickNumber.performClick()
                number.value = result
                assertTrue(number.value == 100)
            }
        }
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.uitesting", appContext.packageName)
    }
}