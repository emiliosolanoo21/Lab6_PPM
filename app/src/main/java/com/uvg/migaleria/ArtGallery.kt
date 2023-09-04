package com.uvg.migaleria

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvg.migaleria.ui.theme.MiGaleriaTheme

class ArtGallery: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSharedPreferences("ArtSpacePrefs", Context.MODE_PRIVATE)
        setContent {
            MiGaleriaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Exhibition()
                }
            }
        }
    }
}

@Composable
fun Exhibition() {
    val obra1 = R.drawable.obra1
    val obra2 = R.drawable.obra2
    val obra3 = R.drawable.obra3
    val obra4 = R.drawable.obra4
    val obra5 = R.drawable.obra5
    val obra6 = R.drawable.obra6
    val obra7 = R.drawable.obra7
    val obra8 = R.drawable.obra8
    val obra9 = R.drawable.obra9
    val obra10 = R.drawable.obra10

    val context = LocalContext.current

    var title by remember { mutableIntStateOf(R.string.nombre_obra1) }
    var published by remember { mutableIntStateOf(R.string.anio_obra1) }
    var author by remember { mutableIntStateOf(R.string.autor_obra1) }
    var currentArtwork by remember { mutableIntStateOf(obra1) }

    Column {
        Box (modifier = Modifier.fillMaxSize()){
            Image(
                painter = painterResource(id = R.drawable.artbackground),
                contentDescription = "app background",
                contentScale = ContentScale.FillBounds,
                alpha = 0.5F,
                modifier = Modifier.matchParentSize()
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier.fillMaxSize()
            ) {

                Row (modifier = Modifier.weight(1.0F)){
                    ArtDisplay(currentArtwork = currentArtwork)
                }

                Spacer(modifier = Modifier.size(16.dp))

                ArtInformation(title = title, year = published, author = author )

                Spacer(modifier = Modifier.size(25.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = {
                            val sharedPreferences = context.getSharedPreferences("ArtSpacePrefs", Context.MODE_PRIVATE)
                            with(sharedPreferences.edit()) {
                                putBoolean("isLoggedIn", false)
                                apply()
                            }
                            val intent = Intent(context, MainActivity::class.java)
                            context.startActivity(intent)
                            (context as Activity).finish()
                        },
                        colors = with(ButtonDefaults) {
                            buttonColors(
                                Color.DarkGray
                            )
                        },
                        elevation = ButtonDefaults.elevatedButtonElevation(
                            defaultElevation = 2.dp,
                            pressedElevation = 0.dp,
                            focusedElevation = 1.dp
                        ),
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Text(
                            text = "Salir",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.LightGray
                        )
                    }

                    Button(
                        onClick = {
                            when (currentArtwork) {
                                obra1 -> {
                                    currentArtwork = obra10
                                    title = R.string.nombre_obra10
                                    published = R.string.anio_obra10
                                    author = R.string.autor_obra10
                                }
                                obra2 -> {
                                    currentArtwork = obra1
                                    title = R.string.nombre_obra1
                                    published = R.string.anio_obra1
                                    author = R.string.autor_obra1
                                }
                                obra3 -> {
                                    currentArtwork = obra2
                                    title = R.string.nombre_obra2
                                    published = R.string.anio_obra2
                                    author = R.string.autor_obra2
                                }
                                obra4 -> {
                                    currentArtwork = obra3
                                    title = R.string.nombre_obra3
                                    published = R.string.anio_obra3
                                    author = R.string.autor_obra3
                                }
                                obra5 -> {
                                    currentArtwork = obra4
                                    title = R.string.nombre_obra4
                                    published = R.string.anio_obra4
                                    author = R.string.autor_obra4
                                }
                                obra6 -> {
                                    currentArtwork = obra5
                                    title = R.string.nombre_obra5
                                    published = R.string.anio_obra5
                                    author = R.string.autor_obra5
                                }
                                obra7 -> {
                                    currentArtwork = obra6
                                    title = R.string.nombre_obra6
                                    published = R.string.anio_obra6
                                    author = R.string.autor_obra6
                                }
                                obra8 -> {
                                    currentArtwork = obra7
                                    title = R.string.nombre_obra7
                                    published = R.string.anio_obra7
                                    author = R.string.autor_obra7
                                }
                                obra9 -> {
                                    currentArtwork = obra8
                                    title = R.string.nombre_obra8
                                    published = R.string.anio_obra8
                                    author = R.string.autor_obra8
                                }
                                obra10 -> {
                                    currentArtwork = obra9
                                    title = R.string.nombre_obra9
                                    published = R.string.anio_obra9
                                    author = R.string.autor_obra9
                                }
                            }
                        },
                        colors = with(ButtonDefaults) {
                            buttonColors(
                                Color.Blue
                            )
                        },
                        elevation = ButtonDefaults.elevatedButtonElevation(
                            defaultElevation = 2.dp,
                            pressedElevation = 0.dp,
                            focusedElevation = 1.dp
                        ),
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Text(
                            text = "Anterior",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.LightGray
                        )
                    }

                    Button(
                        onClick = {
                            when (currentArtwork) {
                                obra1 -> {
                                    currentArtwork = obra2
                                    title = R.string.nombre_obra2
                                    published = R.string.anio_obra2
                                    author = R.string.autor_obra2
                                }
                                obra2 -> {
                                    currentArtwork = obra3
                                    title = R.string.nombre_obra3
                                    published = R.string.anio_obra3
                                    author = R.string.autor_obra3
                                }
                                obra3 -> {
                                    currentArtwork = obra4
                                    title = R.string.nombre_obra4
                                    published = R.string.anio_obra4
                                    author = R.string.autor_obra4
                                }
                                obra4 -> {
                                    currentArtwork = obra5
                                    title = R.string.nombre_obra5
                                    published = R.string.anio_obra5
                                    author = R.string.autor_obra5
                                }
                                obra5 -> {
                                    currentArtwork = obra6
                                    title = R.string.nombre_obra6
                                    published = R.string.anio_obra6
                                    author = R.string.autor_obra6
                                }
                                obra6 -> {
                                    currentArtwork = obra7
                                    title = R.string.nombre_obra7
                                    published = R.string.anio_obra7
                                    author = R.string.autor_obra7
                                }
                                obra7 -> {
                                    currentArtwork = obra8
                                    title = R.string.nombre_obra8
                                    published = R.string.anio_obra8
                                    author = R.string.autor_obra8
                                }
                                obra8 -> {
                                    currentArtwork = obra9
                                    title = R.string.nombre_obra9
                                    published = R.string.anio_obra9
                                    author = R.string.autor_obra9
                                }
                                obra9 -> {
                                    currentArtwork = obra10
                                    title = R.string.nombre_obra10
                                    published = R.string.anio_obra10
                                    author = R.string.autor_obra10
                                }
                                obra10 -> {
                                    currentArtwork = obra1
                                    title = R.string.nombre_obra1
                                    published = R.string.anio_obra1
                                    author = R.string.autor_obra1
                                }
                            }
                        },
                        colors = with(ButtonDefaults) {
                            buttonColors(
                                Color.Green
                            )
                        },
                        elevation = ButtonDefaults.elevatedButtonElevation(
                            defaultElevation = 2.dp,
                            pressedElevation = 0.dp,
                            focusedElevation = 1.dp
                        ),
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Text(
                            text = "Siguiente",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.LightGray
                        )
                    }
                }
            }
        }
    }


}

@Composable
fun ArtDisplay(
    @DrawableRes currentArtwork: Int
) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .clip(shape = RoundedCornerShape(size = 10.dp))
            .background(color = Color.Gray)
            .border(width = 10.dp, color = Color.Black)
            .fillMaxHeight()
    ){
        Image(
            painter = painterResource(currentArtwork),
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight(),
            contentScale = ContentScale.FillHeight,

            )
    }
}

@Composable
fun ArtInformation(
    @StringRes title: Int,
    @StringRes year: Int,
    @StringRes author: Int
) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(modifier = Modifier
            .padding(10.dp)
            .clip(shape = RoundedCornerShape(size = 10.dp))
        ){
            Column (
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ){
                // Artwork title
                Text(
                    text = stringResource(id = title),
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(30, 30, 30),
                    fontSize = 35.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(10.dp),
                    lineHeight = 40.sp
                )

                // Artwork date
                Text(
                    text = "Fecha de publicación: ${stringResource(id = year)}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    modifier = Modifier.padding(10.dp)
                )

                // Artwork artist
                Text(
                    text = "Autor: ${stringResource(id = author)}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExhibitionPreview() {
    MiGaleriaTheme {
        Exhibition()
    }
}