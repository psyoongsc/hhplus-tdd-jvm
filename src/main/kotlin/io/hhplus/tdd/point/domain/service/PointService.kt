package io.hhplus.tdd.point.domain.service

import io.hhplus.tdd.common.enums.TransactionType
import io.hhplus.tdd.point.domain.dto.ChargePointCommand
import io.hhplus.tdd.point.domain.dto.ChargePointResult
import io.hhplus.tdd.point.domain.dto.GetPointCommand
import io.hhplus.tdd.point.domain.dto.GetPointHistoryCommand
import io.hhplus.tdd.point.domain.dto.GetPointHistoryResult
import io.hhplus.tdd.point.domain.dto.GetPointResult
import io.hhplus.tdd.point.domain.dto.UsePointCommand
import io.hhplus.tdd.point.domain.dto.UsePointResult
import io.hhplus.tdd.point.domain.entity.PointHistory
import io.hhplus.tdd.point.domain.entity.UserPoint
import io.hhplus.tdd.point.domain.repository.PointHistoryRepository
import io.hhplus.tdd.point.domain.repository.UserPointRepository
import org.springframework.stereotype.Service
import java.util.Date
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.locks.ReentrantLock

@Service
class PointService(
    private val userPointRepository: UserPointRepository,
    private val pointHistoryRepository: PointHistoryRepository
) {
    companion object {
        const val MAX_POINT: Long = 100000L
        const val MIN_POINT: Long = 0
    }
    fun getPoint(command: GetPointCommand): GetPointResult {
        val id = command.id

        val userPoint: UserPoint = userPointRepository.selectById(id)

        return GetPointResult.fromEntity(userPoint)
    }

    fun getPointHistory(command: GetPointHistoryCommand): GetPointHistoryResult {
        val id = command.id

        val histories: List<PointHistory> = pointHistoryRepository.selectAllByUserId(id)

        return GetPointHistoryResult.fromEntityList(histories)
    }
}