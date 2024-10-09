package me.tbsten.compose.dom.generate.definition

import me.tbsten.compose.dom.generate.ElementAttrsBuilderScope
import me.tbsten.compose.dom.generate.boolAttr
import me.tbsten.compose.dom.generate.elementOf
import me.tbsten.compose.dom.generate.entry
import me.tbsten.compose.dom.generate.enumAttr
import me.tbsten.compose.dom.generate.numAttr
import me.tbsten.compose.dom.generate.strAttr

fun inputElementOf(
    type: String?,
    kotlinName: String,
    elementAttrs: ElementAttrsBuilderScope.() -> Unit,
) = elementOf("input", kotlinName, hasContent = false) {
    if (type != null) {
        initialAttr("type", type)
    } else {
        strAttr("type")
    }
    boolAttr("disabled")
    strAttr("form")
    strAttr("name")
    strAttr("value")
    elementAttrs()
}

val inputElements =
    listOf(
        inputElementOf(null, "Input") { },
        inputElementOf("button", "InputButton") {
            autoCapitalizeAttr()
            autoCompleteAttr()
            strAttr("popovertarget", "popoverTarget")
            strAttr("popovertargetaction", "popoverTargetAction")
            boolAttr("readonly", "readOnly")
        },
        inputElementOf("checkbox", "InputCheckbox") {
            autoCapitalizeAttr()
            boolAttr("checked")
            boolAttr("required")
        },
        inputElementOf("color", "InputColor") {
            autoCapitalizeAttr()
            autoCompleteAttr()
            strAttr("list")
        },
        inputElementOf("date", "InputDate") {
            autoCapitalizeAttr()
            autoCompleteAttr()
            strAttr("list")
            numAttr("max")
            numAttr("min")
            boolAttr("readonly", "readOnly")
            boolAttr("required")
            numAttr("step")
        },
        inputElementOf("datetime-local", "InputDateTimeLocal") {
            autoCapitalizeAttr()
            autoCompleteAttr()
            strAttr("list")
            numAttr("max")
            numAttr("min")
            boolAttr("readonly", "readOnly")
            boolAttr("required")
            numAttr("step")
        },
        inputElementOf("email", "InputEmail") {
            autoCompleteAttr()
            strAttr("dirname", "dirName")
            strAttr("list")
            numAttr("maxlength", "maxLength")
            numAttr("mienlngth", "minLength")
            boolAttr("multiple")
            strAttr("pattern")
            strAttr("placeholder")
            boolAttr("readonly", "readOnly")
            boolAttr("required")
            numAttr("size")
        },
        inputElementOf("file", "InputFile") {
            strAttr("accept")
            autoCapitalizeAttr()
            autoCompleteAttr()
            strAttr("capture")
            strAttr("list")
            boolAttr("multiple")
            boolAttr("readonly", "readOnly")
            boolAttr("required")
        },
        inputElementOf("hidden", "InputHidden") {
            autoCapitalizeAttr()
            autoCompleteAttr()
            strAttr("dirname", "dirName")
        },
        inputElementOf("image", "InputImage") {
            strAttr("alt")
            autoCapitalizeAttr()
            autoCompleteAttr()
            strAttr("formaction", "formAction")
            strAttr("formenctype", "formEncType")
            enumAttr("formmethod", "formMethod") {
                entry("get")
                entry("post")
                entry("dialog")
            }
            boolAttr("formnovalidate", "formNoValidate")
            strAttr("formtarget", "formTarget")
            enumAttr("formtarget", "formTarget") {
                entry("_self", "Self")
                entry("_blank", "Blank")
                entry("_parent", "Parent")
                entry("_top", "Top")
            }
            numAttr("height")
            strAttr("list")
            boolAttr("readonly", "readOnly")
            boolAttr("required")
            strAttr("src")
            numAttr("width")
        },
        inputElementOf("month", "InputMonth") {
            autoCapitalizeAttr()
            autoCompleteAttr()
            strAttr("list")
            numAttr("max")
            numAttr("min")
            boolAttr("readonly", "readOnly")
            boolAttr("required")
            numAttr("step")
        },
        inputElementOf("number", "InputNumber") {
            autoCapitalizeAttr()
            autoCompleteAttr()
            strAttr("list")
            strAttr("placeholder")
            boolAttr("readonly", "readOnly")
            boolAttr("required")
        },
        inputElementOf("password", "InputPassword") {
            autoCompleteAttr()
            numAttr("maxlength", "maxLength")
            numAttr("mienlngth", "minLength")
            strAttr("pattern")
            strAttr("placeholder")
            boolAttr("readonly", "readOnly")
            boolAttr("required")
            numAttr("size")
        },
        inputElementOf("radio", "InputRadio") {
            autoCapitalizeAttr()
            boolAttr("checked")
            boolAttr("required")
        },
        inputElementOf("range", "InputRange") {
            autoCapitalizeAttr()
            autoCompleteAttr()
            strAttr("list")
            numAttr("max")
            numAttr("min")
            numAttr("step")
        },
        inputElementOf("reset", "InputReset") {
            autoCapitalizeAttr()
            autoCompleteAttr()
            strAttr("list")
            boolAttr("readonly", "readOnly")
            boolAttr("required")
        },
        inputElementOf("search", "InputSearch") {
            autoCapitalizeAttr()
            autoCompleteAttr()
            strAttr("dirname", "dirName")
            strAttr("list")
            numAttr("maxlength", "maxLength")
            numAttr("mienlngth", "minLength")
            strAttr("pattern")
            strAttr("placeholder")
            boolAttr("readonly", "readOnly")
            boolAttr("required")
            numAttr("size")
        },
        inputElementOf("submit", "InputSubmit") {
            autoCapitalizeAttr()
            autoCompleteAttr()
            strAttr("formaction", "formAction")
            strAttr("formenctype", "formEncType")
            enumAttr("formmethod", "formMethod") {
                entry("get")
                entry("post")
                entry("dialog")
            }
            boolAttr("formnovalidate", "formNoValidate")
            strAttr("formtarget", "formTarget")
            enumAttr("formtarget", "formTarget") {
                entry("_self", "Self")
                entry("_blank", "Blank")
                entry("_parent", "Parent")
                entry("_top", "Top")
            }
            strAttr("list")
            boolAttr("readonly", "readOnly")
            boolAttr("required")
        },
        inputElementOf("tel", "InputTel") {
            autoCapitalizeAttr()
            autoCompleteAttr()
            strAttr("dirname", "dirName")
            strAttr("list")
            numAttr("maxlength", "maxLength")
            numAttr("mienlngth", "minLength")
            strAttr("pattern")
            strAttr("placeholder")
            boolAttr("readonly", "readOnly")
            boolAttr("required")
            numAttr("size")
        },
        inputElementOf("text", "InputText") {
            autoCapitalizeAttr()
            autoCompleteAttr()
            strAttr("dirname", "dirName")
            strAttr("list")
            numAttr("maxlength", "maxLength")
            numAttr("mienlngth", "minLength")
            strAttr("pattern")
            strAttr("placeholder")
            boolAttr("readonly", "readOnly")
            boolAttr("required")
            numAttr("size")
        },
        inputElementOf("time", "InputTime") {
            autoCapitalizeAttr()
            autoCompleteAttr()
            strAttr("list")
            numAttr("max")
            numAttr("min")
            boolAttr("readonly", "readOnly")
            boolAttr("required")
            numAttr("step")
        },
        inputElementOf("url", "InputUrl") {
            autoCompleteAttr()
            strAttr("dirname", "dirName")
            strAttr("list")
            numAttr("maxlength", "maxLength")
            numAttr("mienlngth", "minLength")
            strAttr("pattern")
            strAttr("placeholder")
            boolAttr("readonly", "readOnly")
            boolAttr("required")
            numAttr("size")
        },
        inputElementOf("week", "InputWeek") {
            autoCapitalizeAttr()
            autoCompleteAttr()
            strAttr("list")
            numAttr("max")
            numAttr("min")
            boolAttr("readonly", "readOnly")
            boolAttr("required")
            numAttr("step")
        },
    )

