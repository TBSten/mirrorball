# mirrorball core

mirrorball coreにはH以下のようなHTMLとComposeとの基本的な統合のコードが含まれています。

- Compose RuntimeでHTMLを記述するためのコード。
- 事前定義されているHTMLタグ・属性・イベント。
- 各プラットフォームで描画するためのrenderComposable関数。

## example

```kt
// 🌐 src/jsMain/main.kt
val root = document.getElementBydId("root")

root.renderComposable {
    Div {
        Button(
            attrs = {
                style { background }
                type(ButtonType.Button)
            },
        ) {
            onClick { alert("clicked button ❤️") }
            +"click me"
        }
    }
}

// 🖥️ src/jvmMain/main.kt
val doc = DocumentBuilderFactory
    .newInstance()
    .newDocumentBuilder()
    .newDocument()
doc.renderComposable {
    Div {
        Button(
            attrs = {
                style { background }
                type(ButtonType.Button)
            },
        ) {
            +"click me"
        }
    }
}
```

より詳細なコードについては `/demo` ディレクトリ配下のプロジェクトコードを参照してください。
