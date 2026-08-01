# Chapter 4 — Java Basics

## Notes

This chapter is a Java refresher aimed squarely at what Android
development actually uses day to day: variables, conditionals, loops,
methods, and basic OOP (classes, objects, inheritance) — the same
fundamentals from general Java, but framed around patterns you'll see
constantly in Activities and Views.

**Variables you'll declare constantly in Android code:** primitives
for simple state (`int score`, `boolean isRunning`), and object
references for UI components (`Button`, `TextView`) and app-specific
data classes.

**Conditionals and loops** work exactly like standard Java — but show
up in very Android-specific places: checking `if (permission granted)`
before accessing the camera, looping over a `List<Item>` to populate a
`RecyclerView`.

**Methods as event handlers:** a huge portion of Android code is
methods that exist purely to respond to something — `onClick()`,
`onSensorChanged()`, `onLocationChanged()`. These aren't called
directly by your code; the Android framework calls them for you at the
right moment.

**Inheritance is structural, not optional:** `MainActivity extends
Activity` isn't a design choice you're making — it's how Android knows
your class *is* an Activity and can plug it into the OS's lifecycle
management. The same pattern applies to `Service`, `BroadcastReceiver`,
and View subclasses.

## Q&A

**Q1: Why do so many Android methods start with `on` (`onCreate`,
`onClick`, `onSensorChanged`)?**
A: They're callback methods — the Android framework calls them at
specific moments (creation, a tap, a sensor update), rather than your
code calling them directly. The `on` prefix signals "this runs in
response to an event."

**Q2: Why does `MainActivity` have to `extends Activity` (or
`AppCompatActivity`) rather than just being a plain class?**
A: Inheriting from `Activity` is what lets the Android OS recognize
and manage your class through its lifecycle — without that
inheritance, the framework has no hook to create, pause, resume, or
destroy your screen.

**Q3: Give an example of a loop you'd realistically write in an
Android app.**
A: Iterating a `List<Item>` to bind each item's data into a
`RecyclerView` row, or looping over available Bluetooth devices found
during a scan.

**Q4: What kind of variable would you use to track whether a
background task is currently running, and why?**
A: A `boolean` flag (e.g. `isLoading`) — cheap, easy to check in an
`if` before starting duplicate work, and easy to reason about from the
UI thread.

**Q5: Why is understanding basic OOP (classes, objects, inheritance)
a prerequisite for Android development specifically, not just general
Java?**
A: Nearly every Android component you write is a subclass of a
framework class (`Activity`, `Service`, `View`, etc.) — without
understanding inheritance and method overriding, the entire
"framework calls your code" pattern doesn't make sense.
