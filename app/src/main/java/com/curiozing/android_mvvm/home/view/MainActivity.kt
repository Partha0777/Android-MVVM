package com.curiozing.android_mvvm.home.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.curiozing.android_mvvm.home.viewModel.HomeViewModel
import com.curiozing.android_mvvm.ui.theme.AndroidMVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidMVVMTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppContent()
                }
            }
        }
    }
}

@Composable
fun AppContent() {

    val homeViewModel: HomeViewModel = viewModel()
    Column(modifier = Modifier.fillMaxSize()) {
        val city = homeViewModel.imageData.observeAsState()

        Image(
            painter = rememberAsyncImagePainter(model = city.value?.image),
            contentScale = ContentScale.FillWidth,
            contentDescription = "",
            modifier = Modifier.fillMaxWidth()
        )
        city.value?.name?.let { Text(text = it) }


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
    AndroidMVVMTheme {
        AppContent()
    }
}