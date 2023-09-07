package com.devx.jetjoke.ui.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devx.jetjoke.R
import com.devx.jetjoke.theme.JetJokeTheme
import com.devx.jetjoke.util.ThemedPreview

@Composable
fun HomeHeader(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(height = 250.dp)
            .background(color = MaterialTheme.colorScheme.primary),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.padding(top = 48.dp),
            fontSize = 28.sp,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(id = R.color.white),
        )
        Text(
            text = stringResource(id = R.string.app_tagline),
            fontSize = 15.sp,
            fontWeight = FontWeight.Light,
            color = colorResource(id = R.color.white),
        )
    }
}

@ThemedPreview
@Composable
private fun HomeHeaderPreview() {
    JetJokeTheme {
        Surface {
            HomeHeader()
        }
    }
}
