package io.github.phenax.h

import io.kotlintest.specs.ShouldSpec
import io.kotlintest.*

import io.github.phenax.h.Component
import io.github.phenax.h.Layout
import io.github.phenax.h.node.DOMNode
import io.github.phenax.h.helpers.MyLayout


abstract class MySpec(
	private val testCaseInterceptor: (TestCaseContext, () -> Unit) -> Unit = { _, test -> test() }
): ShouldSpec() {

	// Test config
	override val defaultTestCaseConfig: TestCaseConfig =
		TestCaseConfig(
			interceptors = listOf(testCaseInterceptor)
		)

	override val oneInstancePerTest = true

    protected fun createLayout(_getRenderNode: (MyLayout) -> (Component) -> DOMNode): MyLayout {
		return MyLayout(_getRenderNode)
	}
}
