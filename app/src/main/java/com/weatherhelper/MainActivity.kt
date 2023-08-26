package com.weatherhelper

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
import com.google.gson.Gson
import com.watherhelper.WeatherRepository
import com.weatherhelper.ui.theme.WeatherHelper2Theme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var source: WeatherRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
                            runBlocking {
                                println("@@@@@@")
                                val response = try {
                                    val weather = source.getWeather(44.82184912850624, 20.450216536447115)
                                    val wr = Gson().toJson(weather)
                                    println("@@@@@@1 $wr")
                                } catch (e: Throwable) {
                                    e.printStackTrace()
                                    e
                                }
                                println("response.errorBody()")
//                                println(response.message())
//                                println(response.body())
                            }
//                        val intent = Intent(this, FeatureActivity::class.java)
//                        startActivity(intent)
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