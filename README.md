# Beginner's Guide to Android App Development — Study Companion

An original, independently-written companion covering an 11-chapter
beginner Android curriculum: fundamentals through 7 hands-on apps —
code, notes, and Q&A per chapter.

> **Note on originality:** the code, notes, and Q&A in this repo are
> written from scratch to cover the same topics as a standard beginner
> Android curriculum. Nothing here is copied from any book — every
> example, explanation, and question was independently authored for
> this repo.

> **A note on running the code:** unlike a plain-Java console app, most
> files here depend on the Android SDK (`android.app.Activity`,
> `android.widget.*`, etc.) and are meant to be dropped into an Android
> Studio project — they aren't standalone-compilable with `javac`
> alone (Chapter 4's `ScoreTracker.java` is the one exception: it's
> pure Java and compiles/runs on its own). Each `.java` file includes
> its paired XML layout as a comment block at the bottom, and a manifest
> permission line where relevant.

## Structure

```
/code/    — one folder per chapter/app. Each .java file contains a
            commented-out UNSOLVED (buggy) exercise followed by the
            SOLVED, working version, plus the matching XML layout as
            a trailing comment block.
/notes/   — one markdown file per chapter: a concept summary plus
            5-7 original Q&A pairs to test your understanding.
```

## Chapters

| # | Topic | Code | Notes |
|---|-------|------|-------|
| 1 | Introduction to Android Development | [`code/01-introduction/`](code/01-introduction/MainActivity.java) | [notes](notes/chapter-01-introduction.md) |
| 2 | Setting Up Your Development Environment | [`code/02-development-environment/`](code/02-development-environment/build.gradle) | [notes](notes/chapter-02-development-environment.md) |
| 3 | Test Drive: The Hello World App | [`code/03-hello-world-app/`](code/03-hello-world-app/HelloWorldActivity.java) | [notes](notes/chapter-03-hello-world-app.md) |
| 4 | Java Basics | [`code/04-java-basics/`](code/04-java-basics/ScoreTracker.java) | [notes](notes/chapter-04-java-basics.md) |
| 5 | App #1: Red/Blue Lighthead | [`code/05-app1-red-blue-lighthead/`](code/05-app1-red-blue-lighthead/LightheadActivity.java) | [notes](notes/chapter-05-app1-red-blue-lighthead.md) |
| 6 | App #2: Body Mass Index (BMI) | [`code/06-app2-bmi-calculator/`](code/06-app2-bmi-calculator/BmiCalculatorActivity.java) | [notes](notes/chapter-06-app2-bmi-calculator.md) |
| 7 | App #3: Simple Dice Roller | [`code/07-app3-dice-roller/`](code/07-app3-dice-roller/DiceRollerActivity.java) | [notes](notes/chapter-07-app3-dice-roller.md) |
| 8 | App #4: The Compass | [`code/08-app4-compass/`](code/08-app4-compass/CompassActivity.java) | [notes](notes/chapter-08-app4-compass.md) |
| 9 | App #5: Show My Location (GPS) | [`code/09-app5-gps-location/`](code/09-app5-gps-location/LocationActivity.java) | [notes](notes/chapter-09-app5-gps-location.md) |
| 10 | App #6: S.O.S. Message Sender | [`code/10-app6-sos-message-sender/`](code/10-app6-sos-message-sender/SosSenderActivity.java) | [notes](notes/chapter-10-app6-sos-message-sender.md) |
| 11 | App #7: 2D Platform Game | [`code/11-app7-2d-platformer/`](code/11-app7-2d-platformer/PlatformerActivity.java) | [notes](notes/chapter-11-app7-2d-platformer.md) |

## Using this with a fresh Android Studio install

1. Create a new project (Empty Views Activity, Java) in Android Studio.
2. For any chapter, copy the `.java` file's class body into a matching
   Activity in your project, and copy the trailing XML comment block
   into the matching file under `res/layout/`.
3. Add any manifest permission lines shown at the bottom of a chapter's
   code file (Chapters 9 and 10 need one each) to `AndroidManifest.xml`.
4. Register each new Activity in `AndroidManifest.xml` if it isn't your
   launcher Activity.
