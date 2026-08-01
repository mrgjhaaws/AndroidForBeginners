# Chapter 3 — Test Drive: The Hello World App

## Notes

Every Android Studio project follows a predictable folder layout. The
pieces a beginner touches first:

- **`AndroidManifest.xml`** — declares the app's components
  (Activities, permissions, app icon/label). If an Activity isn't
  listed here, the OS can't launch it.
- **`res/layout/*.xml`** — UI layouts, written declaratively in XML
  rather than built up in code.
- **`res/values/strings.xml`** — user-facing text lives here, not
  hardcoded in Java, so it can be localized per language.
- **`java/` (or `kotlin/`)** — your actual source code, organized by
  package name.
- **`build.gradle` (module-level)** — dependencies and build config
  for this specific module/app.

**Two ways to build a layout:** the XML file can be edited directly as
text, or through Android Studio's visual "Layout Editor." Both produce
the exact same XML — the visual editor is a convenience, not a
different underlying mechanism.

**Connecting XML to Java:** `findViewById(R.id.someView)` looks up a
view by the `android:id` you gave it in XML, returning a reference you
can manipulate from code. `R` is an auto-generated class mapping every
resource (layouts, strings, IDs, drawables) to a unique integer
constant — you never hand-write it.

**Running the app:** "Build" compiles everything into an APK.
"Run" additionally installs that APK onto a selected target (emulator
or connected physical device via USB debugging) and launches it.

## Q&A

**Q1: What happens if an Activity exists as a Java class but isn't
declared in `AndroidManifest.xml`?**
A: The OS won't know it exists as a launchable component — attempting
to start it typically throws an `ActivityNotFoundException` at
runtime, even though the code compiles fine.

**Q2: Why does Android encourage putting text in `strings.xml`
instead of directly in Java code?**
A: It centralizes user-facing text and enables localization — the
system can swap in a different `strings.xml` per language/locale
without touching any Java code.

**Q3: What does `findViewById()` actually do?**
A: It looks up a view that was inflated from your XML layout by its
`android:id`, returning a Java reference to that live view object so
you can read or modify it from code.

**Q4: What is the auto-generated `R` class for?**
A: It maps every resource in your project (layouts, strings, drawables,
IDs) to a unique integer constant, so code can reference resources
type-safely instead of by raw string/filename.

**Q5: What's the practical difference between "Build" and "Run" in
Android Studio?**
A: Build compiles and packages the app into an APK. Run does that,
then also installs and launches the APK on a chosen emulator or
connected device.
