package me.tbsten.mirrorball.generate.definition

import me.tbsten.mirrorball.generate.Attribute
import me.tbsten.mirrorball.generate.ElementAttrsBuilderScope
import me.tbsten.mirrorball.generate.boolAttr
import me.tbsten.mirrorball.generate.entry
import me.tbsten.mirrorball.generate.enumAttr
import me.tbsten.mirrorball.generate.numAttr
import me.tbsten.mirrorball.generate.strAttr

val globalAttributes: List<Attribute> =
    ElementAttrsBuilderScope()
        .apply {
            strAttr("role")
            strAttr("accesskey", "accessKey")
            autoCompleteAttr()
            boolAttr("autofocus", "autoFocus")
            strAttr("class", "className")
            enumAttr("contenteditable", "contentEditable") {
                entry("true")
                entry("false")
            }
            enumAttr("dir") {
                entry("ltr")
                entry("rtl")
            }
            enumAttr("draggable") {
                entry("true")
                entry("false")
            }
            boolAttr("draggable")
            strAttr("enterkeyhint", "enterKeyHint")
            strAttr("exportparts", "exportParts")
            boolAttr("hidden")
            // FIXME enumと同じ名前のentryを定義できないためとりあえず手動で作成 (refs: core/src/commonMain/kotlin/me/tbsten/compose/dom/attributes/GlobalAttrs.kt)
//    enumAttr("hidden") {
//        entry("hidden")
//        entry("until-found")
//    }
            strAttr("id")
            boolAttr("inert")
            enumAttr("inputmode", "inputMode") {
                entry("none")
                entry("text")
                entry("decimal")
                entry("numeric")
                entry("tel")
                entry("search")
                entry("email")
                entry("url")
            }
            strAttr("is", "htmlIs")
            strAttr("itemid")
            strAttr("itemprop", "itemProp")
            strAttr("itemref", "itemRef")
            strAttr("itemscope", "itemScope")
            strAttr("itemtype", "itemType")
            strAttr("lang")
            strAttr("nonce")
            strAttr("part")
            strAttr("popover")
            strAttr("slot")
            enumAttr("spellcheck", "spellCheck") {
                entry("true")
                entry("false")
            }
            numAttr("tabindex", "tabIndex")
            strAttr("title")
            enumAttr("translate") {
                entry("yes")
                entry("no")
            }
        }.attrs
