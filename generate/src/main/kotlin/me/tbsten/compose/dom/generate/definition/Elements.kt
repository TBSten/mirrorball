package me.tbsten.compose.dom.generate.definition

import me.tbsten.compose.dom.generate.Element
import me.tbsten.compose.dom.generate.ElementAttrsBuilderScope
import me.tbsten.compose.dom.generate.boolAttr
import me.tbsten.compose.dom.generate.elementOf
import me.tbsten.compose.dom.generate.entry
import me.tbsten.compose.dom.generate.enumAttr
import me.tbsten.compose.dom.generate.numAttr
import me.tbsten.compose.dom.generate.strAttr

val elements: List<Element> = listOf(
    elementOf("a") {
        boolAttr("download")
        strAttr("download")
        strAttr("href")
        strAttr("hreflang", "hrefLang")
        strAttr("ping")
        referrerPolicyAttr()
        strAttr("rel")
        enumAttr("target") {
            entry("_self")
            entry("_blank")
            entry("_parent")
            entry("_top")
        }
        strAttr("target")
        strAttr("type")
    },
    elementOf("abbr") { },
    elementOf("address") { },
    elementOf("area", hasContent = false) {
        strAttr("alt")
        numAttr("coords")
        strAttr("download")
        strAttr("href")
        strAttr("hreflang", "hrefLang")
        strAttr("ping")
        referrerPolicyAttr()
        strAttr("rel")
        strAttr("shape")
        enumAttr("target") {
            entry("_self")
            entry("_blank")
            entry("_parent")
            entry("_top")
        }
    },
    elementOf("article") { },
    elementOf("aside") { },
    elementOf("audio") {
        boolAttr("autoplay", "autoPlay")
        boolAttr("controls")
        strAttr("controlslist", "controlsList")
        enumAttr("crossorigin", "crossOrigin") {
            entry("anonymous")
            entry("UseCredentials", "use-credentials")
        }
        boolAttr("disableremoteplayback", "disableRemotePlayback")
        boolAttr("loop")
        boolAttr("muted")
        enumAttr("preload") {
            entry("none")
            entry("metadata")
            entry("auto")
        }
        strAttr("src")
    },
    elementOf("b") {},
    elementOf("base", hasContent = false, parent = listOf("Head")) {
        strAttr("href")
        enumAttr("target") {
            entry("_self")
            entry("_blank")
            entry("_parent")
            entry("_top")
        }
    },
    elementOf("bdi") { },
    elementOf("bdo") {
        enumAttr("dir") {
            entry("ltr")
            entry("rtl")
        }
    },
    elementOf("blockquote") {
        strAttr("cite")
    },
    elementOf("body", parent = listOf("Html")) { },
    elementOf("br", hasContent = false) { },
    elementOf("button") {
        boolAttr("autofocus", "autoFocus")
        boolAttr("disabled")
        strAttr("form")
        strAttr("formaction", "formAction")
        enumAttr("formenctype", "formEncType") {
            entry("ApplicationXWwwFormUrlEncoded", "application/x-www-form-urlencoded")
            entry("MultipartFormData", "multipart/form-data")
            entry("TextPlain", "text/plain")
        }
        enumAttr("formmethod", "formMethod") {
            entry("get")
            entry("post")
            entry("dialog")
        }
        boolAttr("formnovalidate", "formNoValidate")
        strAttr("formtarget", "formTarget")
        enumAttr("formtarget", "formTarget") {
            entry("Self", "_self")
            entry("Blank", "_blank")
            entry("Parent", "_parent")
            entry("Top", "_top")
        }
        strAttr("name")
        strAttr("popovertarget", "popoverTarget")
        enumAttr("popovertargetaction", "popoverTargetAction") {
            entry("hide")
            entry("show")
            entry("toggle")
        }
        enumAttr("type") {
            entry("submit")
            entry("reset")
            entry("button")
        }
        strAttr("value")
    },
    elementOf("canvas") {
        numAttr("height")
        numAttr("width")
    },
    elementOf("caption", parent = listOf("Table")) { },
    elementOf("cite") { },
    elementOf("code") { },
    elementOf("col", hasContent = false, parent = listOf("Colgroup")) {
        numAttr("span")
    },
    elementOf("colgroup", "ColGroup", parent = listOf("Table")) {
        numAttr("span")
    },
    elementOf("data") {
        strAttr("value")
    },
    elementOf("datalist") { },
    elementOf("dd", parent = listOf("Dl")) { },
    elementOf("del") {
        strAttr("cite")
        strAttr("datetime")
    },
    elementOf("details") {
        boolAttr("open")
    },
    elementOf("dfn") { },
    elementOf("dialog") {
        boolAttr("open")
    },
    elementOf("div") { },
    elementOf("dl") { },
    elementOf("dt", parent = listOf("Dl")) { },
    elementOf("em", hasContent = false) { },
    elementOf("embed") {
        numAttr("height")
        strAttr("src")
        strAttr("type")
        numAttr("width")
    },
    elementOf("fieldset", "FieldSet") {
        boolAttr("disabled")
        strAttr("form")
        strAttr("name")
    },
    elementOf("figcaption", "FigureCaption", parent = listOf("Figure")) { },
    elementOf("figure") { },
    elementOf("footer") { },
    elementOf("form") {
        strAttr("accept-charset")
        enumAttr("autocomplete") {
            entry("on")
            entry("off")
        }
        strAttr("name")
        strAttr("rel")

        strAttr("action")
        strAttr("enctype", "encType")
        enumAttr("method") {
            entry("post")
            entry("get")
            entry("dialog")
        }
        boolAttr("novalidate", "noValidate")
        enumAttr("target") {
            entry("Self", "_self")
            entry("Blank", "_blank")
            entry("Parent", "_parent")
            entry("Top", "_top")
        }
    },
    elementOf("h1") {},
    elementOf("h2") {},
    elementOf("h3") {},
    elementOf("h4") {},
    elementOf("h5") {},
    elementOf("h6") {},
    elementOf("head", parent = listOf("Html")) {},
    elementOf("header") { },
    elementOf("hgroup") { },
    elementOf("hr", hasContent = false) { },
    elementOf("html") {
        strAttr("lang")
        strAttr("xmlns")
    },
    elementOf("i") { },
    elementOf("iframe", hasContent = false) {
        strAttr("allow")
        numAttr("height")
        enumAttr("loading") {
            entry("eager")
            entry("lazy")
        }
        strAttr("name")
        referrerPolicyAttr()
        strAttr("sandbox")
        strAttr("src")
        strAttr("srcdoc", "srcDoc")
        numAttr("width")
    },
    elementOf("img", hasContent = false) {
        strAttr("alt")
        enumAttr("crossorigin", "crossOrigin") {
            entry("anonymous")
            entry("UseCredentials", "use-credentials")
        }
        enumAttr("decoding") {
            entry("async")
            entry("sync")
            entry("auto")
        }
        strAttr("elementtiming", "elementTiming")
        enumAttr("fetchpriority") {
            entry("high")
            entry("low")
            entry("auto")
        }
        numAttr("height")
        boolAttr("ismap")
        enumAttr("loading") {
            entry("eager")
            entry("lazy")
        }
        referrerPolicyAttr()
        strAttr("sizes")
        strAttr("src")
        strAttr("srcset", "srcSet")
        numAttr("width")
        strAttr("usemap", "useMap")
    },
    elementOf("ins") {
        strAttr("cite")
        strAttr("datetime")
    },
    elementOf("kbd") { },
    elementOf("label") {
        strAttr("for", "htmlFor")
    },
    elementOf("legend", parent = listOf("FieldSet")) { },
    elementOf("li", parent = listOf("Ul", "Ol", "Menu")) {
        numAttr("value")
    },
    elementOf("link", hasContent = false) {
        enumAttr("as", "htmlAs") {
            entry("audio")
            entry("document")
            entry("embed")
            entry("fetch")
            entry("font")
            entry("image")
            entry("object")
            entry("script")
            entry("style")
            entry("track")
            entry("video")
            entry("worker")
        }
        enumAttr("crossorigin", "crossOrigin") {
            entry("anonymous")
            entry("UseCredentials", "use-credentials")
        }
        boolAttr("disabled")
        enumAttr("fetchpriority", "fetchPriority") {
            entry("high")
            entry("low")
            entry("auto")
        }
        strAttr("href")
        strAttr("HrefLang", "hreflang")
        strAttr("ImageSizes", "imagesizes")
        strAttr("ImageSrcSet", "imagesrcset")
        strAttr("integrity")
        strAttr("media")
        referrerPolicyAttr()
        strAttr("rel")
        strAttr("sizes")
        strAttr("title")
        strAttr("type")
    },
    elementOf("main") { },
    elementOf("map") {
        strAttr("name")
    },
    elementOf("mark") { },
    elementOf("menu") { },
    elementOf("meta", hasContent = false) {
        strAttr("charset")
        strAttr("content")
        enumAttr("http-equiv", "httpEquiv") {
            entry("ContentSecurityPolicy", "content-security-policy")
            entry("ContentType", "content-type")
            entry("DefaultStyle", "default-style")
            entry("XUaCompatible", "x-ua-compatible")
            entry("refresh")
        }
        strAttr("name")
    },
    elementOf("meter") {
        numAttr("value")
        numAttr("min")
        numAttr("max")
        numAttr("low")
        numAttr("high")
        numAttr("optimum")
    },
    elementOf("nav") { },
    elementOf("noscript", "NoScript") {},
    elementOf("object") {
        strAttr("data")
        strAttr("form")
        numAttr("height")
        strAttr("name")
        strAttr("type")
        strAttr("usemap", "useMap")
        numAttr("width")
    },
    elementOf("ol") {
        boolAttr("reversed")
        numAttr("start")
        enumAttr("type") {
            entry("LowercaseAlphabet", "a")
            entry("UppercaseAlphabet", "A")
            entry("LowercaseRomanNumber", "i")
            entry("UppercaseRomanNumber", "I")
            entry("Number", "1")
        }
    },
    elementOf("optgroup", "OptGroup", parent = listOf("Select")) {
        boolAttr("disabled")
        strAttr("label")
    },
    elementOf("option", parent = listOf("Select", "OptGroup", "Datalist")) {
        boolAttr("disabled")
        strAttr("label")
        boolAttr("selected")
        strAttr("value")
    },
    elementOf("output") {
        strAttr("for", "htmlFor")
        strAttr("form")
        strAttr("name")
    },
    elementOf("p") { },
    elementOf("picture") { },
    elementOf("pre") { },
    elementOf("progress") {
        numAttr("max")
        strAttr("value")
    },
    elementOf("q") {
        strAttr("cite")
    },
    elementOf("rp") { },
    elementOf("rt", parent = listOf("Ruby")) { },
    elementOf("ruby") { },
    elementOf("s") { },
    elementOf("samp") { },
    elementOf("script") {
        boolAttr("async")
        enumAttr("crossorigin", "crossOrigin") {
            entry("anonymous")
            entry("UseCredentials", "use-credentials")
        }
        boolAttr("defer")
        strAttr("integrity")
        boolAttr("nomodule", "noModule")
        strAttr("nonce")
        referrerPolicyAttr()
        strAttr("src")
        enumAttr("type") {
            entry("TextJavaScript", "text/javascript")
            entry("module")
            entry("importmap", "ImportMap")
        }
    },
    elementOf("search") { },
    elementOf("section") { },
    elementOf("select") {
        autoCompleteAttr()
        boolAttr("autofocus", "autoFocus")
        boolAttr("disabled")
        strAttr("form")
        boolAttr("multiple")
        strAttr("name")
        boolAttr("required")
        numAttr("size")
    },
    elementOf("slot") {
        strAttr("name")
    },
    elementOf("small") { },
    elementOf("source", hasContent = false) {
        strAttr("type")
        strAttr("src")
        strAttr("srcSet")
        strAttr("sizes")
        strAttr("media")
        numAttr("height")
        numAttr("width")
    },
    elementOf("span") { },
    elementOf("strong") { },
    elementOf("style") {
        strAttr("media")
        strAttr("nonce")
        strAttr("title")
    },
    elementOf("sub") {},
    elementOf("summary", parent = listOf("Details")) {},
    elementOf("sup") {},
    elementOf("table") { },
    elementOf("tbody", parent = listOf("Table")) { },
    elementOf("td", parent = listOf("Tr")) {
        numAttr("colspan", "colSpan")
        strAttr("headers")
        numAttr("rowspan", "rowSpan")
    },
    elementOf("template") {
        enumAttr("shadowrootmode", "shadowRootMode") {
            entry("open")
            entry("closed")
        }
        boolAttr("shadowrootclonable", "shadowRootClonable")
        boolAttr("shadowrootdelegatesfocus", "shadowRootDelegatesFocus")
    },
    elementOf("textarea", "TextArea") {
        autoCompleteAttr()
//        enumAttr("autocomplete", "autoComplete") {
//            entry("off")
//            entry("on")
//        }
        boolAttr("autofocus", "autoFocus")
        numAttr("cols")
        strAttr("dirname", "dirName")
        boolAttr("disabled")
        strAttr("form")
        numAttr("maxlength", "maxLength")
        numAttr("minlength", "minLength")
        strAttr("name")
        strAttr("placeholder")
        boolAttr("readonly")
        boolAttr("required")
        numAttr("rows")
        enumAttr("spellcheck", "spellCehck") {
            entry("true")
            entry("default")
            entry("false")
        }
        enumAttr("wrap") {
            entry("hard")
            entry("soft")
        }
    },
    elementOf("tfoot", "TFoot", parent = listOf("Table")) { },
    elementOf("th", parent = listOf("Th")) {
        strAttr("abbr")
        numAttr("colspan")
        strAttr("headers")
        numAttr("rowspan")
        enumAttr("scope") {
            entry("row")
            entry("col")
            entry("RowGroup", "rowgroup")
            entry("ColGroup", "colgroup")
        }
    },
    elementOf("thead", parent = listOf("Table")) { },
    elementOf("time") {
        strAttr("datetime")
    },
    elementOf("title", parent = listOf("Head")) { },
    elementOf("tr", parent = listOf("Tr", "THead", "TBody", "TFoot")) { },
    elementOf("track", hasContent = false, parent = listOf("Audio", "Video")) {
        boolAttr("default")
        enumAttr("kind") {
            entry("subtitles")
            entry("captions")
            entry("descriptions")
            entry("chapters")
            entry("metadata")
        }
        strAttr("label")
        strAttr("src")
        strAttr("srclang", "srcLang")
    },
    elementOf("u") { },
    elementOf("ul") { },
    elementOf("var", "HtmlVar") { },
    elementOf("video") {
        boolAttr("autoplay", "autoPlay")
        boolAttr("controls")
        enumAttr("crossorigin", "crossOrigin") {
            entry("anonymous")
            entry("UseCredentials", "use-credentials")
        }
        numAttr("height")
        boolAttr("loop")
        boolAttr("muted")
        boolAttr("playsinline", "playsInline")
        strAttr("poster")
        enumAttr("preload") {
            entry("none")
            entry("metadata")
            entry("auto")
        }
        strAttr("src")
        numAttr("width")
    },
    elementOf("wbr", hasContent = false) { },
) + inputElements

fun ElementAttrsBuilderScope.referrerPolicyAttr() =
    enumAttr("referrerpolicy", "referrerPolicy") {
        entry("NoReferrer", "no-referrer")
        entry("NoReferrerWHenDowngrade", "no-referrer-when-downgrade")
        entry("Origin", "origin")
        entry("OriginWhenCrossOrigin", "origin-when-cross-origin")
        entry("SameOrigin", "same-origin")
        entry("StrictOrigin", "strict-origin")
        entry("StrictOriginWhenCrossOrigin", "strict-origin-when-cross-origin")
        entry("UnsafeUrl", "unsafe-url")
    }