//(AI Logic & Bitmap conversion)
package ai.tecx.tecxa // Change to your actual package name

import android.content.Context
import ai.onnxruntime.*

class ModelInference(private val context: Context) {
    private var env: OrtEnvironment = OrtEnvironment.getEnvironment()
    private var session: OrtSession? = null

    init {
        // Load the model from src/main/res/raw/your_model.onnx
        val modelBytes = context.resources.openRawResource(R.raw.your_model).readBytes()
        session = env.createSession(modelBytes)
    }

    fun runInference(yourInputData: FloatArray): Any? {
        val inputName = session?.inputNames?.iterator()?.next() ?: return null
        
        // Ensure shape matches what your PyTorch model expects
        val shape = longArrayOf(1, 1, 28, 28) // Example shape, adjust to yours!
        
        val inputTensor = OnnxTensor.createTensor(env, yourInputData, shape)
        
        val results = session?.run(mapOf(inputName to inputTensor))
        
        // This returns the first output of the model
        return results?.get(0)?.value
    }
}
