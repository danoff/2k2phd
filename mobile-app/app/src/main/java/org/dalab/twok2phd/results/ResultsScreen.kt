package org.dalab.twok2phd.results

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ResultsScreen(
    viewModel: ResultsViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Results for \"${uiState.query}\"",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Trust-first OER matches with visible source, license, and why-this-now signals.",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        uiState.statusMessage?.let { message ->
            Text(
                text = message,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(uiState.recommendations, key = { it.resourceId }) { recommendation ->
                RecommendationCard(
                    recommendation = recommendation,
                    onOpen = { viewModel.onRecommendationOpened(recommendation.resourceId) },
                    onUseThis = { viewModel.onUseThis(recommendation.resourceId) },
                    onHelpful = { viewModel.onRate(recommendation.resourceId, helpful = true) },
                    onNotHelpful = { viewModel.onRate(recommendation.resourceId, helpful = false) },
                    onNeedBetterMatch = viewModel::onNeedBetterMatch
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun RecommendationCard(
    recommendation: RecommendationCardUiState,
    onOpen: () -> Unit,
    onUseThis: () -> Unit,
    onHelpful: () -> Unit,
    onNotHelpful: () -> Unit,
    onNeedBetterMatch: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onOpen),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = recommendation.resourceType,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "${recommendation.scorePercent}% match",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Text(
                text = recommendation.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                AssistChip(onClick = onOpen, label = { Text(recommendation.estimatedEffort) })
                AssistChip(onClick = onOpen, label = { Text(recommendation.license) })
                AssistChip(onClick = onOpen, label = { Text(recommendation.trustStatus) })
                AssistChip(
                    onClick = onOpen,
                    label = { Text(if (recommendation.remixEligible) "Remix eligible" else "Review license") }
                )
            }

            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    text = "Why this now",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold
                )
                recommendation.rationale.forEach { rationale ->
                    Text(
                        text = "• $rationale",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    text = "Source: ${recommendation.source}",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Provenance: ${recommendation.provenance}",
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Spacer(modifier = Modifier.height(2.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(onClick = onUseThis) {
                    Text("Use This")
                }
                OutlinedButton(onClick = onNeedBetterMatch) {
                    Text("Need Better Match")
                }
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                TextButton(onClick = onHelpful) {
                    Text("Helpful")
                }
                TextButton(onClick = onNotHelpful) {
                    Text("Not helpful")
                }
            }
        }
    }
}
