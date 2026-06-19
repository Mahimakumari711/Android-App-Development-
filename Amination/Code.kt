package com.example.animation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.*
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                PhonePurchaseAnimations()
            }
        }
    }
}

@Composable
fun PhonePurchaseAnimations() {

    // Theme Colors
    val Blue = Color(0xFF1565C0)
    val LightBlue = Color(0xFFE3F2FD)
    val Yellow = Color(0xFFFFC107)
    val LightYellow = Color(0xFFFFF8E1)

    var expanded by remember { mutableStateOf(false) }
    var wishlisted by remember { mutableStateOf(false) }
    var purchased by remember { mutableStateOf(false) }

    // Star Color Animation
    val starColor by animateColorAsState(
        targetValue = if (wishlisted) Yellow else Color.Gray,
        label = ""
    )

    // Buy Button Pulse Animation
    val infiniteTransition = rememberInfiniteTransition(label = "")

    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.08f,
        animationSpec = infiniteRepeatable(
            animation = tween(800),
            repeatMode = RepeatMode.Reverse
        ),
        label = ""
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightBlue)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {

        Crossfade(
            targetState = purchased,
            label = ""
        ) { isPurchased ->

            if (!isPurchased) {

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .animateContentSize(),
                    colors = CardDefaults.cardColors(
                        containerColor = LightYellow
                    ),
                    elevation = CardDefaults.cardElevation(12.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Text(
                                text = "📱 Samsung Galaxy S25",
                                style = MaterialTheme.typography.titleLarge,
                                color = Blue
                            )

                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "Wishlist",
                                tint = starColor,
                                modifier = Modifier
                                    .size(32.dp)
                                    .clickable {
                                        wishlisted = !wishlisted
                                    }
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "₹49,999",
                            style = MaterialTheme.typography.headlineSmall,
                            color = Color(0xFFFF8F00)
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Button(
                            onClick = {
                                expanded = !expanded
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Blue
                            )
                        ) {
                            Text(
                                if (expanded)
                                    "Hide Details"
                                else
                                    "Show Details"
                            )
                        }

                        AnimatedVisibility(expanded) {

                            Column {

                                Spacer(modifier = Modifier.height(16.dp))

                                Text("💾 Storage : 256 GB")
                                Text("📸 Camera : 50 MP")
                                Text("🔋 Battery : 5000 mAh")
                                Text("⚡ Fast Charging : 45W")
                                Text("📱 Display : AMOLED 120Hz")

                                Spacer(modifier = Modifier.height(20.dp))

                                Button(
                                    onClick = {
                                        purchased = true
                                    },
                                    modifier = Modifier.scale(scale),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Yellow,
                                        contentColor = Color.Black
                                    )
                                ) {
                                    Text("Buy Now")
                                }
                            }
                        }
                    }
                }

            } else {

                OrderPlacedScreen(
                    blue = Blue,
                    yellow = Yellow
                ) {
                    purchased = false
                    expanded = false
                    wishlisted = false
                }
            }
        }
    }
}

@Composable
fun OrderPlacedScreen(
    blue: Color,
    yellow: Color,
    onBack: () -> Unit
) {

    var showTick by remember {
        mutableStateOf(false)
    }

    // Launch Effect Animation
    LaunchedEffect(Unit) {
        showTick = true
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AnimatedVisibility(showTick) {

            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = null,
                tint = yellow,
                modifier = Modifier.size(140.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "🎉 Order Placed Successfully!",
            style = MaterialTheme.typography.headlineSmall,
            color = blue
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Your Samsung Galaxy S25 will be delivered soon.",
            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onBack,
            colors = ButtonDefaults.buttonColors(
                containerColor = blue
            )
        ) {
            Text("Back To Product")
        }
    }
}
