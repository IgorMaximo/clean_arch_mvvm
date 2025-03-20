package com.tool.base.extension

private const val MIN_ALLOWED_NAME_LENGTH = 3
private const val CPF_LENGTH = 11
private const val CNPJ_LENGTH = 14

fun String?.isValidNameSequence(): Boolean {
    return if (this.isNullOrEmpty().not()) {
        (this?.filter { it.isLetter() }?.trim()?.trimStart()?.trimEnd()?.length ?: 0) >= MIN_ALLOWED_NAME_LENGTH
    } else false
}

fun String?.isValidCPF(): Boolean {
    val pureCPF = this?.filter { it.isDigit() }
    if (pureCPF.isNullOrEmpty() || pureCPF in invalidCPFs || pureCPF.length != CPF_LENGTH) return false
    val dig10: Char
    val dig11: Char
    var sm: Int
    var i: Int
    var r: Int
    var num: Int
    var peso: Int
    return try {
        sm = 0
        peso = 10
        i = 0
        while (i < 9) {
            num = (pureCPF[i].code - 48)
            sm += num * peso
            peso -= 1
            i++
        }
        r = CPF_LENGTH - sm % CPF_LENGTH
        dig10 = if (r == 10 || r == CPF_LENGTH) '0' else (r + 48).toChar()
        sm = 0
        peso = CPF_LENGTH
        i = 0
        while (i < 10) {
            num = (pureCPF[i].code - 48)
            sm += num * peso
            peso -= 1
            i++
        }
        r = CPF_LENGTH - sm % CPF_LENGTH
        dig11 = if (r == 10 || r == CPF_LENGTH) '0' else (r + 48).toChar()
        dig10 == pureCPF[9] && dig11 == pureCPF[10]
    } catch (_: Exception) { false }
}

fun String?.isValidCNPJ(): Boolean {
    val pureCNPJ = this?.filter { it.isDigit() }
    if (pureCNPJ.isNullOrEmpty() || pureCNPJ in invalidCNPJs || pureCNPJ.length != CNPJ_LENGTH) return false
    val dig13: Char
    val dig14: Char
    var sm: Int
    var i: Int
    var r: Int
    var num: Int
    var peso: Int
    return try {
        sm = 0
        peso = 2
        i = 11
        while (i >= 0) {
            num = (pureCNPJ[i].code - 48)
            sm += num * peso
            peso += 1
            if (peso == 10) peso = 2
            i--
        }
        r = sm % 11
        dig13 = if (r == 0 || r == 1) '0' else (11 - r + 48).toChar()
        sm = 0
        peso = 2
        i = 12
        while (i >= 0) {
            num = (pureCNPJ[i].code - 48)
            sm += num * peso
            peso += 1
            if (peso == 10) peso = 2
            i--
        }
        r = sm % 11
        dig14 = if (r == 0 || r == 1) '0' else (11 - r + 48).toChar()
        dig13 == pureCNPJ[12] && dig14 == pureCNPJ[13]
    } catch (_: Exception) { false }
}

private val invalidCPFs = listOf(
    "00000000000",
    "11111111111",
    "22222222222",
    "33333333333",
    "44444444444",
    "55555555555",
    "66666666666",
    "77777777777",
    "88888888888",
    "99999999999"
)

private val invalidCNPJs = listOf(
    "00000000000000",
    "11111111111111",
    "22222222222222",
    "33333333333333",
    "44444444444444",
    "55555555555555",
    "66666666666666",
    "77777777777777",
    "88888888888888",
    "99999999999999"
)
