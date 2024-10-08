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
import kotlin.String
import kotlin.Suppress

class InputSubmitAttrsScope(
    ref: HtmlTagRef,
) : AttrsScope(ref) {
    init {
        attr("type", "submit")
    }
}

fun InputSubmitAttrsScope.disabled(disabled: Boolean) {
    attr("disabled", disabled)
}

fun InputSubmitAttrsScope.form(form: String) {
    attr("form", form)
}

fun InputSubmitAttrsScope.name(name: String) {
    attr("name", name)
}

fun InputSubmitAttrsScope.`value`(`value`: String) {
    attr("value", value)
}

fun InputSubmitAttrsScope.autoCapitalize(autoCapitalize: InputSubmitAutoCapitalize) {
    attr("autocapitalize", autoCapitalize.enumValue)
}

enum class InputSubmitAutoCapitalize(
    val enumValue: String,
) {
    Off("off"),
    None("none"),
    On("on"),
    Sentences("sentences"),
    Words("words"),
    Characters("characters"),
}

fun InputSubmitAttrsScope.autoComplete(autoComplete: InputSubmitAutoComplete) {
    attr("autocomplete", autoComplete.enumValue)
}

enum class InputSubmitAutoComplete(
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

fun InputSubmitAttrsScope.formAction(formAction: String) {
    attr("formaction", formAction)
}

fun InputSubmitAttrsScope.formEncType(formEncType: String) {
    attr("formenctype", formEncType)
}

fun InputSubmitAttrsScope.formMethod(formMethod: InputSubmitFormMethod) {
    attr("formmethod", formMethod.enumValue)
}

enum class InputSubmitFormMethod(
    val enumValue: String,
) {
    Get("get"),
    Post("post"),
    Dialog("dialog"),
}

fun InputSubmitAttrsScope.formNoValidate(formNoValidate: Boolean) {
    attr("formnovalidate", formNoValidate)
}

fun InputSubmitAttrsScope.formTarget(formTarget: String) {
    attr("formtarget", formTarget)
}

fun InputSubmitAttrsScope.formTarget(formTarget: InputSubmitFormTarget) {
    attr("formtarget", formTarget.enumValue)
}

enum class InputSubmitFormTarget(
    val enumValue: String,
) {
    _self("Self"),
    _blank("Blank"),
    _parent("Parent"),
    _top("Top"),
}

fun InputSubmitAttrsScope.list(list: String) {
    attr("list", list)
}

fun InputSubmitAttrsScope.readOnly(readOnly: Boolean) {
    attr("readonly", readOnly)
}

fun InputSubmitAttrsScope.required(required: Boolean) {
    attr("required", required)
}
