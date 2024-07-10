package ui

import Shipment
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ShipmentItem(shipment: Shipment) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(10.dp).background(color = Color(179, 174, 173))
    ) {
        Text("Tracking Shipment: ${shipment.id}", modifier = Modifier.padding(10.dp))
        Text("Status: Created", modifier = Modifier.padding(horizontal = 10.dp))
        Text("Location: Warehouse", modifier = Modifier.padding(horizontal = 10.dp))
        Text("Expected Delivery: 2021-10-10", modifier = Modifier.padding(horizontal = 10.dp))
        Spacer(modifier = Modifier.padding(10.dp))
        Text("Status Updates:", modifier = Modifier.padding(horizontal = 10.dp))
        Text("2021-10-10: Shipment created", modifier = Modifier.padding(horizontal = 10.dp))
        Spacer(modifier = Modifier.padding(10.dp))
        Text("Notes:", modifier = Modifier.padding(10.dp))
    }

}