private fun ElementAttrsBuilderScope.autoCapitalizeAttr() {
    enumAttr("autocapitalize", "autoCapitalize") {
        entry("off")
        entry("none")
        entry("on")
        entry("sentences")
        entry("words")
        entry("characters")
    }
}

internal fun ElementAttrsBuilderScope.autoCompleteAttr() {
    enumAttr("autocomplete", "autoComplete") {
        entry("off")
        entry("on")
        entry("name")
        entry("honorific-prefix")
        entry("given-name")
        entry("additional-name")
        entry("family-name")
        entry("honorific-suffix")
        entry("nickname")
        entry("email")
        entry("username")
        entry("new-password")
        entry("current-password")
        entry("one-time-code")
        entry("organization-title")
        entry("organization")
        entry("street-address")
        entry("shipping")
        entry("billing")
        entry("address-line1")
        entry("address-line2")
        entry("address-line3")
        entry("address-level4")
        entry("address-level3")
        entry("address-level2")
        entry("address-level1")
        entry("country")
        entry("country-name")
        entry("postal-code")
        entry("cc-name")
        entry("cc-given-name")
        entry("cc-additional-name")
        entry("cc-family-name")
        entry("cc-number")
        entry("cc-exp")
        entry("cc-exp-month")
        entry("cc-exp-year")
        entry("cc-csc")
        entry("cc-type")
        entry("transaction-currency")
        entry("transaction-amount")
        entry("language")
        entry("bday")
        entry("bday-day")
        entry("bday-month")
        entry("bday-year")
        entry("sex")
        entry("tel")
        entry("tel-country-code")
        entry("tel-national")
        entry("tel-area-code")
        entry("tel-local")
        entry("tel-extension")
        entry("impp")
        entry("url")
        entry("photo")
        entry("webauthn")
    }
}
