package com.example.tableforyou.Authentication

import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tableforyou.Data.MyData
import com.example.tableforyou.Data.Table
import com.example.tableforyou.Data.UTENTIDADB
import com.example.tableforyou.Data.User
import com.example.tableforyou.MainActivity
import com.example.tableforyou.Navigation.AppNavHost2
import com.example.tableforyou.R
import com.example.tableforyou.ui.theme.TableforYouTheme
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.storage
import java.io.ByteArrayOutputStream

private lateinit var database: DatabaseReference

var pickphoto by mutableStateOf(false)
var mail by mutableStateOf("")
var password by mutableStateOf("")
var name by mutableStateOf("")
var url by mutableIntStateOf(0)
var defaultimg = "android.resource://com.example.tableforyou/"+ R.drawable.defaultimg
var profileimage by mutableStateOf(defaultimg)
var Profileimg by mutableStateOf(Uri.parse(profileimage))

class EmailPasswordActivity : ComponentActivity() {


    private lateinit var auth: FirebaseAuth
    fun updateMail(input: String) { mail = input }
    fun updatePsw(input: String) { password = input }
    fun updateName(input: String) { name = input }
    fun updateImg(input: Int) { url = input }

    fun getMail(): String{ return mail }
    fun getName(): String{ return name }
    fun getPwd(): String{ return name }
    fun getUri(): Any { return Profileimg }
    fun getProfImg(): String { return profileimage }

        val pickMedia =
        registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            // Callback is invoked after the user selects a media item or closes the
            // photo picker.
            if (uri != null) {
                Log.d("PhotoPicker", "Selected URI: $uri")
                Profileimg = uri
                profileimage = uri.toString()
            } else {
                Log.d("PhotoPicker", "No media selected")
            }
        }

    val user = Firebase.auth.currentUser
    fun getUserName(): String{
        if (user != null) {
            return user.displayName!!
        } else {
            return "Anonimous"
        }
    }
    fun getUserImg(): Uri{
        if (user != null) {
            return Profileimg
        } else {
            return Uri.parse("android.resource://com.example.tableforyou/"+ R.drawable.defaultimg)
        }
    }

    fun getUserMail(): String{
        if (user != null) {
            return user.email!!
        }else{
            return ""
        }
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContent {
            TableforYouTheme {
               AuthApp(
                       signIn = {
                           SignIn(mail,password)
                           // My top posts by number of stars
                           /*
                           database.addValueEventListener(object : ValueEventListener {
                               override fun onDataChange(dataSnapshot: DataSnapshot) {
                                   for (userSnapshot in dataSnapshot.children) {
                                       Log.w("diob", "value get from the db ${userSnapshot}")
                                       //Log.w("diob", "value: ${userSnapshot.getValue<User>()}")
                                       //if(userSnapshot.getValue<User>()!!.mail == mail){
                                       if(userSnapshot.value.toString().contains(mail)){
                                           UTENTIDADB = userSnapshot.getValue<User>()!!
                                           //Log.w("diob", "UTENTE: $UTENTIDADB")

                                       }

                                   }
                               }

                               override fun onCancelled(databaseError: DatabaseError) {
                                   // Getting Post failed, log a message
                                   Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
                                   // ...
                               }
                           })*/
                           val storage = com.google.firebase.Firebase.storage("gs://tableforyou-f235e.appspot.com")
                           var storageRef = storage.reference

                           storageRef.child("${UTENTIDADB.name}Profile_img.jpg").downloadUrl.addOnSuccessListener {
                               // Got the download URL for 'users/me/profile.png'
                               Log.w("foto","foto downloaded: $it")
                               UTENTIDADB.profile_img=it.toString()
                           }.addOnFailureListener {
                               // Handle any errors
                               Log.w("foto","foto NOT downloaded: $it")

                           }

                                },
                       GsignIn = {
                           val intent = Intent(this, GoogleSignInActivity::class.java)
                           EmailPasswordActivity().baseContext.startActivity(intent)},
                   createAccount = {
                       this.CreateAccount(mail, password) ; password=""
                       MyData().writeUser(name, mail, profileimage, name)

                       val storage = com.google.firebase.Firebase.storage("gs://tableforyou-f235e.appspot.com")
                       val storageRef = storage.reference
                       val profileimgRef = storageRef.child("${name}Profile_img.jpg")

                       var imageView = ImageView(this)
                       imageView.setImageURI(Profileimg)
                       imageView.isDrawingCacheEnabled = true
                       imageView.buildDrawingCache()
                       val bitmap = (imageView.drawable as BitmapDrawable).bitmap
                       val baos = ByteArrayOutputStream()
                       bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
                       val data = baos.toByteArray()
                       var uploadTask = profileimgRef.putBytes(data)
                       uploadTask.addOnFailureListener {

                       }.addOnSuccessListener {

                       }




                                   },
                   SignOUT = { password=""; profileimage = defaultimg; signOut()},
                   pickPhoto={ pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageAndVideo)); }

                   )

            }
        }
        // Initialize Firebase Auth
        auth = Firebase.auth





    }




    public override fun onStart() {
        super.onStart()

        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            //reload()
        }


    }

    public fun CreateAccount(email: String, password: String) {
        if (email != "" && password != "") {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            baseContext,
                            "Account Succesfully Created",
                            Toast.LENGTH_SHORT,
                        ).show()
                        Thread.sleep(1500)
                        val intent = Intent(this, EmailPasswordActivity::class.java)
                        this.startActivity(intent)
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("test", "createUserWithEmail:success")
                        val user = auth.currentUser
                        //updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("test", "createUserWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext,
                            "Creation failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                        //updateUI(null)
                    }
                }
        }else{
            Toast.makeText(
                baseContext,
                "Please insert credentials",
                Toast.LENGTH_SHORT,
            ).show()
        }


    }

    public fun SignIn(email: String, password: String) {
        if (email != "" && password != "") {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    database = Firebase
                        .database("https://tableforyou-f235e-default-rtdb.europe-west1.firebasedatabase.app/")
                        .getReference("USERS")

                    database.addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            for (user in dataSnapshot.children) {
                                if(user.value.toString().contains(mail)){
                                    UTENTIDADB = user.getValue<User>()!!
                                    Log.w("prova", "user in data.children: $UTENTIDADB")

                                }
                            }
                        }


                        override fun onCancelled(databaseError: DatabaseError) {
                            // Getting Post failed, log a message
                            Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
                            // ...
                        }
                    })
                    /*
                    database = com.google.firebase.Firebase
                        .database("https://tableforyou-f235e-default-rtdb.europe-west1.firebasedatabase.app/")
                        .getReference("USERS")
                    database.get().addOnSuccessListener {


                            Log.i("prova", "user in it.children: ${it.getValue<User>()}")
                                //UTENTIDADB = it.getValue<User>()!!


                        Log.i("prova", "utente preso da mail $UTENTIDADB")
                    }.addOnFailureListener{
                        Log.e("prova", "Error getting data", it)
                    }*/


                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(
                        baseContext,
                        "Authentication Succeded, Welcome back",
                        Toast.LENGTH_SHORT,
                    ).show()
                    Log.d("test", "signInWithEmail:success")
                    val user = auth.currentUser

                    //go to main application
                    Thread.sleep(1500)
                    val intent = Intent(this, MainActivity::class.java)
                    this.startActivity(intent)
                    this.finish()

                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("test", "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                    //updateUI(null)
                }
            }
        }else{
            Toast.makeText(
                baseContext,
                "Please insert credentials",
                Toast.LENGTH_SHORT,
            ).show()
        }
    }

    private fun signOut() {
        auth.signOut()
    }

    public fun getCurrentUser() {
        val user = Firebase.auth.currentUser
        user?.let {
            // Name, email address, and profile photo Url
            val name = it.displayName
            val email = it.email
            val photoUrl = it.photoUrl

            // Check if user's email is verified
            val emailVerified = it.isEmailVerified

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.
            val uid = it.uid

        }

    }
}

