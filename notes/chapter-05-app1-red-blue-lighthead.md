# Chapter 5 — Android App #1: Red/Blue Lighthead

## Notes

The first real app is intentionally tiny: a button that toggles the
screen's background color between two states. Small as it is, it
introduces the core loop every interactive Android app relies on:
**wire a UI event to a listener, mutate state, update the view.**

**The pattern:**
1. Get a reference to a view (`findViewById`).
2. Attach a listener (`setOnClickListener`).
3. Inside the listener, flip some state and call a method that updates
   the UI to reflect it (`setBackgroundColor`, `setText`, etc.).

**Where state lives:** for something this simple, a single `boolean`
field on the Activity (e.g. `isRed`) is enough to track "which state
are we in." As apps grow, this state usually moves out of the Activity
and into a dedicated ViewModel — but the underlying idea (some value
that determines what's currently shown) doesn't change.

**Colors in Android code:** rather than hardcoding hex values
everywhere, colors are usually defined once in `res/values/colors.xml`
and referenced by resource ID (`R.color.app_red`) — the same
centralization idea as `strings.xml` for text.

## Q&A

**Q1: What three steps does "wire a button to change something on
screen" always involve?**
A: Get a reference to the view, attach a listener to it, and inside
that listener update some state and refresh the UI to reflect it.

**Q2: Why track state with a `boolean` field instead of just reading
the current background color back to decide what to switch to?**
A: A dedicated flag is explicit and doesn't depend on correctly
reversing a color lookup — it's a clearer, more maintainable way to
represent "which of two states are we in."

**Q3: Why define colors in `colors.xml` instead of hardcoding hex
values in Java?**
A: Centralizing colors makes them reusable and themeable — change one
XML value and every reference updates, instead of hunting through Java
files for hardcoded hex strings.

**Q4: What does `setOnClickListener` actually register?**
A: A callback object that the Android framework invokes when that
specific view receives a tap — your code doesn't poll for clicks, the
framework calls you.

**Q5: As an app grows past this simple example, where does UI state
typically move, and why?**
A: Into a dedicated ViewModel, so state survives configuration changes
(like screen rotation) and stays separate from Activity lifecycle
concerns — but the "state determines what's shown" idea is the same
one used here.
