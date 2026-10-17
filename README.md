# HelloConstraint

An Android application built as part of the Android Developer Fundamentals curriculum. This project demonstrates responsive UI design using `ConstraintLayout`, multi-orientation layout configurations, adaptive tablet layouts, and robust state management.

## Features

- **Interactive Counter**: Increment count values using the Count button, reset to zero using the Zero button, or trigger a Toast notification.
- **Dynamic Button Styling**: 
  - The Count button changes color dynamically based on whether the current count is even or odd.
  - The Zero button is disabled and grayed out when the count is `0`, and becomes active when the count is greater than `0`.
- **Multi-Screen & Orientation Support**:
  - **Portrait Layout**: Standard vertical arrangement optimized for phones.
  - **Landscape Layout (`layout-land`)**: Optimized side-by-side arrangement for horizontal screens.
  - **Tablet Layout (`layout-xlarge`)**: Tailored layout structure for larger tablet displays.
- **State Persistence**: Preserves counter and button states across screen rotations and configuration changes using `onSaveInstanceState`.
- **Modern Android Practices**: Implements edge-to-edge window insets and fully externalized string resources.

## Project Structure

```text
HelloConstraint/
├── app/
│   ├── src/main/
│   │   ├── java/com/domenkoder/helloconstraint/MainActivity.java
│   │   ├── res/
│   │   │   ├── layout/activity_main.xml         # Portrait layout
│   │   │   ├── layout-land/activity_main.xml    # Landscape layout
│   │   │   ├── layout-xlarge/activity_main.xml  # Tablet layout
│   │   │   └── values/strings.xml               # Localized string resources
```

## Getting Started

1. Clone or open this repository in **Android Studio**.
2. Sync project with Gradle files.
3. Run the app on an Android Virtual Device (AVD) or physical device.
