package com.example.agatepedia.ui.camera

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.agatepedia.databinding.FragmentCameraBinding
import java.io.File
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class CameraFragment : Fragment() {

    private var _binding: FragmentCameraBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var captureBtn: Button
    private lateinit var cameraView: PreviewView
    private lateinit var safeContext: Context
    private var imageCapture: ImageCapture? = null
    private lateinit var outputDirectory: File
    private lateinit var cameraExecutor: ExecutorService

    override fun onAttach(context: Context) {
        super.onAttach(context)
        safeContext = context
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
        val dashboardViewModel =
            ViewModelProvider(this).get(CameraViewModel::class.java)

        _binding = FragmentCameraBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        captureBtn= view.findViewById(R.id.camera_capture_button)
//        cameraView= view.findViewById(R.id.viewFinder)
//
//        // Request camera permissions
//        if (allPermissionsGranted()) {
//            startCamera()
//        } else {
//            ActivityCompat.requestPermissions(
//                view.context as Activity, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS)
//        }
//
//        // Set up the listener for take photo button
//        captureBtn.setOnClickListener {
//            takePhoto()
//            /*val i = Intent(this, ImagePreview::class.java)
//            i.putExtra("photo", )*/
//        }
//
//        outputDirectory = getOutputDirectory()
//
//        cameraExecutor = Executors.newSingleThreadExecutor()
//    }
//
//    companion object {
//        fun newInstance() = CameraFragment()
//        private const val TAG = "CameraXBasic"
//        private const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"
//        private const val REQUEST_CODE_PERMISSIONS = 10
//        private val REQUIRED_PERMISSIONS = arrayOf(android.Manifest.permission.CAMERA)
//    }
}