@Composable
fun AuthApp(
    modifier: Modifier = Modifier,
    signIn: () -> Unit,
    GsignIn: () -> Unit,
    createAccount: () -> Unit,
    SignOUT: ()->Unit,
    pickPhoto:()->Unit
) {
    TableforYouTheme {
        //var currentScreen: AppDestination by remember { mutableStateOf(LogIn) }
        val navController = rememberNavController()

        val currentBackStack by navController.currentBackStackEntryAsState()
        //val currentDestination = currentBackStack?.destination

        /*
        LoginForm(
            signIn = signIn,
            GsignIn = GsignIn,
            goToCreateAccount = { newScreen ->
                navController.navigateSingleTopTo(newScreen.route)}
        )*/


        /*
        LoginForm(
            signIn = { EmailPasswordActivity().SignIn(mail,password) },
            GsignIn = {
                val intent = Intent(EmailPasswordActivity().baseContext, GoogleSignInActivity::class.java)
                EmailPasswordActivity().baseContext.startActivity(intent)},
            goToCreateAccount = { newScreen ->
                navController.navigateSingleTopTo(newScreen.route)}
        )*/

        AppNavHost2(
            navController = navController,
            modifier = Modifier.padding(all=10.dp),
            openCamera = {},
            signIn = signIn,
            GsignIn = GsignIn,
            createAccount = createAccount,
            SignOUT = SignOUT,
            pickPhoto=pickPhoto,
            addToFavorite = {},
            removeFromFavorite = {},
            confirmReservation = {
                                 table: Table, s: String ->  
            },
        )

    }
}




