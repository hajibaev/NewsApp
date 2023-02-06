package com.example.data

object NewsTypes {
    fun getEnNewsTypes(): ArrayList<String> {
        val list = ArrayList<String>()
        list.add("Relevancy")
        list.add("PublishedAt")
        list.add("Popularity")
        return list
    }

    fun getRuNewsTypes(): ArrayList<String> {
        val list = ArrayList<String>()
        list.add("Популярные")
        list.add("На экранах")
        list.add("Рейтинговые")
        return list
    }

    fun getEnNewsTopheadLines(): ArrayList<String> {
        val list = ArrayList<String>()
        list.add("Business")
        list.add("Entertainment")
        list.add("General")
        list.add("Health")
        list.add("Sports")
        return list
    }

    fun getRuNewsTopheadLines(): ArrayList<String> {
        val list = ArrayList<String>()
        list.add("Business")
        list.add("Entertainment")
        list.add("General")
        list.add("Health")
        list.add("Sports")
        return list
    }
}