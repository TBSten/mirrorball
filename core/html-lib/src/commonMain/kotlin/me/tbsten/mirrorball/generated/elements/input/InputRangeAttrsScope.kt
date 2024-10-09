// THIS FILE IS AUTO GENERATED .
// DO NOT EDIT THIS FILE .
@file:Suppress(
    "PackageDirectoryMismatch",
    "unused",
)

package me.tbsten.mirrorball.elements

import me.tbsten.mirrorball.HtmlTagRef
import me.tbsten.mirrorball.attributes.AttrsScope
import me.tbsten.mirrorball.attributes.attr
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.Suppress

class InputRangeAttrsScope(
    ref: HtmlTagRef,
) : AttrsScope(ref) {
    init {
        attr("type", "range")
    }
}

fun InputRangeAttrsScope.disabled(disabled: Boolean) {
    attr("disabled", disabled)
}

fun InputRangeAttrsScope.form(form: String) {
    attr("form", form)
}

fun InputRangeAttrsScope.name(name: String) {
    attr("name", name)
}

fun InputRangeAttrsScope.`value`(`value`: String) {
    attr("value", value)
}

fun InputRangeAttrsScope.autoCapitalize(autoCapitalize: InputRangeAutoCapitalize) {
    attr("autocapitalize", autoCapitalize.enumValue)
}

enum class InputRangeAutoCapitalize(
    val enumValue: String,
) {
    Off("off"),
    None("none"),
    On("on"),
    Sentences("sentences"),
    Words("words"),
    Characters("characters"),
}

fun InputRangeAttrsScope.autoComplete(autoComplete: InputRangeAutoComplete) {
    attr("autocomplete", autoComplete.enumValue)
}

enum class InputRangeAutoComplete(
    val enumValue: String,
) {
    Off("off"),
    On("on"),
    Name("name"),
    HonorificPrefix("honorific-prefix"),
    GivenName("given-name"),
    AdditionalName("additional-name"),
    FamilyName("family-name"),
    HonorificSuffix("honorific-suffix"),
    Nickname("nickname"),
    Email("email"),
    Username("username"),
    NewPassword("new-password"),
    CurrentPassword("current-password"),
    OneTimeCode("one-time-code"),
    OrganizationTitle("organization-title"),
    Organization("organization"),
    StreetAddress("street-address"),
    Shipping("shipping"),
    Billing("billing"),
    AddressLine1("address-line1"),
    AddressLine2("address-line2"),
    AddressLine3("address-line3"),
    AddressLevel4("address-level4"),
    AddressLevel3("address-level3"),
    AddressLevel2("address-level2"),
    AddressLevel1("address-level1"),
    Country("country"),
    CountryName("country-name"),
    PostalCode("postal-code"),
    CcName("cc-name"),
    CcGivenName("cc-given-name"),
    CcAdditionalName("cc-additional-name"),
    CcFamilyName("cc-family-name"),
    CcNumber("cc-number"),
    CcExp("cc-exp"),
    CcExpMonth("cc-exp-month"),
    CcExpYear("cc-exp-year"),
    CcCsc("cc-csc"),
    CcType("cc-type"),
    TransactionCurrency("transaction-currency"),
    TransactionAmount("transaction-amount"),
    Language("language"),
    Bday("bday"),
    BdayDay("bday-day"),
    BdayMonth("bday-month"),
    BdayYear("bday-year"),
    Sex("sex"),
    Tel("tel"),
    TelCountryCode("tel-country-code"),
    TelNational("tel-national"),
    TelAreaCode("tel-area-code"),
    TelLocal("tel-local"),
    TelExtension("tel-extension"),
    Impp("impp"),
    Url("url"),
    Photo("photo"),
    Webauthn("webauthn"),
}

fun InputRangeAttrsScope.list(list: String) {
    attr("list", list)
}

fun InputRangeAttrsScope.max(max: Int) {
    attr("max", max)
}

fun InputRangeAttrsScope.max(max: Float) {
    attr("max", max)
}

fun InputRangeAttrsScope.min(min: Int) {
    attr("min", min)
}

fun InputRangeAttrsScope.min(min: Float) {
    attr("min", min)
}

fun InputRangeAttrsScope.step(step: Int) {
    attr("step", step)
}

fun InputRangeAttrsScope.step(step: Float) {
    attr("step", step)
}
