# mirrorball -kotlin web framework powered by compose-runtime

mirrorball ("Mirabo") is a framework for developing web apps using Kotlin and Jetpack Compose.

```kt
// The following code works for both jsMain and jvmMain.
element.renderComposable {
  // your @Composable code
}
```

## mirrorball vs Compose HTML

An example of using Compose on the Web
is [Compose HTML](https://github.com/JetBrains/compose-multiplatform/blob/master/html/README.md)
().
However, it does not support server-side rendering. In fact, the source code for Compose
HTML source code does not have a jvmMain source set. Mirrorball builds on this.

The primary motivation for using mirrorballs is to make it easy to use Compose to seamlessly build
HTML on both the
server and client side.

## mirrorball libraries

mirrorball consists of several libraries. You can incorporate only the ones you need for your
project, depending on your
intended use.

The following is a list of mirrorball's libraries.

- [`mirrorball-core`](./core/README.md) ... It contains code for basic integration with HTML and
  Compose, which is
  required for almost any project that uses mirrorball.
- [`mirrorball-ui`](./ui/README.md) (WIP) ... A library for building a web frontend like compose
  using mirrorball,
  equivalent to compose-ui or compose-foundation in
  compose.
- [`mirrorball-navigation`](./navigation/README.md) (WIP) ... A library for easy implementation of
  screen
  transitions according to URLs.
  Equivalent to compose-navigation in compose.
- [`mirrorball-ktor`](./ktor/README.md) ... Integration with ktor-server.

These libraries can also be used in combination.
You can also use [bow framework](./bow/README.md).
