# mirrorball -kotlin web framework powered by compose-

mirrorball ("Mirabo") はKotlinとJetpack Composeを使ってWebアプリを開発するためのフレームワークです。

```kt
// 以下のコードはjsMainでもjvmMainでも機能します。
element.renderComposable {
    // your @Composable code
}
```

## mirrorballとCompose HTML

WebでComposeを使用する例としては
[Compose HTML](https://github.com/JetBrains/compose-multiplatform/blob/master/html/README.md)
があります。
しかしこれはサーバサイドでのレンダリングをサポートしていません。
実際Compose HTMLのソースコードにはjvmMainソースセットが存在しません。
これではサーバサイドでComposeを使用できません。mirrorballはこれを可能にします。

mirrorballを使用する最大のモチベーションはComposeを使用して
**シームレスにサーバサイドとクライアントサイドの両方でHTMLの構築を簡素に行える** ようにすることです。

## mirrorballのライブラリ群

mirrorballは複数のライブラリから構成されています。使用用途に合わせて必要なものだけをあなたのプロジェクトに取り入れることができます。

以下にmirrorballのライブラリ一覧を示します。

- [`mirrorball-core`](./core/README.ja.md) ...
  HTMLとComposeとの基本的な統合のコードが含まれています。mirrorballを使用するほぼすべてのプロジェクトで必要になります。
- [`mirrorball-ui`](./ui/README.ja.md) (WIP) ...
  mirrorballを使ってcomposeライクにWebフロントエンドを構築するためのライブラリ。composeにおけるcompose-uiやcompose-foundationに相当します。
- [`mirrorball-navigation`](./navigation/README.jp.md) (WIP) ... URLに応じて画面遷移を簡単に実装するためのライブラリ。
  composeにおけるcompose-navigationに相当します。

これらのライブラリを組み合わせて使用することも、
これら全てを統合しシームレスにWebアプリ開発が行える [bowフレームワーク](./bow/README.ja.md)
を使用することもできます。
