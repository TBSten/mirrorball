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

class InputPasswordAttrsScope(
    ref: HtmlTagRef,
) : AttrsScope(ref) {
    init {
        attr("type", "password")
    }
}

fun InputPasswordAttrsScope.disabled(disabled: Boolean) {
    attr("disabled", disabled)
}

fun InputPasswordAttrsScope.form(form: String) {
    attr("form", form)
}

fun InputPasswordAttrsScope.name(name: String) {
    attr("name", name)
}

fun InputPasswordAttrsScope.`value`(`value`: String) {
    attr("value", value)
}

fun InputPasswordAttrsScope.autoComplete(autoComplete: InputPasswordAutoComplete) {
    attr("autocomplete", autoComplete.enumValue)
}

enum class InputPasswordAutoComplete(
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

fun InputPasswordAttrsScope.maxLength(maxLength: Int) {
    attr("maxlength", maxLength)
}

fun InputPasswordAttrsScope.maxLength(maxLength: Float) {
    attr("maxlength", maxLength)
}

fun InputPasswordAttrsScope.minLength(minLength: Int) {
    attr("mienlngth", minLength)
}

fun InputPasswordAttrsScope.minLength(minLength: Float) {
    attr("mienlngth", minLength)
}

fun InputPasswordAttrsScope.pattern(pattern: String) {
    attr("pattern", pattern)
}

fun InputPasswordAttrsScope.placeholder(placeholder: String) {
    attr("placeholder", placeholder)
}

fun InputPasswordAttrsScope.readOnly(readOnly: Boolean) {
    attr("readonly", readOnly)
}

fun InputPasswordAttrsScope.required(required: Boolean) {
    attr("required", required)
}

fun InputPasswordAttrsScope.size(size: Int) {
    attr("size", size)
}

fun InputPasswordAttrsScope.size(size: Float) {
    attr("size", size)
}
