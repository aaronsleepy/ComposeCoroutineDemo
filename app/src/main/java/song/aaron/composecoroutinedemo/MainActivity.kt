package song.aaron.composecoroutinedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import song.aaron.composecoroutinedemo.ui.theme.ComposeCoroutineDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCoroutineDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DemoView()
                }
            }
        }
    }
}

@Composable
fun DemoView() {
    val coroutineScope = rememberCoroutineScope()
    Column {
        Button(onClick = {
            coroutineScope.launch {
                performSlowTask()
            }
        }) {
            Text(text = "Click Me")
        }
    }
}

suspend fun performSlowTask() {
    println("performSlowTask before")

    delay(5000)

    println("performSlowTask after")
}

@Preview(showBackground = true)
@Composable
fun DemoPreview() {
    DemoView()
}