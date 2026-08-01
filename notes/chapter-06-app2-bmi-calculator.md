# Chapter 6 — Android App #2: Body Mass Index (BMI) Calculator

## Notes

This app introduces **reading user input** — the natural next step
after a static toggle. It combines three widget types that show up in
almost every form-style Android screen:

- **`TextView`** — display-only labels and results.
- **`EditText`** — user-editable text input; `inputType="numberDecimal"`
  restricts the on-screen keyboard and input to numbers.
- **`Button`** — triggers the calculation when tapped.

**The core challenge is input validation, not the math.** BMI itself
is a one-line formula (`weight / height²`), but real apps have to
handle: empty fields, non-numeric text, and division by zero (height
of 0). `EditText.getText().toString()` always returns a `String` —
converting it to a `double` safely (catching `NumberFormatException`)
is where most of the actual logic lives.

**Units matter and should be explicit in the UI.** A height field
without a visible unit label is a common source of user confusion (and
support tickets) — pairing every numeric input with a unit hint (a
label, or `android:hint` text) avoids silently wrong calculations.

**Updating the result:** the calculated BMI is written back into a
`TextView` via `.setText()`, same pattern as previous chapters — read
from one view, compute, write to another.

## Q&A

**Q1: Why does `EditText.getText().toString()` always return a
`String`, even for a field meant to hold a number?**
A: `EditText` is fundamentally a text input widget — the numeric
keyboard restriction (`inputType`) only changes what the user *can
type*, not the underlying data type Android stores it as.

**Q2: What happens if you call `Double.parseDouble()` on an empty
string, and how should the app handle it?**
A: It throws a `NumberFormatException`. The app should catch it and
show a validation message, rather than letting the app crash or
silently compute a wrong result.

**Q3: Why is a height of `0` a special case to guard against in a BMI
calculator?**
A: BMI divides by height squared — a height of zero causes a
division-by-zero, which in floating-point Java produces `Infinity`
rather than crashing, silently corrupting the displayed result if not
checked for explicitly.

**Q4: What does `android:inputType="numberDecimal"` actually change?**
A: It changes the on-screen keyboard shown to the user (numeric with a
decimal point) and provides a input hint to the system — it does not,
by itself, prevent malformed input like an empty field or multiple
decimal points.

**Q5: Why pair each numeric `EditText` with a visible unit label
(like "kg" or "cm")?**
A: Without an explicit unit, users may enter values in the wrong unit
(pounds instead of kilograms, for example), producing a technically
"successful" but practically meaningless calculation.
