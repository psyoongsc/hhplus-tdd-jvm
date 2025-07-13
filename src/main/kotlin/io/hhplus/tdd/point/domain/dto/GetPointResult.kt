package io.hhplus.tdd.point.domain.dto

import io.hhplus.tdd.point.domain.entity.UserPoint

data class GetPointResult(
    val id: Long,
    val point: Long
) {
    companion object {
        fun fromEntity(entity: UserPoint):  GetPointResult {
            val id = entity.id
            val point = entity.point

            return GetPointResult(id, point)
        }
    }
}
