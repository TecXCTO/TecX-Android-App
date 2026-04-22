# TecX-Android-App
TecX Android App

To implement this in a real Android project, you must follow the standard Android Project Structure. Here is exactly where every file belongs:
1. Model File (The AI)
Put your exported .onnx file here.
Path: app/src/main/res/raw/your_model.onnx
Note: If the raw folder doesn't exist, create it inside res.
2. Logic File (The "Brain")
Create a Kotlin class to handle the loading and inference.
Path: app/src/main/java/com/yourpackage/ModelInference.kt
Purpose: Contains the OrtSession and the runInference function we discussed.
3. UI/Controller (The "Trigger")
Call the inference from your main screen.
Path: app/src/main/java/com/yourpackage/MainActivity.kt
Purpose: Takes the user's image, converts it via bitmapToFloatArray, and shows the result.
4. Configuration (The "Rules")
Register the ONNX library so Android knows how to use it.
Path: app/build.gradle (Module level)
Action: Add implementation 'com.microsoft.onnxruntime:onnxruntime-android:latest.release' to the dependencies block.
Full Directory Visualization
```
TecXAndroidApp/
├── app/
│   ├── build.gradle (Add ONNX dependency here)
│   └── src/
│       └── main/
│           ├── java/com/example/myapp/
│           │   ├── MainActivity.kt (UI Logic)
│           │   └── ModelInference.kt (AI Logic & Bitmap conversion)
│           ├── res/
│           │   ├── layout/
│           │   │   └── activity_main.xml (Your UI Design)
│           │   └── raw/
│           │       └── your_model.onnx (PASTE MODEL HERE)
│           └── AndroidManifest.xml
└── build.gradle (Project level)

```
5. Important Step for Python/Termux users

Since you are working in Termux, when you move the file from your Termux environment to your computer/Android Studio, use the cp command to move it to a shared folder (like /sdcard/Download) so you can access it:

cp your_model.onnx /sdcard/Download/
