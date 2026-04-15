package ni.edu.uam.misrecargas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ni.edu.uam.misrecargas.ui.theme.MisRecargasTheme
import androidx.compose.material3.ExperimentalMaterial3Api

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

    var numeroTelefono by remember { mutableStateOf("") }
    var montoRecarga by remember { mutableStateOf("") }
    var compania by remember { mutableStateOf("Seleccionar compañía") }
    var mensaje by remember { mutableStateOf("") }
    var expandido by remember { mutableStateOf(false) }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text("Mis Recargas") }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {

            //FORMULARIO
            Card(
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {

                    Text(
                        "Registrar Recarga",
                        style = MaterialTheme.typography.titleLarge
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    //NÚMERO
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

                    //COMPAÑÍA
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

                    //BOTÓN
                    Button(
                        onClick = {
                            if (numeroTelefono.isNotBlank() && montoRecarga.isNotBlank()) {
                                mensaje = "Recarga registrada correctamente"
                            } else {
                                mensaje = "Complete todos los campos"
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Registrar Recarga")
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    //MENSAJE DINÁMICO
                    Text(
                        text = mensaje,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            //CARD DE RESULTADO (REQUISITO DE LA RÚBRICA)
            if (mensaje.contains("correctamente")) {

                Spacer(modifier = Modifier.height(16.dp))

                Card(
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {

                        Text(
                            "Última recarga",
                            style = MaterialTheme.typography.titleMedium
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text("Número: $numeroTelefono")
                        Text("Monto: $montoRecarga")
                        Text("Compañía: $compania")
                    }
                }
            }
        }
    }
}