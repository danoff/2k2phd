package org.dalab.twok2phd.results.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.dalab.twok2phd.domain.OerRecord
import org.dalab.twok2phd.domain.TrustStatus

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun RecommendationCard(
    record: OerRecord,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            // Title + type badges
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    text = record.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    SuggestionChip(
                        onClick = {},
                        label = { Text(record.resourceType, style = MaterialTheme.typography.labelSmall) },
                    )
                    SuggestionChip(
                        onClick = {},
                        label = { Text(record.estimatedEffort, style = MaterialTheme.typography.labelSmall) },
                    )
                    if (record.remixEligible) {
                        SuggestionChip(
                            onClick = {},
                            label = { Text("Remixable", style = MaterialTheme.typography.labelSmall) },
                        )
                    }
                }
            }

            HorizontalDivider()

            // Why this now
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    text = "Why this now",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                )
                FlowRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    record.rationale.take(3).forEach { reason ->
                        AssistChip(
                            onClick = {},
                            label = { Text(reason, style = MaterialTheme.typography.labelSmall) },
                        )
                    }
                }
            }

            HorizontalDivider()

            // Source + trust row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = record.source,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = record.license,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                    TrustBadge(record.trustStatus)
                }
            }
        }
    }
}

@Composable
private fun TrustBadge(status: TrustStatus) {
    val (label, color) = when (status) {
        TrustStatus.VERIFIED -> "Verified" to MaterialTheme.colorScheme.primary
        TrustStatus.COMMUNITY -> "Community" to MaterialTheme.colorScheme.secondary
        TrustStatus.UNREVIEWED -> "Unreviewed" to MaterialTheme.colorScheme.outline
    }
    AssistChip(
        onClick = {},
        label = { Text(label, style = MaterialTheme.typography.labelSmall) },
        colors = AssistChipDefaults.assistChipColors(labelColor = color),
    )
}
