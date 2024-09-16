// THIS FILE IS AUTO GENERATED .
// DO NOT EDIT THIS FILE .
@file:Suppress(
  "PackageDirectoryMismatch",
  "unused",
)

package me.tbsten.compose.dom.elements

import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import me.tbsten.compose.dom.HtmlTagRef
import me.tbsten.compose.dom.attributes.AttrsScope
import me.tbsten.compose.dom.attributes.attr

public class InputUrlAttrsScope(
  ref: HtmlTagRef,
) : AttrsScope(ref) {
  init {
    attr("type", "url")
  }
}

public fun InputUrlAttrsScope.disabled(disabled: Boolean) {
  attr("disabled", disabled)
}

public fun InputUrlAttrsScope.form(form: String) {
  attr("form", form)
}

public fun InputUrlAttrsScope.name(name: String) {
  attr("name", name)
}

public fun InputUrlAttrsScope.`value`(`value`: String) {
  attr("value", value)
}

public fun InputUrlAttrsScope.autoComplete(autoComplete: InputUrlAutoComplete) {
  attr("autocomplete", autoComplete.enumValue)
}

public enum class InputUrlAutoComplete(
  public val enumValue: String,
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
  ;
}

public fun InputUrlAttrsScope.dirName(dirName: String) {
  attr("dirname", dirName)
}

public fun InputUrlAttrsScope.list(list: String) {
  attr("list", list)
}

public fun InputUrlAttrsScope.maxLength(maxLength: Int) {
  attr("maxlength", maxLength)
}

public fun InputUrlAttrsScope.maxLength(maxLength: Float) {
  attr("maxlength", maxLength)
}

public fun InputUrlAttrsScope.minLength(minLength: Int) {
  attr("mienlngth", minLength)
}

public fun InputUrlAttrsScope.minLength(minLength: Float) {
  attr("mienlngth", minLength)
}

public fun InputUrlAttrsScope.pattern(pattern: String) {
  attr("pattern", pattern)
}

public fun InputUrlAttrsScope.placeholder(placeholder: String) {
  attr("placeholder", placeholder)
}

public fun InputUrlAttrsScope.readOnly(readOnly: Boolean) {
  attr("readonly", readOnly)
}

public fun InputUrlAttrsScope.required(required: Boolean) {
  attr("required", required)
}

public fun InputUrlAttrsScope.size(size: Int) {
  attr("size", size)
}

public fun InputUrlAttrsScope.size(size: Float) {
  attr("size", size)
}
