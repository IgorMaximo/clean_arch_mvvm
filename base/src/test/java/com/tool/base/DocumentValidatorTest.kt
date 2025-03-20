package com.tool.base

import com.tool.base.extension.isValidCNPJ
import com.tool.base.extension.isValidCPF
import com.tool.base.extension.isValidNameSequence
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class DocumentValidatorTest : TestCase() {

    @Test
    fun givenName_whenNameAllOk_checkItsValid_withSuccess() {
        Assert.assertTrue("John Doe".isValidNameSequence())
    }

    @Test
    fun givenName_whenLessThan3Letters_checkItInvalid_withSuccess() {
        Assert.assertFalse("Jo".isValidNameSequence())
    }

    @Test
    fun givenName_whenNameIsNull_checkItInvalid_withSuccess() {
        val name: String? = null
        Assert.assertFalse(name.isValidNameSequence())
    }

    @Test
    fun givenCPF_whenWithMask_checkItsValid_withSuccess() {
        Assert.assertTrue("086.684.400-71".isValidCPF())
    }

    @Test
    fun givenCPF_whenWithoutMask_checkItsValid_withSuccess() {
        Assert.assertTrue("08668440071".isValidCPF())
    }

    @Test
    fun givenCPF_whenWithoutMask_checkItsInvalid_withSuccess() {
        Assert.assertFalse("34567768912".isValidCPF())
    }

    @Test
    fun givenCPF_whenWithWords_checkItsValid_withFailure() {
        Assert.assertFalse("asdasdadasd".isValidCPF())
    }

    @Test
    fun givenCNPJ_whenWithMask_checkItsValid_withSuccess() {
        Assert.assertTrue("69.335.146/0001-94".isValidCNPJ())
    }

    @Test
    fun givenCNPJ_whenWithMask_checkItsInvalid_withSuccess() {
        Assert.assertFalse("00.335.146/0001-94".isValidCNPJ())
    }

    @Test
    fun givenCNPJ_whenWithoutMask_checkItsValid_withSuccess() {
        Assert.assertTrue("69335146000194".isValidCNPJ())
    }

    @Test
    fun givenCNPJ_whenWithoutMask_checkItsInvalid_withSuccess() {
        Assert.assertFalse("11335146123194".isValidCNPJ())
    }

    @Test
    fun givenCNPJ_whenWithWords_checkItsValid_withFailure() {
        Assert.assertFalse("asdasdadasd".isValidCNPJ())
    }
}
