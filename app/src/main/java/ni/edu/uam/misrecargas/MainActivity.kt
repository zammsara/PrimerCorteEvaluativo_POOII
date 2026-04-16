package ni.edu.uam.misrecargas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.shape.RoundedCornerShape
import ni.edu.uam.misrecargas.ui.theme.MisRecargasTheme
import androidx.compose.material3.ExperimentalMaterial3Api

//MODELO
data class Recarga(
    val telefono: String,
    val monto: String,
    val compania: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MisRecargasTheme {
                PantallaPrincipal()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPrincipal() {

    //ESTADOS
    var numeroTelefono by remember { mutableStateOf("") }
    var montoRecarga by remember { mutableStateOf("") }
    var compania by remember { mutableStateOf("Seleccionar compañía") }
    var mensaje by remember { mutableStateOf("") }
    var expandido by remember { mutableStateOf(false) }

    var listaRecargas by remember { mutableStateOf(listOf<Recarga>()) }

    Scaffold(
        containerColor = Color(0xFFE8F5E9), // fondo verde claro
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Mis Recargas",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF2E7D32),
                    titleContentColor = Color.White
                )
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {

            //FORMULARIO
            Card(
                shape = RoundedCornerShape(24.dp),
                elevation = CardDefaults.cardElevation(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {

                    Text(
                        "Registrar Recarga",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color(0xFF2E7D32),
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // TELEFONO
                    OutlinedTextField(
                        value = numeroTelefono,
                        onValueChange = { numeroTelefono = it },
                        label = { Text("Número de teléfono") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    //MONTO
                    OutlinedTextField(
                        value = montoRecarga,
                        onValueChange = { montoRecarga = it },
                        label = { Text("Monto de recarga") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    //COMPAÑIA
                    val companias = listOf("Claro", "Tigo", "Movistar")

                    ExposedDropdownMenuBox(
                        expanded = expandido,
                        onExpandedChange = { expandido = !expandido }
                    ) {
                        OutlinedTextField(
                            value = compania,
                            onValueChange = {},
                            readOnly = true,
                            label = { Text("Compañía") },
                            trailingIcon = {
                                ExposedDropdownMenuDefaults.TrailingIcon(expandido)
                            },
                            modifier = Modifier
                                .menuAnchor()
                                .fillMaxWidth()
                        )

                        ExposedDropdownMenu(
                            expanded = expandido,
                            onDismissRequest = { expandido = false }
                        ) {
                            companias.forEach {
                                DropdownMenuItem(
                                    text = { Text(it) },
                                    onClick = {
                                        compania = it
                                        expandido = false
                                    }
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    //BOTON
                    Button(
                        onClick = {
                            if (numeroTelefono.isNotBlank() && montoRecarga.isNotBlank()) {

                                val nuevaRecarga = Recarga(
                                    telefono = numeroTelefono,
                                    monto = montoRecarga,
                                    compania = compania
                                )

                                listaRecargas = listaRecargas + nuevaRecarga

                                mensaje = "Recarga registrada correctamente"

                                // limpiar campos
                                numeroTelefono = ""
                                montoRecarga = ""
                                compania = "Seleccionar compañía"

                            } else {
                                mensaje = "Complete todos los campos"
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF2E7D32),
                            contentColor = Color.White
                        )
                    ) {
                        Text("Registrar Recarga")
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    //MENSAJE
                    Text(
                        text = mensaje,
                        color = Color(0xFF2E7D32),
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            //TITULO HISTORIAL
            Text(
                "Historial de recargas",
                style = MaterialTheme.typography.titleLarge,
                color = Color(0xFF2E7D32),
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            //LISTA
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(listaRecargas) { recarga ->

                    Card(
                        shape = RoundedCornerShape(20.dp),
                        elevation = CardDefaults.cardElevation(6.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFA5D6A7)
                        )
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {

                            Text(
                                "${recarga.telefono}",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text("Monto: ${recarga.monto}")
                            Text("${recarga.compania}")
                        }
                    }
                }
            }
        }
    }
}