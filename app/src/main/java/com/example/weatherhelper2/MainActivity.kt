package com.example.weatherhelper2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.feature.FeatureActivity
import com.example.weatherhelper2.App.Companion.app
import com.example.weatherhelper2.ui.MapClass
import com.example.weatherhelper2.ui.MapClassA
import com.example.weatherhelper2.ui.MapClassB
import com.example.weatherhelper2.ui.theme.WeatherHelper2Theme
import javax.inject.Inject


class MainActivity : ComponentActivity() {

//    @Inject
//    lateinit var classB: ClassB

//    @Inject
//    lateinit var classA: ClassA

    @Inject
    lateinit var map: Map<Class<out MapClass>, @JvmSuppressWildcards MapClass>

    @Inject
    lateinit var map2: Map<Class<*>, @JvmSuppressWildcards MapClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app.component.inject(this)
//        app.featureComponent.inject(this)
        println("@@@@@@")
//        println(classB.toString())
//        println(classA.toString())

        println(map[MapClassA::class.java]?.toString())
        println(map[MapClassB::class.java]?.toString())
        println(map2[MapClassA::class.java]?.toString())
        println(map2[MapClassB::class.java]?.toString())





        setContent {
            WeatherHelper2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                    Button(
                        onClick = {
                        val intent = Intent(this, FeatureActivity::class.java)
                        startActivity(intent)
                    }) {
                        Text(text = "Жмякнуть к следующией")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherHelper2Theme {
        Greeting("Android")
    }
}