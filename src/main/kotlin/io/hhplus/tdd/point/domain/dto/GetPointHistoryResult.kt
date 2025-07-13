package io.hhplus.tdd.point.domain.dto

import io.hhplus.tdd.point.domain.entity.PointHistory

data class GetPointHistoryResult(
    val histories: List<PointHistory>,
) {
    companion object {
        fun fromEntityList(entityList: List<PointHistory>): GetPointHistoryResult {
            return GetPointHistoryResult(entityList)
        }
    }
}
