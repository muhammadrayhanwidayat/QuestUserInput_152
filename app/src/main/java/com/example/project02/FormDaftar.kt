package com.example.project02

import androidx.appcompat.app.AlertDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormDaftar(modifier: Modifier) {
    var showDialog by remember { mutableStateOf(false) }
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }
    var statusPk by remember { mutableStateOf("") }

    var textJK by remember { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textNama by remember { mutableStateOf("") }

    val gender: List<String> = listOf("Laki-laki", "Perempuan")
    val status: List<String> = listOf("Janda", "Lajang", "Duda")


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = dimensionResource(R.dimen.padding_medium))
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(65.dp)
                .background(Color(0xFF673AB7))
        ) {
            Text(
                "Formulir Pendaftaran",
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_small)
                    ),
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = dimensionResource(R.dimen.padding_small))
        ) {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(Modifier.padding(dimensionResource(R.dimen.padding_medium))) {
                    Text(text = "NAMA LENGKAP")
                    OutlinedTextField(
                        value = textNama,
                        onValueChange = {
                            textNama = it
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                top = dimensionResource(R.dimen.padding_small),
                                bottom = dimensionResource(R.dimen.padding_medium)
                            ),
                        placeholder = { Text("tulis nama lengkap") },
                        singleLine = true
                    )

                    Text(text = "JENIS KELAMIN")
                    Column {
                        gender.forEach { item ->
                            Row(
                                modifier = Modifier
                                    .selectable(
                                        selected = textJK == item,
                                        onClick = { textJK = item }
                                    ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = textJK == item,
                                    onClick = {
                                        textJK = item
                                    }
                                )
                                Text(item)
                            }
                        }
                    }


                    Text(text = "STATUS PERKAWINAN")
                    Column {
                        status.forEach { item ->
                            Row(
                                modifier = Modifier
                                    .selectable(
                                        selected = textStatus == item,
                                        onClick = { textStatus = item }
                                    ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = textStatus == item,
                                    onClick = {
                                        textStatus = item
                                    }
                                )
                                Text(item)
                            }
                        }
                    }

                    Text(text = "ALAMAT")
                    OutlinedTextField(
                        value = textAlamat,
                        onValueChange = {
                            textAlamat = it
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                top = dimensionResource(R.dimen.padding_small),
                                bottom = dimensionResource(R.dimen.padding_small)
                            ),
                        placeholder = { Text("Alamat") },
                        singleLine = true
                    )

                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            // Simpan data (opsional)
                            nama = textNama
                            jenis = textJK
                            statusPk = textStatus
                            alamat = textAlamat

                            // Tampilkan Alert
                            showDialog = true
                        }
                    ) {
                        Text(stringResource(R.string.submit))
                    }

// Tambahkan AlertDialog di bawah tombol
                    if (showDialog) {
                        AlertDialog(
                            onDismissRequest = { showDialog = false },
                            confirmButton = {
                                TextButton(onClick = { showDialog = false }) {
                                    Text("OK")
                                }
                            },
                            title = { Text("Data Terkirim") },
                            text = { Text("Terima kasih, data kamu sudah berhasil dikirim!") }
                        )
                    }
                }
            }


        }

    }


}



