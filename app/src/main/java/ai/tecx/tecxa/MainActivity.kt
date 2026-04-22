// (UI Logic)
// Inside onCreate
val btn = findViewById<Button>(R.id.btnRunInference)
val resultText = findViewById<TextView>(R.id.txtResult)
val imageDisplay = findViewById<ImageView>(R.id.imageView)

// Initialize your model class
val inference = ModelInference(this)

btn.setOnClickListener {
    // 1. Get your bitmap (from assets, camera, or drawable)
    val bitmap = (imageDisplay.drawable as BitmapDrawable).bitmap
    
    // 2. Convert and Run
    val inputData = bitmapToFloatArray(bitmap)
    val output = inference.runInference(inputData)
    
    // 3. Show result
    resultText.text = "Output: $output"
}
