# Chapter 1 — Introduction to Android Development

## Notes

An Android app isn't one monolithic program the way a desktop app
often is — it's a collection of loosely-coupled **components**
(Activities, Services, Broadcast Receivers, Content Providers) that
the Android OS creates, pauses, and destroys on its own schedule based
on what the user is doing and what resources the device has available.

**How an app actually runs, at a high level:**
1. Your Java/Kotlin source compiles down to bytecode.
2. That bytecode is packaged, along with resources (layouts, images,
   strings) and a manifest describing the app, into an `.apk` (or
   `.aab` for Play Store distribution).
3. On the device, the Android Runtime (ART) executes that package —
   each app runs in its own sandboxed process with its own Linux user
   ID, isolating it from other apps by default.

**Why the OS controls your app's lifecycle, not you:** unlike a
desktop program that runs until the user quits it, an Android
Activity can be paused or killed at any time — the user switches apps,
a phone call comes in, the system needs memory back. Apps are written
against lifecycle callbacks (`onCreate`, `onPause`, `onResume`,
`onDestroy`) specifically because the app itself doesn't get to decide
when it stops running.

**Language choice:** Java has historically been the default language
for Android development (and is what this repo's examples use, to
match a Java-based curriculum), while Kotlin is Google's now-preferred
language for new projects — both compile to the same JVM-compatible
bytecode and can be mixed within a single project.

## Q&A

**Q1: Why can't an Activity assume it will keep running once started?**
A: The OS can pause or destroy any Activity at any time — for a phone
call, low memory, or the user switching apps — so apps are built
around lifecycle callbacks rather than assuming continuous execution.

**Q2: What are the four main types of Android app components?**
A: Activities (screens the user interacts with), Services (background
work with no UI), Broadcast Receivers (respond to system-wide events),
and Content Providers (share structured data between apps).

**Q3: What does "sandboxed" mean for an installed Android app?**
A: Each app runs under its own Linux user ID and process, with its own
isolated storage by default — one app can't read another app's private
files without an explicit permission grant.

**Q4: What's the difference between an `.apk` and an `.aab`?**
A: An `.apk` is a directly installable package. An `.aab` (Android App
Bundle) is the format used for Play Store distribution — Google Play
builds and serves optimized APKs from it per device configuration.

**Q5: Can a single Android project mix Java and Kotlin?**
A: Yes — both compile to JVM-compatible bytecode, and Android Studio
supports both languages in the same project, class-by-class.
