package com.uvg.migaleria

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvg.migaleria.ui.theme.MiGaleriaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiGaleriaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InteractiveMenu()
                }
            }
        }
    }
}

fun Context.findActivity(): ComponentActivity? = when (this) {
    is ComponentActivity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}

@Composable
fun InteractiveMenu() {
    val mContext = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    )
    {
        Row (horizontalArrangement = Arrangement.Center)
        {
            Text(text = "Arte+",
                style = TextStyle(color = Color(17, 110, 35), fontSize = 45.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(35.dp))
        }

        Column(
            modifier = Modifier.padding(40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Text(
                text = stringResource(R.string.User),
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .align(alignment = Alignment.Start)
            )

            EditNumberField(modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth())

            Text(
                text = stringResource(R.string.Password),
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .align(alignment = Alignment.Start)
            )

            EditNumberField(modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth())

            Spacer(modifier = Modifier.height(150.dp))
        }

        Button(
            onClick = { mContext.startActivity(Intent(mContext, ArtGallery::class.java)) },
            colors = ButtonDefaults.buttonColors(containerColor = Color(35, 150, 14)),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(alignment = Alignment.Start)
        )
        {
            Text("Iniciar sesión", fontSize = 20.sp)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditNumberField(modifier: Modifier = Modifier) {
    TextField(
        value = "",
        onValueChange = {},
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun InteractiveMenuPreview() {
    MiGaleriaTheme {
        InteractiveMenu()
    }
}