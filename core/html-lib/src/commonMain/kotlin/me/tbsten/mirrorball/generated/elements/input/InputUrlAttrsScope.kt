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

class InputUrlAttrsScope(
    ref: HtmlTagRef,
) : AttrsScope(ref) {
    init {
        attr("type", "url")
    }
}

fun InputUrlAttrsScope.disabled(disabled: Boolean) {
    attr("disabled", disabled)
}

fun InputUrlAttrsScope.form(form: String) {
    attr("form", form)
}

fun InputUrlAttrsScope.name(name: String) {
    attr("name", name)
}

fun InputUrlAttrsScope.`value`(`value`: String) {
    attr("value", value)
}

fun InputUrlAttrsScope.autoComplete(autoComplete: InputUrlAutoComplete) {
    attr("autocomplete", autoComplete.enumValue)
}

enum class InputUrlAutoComplete(
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

fun InputUrlAttrsScope.dirName(dirName: String) {
    attr("dirname", dirName)
}

fun InputUrlAttrsScope.list(list: String) {
    attr("list", list)
}

fun InputUrlAttrsScope.maxLength(maxLength: Int) {
    attr("maxlength", maxLength)
}

fun InputUrlAttrsScope.maxLength(maxLength: Float) {
    attr("maxlength", maxLength)
}

fun InputUrlAttrsScope.minLength(minLength: Int) {
    attr("mienlngth", minLength)
}

fun InputUrlAttrsScope.minLength(minLength: Float) {
    attr("mienlngth", minLength)
}

fun InputUrlAttrsScope.pattern(pattern: String) {
    attr("pattern", pattern)
}

fun InputUrlAttrsScope.placeholder(placeholder: String) {
    attr("placeholder", placeholder)
}

fun InputUrlAttrsScope.readOnly(readOnly: Boolean) {
    attr("readonly", readOnly)
}

fun InputUrlAttrsScope.required(required: Boolean) {
    attr("required", required)
}

fun InputUrlAttrsScope.size(size: Int) {
    attr("size", size)
}

fun InputUrlAttrsScope.size(size: Float) {
    attr("size", size)
}
