package com.example.calculadora_loca

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
@Preview
fun Calculadora_disenio(){
    var x  by remember { mutableStateOf(0.0)}
    var y by remember { mutableStateOf(0.0)}
    var resultado by remember { mutableStateOf(0.0)}
    var operacionSeleccionada by remember { mutableStateOf<(Double, Double) -> Double>({ a, b -> a }) }
    var operacionTexto by remember { mutableStateOf("") }
    var simboloOperacion by remember { mutableStateOf("") }
    var ctrlxy by remember { mutableStateOf(true) }
    var mostrarResultado by remember { mutableStateOf(false) }


    Box(Modifier
        .fillMaxSize()
        .background(Color(0xFF1e2d2b))) {

        Box(
            Modifier
                .fillMaxWidth()
                .padding(20.dp, 60.dp, 25.dp, 0.dp)
                .background(Color(0xFFa8ccc7), shape = RoundedCornerShape(10))
                .height(250.dp)
        )
        {
            val fuente_cal = FontFamily(Font(R.font.fuente_cal))
            Text(
                text = operacionTexto,
                modifier = Modifier.padding(15.dp, 15.dp, 0.dp, 0.dp), fontSize = 55.sp, fontFamily = fuente_cal
            )
        }

        Row(
            Modifier
                .padding(0.dp, 380.dp, 0.dp, 0.dp)
        ) {
            Column(Modifier.padding(20.dp, 0.dp, 0.dp, 0.dp)) {
                boton_cal_num("1", 2.0) {
                    cambiarvalor(
                        it,
                        ctrlxy,
                        { newX -> x = newX },
                        { newY -> y = newY },
                        { operacionTexto = "$it" },
                        { ctrlxy = !ctrlxy },
                        { mostrarResultado = false })
                }
                boton_cal_num("4", 3.0) {
                    cambiarvalor(
                        it,
                        ctrlxy,
                        { newX -> x = newX },
                        { newY -> y = newY },
                        { operacionTexto = "$it" },
                        { ctrlxy = !ctrlxy },
                        { mostrarResultado = false })
                }
                boton_cal_num("7", 8.0) {
                    cambiarvalor(
                        it,
                        ctrlxy,
                        { newX -> x = newX },
                        { newY -> y = newY },
                        { operacionTexto = "$it" },
                        { ctrlxy = !ctrlxy },
                        { mostrarResultado = false })
                }

            }
            Column(Modifier.padding(10.dp, 0.dp, 0.dp, 20.dp)) {
                boton_cal_num("2", 1.0) {
                    cambiarvalor(
                        it,
                        ctrlxy,
                        { newX -> x = newX },
                        { newY -> y = newY },
                        { operacionTexto = "$it" },
                        { ctrlxy = !ctrlxy },
                        { mostrarResultado = false })
                }
                boton_cal_num("0", 9.0) {
                    cambiarvalor(
                        it,
                        ctrlxy,
                        { newX -> x = newX },
                        { newY -> y = newY },
                        { operacionTexto = "$it" },
                        { ctrlxy = !ctrlxy },
                        { mostrarResultado = false })
                }
                boton_cal_num("8", 7.0) {
                    cambiarvalor(
                        it,
                        ctrlxy,
                        { newX -> x = newX },
                        { newY -> y = newY },
                        { operacionTexto = "$it" },
                        { ctrlxy = !ctrlxy },
                        { mostrarResultado = false })
                }
            }
            Column(Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp)) {
                boton_cal_num("3", 0.0) {
                    cambiarvalor(
                        it,
                        ctrlxy,
                        { newX -> x = newX },
                        { newY -> y = newY },
                        { operacionTexto = "$it" },
                        { ctrlxy = !ctrlxy },
                        { mostrarResultado = false })
                }
                boton_cal_num("6", 4.0) {
                    cambiarvalor(
                        it,
                        ctrlxy,
                        { newX -> x = newX },
                        { newY -> y = newY },
                        { operacionTexto = "$it" },
                        { ctrlxy = !ctrlxy },
                        { mostrarResultado = false })
                }
                boton_cal_num("9", 6.0) {
                    cambiarvalor(
                        it,
                        ctrlxy,
                        { newX -> x = newX },
                        { newY -> y = newY },
                        { operacionTexto = "$it" },
                        { ctrlxy = !ctrlxy },
                        { mostrarResultado = false })
                }
            }
            Column(Modifier.padding(23.dp, 0.dp, 0.dp, 0.dp)) {
                boton_cal_ope("&", { a, b -> a + b }) {
                    cambiaroperacion(
                        it,
                        { operacionSeleccionada = it },
                        { operacionTexto += " +" },
                        { simboloOperacion = "+"},
                        { ctrlxy = false },
                        { mostrarResultado = false })
                }
                boton_cal_ope("#", { a, b -> a - b }) {
                    cambiaroperacion(
                        it,
                        { operacionSeleccionada = it },
                        { operacionTexto += " -" },
                        {simboloOperacion = "-"},
                        { ctrlxy = false },
                        { mostrarResultado = false })
                }

                boton_cal_ope("~", { a, b -> a * b }) {
                    cambiaroperacion(
                        it,
                        { operacionSeleccionada = it },
                        { operacionTexto += " *" },
                        { simboloOperacion = "*"},
                        { ctrlxy = false },
                        { mostrarResultado = false })
                }
                boton_cal_ope("¬", { a, b -> if (b != 0.0) a / b else 0.0 }) {
                    cambiaroperacion(
                        it,
                        { operacionSeleccionada = it },
                        { operacionTexto += " /" },
                        { simboloOperacion = "/"},
                        { ctrlxy = false },
                        { mostrarResultado = false })
                }
            }
        }

        Button(onClick = {
            val valorAnteriorx= x
            resultado = operacionSeleccionada(x, y)
            val resultadoModificado= resultado.toString().replace('5','0')
            resultado= resultadoModificado.toDouble()
            operacionTexto = "$valorAnteriorx $simboloOperacion $y = $resultado"
            x = resultado
            ctrlxy = true
            mostrarResultado=true
                         },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF756a24)),
            contentPadding = PaddingValues(20.dp),

            modifier = Modifier
                .padding(23.dp,620.dp,22.dp,0.dp)
                .align(Alignment.Center)
                )

        {
            val fuente_cal = FontFamily(Font(R.font.fuente_cal))
            Text("(R)",fontSize = 58.sp, fontFamily = fuente_cal, fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(30.dp,0.dp,30.dp,0.dp))
        }
    }
}



