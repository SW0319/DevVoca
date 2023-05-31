package com.example.devvoca.data.repository

import com.example.devvoca.data.Entity.UserMemory
import com.example.devvoca.domain.model.Badge
import com.example.devvoca.domain.model.FavoriteVocaGroup

interface MyPageRepository {

    suspend fun getMyMemoryInfo() : UserMemory//내 기억 정보를 가져옴 (로그인 일수, 누적 학습 개수 및 평균 등)

    suspend fun getMyFavoriteGroupInfo() : List<FavoriteVocaGroup> //나의 즐겨찾기 정보를 가져옴

    suspend fun getMyBadgeInfo() : List<Badge> //나의 뱃지를 가져옴 (일종의 업적 기능)
}