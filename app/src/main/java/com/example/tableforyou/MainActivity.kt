package com.example.tableforyou

//import androidx.compose.ui.tooling.data.EmptyGroup.name
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tableforyou.Camera.CameraActivity
import com.example.tableforyou.Elements.BottomNavigationBar
import com.example.tableforyou.Navigation.AppNavHost
import com.example.tableforyou.Navigation.BottomNavigationBarScreens
import com.example.tableforyou.Navigation.Home
import com.example.tableforyou.Navigation.navigateSingleTopTo
import com.example.tableforyou.ui.theme.TableforYouTheme
import java.io.File
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


class MainActivity : ComponentActivity() {
    private lateinit var outputDirectory: File
    private lateinit var cameraExecutor: ExecutorService

    private var shouldShowCamera: MutableState<Boolean> = mutableStateOf(false)

    private lateinit var photoUri: Uri
    private var shouldShowPhoto: MutableState<Boolean> = mutableStateOf(false)




    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            Log.i("kilo", "Permission granted")
            shouldShowCamera.value = true
        } else {
            Log.i("kilo", "Permission denied")
        }
    }

    private fun requestCameraPermission() {
        when {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED -> {
                Log.i("kilo", "Permission previously granted")
                shouldShowCamera.value = true
            }

            ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.CAMERA
            ) -> Log.i("kilo", "Show camera permissions dialog")

            else -> requestPermissionLauncher.launch(Manifest.permission.CAMERA)
        }
    }

    private fun handleImageCapture(uri: Uri) {
        Log.i("kilo", "Image captured: $uri")
        shouldShowCamera.value = false
        photoUri = uri
        shouldShowPhoto.value = true
    }

    private fun getOutputDirectory(): File {
        val mediaDir = externalMediaDirs.firstOrNull()?.let {
            File(it, resources.getString(R.string.app_name)).apply { mkdirs() }
        }

        return if (mediaDir != null && mediaDir.exists()) mediaDir else filesDir
    }

    override fun onDestroy() {
        super.onDestroy()
        cameraExecutor.shutdown()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TableforYouTheme {
                MyApp(
                    modifier = Modifier.fillMaxSize(),
                    openCamera = {
                        val intent = Intent(this, CameraActivity::class.java)
                        this.startActivity(intent)})


                //MyAppR1(modifier = Modifier.fillMaxSize())

            /*
                if (shouldShowCamera.value) {
                    CameraView(
                        outputDirectory = outputDirectory,
                        executor = cameraExecutor,
                        onImageCaptured = ::handleImageCapture,
                        onError = { Log.e("kilo", "View error:", it) }
                    )
                }

            if (shouldShowPhoto.value) {
                Image(
                    painter = rememberImagePainter(photoUri),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }*/


            /* BOUNCINGBALL LOADING SCREEN
                val bouncingBallView = BouncingBallView(this);
                setContentView(bouncingBallView);
                bouncingBallView.setBackgroundColor(Color.WHITE);
                 */

            // OPEN CAMERA TO TAKE FOTO
                /*
                Button(onClick = {
                    val intent = Intent(this, CameraActivity::class.java)
                    this.startActivity(intent)
                }) {

                }*/
        }


        }
        requestCameraPermission()

        outputDirectory = getOutputDirectory()
        cameraExecutor = Executors.newSingleThreadExecutor()
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    openCamera: () -> Unit
) {
    TableforYouTheme {
        //var currentScreen: AppDestination by remember { mutableStateOf(Home) }
        val navController = rememberNavController()

        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination

        val currentScreen = BottomNavigationBarScreens.find { it.route == currentDestination?.route } ?: Home


        Scaffold(
            bottomBar = {
                BottomNavigationBar(
                    onTabSelected = { newScreen ->
                        navController.navigateSingleTopTo(newScreen.route)},
                    currentScreen = currentScreen
                )
                        },
        )
        { padding ->
            //HomeScreen(Modifier.padding(padding))
            //RestorantPageScreen(Modifier.padding(padding))
            AppNavHost(
                navController = navController,
                modifier = Modifier.padding(padding),
                openCamera = openCamera
            )

        }
    }
}



@Composable
fun MyAppR1(modifier: Modifier = Modifier) {
    TableforYouTheme {
        //RestorantPageScreen()
        //SettingsScreen()
    }
}







