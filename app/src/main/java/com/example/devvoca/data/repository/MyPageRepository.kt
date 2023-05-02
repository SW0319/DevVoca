package com.example.devvoca.data.repository

interface MyPageRepository {

    fun getMyMemoryInfo()//내 기억 정보를 가져옴 (로그인 일수, 누적 학습 개수 및 평균 등)

    fun getMyFavoriteGroupInfo() //나의 즐겨찾기 정보를 가져옴

    fun getMyBadgeInfo() //나의 뱃지를 가져옴 (일종의 업적 기능)
}