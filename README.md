# cljondroid

This is an application for testing the lein-droid plugin for Leiningen

I was having some problems with the output of lein droid new, so I took the version from the most recent [sample](https://github.com/clojure-android/lein-droid/tree/master/sample) from the `lein-droid` repo.

This can be built for development with

```
lein droid doall
```

or with Skummet to produce a lean build with

```
lein with-profile lean do clean, droid doall
```

## License

Copyright © 2015 Mark Godfrey

Distributed under the Eclipse Public License, the same as Clojure.
