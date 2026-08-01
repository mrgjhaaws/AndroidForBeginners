# Chapter 2 — Setting Up Your Development Environment

## Notes

Android development centers on **Android Studio** (JetBrains' IntelliJ
platform, configured for Android) bundled with the **Android SDK**
(platform tools, build tools, and per-API-level system images) and
**Gradle** as the build system.

**Core pieces and what they do:**
- **Android Studio** — the IDE: code editing, layout preview, debugger,
  profiler.
- **Android SDK** — compilers, platform libraries per Android version
  (API level), and command-line tools (`adb`, `sdkmanager`).
- **Gradle** — declarative build scripts (`build.gradle`) describing
  dependencies, build variants, and how to package the app.
- **AVD (Android Virtual Device) / Emulator** — a software-simulated
  device for running and testing apps without physical hardware.

**Emulators vs. real devices:** an emulator is convenient (no cables,
easy to reset, can simulate different screen sizes/API levels) but
runs noticeably slower and can't perfectly replicate real hardware
sensors, camera behavior, or performance characteristics — that's why
serious testing eventually needs a physical device too.

**API level vs. Android version:** Android version numbers (like
"Android 14") map to integer **API levels** (like 34) that your code
targets. `minSdkVersion` sets the oldest OS your app supports;
`targetSdkVersion` tells the OS which behaviors your app was built
and tested against — these are configured in `build.gradle`, not in
Java code.

## Q&A

**Q1: What's the difference between Android Studio, the Android SDK,
and Gradle?**
A: Android Studio is the IDE. The Android SDK provides the platform
libraries and tools your code compiles against. Gradle is the build
system that actually compiles, packages, and assembles the app using
those SDK tools.

**Q2: Why might an app behave differently on an emulator than on a
real device?**
A: Emulators simulate hardware in software — sensors, camera
performance, and raw CPU/GPU speed can all differ meaningfully from a
real device, even at the same "API level."

**Q3: What do `minSdkVersion` and `targetSdkVersion` each control?**
A: `minSdkVersion` is the oldest Android version the app will install
on at all. `targetSdkVersion` tells the OS which API behaviors the app
was designed for, affecting things like default permission handling.

**Q4: Where do you configure SDK/build settings for an Android
project — in Java code, or somewhere else?**
A: In `build.gradle` (Groovy or Kotlin DSL), not in Java source files —
build configuration is declarative and separate from application
logic.

**Q5: Why does the Android SDK ship per-API-level components instead
of one universal library?**
A: Different Android versions expose different platform APIs and
behaviors; per-level SDK components let a project compile against and
test on specific target versions precisely.
