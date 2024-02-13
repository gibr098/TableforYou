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
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tableforyou.Authentication.EmailPasswordActivity
import com.example.tableforyou.Camera.CameraActivity
import com.example.tableforyou.Data.MyData
import com.example.tableforyou.Data.Restorant
import com.example.tableforyou.Data.RestorantList
import com.example.tableforyou.Elements.BottomNavigationBar
import com.example.tableforyou.Navigation.AppNavHost
import com.example.tableforyou.Navigation.BottomNavigationBarScreens
import com.example.tableforyou.Navigation.Home
import com.example.tableforyou.Navigation.navigateSingleTopTo
import com.example.tableforyou.Pages.imageAdded
import com.example.tableforyou.Pages.photoTaken
import com.example.tableforyou.ui.theme.TableforYouTheme
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.firebase.database.getValue
import java.io.File
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

var photorev by mutableStateOf(Uri.parse("android.resource://com.example.tableforyou/"+ R.drawable.defaultimg))

private lateinit var database: DatabaseReference

class MainActivity : ComponentActivity() {
    private lateinit var outputDirectory: File
    private lateinit var cameraExecutor: ExecutorService

    private var shouldShowCamera: MutableState<Boolean> = mutableStateOf(false)

    private lateinit var photoUri: Uri
    private var shouldShowPhoto: MutableState<Boolean> = mutableStateOf(false)

    val pickMedia =
        registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            // Callback is invoked after the user selects a media item or closes the
            // photo picker.
            if (uri != null) {
                Log.d("PhotoPicker", "Selected URI: $uri")
                photorev = uri
            } else {
                Log.d("PhotoPicker", "No media selected")
            }
        }

    fun getImagerev():Uri{
        return photorev
    }




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
                        this.startActivity(intent)},
                    signOut = {
                        val intent = Intent(this, EmailPasswordActivity::class.java)
                        this.startActivity(intent)
                        EmailPasswordActivity().updatePsw("")
                        this.finish()
                    },
                    addImage = { pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageAndVideo));imageAdded =true; photoTaken =false}
                    )


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

        /*
        for (i in 1..4 ) {
            MyData().writeRestorant(RestorantList.list[i], "Restorant-$i")
        }*/
        MyData().writeRestorant(RestorantList.list[1])

        database = Firebase
            .database("https://tableforyou-f235e-default-rtdb.europe-west1.firebasedatabase.app/")
            .getReference("Restorant1")
        /*
        fun addPostEventListener(resReference: DatabaseReference) {
            val resListener = object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    // Get Post object and use the values to update the UI
                    val res = dataSnapshot.getValue<Restorant>()
                    Log.w("mydata", "value get from the db: $res")
                    // ...
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Getting Post failed, log a message
                    Log.w("mydata", "loadPost:onCancelled", databaseError.toException())
                }
            }
            resReference.addValueEventListener(resListener)
        }*/

        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI
                val res = dataSnapshot.getValue<Restorant>()
                //RestorantList.list.add(res!!)
                Log.w("mydata", "value get from the db: $res")
                // ...
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w("mydata", "loadPost:onCancelled", databaseError.toException())
            }
        })









    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    openCamera: () -> Unit,
    signOut:()-> Unit,
    addImage: ()-> Unit
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
                openCamera = openCamera,
                signIn = {},
                GsignIn = {},
                createAccount = {},
                signOut = signOut,
                SignOUT = {},
                addImage = addImage
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