fun cambiaroperacion(
    operacion: (Double, Double) -> Double,
    setOperacionSeleccionada: ((Double, Double) -> Double) -> Unit,
    setOperacionTexto: () -> Unit,
    setSimboloOperacion: () -> Unit,
    setCtrlY: () -> Unit,
    hideResultado: () -> Unit
) {
    setOperacionSeleccionada(operacion)
    setOperacionTexto()
    setSimboloOperacion()
    setCtrlY()
    hideResultado()
}


fun cambiarvalor( num: Double,
                  ctrlxy: Boolean,
                  setX: (Double) -> Unit,
                  setY: (Double) -> Unit,
                  setOperacionTexto: (Double) -> Unit,
                  toggleCtrl: () -> Unit,
                  hideResultado: () -> Unit) {
    if (ctrlxy) {
        setX(num)

    } else {
        setY(num)
    }
    setOperacionTexto(num)
    toggleCtrl()
    hideResultado()

}



@Composable
fun boton_cal_num(textoBoton: String, num: Double,numalclicar: (Double) -> Unit){

        OutlinedButton(
            onClick = {numalclicar(num)},
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF24756a)),
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier
            .padding(0.dp,0.dp,0.dp,10.dp)
            .size(85.dp)
    ) {
            val fuente_cal = FontFamily(Font(R.font.fuente_cal))
        Text(textoBoton, fontSize = 58.sp, fontFamily = fuente_cal)
    }

}

@Composable
fun boton_cal_ope(
    textoBoton : String,
    operar: (Double, Double) -> Double,
    opealclicar: ((Double,Double) -> Double) -> Unit
){

    OutlinedButton (
        onClick = {
            opealclicar(operar)
                  },
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6a2475)),
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier
            .padding(0.dp,0.dp,0.dp,8.dp)
            .size(62.dp)
    ) {
        val fuente_cal = FontFamily(Font(R.font.fuente_cal))
        Text(textoBoton,fontSize = 35.sp, fontFamily = fuente_cal)
    }

}


