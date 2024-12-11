### Bug Description

Scala 3 macros seem to cause scoverage to fail to produce correct coverage reports.

The code is structured as follows:

```
.
└── org
    └── example
        ├── App.scala
        ├── NumUtils.scala
        ├── greeting
        │   └── Greeting.scala
        └── macros
            └── Macros.scala
```

The key points are:
  - `Greeting.scala` defines the logic to greet users (`greet: Option[String] => String`);
  - `Macros.scala` defines a macro to decorate strings at compile time (`decorate: String => String`);
  - `App.scala` greets an undefined user and decorates a string using the macro (`println(decorate(greet(None)))`);
  - `NumUtils.scala` defines a simple function `isEven` which is completely unrelated to the rest of the code.

The coverage report fails to include `Greeting.scala`, `Macros.scala`, and `NumUtils.scala`. Moreover, it shows 100%
coverage for `App.scala` even though it should be 0% (`main` method is never called in the tests).

### Steps to Reproduce

```
sbt clean coverage test
sbt coverageReport
```

To make sure that macros are the cause of the issue, simply make the `decorate` macro into regular method:

```scala
def decorate(s: String): String = s">>> $s <<<"
```

and re-run tests and report generation. Coverage is now correctly computed.